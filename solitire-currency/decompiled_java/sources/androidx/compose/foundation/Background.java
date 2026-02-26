package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Background.kt */
/* JADX INFO: loaded from: classes.dex */
final class Background extends InspectorValueInfo implements DrawModifier {
    private final float alpha;

    @Nullable
    private final Brush brush;

    @Nullable
    private final Color color;

    @Nullable
    private LayoutDirection lastLayoutDirection;

    @Nullable
    private Outline lastOutline;

    @Nullable
    private Size lastSize;

    @NotNull
    private final Shape shape;

    public /* synthetic */ Background(Color color, Brush brush, float f10, Shape shape, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(color, brush, f10, shape, lVar);
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline outlineMo201createOutlinePq9zytI;
        if (Size.m1431equalsimpl(contentDrawScope.mo1996getSizeNHjbRc(), this.lastSize) && contentDrawScope.getLayoutDirection() == this.lastLayoutDirection) {
            outlineMo201createOutlinePq9zytI = this.lastOutline;
            t.f(outlineMo201createOutlinePq9zytI);
        } else {
            outlineMo201createOutlinePq9zytI = this.shape.mo201createOutlinePq9zytI(contentDrawScope.mo1996getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        Color color = this.color;
        if (color != null) {
            color.m1608unboximpl();
            OutlineKt.m1803drawOutlinewDX37Ww(contentDrawScope, outlineMo201createOutlinePq9zytI, this.color.m1608unboximpl(), (60 & 4) != 0 ? 1.0f : 0.0f, (60 & 8) != 0 ? Fill.INSTANCE : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU() : 0);
        }
        Brush brush = this.brush;
        if (brush != null) {
            OutlineKt.m1802drawOutlinehn5TExg$default(contentDrawScope, outlineMo201createOutlinePq9zytI, brush, this.alpha, null, null, 0, 56, null);
        }
        this.lastOutline = outlineMo201createOutlinePq9zytI;
        this.lastSize = Size.m1424boximpl(contentDrawScope.mo1996getSizeNHjbRc());
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        Color color = this.color;
        if (color != null) {
            androidx.compose.ui.graphics.drawscope.b.K(contentDrawScope, color.m1608unboximpl(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        Brush brush = this.brush;
        if (brush != null) {
            androidx.compose.ui.graphics.drawscope.b.J(contentDrawScope, brush, 0L, 0L, this.alpha, null, null, 0, 118, null);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        t.i(contentDrawScope, "<this>");
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        Background background = obj instanceof Background ? (Background) obj : null;
        if (background != null && t.d(this.color, background.color) && t.d(this.brush, background.brush)) {
            return ((this.alpha > background.alpha ? 1 : (this.alpha == background.alpha ? 0 : -1)) == 0) && t.d(this.shape, background.shape);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    public int hashCode() {
        Color color = this.color;
        int iM1605hashCodeimpl = (color != null ? Color.m1605hashCodeimpl(color.m1608unboximpl()) : 0) * 31;
        Brush brush = this.brush;
        return ((((iM1605hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.shape.hashCode();
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "Background(color=" + this.color + ", brush=" + this.brush + ", alpha = " + this.alpha + ", shape=" + this.shape + ')';
    }

    public /* synthetic */ Background(Color color, Brush brush, float f10, Shape shape, h9.l lVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : color, (i10 & 2) != 0 ? null : brush, (i10 & 4) != 0 ? 1.0f : f10, shape, lVar, null);
    }

    private Background(Color color, Brush brush, float f10, Shape shape, h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
        this.color = color;
        this.brush = brush;
        this.alpha = f10;
        this.shape = shape;
    }
}
