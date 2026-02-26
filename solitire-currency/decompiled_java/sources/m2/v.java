package m2;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import k2.o1;
import k2.q2;
import l2.t1;

/* JADX INFO: compiled from: AudioSink.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v {

    /* JADX INFO: compiled from: AudioSink.java */
    public static final class b extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f31379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o1 f31380c;

        public b(int i10, int i11, int i12, int i13, o1 o1Var, boolean z10, @Nullable Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(i10);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i11);
            sb.append(", ");
            sb.append(i12);
            sb.append(", ");
            sb.append(i13);
            sb.append(")");
            sb.append(z10 ? " (recoverable)" : "");
            super(sb.toString(), exc);
            this.f31378a = i10;
            this.f31379b = z10;
            this.f31380c = o1Var;
        }
    }

    /* JADX INFO: compiled from: AudioSink.java */
    public interface c {
        void onAudioSinkError(Exception exc);

        void onOffloadBufferEmptying();

        void onOffloadBufferFull();

        void onPositionAdvancing(long j10);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z10);

        void onUnderrun(int i10, long j10, long j11);
    }

    /* JADX INFO: compiled from: AudioSink.java */
    public static final class d extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f31382b;

        public d(long j10, long j11) {
            super("Unexpected audio track timestamp discontinuity: expected " + j11 + ", got " + j10);
            this.f31381a = j10;
            this.f31382b = j11;
        }
    }

    /* JADX INFO: compiled from: AudioSink.java */
    public static final class e extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f31384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o1 f31385c;

        public e(int i10, o1 o1Var, boolean z10) {
            super("AudioTrack write failed: " + i10);
            this.f31384b = z10;
            this.f31383a = i10;
            this.f31385c = o1Var;
        }
    }

    boolean a(o1 o1Var);

    void b(q2 q2Var);

    void c(o1 o1Var, int i10, @Nullable int[] iArr) throws a;

    void d(y yVar);

    void disableTunneling();

    void e();

    void enableTunnelingV21();

    void f(c cVar);

    void flush();

    int g(o1 o1Var);

    long getCurrentPositionUs(boolean z10);

    q2 getPlaybackParameters();

    void h(m2.e eVar);

    boolean handleBuffer(ByteBuffer byteBuffer, long j10, int i10) throws e, b;

    void handleDiscontinuity();

    boolean hasPendingData();

    void i(@Nullable t1 t1Var);

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws e;

    void reset();

    void setAudioSessionId(int i10);

    void setOutputStreamOffsetUs(long j10);

    @RequiresApi(23)
    void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo);

    void setSkipSilenceEnabled(boolean z10);

    void setVolume(float f10);

    /* JADX INFO: compiled from: AudioSink.java */
    public static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1 f31377a;

        public a(Throwable th, o1 o1Var) {
            super(th);
            this.f31377a = o1Var;
        }

        public a(String str, o1 o1Var) {
            super(str);
            this.f31377a = o1Var;
        }
    }
}
