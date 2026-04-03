package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override // androidx.media3.common.Timeline
    public int getFirstWindowIndex(boolean z10) {
        return this.timeline.getFirstWindowIndex(z10);
    }

    @Override // androidx.media3.common.Timeline
    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    @Override // androidx.media3.common.Timeline
    public int getLastWindowIndex(boolean z10) {
        return this.timeline.getLastWindowIndex(z10);
    }

    @Override // androidx.media3.common.Timeline
    public int getNextWindowIndex(int i10, int i11, boolean z10) {
        return this.timeline.getNextWindowIndex(i10, i11, z10);
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Period getPeriod(int i10, Timeline.Period period, boolean z10) {
        return this.timeline.getPeriod(i10, period, z10);
    }

    @Override // androidx.media3.common.Timeline
    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override // androidx.media3.common.Timeline
    public int getPreviousWindowIndex(int i10, int i11, boolean z10) {
        return this.timeline.getPreviousWindowIndex(i10, i11, z10);
    }

    @Override // androidx.media3.common.Timeline
    public Object getUidOfPeriod(int i10) {
        return this.timeline.getUidOfPeriod(i10);
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Window getWindow(int i10, Timeline.Window window, long j10) {
        return this.timeline.getWindow(i10, window, j10);
    }

    @Override // androidx.media3.common.Timeline
    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}
