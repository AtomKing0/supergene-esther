package androidx.compose.foundation;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: AndroidOverscroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidEdgeEffectOverscrollEffect$onNewSize$1 extends v implements h9.l<IntSize, k0> {
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$onNewSize$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        super(1);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(IntSize intSize) {
        m162invokeozmzZPI(intSize.m3837unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m162invokeozmzZPI(long j10) {
        boolean z10 = !Size.m1432equalsimpl0(IntSizeKt.m3843toSizeozmzZPI(j10), this.this$0.containerSize);
        this.this$0.containerSize = IntSizeKt.m3843toSizeozmzZPI(j10);
        if (z10) {
            this.this$0.topEffect.setSize(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10));
            this.this$0.bottomEffect.setSize(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10));
            this.this$0.leftEffect.setSize(IntSize.m3832getHeightimpl(j10), IntSize.m3833getWidthimpl(j10));
            this.this$0.rightEffect.setSize(IntSize.m3832getHeightimpl(j10), IntSize.m3833getWidthimpl(j10));
            this.this$0.topEffectNegation.setSize(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10));
            this.this$0.bottomEffectNegation.setSize(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10));
            this.this$0.leftEffectNegation.setSize(IntSize.m3832getHeightimpl(j10), IntSize.m3833getWidthimpl(j10));
            this.this$0.rightEffectNegation.setSize(IntSize.m3832getHeightimpl(j10), IntSize.m3833getWidthimpl(j10));
        }
        if (z10) {
            this.this$0.invalidateOverscroll();
            this.this$0.animateToRelease();
        }
    }
}
