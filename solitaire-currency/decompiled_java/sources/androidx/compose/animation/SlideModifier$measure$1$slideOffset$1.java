package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class SlideModifier$measure$1$slideOffset$1 extends v implements l<EnterExitState, IntOffset> {
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ SlideModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlideModifier$measure$1$slideOffset$1(SlideModifier slideModifier, long j10) {
        super(1);
        this.this$0 = slideModifier;
        this.$measuredSize = j10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
        return IntOffset.m3782boximpl(m91invokeBjo55l4(enterExitState));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m91invokeBjo55l4(@NotNull EnterExitState it) {
        t.i(it, "it");
        return this.this$0.m90targetValueByStateoFUgxo0(it, this.$measuredSize);
    }
}
