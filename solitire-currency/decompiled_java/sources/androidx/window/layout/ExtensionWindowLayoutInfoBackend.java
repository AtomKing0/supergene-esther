package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.GuardedBy;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import io.sentry.protocol.SentryStackFrame;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ExtensionWindowLayoutInfoBackend.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    @NotNull
    private final Map<Activity, MulticastConsumer> activityToListeners;

    @NotNull
    private final WindowLayoutComponent component;

    @NotNull
    private final ReentrantLock extensionWindowBackendLock;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    @NotNull
    private final Map<Consumer<WindowLayoutInfo>, Activity> listenerToActivity;

    /* JADX INFO: compiled from: ExtensionWindowLayoutInfoBackend.kt */
    @SuppressLint({"NewApi"})
    private static final class MulticastConsumer implements java.util.function.Consumer<androidx.window.extensions.layout.WindowLayoutInfo> {

        @NotNull
        private final Activity activity;

        @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
        @Nullable
        private WindowLayoutInfo lastKnownValue;

        @NotNull
        private final ReentrantLock multicastConsumerLock;

        @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
        @NotNull
        private final Set<Consumer<WindowLayoutInfo>> registeredListeners;

        public MulticastConsumer(@NotNull Activity activity) {
            t.i(activity, "activity");
            this.activity = activity;
            this.multicastConsumerLock = new ReentrantLock();
            this.registeredListeners = new LinkedHashSet();
        }

        public final void addListener(@NotNull Consumer<WindowLayoutInfo> listener) {
            t.i(listener, "listener");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                WindowLayoutInfo windowLayoutInfo = this.lastKnownValue;
                if (windowLayoutInfo != null) {
                    listener.accept(windowLayoutInfo);
                }
                this.registeredListeners.add(listener);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean isEmpty() {
            return this.registeredListeners.isEmpty();
        }

        public final void removeListener(@NotNull Consumer<WindowLayoutInfo> listener) {
            t.i(listener, "listener");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                this.registeredListeners.remove(listener);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.function.Consumer
        public void accept(@NotNull androidx.window.extensions.layout.WindowLayoutInfo value) {
            t.i(value, "value");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                this.lastKnownValue = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.activity, value);
                Iterator<T> it = this.registeredListeners.iterator();
                while (it.hasNext()) {
                    ((Consumer) it.next()).accept(this.lastKnownValue);
                }
                k0 k0Var = k0.f35197a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public ExtensionWindowLayoutInfoBackend(@NotNull WindowLayoutComponent component) {
        t.i(component, "component");
        this.component = component;
        this.extensionWindowBackendLock = new ReentrantLock();
        this.activityToListeners = new LinkedHashMap();
        this.listenerToActivity = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<WindowLayoutInfo> callback) {
        k0 k0Var;
        t.i(activity, "activity");
        t.i(executor, "executor");
        t.i(callback, "callback");
        ReentrantLock reentrantLock = this.extensionWindowBackendLock;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = this.activityToListeners.get(activity);
            if (multicastConsumer == null) {
                k0Var = null;
            } else {
                multicastConsumer.addListener(callback);
                this.listenerToActivity.put(callback, activity);
                k0Var = k0.f35197a;
            }
            if (k0Var == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(activity);
                this.activityToListeners.put(activity, multicastConsumer2);
                this.listenerToActivity.put(callback, activity);
                multicastConsumer2.addListener(callback);
                this.component.addWindowLayoutInfoListener(activity, multicastConsumer2);
            }
            k0 k0Var2 = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(@NotNull Consumer<WindowLayoutInfo> callback) {
        t.i(callback, "callback");
        ReentrantLock reentrantLock = this.extensionWindowBackendLock;
        reentrantLock.lock();
        try {
            Activity activity = this.listenerToActivity.get(callback);
            if (activity == null) {
                return;
            }
            MulticastConsumer multicastConsumer = this.activityToListeners.get(activity);
            if (multicastConsumer == null) {
                return;
            }
            multicastConsumer.removeListener(callback);
            if (multicastConsumer.isEmpty()) {
                this.component.removeWindowLayoutInfoListener(multicastConsumer);
            }
            k0 k0Var = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
