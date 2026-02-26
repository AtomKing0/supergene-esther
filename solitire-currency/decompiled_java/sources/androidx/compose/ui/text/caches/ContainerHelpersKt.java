package androidx.compose.ui.text.caches;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContainerHelpers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContainerHelpersKt {

    @NotNull
    public static final int[] EMPTY_INTS = new int[0];

    @NotNull
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearchInternal(@NotNull int[] iArr, int i10, int i11) {
        t.i(iArr, "<this>");
        int i12 = i10 - 1;
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i11) {
                i13 = i14 + 1;
            } else {
                if (i15 <= i11) {
                    return i14;
                }
                i12 = i14 - 1;
            }
        }
        return ~i13;
    }
}
