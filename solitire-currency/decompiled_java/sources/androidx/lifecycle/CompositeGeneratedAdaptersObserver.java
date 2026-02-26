package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompositeGeneratedAdaptersObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {

    @NotNull
    private final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(@NotNull GeneratedAdapter[] generatedAdapters) {
        t.i(generatedAdapters, "generatedAdapters");
        this.generatedAdapters = generatedAdapters;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        t.i(source, "source");
        t.i(event, "event");
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter generatedAdapter : this.generatedAdapters) {
            generatedAdapter.callMethods(source, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter generatedAdapter2 : this.generatedAdapters) {
            generatedAdapter2.callMethods(source, event, true, methodCallsLogger);
        }
    }
}
