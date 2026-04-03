package androidx.window.layout;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FoldingFeature.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface FoldingFeature extends DisplayFeature {

    /* JADX INFO: compiled from: FoldingFeature.kt */
    public static final class OcclusionType {

        @NotNull
        private final String description;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final OcclusionType NONE = new OcclusionType("NONE");

        @NotNull
        public static final OcclusionType FULL = new OcclusionType("FULL");

        /* JADX INFO: compiled from: FoldingFeature.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }
        }

        private OcclusionType(String str) {
            this.description = str;
        }

        @NotNull
        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: FoldingFeature.kt */
    public static final class Orientation {

        @NotNull
        private final String description;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final Orientation VERTICAL = new Orientation("VERTICAL");

        @NotNull
        public static final Orientation HORIZONTAL = new Orientation("HORIZONTAL");

        /* JADX INFO: compiled from: FoldingFeature.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }
        }

        private Orientation(String str) {
            this.description = str;
        }

        @NotNull
        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: FoldingFeature.kt */
    public static final class State {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final State FLAT = new State("FLAT");

        @NotNull
        public static final State HALF_OPENED = new State("HALF_OPENED");

        @NotNull
        private final String description;

        /* JADX INFO: compiled from: FoldingFeature.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }
        }

        private State(String str) {
            this.description = str;
        }

        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @NotNull
    OcclusionType getOcclusionType();

    @NotNull
    Orientation getOrientation();

    @NotNull
    State getState();

    boolean isSeparating();
}
