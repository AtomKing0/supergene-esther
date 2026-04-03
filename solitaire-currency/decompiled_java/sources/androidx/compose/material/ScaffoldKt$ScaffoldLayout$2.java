package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScaffoldKt$ScaffoldLayout$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ p<Composer, Integer, k0> $bottomBar;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
    final /* synthetic */ p<Composer, Integer, k0> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ boolean $isFabDocked;
    final /* synthetic */ p<Composer, Integer, k0> $snackbar;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$ScaffoldLayout$2(boolean z10, int i10, p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, int i11) {
        super(2);
        this.$isFabDocked = z10;
        this.$fabPosition = i10;
        this.$topBar = pVar;
        this.$content = qVar;
        this.$snackbar = pVar2;
        this.$fab = pVar3;
        this.$bottomBar = pVar4;
        this.$$changed = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        ScaffoldKt.m1119ScaffoldLayoutMDYNRJg(this.$isFabDocked, this.$fabPosition, this.$topBar, this.$content, this.$snackbar, this.$fab, this.$bottomBar, composer, this.$$changed | 1);
    }
}
