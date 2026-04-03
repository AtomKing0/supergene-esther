package androidx.work;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputMerger.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InputMerger {
    @NotNull
    public abstract Data merge(@NotNull List<Data> list);
}
