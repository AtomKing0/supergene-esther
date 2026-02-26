package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GroupComponent extends VNode {

    @NotNull
    private final List<VNode> children;

    @Nullable
    private Path clipPath;

    @NotNull
    private List<? extends PathNode> clipPathData;

    @Nullable
    private float[] groupMatrix;

    @Nullable
    private h9.a<k0> invalidateListener;
    private boolean isClipPathDirty;
    private boolean isMatrixDirty;

    @NotNull
    private String name;

    @Nullable
    private PathParser parser;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;

    public GroupComponent() {
        super(null);
        this.children = new ArrayList();
        this.clipPathData = VectorKt.getEmptyPath();
        this.isClipPathDirty = true;
        this.name = "";
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.isMatrixDirty = true;
    }

    private final boolean getWillClipPath() {
        return !this.clipPathData.isEmpty();
    }

    private final void updateClipPath() {
        if (getWillClipPath()) {
            PathParser pathParser = this.parser;
            if (pathParser == null) {
                pathParser = new PathParser();
                this.parser = pathParser;
            } else {
                pathParser.clear();
            }
            Path Path = this.clipPath;
            if (Path == null) {
                Path = AndroidPath_androidKt.Path();
                this.clipPath = Path;
            } else {
                Path.reset();
            }
            pathParser.addPathNodes(this.clipPathData).toPath(Path);
        }
    }

    private final void updateMatrix() {
        float[] fArrM1776constructorimpl$default = this.groupMatrix;
        if (fArrM1776constructorimpl$default == null) {
            fArrM1776constructorimpl$default = Matrix.m1776constructorimpl$default(null, 1, null);
            this.groupMatrix = fArrM1776constructorimpl$default;
        } else {
            Matrix.m1785resetimpl(fArrM1776constructorimpl$default);
        }
        Matrix.m1796translateimpl$default(fArrM1776constructorimpl$default, this.pivotX + this.translationX, this.pivotY + this.translationY, 0.0f, 4, null);
        Matrix.m1788rotateZimpl(fArrM1776constructorimpl$default, this.rotation);
        Matrix.m1789scaleimpl(fArrM1776constructorimpl$default, this.scaleX, this.scaleY, 1.0f);
        Matrix.m1796translateimpl$default(fArrM1776constructorimpl$default, -this.pivotX, -this.pivotY, 0.0f, 4, null);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        if (this.isMatrixDirty) {
            updateMatrix();
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            updateClipPath();
            this.isClipPathDirty = false;
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        float[] fArr = this.groupMatrix;
        if (fArr != null) {
            transform.mo2010transform58bKbWc(Matrix.m1774boximpl(fArr).m1797unboximpl());
        }
        Path path = this.clipPath;
        if (getWillClipPath() && path != null) {
            c.c(transform, path, 0, 2, null);
        }
        List<VNode> list = this.children;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).draw(drawScope);
        }
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    @NotNull
    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    @Nullable
    public h9.a<k0> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void insertAt(int i10, @NotNull VNode instance) {
        t.i(instance, "instance");
        if (i10 < getNumChildren()) {
            this.children.set(i10, instance);
        } else {
            this.children.add(instance);
        }
        instance.setInvalidateListener$ui_release(getInvalidateListener$ui_release());
        invalidate();
    }

    public final void move(int i10, int i11, int i12) {
        int i13 = 0;
        if (i10 > i11) {
            while (i13 < i12) {
                VNode vNode = this.children.get(i10);
                this.children.remove(i10);
                this.children.add(i11, vNode);
                i11++;
                i13++;
            }
        } else {
            while (i13 < i12) {
                VNode vNode2 = this.children.get(i10);
                this.children.remove(i10);
                this.children.add(i11 - 1, vNode2);
                i13++;
            }
        }
        invalidate();
    }

    public final void remove(int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (i10 < this.children.size()) {
                this.children.get(i10).setInvalidateListener$ui_release(null);
                this.children.remove(i10);
            }
        }
        invalidate();
    }

    public final void setClipPathData(@NotNull List<? extends PathNode> value) {
        t.i(value, "value");
        this.clipPathData = value;
        this.isClipPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void setInvalidateListener$ui_release(@Nullable h9.a<k0> aVar) {
        this.invalidateListener = aVar;
        List<VNode> list = this.children;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).setInvalidateListener$ui_release(aVar);
        }
    }

    public final void setName(@NotNull String value) {
        t.i(value, "value");
        this.name = value;
        invalidate();
    }

    public final void setPivotX(float f10) {
        this.pivotX = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setPivotY(float f10) {
        this.pivotY = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setRotation(float f10) {
        this.rotation = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleX(float f10) {
        this.scaleX = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleY(float f10) {
        this.scaleY = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationX(float f10) {
        this.translationX = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationY(float f10) {
        this.translationY = f10;
        this.isMatrixDirty = true;
        invalidate();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VGroup: ");
        sb.append(this.name);
        List<VNode> list = this.children;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            VNode vNode = list.get(i10);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        String string = sb.toString();
        t.h(string, "sb.toString()");
        return string;
    }
}
