package o1;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f31796a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f31797b = new b();

    /* JADX INFO: compiled from: Executors.java */
    class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f31798a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f31798a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: Executors.java */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f31797b;
    }

    public static Executor b() {
        return f31796a;
    }
}
