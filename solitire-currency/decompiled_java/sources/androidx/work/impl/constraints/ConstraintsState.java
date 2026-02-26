package androidx.work.impl.constraints;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ConstraintsState {

    /* JADX INFO: compiled from: WorkConstraintsTracker.kt */
    public static final class ConstraintsMet extends ConstraintsState {

        @NotNull
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();

        private ConstraintsMet() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: WorkConstraintsTracker.kt */
    public static final class ConstraintsNotMet extends ConstraintsState {
        private final int reason;

        public ConstraintsNotMet(int i10) {
            super(null);
            this.reason = i10;
        }

        public static /* synthetic */ ConstraintsNotMet copy$default(ConstraintsNotMet constraintsNotMet, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = constraintsNotMet.reason;
            }
            return constraintsNotMet.copy(i10);
        }

        public final int component1() {
            return this.reason;
        }

        @NotNull
        public final ConstraintsNotMet copy(int i10) {
            return new ConstraintsNotMet(i10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason;
        }

        @NotNull
        public String toString() {
            return "ConstraintsNotMet(reason=" + this.reason + ')';
        }
    }

    private ConstraintsState() {
    }

    public /* synthetic */ ConstraintsState(k kVar) {
        this();
    }
}
