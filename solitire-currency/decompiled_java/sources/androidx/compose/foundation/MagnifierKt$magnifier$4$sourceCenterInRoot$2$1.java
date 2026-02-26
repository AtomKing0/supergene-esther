package androidx.compose.foundation;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: Magnifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class MagnifierKt$magnifier$4$sourceCenterInRoot$2$1 extends v implements h9.a<Offset> {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
    final /* synthetic */ Density $density;
    final /* synthetic */ State<h9.l<Density, Offset>> $updatedSourceCenter$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(Density density, State<? extends h9.l<? super Density, Offset>> state, MutableState<Offset> mutableState) {
        super(0);
        this.$density = density;
        this.$updatedSourceCenter$delegate = state;
        this.$anchorPositionInRoot$delegate = mutableState;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ Offset invoke() {
        return Offset.m1356boximpl(m231invokeF1C5BW0());
    }

    /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
    public final long m231invokeF1C5BW0() {
        long jM1377unboximpl = ((Offset) MagnifierKt.AnonymousClass4.m225invoke$lambda3(this.$updatedSourceCenter$delegate).invoke(this.$density)).m1377unboximpl();
        return (OffsetKt.m1386isSpecifiedk4lQ0M(MagnifierKt.AnonymousClass4.m222invoke$lambda1(this.$anchorPositionInRoot$delegate)) && OffsetKt.m1386isSpecifiedk4lQ0M(jM1377unboximpl)) ? Offset.m1372plusMKHz9U(MagnifierKt.AnonymousClass4.m222invoke$lambda1(this.$anchorPositionInRoot$delegate), jM1377unboximpl) : Offset.Companion.m1382getUnspecifiedF1C5BW0();
    }
}
