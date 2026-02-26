package androidx.compose.foundation.lazy;

import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyListItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ItemInfo {
    private int index;
    private long notAnimatableDelta = IntOffset.Companion.m3801getZeronOccac();

    @NotNull
    private final List<PlaceableInfo> placeables = new ArrayList();

    public ItemInfo(int i10) {
        this.index = i10;
    }

    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: getNotAnimatableDelta-nOcc-ac, reason: not valid java name */
    public final long m498getNotAnimatableDeltanOccac() {
        return this.notAnimatableDelta;
    }

    @NotNull
    public final List<PlaceableInfo> getPlaceables() {
        return this.placeables;
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    /* JADX INFO: renamed from: setNotAnimatableDelta--gyyYBs, reason: not valid java name */
    public final void m499setNotAnimatableDeltagyyYBs(long j10) {
        this.notAnimatableDelta = j10;
    }
}
