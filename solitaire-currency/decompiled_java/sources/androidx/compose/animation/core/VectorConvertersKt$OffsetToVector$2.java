package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorConvertersKt$OffsetToVector$2 extends v implements l<AnimationVector2D, Offset> {
    public static final VectorConvertersKt$OffsetToVector$2 INSTANCE = new VectorConvertersKt$OffsetToVector$2();

    VectorConvertersKt$OffsetToVector$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Offset invoke(AnimationVector2D animationVector2D) {
        return Offset.m1356boximpl(m150invoketuRUvjQ(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
    public final long m150invoketuRUvjQ(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return OffsetKt.Offset(it.getV1(), it.getV2());
    }
}
