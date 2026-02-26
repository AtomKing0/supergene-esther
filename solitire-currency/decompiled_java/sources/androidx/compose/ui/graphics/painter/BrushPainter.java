package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrushPainter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BrushPainter extends Painter {
    private float alpha;

    @NotNull
    private final Brush brush;

    @Nullable
    private ColorFilter colorFilter;

    public BrushPainter(@NotNull Brush brush) {
        t.i(brush, "brush");
        this.brush = brush;
        this.alpha = 1.0f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f10) {
        this.alpha = f10;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrushPainter) && t.d(this.brush, ((BrushPainter) obj).brush);
    }

    @NotNull
    public final Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2089getIntrinsicSizeNHjbRc() {
        return this.brush.mo1552getIntrinsicSizeNHjbRc();
    }

    public int hashCode() {
        return this.brush.hashCode();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        b.J(drawScope, this.brush, 0L, 0L, this.alpha, null, this.colorFilter, 0, 86, null);
    }

    @NotNull
    public String toString() {
        return "BrushPainter(brush=" + this.brush + ')';
    }
}
