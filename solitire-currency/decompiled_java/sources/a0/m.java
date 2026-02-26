package a0;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f49a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final File f50b = new File("/proc/self/fd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f51c = 30;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f52d = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f53e = true;

    private m() {
    }

    private final boolean a() {
        int i10 = f51c;
        f51c = i10 + 1;
        return i10 >= 30 || SystemClock.uptimeMillis() > f52d + ((long) 30000);
    }

    @WorkerThread
    public final synchronized boolean b(@Nullable r rVar) {
        if (a()) {
            f51c = 0;
            f52d = SystemClock.uptimeMillis();
            String[] list = f50b.list();
            if (list == null) {
                list = new String[0];
            }
            int length = list.length;
            boolean z10 = length < 800;
            f53e = z10;
            if (!z10 && rVar != null && rVar.getLevel() <= 5) {
                rVar.a("FileDescriptorCounter", 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, null);
            }
        }
        return f53e;
    }
}
