package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $body;
    final /* synthetic */ q<Integer, Composer, Integer, k0> $bottomSheet;
    final /* synthetic */ p<Composer, Integer, k0> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ State<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;
    final /* synthetic */ p<Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, q<? super Integer, ? super Composer, ? super Integer, k0> qVar2, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, float f10, int i10, State<Float> state, BottomSheetState bottomSheetState, int i11) {
        super(2);
        this.$topBar = pVar;
        this.$body = qVar;
        this.$bottomSheet = qVar2;
        this.$floatingActionButton = pVar2;
        this.$snackbarHost = pVar3;
        this.$sheetPeekHeight = f10;
        this.$floatingActionButtonPosition = i10;
        this.$sheetOffset = state;
        this.$sheetState = bottomSheetState;
        this.$$changed = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        BottomSheetScaffoldKt.m893BottomSheetScaffoldLayoutKCBPh4w(this.$topBar, this.$body, this.$bottomSheet, this.$floatingActionButton, this.$snackbarHost, this.$sheetPeekHeight, this.$floatingActionButtonPosition, this.$sheetOffset, this.$sheetState, composer, this.$$changed | 1);
    }
}
