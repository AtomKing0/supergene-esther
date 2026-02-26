package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerKt$BottomDrawer$1$1$3$1 extends v implements l<LayoutCoordinates, k0> {
    final /* synthetic */ MutableState<Float> $drawerHeight$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$1$1$3$1(MutableState<Float> mutableState) {
        super(1);
        this.$drawerHeight$delegate = mutableState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
        invoke2(layoutCoordinates);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutCoordinates position) {
        t.i(position, "position");
        DrawerKt$BottomDrawer$1.m1007invoke$lambda2(this.$drawerHeight$delegate, IntSize.m3832getHeightimpl(position.mo2989getSizeYbymL2g()));
    }
}
