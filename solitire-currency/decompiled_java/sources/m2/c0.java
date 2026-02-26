package m2;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import k2.o1;
import k2.q2;
import k2.s;
import l2.t1;
import m2.d0;
import m2.g;
import m2.v;
import m2.x;

/* JADX INFO: compiled from: DefaultAudioSink.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements v {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static boolean f31169e0 = false;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final Object f31170f0 = new Object();

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @Nullable
    @GuardedBy("releaseExecutorLock")
    private static ExecutorService f31171g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @GuardedBy("releaseExecutorLock")
    private static int f31172h0;

    @Nullable
    private ByteBuffer A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private boolean H;
    private boolean I;
    private long J;
    private float K;
    private m2.g[] L;
    private ByteBuffer[] M;

    @Nullable
    private ByteBuffer N;
    private int O;

    @Nullable
    private ByteBuffer P;
    private byte[] Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private y Y;

    @Nullable
    private d Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m2.f f31173a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f31174a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m2.h f31175b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private long f31176b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f31177c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f31178c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a0 f31179d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f31180d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final n0 f31181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m2.g[] f31182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m2.g[] f31183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a4.g f31184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final x f31185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayDeque<j> f31186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f31187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f31188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private m f31189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final k<v.b> f31190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final k<v.e> f31191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final e f31192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private final s.a f31193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private t1 f31194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private v.c f31195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private g f31196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private g f31197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private AudioTrack f31198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private m2.e f31199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private j f31200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private j f31201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private q2 f31202z;

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    @RequiresApi(23)
    private static final class b {
        @DoNotInline
        public static void a(AudioTrack audioTrack, @Nullable d dVar) {
            audioTrack.setPreferredDevice(dVar == null ? null : dVar.f31203a);
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    @RequiresApi(31)
    private static final class c {
        @DoNotInline
        public static void a(AudioTrack audioTrack, t1 t1Var) {
            LogSessionId logSessionIdA = t1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    @RequiresApi(23)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioDeviceInfo f31203a;

        public d(AudioDeviceInfo audioDeviceInfo) {
            this.f31203a = audioDeviceInfo;
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f31204a = new d0.a().g();

        int a(int i10, int i11, int i12, int i13, int i14, double d10);
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    public static final class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private m2.h f31206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f31207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31208d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        s.a f31211g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private m2.f f31205a = m2.f.f31266c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f31209e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        e f31210f = e.f31204a;

        public c0 f() {
            if (this.f31206b == null) {
                this.f31206b = new h(new m2.g[0]);
            }
            return new c0(this);
        }

        public f g(m2.f fVar) {
            a4.a.e(fVar);
            this.f31205a = fVar;
            return this;
        }

        public f h(boolean z10) {
            this.f31208d = z10;
            return this;
        }

        public f i(boolean z10) {
            this.f31207c = z10;
            return this;
        }

        public f j(int i10) {
            this.f31209e = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1 f31212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f31215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f31216e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f31217f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f31218g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f31219h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final m2.g[] f31220i;

        public g(o1 o1Var, int i10, int i11, int i12, int i13, int i14, int i15, int i16, m2.g[] gVarArr) {
            this.f31212a = o1Var;
            this.f31213b = i10;
            this.f31214c = i11;
            this.f31215d = i12;
            this.f31216e = i13;
            this.f31217f = i14;
            this.f31218g = i15;
            this.f31219h = i16;
            this.f31220i = gVarArr;
        }

        private AudioTrack d(boolean z10, m2.e eVar, int i10) {
            int i11 = a4.o0.f214a;
            return i11 >= 29 ? f(z10, eVar, i10) : i11 >= 21 ? e(z10, eVar, i10) : g(eVar, i10);
        }

        @RequiresApi(21)
        private AudioTrack e(boolean z10, m2.e eVar, int i10) {
            return new AudioTrack(i(eVar, z10), c0.y(this.f31216e, this.f31217f, this.f31218g), this.f31219h, 1, i10);
        }

        @RequiresApi(29)
        private AudioTrack f(boolean z10, m2.e eVar, int i10) {
            return new AudioTrack.Builder().setAudioAttributes(i(eVar, z10)).setAudioFormat(c0.y(this.f31216e, this.f31217f, this.f31218g)).setTransferMode(1).setBufferSizeInBytes(this.f31219h).setSessionId(i10).setOffloadedPlayback(this.f31214c == 1).build();
        }

        private AudioTrack g(m2.e eVar, int i10) {
            int iA0 = a4.o0.a0(eVar.f31253c);
            return i10 == 0 ? new AudioTrack(iA0, this.f31216e, this.f31217f, this.f31218g, this.f31219h, 1) : new AudioTrack(iA0, this.f31216e, this.f31217f, this.f31218g, this.f31219h, 1, i10);
        }

        @RequiresApi(21)
        private static AudioAttributes i(m2.e eVar, boolean z10) {
            return z10 ? j() : eVar.b().f31257a;
        }

        @RequiresApi(21)
        private static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z10, m2.e eVar, int i10) throws v.b {
            try {
                AudioTrack audioTrackD = d(z10, eVar, i10);
                int state = audioTrackD.getState();
                if (state == 1) {
                    return audioTrackD;
                }
                try {
                    audioTrackD.release();
                } catch (Exception unused) {
                }
                throw new v.b(state, this.f31216e, this.f31217f, this.f31219h, this.f31212a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e10) {
                throw new v.b(0, this.f31216e, this.f31217f, this.f31219h, this.f31212a, l(), e10);
            }
        }

        public boolean b(g gVar) {
            return gVar.f31214c == this.f31214c && gVar.f31218g == this.f31218g && gVar.f31216e == this.f31216e && gVar.f31217f == this.f31217f && gVar.f31215d == this.f31215d;
        }

        public g c(int i10) {
            return new g(this.f31212a, this.f31213b, this.f31214c, this.f31215d, this.f31216e, this.f31217f, this.f31218g, i10, this.f31220i);
        }

        public long h(long j10) {
            return (j10 * 1000000) / ((long) this.f31216e);
        }

        public long k(long j10) {
            return (j10 * 1000000) / ((long) this.f31212a.f29361z);
        }

        public boolean l() {
            return this.f31214c == 1;
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    public static class h implements m2.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m2.g[] f31221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k0 f31222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m0 f31223c;

        public h(m2.g... gVarArr) {
            this(gVarArr, new k0(), new m0());
        }

        @Override // m2.h
        public q2 a(q2 q2Var) {
            this.f31223c.d(q2Var.f29421a);
            this.f31223c.c(q2Var.f29422b);
            return q2Var;
        }

        @Override // m2.h
        public boolean applySkipSilenceEnabled(boolean z10) {
            this.f31222b.q(z10);
            return z10;
        }

        @Override // m2.h
        public m2.g[] getAudioProcessors() {
            return this.f31221a;
        }

        @Override // m2.h
        public long getMediaDuration(long j10) {
            return this.f31223c.b(j10);
        }

        @Override // m2.h
        public long getSkippedOutputFrameCount() {
            return this.f31222b.k();
        }

        public h(m2.g[] gVarArr, k0 k0Var, m0 m0Var) {
            m2.g[] gVarArr2 = new m2.g[gVarArr.length + 2];
            this.f31221a = gVarArr2;
            System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
            this.f31222b = k0Var;
            this.f31223c = m0Var;
            gVarArr2[gVarArr.length] = k0Var;
            gVarArr2[gVarArr.length + 1] = m0Var;
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    public static final class i extends RuntimeException {
        private i(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    private static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q2 f31224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f31225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f31226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f31227d;

        private j(q2 q2Var, boolean z10, long j10, long j11) {
            this.f31224a = q2Var;
            this.f31225b = z10;
            this.f31226c = j10;
            this.f31227d = j11;
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    private static final class k<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f31228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private T f31229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f31230c;

        public k(long j10) {
            this.f31228a = j10;
        }

        public void a() {
            this.f31229b = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void b(T t10) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f31229b == null) {
                this.f31229b = t10;
                this.f31230c = this.f31228a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f31230c) {
                T t11 = this.f31229b;
                if (t11 != t10) {
                    t11.addSuppressed(t10);
                }
                T t12 = this.f31229b;
                a();
                throw t12;
            }
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    private final class l implements x.a {
        private l() {
        }

        @Override // m2.x.a
        public void onInvalidLatency(long j10) {
            a4.t.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j10);
        }

        @Override // m2.x.a
        public void onPositionAdvancing(long j10) {
            if (c0.this.f31195s != null) {
                c0.this.f31195s.onPositionAdvancing(j10);
            }
        }

        @Override // m2.x.a
        public void onPositionFramesMismatch(long j10, long j11, long j12, long j13) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j10 + ", " + j11 + ", " + j12 + ", " + j13 + ", " + c0.this.F() + ", " + c0.this.G();
            if (c0.f31169e0) {
                throw new i(str);
            }
            a4.t.i("DefaultAudioSink", str);
        }

        @Override // m2.x.a
        public void onSystemTimeUsMismatch(long j10, long j11, long j12, long j13) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j10 + ", " + j11 + ", " + j12 + ", " + j13 + ", " + c0.this.F() + ", " + c0.this.G();
            if (c0.f31169e0) {
                throw new i(str);
            }
            a4.t.i("DefaultAudioSink", str);
        }

        @Override // m2.x.a
        public void onUnderrun(int i10, long j10) {
            if (c0.this.f31195s != null) {
                c0.this.f31195s.onUnderrun(i10, j10, SystemClock.elapsedRealtime() - c0.this.f31176b0);
            }
        }
    }

    /* JADX INFO: compiled from: DefaultAudioSink.java */
    @RequiresApi(29)
    private final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f31232a = new Handler(Looper.myLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f31233b;

        /* JADX INFO: compiled from: DefaultAudioSink.java */
        class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c0 f31235a;

            a(c0 c0Var) {
                this.f31235a = c0Var;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i10) {
                if (audioTrack.equals(c0.this.f31198v) && c0.this.f31195s != null && c0.this.V) {
                    c0.this.f31195s.onOffloadBufferEmptying();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(c0.this.f31198v) && c0.this.f31195s != null && c0.this.V) {
                    c0.this.f31195s.onOffloadBufferEmptying();
                }
            }
        }

        public m() {
            this.f31233b = new a(c0.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f31232a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new androidx.emoji2.text.b(handler), this.f31233b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f31233b);
            this.f31232a.removeCallbacksAndMessages(null);
        }
    }

    private static int A(int i10, int i11, int i12) {
        int minBufferSize = AudioTrack.getMinBufferSize(i10, i11, i12);
        a4.a.g(minBufferSize != -2);
        return minBufferSize;
    }

    private static int B(int i10, ByteBuffer byteBuffer) {
        switch (i10) {
            case 5:
            case 6:
            case 18:
                return m2.b.d(byteBuffer);
            case 7:
            case 8:
                return e0.e(byteBuffer);
            case 9:
                int iM = h0.m(a4.o0.F(byteBuffer, byteBuffer.position()));
                if (iM != -1) {
                    return iM;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i10);
            case 14:
                int iA = m2.b.a(byteBuffer);
                if (iA == -1) {
                    return 0;
                }
                return m2.b.h(byteBuffer, iA) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return m2.c.c(byteBuffer);
        }
    }

    private j C() {
        j jVar = this.f31200x;
        return jVar != null ? jVar : !this.f31186j.isEmpty() ? this.f31186j.getLast() : this.f31201y;
    }

    @RequiresApi(29)
    @SuppressLint({"InlinedApi"})
    private int D(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i10 = a4.o0.f214a;
        if (i10 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i10 == 30 && a4.o0.f217d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long F() {
        g gVar = this.f31197u;
        return gVar.f31214c == 0 ? this.C / ((long) gVar.f31213b) : this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long G() {
        g gVar = this.f31197u;
        return gVar.f31214c == 0 ? this.E / ((long) gVar.f31215d) : this.F;
    }

    private boolean H() throws v.b {
        t1 t1Var;
        if (!this.f31184h.d()) {
            return false;
        }
        AudioTrack audioTrackV = v();
        this.f31198v = audioTrackV;
        if (K(audioTrackV)) {
            P(this.f31198v);
            if (this.f31188l != 3) {
                AudioTrack audioTrack = this.f31198v;
                o1 o1Var = this.f31197u.f31212a;
                audioTrack.setOffloadDelayPadding(o1Var.B, o1Var.C);
            }
        }
        int i10 = a4.o0.f214a;
        if (i10 >= 31 && (t1Var = this.f31194r) != null) {
            c.a(this.f31198v, t1Var);
        }
        this.X = this.f31198v.getAudioSessionId();
        x xVar = this.f31185i;
        AudioTrack audioTrack2 = this.f31198v;
        g gVar = this.f31197u;
        xVar.s(audioTrack2, gVar.f31214c == 2, gVar.f31218g, gVar.f31215d, gVar.f31219h);
        U();
        int i11 = this.Y.f31423a;
        if (i11 != 0) {
            this.f31198v.attachAuxEffect(i11);
            this.f31198v.setAuxEffectSendLevel(this.Y.f31424b);
        }
        d dVar = this.Z;
        if (dVar != null && i10 >= 23) {
            b.a(this.f31198v, dVar);
        }
        this.I = true;
        return true;
    }

    private static boolean I(int i10) {
        return (a4.o0.f214a >= 24 && i10 == -6) || i10 == -32;
    }

    private boolean J() {
        return this.f31198v != null;
    }

    private static boolean K(AudioTrack audioTrack) {
        return a4.o0.f214a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(AudioTrack audioTrack, a4.g gVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            gVar.e();
            synchronized (f31170f0) {
                int i10 = f31172h0 - 1;
                f31172h0 = i10;
                if (i10 == 0) {
                    f31171g0.shutdown();
                    f31171g0 = null;
                }
            }
        } catch (Throwable th) {
            gVar.e();
            synchronized (f31170f0) {
                int i11 = f31172h0 - 1;
                f31172h0 = i11;
                if (i11 == 0) {
                    f31171g0.shutdown();
                    f31171g0 = null;
                }
                throw th;
            }
        }
    }

    private void M() {
        if (this.f31197u.l()) {
            this.f31178c0 = true;
        }
    }

    private void N() {
        if (this.U) {
            return;
        }
        this.U = true;
        this.f31185i.g(G());
        this.f31198v.stop();
        this.B = 0;
    }

    private void O(long j10) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.L.length;
        int i10 = length;
        while (i10 >= 0) {
            if (i10 > 0) {
                byteBuffer = this.M[i10 - 1];
            } else {
                byteBuffer = this.N;
                if (byteBuffer == null) {
                    byteBuffer = m2.g.f31273a;
                }
            }
            if (i10 == length) {
                b0(byteBuffer, j10);
            } else {
                m2.g gVar = this.L[i10];
                if (i10 > this.S) {
                    gVar.queueInput(byteBuffer);
                }
                ByteBuffer output = gVar.getOutput();
                this.M[i10] = output;
                if (output.hasRemaining()) {
                    i10++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i10--;
            }
        }
    }

    @RequiresApi(29)
    private void P(AudioTrack audioTrack) {
        if (this.f31189m == null) {
            this.f31189m = new m();
        }
        this.f31189m.a(audioTrack);
    }

    private static void Q(final AudioTrack audioTrack, final a4.g gVar) {
        gVar.c();
        synchronized (f31170f0) {
            if (f31171g0 == null) {
                f31171g0 = a4.o0.x0("ExoPlayer:AudioTrackReleaseThread");
            }
            f31172h0++;
            f31171g0.execute(new Runnable() { // from class: m2.b0
                @Override // java.lang.Runnable
                public final void run() {
                    c0.L(audioTrack, gVar);
                }
            });
        }
    }

    private void R() {
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.f31180d0 = false;
        this.G = 0;
        this.f31201y = new j(z(), E(), 0L, 0L);
        this.J = 0L;
        this.f31200x = null;
        this.f31186j.clear();
        this.N = null;
        this.O = 0;
        this.P = null;
        this.U = false;
        this.T = false;
        this.S = -1;
        this.A = null;
        this.B = 0;
        this.f31181e.i();
        x();
    }

    private void S(q2 q2Var, boolean z10) {
        j jVarC = C();
        if (q2Var.equals(jVarC.f31224a) && z10 == jVarC.f31225b) {
            return;
        }
        j jVar = new j(q2Var, z10, C.TIME_UNSET, C.TIME_UNSET);
        if (J()) {
            this.f31200x = jVar;
        } else {
            this.f31201y = jVar;
        }
    }

    @RequiresApi(23)
    private void T(q2 q2Var) {
        if (J()) {
            try {
                this.f31198v.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(q2Var.f29421a).setPitch(q2Var.f29422b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e10) {
                a4.t.j("DefaultAudioSink", "Failed to set playback params", e10);
            }
            q2Var = new q2(this.f31198v.getPlaybackParams().getSpeed(), this.f31198v.getPlaybackParams().getPitch());
            this.f31185i.t(q2Var.f29421a);
        }
        this.f31202z = q2Var;
    }

    private void U() {
        if (J()) {
            if (a4.o0.f214a >= 21) {
                V(this.f31198v, this.K);
            } else {
                W(this.f31198v, this.K);
            }
        }
    }

    @RequiresApi(21)
    private static void V(AudioTrack audioTrack, float f10) {
        audioTrack.setVolume(f10);
    }

    private static void W(AudioTrack audioTrack, float f10) {
        audioTrack.setStereoVolume(f10, f10);
    }

    private void X() {
        m2.g[] gVarArr = this.f31197u.f31220i;
        ArrayList arrayList = new ArrayList();
        for (m2.g gVar : gVarArr) {
            if (gVar.isActive()) {
                arrayList.add(gVar);
            } else {
                gVar.flush();
            }
        }
        int size = arrayList.size();
        this.L = (m2.g[]) arrayList.toArray(new m2.g[size]);
        this.M = new ByteBuffer[size];
        x();
    }

    private boolean Y() {
        return (this.f31174a0 || !MimeTypes.AUDIO_RAW.equals(this.f31197u.f31212a.f29347l) || Z(this.f31197u.f31212a.A)) ? false : true;
    }

    private boolean Z(int i10) {
        return this.f31177c && a4.o0.n0(i10);
    }

    private boolean a0(o1 o1Var, m2.e eVar) {
        int iD;
        int iD2;
        int iD3;
        if (a4.o0.f214a < 29 || this.f31188l == 0 || (iD = a4.x.d((String) a4.a.e(o1Var.f29347l), o1Var.f29344i)) == 0 || (iD2 = a4.o0.D(o1Var.f29360y)) == 0 || (iD3 = D(y(o1Var.f29361z, iD2, iD), eVar.b().f31257a)) == 0) {
            return false;
        }
        if (iD3 == 1) {
            return ((o1Var.B != 0 || o1Var.C != 0) && (this.f31188l == 1)) ? false : true;
        }
        if (iD3 == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private void b0(ByteBuffer byteBuffer, long j10) throws Exception {
        int iC0;
        v.c cVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.P;
            if (byteBuffer2 != null) {
                a4.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.P = byteBuffer;
                if (a4.o0.f214a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.Q;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.Q = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.Q, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.R = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (a4.o0.f214a < 21) {
                int iC = this.f31185i.c(this.E);
                if (iC > 0) {
                    iC0 = this.f31198v.write(this.Q, this.R, Math.min(iRemaining2, iC));
                    if (iC0 > 0) {
                        this.R += iC0;
                        byteBuffer.position(byteBuffer.position() + iC0);
                    }
                } else {
                    iC0 = 0;
                }
            } else if (this.f31174a0) {
                a4.a.g(j10 != C.TIME_UNSET);
                iC0 = d0(this.f31198v, byteBuffer, iRemaining2, j10);
            } else {
                iC0 = c0(this.f31198v, byteBuffer, iRemaining2);
            }
            this.f31176b0 = SystemClock.elapsedRealtime();
            if (iC0 < 0) {
                v.e eVar = new v.e(iC0, this.f31197u.f31212a, I(iC0) && this.F > 0);
                v.c cVar2 = this.f31195s;
                if (cVar2 != null) {
                    cVar2.onAudioSinkError(eVar);
                }
                if (eVar.f31384b) {
                    throw eVar;
                }
                this.f31191o.b(eVar);
                return;
            }
            this.f31191o.a();
            if (K(this.f31198v)) {
                if (this.F > 0) {
                    this.f31180d0 = false;
                }
                if (this.V && (cVar = this.f31195s) != null && iC0 < iRemaining2 && !this.f31180d0) {
                    cVar.onOffloadBufferFull();
                }
            }
            int i10 = this.f31197u.f31214c;
            if (i10 == 0) {
                this.E += (long) iC0;
            }
            if (iC0 == iRemaining2) {
                if (i10 != 0) {
                    a4.a.g(byteBuffer == this.N);
                    this.F += ((long) this.G) * ((long) this.O);
                }
                this.P = null;
            }
        }
    }

    @RequiresApi(21)
    private static int c0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i10) {
        return audioTrack.write(byteBuffer, i10, 1);
    }

    @RequiresApi(21)
    private int d0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i10, long j10) {
        if (a4.o0.f214a >= 26) {
            return audioTrack.write(byteBuffer, i10, 1, j10 * 1000);
        }
        if (this.A == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.A = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.A.putInt(1431633921);
        }
        if (this.B == 0) {
            this.A.putInt(4, i10);
            this.A.putLong(8, j10 * 1000);
            this.A.position(0);
            this.B = i10;
        }
        int iRemaining = this.A.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.A, iRemaining, 1);
            if (iWrite < 0) {
                this.B = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iC0 = c0(audioTrack, byteBuffer, i10);
        if (iC0 < 0) {
            this.B = 0;
            return iC0;
        }
        this.B -= iC0;
        return iC0;
    }

    private void r(long j10) {
        q2 q2VarA = Y() ? this.f31175b.a(z()) : q2.f29419d;
        boolean zApplySkipSilenceEnabled = Y() ? this.f31175b.applySkipSilenceEnabled(E()) : false;
        this.f31186j.add(new j(q2VarA, zApplySkipSilenceEnabled, Math.max(0L, j10), this.f31197u.h(G())));
        X();
        v.c cVar = this.f31195s;
        if (cVar != null) {
            cVar.onSkipSilenceEnabledChanged(zApplySkipSilenceEnabled);
        }
    }

    private long s(long j10) {
        while (!this.f31186j.isEmpty() && j10 >= this.f31186j.getFirst().f31227d) {
            this.f31201y = this.f31186j.remove();
        }
        j jVar = this.f31201y;
        long j11 = j10 - jVar.f31227d;
        if (jVar.f31224a.equals(q2.f29419d)) {
            return this.f31201y.f31226c + j11;
        }
        if (this.f31186j.isEmpty()) {
            return this.f31201y.f31226c + this.f31175b.getMediaDuration(j11);
        }
        j first = this.f31186j.getFirst();
        return first.f31226c - a4.o0.U(first.f31227d - j10, this.f31201y.f31224a.f29421a);
    }

    private long t(long j10) {
        return j10 + this.f31197u.h(this.f31175b.getSkippedOutputFrameCount());
    }

    private AudioTrack u(g gVar) throws v.b {
        try {
            AudioTrack audioTrackA = gVar.a(this.f31174a0, this.f31199w, this.X);
            s.a aVar = this.f31193q;
            if (aVar != null) {
                aVar.l(K(audioTrackA));
            }
            return audioTrackA;
        } catch (v.b e10) {
            v.c cVar = this.f31195s;
            if (cVar != null) {
                cVar.onAudioSinkError(e10);
            }
            throw e10;
        }
    }

    private AudioTrack v() throws v.b {
        try {
            return u((g) a4.a.e(this.f31197u));
        } catch (v.b e10) {
            g gVar = this.f31197u;
            if (gVar.f31219h > 1000000) {
                g gVarC = gVar.c(PlaybackException.CUSTOM_ERROR_CODE_BASE);
                try {
                    AudioTrack audioTrackU = u(gVarC);
                    this.f31197u = gVarC;
                    return audioTrackU;
                } catch (v.b e11) {
                    e10.addSuppressed(e11);
                    M();
                    throw e10;
                }
            }
            M();
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean w() throws java.lang.Exception {
        /*
            r9 = this;
            int r0 = r9.S
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.S = r2
        L9:
            r0 = r1
            goto Lc
        Lb:
            r0 = r2
        Lc:
            int r4 = r9.S
            m2.g[] r5 = r9.L
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.queueEndOfStream()
        L1f:
            r9.O(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.S
            int r0 = r0 + r1
            r9.S = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L3b
            r9.b0(r0, r7)
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.S = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.c0.w():boolean");
    }

    private void x() {
        int i10 = 0;
        while (true) {
            m2.g[] gVarArr = this.L;
            if (i10 >= gVarArr.length) {
                return;
            }
            m2.g gVar = gVarArr[i10];
            gVar.flush();
            this.M[i10] = gVar.getOutput();
            i10++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public static AudioFormat y(int i10, int i11, int i12) {
        return new AudioFormat.Builder().setSampleRate(i10).setChannelMask(i11).setEncoding(i12).build();
    }

    private q2 z() {
        return C().f31224a;
    }

    public boolean E() {
        return C().f31225b;
    }

    @Override // m2.v
    public boolean a(o1 o1Var) {
        return g(o1Var) != 0;
    }

    @Override // m2.v
    public void b(q2 q2Var) {
        q2 q2Var2 = new q2(a4.o0.o(q2Var.f29421a, 0.1f, 8.0f), a4.o0.o(q2Var.f29422b, 0.1f, 8.0f));
        if (!this.f31187k || a4.o0.f214a < 23) {
            S(q2Var2, E());
        } else {
            T(q2Var2);
        }
    }

    @Override // m2.v
    public void c(o1 o1Var, int i10, @Nullable int[] iArr) throws v.a {
        int i11;
        m2.g[] gVarArr;
        int i12;
        int iIntValue;
        int i13;
        int iY;
        int iD;
        int i14;
        int i15;
        int iA;
        int[] iArr2;
        if (MimeTypes.AUDIO_RAW.equals(o1Var.f29347l)) {
            a4.a.a(a4.o0.o0(o1Var.A));
            int iY2 = a4.o0.Y(o1Var.A, o1Var.f29360y);
            m2.g[] gVarArr2 = Z(o1Var.A) ? this.f31183g : this.f31182f;
            this.f31181e.j(o1Var.B, o1Var.C);
            if (a4.o0.f214a < 21 && o1Var.f29360y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i16 = 0; i16 < 6; i16++) {
                    iArr2[i16] = i16;
                }
            } else {
                iArr2 = iArr;
            }
            this.f31179d.h(iArr2);
            g.a aVar = new g.a(o1Var.f29361z, o1Var.f29360y, o1Var.A);
            for (m2.g gVar : gVarArr2) {
                try {
                    g.a aVarA = gVar.a(aVar);
                    if (gVar.isActive()) {
                        aVar = aVarA;
                    }
                } catch (g.b e10) {
                    throw new v.a(e10, o1Var);
                }
            }
            int i17 = aVar.f31277c;
            int i18 = aVar.f31275a;
            int iD2 = a4.o0.D(aVar.f31276b);
            gVarArr = gVarArr2;
            iY = a4.o0.Y(i17, aVar.f31276b);
            iD = i17;
            i12 = i18;
            iIntValue = iD2;
            i13 = iY2;
            i14 = 0;
        } else {
            m2.g[] gVarArr3 = new m2.g[0];
            int i19 = o1Var.f29361z;
            if (a0(o1Var, this.f31199w)) {
                i11 = 1;
                gVarArr = gVarArr3;
                i12 = i19;
                iD = a4.x.d((String) a4.a.e(o1Var.f29347l), o1Var.f29344i);
                i13 = -1;
                iY = -1;
                iIntValue = a4.o0.D(o1Var.f29360y);
            } else {
                Pair<Integer, Integer> pairF = this.f31173a.f(o1Var);
                if (pairF == null) {
                    throw new v.a("Unable to configure passthrough for: " + o1Var, o1Var);
                }
                int iIntValue2 = ((Integer) pairF.first).intValue();
                i11 = 2;
                gVarArr = gVarArr3;
                i12 = i19;
                iIntValue = ((Integer) pairF.second).intValue();
                i13 = -1;
                iY = -1;
                iD = iIntValue2;
            }
            i14 = i11;
        }
        if (iD == 0) {
            throw new v.a("Invalid output encoding (mode=" + i14 + ") for: " + o1Var, o1Var);
        }
        if (iIntValue == 0) {
            throw new v.a("Invalid output channel config (mode=" + i14 + ") for: " + o1Var, o1Var);
        }
        if (i10 != 0) {
            iA = i10;
            i15 = iD;
        } else {
            i15 = iD;
            iA = this.f31192p.a(A(i12, iIntValue, iD), iD, i14, iY, i12, this.f31187k ? 8.0d : 1.0d);
        }
        this.f31178c0 = false;
        g gVar2 = new g(o1Var, i13, i14, iY, i12, iIntValue, i15, iA, gVarArr);
        if (J()) {
            this.f31196t = gVar2;
        } else {
            this.f31197u = gVar2;
        }
    }

    @Override // m2.v
    public void d(y yVar) {
        if (this.Y.equals(yVar)) {
            return;
        }
        int i10 = yVar.f31423a;
        float f10 = yVar.f31424b;
        AudioTrack audioTrack = this.f31198v;
        if (audioTrack != null) {
            if (this.Y.f31423a != i10) {
                audioTrack.attachAuxEffect(i10);
            }
            if (i10 != 0) {
                this.f31198v.setAuxEffectSendLevel(f10);
            }
        }
        this.Y = yVar;
    }

    @Override // m2.v
    public void disableTunneling() {
        if (this.f31174a0) {
            this.f31174a0 = false;
            flush();
        }
    }

    @Override // m2.v
    public void e() {
        if (a4.o0.f214a < 25) {
            flush();
            return;
        }
        this.f31191o.a();
        this.f31190n.a();
        if (J()) {
            R();
            if (this.f31185i.i()) {
                this.f31198v.pause();
            }
            this.f31198v.flush();
            this.f31185i.q();
            x xVar = this.f31185i;
            AudioTrack audioTrack = this.f31198v;
            g gVar = this.f31197u;
            xVar.s(audioTrack, gVar.f31214c == 2, gVar.f31218g, gVar.f31215d, gVar.f31219h);
            this.I = true;
        }
    }

    @Override // m2.v
    public void enableTunnelingV21() {
        a4.a.g(a4.o0.f214a >= 21);
        a4.a.g(this.W);
        if (this.f31174a0) {
            return;
        }
        this.f31174a0 = true;
        flush();
    }

    @Override // m2.v
    public void f(v.c cVar) {
        this.f31195s = cVar;
    }

    @Override // m2.v
    public void flush() {
        if (J()) {
            R();
            if (this.f31185i.i()) {
                this.f31198v.pause();
            }
            if (K(this.f31198v)) {
                ((m) a4.a.e(this.f31189m)).b(this.f31198v);
            }
            if (a4.o0.f214a < 21 && !this.W) {
                this.X = 0;
            }
            g gVar = this.f31196t;
            if (gVar != null) {
                this.f31197u = gVar;
                this.f31196t = null;
            }
            this.f31185i.q();
            Q(this.f31198v, this.f31184h);
            this.f31198v = null;
        }
        this.f31191o.a();
        this.f31190n.a();
    }

    @Override // m2.v
    public int g(o1 o1Var) {
        if (!MimeTypes.AUDIO_RAW.equals(o1Var.f29347l)) {
            return ((this.f31178c0 || !a0(o1Var, this.f31199w)) && !this.f31173a.h(o1Var)) ? 0 : 2;
        }
        if (a4.o0.o0(o1Var.A)) {
            int i10 = o1Var.A;
            return (i10 == 2 || (this.f31177c && i10 == 4)) ? 2 : 1;
        }
        a4.t.i("DefaultAudioSink", "Invalid PCM encoding: " + o1Var.A);
        return 0;
    }

    @Override // m2.v
    public long getCurrentPositionUs(boolean z10) {
        if (!J() || this.I) {
            return Long.MIN_VALUE;
        }
        return t(s(Math.min(this.f31185i.d(z10), this.f31197u.h(G()))));
    }

    @Override // m2.v
    public q2 getPlaybackParameters() {
        return this.f31187k ? this.f31202z : z();
    }

    @Override // m2.v
    public void h(m2.e eVar) {
        if (this.f31199w.equals(eVar)) {
            return;
        }
        this.f31199w = eVar;
        if (this.f31174a0) {
            return;
        }
        flush();
    }

    @Override // m2.v
    public boolean handleBuffer(ByteBuffer byteBuffer, long j10, int i10) throws Exception {
        ByteBuffer byteBuffer2 = this.N;
        a4.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f31196t != null) {
            if (!w()) {
                return false;
            }
            if (this.f31196t.b(this.f31197u)) {
                this.f31197u = this.f31196t;
                this.f31196t = null;
                if (K(this.f31198v) && this.f31188l != 3) {
                    if (this.f31198v.getPlayState() == 3) {
                        this.f31198v.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f31198v;
                    o1 o1Var = this.f31197u.f31212a;
                    audioTrack.setOffloadDelayPadding(o1Var.B, o1Var.C);
                    this.f31180d0 = true;
                }
            } else {
                N();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            r(j10);
        }
        if (!J()) {
            try {
                if (!H()) {
                    return false;
                }
            } catch (v.b e10) {
                if (e10.f31379b) {
                    throw e10;
                }
                this.f31190n.b(e10);
                return false;
            }
        }
        this.f31190n.a();
        if (this.I) {
            this.J = Math.max(0L, j10);
            this.H = false;
            this.I = false;
            if (this.f31187k && a4.o0.f214a >= 23) {
                T(this.f31202z);
            }
            r(j10);
            if (this.V) {
                play();
            }
        }
        if (!this.f31185i.k(G())) {
            return false;
        }
        if (this.N == null) {
            a4.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            g gVar = this.f31197u;
            if (gVar.f31214c != 0 && this.G == 0) {
                int iB = B(gVar.f31218g, byteBuffer);
                this.G = iB;
                if (iB == 0) {
                    return true;
                }
            }
            if (this.f31200x != null) {
                if (!w()) {
                    return false;
                }
                r(j10);
                this.f31200x = null;
            }
            long jK = this.J + this.f31197u.k(F() - this.f31181e.h());
            if (!this.H && Math.abs(jK - j10) > 200000) {
                this.f31195s.onAudioSinkError(new v.d(j10, jK));
                this.H = true;
            }
            if (this.H) {
                if (!w()) {
                    return false;
                }
                long j11 = j10 - jK;
                this.J += j11;
                this.H = false;
                r(j10);
                v.c cVar = this.f31195s;
                if (cVar != null && j11 != 0) {
                    cVar.onPositionDiscontinuity();
                }
            }
            if (this.f31197u.f31214c == 0) {
                this.C += (long) byteBuffer.remaining();
            } else {
                this.D += ((long) this.G) * ((long) i10);
            }
            this.N = byteBuffer;
            this.O = i10;
        }
        O(j10);
        if (!this.N.hasRemaining()) {
            this.N = null;
            this.O = 0;
            return true;
        }
        if (!this.f31185i.j(G())) {
            return false;
        }
        a4.t.i("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // m2.v
    public void handleDiscontinuity() {
        this.H = true;
    }

    @Override // m2.v
    public boolean hasPendingData() {
        return J() && this.f31185i.h(G());
    }

    @Override // m2.v
    public void i(@Nullable t1 t1Var) {
        this.f31194r = t1Var;
    }

    @Override // m2.v
    public boolean isEnded() {
        return !J() || (this.T && !hasPendingData());
    }

    @Override // m2.v
    public void pause() {
        this.V = false;
        if (J() && this.f31185i.p()) {
            this.f31198v.pause();
        }
    }

    @Override // m2.v
    public void play() {
        this.V = true;
        if (J()) {
            this.f31185i.u();
            this.f31198v.play();
        }
    }

    @Override // m2.v
    public void playToEndOfStream() throws v.e {
        if (!this.T && J() && w()) {
            N();
            this.T = true;
        }
    }

    @Override // m2.v
    public void reset() {
        flush();
        for (m2.g gVar : this.f31182f) {
            gVar.reset();
        }
        for (m2.g gVar2 : this.f31183g) {
            gVar2.reset();
        }
        this.V = false;
        this.f31178c0 = false;
    }

    @Override // m2.v
    public void setAudioSessionId(int i10) {
        if (this.X != i10) {
            this.X = i10;
            this.W = i10 != 0;
            flush();
        }
    }

    @Override // m2.v
    public /* synthetic */ void setOutputStreamOffsetUs(long j10) {
        u.a(this, j10);
    }

    @Override // m2.v
    @RequiresApi(23)
    public void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        d dVar = audioDeviceInfo == null ? null : new d(audioDeviceInfo);
        this.Z = dVar;
        AudioTrack audioTrack = this.f31198v;
        if (audioTrack != null) {
            b.a(audioTrack, dVar);
        }
    }

    @Override // m2.v
    public void setSkipSilenceEnabled(boolean z10) {
        S(z(), z10);
    }

    @Override // m2.v
    public void setVolume(float f10) {
        if (this.K != f10) {
            this.K = f10;
            U();
        }
    }

    private c0(f fVar) {
        this.f31173a = fVar.f31205a;
        m2.h hVar = fVar.f31206b;
        this.f31175b = hVar;
        int i10 = a4.o0.f214a;
        this.f31177c = i10 >= 21 && fVar.f31207c;
        this.f31187k = i10 >= 23 && fVar.f31208d;
        this.f31188l = i10 >= 29 ? fVar.f31209e : 0;
        this.f31192p = fVar.f31210f;
        a4.g gVar = new a4.g(a4.d.f148a);
        this.f31184h = gVar;
        gVar.e();
        this.f31185i = new x(new l());
        a0 a0Var = new a0();
        this.f31179d = a0Var;
        n0 n0Var = new n0();
        this.f31181e = n0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new j0(), a0Var, n0Var);
        Collections.addAll(arrayList, hVar.getAudioProcessors());
        this.f31182f = (m2.g[]) arrayList.toArray(new m2.g[0]);
        this.f31183g = new m2.g[]{new f0()};
        this.K = 1.0f;
        this.f31199w = m2.e.f31249g;
        this.X = 0;
        this.Y = new y(0, 0.0f);
        q2 q2Var = q2.f29419d;
        this.f31201y = new j(q2Var, false, 0L, 0L);
        this.f31202z = q2Var;
        this.S = -1;
        this.L = new m2.g[0];
        this.M = new ByteBuffer[0];
        this.f31186j = new ArrayDeque<>();
        this.f31190n = new k<>(100L);
        this.f31191o = new k<>(100L);
        this.f31193q = fVar.f31211g;
    }
}
