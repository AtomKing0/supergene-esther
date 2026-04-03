package androidx.compose.runtime;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositionLocal.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class CompositionLocal<T> {

    @NotNull
    private final LazyValueHolder<T> defaultValueHolder;

    public /* synthetic */ CompositionLocal(h9.a aVar, k kVar) {
        this(aVar);
    }

    @Composable
    @ReadOnlyComposable
    public final T getCurrent(@Nullable Composer composer, int i10) {
        return (T) composer.consume(this);
    }

    @NotNull
    public final LazyValueHolder<T> getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }

    @Composable
    @NotNull
    public abstract State<T> provided$runtime_release(T t10, @Nullable Composer composer, int i10);

    private CompositionLocal(h9.a<? extends T> aVar) {
        this.defaultValueHolder = new LazyValueHolder<>(aVar);
    }

    public static /* synthetic */ void getCurrent$annotations() {
    }

    public static /* synthetic */ void getDefaultValueHolder$runtime_release$annotations() {
    }
}
