package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class SolidColor extends Brush {
    private final long value;

    public /* synthetic */ SolidColor(long j10, kotlin.jvm.internal.k kVar) {
        this(j10);
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public void mo1551applyToPq9zytI(long j10, @NotNull Paint p10, float f10) {
        long jM1597copywmQWz5c$default;
        kotlin.jvm.internal.t.i(p10, "p");
        p10.setAlpha(1.0f);
        if (f10 == 1.0f) {
            jM1597copywmQWz5c$default = this.value;
        } else {
            long j11 = this.value;
            jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(j11, Color.m1600getAlphaimpl(j11) * f10, 0.0f, 0.0f, 0.0f, 14, null);
        }
        p10.mo1488setColor8_81llA(jM1597copywmQWz5c$default);
        if (p10.getShader() != null) {
            p10.setShader(null);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SolidColor) && Color.m1599equalsimpl0(this.value, ((SolidColor) obj).value);
    }

    /* JADX INFO: renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m1867getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m1605hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return "SolidColor(value=" + ((Object) Color.m1606toStringimpl(this.value)) + ')';
    }

    private SolidColor(long j10) {
        super(null);
        this.value = j10;
    }
}
