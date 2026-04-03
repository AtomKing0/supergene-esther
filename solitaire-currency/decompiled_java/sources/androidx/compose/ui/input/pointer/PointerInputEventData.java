package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InternalPointerInput.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEventData {
    private final boolean down;

    @NotNull
    private final List<HistoricalChange> historical;
    private final long id;
    private final boolean issuesEnterExit;
    private final long position;
    private final long positionOnScreen;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j10, long j11, long j12, long j13, boolean z10, int i10, boolean z11, List list, long j14, k kVar) {
        this(j10, j11, j12, j13, z10, i10, z11, list, j14);
    }

    /* JADX INFO: renamed from: component1-J3iCeTQ, reason: not valid java name */
    public final long m2880component1J3iCeTQ() {
        return this.id;
    }

    public final long component2() {
        return this.uptime;
    }

    /* JADX INFO: renamed from: component3-F1C5BW0, reason: not valid java name */
    public final long m2881component3F1C5BW0() {
        return this.positionOnScreen;
    }

    /* JADX INFO: renamed from: component4-F1C5BW0, reason: not valid java name */
    public final long m2882component4F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    /* JADX INFO: renamed from: component6-T8wyACA, reason: not valid java name */
    public final int m2883component6T8wyACA() {
        return this.type;
    }

    public final boolean component7() {
        return this.issuesEnterExit;
    }

    @NotNull
    public final List<HistoricalChange> component8() {
        return this.historical;
    }

    /* JADX INFO: renamed from: component9-F1C5BW0, reason: not valid java name */
    public final long m2884component9F1C5BW0() {
        return this.scrollDelta;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-JzxSYW4, reason: not valid java name */
    public final PointerInputEventData m2885copyJzxSYW4(long j10, long j11, long j12, long j13, boolean z10, int i10, boolean z11, @NotNull List<HistoricalChange> historical, long j14) {
        t.i(historical, "historical");
        return new PointerInputEventData(j10, j11, j12, j13, z10, i10, z11, historical, j14, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.m2860equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m1364equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m1364equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && PointerType.m2931equalsimpl0(this.type, pointerInputEventData.type) && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && t.d(this.historical, pointerInputEventData.historical) && Offset.m1364equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta);
    }

    public final boolean getDown() {
        return this.down;
    }

    @NotNull
    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* JADX INFO: renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m2886getIdJ3iCeTQ() {
        return this.id;
    }

    public final boolean getIssuesEnterExit() {
        return this.issuesEnterExit;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m2887getPositionF1C5BW0() {
        return this.position;
    }

    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m2888getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    /* JADX INFO: renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m2889getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m2890getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iM2861hashCodeimpl = ((((((PointerId.m2861hashCodeimpl(this.id) * 31) + androidx.compose.animation.a.a(this.uptime)) * 31) + Offset.m1369hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m1369hashCodeimpl(this.position)) * 31;
        boolean z10 = this.down;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int iM2932hashCodeimpl = (((iM2861hashCodeimpl + r12) * 31) + PointerType.m2932hashCodeimpl(this.type)) * 31;
        boolean z11 = this.issuesEnterExit;
        return ((((iM2932hashCodeimpl + (z11 ? 1 : z11)) * 31) + this.historical.hashCode()) * 31) + Offset.m1369hashCodeimpl(this.scrollDelta);
    }

    @NotNull
    public String toString() {
        return "PointerInputEventData(id=" + ((Object) PointerId.m2862toStringimpl(this.id)) + ", uptime=" + this.uptime + ", positionOnScreen=" + ((Object) Offset.m1375toStringimpl(this.positionOnScreen)) + ", position=" + ((Object) Offset.m1375toStringimpl(this.position)) + ", down=" + this.down + ", type=" + ((Object) PointerType.m2933toStringimpl(this.type)) + ", issuesEnterExit=" + this.issuesEnterExit + ", historical=" + this.historical + ", scrollDelta=" + ((Object) Offset.m1375toStringimpl(this.scrollDelta)) + ')';
    }

    private PointerInputEventData(long j10, long j11, long j12, long j13, boolean z10, int i10, boolean z11, List<HistoricalChange> list, long j14) {
        this.id = j10;
        this.uptime = j11;
        this.positionOnScreen = j12;
        this.position = j13;
        this.down = z10;
        this.type = i10;
        this.issuesEnterExit = z11;
        this.historical = list;
        this.scrollDelta = j14;
    }

    public /* synthetic */ PointerInputEventData(long j10, long j11, long j12, long j13, boolean z10, int i10, boolean z11, List list, long j14, int i11, k kVar) {
        this(j10, j11, j12, j13, z10, i10, (i11 & 64) != 0 ? false : z11, (i11 & 128) != 0 ? new ArrayList() : list, (i11 & 256) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j14, null);
    }
}
