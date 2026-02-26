package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HoverInteraction.kt */
/* JADX INFO: loaded from: classes.dex */
public interface HoverInteraction extends Interaction {

    /* JADX INFO: compiled from: HoverInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Enter implements HoverInteraction {
        public static final int $stable = 0;
    }

    /* JADX INFO: compiled from: HoverInteraction.kt */
    @StabilityInferred(parameters = 0)
    public static final class Exit implements HoverInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Enter enter;

        public Exit(@NotNull Enter enter) {
            t.i(enter, "enter");
            this.enter = enter;
        }

        @NotNull
        public final Enter getEnter() {
            return this.enter;
        }
    }
}
