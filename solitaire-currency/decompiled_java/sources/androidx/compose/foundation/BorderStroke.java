package androidx.compose.foundation;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BorderStroke.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BorderStroke {

    @NotNull
    private final Brush brush;
    private final float width;

    public /* synthetic */ BorderStroke(float f10, Brush brush, kotlin.jvm.internal.k kVar) {
        this(f10, brush);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m177copyD5KLDUw$default(BorderStroke borderStroke, float f10, Brush brush, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = borderStroke.width;
        }
        if ((i10 & 2) != 0) {
            brush = borderStroke.brush;
        }
        return borderStroke.m178copyD5KLDUw(f10, brush);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStroke m178copyD5KLDUw(float f10, @NotNull Brush brush) {
        t.i(brush, "brush");
        return new BorderStroke(f10, brush, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        return Dp.m3678equalsimpl0(this.width, borderStroke.width) && t.d(this.brush, borderStroke.brush);
    }

    @NotNull
    public final Brush getBrush() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m179getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m3679hashCodeimpl(this.width) * 31) + this.brush.hashCode();
    }

    @NotNull
    public String toString() {
        return "BorderStroke(width=" + ((Object) Dp.m3684toStringimpl(this.width)) + ", brush=" + this.brush + ')';
    }

    private BorderStroke(float f10, Brush brush) {
        this.width = f10;
        this.brush = brush;
    }
}
