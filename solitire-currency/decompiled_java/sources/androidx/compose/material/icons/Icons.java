package androidx.compose.material.icons;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Icons.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Icons {
    public static final int $stable = 0;

    @NotNull
    public static final Icons INSTANCE = new Icons();

    @NotNull
    private static final Filled Default = Filled.INSTANCE;

    /* JADX INFO: compiled from: Icons.kt */
    @StabilityInferred(parameters = 0)
    public static final class Filled {
        public static final int $stable = 0;

        @NotNull
        public static final Filled INSTANCE = new Filled();

        private Filled() {
        }
    }

    /* JADX INFO: compiled from: Icons.kt */
    @StabilityInferred(parameters = 0)
    public static final class Outlined {
        public static final int $stable = 0;

        @NotNull
        public static final Outlined INSTANCE = new Outlined();

        private Outlined() {
        }
    }

    /* JADX INFO: compiled from: Icons.kt */
    @StabilityInferred(parameters = 0)
    public static final class Rounded {
        public static final int $stable = 0;

        @NotNull
        public static final Rounded INSTANCE = new Rounded();

        private Rounded() {
        }
    }

    /* JADX INFO: compiled from: Icons.kt */
    @StabilityInferred(parameters = 0)
    public static final class Sharp {
        public static final int $stable = 0;

        @NotNull
        public static final Sharp INSTANCE = new Sharp();

        private Sharp() {
        }
    }

    /* JADX INFO: compiled from: Icons.kt */
    @StabilityInferred(parameters = 0)
    public static final class TwoTone {
        public static final int $stable = 0;

        @NotNull
        public static final TwoTone INSTANCE = new TwoTone();

        private TwoTone() {
        }
    }

    private Icons() {
    }

    @NotNull
    public final Filled getDefault() {
        return Default;
    }
}
