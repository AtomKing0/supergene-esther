package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$CommonDecorationBox$labelColor$1 extends v implements q<InputPhase, Composer, Integer, Color> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$labelColor$1(TextFieldColors textFieldColors, boolean z10, boolean z11, InteractionSource interactionSource, int i10, int i11) {
        super(3);
        this.$colors = textFieldColors;
        this.$enabled = z10;
        this.$isError = z11;
        this.$interactionSource = interactionSource;
        this.$$dirty = i10;
        this.$$dirty1 = i11;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase, Composer composer, Integer num) {
        return Color.m1588boximpl(m1207invokeXeAY9LY(inputPhase, composer, num.intValue()));
    }

    @Composable
    /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
    public final long m1207invokeXeAY9LY(@NotNull InputPhase it, @Nullable Composer composer, int i10) {
        t.i(it, "it");
        composer.startReplaceableGroup(697243846);
        TextFieldColors textFieldColors = this.$colors;
        boolean z10 = this.$enabled;
        boolean z11 = it == InputPhase.UnfocusedEmpty ? false : this.$isError;
        InteractionSource interactionSource = this.$interactionSource;
        int i11 = (this.$$dirty >> 27) & 14;
        int i12 = this.$$dirty1;
        long jM1608unboximpl = textFieldColors.labelColor(z10, z11, interactionSource, composer, i11 | ((i12 << 3) & 896) | (i12 & 7168)).getValue().m1608unboximpl();
        composer.endReplaceableGroup();
        return jM1608unboximpl;
    }
}
