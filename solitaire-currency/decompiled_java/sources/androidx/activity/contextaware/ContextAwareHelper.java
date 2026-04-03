package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContextAwareHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareHelper {

    @Nullable
    private volatile Context context;

    @NotNull
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final void addOnContextAvailableListener(@NotNull OnContextAvailableListener listener) {
        t.i(listener, "listener");
        Context context = this.context;
        if (context != null) {
            listener.onContextAvailable(context);
        }
        this.listeners.add(listener);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
        Iterator<OnContextAvailableListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onContextAvailable(context);
        }
    }

    @Nullable
    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(@NotNull OnContextAvailableListener listener) {
        t.i(listener, "listener");
        this.listeners.remove(listener);
    }
}
