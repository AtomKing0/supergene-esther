package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.graphics.TransformOrigin;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class EnterExitTransitionKt$TransformOriginVectorConverter$1 extends v implements l<TransformOrigin, AnimationVector2D> {
    public static final EnterExitTransitionKt$TransformOriginVectorConverter$1 INSTANCE = new EnterExitTransitionKt$TransformOriginVectorConverter$1();

    EnterExitTransitionKt$TransformOriginVectorConverter$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
        return m57invoke__ExYCQ(transformOrigin.m1922unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-__ExYCQ, reason: not valid java name */
    public final AnimationVector2D m57invoke__ExYCQ(long j10) {
        return new AnimationVector2D(TransformOrigin.m1918getPivotFractionXimpl(j10), TransformOrigin.m1919getPivotFractionYimpl(j10));
    }
}
