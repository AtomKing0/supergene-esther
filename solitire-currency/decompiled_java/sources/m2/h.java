package m2;

import k2.q2;

/* JADX INFO: compiled from: AudioProcessorChain.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {
    q2 a(q2 q2Var);

    boolean applySkipSilenceEnabled(boolean z10);

    g[] getAudioProcessors();

    long getMediaDuration(long j10);

    long getSkippedOutputFrameCount();
}
