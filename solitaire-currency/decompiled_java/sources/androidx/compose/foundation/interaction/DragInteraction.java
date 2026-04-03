package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DragInteraction.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DragInteraction extends Interaction {

    /* JADX INFO: compiled from: DragInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Cancel implements DragInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Start start;

        public Cancel(@NotNull Start start) {
            t.i(start, "start");
            this.start = start;
        }

        @NotNull
        public final Start getStart() {
            return this.start;
        }
    }

    /* JADX INFO: compiled from: DragInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Start implements DragInteraction {
        public static final int $stable = 0;
    }

    /* JADX INFO: compiled from: DragInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Stop implements DragInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Start start;

        public Stop(@NotNull Start start) {
            t.i(start, "start");
            this.start = start;
        }

        @NotNull
        public final Start getStart() {
            return this.start;
        }
    }
}
