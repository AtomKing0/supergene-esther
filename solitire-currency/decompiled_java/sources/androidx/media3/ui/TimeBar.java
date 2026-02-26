package androidx.media3.ui;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface TimeBar {

    public interface OnScrubListener {
        void onScrubMove(TimeBar timeBar, long j10);

        void onScrubStart(TimeBar timeBar, long j10);

        void onScrubStop(TimeBar timeBar, long j10, boolean z10);
    }

    void addListener(OnScrubListener onScrubListener);

    long getPreferredUpdateDelay();

    void removeListener(OnScrubListener onScrubListener);

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i10);

    void setBufferedPosition(long j10);

    void setDuration(long j10);

    void setEnabled(boolean z10);

    void setKeyCountIncrement(int i10);

    void setKeyTimeIncrement(long j10);

    void setPosition(long j10);
}
