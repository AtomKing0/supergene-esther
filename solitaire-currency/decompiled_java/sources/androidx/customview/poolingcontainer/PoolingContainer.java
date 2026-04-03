package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PoolingContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PoolingContainer {
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener listener) {
        t.i(view, "<this>");
        t.i(listener, "listener");
        getPoolingContainerListenerHolder(view).addListener(listener);
    }

    public static final void callPoolingContainerOnRelease(@NotNull View view) {
        t.i(view, "<this>");
        Iterator<View> it = ViewKt.getAllViews(view).iterator();
        while (it.hasNext()) {
            getPoolingContainerListenerHolder(it.next()).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(@NotNull ViewGroup viewGroup) {
        t.i(viewGroup, "<this>");
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (it.hasNext()) {
            getPoolingContainerListenerHolder(it.next()).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        int i10 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i10);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i10, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean isPoolingContainer(@NotNull View view) {
        t.i(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(@NotNull View view) {
        t.i(view, "<this>");
        for (Object obj : ViewKt.getAncestors(view)) {
            if ((obj instanceof View) && isPoolingContainer((View) obj)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener listener) {
        t.i(view, "<this>");
        t.i(listener, "listener");
        getPoolingContainerListenerHolder(view).removeListener(listener);
    }

    public static final void setPoolingContainer(@NotNull View view, boolean z10) {
        t.i(view, "<this>");
        view.setTag(IsPoolingContainerTag, Boolean.valueOf(z10));
    }
}
