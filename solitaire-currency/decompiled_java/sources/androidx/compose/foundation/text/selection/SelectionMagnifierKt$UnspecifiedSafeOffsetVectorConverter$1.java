package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SelectionMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 extends v implements l<Offset, AnimationVector2D> {
    public static final SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 INSTANCE = new SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1();

    SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ AnimationVector2D invoke(Offset offset) {
        return m783invokek4lQ0M(offset.m1377unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final AnimationVector2D m783invokek4lQ0M(long j10) {
        return OffsetKt.m1386isSpecifiedk4lQ0M(j10) ? new AnimationVector2D(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10)) : SelectionMagnifierKt.UnspecifiedAnimationVector2D;
    }
}
