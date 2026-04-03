package k2;

import k2.w1;

/* JADX INFO: compiled from: LivePlaybackSpeedControl.java */
/* JADX INFO: loaded from: classes2.dex */
public interface t1 {
    void a(w1.g gVar);

    float getAdjustedPlaybackSpeed(long j10, long j11);

    long getTargetLiveOffsetUs();

    void notifyRebuffer();

    void setTargetLiveOffsetOverrideUs(long j10);
}
