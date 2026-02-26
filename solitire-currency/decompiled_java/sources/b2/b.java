package b2;

/* JADX INFO: compiled from: GlobalMetrics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f1905b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f1906a;

    /* JADX INFO: compiled from: GlobalMetrics.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f1907a = null;

        a() {
        }

        public b a() {
            return new b(this.f1907a);
        }

        public a b(e eVar) {
            this.f1907a = eVar;
            return this;
        }
    }

    b(e eVar) {
        this.f1906a = eVar;
    }

    public static a b() {
        return new a();
    }

    @s5.d(tag = 1)
    public e a() {
        return this.f1906a;
    }
}
