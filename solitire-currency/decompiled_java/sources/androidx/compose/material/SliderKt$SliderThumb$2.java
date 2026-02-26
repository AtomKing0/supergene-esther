package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$SliderThumb$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $offset;
    final /* synthetic */ BoxScope $this_SliderThumb;
    final /* synthetic */ float $thumbSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$SliderThumb$2(BoxScope boxScope, Modifier modifier, float f10, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z10, float f11, int i10) {
        super(2);
        this.$this_SliderThumb = boxScope;
        this.$modifier = modifier;
        this.$offset = f10;
        this.$interactionSource = mutableInteractionSource;
        this.$colors = sliderColors;
        this.$enabled = z10;
        this.$thumbSize = f11;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        SliderKt.m1123SliderThumbPcYyNuk(this.$this_SliderThumb, this.$modifier, this.$offset, this.$interactionSource, this.$colors, this.$enabled, this.$thumbSize, composer, this.$$changed | 1);
    }
}
