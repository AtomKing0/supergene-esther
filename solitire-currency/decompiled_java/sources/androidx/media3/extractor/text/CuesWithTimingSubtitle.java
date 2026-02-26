package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.s0;
import com.google.common.collect.y;
import e5.g;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class CuesWithTimingSubtitle implements Subtitle {
    private static final s0<CuesWithTiming> CUES_BY_START_TIME_ASCENDING = s0.d().f(new g() { // from class: androidx.media3.extractor.text.b
        @Override // e5.g
        public final Object apply(Object obj) {
            return CuesWithTimingSubtitle.lambda$static$0((CuesWithTiming) obj);
        }
    });
    private static final String TAG = "CuesWithTimingSubtitle";
    private final y<y<Cue>> eventCues;
    private final long[] eventTimesUs;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CuesWithTimingSubtitle(java.util.List<androidx.media3.extractor.text.CuesWithTiming> r15) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.CuesWithTimingSubtitle.<init>(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Comparable lambda$static$0(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(normalizeUnsetStartTimeToZero(cuesWithTiming.startTimeUs));
    }

    private static long normalizeUnsetStartTimeToZero(long j10) {
        if (j10 == C.TIME_UNSET) {
            return 0L;
        }
        return j10;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i10) {
        Assertions.checkArgument(i10 < this.eventCues.size());
        return this.eventTimesUs[i10];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return this.eventCues.size();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j10) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j10, false, false);
        if (iBinarySearchCeil < this.eventCues.size()) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public y<Cue> getCues(long j10) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.eventTimesUs, j10, true, false);
        return iBinarySearchFloor == -1 ? y.q() : this.eventCues.get(iBinarySearchFloor);
    }
}
