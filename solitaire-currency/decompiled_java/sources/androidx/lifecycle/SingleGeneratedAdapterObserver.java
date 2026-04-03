package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SingleGeneratedAdapterObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    @NotNull
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(@NotNull GeneratedAdapter generatedAdapter) {
        t.i(generatedAdapter, "generatedAdapter");
        this.generatedAdapter = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        t.i(source, "source");
        t.i(event, "event");
        this.generatedAdapter.callMethods(source, event, false, null);
        this.generatedAdapter.callMethods(source, event, true, null);
    }
}
