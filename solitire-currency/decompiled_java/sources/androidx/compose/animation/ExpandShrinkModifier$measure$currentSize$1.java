package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class ExpandShrinkModifier$measure$currentSize$1 extends v implements l<EnterExitState, IntSize> {
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ ExpandShrinkModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpandShrinkModifier$measure$currentSize$1(ExpandShrinkModifier expandShrinkModifier, long j10) {
        super(1);
        this.this$0 = expandShrinkModifier;
        this.$measuredSize = j10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ IntSize invoke(EnterExitState enterExitState) {
        return IntSize.m3825boximpl(m75invokeYEO4UFw(enterExitState));
    }

    /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
    public final long m75invokeYEO4UFw(@NotNull EnterExitState it) {
        t.i(it, "it");
        return this.this$0.m73sizeByStateUzc_VyU(it, this.$measuredSize);
    }
}
