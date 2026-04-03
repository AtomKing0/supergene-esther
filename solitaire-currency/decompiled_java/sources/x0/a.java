package x0;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.sentry.protocol.TransactionInfo;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f35558b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f35559c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f35560a;

    /* JADX INFO: renamed from: x0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideExecutor.java */
    private static final class ThreadFactoryC0724a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f35561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b f35562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f35563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35564d;

        /* JADX INFO: renamed from: x0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0725a extends Thread {
            C0725a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (ThreadFactoryC0724a.this.f35563c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    ThreadFactoryC0724a.this.f35562b.a(th);
                }
            }
        }

        ThreadFactoryC0724a(String str, b bVar, boolean z10) {
            this.f35561a = str;
            this.f35562b = bVar;
            this.f35563c = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0725a c0725a;
            c0725a = new C0725a(runnable, "glide-" + this.f35561a + "-thread-" + this.f35564d);
            this.f35564d = this.f35564d + 1;
            return c0725a;
        }
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.f35560a = executorService;
    }

    public static int a() {
        if (f35559c == 0) {
            f35559c = Math.min(4, x0.b.a());
        }
        return f35559c;
    }

    public static a b() {
        return c(a() >= 4 ? 2 : 1, b.f35569d);
    }

    public static a c(int i10, b bVar) {
        return new a(new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0724a("animation", bVar, true)));
    }

    public static a d() {
        return e(1, "disk-cache", b.f35569d);
    }

    public static a e(int i10, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0724a(str, bVar, true)));
    }

    public static a f() {
        return g(a(), TransactionInfo.JsonKeys.SOURCE, b.f35569d);
    }

    public static a g(int i10, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0724a(str, bVar, false)));
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f35558b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0724a("source-unlimited", b.f35569d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f35560a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f35560a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f35560a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f35560a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f35560a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f35560a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f35560a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f35560a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f35560a.submit(runnable);
    }

    public String toString() {
        return this.f35560a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f35560a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f35560a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t10) {
        return this.f35560a.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f35560a.submit(callable);
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35566a = new C0726a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f35567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f35568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f35569d;

        /* JADX INFO: renamed from: x0.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0727b implements b {
            C0727b() {
            }

            @Override // x0.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* JADX INFO: compiled from: GlideExecutor.java */
        class c implements b {
            c() {
            }

            @Override // x0.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0727b c0727b = new C0727b();
            f35567b = c0727b;
            f35568c = new c();
            f35569d = c0727b;
        }

        void a(Throwable th);

        /* JADX INFO: renamed from: x0.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0726a implements b {
            C0726a() {
            }

            @Override // x0.a.b
            public void a(Throwable th) {
            }
        }
    }
}
