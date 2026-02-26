package androidx.compose.ui.node;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Ref.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Ref<T> {
    public static final int $stable = 8;

    @Nullable
    private T value;

    @Nullable
    public final T getValue() {
        return this.value;
    }

    public final void setValue(@Nullable T t10) {
        this.value = t10;
    }
}
