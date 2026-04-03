package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StartStopToken.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StartStopToken {

    @NotNull
    private final WorkGenerationalId id;

    public StartStopToken(@NotNull WorkGenerationalId id) {
        t.i(id, "id");
        this.id = id;
    }

    @NotNull
    public final WorkGenerationalId getId() {
        return this.id;
    }
}
