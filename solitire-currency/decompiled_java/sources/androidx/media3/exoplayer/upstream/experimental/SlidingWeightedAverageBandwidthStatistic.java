package androidx.media3.exoplayer.upstream.experimental;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class SlidingWeightedAverageBandwidthStatistic implements BandwidthStatistic {
    public static final int DEFAULT_MAX_SAMPLES_COUNT = 10;
    private double bitrateWeightProductSum;
    private final Clock clock;
    private final SampleEvictionFunction sampleEvictionFunction;
    private final ArrayDeque<Sample> samples;
    private double weightSum;

    public static class Sample {
        public final long bitrate;
        public final long timeAddedMs;
        public final double weight;

        public Sample(long j10, double d10, long j11) {
            this.bitrate = j10;
            this.weight = d10;
            this.timeAddedMs = j11;
        }
    }

    public interface SampleEvictionFunction {
        boolean shouldEvictSample(Deque<Sample> deque);
    }

    public SlidingWeightedAverageBandwidthStatistic() {
        this(getMaxCountEvictionFunction(10L));
    }

    public static SampleEvictionFunction getAgeBasedEvictionFunction(long j10) {
        return getAgeBasedEvictionFunction(j10, Clock.DEFAULT);
    }

    public static SampleEvictionFunction getMaxCountEvictionFunction(final long j10) {
        return new SampleEvictionFunction() { // from class: androidx.media3.exoplayer.upstream.experimental.b
            @Override // androidx.media3.exoplayer.upstream.experimental.SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction
            public final boolean shouldEvictSample(Deque deque) {
                return SlidingWeightedAverageBandwidthStatistic.lambda$getMaxCountEvictionFunction$0(j10, deque);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAgeBasedEvictionFunction$1(long j10, Clock clock, Deque deque) {
        return !deque.isEmpty() && ((Sample) Util.castNonNull((Sample) deque.peek())).timeAddedMs + j10 < clock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMaxCountEvictionFunction$0(long j10, Deque deque) {
        return ((long) deque.size()) >= j10;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void addSample(long j10, long j11) {
        while (this.sampleEvictionFunction.shouldEvictSample(this.samples)) {
            Sample sampleRemove = this.samples.remove();
            double d10 = this.bitrateWeightProductSum;
            double d11 = sampleRemove.bitrate;
            double d12 = sampleRemove.weight;
            this.bitrateWeightProductSum = d10 - (d11 * d12);
            this.weightSum -= d12;
        }
        Sample sample = new Sample((j10 * 8000000) / j11, Math.sqrt(j10), this.clock.elapsedRealtime());
        this.samples.add(sample);
        double d13 = this.bitrateWeightProductSum;
        double d14 = sample.bitrate;
        double d15 = sample.weight;
        this.bitrateWeightProductSum = d13 + (d14 * d15);
        this.weightSum += d15;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public long getBandwidthEstimate() {
        if (this.samples.isEmpty()) {
            return Long.MIN_VALUE;
        }
        return (long) (this.bitrateWeightProductSum / this.weightSum);
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void reset() {
        this.samples.clear();
        this.bitrateWeightProductSum = 0.0d;
        this.weightSum = 0.0d;
    }

    public SlidingWeightedAverageBandwidthStatistic(SampleEvictionFunction sampleEvictionFunction) {
        this(sampleEvictionFunction, Clock.DEFAULT);
    }

    @VisibleForTesting
    static SampleEvictionFunction getAgeBasedEvictionFunction(final long j10, final Clock clock) {
        return new SampleEvictionFunction() { // from class: androidx.media3.exoplayer.upstream.experimental.c
            @Override // androidx.media3.exoplayer.upstream.experimental.SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction
            public final boolean shouldEvictSample(Deque deque) {
                return SlidingWeightedAverageBandwidthStatistic.lambda$getAgeBasedEvictionFunction$1(j10, clock, deque);
            }
        };
    }

    @VisibleForTesting
    SlidingWeightedAverageBandwidthStatistic(SampleEvictionFunction sampleEvictionFunction, Clock clock) {
        this.samples = new ArrayDeque<>();
        this.sampleEvictionFunction = sampleEvictionFunction;
        this.clock = clock;
    }
}
