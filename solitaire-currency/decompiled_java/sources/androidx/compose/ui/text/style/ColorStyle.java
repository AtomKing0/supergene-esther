package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.style.TextDrawStyle;
import h9.a;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextDrawStyle.kt */
/* JADX INFO: loaded from: classes.dex */
final class ColorStyle implements TextDrawStyle {
    private final long value;

    public /* synthetic */ ColorStyle(long j10, k kVar) {
        this(j10);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name */
    private final long m3557component10d7_KjU() {
        return this.value;
    }

    /* JADX INFO: renamed from: copy-8_81llA$default, reason: not valid java name */
    public static /* synthetic */ ColorStyle m3558copy8_81llA$default(ColorStyle colorStyle, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = colorStyle.value;
        }
        return colorStyle.m3559copy8_81llA(j10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-8_81llA, reason: not valid java name */
    public final ColorStyle m3559copy8_81llA(long j10) {
        return new ColorStyle(j10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorStyle) && Color.m1599equalsimpl0(this.value, ((ColorStyle) obj).value);
    }

    @Override // androidx.compose.ui.text.style.TextDrawStyle
    @Nullable
    public Brush getBrush() {
        return null;
    }

    @Override // androidx.compose.ui.text.style.TextDrawStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU */
    public long mo3556getColor0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m1605hashCodeimpl(this.value);
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
        return "ColorStyle(value=" + ((Object) Color.m1606toStringimpl(this.value)) + ')';
    }

    private ColorStyle(long j10) {
        this.value = j10;
        if (!(j10 != Color.Companion.m1634getUnspecified0d7_KjU())) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextDrawStyle.Unspecified instead.".toString());
        }
    }
}
