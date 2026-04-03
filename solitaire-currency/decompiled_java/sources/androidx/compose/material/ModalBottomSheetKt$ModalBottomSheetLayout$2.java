package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModalBottomSheetKt$ModalBottomSheetLayout$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ModalBottomSheetKt$ModalBottomSheetLayout$2(q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, Modifier modifier, ModalBottomSheetState modalBottomSheetState, Shape shape, float f10, long j10, long j11, long j12, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
        super(2);
        this.$sheetContent = qVar;
        this.$modifier = modifier;
        this.$sheetState = modalBottomSheetState;
        this.$sheetShape = shape;
        this.$sheetElevation = f10;
        this.$sheetBackgroundColor = j10;
        this.$sheetContentColor = j11;
        this.$scrimColor = j12;
        this.$content = pVar;
        this.$$changed = i10;
        this.$$default = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        ModalBottomSheetKt.m1064ModalBottomSheetLayoutBzaUkTc(this.$sheetContent, this.$modifier, this.$sheetState, this.$sheetShape, this.$sheetElevation, this.$sheetBackgroundColor, this.$sheetContentColor, this.$scrimColor, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
