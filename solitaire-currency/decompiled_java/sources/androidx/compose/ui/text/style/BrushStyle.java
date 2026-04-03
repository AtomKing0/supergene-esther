package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.style.TextDrawStyle;
import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextDrawStyle.kt */
/* JADX INFO: loaded from: classes.dex */
final class BrushStyle implements TextDrawStyle {

    @NotNull
    private final ShaderBrush value;

    public BrushStyle(@NotNull ShaderBrush value) {
        t.i(value, "value");
        this.value = value;
    }

    private final ShaderBrush component1() {
        return this.value;
    }

    public static /* synthetic */ BrushStyle copy$default(BrushStyle brushStyle, ShaderBrush shaderBrush, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            shaderBrush = brushStyle.value;
        }
        return brushStyle.copy(shaderBrush);
    }

    @NotNull
    public final BrushStyle copy(@NotNull ShaderBrush value) {
        t.i(value, "value");
        return new BrushStyle(value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrushStyle) && t.d(this.value, ((BrushStyle) obj).value);
    }

    @Override // androidx.compose.ui.text.style.TextDrawStyle
    @NotNull
    public Brush getBrush() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextDrawStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long mo3556getColor0d7_KjU() {
        return Color.Companion.m1634getUnspecified0d7_KjU();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // androidx.compose.ui.text.style.TextDrawStyle
    public /* synthetic */ TextDrawStyle merge(TextDrawStyle textDrawStyle) {
        return TextDrawStyle.CC.a(this, textDrawStyle);
    }

    @Override // androidx.compose.ui.text.style.TextDrawStyle
    public /* synthetic */ TextDrawStyle takeOrElse(a aVar) {
        return TextDrawStyle.CC.b(this, aVar);
    }

    @NotNull
    public String toString() {
        return "BrushStyle(value=" + this.value + ')';
    }
}
