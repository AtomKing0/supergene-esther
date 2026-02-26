package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldDefaults$BorderBox$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ float $focusedBorderThickness;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ TextFieldDefaults $tmp0_rcvr;
    final /* synthetic */ float $unfocusedBorderThickness;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldDefaults$BorderBox$1(TextFieldDefaults textFieldDefaults, boolean z10, boolean z11, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f10, float f11, int i10, int i11) {
        super(2);
        this.$tmp0_rcvr = textFieldDefaults;
        this.$enabled = z10;
        this.$isError = z11;
        this.$interactionSource = interactionSource;
        this.$colors = textFieldColors;
        this.$shape = shape;
        this.$focusedBorderThickness = f10;
        this.$unfocusedBorderThickness = f11;
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
        this.$tmp0_rcvr.m1190BorderBoxnbWgWpA(this.$enabled, this.$isError, this.$interactionSource, this.$colors, this.$shape, this.$focusedBorderThickness, this.$unfocusedBorderThickness, composer, this.$$changed | 1, this.$$default);
    }
}
