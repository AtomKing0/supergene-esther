package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$DpOffsetToVector$2 extends v implements l<AnimationVector2D, DpOffset> {
    public static final VectorConvertersKt$DpOffsetToVector$2 INSTANCE = new VectorConvertersKt$DpOffsetToVector$2();

    VectorConvertersKt$DpOffsetToVector$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ DpOffset invoke(AnimationVector2D animationVector2D) {
        return DpOffset.m3728boximpl(m142invokegVRvYmI(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-gVRvYmI, reason: not valid java name */
    public final long m142invokegVRvYmI(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return DpKt.m3694DpOffsetYgX7TsA(Dp.m3673constructorimpl(it.getV1()), Dp.m3673constructorimpl(it.getV2()));
    }
}
