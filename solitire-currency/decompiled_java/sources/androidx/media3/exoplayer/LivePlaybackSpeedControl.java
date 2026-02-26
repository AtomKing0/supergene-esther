package androidx.media3.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface LivePlaybackSpeedControl {
    float getAdjustedPlaybackSpeed(long j10, long j11);

    long getTargetLiveOffsetUs();

    void notifyRebuffer();

    void setLiveConfiguration(MediaItem.LiveConfiguration liveConfiguration);

    void setTargetLiveOffsetOverrideUs(long j10);
}
