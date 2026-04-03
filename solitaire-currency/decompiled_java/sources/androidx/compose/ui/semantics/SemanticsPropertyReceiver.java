package androidx.compose.ui.semantics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SemanticsPropertyReceiver {
    <T> void set(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, T t10);
}
