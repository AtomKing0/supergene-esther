package a4;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Clock.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f148a = new i0();

    p createHandler(Looper looper, @Nullable Handler.Callback callback);

    long elapsedRealtime();

    void onThreadBlocked();

    long uptimeMillis();
}
