package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
public final class ProvidedValue<T> {
    public static final int $stable = 0;
    private final boolean canOverride;

    @NotNull
    private final CompositionLocal<T> compositionLocal;
    private final T value;

    public ProvidedValue(@NotNull CompositionLocal<T> compositionLocal, T t10, boolean z10) {
        t.i(compositionLocal, "compositionLocal");
        this.compositionLocal = compositionLocal;
        this.value = t10;
        this.canOverride = z10;
    }

    public final boolean getCanOverride() {
        return this.canOverride;
    }

    @NotNull
    public final CompositionLocal<T> getCompositionLocal() {
        return this.compositionLocal;
    }

    public final T getValue() {
        return this.value;
    }
}
