package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import h9.l;
import j9.c;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends v implements l<Constraints, Constraints> {
    final /* synthetic */ float $headerHeightPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f10) {
        super(1);
        this.$headerHeightPx = f10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
        return Constraints.m3629boximpl(m875invokeZezNO4M(constraints.m3647unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-ZezNO4M, reason: not valid java name */
    public final long m875invokeZezNO4M(long j10) {
        return ConstraintsKt.m3658offsetNN6EwU$default(Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 10, null), 0, -c.c(this.$headerHeightPx), 1, null);
    }
}
