package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e {
    public static /* synthetic */ void a(TransformScope transformScope, float f10, long j10, float f11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
        }
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            j10 = Offset.Companion.m1383getZeroF1C5BW0();
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        transformScope.mo242transformByd4ec7I(f10, j10, f11);
    }
}
