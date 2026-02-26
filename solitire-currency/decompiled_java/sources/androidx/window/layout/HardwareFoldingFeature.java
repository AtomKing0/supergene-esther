package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HardwareFoldingFeature.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HardwareFoldingFeature implements FoldingFeature {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Bounds featureBounds;

    @NotNull
    private final FoldingFeature.State state;

    @NotNull
    private final Type type;

    /* JADX INFO: compiled from: HardwareFoldingFeature.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final void validateFeatureBounds$window_release(@NotNull Bounds bounds) {
            t.i(bounds, "bounds");
            if (!((bounds.getWidth() == 0 && bounds.getHeight() == 0) ? false : true)) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (!(bounds.getLeft() == 0 || bounds.getTop() == 0)) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }
    }

    /* JADX INFO: compiled from: HardwareFoldingFeature.kt */
    public static final class Type {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Type FOLD = new Type("FOLD");

        @NotNull
        private static final Type HINGE = new Type("HINGE");

        @NotNull
        private final String description;

        /* JADX INFO: compiled from: HardwareFoldingFeature.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            @NotNull
            public final Type getFOLD() {
                return Type.FOLD;
            }

            @NotNull
            public final Type getHINGE() {
                return Type.HINGE;
            }
        }

        private Type(String str) {
            this.description = str;
        }

        @NotNull
        public String toString() {
            return this.description;
        }
    }

    public HardwareFoldingFeature(@NotNull Bounds featureBounds, @NotNull Type type, @NotNull FoldingFeature.State state) {
        t.i(featureBounds, "featureBounds");
        t.i(type, "type");
        t.i(state, "state");
        this.featureBounds = featureBounds;
        this.type = type;
        this.state = state;
        Companion.validateFeatureBounds$window_release(featureBounds);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(HardwareFoldingFeature.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
        return t.d(this.featureBounds, hardwareFoldingFeature.featureBounds) && t.d(this.type, hardwareFoldingFeature.type) && t.d(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.layout.DisplayFeature
    @NotNull
    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    @Override // androidx.window.layout.FoldingFeature
    @NotNull
    public FoldingFeature.OcclusionType getOcclusionType() {
        return (this.featureBounds.getWidth() == 0 || this.featureBounds.getHeight() == 0) ? FoldingFeature.OcclusionType.NONE : FoldingFeature.OcclusionType.FULL;
    }

    @Override // androidx.window.layout.FoldingFeature
    @NotNull
    public FoldingFeature.Orientation getOrientation() {
        return this.featureBounds.getWidth() > this.featureBounds.getHeight() ? FoldingFeature.Orientation.HORIZONTAL : FoldingFeature.Orientation.VERTICAL;
    }

    @Override // androidx.window.layout.FoldingFeature
    @NotNull
    public FoldingFeature.State getState() {
        return this.state;
    }

    @NotNull
    public final Type getType$window_release() {
        return this.type;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean isSeparating() {
        Type type = this.type;
        Type.Companion companion = Type.Companion;
        if (t.d(type, companion.getHINGE())) {
            return true;
        }
        return t.d(this.type, companion.getFOLD()) && t.d(getState(), FoldingFeature.State.HALF_OPENED);
    }

    @NotNull
    public String toString() {
        return ((Object) HardwareFoldingFeature.class.getSimpleName()) + " { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }
}
