package l2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.PlaybackException;
import b3.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import k2.b2;
import k2.j2;
import k2.n2;
import k2.n3;
import k2.q2;
import k2.r2;
import k2.s3;
import k2.w1;
import l2.c;
import l2.s1;
import l3.a0;
import m2.v;
import o2.h;
import o2.o;
import z3.n0;
import z3.x;

/* JADX INFO: compiled from: MediaMetricsListener.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(31)
public final class r1 implements c, s1.a {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f30375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s1 f30376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlaybackSession f30377c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private String f30383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private PlaybackMetrics.Builder f30384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f30385k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private n2 f30388n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private b f30389o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private b f30390p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private b f30391q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private k2.o1 f30392r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private k2.o1 f30393s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private k2.o1 f30394t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f30395u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f30396v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f30397w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f30398x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f30399y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f30400z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final n3.d f30379e = new n3.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final n3.b f30380f = new n3.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap<String, Long> f30382h = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, Long> f30381g = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f30378d = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f30386l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f30387m = 0;

    /* JADX INFO: compiled from: MediaMetricsListener.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f30402b;

        public a(int i10, int i11) {
            this.f30401a = i10;
            this.f30402b = i11;
        }
    }

    /* JADX INFO: compiled from: MediaMetricsListener.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k2.o1 f30403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f30404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f30405c;

        public b(k2.o1 o1Var, int i10, String str) {
            this.f30403a = o1Var;
            this.f30404b = i10;
            this.f30405c = str;
        }
    }

    private r1(Context context, PlaybackSession playbackSession) {
        this.f30375a = context.getApplicationContext();
        this.f30377c = playbackSession;
        q1 q1Var = new q1();
        this.f30376b = q1Var;
        q1Var.a(this);
    }

    @Nullable
    public static r1 A0(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new r1(context, mediaMetricsManager.createPlaybackSession());
    }

    private void B0() {
        PlaybackMetrics.Builder builder = this.f30384j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f30400z);
            this.f30384j.setVideoFramesDropped(this.f30398x);
            this.f30384j.setVideoFramesPlayed(this.f30399y);
            Long l10 = this.f30381g.get(this.f30383i);
            this.f30384j.setNetworkTransferDurationMillis(l10 == null ? 0L : l10.longValue());
            Long l11 = this.f30382h.get(this.f30383i);
            this.f30384j.setNetworkBytesRead(l11 == null ? 0L : l11.longValue());
            this.f30384j.setStreamSource((l11 == null || l11.longValue() <= 0) ? 0 : 1);
            this.f30377c.reportPlaybackMetrics(this.f30384j.build());
        }
        this.f30384j = null;
        this.f30383i = null;
        this.f30400z = 0;
        this.f30398x = 0;
        this.f30399y = 0;
        this.f30392r = null;
        this.f30393s = null;
        this.f30394t = null;
        this.A = false;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int C0(int i10) {
        switch (a4.o0.P(i10)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                return 25;
            case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    private static o2.m D0(com.google.common.collect.y<s3.a> yVar) {
        o2.m mVar;
        com.google.common.collect.i1<s3.a> it = yVar.iterator();
        while (it.hasNext()) {
            s3.a next = it.next();
            for (int i10 = 0; i10 < next.f29478a; i10++) {
                if (next.f(i10) && (mVar = next.c(i10).f29350o) != null) {
                    return mVar;
                }
            }
        }
        return null;
    }

    private static int E0(o2.m mVar) {
        for (int i10 = 0; i10 < mVar.f31918d; i10++) {
            UUID uuid = mVar.c(i10).f31920b;
            if (uuid.equals(k2.i.f29129d)) {
                return 3;
            }
            if (uuid.equals(k2.i.f29130e)) {
                return 2;
            }
            if (uuid.equals(k2.i.f29128c)) {
                return 6;
            }
        }
        return 1;
    }

    private static a F0(n2 n2Var, Context context, boolean z10) {
        int i10;
        boolean z11;
        if (n2Var.f29293a == 1001) {
            return new a(20, 0);
        }
        if (n2Var instanceof k2.q) {
            k2.q qVar = (k2.q) n2Var;
            z11 = qVar.f29411d == 1;
            i10 = qVar.f29415h;
        } else {
            i10 = 0;
            z11 = false;
        }
        Throwable th = (Throwable) a4.a.e(n2Var.getCause());
        if (!(th instanceof IOException)) {
            if (z11 && (i10 == 0 || i10 == 1)) {
                return new a(35, 0);
            }
            if (z11 && i10 == 3) {
                return new a(15, 0);
            }
            if (z11 && i10 == 2) {
                return new a(23, 0);
            }
            if (th instanceof o.b) {
                return new a(13, a4.o0.Q(((o.b) th).f2053d));
            }
            if (th instanceof b3.m) {
                return new a(14, a4.o0.Q(((b3.m) th).f1999b));
            }
            if (th instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th instanceof v.b) {
                return new a(17, ((v.b) th).f31378a);
            }
            if (th instanceof v.e) {
                return new a(18, ((v.e) th).f31383a);
            }
            if (a4.o0.f214a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new a(C0(errorCode), errorCode);
        }
        if (th instanceof z3.b0) {
            return new a(5, ((z3.b0) th).f37365d);
        }
        if ((th instanceof z3.a0) || (th instanceof j2)) {
            return new a(z10 ? 10 : 11, 0);
        }
        if ((th instanceof z3.z) || (th instanceof n0.a)) {
            if (a4.a0.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : ((th instanceof z3.z) && ((z3.z) th).f37563c == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (n2Var.f29293a == 1002) {
            return new a(21, 0);
        }
        if (!(th instanceof o.a)) {
            if (!(th instanceof x.b) || !(th.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) a4.a.e(th.getCause())).getCause();
            return (a4.o0.f214a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th2 = (Throwable) a4.a.e(th.getCause());
        int i11 = a4.o0.f214a;
        if (i11 < 21 || !(th2 instanceof MediaDrm.MediaDrmStateException)) {
            return (i11 < 23 || !(th2 instanceof MediaDrmResetException)) ? (i11 < 18 || !(th2 instanceof NotProvisionedException)) ? (i11 < 18 || !(th2 instanceof DeniedByServerException)) ? th2 instanceof o2.p0 ? new a(23, 0) : th2 instanceof h.e ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int iQ = a4.o0.Q(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
        return new a(C0(iQ), iQ);
    }

    private static Pair<String, String> G0(String str) {
        String[] strArrH0 = a4.o0.H0(str, "-");
        return Pair.create(strArrH0[0], strArrH0.length >= 2 ? strArrH0[1] : null);
    }

    private static int I0(Context context) {
        switch (a4.a0.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    private static int J0(w1 w1Var) {
        w1.h hVar = w1Var.f29517b;
        if (hVar == null) {
            return 0;
        }
        int iK0 = a4.o0.k0(hVar.f29580a, hVar.f29581b);
        if (iK0 == 0) {
            return 3;
        }
        if (iK0 != 1) {
            return iK0 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int K0(int i10) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void L0(c.b bVar) {
        for (int i10 = 0; i10 < bVar.d(); i10++) {
            int iB = bVar.b(i10);
            c.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.f30376b.f(aVarC);
            } else if (iB == 11) {
                this.f30376b.e(aVarC, this.f30385k);
            } else {
                this.f30376b.d(aVarC);
            }
        }
    }

    private void M0(long j10) {
        int iI0 = I0(this.f30375a);
        if (iI0 != this.f30387m) {
            this.f30387m = iI0;
            this.f30377c.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(iI0).setTimeSinceCreatedMillis(j10 - this.f30378d).build());
        }
    }

    private void N0(long j10) {
        n2 n2Var = this.f30388n;
        if (n2Var == null) {
            return;
        }
        a aVarF0 = F0(n2Var, this.f30375a, this.f30396v == 4);
        this.f30377c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j10 - this.f30378d).setErrorCode(aVarF0.f30401a).setSubErrorCode(aVarF0.f30402b).setException(n2Var).build());
        this.A = true;
        this.f30388n = null;
    }

    private void O0(r2 r2Var, c.b bVar, long j10) {
        if (r2Var.getPlaybackState() != 2) {
            this.f30395u = false;
        }
        if (r2Var.getPlayerError() == null) {
            this.f30397w = false;
        } else if (bVar.a(10)) {
            this.f30397w = true;
        }
        int iW0 = W0(r2Var);
        if (this.f30386l != iW0) {
            this.f30386l = iW0;
            this.A = true;
            this.f30377c.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.f30386l).setTimeSinceCreatedMillis(j10 - this.f30378d).build());
        }
    }

    private void P0(r2 r2Var, c.b bVar, long j10) {
        if (bVar.a(2)) {
            s3 currentTracks = r2Var.getCurrentTracks();
            boolean zD = currentTracks.d(2);
            boolean zD2 = currentTracks.d(1);
            boolean zD3 = currentTracks.d(3);
            if (zD || zD2 || zD3) {
                if (!zD) {
                    U0(j10, null, 0);
                }
                if (!zD2) {
                    Q0(j10, null, 0);
                }
                if (!zD3) {
                    S0(j10, null, 0);
                }
            }
        }
        if (z0(this.f30389o)) {
            b bVar2 = this.f30389o;
            k2.o1 o1Var = bVar2.f30403a;
            if (o1Var.f29353r != -1) {
                U0(j10, o1Var, bVar2.f30404b);
                this.f30389o = null;
            }
        }
        if (z0(this.f30390p)) {
            b bVar3 = this.f30390p;
            Q0(j10, bVar3.f30403a, bVar3.f30404b);
            this.f30390p = null;
        }
        if (z0(this.f30391q)) {
            b bVar4 = this.f30391q;
            S0(j10, bVar4.f30403a, bVar4.f30404b);
            this.f30391q = null;
        }
    }

    private void Q0(long j10, @Nullable k2.o1 o1Var, int i10) {
        if (a4.o0.c(this.f30393s, o1Var)) {
            return;
        }
        if (this.f30393s == null && i10 == 0) {
            i10 = 1;
        }
        this.f30393s = o1Var;
        V0(0, j10, o1Var, i10);
    }

    private void R0(r2 r2Var, c.b bVar) {
        o2.m mVarD0;
        if (bVar.a(0)) {
            c.a aVarC = bVar.c(0);
            if (this.f30384j != null) {
                T0(aVarC.f30241b, aVarC.f30243d);
            }
        }
        if (bVar.a(2) && this.f30384j != null && (mVarD0 = D0(r2Var.getCurrentTracks().b())) != null) {
            ((PlaybackMetrics.Builder) a4.o0.j(this.f30384j)).setDrmType(E0(mVarD0));
        }
        if (bVar.a(1011)) {
            this.f30400z++;
        }
    }

    private void S0(long j10, @Nullable k2.o1 o1Var, int i10) {
        if (a4.o0.c(this.f30394t, o1Var)) {
            return;
        }
        if (this.f30394t == null && i10 == 0) {
            i10 = 1;
        }
        this.f30394t = o1Var;
        V0(2, j10, o1Var, i10);
    }

    private void T0(n3 n3Var, @Nullable a0.b bVar) {
        int iF;
        PlaybackMetrics.Builder builder = this.f30384j;
        if (bVar == null || (iF = n3Var.f(bVar.f30778a)) == -1) {
            return;
        }
        n3Var.j(iF, this.f30380f);
        n3Var.r(this.f30380f.f29300c, this.f30379e);
        builder.setStreamType(J0(this.f30379e.f29315c));
        n3.d dVar = this.f30379e;
        if (dVar.f29326n != C.TIME_UNSET && !dVar.f29324l && !dVar.f29321i && !dVar.i()) {
            builder.setMediaDurationMillis(this.f30379e.g());
        }
        builder.setPlaybackType(this.f30379e.i() ? 2 : 1);
        this.A = true;
    }

    private void U0(long j10, @Nullable k2.o1 o1Var, int i10) {
        if (a4.o0.c(this.f30392r, o1Var)) {
            return;
        }
        if (this.f30392r == null && i10 == 0) {
            i10 = 1;
        }
        this.f30392r = o1Var;
        V0(1, j10, o1Var, i10);
    }

    private void V0(int i10, long j10, @Nullable k2.o1 o1Var, int i11) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i10).setTimeSinceCreatedMillis(j10 - this.f30378d);
        if (o1Var != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(K0(i11));
            String str = o1Var.f29346k;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = o1Var.f29347l;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = o1Var.f29344i;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i12 = o1Var.f29343h;
            if (i12 != -1) {
                timeSinceCreatedMillis.setBitrate(i12);
            }
            int i13 = o1Var.f29352q;
            if (i13 != -1) {
                timeSinceCreatedMillis.setWidth(i13);
            }
            int i14 = o1Var.f29353r;
            if (i14 != -1) {
                timeSinceCreatedMillis.setHeight(i14);
            }
            int i15 = o1Var.f29360y;
            if (i15 != -1) {
                timeSinceCreatedMillis.setChannelCount(i15);
            }
            int i16 = o1Var.f29361z;
            if (i16 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i16);
            }
            String str4 = o1Var.f29338c;
            if (str4 != null) {
                Pair<String, String> pairG0 = G0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairG0.first);
                Object obj = pairG0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f10 = o1Var.f29354s;
            if (f10 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f10);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.f30377c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    private int W0(r2 r2Var) {
        int playbackState = r2Var.getPlaybackState();
        if (this.f30395u) {
            return 5;
        }
        if (this.f30397w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i10 = this.f30386l;
            if (i10 == 0 || i10 == 2) {
                return 2;
            }
            if (r2Var.getPlayWhenReady()) {
                return r2Var.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (r2Var.getPlayWhenReady()) {
                return r2Var.getPlaybackSuppressionReason() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.f30386l == 0) {
            return this.f30386l;
        }
        return 12;
    }

    private boolean z0(@Nullable b bVar) {
        return bVar != null && bVar.f30405c.equals(this.f30376b.getActiveSessionId());
    }

    @Override // l2.c
    public /* synthetic */ void A(c.a aVar, int i10, boolean z10) {
        l2.b.t(this, aVar, i10, z10);
    }

    @Override // l2.c
    public /* synthetic */ void B(c.a aVar, int i10) {
        l2.b.O(this, aVar, i10);
    }

    @Override // l2.c
    public /* synthetic */ void C(c.a aVar, Exception exc) {
        l2.b.z(this, aVar, exc);
    }

    @Override // l2.c
    public /* synthetic */ void D(c.a aVar, String str, long j10, long j11) {
        l2.b.c(this, aVar, str, j10, j11);
    }

    @Override // l2.c
    public /* synthetic */ void E(c.a aVar, String str) {
        l2.b.g0(this, aVar, str);
    }

    @Override // l2.c
    public void F(c.a aVar, n2 n2Var) {
        this.f30388n = n2Var;
    }

    @Override // l2.c
    public /* synthetic */ void G(c.a aVar, int i10) {
        l2.b.y(this, aVar, i10);
    }

    @Override // l2.c
    public /* synthetic */ void H(c.a aVar, k2.o oVar) {
        l2.b.s(this, aVar, oVar);
    }

    public LogSessionId H0() {
        return this.f30377c.getSessionId();
    }

    @Override // l2.c
    public /* synthetic */ void I(c.a aVar, int i10, long j10, long j11) {
        l2.b.k(this, aVar, i10, j10, j11);
    }

    @Override // l2.c
    public /* synthetic */ void J(c.a aVar, long j10) {
        l2.b.i(this, aVar, j10);
    }

    @Override // l2.c
    public /* synthetic */ void K(c.a aVar, boolean z10, int i10) {
        l2.b.L(this, aVar, z10, i10);
    }

    @Override // l2.c
    public /* synthetic */ void L(c.a aVar, Exception exc) {
        l2.b.d0(this, aVar, exc);
    }

    @Override // l2.c
    public /* synthetic */ void M(c.a aVar, int i10) {
        l2.b.N(this, aVar, i10);
    }

    @Override // l2.c
    public /* synthetic */ void N(c.a aVar, Exception exc) {
        l2.b.j(this, aVar, exc);
    }

    @Override // l2.c
    public void O(r2 r2Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        L0(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        R0(r2Var, bVar);
        N0(jElapsedRealtime);
        P0(r2Var, bVar, jElapsedRealtime);
        M0(jElapsedRealtime);
        O0(r2Var, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.f30376b.b(bVar.c(1028));
        }
    }

    @Override // l2.c
    public /* synthetic */ void P(c.a aVar, boolean z10) {
        l2.b.X(this, aVar, z10);
    }

    @Override // l2.c
    public void Q(c.a aVar, int i10, long j10, long j11) {
        a0.b bVar = aVar.f30243d;
        if (bVar != null) {
            String strC = this.f30376b.c(aVar.f30241b, (a0.b) a4.a.e(bVar));
            Long l10 = this.f30382h.get(strC);
            Long l11 = this.f30381g.get(strC);
            this.f30382h.put(strC, Long.valueOf((l10 == null ? 0L : l10.longValue()) + j10));
            this.f30381g.put(strC, Long.valueOf((l11 != null ? l11.longValue() : 0L) + ((long) i10)));
        }
    }

    @Override // l2.c
    public /* synthetic */ void R(c.a aVar, int i10, long j10) {
        l2.b.B(this, aVar, i10, j10);
    }

    @Override // l2.c
    public /* synthetic */ void S(c.a aVar, int i10) {
        l2.b.a0(this, aVar, i10);
    }

    @Override // l2.c
    public /* synthetic */ void T(c.a aVar, n2 n2Var) {
        l2.b.P(this, aVar, n2Var);
    }

    @Override // l2.s1.a
    public void U(c.a aVar, String str, boolean z10) {
        a0.b bVar = aVar.f30243d;
        if ((bVar == null || !bVar.b()) && str.equals(this.f30383i)) {
            B0();
        }
        this.f30381g.remove(str);
        this.f30382h.remove(str);
    }

    @Override // l2.c
    public /* synthetic */ void V(c.a aVar) {
        l2.b.w(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void W(c.a aVar, String str) {
        l2.b.d(this, aVar, str);
    }

    @Override // l2.c
    public /* synthetic */ void X(c.a aVar, int i10, String str, long j10) {
        l2.b.q(this, aVar, i10, str, j10);
    }

    @Override // l2.c
    public /* synthetic */ void Y(c.a aVar, r2.b bVar) {
        l2.b.l(this, aVar, bVar);
    }

    @Override // l2.c
    public /* synthetic */ void Z(c.a aVar, k2.o1 o1Var) {
        l2.b.g(this, aVar, o1Var);
    }

    @Override // l2.c
    public /* synthetic */ void a(c.a aVar, x3.z zVar) {
        l2.b.b0(this, aVar, zVar);
    }

    @Override // l2.c
    public /* synthetic */ void a0(c.a aVar) {
        l2.b.x(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void b(c.a aVar, Exception exc) {
        l2.b.a(this, aVar, exc);
    }

    @Override // l2.c
    public /* synthetic */ void b0(c.a aVar, int i10, int i11, int i12, float f10) {
        l2.b.l0(this, aVar, i10, i11, i12, f10);
    }

    @Override // l2.c
    public /* synthetic */ void c(c.a aVar, boolean z10) {
        l2.b.D(this, aVar, z10);
    }

    @Override // l2.c
    public /* synthetic */ void c0(c.a aVar, l3.t tVar, l3.w wVar) {
        l2.b.G(this, aVar, tVar, wVar);
    }

    @Override // l2.c
    public /* synthetic */ void d(c.a aVar, q2 q2Var) {
        l2.b.M(this, aVar, q2Var);
    }

    @Override // l2.c
    public /* synthetic */ void d0(c.a aVar, boolean z10) {
        l2.b.H(this, aVar, z10);
    }

    @Override // l2.c
    public /* synthetic */ void e(c.a aVar) {
        l2.b.V(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void e0(c.a aVar, k2.o1 o1Var) {
        l2.b.j0(this, aVar, o1Var);
    }

    @Override // l2.c
    public void f(c.a aVar, l3.w wVar) {
        if (aVar.f30243d == null) {
            return;
        }
        b bVar = new b((k2.o1) a4.a.e(wVar.f30755c), wVar.f30756d, this.f30376b.c(aVar.f30241b, (a0.b) a4.a.e(aVar.f30243d)));
        int i10 = wVar.f30754b;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f30390p = bVar;
                return;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                this.f30391q = bVar;
                return;
            }
        }
        this.f30389o = bVar;
    }

    @Override // l2.c
    public /* synthetic */ void f0(c.a aVar) {
        l2.b.v(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void g(c.a aVar, n2.e eVar) {
        l2.b.h0(this, aVar, eVar);
    }

    @Override // l2.c
    public void g0(c.a aVar, l3.t tVar, l3.w wVar, IOException iOException, boolean z10) {
        this.f30396v = wVar.f30753a;
    }

    @Override // l2.c
    public /* synthetic */ void h(c.a aVar, k2.o1 o1Var, n2.i iVar) {
        l2.b.h(this, aVar, o1Var, iVar);
    }

    @Override // l2.c
    public /* synthetic */ void h0(c.a aVar, Object obj, long j10) {
        l2.b.T(this, aVar, obj, j10);
    }

    @Override // l2.c
    public /* synthetic */ void i(c.a aVar, l3.t tVar, l3.w wVar) {
        l2.b.F(this, aVar, tVar, wVar);
    }

    @Override // l2.c
    public /* synthetic */ void i0(c.a aVar, String str, long j10, long j11) {
        l2.b.f0(this, aVar, str, j10, j11);
    }

    @Override // l2.c
    public /* synthetic */ void j(c.a aVar) {
        l2.b.A(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void j0(c.a aVar) {
        l2.b.W(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void k(c.a aVar, long j10, int i10) {
        l2.b.i0(this, aVar, j10, i10);
    }

    @Override // l2.c
    public /* synthetic */ void k0(c.a aVar) {
        l2.b.Q(this, aVar);
    }

    @Override // l2.c
    public void l(c.a aVar, r2.e eVar, r2.e eVar2, int i10) {
        if (i10 == 1) {
            this.f30395u = true;
        }
        this.f30385k = i10;
    }

    @Override // l2.c
    public /* synthetic */ void l0(c.a aVar, n2.e eVar) {
        l2.b.f(this, aVar, eVar);
    }

    @Override // l2.c
    public /* synthetic */ void m(c.a aVar, b2 b2Var) {
        l2.b.J(this, aVar, b2Var);
    }

    @Override // l2.c
    public /* synthetic */ void m0(c.a aVar, int i10, k2.o1 o1Var) {
        l2.b.r(this, aVar, i10, o1Var);
    }

    @Override // l2.c
    public /* synthetic */ void n(c.a aVar, int i10) {
        l2.b.S(this, aVar, i10);
    }

    @Override // l2.c
    public /* synthetic */ void n0(c.a aVar, k2.o1 o1Var, n2.i iVar) {
        l2.b.k0(this, aVar, o1Var, iVar);
    }

    @Override // l2.c
    public /* synthetic */ void o(c.a aVar, int i10, int i11) {
        l2.b.Z(this, aVar, i10, i11);
    }

    @Override // l2.c
    public /* synthetic */ void p(c.a aVar, boolean z10) {
        l2.b.Y(this, aVar, z10);
    }

    @Override // l2.c
    public /* synthetic */ void p0(c.a aVar, String str, long j10) {
        l2.b.e0(this, aVar, str, j10);
    }

    @Override // l2.c
    public /* synthetic */ void q(c.a aVar, boolean z10) {
        l2.b.C(this, aVar, z10);
    }

    @Override // l2.c
    public void q0(c.a aVar, n2.e eVar) {
        this.f30398x += eVar.f31579g;
        this.f30399y += eVar.f31577e;
    }

    @Override // l2.c
    public /* synthetic */ void r(c.a aVar, List list) {
        l2.b.m(this, aVar, list);
    }

    @Override // l2.c
    public /* synthetic */ void r0(c.a aVar, int i10, n2.e eVar) {
        l2.b.p(this, aVar, i10, eVar);
    }

    @Override // l2.c
    public void s(c.a aVar, b4.b0 b0Var) {
        b bVar = this.f30389o;
        if (bVar != null) {
            k2.o1 o1Var = bVar.f30403a;
            if (o1Var.f29353r == -1) {
                this.f30389o = new b(o1Var.b().j0(b0Var.f2079a).Q(b0Var.f2080b).E(), bVar.f30404b, bVar.f30405c);
            }
        }
    }

    @Override // l2.c
    public /* synthetic */ void s0(c.a aVar, c3.a aVar2) {
        l2.b.K(this, aVar, aVar2);
    }

    @Override // l2.c
    public /* synthetic */ void t(c.a aVar) {
        l2.b.u(this, aVar);
    }

    @Override // l2.c
    public /* synthetic */ void t0(c.a aVar, l3.t tVar, l3.w wVar) {
        l2.b.E(this, aVar, tVar, wVar);
    }

    @Override // l2.c
    public /* synthetic */ void u(c.a aVar, float f10) {
        l2.b.m0(this, aVar, f10);
    }

    @Override // l2.c
    public /* synthetic */ void u0(c.a aVar, s3 s3Var) {
        l2.b.c0(this, aVar, s3Var);
    }

    @Override // l2.c
    public /* synthetic */ void v(c.a aVar, boolean z10, int i10) {
        l2.b.R(this, aVar, z10, i10);
    }

    @Override // l2.c
    public /* synthetic */ void w(c.a aVar, String str, long j10) {
        l2.b.b(this, aVar, str, j10);
    }

    @Override // l2.s1.a
    public void w0(c.a aVar, String str) {
        a0.b bVar = aVar.f30243d;
        if (bVar == null || !bVar.b()) {
            B0();
            this.f30383i = str;
            this.f30384j = new PlaybackMetrics.Builder().setPlayerName("ExoPlayerLib").setPlayerVersion("2.18.2");
            T0(aVar.f30241b, aVar.f30243d);
        }
    }

    @Override // l2.c
    public /* synthetic */ void x(c.a aVar, n2.e eVar) {
        l2.b.e(this, aVar, eVar);
    }

    @Override // l2.c
    public /* synthetic */ void x0(c.a aVar, int i10) {
        l2.b.U(this, aVar, i10);
    }

    @Override // l2.c
    public /* synthetic */ void y(c.a aVar, int i10, n2.e eVar) {
        l2.b.o(this, aVar, i10, eVar);
    }

    @Override // l2.c
    public /* synthetic */ void y0(c.a aVar, w1 w1Var, int i10) {
        l2.b.I(this, aVar, w1Var, i10);
    }

    @Override // l2.c
    public /* synthetic */ void z(c.a aVar, n3.f fVar) {
        l2.b.n(this, aVar, fVar);
    }

    @Override // l2.s1.a
    public void v0(c.a aVar, String str) {
    }

    @Override // l2.s1.a
    public void o0(c.a aVar, String str, String str2) {
    }
}
