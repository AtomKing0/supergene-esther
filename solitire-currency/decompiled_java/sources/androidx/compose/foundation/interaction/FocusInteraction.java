package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusInteraction.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FocusInteraction extends Interaction {

    /* JADX INFO: compiled from: FocusInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Focus implements FocusInteraction {
        public static final int $stable = 0;
    }

    /* JADX INFO: compiled from: FocusInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Unfocus implements FocusInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Focus focus;

        public Unfocus(@NotNull Focus focus) {
            t.i(focus, "focus");
            this.focus = focus;
        }

        @NotNull
        public final Focus getFocus() {
            return this.focus;
        }
    }
}
