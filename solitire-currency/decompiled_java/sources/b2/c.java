package b2;

/* JADX INFO: compiled from: LogEventDropped.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f1908c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f1910b;

    /* JADX INFO: compiled from: LogEventDropped.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1911a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f1912b = b.REASON_UNKNOWN;

        a() {
        }

        public c a() {
            return new c(this.f1911a, this.f1912b);
        }

        public a b(long j10) {
            this.f1911a = j10;
            return this;
        }

        public a c(b bVar) {
            this.f1912b = bVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: LogEventDropped.java */
    public enum b implements s5.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1921a;

        b(int i10) {
            this.f1921a = i10;
        }

        @Override // s5.c
        public int getNumber() {
            return this.f1921a;
        }
    }

    c(long j10, b bVar) {
        this.f1909a = j10;
        this.f1910b = bVar;
    }

    public static a c() {
        return new a();
    }

    @s5.d(tag = 1)
    public long a() {
        return this.f1909a;
    }

    @s5.d(tag = 3)
    public b b() {
        return this.f1910b;
    }
}
