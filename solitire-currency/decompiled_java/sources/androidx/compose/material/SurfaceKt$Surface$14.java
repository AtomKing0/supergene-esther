package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import h9.a;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
final class SurfaceKt$Surface$14 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $color;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a<k0> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;
    final /* synthetic */ Shape $shape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SurfaceKt$Surface$14(a<k0> aVar, Modifier modifier, Shape shape, long j10, long j11, BorderStroke borderStroke, float f10, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z10, String str, Role role, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11, int i12) {
        super(2);
        this.$onClick = aVar;
        this.$modifier = modifier;
        this.$shape = shape;
        this.$color = j10;
        this.$contentColor = j11;
        this.$border = borderStroke;
        this.$elevation = f10;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$enabled = z10;
        this.$onClickLabel = str;
        this.$role = role;
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
        SurfaceKt.m1146Surface9VG74zQ(this.$onClick, this.$modifier, this.$shape, this.$color, this.$contentColor, this.$border, this.$elevation, this.$interactionSource, this.$indication, this.$enabled, this.$onClickLabel, this.$role, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
