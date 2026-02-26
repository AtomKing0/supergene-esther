package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PathMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PathMeasure {

    /* JADX INFO: compiled from: PathMeasure.kt */
    public static final class DefaultImpls {
    }

    float getLength();

    boolean getSegment(float f10, float f11, @NotNull Path path, boolean z10);

    void setPath(@Nullable Path path, boolean z10);
}
