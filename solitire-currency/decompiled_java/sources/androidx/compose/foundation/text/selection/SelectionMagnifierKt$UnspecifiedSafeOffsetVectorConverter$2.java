package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SelectionMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2 extends v implements l<AnimationVector2D, Offset> {
    public static final SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2 INSTANCE = new SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2();

    SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Offset invoke(AnimationVector2D animationVector2D) {
        return Offset.m1356boximpl(m784invoketuRUvjQ(animationVector2D));
    }

    /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
    public final long m784invoketuRUvjQ(@NotNull AnimationVector2D it) {
        t.i(it, "it");
        return OffsetKt.Offset(it.getV1(), it.getV2());
    }
}
