package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1 extends v implements l<IntSize, k0> {
    final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(MutableState<Float> mutableState) {
        super(1);
        this.$bottomSheetHeight$delegate = mutableState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(IntSize intSize) {
        m899invokeozmzZPI(intSize.m3837unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m899invokeozmzZPI(long j10) {
        this.$bottomSheetHeight$delegate.setValue(Float.valueOf(IntSize.m3832getHeightimpl(j10)));
    }
}
