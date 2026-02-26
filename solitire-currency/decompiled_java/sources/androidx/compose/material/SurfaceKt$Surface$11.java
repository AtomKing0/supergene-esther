package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
final class SurfaceKt$Surface$11 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ long $color;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ l<Boolean, k0> $onCheckedChange;
    final /* synthetic */ Shape $shape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SurfaceKt$Surface$11(boolean z10, l<? super Boolean, k0> lVar, Modifier modifier, boolean z11, Shape shape, long j10, long j11, BorderStroke borderStroke, float f10, MutableInteractionSource mutableInteractionSource, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11, int i12) {
        super(2);
        this.$checked = z10;
        this.$onCheckedChange = lVar;
        this.$modifier = modifier;
        this.$enabled = z11;
        this.$shape = shape;
        this.$color = j10;
        this.$contentColor = j11;
        this.$border = borderStroke;
        this.$elevation = f10;
        this.$interactionSource = mutableInteractionSource;
        this.$content = pVar;
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
        SurfaceKt.m1150SurfaceNy5ogXk(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$shape, this.$color, this.$contentColor, this.$border, this.$elevation, this.$interactionSource, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
