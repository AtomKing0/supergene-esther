package m5;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: UiExecutor.java */
/* JADX INFO: loaded from: classes3.dex */
public enum l implements Executor {
    INSTANCE;


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ThreadPoolCreation"})
    private static final Handler f31466b = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f31466b.post(runnable);
    }
}
