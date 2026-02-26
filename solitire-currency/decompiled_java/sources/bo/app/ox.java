package bo.app;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ox {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3585g = (int) TimeUnit.SECONDS.toMillis(45);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l9.c f3590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3591f;

    public /* synthetic */ ox(int i10, int i11, int i12) {
        this(i10, f3585g, i11, i12);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ExponentialBackoffStateProvider(maxSleepDurationMs=");
        sb.append(this.f3586a);
        sb.append(", defaultNormalFlushIntervalMs=");
        sb.append(this.f3587b);
        sb.append(", minSleepDurationMs=");
        sb.append(this.f3588c);
        sb.append(", scaleFactor=");
        sb.append(this.f3589d);
        sb.append(", randomSleepDurationGenerator=");
        sb.append(this.f3590e);
        sb.append(", lastSleepDurationMs=");
        sb.append(this.f3591f);
        sb.append(", isBackingOff=");
        sb.append(this.f3591f != 0);
        sb.append(')');
        return sb.toString();
    }

    public ox(int i10, int i11, int i12, int i13) {
        this.f3586a = i10;
        this.f3587b = i11;
        this.f3588c = i12;
        this.f3589d = i13;
        this.f3590e = l9.d.a(SystemClock.uptimeMillis());
    }
}
