package androidx.media3.exoplayer.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.s0;
import com.google.common.collect.y;
import e5.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class MergingCuesResolver implements CuesResolver {
    private static final s0<CuesWithTiming> CUES_DISPLAY_PRIORITY_COMPARATOR = s0.d().f(new g() { // from class: androidx.media3.exoplayer.text.a
        @Override // e5.g
        public final Object apply(Object obj) {
            return MergingCuesResolver.lambda$static$0((CuesWithTiming) obj);
        }
    }).a(s0.d().g().f(new g() { // from class: androidx.media3.exoplayer.text.b
        @Override // e5.g
        public final Object apply(Object obj) {
            return MergingCuesResolver.lambda$static$1((CuesWithTiming) obj);
        }
    }));
    private final List<CuesWithTiming> cuesWithTimingList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$static$0(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(cuesWithTiming.startTimeUs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$static$1(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(cuesWithTiming.durationUs);
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public boolean addCues(CuesWithTiming cuesWithTiming, long j10) {
        Assertions.checkArgument(cuesWithTiming.startTimeUs != C.TIME_UNSET);
        Assertions.checkArgument(cuesWithTiming.durationUs != C.TIME_UNSET);
        boolean z10 = cuesWithTiming.startTimeUs <= j10 && j10 < cuesWithTiming.endTimeUs;
        for (int size = this.cuesWithTimingList.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.startTimeUs >= this.cuesWithTimingList.get(size).startTimeUs) {
                this.cuesWithTimingList.add(size + 1, cuesWithTiming);
                return z10;
            }
        }
        this.cuesWithTimingList.add(0, cuesWithTiming);
        return z10;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void clear() {
        this.cuesWithTimingList.clear();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void discardCuesBeforeTimeUs(long j10) {
        int i10 = 0;
        while (i10 < this.cuesWithTimingList.size()) {
            long j11 = this.cuesWithTimingList.get(i10).startTimeUs;
            if (j10 > j11 && j10 > this.cuesWithTimingList.get(i10).endTimeUs) {
                this.cuesWithTimingList.remove(i10);
                i10--;
            } else if (j10 < j11) {
                return;
            }
            i10++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.text.CuesResolver
    public y<Cue> getCuesAtTimeUs(long j10) {
        if (!this.cuesWithTimingList.isEmpty()) {
            if (j10 >= this.cuesWithTimingList.get(0).startTimeUs) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < this.cuesWithTimingList.size(); i10++) {
                    CuesWithTiming cuesWithTiming = this.cuesWithTimingList.get(i10);
                    if (j10 >= cuesWithTiming.startTimeUs && j10 < cuesWithTiming.endTimeUs) {
                        arrayList.add(cuesWithTiming);
                    }
                    if (j10 < cuesWithTiming.startTimeUs) {
                        break;
                    }
                }
                y yVarX = y.x(CUES_DISPLAY_PRIORITY_COMPARATOR, arrayList);
                y.a aVarK = y.k();
                for (int i11 = 0; i11 < yVarX.size(); i11++) {
                    aVarK.j(((CuesWithTiming) yVarX.get(i11)).cues);
                }
                return aVarK.k();
            }
        }
        return y.q();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long getNextCueChangeTimeUs(long j10) {
        int i10 = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            if (i10 >= this.cuesWithTimingList.size()) {
                break;
            }
            long j11 = this.cuesWithTimingList.get(i10).startTimeUs;
            long j12 = this.cuesWithTimingList.get(i10).endTimeUs;
            if (j10 < j11) {
                jMin = jMin == C.TIME_UNSET ? j11 : Math.min(jMin, j11);
            } else {
                if (j10 < j12) {
                    jMin = jMin == C.TIME_UNSET ? j12 : Math.min(jMin, j12);
                }
                i10++;
            }
        }
        if (jMin != C.TIME_UNSET) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long getPreviousCueChangeTimeUs(long j10) {
        if (this.cuesWithTimingList.isEmpty()) {
            return C.TIME_UNSET;
        }
        if (j10 < this.cuesWithTimingList.get(0).startTimeUs) {
            return C.TIME_UNSET;
        }
        long jMax = this.cuesWithTimingList.get(0).startTimeUs;
        for (int i10 = 0; i10 < this.cuesWithTimingList.size(); i10++) {
            long j11 = this.cuesWithTimingList.get(i10).startTimeUs;
            long j12 = this.cuesWithTimingList.get(i10).endTimeUs;
            if (j12 > j10) {
                if (j11 > j10) {
                    break;
                }
                jMax = Math.max(jMax, j11);
            } else {
                jMax = Math.max(jMax, j12);
            }
        }
        return jMax;
    }
}
