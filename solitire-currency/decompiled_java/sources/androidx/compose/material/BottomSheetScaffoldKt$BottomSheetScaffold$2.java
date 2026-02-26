package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$changed2;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ p<Composer, Integer, k0> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffold$2(q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, p<? super Composer, ? super Integer, k0> pVar, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar2, p<? super Composer, ? super Integer, k0> pVar2, int i10, boolean z10, Shape shape, float f10, long j10, long j11, float f11, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar3, boolean z11, Shape shape2, float f12, long j12, long j13, long j14, long j15, long j16, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar4, int i11, int i12, int i13, int i14) {
        super(2);
        this.$sheetContent = qVar;
        this.$modifier = modifier;
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$topBar = pVar;
        this.$snackbarHost = qVar2;
        this.$floatingActionButton = pVar2;
        this.$floatingActionButtonPosition = i10;
        this.$sheetGesturesEnabled = z10;
        this.$sheetShape = shape;
        this.$sheetElevation = f10;
        this.$sheetBackgroundColor = j10;
        this.$sheetContentColor = j11;
        this.$sheetPeekHeight = f11;
        this.$drawerContent = qVar3;
        this.$drawerGesturesEnabled = z11;
        this.$drawerShape = shape2;
        this.$drawerElevation = f12;
        this.$drawerBackgroundColor = j12;
        this.$drawerContentColor = j13;
        this.$drawerScrimColor = j14;
        this.$backgroundColor = j15;
        this.$contentColor = j16;
        this.$content = qVar4;
        this.$$changed = i11;
        this.$$changed1 = i12;
        this.$$changed2 = i13;
        this.$$default = i14;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        BottomSheetScaffoldKt.m892BottomSheetScaffoldbGncdBI(this.$sheetContent, this.$modifier, this.$scaffoldState, this.$topBar, this.$snackbarHost, this.$floatingActionButton, this.$floatingActionButtonPosition, this.$sheetGesturesEnabled, this.$sheetShape, this.$sheetElevation, this.$sheetBackgroundColor, this.$sheetContentColor, this.$sheetPeekHeight, this.$drawerContent, this.$drawerGesturesEnabled, this.$drawerShape, this.$drawerElevation, this.$drawerBackgroundColor, this.$drawerContentColor, this.$drawerScrimColor, this.$backgroundColor, this.$contentColor, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$changed2, this.$$default);
    }
}
