package a0;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    private n() {
    }

    public /* synthetic */ n(kotlin.jvm.internal.k kVar) {
        this();
    }

    @MainThread
    public abstract boolean a(@NotNull w.i iVar);

    @WorkerThread
    public abstract boolean b();
}
