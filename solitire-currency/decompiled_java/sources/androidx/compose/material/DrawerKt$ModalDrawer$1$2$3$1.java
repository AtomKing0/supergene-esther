package androidx.compose.material;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerKt$ModalDrawer$1$2$3$1 extends v implements a<Float> {
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1$2$3$1(float f10, float f11, DrawerState drawerState) {
        super(0);
        this.$minValue = f10;
        this.$maxValue = f11;
        this.$drawerState = drawerState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        return Float.valueOf(DrawerKt.calculateFraction(this.$minValue, this.$maxValue, this.$drawerState.getOffset().getValue().floatValue()));
    }
}
