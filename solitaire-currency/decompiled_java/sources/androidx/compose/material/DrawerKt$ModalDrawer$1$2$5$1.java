package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import h9.l;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerKt$ModalDrawer$1$2$5$1 extends v implements l<Density, IntOffset> {
    final /* synthetic */ DrawerState $drawerState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1$2$5$1(DrawerState drawerState) {
        super(1);
        this.$drawerState = drawerState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
        return IntOffset.m3782boximpl(m1010invokeBjo55l4(density));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m1010invokeBjo55l4(@NotNull Density offset) {
        t.i(offset, "$this$offset");
        return IntOffsetKt.IntOffset(c.c(this.$drawerState.getOffset().getValue().floatValue()), 0);
    }
}
