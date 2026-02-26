package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.PathMeasure;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
final class PathComponent$pathMeasure$2 extends v implements h9.a<PathMeasure> {
    public static final PathComponent$pathMeasure$2 INSTANCE = new PathComponent$pathMeasure$2();

    PathComponent$pathMeasure$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final PathMeasure invoke() {
        return AndroidPathMeasure_androidKt.PathMeasure();
    }
}
