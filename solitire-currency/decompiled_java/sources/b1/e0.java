package b1;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import r0.g;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0<T> implements r0.j<T, Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r0.g<Long> f1831d = r0.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r0.g<Integer> f1832e = r0.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f1833f = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<T> f1834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.d f1835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f1836c;

    /* JADX INFO: compiled from: VideoDecoder.java */
    class a implements g.b<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f1837a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // r0.g.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull byte[] bArr, @NonNull Long l10, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f1837a) {
                this.f1837a.position(0);
                messageDigest.update(this.f1837a.putLong(l10.longValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    class b implements g.b<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f1838a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // r0.g.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f1838a) {
                this.f1838a.position(0);
                messageDigest.update(this.f1838a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    private static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // b1.e0.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @VisibleForTesting
    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @VisibleForTesting
    interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t10);
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class f implements e<ParcelFileDescriptor> {
        f() {
        }

        @Override // b1.e0.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    e0(v0.d dVar, e<T> eVar) {
        this(dVar, eVar, f1833f);
    }

    public static r0.j<AssetFileDescriptor, Bitmap> c(v0.d dVar) {
        return new e0(dVar, new c(null));
    }

    @Nullable
    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, m mVar) {
        Bitmap bitmapF = (Build.VERSION.SDK_INT < 27 || i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE || mVar == m.f1853f) ? null : f(mediaMetadataRetriever, j10, i10, i11, i12, mVar);
        return bitmapF == null ? e(mediaMetadataRetriever, j10, i10) : bitmapF;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10) {
        return mediaMetadataRetriever.getFrameAtTime(j10, i10);
    }

    @TargetApi(27)
    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, m mVar) {
        try {
            int i13 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i14 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i15 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i15 == 90 || i15 == 270) {
                i14 = i13;
                i13 = i14;
            }
            float fB = mVar.b(i13, i14, i11, i12);
            return mediaMetadataRetriever.getScaledFrameAtTime(j10, i10, Math.round(i13 * fB), Math.round(fB * i14));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static r0.j<ParcelFileDescriptor, Bitmap> g(v0.d dVar) {
        return new e0(dVar, new f());
    }

    @Override // r0.j
    public boolean a(@NonNull T t10, @NonNull r0.h hVar) {
        return true;
    }

    @Override // r0.j
    public u0.v<Bitmap> b(@NonNull T t10, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        long jLongValue = ((Long) hVar.c(f1831d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) hVar.c(f1832e);
        if (num == null) {
            num = 2;
        }
        m mVar = (m) hVar.c(m.f1855h);
        if (mVar == null) {
            mVar = m.f1854g;
        }
        m mVar2 = mVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f1836c.a();
        try {
            try {
                this.f1834a.a(mediaMetadataRetrieverA, t10);
                Bitmap bitmapD = d(mediaMetadataRetrieverA, jLongValue, num.intValue(), i10, i11, mVar2);
                mediaMetadataRetrieverA.release();
                return b1.e.c(bitmapD, this.f1835b);
            } catch (RuntimeException e10) {
                throw new IOException(e10);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    @VisibleForTesting
    e0(v0.d dVar, e<T> eVar, d dVar2) {
        this.f1835b = dVar;
        this.f1834a = eVar;
        this.f1836c = dVar2;
    }
}
