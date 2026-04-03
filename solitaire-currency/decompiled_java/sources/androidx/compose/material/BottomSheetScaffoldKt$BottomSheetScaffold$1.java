package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import com.google.android.gms.drive.DriveFile;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ p<Composer, Integer, k0> $child;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffold$1(q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar, BottomSheetScaffoldState bottomSheetScaffoldState, boolean z10, Shape shape, float f10, long j10, long j11, long j12, int i10) {
        super(2);
        this.$drawerContent = qVar;
        this.$child = pVar;
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$drawerGesturesEnabled = z10;
        this.$drawerShape = shape;
        this.$drawerElevation = f10;
        this.$drawerBackgroundColor = j10;
        this.$drawerContentColor = j11;
        this.$drawerScrimColor = j12;
        this.$$dirty1 = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (this.$drawerContent == null) {
            composer.startReplaceableGroup(-249544858);
            this.$child.mo4invoke(composer, 6);
            composer.endReplaceableGroup();
            return;
        }
        composer.startReplaceableGroup(-249544821);
        q<ColumnScope, Composer, Integer, k0> qVar = this.$drawerContent;
        DrawerState drawerState = this.$scaffoldState.getDrawerState();
        boolean z10 = this.$drawerGesturesEnabled;
        Shape shape = this.$drawerShape;
        float f10 = this.$drawerElevation;
        long j10 = this.$drawerBackgroundColor;
        long j11 = this.$drawerContentColor;
        long j12 = this.$drawerScrimColor;
        p<Composer, Integer, k0> pVar = this.$child;
        int i11 = this.$$dirty1;
        DrawerKt.m1000ModalDrawerGs3lGvM(qVar, null, drawerState, z10, shape, f10, j10, j11, j12, pVar, composer, ((i11 >> 9) & 14) | DriveFile.MODE_READ_WRITE | ((i11 >> 3) & 7168) | ((i11 >> 3) & 57344) | ((i11 >> 3) & 458752) | ((i11 >> 3) & 3670016) | ((i11 >> 3) & 29360128) | ((i11 >> 3) & 234881024), 2);
        composer.endReplaceableGroup();
    }
}
