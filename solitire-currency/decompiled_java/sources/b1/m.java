package b1;

/* JADX INFO: compiled from: DownsampleStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f1848a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f1849b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f1850c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f1851d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f1852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f1853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f1854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r0.g<m> f1855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f1856i;

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class a extends m {
        a() {
        }

        @Override // b1.m
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // b1.m
        public float b(int i10, int i11, int i12, int i13) {
            if (Math.min(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class b extends m {
        b() {
        }

        @Override // b1.m
        public g a(int i10, int i11, int i12, int i13) {
            return g.MEMORY;
        }

        @Override // b1.m
        public float b(int i10, int i11, int i12, int i13) {
            int iCeil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class c extends m {
        c() {
        }

        @Override // b1.m
        public g a(int i10, int i11, int i12, int i13) {
            return b(i10, i11, i12, i13) == 1.0f ? g.QUALITY : m.f1850c.a(i10, i11, i12, i13);
        }

        @Override // b1.m
        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, m.f1850c.b(i10, i11, i12, i13));
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class d extends m {
        d() {
        }

        @Override // b1.m
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // b1.m
        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class e extends m {
        e() {
        }

        @Override // b1.m
        public g a(int i10, int i11, int i12, int i13) {
            return m.f1856i ? g.QUALITY : g.MEMORY;
        }

        @Override // b1.m
        public float b(int i10, int i11, int i12, int i13) {
            if (m.f1856i) {
                return Math.min(i12 / i10, i13 / i11);
            }
            if (Math.max(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class f extends m {
        f() {
        }

        @Override // b1.m
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // b1.m
        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f1852e = dVar;
        f1853f = new f();
        f1854g = dVar;
        f1855h = r0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f1856i = true;
    }

    public abstract g a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);
}
