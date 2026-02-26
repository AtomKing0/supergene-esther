package e6;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PoolableExecutors.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e6.a f25175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e6.a f25176b;

    /* JADX INFO: renamed from: e6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PoolableExecutors.java */
    private static class C0547b implements e6.a {
        private C0547b() {
        }

        @Override // e6.a
        @NonNull
        public ExecutorService a(ThreadFactory threadFactory, c cVar) {
            return b(1, threadFactory, cVar);
        }

        @NonNull
        @SuppressLint({"ThreadPoolCreation"})
        public ExecutorService b(int i10, ThreadFactory threadFactory, c cVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0547b c0547b = new C0547b();
        f25175a = c0547b;
        f25176b = c0547b;
    }

    public static e6.a a() {
        return f25176b;
    }
}
