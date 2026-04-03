package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionData;
import h9.p;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: CompositionContext.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class CompositionContext {
    public static final int $stable = 0;

    public abstract void composeInitial$runtime_release(@NotNull ControlledComposition controlledComposition, @NotNull p<? super Composer, ? super Integer, k0> pVar);

    public abstract void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference);

    public abstract boolean getCollectingParameterInformation$runtime_release();

    @NotNull
    public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
        return CompositionContextKt.EmptyCompositionLocalMap;
    }

    public abstract int getCompoundHashKey$runtime_release();

    @NotNull
    public abstract g getEffectCoroutineContext$runtime_release();

    @NotNull
    public abstract g getRecomposeCoroutineContext$runtime_release();

    public abstract void insertMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference);

    public abstract void invalidate$runtime_release(@NotNull ControlledComposition controlledComposition);

    public abstract void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl recomposeScopeImpl);

    public abstract void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference movableContentStateReference, @NotNull MovableContentState movableContentState);

    @Nullable
    public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference reference) {
        t.i(reference, "reference");
        return null;
    }

    public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> table) {
        t.i(table, "table");
    }

    public void registerComposer$runtime_release(@NotNull Composer composer) {
        t.i(composer, "composer");
    }

    public abstract void registerComposition$runtime_release(@NotNull ControlledComposition controlledComposition);

    public void unregisterComposer$runtime_release(@NotNull Composer composer) {
        t.i(composer, "composer");
    }

    public abstract void unregisterComposition$runtime_release(@NotNull ControlledComposition controlledComposition);

    public void doneComposing$runtime_release() {
    }

    public void startComposing$runtime_release() {
    }
}
