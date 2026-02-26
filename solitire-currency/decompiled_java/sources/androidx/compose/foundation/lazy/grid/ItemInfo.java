package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ItemInfo {
    private int crossAxisOffset;
    private int crossAxisSize;
    private int index;
    private long notAnimatableDelta = IntOffset.Companion.m3801getZeronOccac();

    @NotNull
    private final List<PlaceableInfo> placeables = new ArrayList();

    public ItemInfo(int i10, int i11, int i12) {
        this.index = i10;
        this.crossAxisSize = i11;
        this.crossAxisOffset = i12;
    }

    public final int getCrossAxisOffset() {
        return this.crossAxisOffset;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: getNotAnimatableDelta-nOcc-ac, reason: not valid java name */
    public final long m552getNotAnimatableDeltanOccac() {
        return this.notAnimatableDelta;
    }

    @NotNull
    public final List<PlaceableInfo> getPlaceables() {
        return this.placeables;
    }

    public final void setCrossAxisOffset(int i10) {
        this.crossAxisOffset = i10;
    }

    public final void setCrossAxisSize(int i10) {
        this.crossAxisSize = i10;
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    /* JADX INFO: renamed from: setNotAnimatableDelta--gyyYBs, reason: not valid java name */
    public final void m553setNotAnimatableDeltagyyYBs(long j10) {
        this.notAnimatableDelta = j10;
    }
}
