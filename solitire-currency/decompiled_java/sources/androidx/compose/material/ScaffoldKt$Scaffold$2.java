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

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScaffoldKt$Scaffold$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ p<Composer, Integer, k0> $bottomBar;
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
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$Scaffold$2(Modifier modifier, ScaffoldState scaffoldState, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar3, int i10, boolean z10, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar2, boolean z11, Shape shape, float f10, long j10, long j11, long j12, long j13, long j14, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar3, int i11, int i12, int i13) {
        super(2);
        this.$modifier = modifier;
        this.$scaffoldState = scaffoldState;
        this.$topBar = pVar;
        this.$bottomBar = pVar2;
        this.$snackbarHost = qVar;
        this.$floatingActionButton = pVar3;
        this.$floatingActionButtonPosition = i10;
        this.$isFloatingActionButtonDocked = z10;
        this.$drawerContent = qVar2;
        this.$drawerGesturesEnabled = z11;
        this.$drawerShape = shape;
        this.$drawerElevation = f10;
        this.$drawerBackgroundColor = j10;
        this.$drawerContentColor = j11;
        this.$drawerScrimColor = j12;
        this.$backgroundColor = j13;
        this.$contentColor = j14;
        this.$content = qVar3;
        this.$$changed = i11;
        this.$$changed1 = i12;
        this.$$default = i13;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        ScaffoldKt.m1118Scaffold27mzLpw(this.$modifier, this.$scaffoldState, this.$topBar, this.$bottomBar, this.$snackbarHost, this.$floatingActionButton, this.$floatingActionButtonPosition, this.$isFloatingActionButtonDocked, this.$drawerContent, this.$drawerGesturesEnabled, this.$drawerShape, this.$drawerElevation, this.$drawerBackgroundColor, this.$drawerContentColor, this.$drawerScrimColor, this.$backgroundColor, this.$contentColor, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
