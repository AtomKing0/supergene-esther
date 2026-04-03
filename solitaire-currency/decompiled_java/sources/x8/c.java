package x8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _ComparisonsJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public class c extends b {
    public static float c(float f10, @NotNull float... other) {
        t.i(other, "other");
        for (float f11 : other) {
            f10 = Math.max(f10, f11);
        }
        return f10;
    }

    public static float d(float f10, @NotNull float... other) {
        t.i(other, "other");
        for (float f11 : other) {
            f10 = Math.min(f10, f11);
        }
        return f10;
    }
}
