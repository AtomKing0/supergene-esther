package androidx.compose.runtime.saveable;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import h9.l;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SaveableStateRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateRegistryKt {

    @NotNull
    private static final ProvidableCompositionLocal<SaveableStateRegistry> LocalSaveableStateRegistry = CompositionLocalKt.staticCompositionLocalOf(SaveableStateRegistryKt$LocalSaveableStateRegistry$1.INSTANCE);

    @NotNull
    public static final SaveableStateRegistry SaveableStateRegistry(@Nullable Map<String, ? extends List<? extends Object>> map, @NotNull l<Object, Boolean> canBeSaved) {
        t.i(canBeSaved, "canBeSaved");
        return new SaveableStateRegistryImpl(map, canBeSaved);
    }

    @NotNull
    public static final ProvidableCompositionLocal<SaveableStateRegistry> getLocalSaveableStateRegistry() {
        return LocalSaveableStateRegistry;
    }
}
