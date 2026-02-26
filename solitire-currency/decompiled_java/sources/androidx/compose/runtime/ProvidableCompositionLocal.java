package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompositionLocal.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableCompositionLocal(@NotNull h9.a<? extends T> defaultFactory) {
        super(defaultFactory, null);
        t.i(defaultFactory, "defaultFactory");
    }

    @NotNull
    public final ProvidedValue<T> provides(T t10) {
        return new ProvidedValue<>(this, t10, true);
    }

    @NotNull
    public final ProvidedValue<T> providesDefault(T t10) {
        return new ProvidedValue<>(this, t10, false);
    }
}
