package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PressInteraction.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PressInteraction extends Interaction {

    /* JADX INFO: compiled from: PressInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Cancel implements PressInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Press press;

        public Cancel(@NotNull Press press) {
            t.i(press, "press");
            this.press = press;
        }

        @NotNull
        public final Press getPress() {
            return this.press;
        }
    }

    /* JADX INFO: compiled from: PressInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Press implements PressInteraction {
        public static final int $stable = 0;
        private final long pressPosition;

        public /* synthetic */ Press(long j10, k kVar) {
            this(j10);
        }

        /* JADX INFO: renamed from: getPressPosition-F1C5BW0, reason: not valid java name */
        public final long m322getPressPositionF1C5BW0() {
            return this.pressPosition;
        }

        private Press(long j10) {
            this.pressPosition = j10;
        }
    }

    /* JADX INFO: compiled from: PressInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Release implements PressInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Press press;

        public Release(@NotNull Press press) {
            t.i(press, "press");
            this.press = press;
        }

        @NotNull
        public final Press getPress() {
            return this.press;
        }
    }
}
