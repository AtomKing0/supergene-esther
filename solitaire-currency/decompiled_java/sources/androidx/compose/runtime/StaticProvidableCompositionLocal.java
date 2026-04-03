package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositionLocal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StaticProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticProvidableCompositionLocal(@NotNull h9.a<? extends T> defaultFactory) {
        super(defaultFactory);
        t.i(defaultFactory, "defaultFactory");
    }

    @Override // androidx.compose.runtime.CompositionLocal
    @Composable
    @NotNull
    public State<T> provided$runtime_release(T t10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1121811719);
        StaticValueHolder staticValueHolder = new StaticValueHolder(t10);
        composer.endReplaceableGroup();
        return staticValueHolder;
    }
}
