package androidx.compose.material;

import androidx.compose.runtime.Composer;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackdropScaffoldKt$Scrim$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $color;
    final /* synthetic */ a<k0> $onDismiss;
    final /* synthetic */ boolean $visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$Scrim$2(long j10, a<k0> aVar, boolean z10, int i10) {
        super(2);
        this.$color = j10;
        this.$onDismiss = aVar;
        this.$visible = z10;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        BackdropScaffoldKt.m869Scrim3JVO9M(this.$color, this.$onDismiss, this.$visible, composer, this.$$changed | 1);
    }
}
