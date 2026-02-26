package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.PlaceholderDataSource;
import androidx.media3.datasource.PriorityDataSource;
import androidx.media3.datasource.TeeDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSink;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class CacheDataSource implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = -1;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 102400;

    @Nullable
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource cacheReadDataSource;

    @Nullable
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;

    @Nullable
    private DataSource currentDataSource;
    private long currentDataSourceBytesRead;

    @Nullable
    private DataSpec currentDataSpec;

    @Nullable
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;

    @Nullable
    private final EventListener eventListener;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private long readPosition;

    @Nullable
    private DataSpec requestDataSpec;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i10);

        void onCachedBytesRead(long j10, long j11);
    }

    public static final class Factory implements DataSource.Factory {
        private Cache cache;
        private boolean cacheIsReadOnly;

        @Nullable
        private DataSink.Factory cacheWriteDataSinkFactory;

        @Nullable
        private EventListener eventListener;
        private int flags;

        @Nullable
        private DataSource.Factory upstreamDataSourceFactory;
        private int upstreamPriority;

        @Nullable
        private PriorityTaskManager upstreamPriorityTaskManager;
        private DataSource.Factory cacheReadDataSourceFactory = new FileDataSource.Factory();
        private CacheKeyFactory cacheKeyFactory = CacheKeyFactory.DEFAULT;

        private CacheDataSource createDataSourceInternal(@Nullable DataSource dataSource, int i10, int i11) {
            DataSink dataSinkCreateDataSink;
            Cache cache = (Cache) Assertions.checkNotNull(this.cache);
            if (this.cacheIsReadOnly || dataSource == null) {
                dataSinkCreateDataSink = null;
            } else {
                DataSink.Factory factory = this.cacheWriteDataSinkFactory;
                dataSinkCreateDataSink = factory != null ? factory.createDataSink() : new CacheDataSink.Factory().setCache(cache).createDataSink();
            }
            return new CacheDataSource(cache, dataSource, this.cacheReadDataSourceFactory.createDataSource(), dataSinkCreateDataSink, this.cacheKeyFactory, i10, this.upstreamPriorityTaskManager, i11, this.eventListener);
        }

        public CacheDataSource createDataSourceForDownloading() {
            DataSource.Factory factory = this.upstreamDataSourceFactory;
            return createDataSourceInternal(factory != null ? factory.createDataSource() : null, this.flags | 1, -1000);
        }

        public CacheDataSource createDataSourceForRemovingDownload() {
            return createDataSourceInternal(null, this.flags | 1, -1000);
        }

        @Nullable
        public Cache getCache() {
            return this.cache;
        }

        public CacheKeyFactory getCacheKeyFactory() {
            return this.cacheKeyFactory;
        }

        @Nullable
        public PriorityTaskManager getUpstreamPriorityTaskManager() {
            return this.upstreamPriorityTaskManager;
        }

        public Factory setCache(Cache cache) {
            this.cache = cache;
            return this;
        }

        public Factory setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.cacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Factory setCacheReadDataSourceFactory(DataSource.Factory factory) {
            this.cacheReadDataSourceFactory = factory;
            return this;
        }

        public Factory setCacheWriteDataSinkFactory(@Nullable DataSink.Factory factory) {
            this.cacheWriteDataSinkFactory = factory;
            this.cacheIsReadOnly = factory == null;
            return this;
        }

        public Factory setEventListener(@Nullable EventListener eventListener) {
            this.eventListener = eventListener;
            return this;
        }

        public Factory setFlags(int i10) {
            this.flags = i10;
            return this;
        }

        public Factory setUpstreamDataSourceFactory(@Nullable DataSource.Factory factory) {
            this.upstreamDataSourceFactory = factory;
            return this;
        }

        public Factory setUpstreamPriority(int i10) {
            this.upstreamPriority = i10;
            return this;
        }

        public Factory setUpstreamPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            this.upstreamPriorityTaskManager = priorityTaskManager;
            return this;
        }

        @Override // androidx.media3.datasource.DataSource.Factory
        public CacheDataSource createDataSource() {
            DataSource.Factory factory = this.upstreamDataSourceFactory;
            return createDataSourceInternal(factory != null ? factory.createDataSource() : null, this.flags, this.upstreamPriority);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.currentDataSpec = null;
            this.currentDataSource = null;
            CacheSpan cacheSpan = this.currentHoleSpan;
            if (cacheSpan != null) {
                this.cache.releaseHoleSpan(cacheSpan);
                this.currentHoleSpan = null;
            }
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache, String str, Uri uri) {
        Uri uriB = c.b(cache.getContentMetadata(str));
        return uriB != null ? uriB : uri;
    }

    private void handleBeforeThrow(Throwable th) {
        if (isReadingFromCache() || (th instanceof Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private boolean isBypassingCache() {
        return this.currentDataSource == this.upstreamDataSource;
    }

    private boolean isReadingFromCache() {
        return this.currentDataSource == this.cacheReadDataSource;
    }

    private boolean isReadingFromUpstream() {
        return !isReadingFromCache();
    }

    private boolean isWritingToCache() {
        return this.currentDataSource == this.cacheWriteDataSource;
    }

    private void notifyBytesRead() {
        EventListener eventListener = this.eventListener;
        if (eventListener == null || this.totalCachedBytesRead <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
        this.totalCachedBytesRead = 0L;
    }

    private void notifyCacheIgnored(int i10) {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onCacheIgnored(i10);
        }
    }

    private void openNextSource(DataSpec dataSpec, boolean z10) throws IOException {
        CacheSpan cacheSpanStartReadWrite;
        long jMin;
        DataSpec dataSpecBuild;
        DataSource dataSource;
        String str = (String) Util.castNonNull(dataSpec.key);
        if (this.currentRequestIgnoresCache) {
            cacheSpanStartReadWrite = null;
        } else if (this.blockOnCache) {
            try {
                cacheSpanStartReadWrite = this.cache.startReadWrite(str, this.readPosition, this.bytesRemaining);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpanStartReadWrite = this.cache.startReadWriteNonBlocking(str, this.readPosition, this.bytesRemaining);
        }
        if (cacheSpanStartReadWrite == null) {
            dataSource = this.upstreamDataSource;
            dataSpecBuild = dataSpec.buildUpon().setPosition(this.readPosition).setLength(this.bytesRemaining).build();
        } else if (cacheSpanStartReadWrite.isCached) {
            Uri uriFromFile = Uri.fromFile((File) Util.castNonNull(cacheSpanStartReadWrite.file));
            long j10 = cacheSpanStartReadWrite.position;
            long j11 = this.readPosition - j10;
            long jMin2 = cacheSpanStartReadWrite.length - j11;
            long j12 = this.bytesRemaining;
            if (j12 != -1) {
                jMin2 = Math.min(jMin2, j12);
            }
            dataSpecBuild = dataSpec.buildUpon().setUri(uriFromFile).setUriPositionOffset(j10).setPosition(j11).setLength(jMin2).build();
            dataSource = this.cacheReadDataSource;
        } else {
            if (cacheSpanStartReadWrite.isOpenEnded()) {
                jMin = this.bytesRemaining;
            } else {
                jMin = cacheSpanStartReadWrite.length;
                long j13 = this.bytesRemaining;
                if (j13 != -1) {
                    jMin = Math.min(jMin, j13);
                }
            }
            dataSpecBuild = dataSpec.buildUpon().setPosition(this.readPosition).setLength(jMin).build();
            dataSource = this.cacheWriteDataSource;
            if (dataSource == null) {
                dataSource = this.upstreamDataSource;
                this.cache.releaseHoleSpan(cacheSpanStartReadWrite);
                cacheSpanStartReadWrite = null;
            }
        }
        this.checkCachePosition = (this.currentRequestIgnoresCache || dataSource != this.upstreamDataSource) ? Long.MAX_VALUE : this.readPosition + MIN_READ_BEFORE_CHECKING_CACHE;
        if (z10) {
            Assertions.checkState(isBypassingCache());
            if (dataSource == this.upstreamDataSource) {
                return;
            }
            try {
                closeCurrentSource();
            } finally {
            }
        }
        if (cacheSpanStartReadWrite != null && cacheSpanStartReadWrite.isHoleSpan()) {
            this.currentHoleSpan = cacheSpanStartReadWrite;
        }
        this.currentDataSource = dataSource;
        this.currentDataSpec = dataSpecBuild;
        this.currentDataSourceBytesRead = 0L;
        long jOpen = dataSource.open(dataSpecBuild);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpecBuild.length == -1 && jOpen != -1) {
            this.bytesRemaining = jOpen;
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.readPosition + jOpen);
        }
        if (isReadingFromUpstream()) {
            Uri uri = dataSource.getUri();
            this.actualUri = uri;
            ContentMetadataMutations.setRedirectedUri(contentMetadataMutations, dataSpec.uri.equals(uri) ^ true ? this.actualUri : null);
        }
        if (isWritingToCache()) {
            this.cache.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    private void setNoBytesRemainingAndMaybeStoreLength(String str) throws IOException {
        this.bytesRemaining = 0L;
        if (isWritingToCache()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.readPosition);
            this.cache.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec) {
        if (this.ignoreCacheOnError && this.seenCacheError) {
            return 0;
        }
        return (this.ignoreCacheForUnsetLengthRequests && dataSpec.length == -1) ? 1 : -1;
    }

    @Override // androidx.media3.datasource.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.cacheReadDataSource.addTransferListener(transferListener);
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() throws IOException {
        this.requestDataSpec = null;
        this.actualUri = null;
        this.readPosition = 0L;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (Throwable th) {
            handleBeforeThrow(th);
            throw th;
        }
    }

    public Cache getCache() {
        return this.cache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    @Override // androidx.media3.datasource.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return isReadingFromUpstream() ? this.upstreamDataSource.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // androidx.media3.datasource.DataSource
    @Nullable
    public Uri getUri() {
        return this.actualUri;
    }

    @Override // androidx.media3.datasource.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        try {
            String strBuildCacheKey = this.cacheKeyFactory.buildCacheKey(dataSpec);
            DataSpec dataSpecBuild = dataSpec.buildUpon().setKey(strBuildCacheKey).build();
            this.requestDataSpec = dataSpecBuild;
            this.actualUri = getRedirectedUriOrDefault(this.cache, strBuildCacheKey, dataSpecBuild.uri);
            this.readPosition = dataSpec.position;
            int iShouldIgnoreCacheForRequest = shouldIgnoreCacheForRequest(dataSpec);
            boolean z10 = iShouldIgnoreCacheForRequest != -1;
            this.currentRequestIgnoresCache = z10;
            if (z10) {
                notifyCacheIgnored(iShouldIgnoreCacheForRequest);
            }
            if (this.currentRequestIgnoresCache) {
                this.bytesRemaining = -1L;
            } else {
                long jA = c.a(this.cache.getContentMetadata(strBuildCacheKey));
                this.bytesRemaining = jA;
                if (jA != -1) {
                    long j10 = jA - dataSpec.position;
                    this.bytesRemaining = j10;
                    if (j10 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = dataSpec.length;
            if (jMin != -1) {
                long j11 = this.bytesRemaining;
                if (j11 != -1) {
                    jMin = Math.min(j11, jMin);
                }
                this.bytesRemaining = jMin;
            }
            long j12 = this.bytesRemaining;
            if (j12 > 0 || j12 == -1) {
                openNextSource(dataSpecBuild, false);
            }
            long j13 = dataSpec.length;
            return j13 != -1 ? j13 : this.bytesRemaining;
        } catch (Throwable th) {
            handleBeforeThrow(th);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:9:0x0021, B:11:0x0029, B:12:0x002d, B:14:0x0041, B:16:0x0047, B:17:0x004d, B:19:0x005e, B:20:0x0062, B:22:0x0068, B:24:0x006e, B:26:0x0074, B:27:0x0080, B:33:0x008e), top: B:38:0x0021 }] */
    @Override // androidx.media3.common.DataReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(byte[] r16, int r17, int r18) throws java.io.IOException {
        /*
            r15 = this;
            r1 = r15
            r0 = r18
            r2 = 0
            if (r0 != 0) goto L7
            return r2
        L7:
            long r3 = r1.bytesRemaining
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r4 = -1
            if (r3 != 0) goto L11
            return r4
        L11:
            androidx.media3.datasource.DataSpec r3 = r1.requestDataSpec
            java.lang.Object r3 = androidx.media3.common.util.Assertions.checkNotNull(r3)
            androidx.media3.datasource.DataSpec r3 = (androidx.media3.datasource.DataSpec) r3
            androidx.media3.datasource.DataSpec r7 = r1.currentDataSpec
            java.lang.Object r7 = androidx.media3.common.util.Assertions.checkNotNull(r7)
            androidx.media3.datasource.DataSpec r7 = (androidx.media3.datasource.DataSpec) r7
            long r8 = r1.readPosition     // Catch: java.lang.Throwable -> L99
            long r10 = r1.checkCachePosition     // Catch: java.lang.Throwable -> L99
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 < 0) goto L2d
            r8 = 1
            r15.openNextSource(r3, r8)     // Catch: java.lang.Throwable -> L99
        L2d:
            androidx.media3.datasource.DataSource r8 = r1.currentDataSource     // Catch: java.lang.Throwable -> L99
            java.lang.Object r8 = androidx.media3.common.util.Assertions.checkNotNull(r8)     // Catch: java.lang.Throwable -> L99
            androidx.media3.datasource.DataSource r8 = (androidx.media3.datasource.DataSource) r8     // Catch: java.lang.Throwable -> L99
            r9 = r16
            r10 = r17
            int r8 = r8.read(r9, r10, r0)     // Catch: java.lang.Throwable -> L99
            r11 = -1
            if (r8 == r4) goto L62
            boolean r0 = r15.isReadingFromCache()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L4d
            long r2 = r1.totalCachedBytesRead     // Catch: java.lang.Throwable -> L99
            long r4 = (long) r8     // Catch: java.lang.Throwable -> L99
            long r2 = r2 + r4
            r1.totalCachedBytesRead = r2     // Catch: java.lang.Throwable -> L99
        L4d:
            long r2 = r1.readPosition     // Catch: java.lang.Throwable -> L99
            long r4 = (long) r8     // Catch: java.lang.Throwable -> L99
            long r2 = r2 + r4
            r1.readPosition = r2     // Catch: java.lang.Throwable -> L99
            long r2 = r1.currentDataSourceBytesRead     // Catch: java.lang.Throwable -> L99
            long r2 = r2 + r4
            r1.currentDataSourceBytesRead = r2     // Catch: java.lang.Throwable -> L99
            long r2 = r1.bytesRemaining     // Catch: java.lang.Throwable -> L99
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L8d
            long r2 = r2 - r4
            r1.bytesRemaining = r2     // Catch: java.lang.Throwable -> L99
            goto L8d
        L62:
            boolean r4 = r15.isReadingFromUpstream()     // Catch: java.lang.Throwable -> L99
            if (r4 == 0) goto L80
            long r13 = r7.length     // Catch: java.lang.Throwable -> L99
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 == 0) goto L74
            long r11 = r1.currentDataSourceBytesRead     // Catch: java.lang.Throwable -> L99
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 >= 0) goto L80
        L74:
            java.lang.String r0 = r3.key     // Catch: java.lang.Throwable -> L99
            java.lang.Object r0 = androidx.media3.common.util.Util.castNonNull(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L99
            r15.setNoBytesRemainingAndMaybeStoreLength(r0)     // Catch: java.lang.Throwable -> L99
            goto L8d
        L80:
            long r11 = r1.bytesRemaining     // Catch: java.lang.Throwable -> L99
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 > 0) goto L8e
            r4 = -1
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 != 0) goto L8d
            goto L8e
        L8d:
            return r8
        L8e:
            r15.closeCurrentSource()     // Catch: java.lang.Throwable -> L99
            r15.openNextSource(r3, r2)     // Catch: java.lang.Throwable -> L99
            int r0 = r15.read(r16, r17, r18)     // Catch: java.lang.Throwable -> L99
            return r0
        L99:
            r0 = move-exception
            r15.handleBeforeThrow(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.CacheDataSource.read(byte[], int, int):int");
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, int i10) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, 5242880L), i10, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i10, @Nullable EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i10, eventListener, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i10, @Nullable EventListener eventListener, @Nullable CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i10, null, 0, eventListener);
    }

    private CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, @Nullable CacheKeyFactory cacheKeyFactory, int i10, @Nullable PriorityTaskManager priorityTaskManager, int i11, @Nullable EventListener eventListener) {
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        this.cacheKeyFactory = cacheKeyFactory == null ? CacheKeyFactory.DEFAULT : cacheKeyFactory;
        this.blockOnCache = (i10 & 1) != 0;
        this.ignoreCacheOnError = (i10 & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i10 & 4) != 0;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i11) : dataSource;
            this.upstreamDataSource = dataSource;
            this.cacheWriteDataSource = dataSink != null ? new TeeDataSource(dataSource, dataSink) : null;
        } else {
            this.upstreamDataSource = PlaceholderDataSource.INSTANCE;
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }
}
