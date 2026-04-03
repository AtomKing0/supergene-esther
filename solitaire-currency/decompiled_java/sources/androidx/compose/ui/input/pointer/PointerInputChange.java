package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class PointerInputChange {

    @Nullable
    private List<HistoricalChange> _historical;

    @NotNull
    private ConsumedData consumed;
    private final long id;
    private final long position;
    private final boolean pressed;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, ConsumedData consumedData, int i10, k kVar) {
        this(j10, j11, j12, z10, j13, j14, z11, consumedData, i10);
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-0GkPj7c, reason: not valid java name */
    public final PointerInputChange m2868copy0GkPj7c(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, @NotNull ConsumedData consumed, int i10, long j15) {
        t.i(consumed, "consumed");
        PointerInputChange pointerInputChange = new PointerInputChange(j10, j11, j12, z10, j13, j14, z11, consumed.getDownChange() || consumed.getPositionChange(), i10, getHistorical(), j15, (k) null);
        this.consumed = consumed;
        return pointerInputChange;
    }

    /* JADX INFO: renamed from: copy-Ezr-O64, reason: not valid java name */
    public final /* synthetic */ PointerInputChange m2869copyEzrO64(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, ConsumedData consumed, int i10) {
        t.i(consumed, "consumed");
        PointerInputChange pointerInputChange = new PointerInputChange(j10, j11, j12, z10, j13, j14, z11, consumed.getDownChange() || consumed.getPositionChange(), i10, getHistorical(), this.scrollDelta, (k) null);
        this.consumed = consumed;
        return pointerInputChange;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-JKmWfYY, reason: not valid java name */
    public final PointerInputChange m2870copyJKmWfYY(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, int i10, long j15) {
        PointerInputChange pointerInputChange = new PointerInputChange(j10, j11, j12, z10, j13, j14, z11, false, i10, (List) getHistorical(), j15, (k) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* JADX INFO: renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m2871copyOHpmEuE(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, int i10, @NotNull List<HistoricalChange> historical, long j15) {
        t.i(historical, "historical");
        PointerInputChange pointerInputChange = new PointerInputChange(j10, j11, j12, z10, j13, j14, z11, false, i10, (List) historical, j15, (k) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @NotNull
    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? v.l() : list;
    }

    /* JADX INFO: renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m2872getIdJ3iCeTQ() {
        return this.id;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m2873getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    /* JADX INFO: renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name */
    public final long m2874getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* JADX INFO: renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m2875getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m2876getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    @NotNull
    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.m2862toStringimpl(this.id)) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m1375toStringimpl(this.position)) + ", pressed=" + this.pressed + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + ((Object) Offset.m1375toStringimpl(this.previousPosition)) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + ((Object) PointerType.m2933toStringimpl(this.type)) + ", historical=" + getHistorical() + ",scrollDelta=" + ((Object) Offset.m1375toStringimpl(this.scrollDelta)) + ')';
    }

    public /* synthetic */ PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, boolean z12, int i10, long j15, k kVar) {
        this(j10, j11, j12, z10, j13, j14, z11, z12, i10, j15);
    }

    public /* synthetic */ PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, boolean z12, int i10, List list, long j15, k kVar) {
        this(j10, j11, j12, z10, j13, j14, z11, z12, i10, (List<HistoricalChange>) list, j15);
    }

    private PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, boolean z12, int i10, long j15) {
        this.id = j10;
        this.uptimeMillis = j11;
        this.position = j12;
        this.pressed = z10;
        this.previousUptimeMillis = j13;
        this.previousPosition = j14;
        this.previousPressed = z11;
        this.type = i10;
        this.scrollDelta = j15;
        this.consumed = new ConsumedData(z12, z12);
    }

    public /* synthetic */ PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, boolean z12, int i10, long j15, int i11, k kVar) {
        this(j10, j11, j12, z10, j13, j14, z11, z12, (i11 & 256) != 0 ? PointerType.Companion.m2938getTouchT8wyACA() : i10, (i11 & 512) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j15, (k) null);
    }

    public /* synthetic */ PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, ConsumedData consumedData, int i10, int i11, k kVar) {
        this(j10, j11, j12, z10, j13, j14, z11, consumedData, (i11 & 256) != 0 ? PointerType.Companion.m2938getTouchT8wyACA() : i10, (k) null);
    }

    public static /* synthetic */ void getConsumed$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getHistorical$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    private PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, ConsumedData consumedData, int i10) {
        this(j10, j11, j12, z10, j13, j14, z11, consumedData.getDownChange() || consumedData.getPositionChange(), i10, Offset.Companion.m1383getZeroF1C5BW0(), (k) null);
    }

    private PointerInputChange(long j10, long j11, long j12, boolean z10, long j13, long j14, boolean z11, boolean z12, int i10, List<HistoricalChange> list, long j15) {
        this(j10, j11, j12, z10, j13, j14, z11, z12, i10, j15, (k) null);
        this._historical = list;
    }
}
