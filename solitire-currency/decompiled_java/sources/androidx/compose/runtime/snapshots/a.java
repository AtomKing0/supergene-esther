package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    @Nullable
    public static StateRecord a(StateObject stateObject, @NotNull StateRecord previous, @NotNull StateRecord current, @NotNull StateRecord applied) {
        t.i(previous, "previous");
        t.i(current, "current");
        t.i(applied, "applied");
        return null;
    }
}
