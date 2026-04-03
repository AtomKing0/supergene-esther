package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompositionLocal.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class CompositionLocalContext {

    @NotNull
    private final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocals;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositionLocalContext(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> compositionLocals) {
        t.i(compositionLocals, "compositionLocals");
        this.compositionLocals = compositionLocals;
    }

    @NotNull
    public final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocals$runtime_release() {
        return this.compositionLocals;
    }
}
