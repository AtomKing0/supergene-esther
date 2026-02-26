package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidPathMeasure.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathMeasure implements PathMeasure {

    @NotNull
    private final android.graphics.PathMeasure internalPathMeasure;

    public AndroidPathMeasure(@NotNull android.graphics.PathMeasure internalPathMeasure) {
        kotlin.jvm.internal.t.i(internalPathMeasure, "internalPathMeasure");
        this.internalPathMeasure = internalPathMeasure;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public boolean getSegment(float f10, float f11, @NotNull Path destination, boolean z10) {
        kotlin.jvm.internal.t.i(destination, "destination");
        android.graphics.PathMeasure pathMeasure = this.internalPathMeasure;
        if (destination instanceof AndroidPath) {
            return pathMeasure.getSegment(f10, f11, ((AndroidPath) destination).getInternalPath(), z10);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public void setPath(@Nullable Path path, boolean z10) {
        android.graphics.Path internalPath;
        android.graphics.PathMeasure pathMeasure = this.internalPathMeasure;
        if (path == null) {
            internalPath = null;
        } else {
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            internalPath = ((AndroidPath) path).getInternalPath();
        }
        pathMeasure.setPath(internalPath, z10);
    }
}
