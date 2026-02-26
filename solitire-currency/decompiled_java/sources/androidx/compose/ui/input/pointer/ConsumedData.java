package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ConsumedData {
    public static final int $stable = 8;
    private boolean downChange;
    private boolean positionChange;

    /* JADX WARN: Illegal instructions before constructor call */
    public ConsumedData() {
        boolean z10 = false;
        this(z10, z10, 3, null);
    }

    public final boolean getDownChange() {
        return this.downChange;
    }

    public final boolean getPositionChange() {
        return this.positionChange;
    }

    public final void setDownChange(boolean z10) {
        this.downChange = z10;
    }

    public final void setPositionChange(boolean z10) {
        this.positionChange = z10;
    }

    public ConsumedData(boolean z10, boolean z11) {
        this.positionChange = z10;
        this.downChange = z11;
    }

    public /* synthetic */ ConsumedData(boolean z10, boolean z11, int i10, k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11);
    }

    public static /* synthetic */ void getDownChange$annotations() {
    }

    public static /* synthetic */ void getPositionChange$annotations() {
    }
}
