package androidx.compose.runtime.tooling;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompositionData.kt */
/* JADX INFO: loaded from: classes.dex */
public interface CompositionData {
    @NotNull
    Iterable<CompositionGroup> getCompositionGroups();

    boolean isEmpty();
}
