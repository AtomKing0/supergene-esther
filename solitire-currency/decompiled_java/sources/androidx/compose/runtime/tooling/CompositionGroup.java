package androidx.compose.runtime.tooling;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositionData.kt */
/* JADX INFO: loaded from: classes.dex */
public interface CompositionGroup extends CompositionData {

    /* JADX INFO: compiled from: CompositionData.kt */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object getIdentity(@NotNull CompositionGroup compositionGroup) {
            return a.a(compositionGroup);
        }
    }

    @NotNull
    Iterable<Object> getData();

    @Nullable
    Object getIdentity();

    @NotNull
    Object getKey();

    @Nullable
    Object getNode();

    @Nullable
    String getSourceInfo();
}
