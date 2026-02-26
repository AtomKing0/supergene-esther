package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PoolingContainer.kt */
/* JADX INFO: loaded from: classes.dex */
final class PoolingContainerListenerHolder {

    @NotNull
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(@NotNull PoolingContainerListener listener) {
        t.i(listener, "listener");
        this.listeners.add(listener);
    }

    public final void onRelease() {
        for (int iM = v.m(this.listeners); -1 < iM; iM--) {
            this.listeners.get(iM).onRelease();
        }
    }

    public final void removeListener(@NotNull PoolingContainerListener listener) {
        t.i(listener, "listener");
        this.listeners.remove(listener);
    }
}
