package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomNavigationKt$BottomNavigationItem$2$1 extends v implements q<Float, Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ p<Composer, Integer, k0> $icon;
    final /* synthetic */ p<Composer, Integer, k0> $styledLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomNavigationKt$BottomNavigationItem$2$1(boolean z10, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10) {
        super(3);
        this.$alwaysShowLabel = z10;
        this.$icon = pVar;
        this.$styledLabel = pVar2;
        this.$$dirty = i10;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Float f10, Composer composer, Integer num) {
        invoke(f10.floatValue(), composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(float f10, @Nullable Composer composer, int i10) {
        if ((i10 & 14) == 0) {
            i10 |= composer.changed(f10) ? 4 : 2;
        }
        if ((i10 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (this.$alwaysShowLabel) {
            f10 = 1.0f;
        }
        BottomNavigationKt.BottomNavigationItemBaselineLayout(this.$icon, this.$styledLabel, f10, composer, (this.$$dirty >> 9) & 14);
    }
}
