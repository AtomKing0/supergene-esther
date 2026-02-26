package k2;

import androidx.annotation.Nullable;
import java.io.IOException;
import k2.v2;

/* JADX INFO: compiled from: Renderer.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a3 extends v2.b {

    /* JADX INFO: compiled from: Renderer.java */
    public interface a {
        void onSleep();

        void onWakeup();
    }

    void c(d3 d3Var, o1[] o1VarArr, l3.u0 u0Var, long j10, boolean z10, boolean z11, long j11, long j12) throws q;

    void d(int i10, l2.t1 t1Var);

    void disable();

    void e(o1[] o1VarArr, l3.u0 u0Var, long j10, long j11) throws q;

    c3 getCapabilities();

    @Nullable
    a4.v getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    @Nullable
    l3.u0 getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j10, long j11) throws q;

    void reset();

    void resetPosition(long j10) throws q;

    void setCurrentStreamFinal();

    void setPlaybackSpeed(float f10, float f11) throws q;

    void start() throws q;

    void stop();
}
