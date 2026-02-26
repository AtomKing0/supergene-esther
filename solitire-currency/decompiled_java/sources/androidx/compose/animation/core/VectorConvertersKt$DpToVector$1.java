package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$DpToVector$1 extends v implements l<Dp, AnimationVector1D> {
    public static final VectorConvertersKt$DpToVector$1 INSTANCE = new VectorConvertersKt$DpToVector$1();

    VectorConvertersKt$DpToVector$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector1D invoke(Dp dp) {
        return m143invoke0680j_4(dp.m3687unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0680j_4, reason: not valid java name */
    public final AnimationVector1D m143invoke0680j_4(float f10) {
        return new AnimationVector1D(f10);
    }
}
