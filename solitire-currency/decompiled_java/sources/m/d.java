package m;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.media3.common.MimeTypes;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import m.i;
import m.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.k0;
import ua.z0;

/* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f31081e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p f31082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final v.n f31083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final y9.d f31084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final l f31085d;

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    private static final class b extends ua.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Exception f31086a;

        public b(@NotNull z0 z0Var) {
            super(z0Var);
        }

        @Nullable
        public final Exception a() {
            return this.f31086a;
        }

        @Override // ua.m, ua.z0
        public long read(@NotNull ua.c cVar, long j10) throws Exception {
            try {
                return super.read(cVar, j10);
            } catch (Exception e10) {
                this.f31086a = e10;
                throw e10;
            }
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    public static final class c implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final l f31087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final y9.d f31088b;

        public c(int i10, @NotNull l lVar) {
            this.f31087a = lVar;
            this.f31088b = y9.f.b(i10, 0, 2, null);
        }

        @Override // m.i.a
        @NotNull
        public i a(@NotNull p.m mVar, @NotNull v.n nVar, @NotNull j.e eVar) {
            return new d(mVar.b(), nVar, this.f31088b, this.f31087a);
        }

        public boolean equals(@Nullable Object obj) {
            return obj instanceof c;
        }

        public int hashCode() {
            return c.class.hashCode();
        }
    }

    /* JADX INFO: renamed from: m.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", l = {232, 46}, m = "decode")
    static final class C0624d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f31089j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f31090k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f31091l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f31093n;

        C0624d(z8.d<? super C0624d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f31091l = obj;
            this.f31093n |= Integer.MIN_VALUE;
            return d.this.a(this);
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    static final class e extends v implements h9.a<g> {
        e() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            return d.this.e(new BitmapFactory.Options());
        }
    }

    public d(@NotNull p pVar, @NotNull v.n nVar, @NotNull y9.d dVar, @NotNull l lVar) {
        this.f31082a = pVar;
        this.f31083b = nVar;
        this.f31084c = dVar;
        this.f31085d = lVar;
    }

    private final void c(BitmapFactory.Options options, j jVar) {
        Bitmap.Config configF = this.f31083b.f();
        if (jVar.b() || n.a(jVar)) {
            configF = a0.a.e(configF);
        }
        if (this.f31083b.d() && configF == Bitmap.Config.ARGB_8888 && t.d(options.outMimeType, MimeTypes.IMAGE_JPEG)) {
            configF = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && configF != Bitmap.Config.HARDWARE) {
            configF = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = configF;
    }

    private final void d(BitmapFactory.Options options, j jVar) {
        p.a aVarA = this.f31082a.a();
        if ((aVarA instanceof r) && w.b.a(this.f31083b.n())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((r) aVarA).a();
            options.inTargetDensity = this.f31083b.g().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i10 = n.b(jVar) ? options.outHeight : options.outWidth;
        int i11 = n.b(jVar) ? options.outWidth : options.outHeight;
        w.i iVarN = this.f31083b.n();
        int iZ = w.b.a(iVarN) ? i10 : a0.j.z(iVarN.b(), this.f31083b.m());
        w.i iVarN2 = this.f31083b.n();
        int iZ2 = w.b.a(iVarN2) ? i11 : a0.j.z(iVarN2.a(), this.f31083b.m());
        int iA = h.a(i10, i11, iZ, iZ2, this.f31083b.m());
        options.inSampleSize = iA;
        double dB = h.b(((double) i10) / ((double) iA), ((double) i11) / ((double) iA), iZ, iZ2, this.f31083b.m());
        if (this.f31083b.c()) {
            dB = n9.o.h(dB, 1.0d);
        }
        boolean z10 = !(dB == 1.0d);
        options.inScaled = z10;
        if (z10) {
            if (dB > 1.0d) {
                options.inDensity = j9.c.b(((double) Integer.MAX_VALUE) / dB);
                options.inTargetDensity = Integer.MAX_VALUE;
            } else {
                options.inDensity = Integer.MAX_VALUE;
                options.inTargetDensity = j9.c.b(((double) Integer.MAX_VALUE) * dB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g e(BitmapFactory.Options options) throws Exception {
        b bVar = new b(this.f31082a.c());
        ua.e eVarD = k0.d(bVar);
        boolean z10 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(eVarD.peek().F0(), null, options);
        Exception excA = bVar.a();
        if (excA != null) {
            throw excA;
        }
        options.inJustDecodeBounds = false;
        m mVar = m.f31115a;
        j jVarA = mVar.a(options.outMimeType, eVarD, this.f31085d);
        Exception excA2 = bVar.a();
        if (excA2 != null) {
            throw excA2;
        }
        options.inMutable = false;
        if (Build.VERSION.SDK_INT >= 26 && this.f31083b.e() != null) {
            options.inPreferredColorSpace = this.f31083b.e();
        }
        options.inPremultiplied = this.f31083b.l();
        c(options, jVarA);
        d(options, jVarA);
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(eVarD.F0(), null, options);
            f9.c.a(eVarD, null);
            Exception excA3 = bVar.a();
            if (excA3 != null) {
                throw excA3;
            }
            if (bitmapDecodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
            }
            bitmapDecodeStream.setDensity(this.f31083b.g().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f31083b.g().getResources(), mVar.b(bitmapDecodeStream, jVarA));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z10 = false;
            }
            return new g(bitmapDrawable, z10);
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // m.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull z8.d<? super m.g> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof m.d.C0624d
            if (r0 == 0) goto L13
            r0 = r8
            m.d$d r0 = (m.d.C0624d) r0
            int r1 = r0.f31093n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f31093n = r1
            goto L18
        L13:
            m.d$d r0 = new m.d$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f31091l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f31093n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.f31089j
            y9.d r0 = (y9.d) r0
            v8.u.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L70
        L30:
            r8 = move-exception
            goto L7a
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3a:
            java.lang.Object r2 = r0.f31090k
            y9.d r2 = (y9.d) r2
            java.lang.Object r5 = r0.f31089j
            m.d r5 = (m.d) r5
            v8.u.b(r8)
            r8 = r2
            goto L5a
        L47:
            v8.u.b(r8)
            y9.d r8 = r7.f31084c
            r0.f31089j = r7
            r0.f31090k = r8
            r0.f31093n = r4
            java.lang.Object r2 = r8.a(r0)
            if (r2 != r1) goto L59
            return r1
        L59:
            r5 = r7
        L5a:
            m.d$e r2 = new m.d$e     // Catch: java.lang.Throwable -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L76
            r0.f31089j = r8     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r0.f31090k = r5     // Catch: java.lang.Throwable -> L76
            r0.f31093n = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r0 = kotlinx.coroutines.x1.c(r5, r2, r0, r4, r5)     // Catch: java.lang.Throwable -> L76
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r6 = r0
            r0 = r8
            r8 = r6
        L70:
            m.g r8 = (m.g) r8     // Catch: java.lang.Throwable -> L30
            r0.release()
            return r8
        L76:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L7a:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.a(z8.d):java.lang.Object");
    }
}
