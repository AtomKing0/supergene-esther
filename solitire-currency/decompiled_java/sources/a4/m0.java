package a4;

import android.os.Trace;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: TraceUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    public static void a(String str) {
        if (o0.f214a >= 18) {
            b(str);
        }
    }

    @RequiresApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (o0.f214a >= 18) {
            d();
        }
    }

    @RequiresApi(18)
    private static void d() {
        Trace.endSection();
    }
}
