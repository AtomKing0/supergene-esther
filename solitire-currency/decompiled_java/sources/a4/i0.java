package a4;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SystemClock.java */
/* JADX INFO: loaded from: classes2.dex */
public class i0 implements d {
    protected i0() {
    }

    @Override // a4.d
    public p createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new j0(new Handler(looper, callback));
    }

    @Override // a4.d
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // a4.d
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    @Override // a4.d
    public void onThreadBlocked() {
    }
}
