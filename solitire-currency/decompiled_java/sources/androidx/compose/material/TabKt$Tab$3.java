package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabKt$Tab$3 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ p<Composer, Integer, k0> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ long $selectedContentColor;
    final /* synthetic */ p<Composer, Integer, k0> $text;
    final /* synthetic */ long $unselectedContentColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabKt$Tab$3(boolean z10, a<k0> aVar, Modifier modifier, boolean z11, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, MutableInteractionSource mutableInteractionSource, long j10, long j11, int i10, int i11) {
        super(2);
        this.$selected = z10;
        this.$onClick = aVar;
        this.$modifier = modifier;
        this.$enabled = z11;
        this.$text = pVar;
        this.$icon = pVar2;
        this.$interactionSource = mutableInteractionSource;
        this.$selectedContentColor = j10;
        this.$unselectedContentColor = j11;
        this.$$changed = i10;
        this.$$default = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        TabKt.m1167Tab0nDMI0(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$text, this.$icon, this.$interactionSource, this.$selectedContentColor, this.$unselectedContentColor, composer, this.$$changed | 1, this.$$default);
    }
}
