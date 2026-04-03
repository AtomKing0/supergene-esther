package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import h9.l;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1 extends v implements l<Density, IntOffset> {
    final /* synthetic */ float $fullHeight;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1(ModalBottomSheetState modalBottomSheetState, float f10) {
        super(1);
        this.$sheetState = modalBottomSheetState;
        this.$fullHeight = f10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
        return IntOffset.m3782boximpl(m1069invokeBjo55l4(density));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m1069invokeBjo55l4(@NotNull Density offset) {
        t.i(offset, "$this$offset");
        return IntOffsetKt.IntOffset(0, this.$sheetState.getAnchors$material_release().isEmpty() ? c.c(this.$fullHeight) : c.c(this.$sheetState.getOffset().getValue().floatValue()));
    }
}
