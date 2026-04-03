package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomNavigationKt$BottomNavigationItem$3 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ p<Composer, Integer, k0> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ p<Composer, Integer, k0> $label;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ long $selectedContentColor;
    final /* synthetic */ RowScope $this_BottomNavigationItem;
    final /* synthetic */ long $unselectedContentColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomNavigationKt$BottomNavigationItem$3(RowScope rowScope, boolean z10, a<k0> aVar, p<? super Composer, ? super Integer, k0> pVar, Modifier modifier, boolean z11, p<? super Composer, ? super Integer, k0> pVar2, boolean z12, MutableInteractionSource mutableInteractionSource, long j10, long j11, int i10, int i11, int i12) {
        super(2);
        this.$this_BottomNavigationItem = rowScope;
        this.$selected = z10;
        this.$onClick = aVar;
        this.$icon = pVar;
        this.$modifier = modifier;
        this.$enabled = z11;
        this.$label = pVar2;
        this.$alwaysShowLabel = z12;
        this.$interactionSource = mutableInteractionSource;
        this.$selectedContentColor = j10;
        this.$unselectedContentColor = j11;
        this.$$changed = i10;
        this.$$changed1 = i11;
        this.$$default = i12;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        BottomNavigationKt.m881BottomNavigationItemjY6E1Zs(this.$this_BottomNavigationItem, this.$selected, this.$onClick, this.$icon, this.$modifier, this.$enabled, this.$label, this.$alwaysShowLabel, this.$interactionSource, this.$selectedContentColor, this.$unselectedContentColor, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
