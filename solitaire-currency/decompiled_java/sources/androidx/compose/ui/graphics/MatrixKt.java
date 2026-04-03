package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Matrix.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MatrixKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    public static final float m1799dotp89u6pk(float[] fArr, int i10, float[] fArr2, int i11) {
        int i12 = i10 * 4;
        return (fArr[i12 + 0] * fArr2[0 + i11]) + (fArr[i12 + 1] * fArr2[4 + i11]) + (fArr[i12 + 2] * fArr2[8 + i11]) + (fArr[i12 + 3] * fArr2[12 + i11]);
    }

    /* JADX INFO: renamed from: isIdentity-58bKbWc, reason: not valid java name */
    public static final boolean m1800isIdentity58bKbWc(@NotNull float[] isIdentity) {
        kotlin.jvm.internal.t.i(isIdentity, "$this$isIdentity");
        int i10 = 0;
        while (i10 < 4) {
            int i11 = 0;
            while (i11 < 4) {
                if (!(isIdentity[(i10 * 4) + i11] == (i10 == i11 ? 1.0f : 0.0f))) {
                    return false;
                }
                i11++;
            }
            i10++;
        }
        return true;
    }
}
