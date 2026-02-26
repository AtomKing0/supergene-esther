package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RememberSaveable.kt */
/* JADX INFO: loaded from: classes.dex */
final class RememberSaveableKt$mutableStateSaver$1$2<T> extends v implements l<MutableState<Object>, MutableState<T>> {
    final /* synthetic */ Saver<T, Object> $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$mutableStateSaver$1$2(Saver<T, Object> saver) {
        super(1);
        this.$this_with = saver;
    }

    @Override // h9.l
    @Nullable
    public final MutableState<T> invoke(@NotNull MutableState<Object> it) {
        T tRestore;
        t.i(it, "it");
        if (!(it instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (it.getValue() != null) {
            Saver<T, Object> saver = this.$this_with;
            Object value = it.getValue();
            t.f(value);
            tRestore = saver.restore(value);
        } else {
            tRestore = null;
        }
        return SnapshotStateKt.mutableStateOf(tRestore, ((SnapshotMutableState) it).getPolicy());
    }
}
