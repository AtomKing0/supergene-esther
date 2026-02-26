package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class EnterExitTransitionKt$TransformOriginVectorConverter$2 extends v implements l<AnimationVector2D, TransformOrigin> {
    public static final EnterExitTransitionKt$TransformOriginVectorConverter$2 INSTANCE = new EnterExitTransitionKt$TransformOriginVectorConverter$2();

    EnterExitTransitionKt$TransformOriginVectorConverter$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
        return TransformOrigin.m1910boximpl(m58invokeLIALnN8(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-LIALnN8, reason: not valid java name */
    public final long m58invokeLIALnN8(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return TransformOriginKt.TransformOrigin(it.getV1(), it.getV2());
    }
}
