package androidx.media3.common.util;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ConstantRateTimestampIterator implements TimestampIterator {
    private double currentTimestampUs;
    private final long durationUs;
    private final float frameRate;
    private final double framesDurationUs;
    private int framesToAdd;
    private final long startingTimestampUs;

    public ConstantRateTimestampIterator(@IntRange(from = 1) long j10, @FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        this(j10, f10, 0L);
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public boolean hasNext() {
        return this.framesToAdd != 0;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public long next() {
        Assertions.checkState(hasNext());
        this.framesToAdd--;
        long jRound = Math.round(this.currentTimestampUs);
        this.currentTimestampUs += this.framesDurationUs;
        return jRound;
    }

    public ConstantRateTimestampIterator(@IntRange(from = 1) long j10, @FloatRange(from = 0.0d, fromInclusive = false) float f10, @IntRange(from = 0) long j11) {
        Assertions.checkArgument(j10 > 0);
        Assertions.checkArgument(f10 > 0.0f);
        Assertions.checkArgument(j11 >= 0);
        this.durationUs = j10;
        this.frameRate = f10;
        this.startingTimestampUs = j11;
        this.currentTimestampUs = j11;
        this.framesToAdd = Math.round((j10 / 1000000.0f) * f10);
        this.framesDurationUs = 1000000.0f / f10;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public ConstantRateTimestampIterator copyOf() {
        return new ConstantRateTimestampIterator(this.durationUs, this.frameRate, this.startingTimestampUs);
    }
}
