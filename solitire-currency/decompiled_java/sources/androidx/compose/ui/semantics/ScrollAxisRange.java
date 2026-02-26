package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ScrollAxisRange {
    public static final int $stable = 0;

    @NotNull
    private final h9.a<Float> maxValue;
    private final boolean reverseScrolling;

    @NotNull
    private final h9.a<Float> value;

    public ScrollAxisRange(@NotNull h9.a<Float> value, @NotNull h9.a<Float> maxValue, boolean z10) {
        t.i(value, "value");
        t.i(maxValue, "maxValue");
        this.value = value;
        this.maxValue = maxValue;
        this.reverseScrolling = z10;
    }

    @NotNull
    public final h9.a<Float> getMaxValue() {
        return this.maxValue;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @NotNull
    public final h9.a<Float> getValue() {
        return this.value;
    }

    @NotNull
    public String toString() {
        return "ScrollAxisRange(value=" + this.value.invoke().floatValue() + ", maxValue=" + this.maxValue.invoke().floatValue() + ", reverseScrolling=" + this.reverseScrolling + ')';
    }

    public /* synthetic */ ScrollAxisRange(h9.a aVar, h9.a aVar2, boolean z10, int i10, k kVar) {
        this(aVar, aVar2, (i10 & 4) != 0 ? false : z10);
    }
}
