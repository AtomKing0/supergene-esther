package androidx.media3.exoplayer.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.g0;
import com.google.common.collect.l0;
import com.google.common.collect.m0;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_HEIGHT_TO_DISCARD = 719;
    public static final int DEFAULT_MAX_WIDTH_TO_DISCARD = 1279;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private static final long MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 1000;
    private static final String TAG = "AdaptiveTrackSelection";
    private final y<AdaptationCheckpoint> adaptationCheckpoints;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;

    @Nullable
    private MediaChunk lastBufferEvaluationMediaChunk;
    private long lastBufferEvaluationMs;
    private long latestBitrateEstimate;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxHeightToDiscard;
    private final int maxWidthToDiscard;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    public static final class AdaptationCheckpoint {
        public final long allocatedBandwidth;
        public final long totalBandwidth;

        public AdaptationCheckpoint(long j10, long j11) {
            this.totalBandwidth = j10;
            this.allocatedBandwidth = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            return this.totalBandwidth == adaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptationCheckpoint.allocatedBandwidth;
        }

        public int hashCode() {
            return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {
        private final float bandwidthFraction;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int maxHeightToDiscard;
        private final int maxWidthToDiscard;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        protected AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i10, BandwidthMeter bandwidthMeter, y<AdaptationCheckpoint> yVar) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i10, bandwidthMeter, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.maxWidthToDiscard, this.maxHeightToDiscard, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, yVar, this.clock);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection.Factory
        public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            y adaptationCheckpoints = AdaptiveTrackSelection.getAdaptationCheckpoints(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i10 = 0; i10 < definitionArr.length; i10++) {
                ExoTrackSelection.Definition definition = definitionArr[i10];
                if (definition != null) {
                    int[] iArr = definition.tracks;
                    if (iArr.length != 0) {
                        exoTrackSelectionArr[i10] = iArr.length == 1 ? new FixedTrackSelection(definition.group, iArr[0], definition.type) : createAdaptiveTrackSelection(definition.group, iArr, definition.type, bandwidthMeter, (y) adaptationCheckpoints.get(i10));
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        public Factory(int i10, int i11, int i12, float f10) {
            this(i10, i11, i12, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f10, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i10, int i11, int i12, int i13, int i14, float f10) {
            this(i10, i11, i12, i13, i14, f10, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i10, int i11, int i12, float f10, float f11, Clock clock) {
            this(i10, i11, i12, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f10, f11, clock);
        }

        public Factory(int i10, int i11, int i12, int i13, int i14, float f10, float f11, Clock clock) {
            this.minDurationForQualityIncreaseMs = i10;
            this.maxDurationForQualityDecreaseMs = i11;
            this.minDurationToRetainAfterDiscardMs = i12;
            this.maxWidthToDiscard = i13;
            this.maxHeightToDiscard = i14;
            this.bandwidthFraction = f10;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f11;
            this.clock = clock;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, 0, bandwidthMeter, 10000L, 25000L, 25000L, DEFAULT_MAX_WIDTH_TO_DISCARD, DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, y.q(), Clock.DEFAULT);
    }

    private static void addCheckpoint(List<y.a<AdaptationCheckpoint>> list, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            y.a<AdaptationCheckpoint> aVar = list.get(i10);
            if (aVar != null) {
                aVar.a(new AdaptationCheckpoint(j10, jArr[i10]));
            }
        }
    }

    private int determineIdealSelectedIndex(long j10, long j11) {
        long allocatedBandwidth = getAllocatedBandwidth(j11);
        int i10 = 0;
        for (int i11 = 0; i11 < this.length; i11++) {
            if (j10 == Long.MIN_VALUE || !isTrackExcluded(i11, j10)) {
                Format format = getFormat(i11);
                if (canSelectFormat(format, format.bitrate, allocatedBandwidth)) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static y<y<AdaptationCheckpoint>> getAdaptationCheckpoints(ExoTrackSelection.Definition[] definitionArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.tracks.length <= 1) {
                arrayList.add(null);
            } else {
                y.a aVarK = y.k();
                aVarK.a(new AdaptationCheckpoint(0L, 0L));
                arrayList.add(aVarK);
            }
        }
        long[][] sortedTrackBitrates = getSortedTrackBitrates(definitionArr);
        int[] iArr = new int[sortedTrackBitrates.length];
        long[] jArr = new long[sortedTrackBitrates.length];
        for (int i10 = 0; i10 < sortedTrackBitrates.length; i10++) {
            long[] jArr2 = sortedTrackBitrates[i10];
            jArr[i10] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        addCheckpoint(arrayList, jArr);
        y<Integer> switchOrder = getSwitchOrder(sortedTrackBitrates);
        for (int i11 = 0; i11 < switchOrder.size(); i11++) {
            int iIntValue = switchOrder.get(i11).intValue();
            int i12 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i12;
            jArr[iIntValue] = sortedTrackBitrates[iIntValue][i12];
            addCheckpoint(arrayList, jArr);
        }
        for (int i13 = 0; i13 < definitionArr.length; i13++) {
            if (arrayList.get(i13) != null) {
                jArr[i13] = jArr[i13] * 2;
            }
        }
        addCheckpoint(arrayList, jArr);
        y.a aVarK2 = y.k();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            y.a aVar = (y.a) arrayList.get(i14);
            aVarK2.a(aVar == null ? y.q() : aVar.k());
        }
        return aVarK2.k();
    }

    private long getAllocatedBandwidth(long j10) {
        long totalAllocatableBandwidth = getTotalAllocatableBandwidth(j10);
        if (this.adaptationCheckpoints.isEmpty()) {
            return totalAllocatableBandwidth;
        }
        int i10 = 1;
        while (i10 < this.adaptationCheckpoints.size() - 1 && this.adaptationCheckpoints.get(i10).totalBandwidth < totalAllocatableBandwidth) {
            i10++;
        }
        AdaptationCheckpoint adaptationCheckpoint = this.adaptationCheckpoints.get(i10 - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = this.adaptationCheckpoints.get(i10);
        long j11 = adaptationCheckpoint.totalBandwidth;
        float f10 = (totalAllocatableBandwidth - j11) / (adaptationCheckpoint2.totalBandwidth - j11);
        return adaptationCheckpoint.allocatedBandwidth + ((long) (f10 * (adaptationCheckpoint2.allocatedBandwidth - r2)));
    }

    private long getLastChunkDurationUs(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        MediaChunk mediaChunk = (MediaChunk) g0.d(list);
        long j10 = mediaChunk.startTimeUs;
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j11 = mediaChunk.endTimeUs;
        return j11 != C.TIME_UNSET ? j11 - j10 : C.TIME_UNSET;
    }

    private long getNextChunkDurationUs(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i10 = this.selectedIndex;
        if (i10 < mediaChunkIteratorArr.length && mediaChunkIteratorArr[i10].next()) {
            MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[this.selectedIndex];
            return mediaChunkIterator.getChunkEndTimeUs() - mediaChunkIterator.getChunkStartTimeUs();
        }
        for (MediaChunkIterator mediaChunkIterator2 : mediaChunkIteratorArr) {
            if (mediaChunkIterator2.next()) {
                return mediaChunkIterator2.getChunkEndTimeUs() - mediaChunkIterator2.getChunkStartTimeUs();
            }
        }
        return getLastChunkDurationUs(list);
    }

    private static long[][] getSortedTrackBitrates(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i10 = 0; i10 < definitionArr.length; i10++) {
            ExoTrackSelection.Definition definition = definitionArr[i10];
            if (definition == null) {
                jArr[i10] = new long[0];
            } else {
                jArr[i10] = new long[definition.tracks.length];
                int i11 = 0;
                while (true) {
                    int[] iArr = definition.tracks;
                    if (i11 >= iArr.length) {
                        break;
                    }
                    long j10 = definition.group.getFormat(iArr[i11]).bitrate;
                    long[] jArr2 = jArr[i10];
                    if (j10 == -1) {
                        j10 = 0;
                    }
                    jArr2[i11] = j10;
                    i11++;
                }
                Arrays.sort(jArr[i10]);
            }
        }
        return jArr;
    }

    private static y<Integer> getSwitchOrder(long[][] jArr) {
        l0 l0VarE = m0.c().a().e();
        for (int i10 = 0; i10 < jArr.length; i10++) {
            long[] jArr2 = jArr[i10];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i11 = 0;
                while (true) {
                    long[] jArr3 = jArr[i10];
                    double dLog = 0.0d;
                    if (i11 >= jArr3.length) {
                        break;
                    }
                    long j10 = jArr3[i11];
                    if (j10 != -1) {
                        dLog = Math.log(j10);
                    }
                    dArr[i11] = dLog;
                    i11++;
                }
                int i12 = length - 1;
                double d10 = dArr[i12] - dArr[0];
                int i13 = 0;
                while (i13 < i12) {
                    double d11 = dArr[i13];
                    i13++;
                    l0VarE.put(Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i13]) * 0.5d) - dArr[0]) / d10), Integer.valueOf(i10));
                }
            }
        }
        return y.m(l0VarE.values());
    }

    private long getTotalAllocatableBandwidth(long j10) {
        long bitrateEstimate = this.bandwidthMeter.getBitrateEstimate();
        this.latestBitrateEstimate = bitrateEstimate;
        long j11 = (long) (bitrateEstimate * this.bandwidthFraction);
        long timeToFirstByteEstimateUs = this.bandwidthMeter.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == C.TIME_UNSET || j10 == C.TIME_UNSET) {
            return (long) (j11 / this.playbackSpeed);
        }
        float f10 = j10;
        return (long) ((j11 * Math.max((f10 / this.playbackSpeed) - timeToFirstByteEstimateUs, 0.0f)) / f10);
    }

    private long minDurationForQualityIncreaseUs(long j10, long j11) {
        if (j10 == C.TIME_UNSET) {
            return this.minDurationForQualityIncreaseUs;
        }
        if (j11 != C.TIME_UNSET) {
            j10 -= j11;
        }
        return Math.min((long) (j10 * this.bufferedFractionToLiveEdgeForQualityIncrease), this.minDurationForQualityIncreaseUs);
    }

    protected boolean canSelectFormat(Format format, int i10, long j10) {
        return ((long) i10) <= j10;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    @CallSuper
    public void disable() {
        this.lastBufferEvaluationMediaChunk = null;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    @CallSuper
    public void enable() {
        this.lastBufferEvaluationMs = C.TIME_UNSET;
        this.lastBufferEvaluationMediaChunk = null;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j10, List<? extends MediaChunk> list) {
        int i10;
        int i11;
        long jElapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(jElapsedRealtime, list)) {
            return list.size();
        }
        this.lastBufferEvaluationMs = jElapsedRealtime;
        this.lastBufferEvaluationMediaChunk = list.isEmpty() ? null : (MediaChunk) g0.d(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j10, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(jElapsedRealtime, getLastChunkDurationUs(list)));
        for (int i12 = 0; i12 < size; i12++) {
            MediaChunk mediaChunk = list.get(i12);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j10, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i10 = format2.height) != -1 && i10 <= this.maxHeightToDiscard && (i11 = format2.width) != -1 && i11 <= this.maxWidthToDiscard && i10 < format.height) {
                return i12;
            }
        }
        return size;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public long getLatestBitrateEstimate() {
        return this.latestBitrateEstimate;
    }

    protected long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // androidx.media3.exoplayer.trackselection.BaseTrackSelection, androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f10) {
        this.playbackSpeed = f10;
    }

    protected boolean shouldEvaluateQueueSize(long j10, List<? extends MediaChunk> list) {
        long j11 = this.lastBufferEvaluationMs;
        return j11 == C.TIME_UNSET || j10 - j11 >= 1000 || !(list.isEmpty() || ((MediaChunk) g0.d(list)).equals(this.lastBufferEvaluationMediaChunk));
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void updateSelectedTrack(long j10, long j11, long j12, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = this.clock.elapsedRealtime();
        long nextChunkDurationUs = getNextChunkDurationUs(mediaChunkIteratorArr, list);
        int i10 = this.reason;
        if (i10 == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(jElapsedRealtime, nextChunkDurationUs);
            return;
        }
        int i11 = this.selectedIndex;
        int iIndexOf = list.isEmpty() ? -1 : indexOf(((MediaChunk) g0.d(list)).trackFormat);
        if (iIndexOf != -1) {
            i10 = ((MediaChunk) g0.d(list)).trackSelectionReason;
            i11 = iIndexOf;
        }
        int iDetermineIdealSelectedIndex = determineIdealSelectedIndex(jElapsedRealtime, nextChunkDurationUs);
        if (iDetermineIdealSelectedIndex != i11 && !isTrackExcluded(i11, jElapsedRealtime)) {
            Format format = getFormat(i11);
            Format format2 = getFormat(iDetermineIdealSelectedIndex);
            long jMinDurationForQualityIncreaseUs = minDurationForQualityIncreaseUs(j12, nextChunkDurationUs);
            int i12 = format2.bitrate;
            int i13 = format.bitrate;
            if ((i12 > i13 && j11 < jMinDurationForQualityIncreaseUs) || (i12 < i13 && j11 >= this.maxDurationForQualityDecreaseUs)) {
                iDetermineIdealSelectedIndex = i11;
            }
        }
        if (iDetermineIdealSelectedIndex != i11) {
            i10 = 3;
        }
        this.reason = i10;
        this.selectedIndex = iDetermineIdealSelectedIndex;
    }

    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i10, BandwidthMeter bandwidthMeter, long j10, long j11, long j12, int i11, int i12, float f10, float f11, List<AdaptationCheckpoint> list, Clock clock) {
        BandwidthMeter bandwidthMeter2;
        long j13;
        super(trackGroup, iArr, i10);
        if (j12 < j10) {
            Log.w(TAG, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter2 = bandwidthMeter;
            j13 = j10;
        } else {
            bandwidthMeter2 = bandwidthMeter;
            j13 = j12;
        }
        this.bandwidthMeter = bandwidthMeter2;
        this.minDurationForQualityIncreaseUs = j10 * 1000;
        this.maxDurationForQualityDecreaseUs = j11 * 1000;
        this.minDurationToRetainAfterDiscardUs = j13 * 1000;
        this.maxWidthToDiscard = i11;
        this.maxHeightToDiscard = i12;
        this.bandwidthFraction = f10;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f11;
        this.adaptationCheckpoints = y.m(list);
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = C.TIME_UNSET;
        this.latestBitrateEstimate = -2147483647L;
    }
}
