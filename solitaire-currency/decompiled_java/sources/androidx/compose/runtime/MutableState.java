package androidx.compose.runtime;

import h9.l;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SnapshotState.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableState<T> extends State<T> {
    T component1();

    @NotNull
    l<T, k0> component2();

    @Override // androidx.compose.runtime.State
    T getValue();

    void setValue(T t10);
}
