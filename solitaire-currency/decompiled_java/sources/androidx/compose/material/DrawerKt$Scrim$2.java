package androidx.compose.material;

import androidx.compose.runtime.Composer;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerKt$Scrim$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $color;
    final /* synthetic */ a<Float> $fraction;
    final /* synthetic */ a<k0> $onClose;
    final /* synthetic */ boolean $open;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$Scrim$2(boolean z10, a<k0> aVar, a<Float> aVar2, long j10, int i10) {
        super(2);
        this.$open = z10;
        this.$onClose = aVar;
        this.$fraction = aVar2;
        this.$color = j10;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        DrawerKt.m1001ScrimBx497Mc(this.$open, this.$onClose, this.$fraction, this.$color, composer, this.$$changed | 1);
    }
}
