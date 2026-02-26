package p9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class o extends n {
    @Nullable
    public static Double i(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        try {
            if (g.f32973b.a(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static Float j(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        try {
            if (g.f32973b.a(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
