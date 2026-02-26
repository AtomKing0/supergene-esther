package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.e;
import n9.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ProgressBarRangeInfo {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ProgressBarRangeInfo Indeterminate = new ProgressBarRangeInfo(0.0f, n.b(0.0f, 0.0f), 0, 4, null);
    private final float current;

    @NotNull
    private final e<Float> range;
    private final int steps;

    /* JADX INFO: compiled from: SemanticsProperties.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final ProgressBarRangeInfo getIndeterminate() {
            return ProgressBarRangeInfo.Indeterminate;
        }
    }

    public ProgressBarRangeInfo(float f10, @NotNull e<Float> range, int i10) {
        t.i(range, "range");
        this.current = f10;
        this.range = range;
        this.steps = i10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarRangeInfo)) {
            return false;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj;
        return ((this.current > progressBarRangeInfo.current ? 1 : (this.current == progressBarRangeInfo.current ? 0 : -1)) == 0) && t.d(this.range, progressBarRangeInfo.range) && this.steps == progressBarRangeInfo.steps;
    }

    public final float getCurrent() {
        return this.current;
    }

    @NotNull
    public final e<Float> getRange() {
        return this.range;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.current) * 31) + this.range.hashCode()) * 31) + this.steps;
    }

    @NotNull
    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.current + ", range=" + this.range + ", steps=" + this.steps + ')';
    }

    public /* synthetic */ ProgressBarRangeInfo(float f10, e eVar, int i10, int i11, k kVar) {
        this(f10, eVar, (i11 & 4) != 0 ? 0 : i10);
    }
}
