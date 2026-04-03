package b2;

/* JADX INFO: compiled from: StorageMetrics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final e f1927c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f1929b;

    /* JADX INFO: compiled from: StorageMetrics.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1930a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1931b = 0;

        a() {
        }

        public e a() {
            return new e(this.f1930a, this.f1931b);
        }

        public a b(long j10) {
            this.f1930a = j10;
            return this;
        }

        public a c(long j10) {
            this.f1931b = j10;
            return this;
        }
    }

    e(long j10, long j11) {
        this.f1928a = j10;
        this.f1929b = j11;
    }

    public static a c() {
        return new a();
    }

    @s5.d(tag = 1)
    public long a() {
        return this.f1928a;
    }

    @s5.d(tag = 2)
    public long b() {
        return this.f1929b;
    }
}
