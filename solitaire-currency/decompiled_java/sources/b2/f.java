package b2;

/* JADX INFO: compiled from: TimeWindow.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f1932c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f1934b;

    /* JADX INFO: compiled from: TimeWindow.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1935a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1936b = 0;

        a() {
        }

        public f a() {
            return new f(this.f1935a, this.f1936b);
        }

        public a b(long j10) {
            this.f1936b = j10;
            return this;
        }

        public a c(long j10) {
            this.f1935a = j10;
            return this;
        }
    }

    f(long j10, long j11) {
        this.f1933a = j10;
        this.f1934b = j11;
    }

    public static a c() {
        return new a();
    }

    @s5.d(tag = 2)
    public long a() {
        return this.f1934b;
    }

    @s5.d(tag = 1)
    public long b() {
        return this.f1933a;
    }
}
