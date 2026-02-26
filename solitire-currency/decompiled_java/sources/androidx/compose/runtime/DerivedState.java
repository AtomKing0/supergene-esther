package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateObject;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DerivedState.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DerivedState<T> extends State<T> {
    T getCurrentValue();

    @NotNull
    Set<StateObject> getDependencies();
}
