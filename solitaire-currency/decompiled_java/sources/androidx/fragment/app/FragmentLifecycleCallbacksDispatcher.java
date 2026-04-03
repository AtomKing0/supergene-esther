package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentLifecycleCallbacksDispatcher {

    @NotNull
    private final FragmentManager fragmentManager;

    @NotNull
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> lifecycleCallbacks;

    /* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.kt */
    private static final class FragmentLifecycleCallbacksHolder {

        @NotNull
        private final FragmentManager.FragmentLifecycleCallbacks callback;
        private final boolean recursive;

        public FragmentLifecycleCallbacksHolder(@NotNull FragmentManager.FragmentLifecycleCallbacks callback, boolean z10) {
            kotlin.jvm.internal.t.i(callback, "callback");
            this.callback = callback;
            this.recursive = z10;
        }

        @NotNull
        public final FragmentManager.FragmentLifecycleCallbacks getCallback() {
            return this.callback;
        }

        public final boolean getRecursive() {
            return this.recursive;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(@NotNull FragmentManager fragmentManager) {
        kotlin.jvm.internal.t.i(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.lifecycleCallbacks = new CopyOnWriteArrayList<>();
    }

    public final void dispatchOnFragmentActivityCreated(@NotNull Fragment f10, @Nullable Bundle bundle, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(f10, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentActivityCreated(this.fragmentManager, f10, bundle);
            }
        }
    }

    public final void dispatchOnFragmentAttached(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Context context = this.fragmentManager.getHost().getContext();
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentAttached(this.fragmentManager, f10, context);
            }
        }
    }

    public final void dispatchOnFragmentCreated(@NotNull Fragment f10, @Nullable Bundle bundle, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(f10, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentCreated(this.fragmentManager, f10, bundle);
            }
        }
    }

    public final void dispatchOnFragmentDestroyed(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentDestroyed(this.fragmentManager, f10);
            }
        }
    }

    public final void dispatchOnFragmentDetached(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentDetached(this.fragmentManager, f10);
            }
        }
    }

    public final void dispatchOnFragmentPaused(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentPaused(this.fragmentManager, f10);
            }
        }
    }

    public final void dispatchOnFragmentPreAttached(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Context context = this.fragmentManager.getHost().getContext();
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentPreAttached(this.fragmentManager, f10, context);
            }
        }
    }

    public final void dispatchOnFragmentPreCreated(@NotNull Fragment f10, @Nullable Bundle bundle, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(f10, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentPreCreated(this.fragmentManager, f10, bundle);
            }
        }
    }

    public final void dispatchOnFragmentResumed(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentResumed(this.fragmentManager, f10);
            }
        }
    }

    public final void dispatchOnFragmentSaveInstanceState(@NotNull Fragment f10, @NotNull Bundle outState, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        kotlin.jvm.internal.t.i(outState, "outState");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(f10, outState, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentSaveInstanceState(this.fragmentManager, f10, outState);
            }
        }
    }

    public final void dispatchOnFragmentStarted(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentStarted(this.fragmentManager, f10);
            }
        }
    }

    public final void dispatchOnFragmentStopped(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentStopped(this.fragmentManager, f10);
            }
        }
    }

    public final void dispatchOnFragmentViewCreated(@NotNull Fragment f10, @NotNull View v10, @Nullable Bundle bundle, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        kotlin.jvm.internal.t.i(v10, "v");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(f10, v10, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentViewCreated(this.fragmentManager, f10, v10, bundle);
            }
        }
    }

    public final void dispatchOnFragmentViewDestroyed(@NotNull Fragment f10, boolean z10) {
        kotlin.jvm.internal.t.i(f10, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            kotlin.jvm.internal.t.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(f10, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z10 || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentViewDestroyed(this.fragmentManager, f10);
            }
        }
    }

    public final void registerFragmentLifecycleCallbacks(@NotNull FragmentManager.FragmentLifecycleCallbacks cb2, boolean z10) {
        kotlin.jvm.internal.t.i(cb2, "cb");
        this.lifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(cb2, z10));
    }

    public final void unregisterFragmentLifecycleCallbacks(@NotNull FragmentManager.FragmentLifecycleCallbacks cb2) {
        kotlin.jvm.internal.t.i(cb2, "cb");
        synchronized (this.lifecycleCallbacks) {
            int size = this.lifecycleCallbacks.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (this.lifecycleCallbacks.get(i10).getCallback() == cb2) {
                    this.lifecycleCallbacks.remove(i10);
                    break;
                }
                i10++;
            }
            k0 k0Var = k0.f35197a;
        }
    }
}
