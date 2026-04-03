package k1;

/* JADX INFO: compiled from: RequestCoordinator.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {

    /* JADX INFO: compiled from: RequestCoordinator.java */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f28924a;

        a(boolean z10) {
            this.f28924a = z10;
        }

        boolean a() {
            return this.f28924a;
        }
    }

    void a(c cVar);

    boolean b();

    boolean c(c cVar);

    boolean e(c cVar);

    void f(c cVar);

    boolean i(c cVar);
}
