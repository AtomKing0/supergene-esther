package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeApi
public final class MovableContentState {
    public static final int $stable = 8;

    @NotNull
    private final SlotTable slotTable;

    public MovableContentState(@NotNull SlotTable slotTable) {
        t.i(slotTable, "slotTable");
        this.slotTable = slotTable;
    }

    @NotNull
    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }
}
