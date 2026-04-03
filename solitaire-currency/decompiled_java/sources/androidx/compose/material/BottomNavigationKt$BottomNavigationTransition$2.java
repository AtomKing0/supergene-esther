package androidx.compose.material;

import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomNavigationKt$BottomNavigationTransition$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $activeColor;
    final /* synthetic */ q<Float, Composer, Integer, k0> $content;
    final /* synthetic */ long $inactiveColor;
    final /* synthetic */ boolean $selected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomNavigationKt$BottomNavigationTransition$2(long j10, long j11, boolean z10, q<? super Float, ? super Composer, ? super Integer, k0> qVar, int i10) {
        super(2);
        this.$activeColor = j10;
        this.$inactiveColor = j11;
        this.$selected = z10;
        this.$content = qVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        BottomNavigationKt.m882BottomNavigationTransitionKlgxPg(this.$activeColor, this.$inactiveColor, this.$selected, this.$content, composer, this.$$changed | 1);
    }
}
