package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: TimeBar.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f0 {

    /* JADX INFO: compiled from: TimeBar.java */
    public interface a {
        void k(f0 f0Var, long j10);

        void n(f0 f0Var, long j10, boolean z10);

        void o(f0 f0Var, long j10);
    }

    void a(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i10);

    void setBufferedPosition(long j10);

    void setDuration(long j10);

    void setEnabled(boolean z10);

    void setPosition(long j10);
}
