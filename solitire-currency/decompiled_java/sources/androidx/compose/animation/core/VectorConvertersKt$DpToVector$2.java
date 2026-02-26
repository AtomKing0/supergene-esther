package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$DpToVector$2 extends v implements l<AnimationVector1D, Dp> {
    public static final VectorConvertersKt$DpToVector$2 INSTANCE = new VectorConvertersKt$DpToVector$2();

    VectorConvertersKt$DpToVector$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Dp invoke(AnimationVector1D animationVector1D) {
        return Dp.m3671boximpl(m144invokeu2uoSUM(animationVector1D));
    }

    /* JADX INFO: renamed from: invoke-u2uoSUM, reason: not valid java name */
    public final float m144invokeu2uoSUM(@NotNull AnimationVector1D it) {
        t.i(it, "it");
        return Dp.m3673constructorimpl(it.getValue());
    }
}
