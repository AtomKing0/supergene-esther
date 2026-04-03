package androidx.lifecycle.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LifecycleExt.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleExtKt {
    @Composable
    @NotNull
    public static final State<Lifecycle.State> currentStateAsState(@NotNull Lifecycle lifecycle, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1892357376);
        State<Lifecycle.State> stateCollectAsState = SnapshotStateKt.collectAsState(lifecycle.getCurrentStateFlow(), null, composer, 8, 1);
        composer.endReplaceableGroup();
        return stateCollectAsState;
    }
}
