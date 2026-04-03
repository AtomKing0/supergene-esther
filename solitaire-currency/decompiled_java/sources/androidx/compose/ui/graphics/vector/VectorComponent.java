package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VectorComponent extends VNode {

    @NotNull
    private final DrawCache cacheDrawScope;

    @NotNull
    private final l<DrawScope, k0> drawVectorBlock;

    @NotNull
    private final MutableState intrinsicColorFilter$delegate;

    @NotNull
    private h9.a<k0> invalidateCallback;
    private boolean isDirty;
    private long previousDrawSize;

    @NotNull
    private final GroupComponent root;
    private float viewportHeight;
    private float viewportWidth;

    public VectorComponent() {
        super(null);
        GroupComponent groupComponent = new GroupComponent();
        groupComponent.setPivotX(0.0f);
        groupComponent.setPivotY(0.0f);
        groupComponent.setInvalidateListener$ui_release(new VectorComponent$root$1$1(this));
        this.root = groupComponent;
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
        this.intrinsicColorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousDrawSize = Size.Companion.m1444getUnspecifiedNHjbRc();
        this.drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final void draw(@NotNull DrawScope drawScope, float f10, @Nullable ColorFilter colorFilter) {
        t.i(drawScope, "<this>");
        if (colorFilter == null) {
            colorFilter = getIntrinsicColorFilter$ui_release();
        }
        if (this.isDirty || !Size.m1432equalsimpl0(this.previousDrawSize, drawScope.mo1996getSizeNHjbRc())) {
            this.root.setScaleX(Size.m1436getWidthimpl(drawScope.mo1996getSizeNHjbRc()) / this.viewportWidth);
            this.root.setScaleY(Size.m1433getHeightimpl(drawScope.mo1996getSizeNHjbRc()) / this.viewportHeight);
            this.cacheDrawScope.m2096drawCachedImageCJJARo(IntSizeKt.IntSize((int) Math.ceil(Size.m1436getWidthimpl(drawScope.mo1996getSizeNHjbRc())), (int) Math.ceil(Size.m1433getHeightimpl(drawScope.mo1996getSizeNHjbRc()))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo1996getSizeNHjbRc();
        }
        this.cacheDrawScope.drawInto(drawScope, f10, colorFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter$delegate.getValue();
    }

    @NotNull
    public final h9.a<k0> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    @NotNull
    public final String getName() {
        return this.root.getName();
    }

    @NotNull
    public final GroupComponent getRoot() {
        return this.root;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.intrinsicColorFilter$delegate.setValue(colorFilter);
    }

    public final void setInvalidateCallback$ui_release(@NotNull h9.a<k0> aVar) {
        t.i(aVar, "<set-?>");
        this.invalidateCallback = aVar;
    }

    public final void setName(@NotNull String value) {
        t.i(value, "value");
        this.root.setName(value);
    }

    public final void setViewportHeight(float f10) {
        if (this.viewportHeight == f10) {
            return;
        }
        this.viewportHeight = f10;
        doInvalidate();
    }

    public final void setViewportWidth(float f10) {
        if (this.viewportWidth == f10) {
            return;
        }
        this.viewportWidth = f10;
        doInvalidate();
    }

    @NotNull
    public String toString() {
        String str = "Params: \tname: " + getName() + "\n\tviewportWidth: " + this.viewportWidth + "\n\tviewportHeight: " + this.viewportHeight + "\n";
        t.h(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        draw(drawScope, 1.0f, null);
    }
}
