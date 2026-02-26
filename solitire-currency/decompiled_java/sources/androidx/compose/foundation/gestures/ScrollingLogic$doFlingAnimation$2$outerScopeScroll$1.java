package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import h9.l;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1 extends v implements l<Offset, Offset> {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(ScrollingLogic scrollingLogic, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$$this$scroll = scrollScope;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
        return Offset.m1356boximpl(m314invokeMKHz9U(offset.m1377unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
    public final long m314invokeMKHz9U(long j10) {
        ScrollingLogic scrollingLogic = this.this$0;
        return Offset.m1371minusMKHz9U(j10, this.this$0.m308reverseIfNeededMKHz9U(scrollingLogic.m305dispatchScrollf0eR0lY(this.$$this$scroll, scrollingLogic.m308reverseIfNeededMKHz9U(j10), null, NestedScrollSource.Companion.m2788getFlingWNlRxjI())));
    }
}
