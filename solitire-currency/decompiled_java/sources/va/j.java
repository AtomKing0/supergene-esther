package va;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.w0;

/* JADX INFO: compiled from: -SegmentedByteString.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j {
    public static final int a(@NotNull int[] iArr, int i10, int i11, int i12) {
        t.i(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final int b(@NotNull w0 w0Var, int i10) {
        t.i(w0Var, "<this>");
        int iA = a(w0Var.I(), i10 + 1, 0, w0Var.J().length);
        return iA >= 0 ? iA : ~iA;
    }
}
