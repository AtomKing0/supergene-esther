package b1;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

/* JADX INFO: compiled from: HardwareConfigState.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final File f1878d = new File("/proc/self/fd");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile int f1879e = 700;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile int f1880f = 128;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile v f1881g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private int f1883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f1884c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f1882a = d();

    @VisibleForTesting
    v() {
    }

    public static v a() {
        if (f1881g == null) {
            synchronized (v.class) {
                if (f1881g == null) {
                    f1881g = new v();
                }
            }
        }
        return f1881g;
    }

    private synchronized boolean b() {
        boolean z10 = true;
        int i10 = this.f1883b + 1;
        this.f1883b = i10;
        if (i10 >= 50) {
            this.f1883b = 0;
            int length = f1878d.list().length;
            if (length >= f1879e) {
                z10 = false;
            }
            this.f1884c = z10;
            if (!z10 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + f1879e);
            }
        }
        return this.f1884c;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String strSubstring = str.substring(0, 7);
        strSubstring.hashCode();
        switch (strSubstring) {
            case "SM-A520":
            case "SM-G930":
            case "SM-G935":
            case "SM-G960":
            case "SM-G965":
            case "SM-J720":
            case "SM-N935":
                return Build.VERSION.SDK_INT != 26;
            default:
                return true;
        }
    }

    public boolean c(int i10, int i11, boolean z10, boolean z11) {
        return z10 && this.f1882a && Build.VERSION.SDK_INT >= 26 && !z11 && i10 >= f1880f && i11 >= f1880f && b();
    }

    @TargetApi(26)
    boolean e(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean zC = c(i10, i11, z10, z11);
        if (zC) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zC;
    }
}
