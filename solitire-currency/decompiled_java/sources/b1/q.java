package b1;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import b1.m;
import com.bumptech.glide.load.ImageHeaderParser;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: Downsampler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r0.g<r0.b> f1860f = r0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", r0.b.f33240c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r0.g<r0.i> f1861g = r0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", r0.i.SRGB);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final r0.g<m> f1862h = m.f1855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final r0.g<Boolean> f1863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final r0.g<Boolean> f1864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Set<String> f1865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b f1866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f1867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f1868n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0.d f1869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f1870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v0.b f1871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f1872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v f1873e = v.a();

    /* JADX INFO: compiled from: Downsampler.java */
    public interface b {
        void a(v0.d dVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f1863i = r0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f1864j = r0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f1865k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f1866l = new a();
        f1867m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f1868n = o1.k.e(0);
    }

    public q(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, v0.d dVar, v0.b bVar) {
        this.f1872d = list;
        this.f1870b = (DisplayMetrics) o1.j.d(displayMetrics);
        this.f1869a = (v0.d) o1.j.d(dVar);
        this.f1871c = (v0.b) o1.j.d(bVar);
    }

    private static int a(double d10) {
        int iJ = j(d10);
        int iU = u(((double) iJ) * d10);
        return u((d10 / ((double) (iU / iJ))) * ((double) iU));
    }

    private void b(InputStream inputStream, r0.b bVar, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        boolean zHasAlpha;
        if (this.f1873e.e(i10, i11, options, z10, z11)) {
            return;
        }
        if (bVar == r0.b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = com.bumptech.glide.load.a.b(this.f1872d, inputStream, this.f1871c).hasAlpha();
        } catch (IOException e10) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e10);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, b bVar, v0.d dVar, m mVar, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) throws IOException {
        int i15;
        int i16;
        int i17;
        int iFloor;
        double dFloor;
        int iRound;
        if (i11 <= 0 || i12 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i13 + ViewHierarchyNode.JsonKeys.X + i14 + v8.i.f15839e);
                return;
            }
            return;
        }
        if (o(i10)) {
            i16 = i11;
            i15 = i12;
        } else {
            i15 = i11;
            i16 = i12;
        }
        float fB = mVar.b(i15, i16, i13, i14);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + mVar + ", source: [" + i11 + ViewHierarchyNode.JsonKeys.X + i12 + "], target: [" + i13 + ViewHierarchyNode.JsonKeys.X + i14 + v8.i.f15839e);
        }
        m.g gVarA = mVar.a(i15, i16, i13, i14);
        if (gVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f10 = i15;
        float f11 = i16;
        int iU = i15 / u(fB * f10);
        int iU2 = i16 / u(fB * f11);
        m.g gVar = m.g.MEMORY;
        int iMax = gVarA == gVar ? Math.max(iU, iU2) : Math.min(iU, iU2);
        int i18 = Build.VERSION.SDK_INT;
        if (i18 > 23 || !f1865k.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(iMax));
            if (gVarA == gVar && iMax2 < 1.0f / fB) {
                iMax2 <<= 1;
            }
            i17 = iMax2;
        } else {
            i17 = 1;
        }
        options.inSampleSize = i17;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i17, 8);
            iFloor = (int) Math.ceil(f10 / fMin);
            iRound = (int) Math.ceil(f11 / fMin);
            int i19 = i17 / 8;
            if (i19 > 0) {
                iFloor /= i19;
                iRound /= i19;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f12 = i17;
                iFloor = (int) Math.floor(f10 / f12);
                dFloor = Math.floor(f11 / f12);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (i18 >= 24) {
                    float f13 = i17;
                    iFloor = Math.round(f10 / f13);
                    iRound = Math.round(f11 / f13);
                } else {
                    float f14 = i17;
                    iFloor = (int) Math.floor(f10 / f14);
                    dFloor = Math.floor(f11 / f14);
                }
            } else if (i15 % i17 == 0 && i16 % i17 == 0) {
                iFloor = i15 / i17;
                iRound = i16 / i17;
            } else {
                int[] iArrK = k(inputStream, options, bVar, dVar);
                iFloor = iArrK[0];
                iRound = iArrK[1];
            }
            iRound = (int) dFloor;
        }
        double dB = mVar.b(iFloor, iRound, i13, i14);
        options.inTargetDensity = a(dB);
        options.inDensity = j(dB);
        if (p(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i11 + ViewHierarchyNode.JsonKeys.X + i12 + "], degreesToRotate: " + i10 + ", target: [" + i13 + ViewHierarchyNode.JsonKeys.X + i14 + "], power of two scaled: [" + iFloor + ViewHierarchyNode.JsonKeys.X + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + i17 + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, m mVar, r0.b bVar, r0.i iVar, boolean z10, int i10, int i11, boolean z11, b bVar2) throws IOException {
        int i12;
        int i13;
        String str;
        int i14;
        int iRound;
        int iRound2;
        long jB = o1.f.b();
        int[] iArrK = k(inputStream, options, bVar2, this.f1869a);
        boolean z12 = false;
        int i15 = iArrK[0];
        int i16 = iArrK[1];
        String str2 = options.outMimeType;
        boolean z13 = (i15 == -1 || i16 == -1) ? false : z10;
        int iA = com.bumptech.glide.load.a.a(this.f1872d, inputStream, this.f1871c);
        int iG = b0.g(iA);
        boolean zJ = b0.j(iA);
        if (i10 == Integer.MIN_VALUE) {
            i12 = i11;
            i13 = o(iG) ? i16 : i15;
        } else {
            i12 = i11;
            i13 = i10;
        }
        int i17 = i12 == Integer.MIN_VALUE ? o(iG) ? i15 : i16 : i12;
        ImageHeaderParser.ImageType imageTypeB = com.bumptech.glide.load.a.b(this.f1872d, inputStream, this.f1871c);
        c(imageTypeB, inputStream, bVar2, this.f1869a, mVar, iG, i15, i16, i13, i17, options);
        b(inputStream, bVar, z13, zJ, options, i13, i17);
        int i18 = Build.VERSION.SDK_INT;
        int i19 = options.inSampleSize;
        if (w(imageTypeB)) {
            if (i15 < 0 || i16 < 0 || !z11) {
                float f10 = p(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i20 = options.inSampleSize;
                float f11 = i20;
                int iCeil = (int) Math.ceil(i15 / f11);
                int iCeil2 = (int) Math.ceil(i16 / f11);
                iRound = Math.round(iCeil * f10);
                iRound2 = Math.round(iCeil2 * f10);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + iRound + ViewHierarchyNode.JsonKeys.X + iRound2 + "] for source [" + i15 + ViewHierarchyNode.JsonKeys.X + i16 + "], sampleSize: " + i20 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f10);
                }
            } else {
                str = "Downsampler";
                iRound = i13;
                iRound2 = i17;
            }
            if (iRound > 0 && iRound2 > 0) {
                v(options, this.f1869a, iRound, iRound2);
            }
        } else {
            str = "Downsampler";
        }
        if (i18 >= 28) {
            if (iVar == r0.i.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) {
                z12 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z12 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i18 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmapG = g(inputStream, options, bVar2, this.f1869a);
        bVar2.a(this.f1869a, bitmapG);
        if (Log.isLoggable(str, 2)) {
            i14 = iA;
            q(i15, i16, str2, options, bitmapG, i10, i11, jB);
        } else {
            i14 = iA;
        }
        if (bitmapG == null) {
            return null;
        }
        bitmapG.setDensity(this.f1870b.densityDpi);
        Bitmap bitmapK = b0.k(this.f1869a, bitmapG, i14);
        if (bitmapG.equals(bitmapK)) {
            return bitmapK;
        }
        this.f1869a.c(bitmapG);
        return bitmapK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap g(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, b1.q.b r8, v0.d r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto Lc
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto Lf
        Lc:
            r8.b()
        Lf:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = b1.b0.f()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.Throwable -> L30 java.lang.IllegalArgumentException -> L32
            java.util.concurrent.locks.Lock r9 = b1.b0.f()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L2f
            r6.reset()
        L2f:
            return r8
        L30:
            r6 = move-exception
            goto L5f
        L32:
            r5 = move-exception
            java.io.IOException r1 = r(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L30
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L43
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L30
        L43:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L5e
            r6.reset()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r9.c(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r7.inBitmap = r4     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r6 = g(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            java.util.concurrent.locks.Lock r7 = b1.b0.f()
            r7.unlock()
            return r6
        L5d:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5e:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5f:
            java.util.concurrent.locks.Lock r7 = b1.b0.f()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.q.g(java.io.InputStream, android.graphics.BitmapFactory$Options, b1.q$b, v0.d):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    private static String h(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return v8.i.f15837d + bitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f1868n;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            t(optionsPoll);
        }
        return optionsPoll;
    }

    private static int j(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, v0.d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean o(int i10) {
        return i10 == 90 || i10 == 270;
    }

    private static boolean p(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        return i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10;
    }

    private static void q(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i10 + ViewHierarchyNode.JsonKeys.X + i11 + "] " + str + " with inBitmap " + l(options) + " for [" + i12 + ViewHierarchyNode.JsonKeys.X + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + o1.f.a(j10));
    }

    private static IOException r(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void s(BitmapFactory.Options options) {
        t(options);
        Queue<BitmapFactory.Options> queue = f1868n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void t(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int u(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    private static void v(BitmapFactory.Options options, v0.d dVar, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.e(i10, i11, config);
    }

    private boolean w(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public u0.v<Bitmap> d(InputStream inputStream, int i10, int i11, r0.h hVar) throws IOException {
        return e(inputStream, i10, i11, hVar, f1866l);
    }

    public u0.v<Bitmap> e(InputStream inputStream, int i10, int i11, r0.h hVar, b bVar) throws IOException {
        o1.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f1871c.c(65536, byte[].class);
        BitmapFactory.Options optionsI = i();
        optionsI.inTempStorage = bArr;
        r0.b bVar2 = (r0.b) hVar.c(f1860f);
        r0.i iVar = (r0.i) hVar.c(f1861g);
        m mVar = (m) hVar.c(m.f1855h);
        boolean zBooleanValue = ((Boolean) hVar.c(f1863i)).booleanValue();
        r0.g<Boolean> gVar = f1864j;
        try {
            return e.c(f(inputStream, optionsI, mVar, bVar2, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i10, i11, zBooleanValue, bVar), this.f1869a);
        } finally {
            s(optionsI);
            this.f1871c.put(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }

    /* JADX INFO: compiled from: Downsampler.java */
    class a implements b {
        a() {
        }

        @Override // b1.q.b
        public void b() {
        }

        @Override // b1.q.b
        public void a(v0.d dVar, Bitmap bitmap) {
        }
    }
}
