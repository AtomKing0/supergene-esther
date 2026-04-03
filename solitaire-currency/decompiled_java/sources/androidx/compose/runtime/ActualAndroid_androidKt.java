package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: ActualAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActualAndroid_androidKt {

    @NotNull
    private static final l DefaultMonotonicFrameClock$delegate = n.a(ActualAndroid_androidKt$DefaultMonotonicFrameClock$2.INSTANCE);
    private static final boolean DisallowDefaultMonotonicFrameClock = false;

    @NotNull
    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T t10, @NotNull SnapshotMutationPolicy<T> policy) {
        t.i(policy, "policy");
        return new ParcelableSnapshotMutableState(t10, policy);
    }

    @NotNull
    public static final MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return (MonotonicFrameClock) DefaultMonotonicFrameClock$delegate.getValue();
    }

    public static /* synthetic */ void getDefaultMonotonicFrameClock$annotations() {
    }
}
