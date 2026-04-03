package s6;

import android.app.Activity;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.util.Scanner;

/* JADX INFO: compiled from: GameLoadBooster.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q6.a f33585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f33586b;

    static {
        b();
    }

    private static boolean a() throws Throwable {
        boolean z10 = true;
        Scanner scanner = null;
        try {
            Activity activity = UnityPlayer.currentActivity;
            if (activity == null) {
                return true;
            }
            Scanner scanner2 = new Scanner(activity.getAssets().open("bin/Data/boot.config"));
            try {
                scanner2.useDelimiter("\n");
                while (true) {
                    if (!scanner2.hasNext()) {
                        break;
                    }
                    if ("adaptive-performance-samsung-boost-launch=0".equals(scanner2.next())) {
                        z10 = false;
                        break;
                    }
                }
                scanner2.close();
                return z10;
            } catch (Exception unused) {
                scanner = scanner2;
            } catch (Throwable th) {
                th = th;
                scanner = scanner2;
                if (scanner != null) {
                    scanner.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (scanner != null) {
            scanner.close();
        }
        return true;
    }

    public static boolean b() {
        boolean zB;
        boolean zC;
        try {
            if (!c()) {
                return false;
            }
            if (f33585a == null) {
                f33585a = new q6.a();
            }
            if (f33585a.a().equals("3.5")) {
                zB = f33585a.b(1);
                zC = f33585a.c(1);
            } else {
                zB = false;
                zC = false;
            }
            if (zB && zC) {
                Log.v("Unity", "Enabled boost mode on launch");
            }
            return zB && zC;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean c() {
        if (f33586b == null) {
            f33586b = Boolean.valueOf(a());
        }
        return f33586b.booleanValue();
    }
}
