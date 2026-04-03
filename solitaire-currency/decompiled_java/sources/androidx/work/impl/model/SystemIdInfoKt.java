package androidx.work.impl.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SystemIdInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemIdInfoKt {
    @NotNull
    public static final SystemIdInfo systemIdInfo(@NotNull WorkGenerationalId generationalId, int i10) {
        t.i(generationalId, "generationalId");
        return new SystemIdInfo(generationalId.getWorkSpecId(), generationalId.getGeneration(), i10);
    }
}
