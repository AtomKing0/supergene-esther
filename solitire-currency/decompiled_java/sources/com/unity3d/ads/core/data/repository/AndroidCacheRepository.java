package com.unity3d.ads.core.data.repository;

import android.content.Context;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.model.CacheError;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CacheSource;
import com.unity3d.ads.core.data.model.CachedFile;
import com.unity3d.ads.core.extensions.FileExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import h9.p;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AndroidCacheRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidCacheRepository implements CacheRepository {

    @NotNull
    private final File cacheDir;

    @NotNull
    private final ConcurrentHashMap<String, CachedFile> cachedFiles;

    @NotNull
    private final Context context;

    @NotNull
    private final k0 ioDispatcher;

    @NotNull
    private final CacheDataSource localCacheDataSource;

    @NotNull
    private final ConcurrentHashMap<String, Set<String>> neededFiles;

    @NotNull
    private final CacheDataSource remoteCacheDataSource;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2", f = "AndroidCacheRepository.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super v8.k0>, Object> {
        int label;

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidCacheRepository.this.new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            File[] fileArrListFiles = AndroidCacheRepository.this.cacheDir.listFiles();
            if (fileArrListFiles == null) {
                return null;
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2", f = "AndroidCacheRepository.kt", l = {}, m = "invokeSuspend")
    static final class C31702 extends l implements p<o0, d<? super Long>, Object> {
        int label;

        C31702(d<? super C31702> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidCacheRepository.this.new C31702(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return b.e(FileExtensionsKt.getDirectorySize(AndroidCacheRepository.this.cacheDir));
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super Long> dVar) {
            return ((C31702) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCacheRepository.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2", f = "AndroidCacheRepository.kt", l = {49, 56, 132}, m = "invokeSuspend")
    static final class C31712 extends l implements p<o0, d<? super CacheResult>, Object> {
        final /* synthetic */ String $objectId;
        final /* synthetic */ int $priority;
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidCacheRepository.kt */
        @f(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$1", f = "AndroidCacheRepository.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, d<? super Boolean>, Object> {
            final /* synthetic */ File $newFile;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(File file, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$newFile = file;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(this.$newFile, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                return b.a(this.$newFile.createNewFile());
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super Boolean> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31712(String str, int i10, String str2, d<? super C31712> dVar) {
            super(2, dVar);
            this.$url = str;
            this.$priority = i10;
            this.$objectId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidCacheRepository.this.new C31712(this.$url, this.$priority, this.$objectId, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00cc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 251
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.C31712.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super CacheResult> dVar) {
            return ((C31712) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public AndroidCacheRepository(@NotNull k0 ioDispatcher, @NotNull CacheDataSource localCacheDataSource, @NotNull CacheDataSource remoteCacheDataSource, @NotNull Context context) {
        t.i(ioDispatcher, "ioDispatcher");
        t.i(localCacheDataSource, "localCacheDataSource");
        t.i(remoteCacheDataSource, "remoteCacheDataSource");
        t.i(context, "context");
        this.ioDispatcher = ioDispatcher;
        this.localCacheDataSource = localCacheDataSource;
        this.remoteCacheDataSource = remoteCacheDataSource;
        this.context = context;
        this.cachedFiles = new ConcurrentHashMap<>();
        this.neededFiles = new ConcurrentHashMap<>();
        this.cacheDir = initCacheDir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(CachedFile cachedFile) {
        this.cachedFiles.put(cachedFile.getName(), cachedFile);
        Set<String> linkedHashSet = this.neededFiles.get(cachedFile.getName());
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
        }
        linkedHashSet.add(cachedFile.getObjectId());
        this.neededFiles.put(cachedFile.getName(), linkedHashSet);
    }

    private final void deleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private final File getCacheDirBase() {
        File cacheDir = this.context.getCacheDir();
        t.h(cacheDir, "context.cacheDir");
        return cacheDir;
    }

    private final String getCacheDirPath() {
        return UnityAdsConstants.DefaultUrls.CACHE_DIR_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFilePath(String str) {
        return this.cacheDir.getAbsolutePath() + File.separator + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getHash(String str) {
        byte[] bytes = str.getBytes(p9.d.f32952b);
        t.h(bytes, "this as java.lang.String).getBytes(charset)");
        String strK = ua.f.u(Arrays.copyOf(bytes, bytes.length)).A().k();
        t.h(strK, "bytes.sha256().hex()");
        return strK;
    }

    private final File initCacheDir() {
        File file = new File(getCacheDirBase(), getCacheDirPath());
        file.mkdirs();
        return file;
    }

    private final void removeFileFromCache(CachedFile cachedFile) {
        this.cachedFiles.remove(cachedFile.getName());
        Set<String> set = this.neededFiles.get(cachedFile.getName());
        if (set != null) {
            set.remove(cachedFile.getObjectId());
        }
        deleteFile(cachedFile.getFile());
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    @Nullable
    public Object clearCache(@NotNull d<? super v8.k0> dVar) {
        return i.g(this.ioDispatcher, new AnonymousClass2(null), dVar);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    @Nullable
    public Object doesFileExist(@NotNull String str, @NotNull d<? super Boolean> dVar) {
        return b.a(this.cachedFiles.containsKey(str));
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    @Nullable
    public Object getCacheSize(@NotNull d<? super Long> dVar) {
        return i.g(this.ioDispatcher, new C31702(null), dVar);
    }

    @NotNull
    public final ConcurrentHashMap<String, CachedFile> getCachedFiles() {
        return this.cachedFiles;
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    @Nullable
    public Object getFile(@NotNull String str, @NotNull String str2, @Nullable JSONArray jSONArray, int i10, @NotNull d<? super CacheResult> dVar) {
        return i.g(this.ioDispatcher, new C31712(str, i10, str2, null), dVar);
    }

    @NotNull
    public final String getFilename(@NotNull String url) {
        t.i(url, "url");
        return getHash(url);
    }

    @NotNull
    public final ConcurrentHashMap<String, Set<String>> getNeededFiles() {
        return this.neededFiles;
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public void removeFile(@NotNull CachedFile cachedFile) {
        t.i(cachedFile, "cachedFile");
        removeFileFromCache(cachedFile);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    @NotNull
    public CacheResult retrieveFile(@NotNull String fileName) {
        t.i(fileName, "fileName");
        CachedFile cachedFile = this.cachedFiles.get(fileName);
        return cachedFile != null ? new CacheResult.Success(cachedFile, CacheSource.LOCAL) : new CacheResult.Failure(CacheError.FILE_NOT_FOUND, CacheSource.LOCAL);
    }
}
