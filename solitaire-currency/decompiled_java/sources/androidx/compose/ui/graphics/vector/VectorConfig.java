package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes.dex */
public interface VectorConfig {

    /* JADX INFO: compiled from: VectorPainter.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T getOrDefault(@NotNull VectorConfig vectorConfig, @NotNull VectorProperty<T> property, T t10) {
            t.i(property, "property");
            return (T) a.a(vectorConfig, property, t10);
        }
    }

    <T> T getOrDefault(@NotNull VectorProperty<T> vectorProperty, T t10);
}
