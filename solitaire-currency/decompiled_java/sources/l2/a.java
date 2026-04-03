package l2;

import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.List;
import k2.r2;
import l3.a0;
import z3.e;

/* JADX INFO: compiled from: AnalyticsCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends r2.d, l3.g0, e.a, o2.w {
    void I(c cVar);

    void b(n2.e eVar);

    void c(n2.e eVar);

    void d(k2.o1 o1Var, @Nullable n2.i iVar);

    void e(k2.o1 o1Var, @Nullable n2.i iVar);

    void g(n2.e eVar);

    void i(n2.e eVar);

    void l(r2 r2Var, Looper looper);

    void notifySeekStarted();

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j10, long j11);

    void onAudioDecoderReleased(String str);

    void onAudioPositionAdvancing(long j10);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i10, long j10, long j11);

    void onDroppedFrames(int i10, long j10);

    void onRenderedFirstFrame(Object obj, long j10);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j10, long j11);

    void onVideoDecoderReleased(String str);

    void onVideoFrameProcessingOffset(long j10, int i10);

    void r(List<a0.b> list, @Nullable a0.b bVar);

    void release();
}
