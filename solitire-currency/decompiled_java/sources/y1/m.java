package y1;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SafeLoggingExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f36414a;

    /* JADX INFO: compiled from: SafeLoggingExecutor.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f36415a;

        a(Runnable runnable) {
            this.f36415a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f36415a.run();
            } catch (Exception e10) {
                c2.a.d("Executor", "Background execution failure.", e10);
            }
        }
    }

    m(Executor executor) {
        this.f36414a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f36414a.execute(new a(runnable));
    }
}
