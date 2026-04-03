package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$IntOffsetToVector$2 extends v implements l<AnimationVector2D, IntOffset> {
    public static final VectorConvertersKt$IntOffsetToVector$2 INSTANCE = new VectorConvertersKt$IntOffsetToVector$2();

    VectorConvertersKt$IntOffsetToVector$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ IntOffset invoke(AnimationVector2D animationVector2D) {
        return IntOffset.m3782boximpl(m146invokeBjo55l4(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m146invokeBjo55l4(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return IntOffsetKt.IntOffset(j9.c.c(it.getV1()), j9.c.c(it.getV2()));
    }
}
