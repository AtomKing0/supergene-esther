package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$3 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ FloatingActionButtonElevation $elevation;
    final /* synthetic */ p<Composer, Integer, k0> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ p<Composer, Integer, k0> $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FloatingActionButtonKt$ExtendedFloatingActionButton$3(p<? super Composer, ? super Integer, k0> pVar, a<k0> aVar, Modifier modifier, p<? super Composer, ? super Integer, k0> pVar2, MutableInteractionSource mutableInteractionSource, Shape shape, long j10, long j11, FloatingActionButtonElevation floatingActionButtonElevation, int i10, int i11) {
        super(2);
        this.$text = pVar;
        this.$onClick = aVar;
        this.$modifier = modifier;
        this.$icon = pVar2;
        this.$interactionSource = mutableInteractionSource;
        this.$shape = shape;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$elevation = floatingActionButtonElevation;
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
        FloatingActionButtonKt.m1045ExtendedFloatingActionButtonwqdebIU(this.$text, this.$onClick, this.$modifier, this.$icon, this.$interactionSource, this.$shape, this.$backgroundColor, this.$contentColor, this.$elevation, composer, this.$$changed | 1, this.$$default);
    }
}
