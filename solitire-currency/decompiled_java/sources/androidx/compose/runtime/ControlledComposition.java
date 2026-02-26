package androidx.compose.runtime;

import h9.p;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ControlledComposition extends Composition {
    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(@NotNull p<? super Composer, ? super Integer, k0> pVar);

    <R> R delegateInvalidations(@Nullable ControlledComposition controlledComposition, int i10, @NotNull h9.a<? extends R> aVar);

    @InternalComposeApi
    void disposeUnusedMovableContent(@NotNull MovableContentState movableContentState);

    boolean getHasPendingChanges();

    @InternalComposeApi
    void insertMovableContent(@NotNull List<s<MovableContentStateReference, MovableContentStateReference>> list);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(@NotNull Set<? extends Object> set);

    void prepareCompose(@NotNull h9.a<k0> aVar);

    boolean recompose();

    void recordModificationsOf(@NotNull Set<? extends Object> set);

    void recordReadOf(@NotNull Object obj);

    void recordWriteOf(@NotNull Object obj);

    @InternalComposeApi
    void verifyConsistent();
}
