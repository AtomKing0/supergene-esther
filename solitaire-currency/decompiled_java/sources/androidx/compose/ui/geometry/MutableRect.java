package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MutableRect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MutableRect {
    private float bottom;
    private float left;
    private float right;
    private float top;

    public MutableRect(float f10, float f11, float f12, float f13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m1354containsk4lQ0M(long j10) {
        return Offset.m1367getXimpl(j10) >= this.left && Offset.m1367getXimpl(j10) < this.right && Offset.m1368getYimpl(j10) >= this.top && Offset.m1368getYimpl(j10) < this.bottom;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getHeight() {
        return getBottom() - getTop();
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m1355getSizeNHjbRc() {
        return SizeKt.Size(getRight() - getLeft(), getBottom() - getTop());
    }

    public final float getTop() {
        return this.top;
    }

    public final float getWidth() {
        return getRight() - getLeft();
    }

    @Stable
    public final void intersect(float f10, float f11, float f12, float f13) {
        this.left = Math.max(f10, this.left);
        this.top = Math.max(f11, this.top);
        this.right = Math.min(f12, this.right);
        this.bottom = Math.min(f13, this.bottom);
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final void set(float f10, float f11, float f12, float f13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
    }

    public final void setBottom(float f10) {
        this.bottom = f10;
    }

    public final void setLeft(float f10) {
        this.left = f10;
    }

    public final void setRight(float f10) {
        this.right = f10;
    }

    public final void setTop(float f10) {
        this.top = f10;
    }

    @NotNull
    public String toString() {
        return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }
}
