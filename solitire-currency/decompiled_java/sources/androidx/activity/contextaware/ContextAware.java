package androidx.activity.contextaware;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ContextAware {
    void addOnContextAvailableListener(@NotNull OnContextAvailableListener onContextAvailableListener);

    @Nullable
    Context peekAvailableContext();

    void removeOnContextAvailableListener(@NotNull OnContextAvailableListener onContextAvailableListener);
}
