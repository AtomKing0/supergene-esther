package androidx.compose.ui.graphics;

/* JADX INFO: compiled from: PathMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g1 {
    public static /* synthetic */ boolean a(PathMeasure pathMeasure, float f10, float f11, Path path, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return pathMeasure.getSegment(f10, f11, path, z10);
    }
}
