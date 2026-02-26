package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DisposableSaveableStateRegistry.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    private final /* synthetic */ SaveableStateRegistry $$delegate_0;

    @NotNull
    private final h9.a<v8.k0> onDispose;

    public DisposableSaveableStateRegistry(@NotNull SaveableStateRegistry saveableStateRegistry, @NotNull h9.a<v8.k0> onDispose) {
        kotlin.jvm.internal.t.i(saveableStateRegistry, "saveableStateRegistry");
        kotlin.jvm.internal.t.i(onDispose, "onDispose");
        this.onDispose = onDispose;
        this.$$delegate_0 = saveableStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(@NotNull Object value) {
        kotlin.jvm.internal.t.i(value, "value");
        return this.$$delegate_0.canBeSaved(value);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @Nullable
    public Object consumeRestored(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.$$delegate_0.consumeRestored(key);
    }

    public final void dispose() {
        this.onDispose.invoke();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public Map<String, List<Object>> performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public SaveableStateRegistry.Entry registerProvider(@NotNull String key, @NotNull h9.a<? extends Object> valueProvider) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(valueProvider, "valueProvider");
        return this.$$delegate_0.registerProvider(key, valueProvider);
    }
}
