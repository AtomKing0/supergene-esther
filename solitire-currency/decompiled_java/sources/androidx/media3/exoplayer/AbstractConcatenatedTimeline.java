package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.ShuffleOrder;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z10, ShuffleOrder shuffleOrder) {
        this.isAtomic = z10;
        this.shuffleOrder = shuffleOrder;
        this.childCount = shuffleOrder.getLength();
    }

    public static Object getChildPeriodUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object getChildTimelineUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object getConcatenatedUid(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int getNextChildIndex(int i10, boolean z10) {
        if (z10) {
            return this.shuffleOrder.getNextIndex(i10);
        }
        if (i10 < this.childCount - 1) {
            return i10 + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i10, boolean z10) {
        if (z10) {
            return this.shuffleOrder.getPreviousIndex(i10);
        }
        if (i10 > 0) {
            return i10 - 1;
        }
        return -1;
    }

    protected abstract int getChildIndexByChildUid(Object obj);

    protected abstract int getChildIndexByPeriodIndex(int i10);

    protected abstract int getChildIndexByWindowIndex(int i10);

    protected abstract Object getChildUidByChildIndex(int i10);

    protected abstract int getFirstPeriodIndexByChildIndex(int i10);

    @Override // androidx.media3.common.Timeline
    public int getFirstWindowIndex(boolean z10) {
        if (this.childCount == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z10 = false;
        }
        int firstIndex = z10 ? this.shuffleOrder.getFirstIndex() : 0;
        while (getTimelineByChildIndex(firstIndex).isEmpty()) {
            firstIndex = getNextChildIndex(firstIndex, z10);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(firstIndex) + getTimelineByChildIndex(firstIndex).getFirstWindowIndex(z10);
    }

    protected abstract int getFirstWindowIndexByChildIndex(int i10);

    @Override // androidx.media3.common.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(childPeriodUidFromConcatenatedUid)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // androidx.media3.common.Timeline
    public int getLastWindowIndex(boolean z10) {
        int i10 = this.childCount;
        if (i10 == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z10 = false;
        }
        int lastIndex = z10 ? this.shuffleOrder.getLastIndex() : i10 - 1;
        while (getTimelineByChildIndex(lastIndex).isEmpty()) {
            lastIndex = getPreviousChildIndex(lastIndex, z10);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(lastIndex) + getTimelineByChildIndex(lastIndex).getLastWindowIndex(z10);
    }

    @Override // androidx.media3.common.Timeline
    public int getNextWindowIndex(int i10, int i11, boolean z10) {
        if (this.isAtomic) {
            if (i11 == 1) {
                i11 = 2;
            }
            z10 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int nextWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getNextWindowIndex(i10 - firstWindowIndexByChildIndex, i11 != 2 ? i11 : 0, z10);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z10);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z10);
        }
        if (nextChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z10);
        }
        if (i11 == 2) {
            return getFirstWindowIndex(z10);
        }
        return -1;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period getPeriod(int i10, Timeline.Period period, boolean z10) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i10 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z10);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z10) {
            period.uid = getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), Assertions.checkNotNull(period.uid));
        }
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).getPeriodByUid(childPeriodUidFromConcatenatedUid, period);
        period.windowIndex += firstWindowIndexByChildIndex;
        period.uid = obj;
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public int getPreviousWindowIndex(int i10, int i11, boolean z10) {
        if (this.isAtomic) {
            if (i11 == 1) {
                i11 = 2;
            }
            z10 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int previousWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getPreviousWindowIndex(i10 - firstWindowIndexByChildIndex, i11 != 2 ? i11 : 0, z10);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z10);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z10);
        }
        if (previousChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z10);
        }
        if (i11 == 2) {
            return getLastWindowIndex(z10);
        }
        return -1;
    }

    protected abstract Timeline getTimelineByChildIndex(int i10);

    @Override // androidx.media3.common.Timeline
    public final Object getUidOfPeriod(int i10) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i10);
        return getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).getUidOfPeriod(i10 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Window getWindow(int i10, Timeline.Window window, long j10) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i10 - firstWindowIndexByChildIndex, window, j10);
        Object childUidByChildIndex = getChildUidByChildIndex(childIndexByWindowIndex);
        if (!Timeline.Window.SINGLE_WINDOW_UID.equals(window.uid)) {
            childUidByChildIndex = getConcatenatedUid(childUidByChildIndex, window.uid);
        }
        window.uid = childUidByChildIndex;
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}
