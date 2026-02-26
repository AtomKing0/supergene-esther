package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Anchor {
    private int location;

    public Anchor(int i10) {
        this.location = i10;
    }

    public final int getLocation$runtime_release() {
        return this.location;
    }

    public final boolean getValid() {
        return this.location != Integer.MIN_VALUE;
    }

    public final void setLocation$runtime_release(int i10) {
        this.location = i10;
    }

    public final int toIndexFor(@NotNull SlotTable slots) {
        t.i(slots, "slots");
        return slots.anchorIndex(this);
    }

    public final int toIndexFor(@NotNull SlotWriter writer) {
        t.i(writer, "writer");
        return writer.anchorIndex(this);
    }
}
