package b3;

import a4.k0;
import a4.m0;
import a4.o0;
import a4.y;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import b3.l;
import b3.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import k2.o1;
import k2.p1;
import l2.t1;
import n2.g;
import o2.h0;
import o2.o;

/* JADX INFO: compiled from: MediaCodecRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends k2.f {
    private static final byte[] F0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final long[] A;

    @Nullable
    private k2.q A0;

    @Nullable
    private o1 B;
    protected n2.e B0;

    @Nullable
    private o1 C;
    private long C0;

    @Nullable
    private o2.o D;
    private long D0;

    @Nullable
    private o2.o E;
    private int E0;

    @Nullable
    private MediaCrypto F;
    private boolean G;
    private long H;
    private float I;
    private float J;

    @Nullable
    private l K;

    @Nullable
    private o1 L;

    @Nullable
    private MediaFormat M;
    private boolean N;
    private float O;

    @Nullable
    private ArrayDeque<n> P;

    @Nullable
    private b Q;

    @Nullable
    private n R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f2011a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f2012b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f2013c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @Nullable
    private i f2014d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f2015e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f2016f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f2017g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @Nullable
    private ByteBuffer f2018h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f2019i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f2020j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f2021k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f2022l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f2023m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final l.b f2024n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f2025n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final q f2026o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2027o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f2028p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f2029p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f2030q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2031q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final n2.g f2032r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f2033r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final n2.g f2034s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f2035s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final n2.g f2036t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f2037t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final h f2038u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private long f2039u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final k0<o1> f2040v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private long f2041v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ArrayList<Long> f2042w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f2043w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MediaCodec.BufferInfo f2044x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f2045x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final long[] f2046y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private boolean f2047y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final long[] f2048z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f2049z0;

    /* JADX INFO: compiled from: MediaCodecRenderer.java */
    @RequiresApi(31)
    private static final class a {
        @DoNotInline
        public static void a(l.a aVar, t1 t1Var) {
            LogSessionId logSessionIdA = t1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.f1993b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    public o(int i10, l.b bVar, q qVar, boolean z10, float f10) {
        super(i10);
        this.f2024n = bVar;
        this.f2026o = (q) a4.a.e(qVar);
        this.f2028p = z10;
        this.f2030q = f10;
        this.f2032r = n2.g.p();
        this.f2034s = new n2.g(0);
        this.f2036t = new n2.g(2);
        h hVar = new h();
        this.f2038u = hVar;
        this.f2040v = new k0<>();
        this.f2042w = new ArrayList<>();
        this.f2044x = new MediaCodec.BufferInfo();
        this.I = 1.0f;
        this.J = 1.0f;
        this.H = C.TIME_UNSET;
        this.f2046y = new long[10];
        this.f2048z = new long[10];
        this.A = new long[10];
        this.C0 = C.TIME_UNSET;
        K0(C.TIME_UNSET);
        hVar.m(0);
        hVar.f31586c.order(ByteOrder.nativeOrder());
        this.O = -1.0f;
        this.S = 0;
        this.f2027o0 = 0;
        this.f2016f0 = -1;
        this.f2017g0 = -1;
        this.f2015e0 = C.TIME_UNSET;
        this.f2039u0 = C.TIME_UNSET;
        this.f2041v0 = C.TIME_UNSET;
        this.f2029p0 = 0;
        this.f2031q0 = 0;
    }

    private int A(String str) {
        int i10 = o0.f214a;
        if (i10 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = o0.f217d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i10 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = o0.f215b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private void A0() {
        this.f2037t0 = true;
        MediaFormat outputFormat = this.K.getOutputFormat();
        if (this.S != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.f2012b0 = true;
            return;
        }
        if (this.Z) {
            outputFormat.setInteger("channel-count", 1);
        }
        this.M = outputFormat;
        this.N = true;
    }

    private static boolean B(String str, o1 o1Var) {
        return o0.f214a < 21 && o1Var.f29349n.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private boolean B0(int i10) throws k2.q {
        p1 p1VarI = i();
        this.f2032r.c();
        int iU = u(p1VarI, this.f2032r, i10 | 4);
        if (iU == -5) {
            s0(p1VarI);
            return true;
        }
        if (iU != -4 || !this.f2032r.h()) {
            return false;
        }
        this.f2043w0 = true;
        y0();
        return false;
    }

    private static boolean C(String str) {
        if (o0.f214a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(o0.f216c)) {
            String str2 = o0.f215b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private void C0() throws k2.q {
        D0();
        n0();
    }

    private static boolean D(String str) {
        int i10 = o0.f214a;
        if (i10 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i10 <= 19) {
                String str2 = o0.f215b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private static boolean E(String str) {
        return o0.f214a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean F(n nVar) {
        String str = nVar.f2000a;
        int i10 = o0.f214a;
        return (i10 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i10 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i10 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(o0.f216c) && "AFTS".equals(o0.f217d) && nVar.f2006g));
    }

    private static boolean G(String str) {
        int i10 = o0.f214a;
        return i10 < 18 || (i10 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i10 == 19 && o0.f217d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean H(String str, o1 o1Var) {
        return o0.f214a <= 18 && o1Var.f29360y == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void H0() {
        this.f2016f0 = -1;
        this.f2034s.f31586c = null;
    }

    private static boolean I(String str) {
        return o0.f214a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void I0() {
        this.f2017g0 = -1;
        this.f2018h0 = null;
    }

    private void J0(@Nullable o2.o oVar) {
        o2.n.a(this.D, oVar);
        this.D = oVar;
    }

    private void K() {
        this.f2023m0 = false;
        this.f2038u.c();
        this.f2036t.c();
        this.f2022l0 = false;
        this.f2021k0 = false;
    }

    private void K0(long j10) {
        this.D0 = j10;
        if (j10 != C.TIME_UNSET) {
            u0(j10);
        }
    }

    private boolean L() {
        if (this.f2033r0) {
            this.f2029p0 = 1;
            if (this.U || this.W) {
                this.f2031q0 = 3;
                return false;
            }
            this.f2031q0 = 1;
        }
        return true;
    }

    private void M() throws k2.q {
        if (!this.f2033r0) {
            C0();
        } else {
            this.f2029p0 = 1;
            this.f2031q0 = 3;
        }
    }

    @TargetApi(23)
    private boolean N() throws k2.q {
        if (this.f2033r0) {
            this.f2029p0 = 1;
            if (this.U || this.W) {
                this.f2031q0 = 3;
                return false;
            }
            this.f2031q0 = 2;
        } else {
            V0();
        }
        return true;
    }

    private void N0(@Nullable o2.o oVar) {
        o2.n.a(this.E, oVar);
        this.E = oVar;
    }

    private boolean O(long j10, long j11) throws k2.q {
        boolean z10;
        boolean zZ0;
        l lVar;
        ByteBuffer byteBuffer;
        int i10;
        MediaCodec.BufferInfo bufferInfo;
        int iDequeueOutputBufferIndex;
        if (!g0()) {
            if (this.X && this.f2035s0) {
                try {
                    iDequeueOutputBufferIndex = this.K.dequeueOutputBufferIndex(this.f2044x);
                } catch (IllegalStateException unused) {
                    y0();
                    if (this.f2045x0) {
                        D0();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBufferIndex = this.K.dequeueOutputBufferIndex(this.f2044x);
            }
            if (iDequeueOutputBufferIndex < 0) {
                if (iDequeueOutputBufferIndex == -2) {
                    A0();
                    return true;
                }
                if (this.f2013c0 && (this.f2043w0 || this.f2029p0 == 2)) {
                    y0();
                }
                return false;
            }
            if (this.f2012b0) {
                this.f2012b0 = false;
                this.K.releaseOutputBuffer(iDequeueOutputBufferIndex, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f2044x;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                y0();
                return false;
            }
            this.f2017g0 = iDequeueOutputBufferIndex;
            ByteBuffer outputBuffer = this.K.getOutputBuffer(iDequeueOutputBufferIndex);
            this.f2018h0 = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.f2044x.offset);
                ByteBuffer byteBuffer2 = this.f2018h0;
                MediaCodec.BufferInfo bufferInfo3 = this.f2044x;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.Y) {
                MediaCodec.BufferInfo bufferInfo4 = this.f2044x;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j12 = this.f2039u0;
                    if (j12 != C.TIME_UNSET) {
                        bufferInfo4.presentationTimeUs = j12;
                    }
                }
            }
            this.f2019i0 = j0(this.f2044x.presentationTimeUs);
            long j13 = this.f2041v0;
            long j14 = this.f2044x.presentationTimeUs;
            this.f2020j0 = j13 == j14;
            W0(j14);
        }
        if (this.X && this.f2035s0) {
            try {
                lVar = this.K;
                byteBuffer = this.f2018h0;
                i10 = this.f2017g0;
                bufferInfo = this.f2044x;
                z10 = false;
            } catch (IllegalStateException unused2) {
                z10 = false;
            }
            try {
                zZ0 = z0(j10, j11, lVar, byteBuffer, i10, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f2019i0, this.f2020j0, this.C);
            } catch (IllegalStateException unused3) {
                y0();
                if (this.f2045x0) {
                    D0();
                }
                return z10;
            }
        } else {
            z10 = false;
            l lVar2 = this.K;
            ByteBuffer byteBuffer3 = this.f2018h0;
            int i11 = this.f2017g0;
            MediaCodec.BufferInfo bufferInfo5 = this.f2044x;
            zZ0 = z0(j10, j11, lVar2, byteBuffer3, i11, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f2019i0, this.f2020j0, this.C);
        }
        if (zZ0) {
            v0(this.f2044x.presentationTimeUs);
            boolean z11 = (this.f2044x.flags & 4) != 0 ? true : z10;
            I0();
            if (!z11) {
                return true;
            }
            y0();
        }
        return z10;
    }

    private boolean O0(long j10) {
        return this.H == C.TIME_UNSET || SystemClock.elapsedRealtime() - j10 < this.H;
    }

    private boolean P(n nVar, o1 o1Var, @Nullable o2.o oVar, @Nullable o2.o oVar2) throws k2.q {
        h0 h0VarB0;
        if (oVar == oVar2) {
            return false;
        }
        if (oVar2 == null || oVar == null || !oVar2.getSchemeUuid().equals(oVar.getSchemeUuid()) || o0.f214a < 23) {
            return true;
        }
        UUID uuid = k2.i.f29130e;
        if (uuid.equals(oVar.getSchemeUuid()) || uuid.equals(oVar2.getSchemeUuid()) || (h0VarB0 = b0(oVar2)) == null) {
            return true;
        }
        return !nVar.f2006g && (h0VarB0.f31895c ? false : oVar2.requiresSecureDecoder(o1Var.f29347l));
    }

    private boolean Q() throws k2.q {
        int i10;
        if (this.K == null || (i10 = this.f2029p0) == 2 || this.f2043w0) {
            return false;
        }
        if (i10 == 0 && Q0()) {
            M();
        }
        if (this.f2016f0 < 0) {
            int iDequeueInputBufferIndex = this.K.dequeueInputBufferIndex();
            this.f2016f0 = iDequeueInputBufferIndex;
            if (iDequeueInputBufferIndex < 0) {
                return false;
            }
            this.f2034s.f31586c = this.K.getInputBuffer(iDequeueInputBufferIndex);
            this.f2034s.c();
        }
        if (this.f2029p0 == 1) {
            if (!this.f2013c0) {
                this.f2035s0 = true;
                this.K.queueInputBuffer(this.f2016f0, 0, 0, 0L, 4);
                H0();
            }
            this.f2029p0 = 2;
            return false;
        }
        if (this.f2011a0) {
            this.f2011a0 = false;
            ByteBuffer byteBuffer = this.f2034s.f31586c;
            byte[] bArr = F0;
            byteBuffer.put(bArr);
            this.K.queueInputBuffer(this.f2016f0, 0, bArr.length, 0L, 0);
            H0();
            this.f2033r0 = true;
            return true;
        }
        if (this.f2027o0 == 1) {
            for (int i11 = 0; i11 < this.L.f29349n.size(); i11++) {
                this.f2034s.f31586c.put(this.L.f29349n.get(i11));
            }
            this.f2027o0 = 2;
        }
        int iPosition = this.f2034s.f31586c.position();
        p1 p1VarI = i();
        try {
            int iU = u(p1VarI, this.f2034s, 0);
            if (hasReadStreamToEnd()) {
                this.f2041v0 = this.f2039u0;
            }
            if (iU == -3) {
                return false;
            }
            if (iU == -5) {
                if (this.f2027o0 == 2) {
                    this.f2034s.c();
                    this.f2027o0 = 1;
                }
                s0(p1VarI);
                return true;
            }
            if (this.f2034s.h()) {
                if (this.f2027o0 == 2) {
                    this.f2034s.c();
                    this.f2027o0 = 1;
                }
                this.f2043w0 = true;
                if (!this.f2033r0) {
                    y0();
                    return false;
                }
                try {
                    if (!this.f2013c0) {
                        this.f2035s0 = true;
                        this.K.queueInputBuffer(this.f2016f0, 0, 0, 0L, 4);
                        H0();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e10) {
                    throw f(e10, this.B, o0.P(e10.getErrorCode()));
                }
            }
            if (!this.f2033r0 && !this.f2034s.j()) {
                this.f2034s.c();
                if (this.f2027o0 == 2) {
                    this.f2027o0 = 1;
                }
                return true;
            }
            boolean zO = this.f2034s.o();
            if (zO) {
                this.f2034s.f31585b.b(iPosition);
            }
            if (this.T && !zO) {
                y.b(this.f2034s.f31586c);
                if (this.f2034s.f31586c.position() == 0) {
                    return true;
                }
                this.T = false;
            }
            n2.g gVar = this.f2034s;
            long jD = gVar.f31588e;
            i iVar = this.f2014d0;
            if (iVar != null) {
                jD = iVar.d(this.B, gVar);
                this.f2039u0 = Math.max(this.f2039u0, this.f2014d0.b(this.B));
            }
            long j10 = jD;
            if (this.f2034s.g()) {
                this.f2042w.add(Long.valueOf(j10));
            }
            if (this.f2047y0) {
                this.f2040v.a(j10, this.B);
                this.f2047y0 = false;
            }
            this.f2039u0 = Math.max(this.f2039u0, j10);
            this.f2034s.n();
            if (this.f2034s.f()) {
                f0(this.f2034s);
            }
            x0(this.f2034s);
            try {
                if (zO) {
                    this.K.a(this.f2016f0, 0, this.f2034s.f31585b, j10, 0);
                } else {
                    this.K.queueInputBuffer(this.f2016f0, 0, this.f2034s.f31586c.limit(), j10, 0);
                }
                H0();
                this.f2033r0 = true;
                this.f2027o0 = 0;
                this.B0.f31575c++;
                return true;
            } catch (MediaCodec.CryptoException e11) {
                throw f(e11, this.B, o0.P(e11.getErrorCode()));
            }
        } catch (g.a e12) {
            p0(e12);
            B0(0);
            R();
            return true;
        }
    }

    private void R() {
        try {
            this.K.flush();
        } finally {
            F0();
        }
    }

    protected static boolean T0(o1 o1Var) {
        int i10 = o1Var.E;
        return i10 == 0 || i10 == 2;
    }

    private List<n> U(boolean z10) throws v.c {
        List<n> listA0 = a0(this.f2026o, this.B, z10);
        if (listA0.isEmpty() && z10) {
            listA0 = a0(this.f2026o, this.B, false);
            if (!listA0.isEmpty()) {
                a4.t.i("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.f29347l + ", but no secure decoder available. Trying to proceed with " + listA0 + ".");
            }
        }
        return listA0;
    }

    private boolean U0(o1 o1Var) throws k2.q {
        if (o0.f214a >= 23 && this.K != null && this.f2031q0 != 3 && getState() != 0) {
            float fY = Y(this.J, o1Var, l());
            float f10 = this.O;
            if (f10 == fY) {
                return true;
            }
            if (fY == -1.0f) {
                M();
                return false;
            }
            if (f10 == -1.0f && fY <= this.f2030q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fY);
            this.K.setParameters(bundle);
            this.O = fY;
        }
        return true;
    }

    @RequiresApi(23)
    private void V0() throws k2.q {
        try {
            this.F.setMediaDrmSession(b0(this.E).f31894b);
            J0(this.E);
            this.f2029p0 = 0;
            this.f2031q0 = 0;
        } catch (MediaCryptoException e10) {
            throw f(e10, this.B, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
        }
    }

    @Nullable
    private h0 b0(o2.o oVar) throws k2.q {
        n2.b cryptoConfig = oVar.getCryptoConfig();
        if (cryptoConfig == null || (cryptoConfig instanceof h0)) {
            return (h0) cryptoConfig;
        }
        throw f(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + cryptoConfig), this.B, 6001);
    }

    private boolean g0() {
        return this.f2017g0 >= 0;
    }

    private void h0(o1 o1Var) {
        K();
        String str = o1Var.f29347l;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.f2038u.x(32);
        } else {
            this.f2038u.x(1);
        }
        this.f2021k0 = true;
    }

    private void i0(n nVar, MediaCrypto mediaCrypto) throws Exception {
        String str = nVar.f2000a;
        int i10 = o0.f214a;
        float fY = i10 < 23 ? -1.0f : Y(this.J, this.B, l());
        float f10 = fY > this.f2030q ? fY : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        l.a aVarC0 = c0(nVar, this.B, mediaCrypto, f10);
        if (i10 >= 31) {
            a.a(aVarC0, k());
        }
        try {
            m0.a("createCodec:" + str);
            this.K = this.f2024n.a(aVarC0);
            m0.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.R = nVar;
            this.O = f10;
            this.L = this.B;
            this.S = A(str);
            this.T = B(str, this.L);
            this.U = G(str);
            this.V = I(str);
            this.W = D(str);
            this.X = E(str);
            this.Y = C(str);
            this.Z = H(str, this.L);
            this.f2013c0 = F(nVar) || X();
            if (this.K.needsReconfiguration()) {
                this.f2025n0 = true;
                this.f2027o0 = 1;
                this.f2011a0 = this.S != 0;
            }
            if ("c2.android.mp3.decoder".equals(nVar.f2000a)) {
                this.f2014d0 = new i();
            }
            if (getState() == 2) {
                this.f2015e0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.B0.f31573a++;
            q0(str, aVarC0, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th) {
            m0.c();
            throw th;
        }
    }

    private boolean j0(long j10) {
        int size = this.f2042w.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f2042w.get(i10).longValue() == j10) {
                this.f2042w.remove(i10);
                return true;
            }
        }
        return false;
    }

    private static boolean k0(IllegalStateException illegalStateException) {
        if (o0.f214a >= 21 && l0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    private static boolean l0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    private static boolean m0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void o0(android.media.MediaCrypto r8, boolean r9) throws b3.o.b {
        /*
            r7 = this;
            java.util.ArrayDeque<b3.n> r0 = r7.P
            r1 = 0
            if (r0 != 0) goto L39
            java.util.List r0 = r7.U(r9)     // Catch: b3.v.c -> L2d
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: b3.v.c -> L2d
            r2.<init>()     // Catch: b3.v.c -> L2d
            r7.P = r2     // Catch: b3.v.c -> L2d
            boolean r3 = r7.f2028p     // Catch: b3.v.c -> L2d
            if (r3 == 0) goto L18
            r2.addAll(r0)     // Catch: b3.v.c -> L2d
            goto L2a
        L18:
            boolean r2 = r0.isEmpty()     // Catch: b3.v.c -> L2d
            if (r2 != 0) goto L2a
            java.util.ArrayDeque<b3.n> r2 = r7.P     // Catch: b3.v.c -> L2d
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: b3.v.c -> L2d
            b3.n r0 = (b3.n) r0     // Catch: b3.v.c -> L2d
            r2.add(r0)     // Catch: b3.v.c -> L2d
        L2a:
            r7.Q = r1     // Catch: b3.v.c -> L2d
            goto L39
        L2d:
            r8 = move-exception
            b3.o$b r0 = new b3.o$b
            k2.o1 r1 = r7.B
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r1, r8, r9, r2)
            throw r0
        L39:
            java.util.ArrayDeque<b3.n> r0 = r7.P
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb4
            java.util.ArrayDeque<b3.n> r0 = r7.P
            java.lang.Object r0 = r0.peekFirst()
            b3.n r0 = (b3.n) r0
        L49:
            b3.l r2 = r7.K
            if (r2 != 0) goto Lb1
            java.util.ArrayDeque<b3.n> r2 = r7.P
            java.lang.Object r2 = r2.peekFirst()
            b3.n r2 = (b3.n) r2
            boolean r3 = r7.P0(r2)
            if (r3 != 0) goto L5c
            return
        L5c:
            r7.i0(r2, r8)     // Catch: java.lang.Exception -> L60
            goto L49
        L60:
            r3 = move-exception
            java.lang.String r4 = "MediaCodecRenderer"
            if (r2 != r0) goto L73
            java.lang.String r3 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            a4.t.i(r4, r3)     // Catch: java.lang.Exception -> L74
            r5 = 50
            java.lang.Thread.sleep(r5)     // Catch: java.lang.Exception -> L74
            r7.i0(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L49
        L73:
            throw r3     // Catch: java.lang.Exception -> L74
        L74:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to initialize decoder: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            a4.t.j(r4, r5, r3)
            java.util.ArrayDeque<b3.n> r4 = r7.P
            r4.removeFirst()
            b3.o$b r4 = new b3.o$b
            k2.o1 r5 = r7.B
            r4.<init>(r5, r3, r9, r2)
            r7.p0(r4)
            b3.o$b r2 = r7.Q
            if (r2 != 0) goto L9f
            r7.Q = r4
            goto La5
        L9f:
            b3.o$b r2 = b3.o.b.a(r2, r4)
            r7.Q = r2
        La5:
            java.util.ArrayDeque<b3.n> r2 = r7.P
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lae
            goto L49
        Lae:
            b3.o$b r8 = r7.Q
            throw r8
        Lb1:
            r7.P = r1
            return
        Lb4:
            b3.o$b r8 = new b3.o$b
            k2.o1 r0 = r7.B
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r8.<init>(r0, r1, r9, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.o.o0(android.media.MediaCrypto, boolean):void");
    }

    private void x() throws k2.q {
        a4.a.g(!this.f2043w0);
        p1 p1VarI = i();
        this.f2036t.c();
        do {
            this.f2036t.c();
            int iU = u(p1VarI, this.f2036t, 0);
            if (iU == -5) {
                s0(p1VarI);
                return;
            }
            if (iU != -4) {
                if (iU != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f2036t.h()) {
                    this.f2043w0 = true;
                    return;
                }
                if (this.f2047y0) {
                    o1 o1Var = (o1) a4.a.e(this.B);
                    this.C = o1Var;
                    t0(o1Var, null);
                    this.f2047y0 = false;
                }
                this.f2036t.n();
            }
        } while (this.f2038u.r(this.f2036t));
        this.f2022l0 = true;
    }

    private boolean y(long j10, long j11) throws k2.q {
        boolean z10;
        a4.a.g(!this.f2045x0);
        if (this.f2038u.w()) {
            h hVar = this.f2038u;
            if (!z0(j10, j11, null, hVar.f31586c, this.f2017g0, 0, hVar.v(), this.f2038u.t(), this.f2038u.g(), this.f2038u.h(), this.C)) {
                return false;
            }
            v0(this.f2038u.u());
            this.f2038u.c();
            z10 = false;
        } else {
            z10 = false;
        }
        if (this.f2043w0) {
            this.f2045x0 = true;
            return z10;
        }
        if (this.f2022l0) {
            a4.a.g(this.f2038u.r(this.f2036t));
            this.f2022l0 = z10;
        }
        if (this.f2023m0) {
            if (this.f2038u.w()) {
                return true;
            }
            K();
            this.f2023m0 = z10;
            n0();
            if (!this.f2021k0) {
                return z10;
            }
        }
        x();
        if (this.f2038u.w()) {
            this.f2038u.n();
        }
        if (this.f2038u.w() || this.f2043w0 || this.f2023m0) {
            return true;
        }
        return z10;
    }

    @TargetApi(23)
    private void y0() throws k2.q {
        int i10 = this.f2031q0;
        if (i10 == 1) {
            R();
            return;
        }
        if (i10 == 2) {
            R();
            V0();
        } else if (i10 == 3) {
            C0();
        } else {
            this.f2045x0 = true;
            E0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void D0() {
        try {
            l lVar = this.K;
            if (lVar != null) {
                lVar.release();
                this.B0.f31574b++;
                r0(this.R.f2000a);
            }
            this.K = null;
            try {
                MediaCrypto mediaCrypto = this.F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.K = null;
            try {
                MediaCrypto mediaCrypto2 = this.F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @CallSuper
    protected void F0() {
        H0();
        I0();
        this.f2015e0 = C.TIME_UNSET;
        this.f2035s0 = false;
        this.f2033r0 = false;
        this.f2011a0 = false;
        this.f2012b0 = false;
        this.f2019i0 = false;
        this.f2020j0 = false;
        this.f2042w.clear();
        this.f2039u0 = C.TIME_UNSET;
        this.f2041v0 = C.TIME_UNSET;
        i iVar = this.f2014d0;
        if (iVar != null) {
            iVar.c();
        }
        this.f2029p0 = 0;
        this.f2031q0 = 0;
        this.f2027o0 = this.f2025n0 ? 1 : 0;
    }

    @CallSuper
    protected void G0() {
        F0();
        this.A0 = null;
        this.f2014d0 = null;
        this.P = null;
        this.R = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.f2037t0 = false;
        this.O = -1.0f;
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f2013c0 = false;
        this.f2025n0 = false;
        this.f2027o0 = 0;
        this.G = false;
    }

    protected m J(Throwable th, @Nullable n nVar) {
        return new m(th, nVar);
    }

    protected final void L0() {
        this.f2049z0 = true;
    }

    protected final void M0(k2.q qVar) {
        this.A0 = qVar;
    }

    protected boolean P0(n nVar) {
        return true;
    }

    protected boolean Q0() {
        return false;
    }

    protected boolean R0(o1 o1Var) {
        return false;
    }

    protected final boolean S() throws k2.q {
        boolean zT = T();
        if (zT) {
            n0();
        }
        return zT;
    }

    protected abstract int S0(q qVar, o1 o1Var) throws v.c;

    protected boolean T() {
        if (this.K == null) {
            return false;
        }
        int i10 = this.f2031q0;
        if (i10 == 3 || this.U || ((this.V && !this.f2037t0) || (this.W && this.f2035s0))) {
            D0();
            return true;
        }
        if (i10 == 2) {
            int i11 = o0.f214a;
            a4.a.g(i11 >= 23);
            if (i11 >= 23) {
                try {
                    V0();
                } catch (k2.q e10) {
                    a4.t.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e10);
                    D0();
                    return true;
                }
            }
        }
        R();
        return false;
    }

    @Nullable
    protected final l V() {
        return this.K;
    }

    @Nullable
    protected final n W() {
        return this.R;
    }

    protected final void W0(long j10) throws k2.q {
        boolean z10;
        o1 o1VarJ = this.f2040v.j(j10);
        if (o1VarJ == null && this.N) {
            o1VarJ = this.f2040v.i();
        }
        if (o1VarJ != null) {
            this.C = o1VarJ;
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || (this.N && this.C != null)) {
            t0(this.C, this.M);
            this.N = false;
        }
    }

    protected boolean X() {
        return false;
    }

    protected abstract float Y(float f10, o1 o1Var, o1[] o1VarArr);

    @Nullable
    protected final MediaFormat Z() {
        return this.M;
    }

    @Override // k2.c3
    public final int a(o1 o1Var) throws k2.q {
        try {
            return S0(this.f2026o, o1Var);
        } catch (v.c e10) {
            throw f(e10, o1Var, 4002);
        }
    }

    protected abstract List<n> a0(q qVar, o1 o1Var, boolean z10) throws v.c;

    protected abstract l.a c0(n nVar, o1 o1Var, @Nullable MediaCrypto mediaCrypto, float f10);

    protected final long d0() {
        return this.D0;
    }

    protected float e0() {
        return this.I;
    }

    @Override // k2.a3
    public boolean isEnded() {
        return this.f2045x0;
    }

    @Override // k2.a3
    public boolean isReady() {
        return this.B != null && (m() || g0() || (this.f2015e0 != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.f2015e0));
    }

    @Override // k2.f
    protected void n() {
        this.B = null;
        this.C0 = C.TIME_UNSET;
        K0(C.TIME_UNSET);
        this.E0 = 0;
        T();
    }

    protected final void n0() throws k2.q {
        o1 o1Var;
        if (this.K != null || this.f2021k0 || (o1Var = this.B) == null) {
            return;
        }
        if (this.E == null && R0(o1Var)) {
            h0(this.B);
            return;
        }
        J0(this.E);
        String str = this.B.f29347l;
        o2.o oVar = this.D;
        if (oVar != null) {
            if (this.F == null) {
                h0 h0VarB0 = b0(oVar);
                if (h0VarB0 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(h0VarB0.f31893a, h0VarB0.f31894b);
                        this.F = mediaCrypto;
                        this.G = !h0VarB0.f31895c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e10) {
                        throw f(e10, this.B, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
                    }
                } else if (this.D.getError() == null) {
                    return;
                }
            }
            if (h0.f31892d) {
                int state = this.D.getState();
                if (state == 1) {
                    o.a aVar = (o.a) a4.a.e(this.D.getError());
                    throw f(aVar, this.B, aVar.f31924a);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            o0(this.F, this.G);
        } catch (b e11) {
            throw f(e11, this.B, 4001);
        }
    }

    @Override // k2.f
    protected void o(boolean z10, boolean z11) throws k2.q {
        this.B0 = new n2.e();
    }

    @Override // k2.f
    protected void p(long j10, boolean z10) throws k2.q {
        this.f2043w0 = false;
        this.f2045x0 = false;
        this.f2049z0 = false;
        if (this.f2021k0) {
            this.f2038u.c();
            this.f2036t.c();
            this.f2022l0 = false;
        } else {
            S();
        }
        if (this.f2040v.l() > 0) {
            this.f2047y0 = true;
        }
        this.f2040v.c();
        int i10 = this.E0;
        if (i10 != 0) {
            K0(this.f2048z[i10 - 1]);
            this.C0 = this.f2046y[this.E0 - 1];
            this.E0 = 0;
        }
    }

    protected abstract void p0(Exception exc);

    @Override // k2.f
    protected void q() {
        try {
            K();
            D0();
        } finally {
            N0(null);
        }
    }

    protected abstract void q0(String str, l.a aVar, long j10, long j11);

    protected abstract void r0(String str);

    @Override // k2.a3
    public void render(long j10, long j11) throws k2.q {
        boolean z10 = false;
        if (this.f2049z0) {
            this.f2049z0 = false;
            y0();
        }
        k2.q qVar = this.A0;
        if (qVar != null) {
            this.A0 = null;
            throw qVar;
        }
        try {
            if (this.f2045x0) {
                E0();
                return;
            }
            if (this.B != null || B0(2)) {
                n0();
                if (this.f2021k0) {
                    m0.a("bypassRender");
                    while (y(j10, j11)) {
                    }
                    m0.c();
                } else if (this.K != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    m0.a("drainAndFeed");
                    while (O(j10, j11) && O0(jElapsedRealtime)) {
                    }
                    while (Q() && O0(jElapsedRealtime)) {
                    }
                    m0.c();
                } else {
                    this.B0.f31576d += w(j10);
                    B0(1);
                }
                this.B0.c();
            }
        } catch (IllegalStateException e10) {
            if (!k0(e10)) {
                throw e10;
            }
            p0(e10);
            if (o0.f214a >= 21 && m0(e10)) {
                z10 = true;
            }
            if (z10) {
                D0();
            }
            throw g(J(e10, W()), this.B, z10, PlaybackException.ERROR_CODE_DECODING_FAILED);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    @androidx.annotation.Nullable
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected n2.i s0(k2.p1 r12) throws k2.q {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.o.s0(k2.p1):n2.i");
    }

    @Override // k2.f, k2.a3
    public void setPlaybackSpeed(float f10, float f11) throws k2.q {
        this.I = f10;
        this.J = f11;
        U0(this.L);
    }

    @Override // k2.f, k2.c3
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    @Override // k2.f
    protected void t(o1[] o1VarArr, long j10, long j11) throws k2.q {
        if (this.D0 == C.TIME_UNSET) {
            a4.a.g(this.C0 == C.TIME_UNSET);
            this.C0 = j10;
            K0(j11);
            return;
        }
        int i10 = this.E0;
        if (i10 == this.f2048z.length) {
            a4.t.i("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.f2048z[this.E0 - 1]);
        } else {
            this.E0 = i10 + 1;
        }
        long[] jArr = this.f2046y;
        int i11 = this.E0;
        jArr[i11 - 1] = j10;
        this.f2048z[i11 - 1] = j11;
        this.A[i11 - 1] = this.f2039u0;
    }

    protected abstract void t0(o1 o1Var, @Nullable MediaFormat mediaFormat) throws k2.q;

    @CallSuper
    protected void v0(long j10) {
        while (this.E0 != 0 && j10 >= this.A[0]) {
            this.C0 = this.f2046y[0];
            K0(this.f2048z[0]);
            int i10 = this.E0 - 1;
            this.E0 = i10;
            long[] jArr = this.f2046y;
            System.arraycopy(jArr, 1, jArr, 0, i10);
            long[] jArr2 = this.f2048z;
            System.arraycopy(jArr2, 1, jArr2, 0, this.E0);
            long[] jArr3 = this.A;
            System.arraycopy(jArr3, 1, jArr3, 0, this.E0);
            w0();
        }
    }

    protected abstract void x0(n2.g gVar) throws k2.q;

    protected abstract n2.i z(n nVar, o1 o1Var, o1 o1Var2);

    protected abstract boolean z0(long j10, long j11, @Nullable l lVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, o1 o1Var) throws k2.q;

    /* JADX INFO: compiled from: MediaCodecRenderer.java */
    public static class b extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final n f2052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f2053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final b f2054e;

        public b(o1 o1Var, @Nullable Throwable th, boolean z10, int i10) {
            this("Decoder init failed: [" + i10 + "], " + o1Var, th, o1Var.f29347l, z10, null, b(i10), null);
        }

        private static String b(int i10) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i10 < 0 ? "neg_" : "") + Math.abs(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public b c(b bVar) {
            return new b(getMessage(), getCause(), this.f2050a, this.f2051b, this.f2052c, this.f2053d, bVar);
        }

        @Nullable
        @RequiresApi(21)
        private static String d(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public b(o1 o1Var, @Nullable Throwable th, boolean z10, n nVar) {
            this("Decoder init failed: " + nVar.f2000a + ", " + o1Var, th, o1Var.f29347l, z10, nVar, o0.f214a >= 21 ? d(th) : null, null);
        }

        private b(String str, @Nullable Throwable th, String str2, boolean z10, @Nullable n nVar, @Nullable String str3, @Nullable b bVar) {
            super(str, th);
            this.f2050a = str2;
            this.f2051b = z10;
            this.f2052c = nVar;
            this.f2053d = str3;
            this.f2054e = bVar;
        }
    }

    protected void E0() throws k2.q {
    }

    @Override // k2.f
    protected void r() {
    }

    @Override // k2.f
    protected void s() {
    }

    protected void w0() {
    }

    protected void f0(n2.g gVar) throws k2.q {
    }

    protected void u0(long j10) {
    }
}
