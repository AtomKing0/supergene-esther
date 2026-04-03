package m2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import b3.l;
import b3.v;
import java.nio.ByteBuffer;
import java.util.List;
import k2.a3;
import k2.b3;
import k2.o1;
import k2.p1;
import k2.q2;
import m2.t;
import m2.v;

/* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 extends b3.o implements a4.v {
    private final Context G0;
    private final t.a H0;
    private final v I0;
    private int J0;
    private boolean K0;

    @Nullable
    private o1 L0;
    private long M0;
    private boolean N0;
    private boolean O0;
    private boolean P0;
    private boolean Q0;

    @Nullable
    private a3.a R0;

    /* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
    @RequiresApi(23)
    private static final class b {
        @DoNotInline
        public static void a(v vVar, @Nullable Object obj) {
            vVar.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    /* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
    private final class c implements v.c {
        private c() {
        }

        @Override // m2.v.c
        public void onAudioSinkError(Exception exc) {
            a4.t.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            g0.this.H0.l(exc);
        }

        @Override // m2.v.c
        public void onOffloadBufferEmptying() {
            if (g0.this.R0 != null) {
                g0.this.R0.onWakeup();
            }
        }

        @Override // m2.v.c
        public void onOffloadBufferFull() {
            if (g0.this.R0 != null) {
                g0.this.R0.onSleep();
            }
        }

        @Override // m2.v.c
        public void onPositionAdvancing(long j10) {
            g0.this.H0.B(j10);
        }

        @Override // m2.v.c
        public void onPositionDiscontinuity() {
            g0.this.f1();
        }

        @Override // m2.v.c
        public void onSkipSilenceEnabledChanged(boolean z10) {
            g0.this.H0.C(z10);
        }

        @Override // m2.v.c
        public void onUnderrun(int i10, long j10, long j11) {
            g0.this.H0.D(i10, j10, j11);
        }
    }

    public g0(Context context, l.b bVar, b3.q qVar, boolean z10, @Nullable Handler handler, @Nullable t tVar, v vVar) {
        super(1, bVar, qVar, z10, 44100.0f);
        this.G0 = context.getApplicationContext();
        this.I0 = vVar;
        this.H0 = new t.a(handler, tVar);
        vVar.f(new c());
    }

    private static boolean Z0(String str) {
        if (a4.o0.f214a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(a4.o0.f216c)) {
            String str2 = a4.o0.f215b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean a1() {
        if (a4.o0.f214a == 23) {
            String str = a4.o0.f217d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int b1(b3.n nVar, o1 o1Var) {
        int i10;
        if (!"OMX.google.raw.decoder".equals(nVar.f2000a) || (i10 = a4.o0.f214a) >= 24 || (i10 == 23 && a4.o0.r0(this.G0))) {
            return o1Var.f29348m;
        }
        return -1;
    }

    private static List<b3.n> d1(b3.q qVar, o1 o1Var, boolean z10, v vVar) throws v.c {
        b3.n nVarV;
        String str = o1Var.f29347l;
        if (str == null) {
            return com.google.common.collect.y.q();
        }
        if (vVar.a(o1Var) && (nVarV = b3.v.v()) != null) {
            return com.google.common.collect.y.r(nVarV);
        }
        List<b3.n> decoderInfos = qVar.getDecoderInfos(str, z10, false);
        String strM = b3.v.m(o1Var);
        return strM == null ? com.google.common.collect.y.m(decoderInfos) : com.google.common.collect.y.k().j(decoderInfos).j(qVar.getDecoderInfos(strM, z10, false)).k();
    }

    private void g1() {
        long currentPositionUs = this.I0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.O0) {
                currentPositionUs = Math.max(this.M0, currentPositionUs);
            }
            this.M0 = currentPositionUs;
            this.O0 = false;
        }
    }

    @Override // b3.o
    protected void E0() throws k2.q {
        try {
            this.I0.playToEndOfStream();
        } catch (v.e e10) {
            throw g(e10, e10.f31385c, e10.f31384b, 5002);
        }
    }

    @Override // b3.o
    protected boolean R0(o1 o1Var) {
        return this.I0.a(o1Var);
    }

    @Override // b3.o
    protected int S0(b3.q qVar, o1 o1Var) throws v.c {
        boolean z10;
        if (!a4.x.l(o1Var.f29347l)) {
            return b3.a(0);
        }
        int i10 = a4.o0.f214a >= 21 ? 32 : 0;
        boolean z11 = true;
        boolean z12 = o1Var.E != 0;
        boolean zT0 = b3.o.T0(o1Var);
        int i11 = 8;
        if (zT0 && this.I0.a(o1Var) && (!z12 || b3.v.v() != null)) {
            return b3.b(4, 8, i10);
        }
        if (MimeTypes.AUDIO_RAW.equals(o1Var.f29347l) && !this.I0.a(o1Var)) {
            return b3.a(1);
        }
        if (!this.I0.a(a4.o0.X(2, o1Var.f29360y, o1Var.f29361z))) {
            return b3.a(1);
        }
        List<b3.n> listD1 = d1(qVar, o1Var, false, this.I0);
        if (listD1.isEmpty()) {
            return b3.a(1);
        }
        if (!zT0) {
            return b3.a(2);
        }
        b3.n nVar = listD1.get(0);
        boolean zM = nVar.m(o1Var);
        if (zM) {
            z10 = true;
            z11 = zM;
        } else {
            for (int i12 = 1; i12 < listD1.size(); i12++) {
                b3.n nVar2 = listD1.get(i12);
                if (nVar2.m(o1Var)) {
                    z10 = false;
                    nVar = nVar2;
                    break;
                }
            }
            z10 = true;
            z11 = zM;
        }
        int i13 = z11 ? 4 : 3;
        if (z11 && nVar.p(o1Var)) {
            i11 = 16;
        }
        return b3.c(i13, i11, i10, nVar.f2007h ? 64 : 0, z10 ? 128 : 0);
    }

    @Override // b3.o
    protected float Y(float f10, o1 o1Var, o1[] o1VarArr) {
        int iMax = -1;
        for (o1 o1Var2 : o1VarArr) {
            int i10 = o1Var2.f29361z;
            if (i10 != -1) {
                iMax = Math.max(iMax, i10);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f10 * iMax;
    }

    @Override // b3.o
    protected List<b3.n> a0(b3.q qVar, o1 o1Var, boolean z10) throws v.c {
        return b3.v.u(d1(qVar, o1Var, z10, this.I0), o1Var);
    }

    @Override // a4.v
    public void b(q2 q2Var) {
        this.I0.b(q2Var);
    }

    @Override // b3.o
    protected l.a c0(b3.n nVar, o1 o1Var, @Nullable MediaCrypto mediaCrypto, float f10) {
        this.J0 = c1(nVar, o1Var, l());
        this.K0 = Z0(nVar.f2000a);
        MediaFormat mediaFormatE1 = e1(o1Var, nVar.f2002c, this.J0, f10);
        this.L0 = MimeTypes.AUDIO_RAW.equals(nVar.f2001b) && !MimeTypes.AUDIO_RAW.equals(o1Var.f29347l) ? o1Var : null;
        return l.a.a(nVar, mediaFormatE1, o1Var, mediaCrypto);
    }

    protected int c1(b3.n nVar, o1 o1Var, o1[] o1VarArr) {
        int iB1 = b1(nVar, o1Var);
        if (o1VarArr.length == 1) {
            return iB1;
        }
        for (o1 o1Var2 : o1VarArr) {
            if (nVar.e(o1Var, o1Var2).f31599d != 0) {
                iB1 = Math.max(iB1, b1(nVar, o1Var2));
            }
        }
        return iB1;
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat e1(o1 o1Var, String str, int i10, float f10) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", o1Var.f29360y);
        mediaFormat.setInteger("sample-rate", o1Var.f29361z);
        a4.w.e(mediaFormat, o1Var.f29349n);
        a4.w.d(mediaFormat, "max-input-size", i10);
        int i11 = a4.o0.f214a;
        if (i11 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f && !a1()) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (i11 <= 28 && MimeTypes.AUDIO_AC4.equals(o1Var.f29347l)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i11 >= 24 && this.I0.g(a4.o0.X(4, o1Var.f29360y, o1Var.f29361z)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i11 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @CallSuper
    protected void f1() {
        this.O0 = true;
    }

    @Override // k2.a3, k2.c3
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // a4.v
    public q2 getPlaybackParameters() {
        return this.I0.getPlaybackParameters();
    }

    @Override // a4.v
    public long getPositionUs() {
        if (getState() == 2) {
            g1();
        }
        return this.M0;
    }

    @Override // k2.f, k2.v2.b
    public void handleMessage(int i10, @Nullable Object obj) throws k2.q {
        if (i10 == 2) {
            this.I0.setVolume(((Float) obj).floatValue());
        }
        if (i10 == 3) {
            this.I0.h((e) obj);
            return;
        }
        if (i10 == 6) {
            this.I0.d((y) obj);
            return;
        }
        switch (i10) {
            case 9:
                this.I0.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.I0.setAudioSessionId(((Integer) obj).intValue());
                break;
            case 11:
                this.R0 = (a3.a) obj;
                break;
            case 12:
                if (a4.o0.f214a >= 23) {
                    b.a(this.I0, obj);
                }
                break;
            default:
                super.handleMessage(i10, obj);
                break;
        }
    }

    @Override // b3.o, k2.a3
    public boolean isEnded() {
        return super.isEnded() && this.I0.isEnded();
    }

    @Override // b3.o, k2.a3
    public boolean isReady() {
        return this.I0.hasPendingData() || super.isReady();
    }

    @Override // b3.o, k2.f
    protected void n() {
        this.P0 = true;
        try {
            this.I0.flush();
            try {
                super.n();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.n();
                throw th;
            } finally {
            }
        }
    }

    @Override // b3.o, k2.f
    protected void o(boolean z10, boolean z11) throws k2.q {
        super.o(z10, z11);
        this.H0.p(this.B0);
        if (h().f29075a) {
            this.I0.enableTunnelingV21();
        } else {
            this.I0.disableTunneling();
        }
        this.I0.i(k());
    }

    @Override // b3.o, k2.f
    protected void p(long j10, boolean z10) throws k2.q {
        super.p(j10, z10);
        if (this.Q0) {
            this.I0.e();
        } else {
            this.I0.flush();
        }
        this.M0 = j10;
        this.N0 = true;
        this.O0 = true;
    }

    @Override // b3.o
    protected void p0(Exception exc) {
        a4.t.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.H0.k(exc);
    }

    @Override // b3.o, k2.f
    protected void q() {
        try {
            super.q();
        } finally {
            if (this.P0) {
                this.P0 = false;
                this.I0.reset();
            }
        }
    }

    @Override // b3.o
    protected void q0(String str, l.a aVar, long j10, long j11) {
        this.H0.m(str, j10, j11);
    }

    @Override // b3.o, k2.f
    protected void r() {
        super.r();
        this.I0.play();
    }

    @Override // b3.o
    protected void r0(String str) {
        this.H0.n(str);
    }

    @Override // b3.o, k2.f
    protected void s() {
        g1();
        this.I0.pause();
        super.s();
    }

    @Override // b3.o
    @Nullable
    protected n2.i s0(p1 p1Var) throws k2.q {
        n2.i iVarS0 = super.s0(p1Var);
        this.H0.q(p1Var.f29409b, iVarS0);
        return iVarS0;
    }

    @Override // b3.o
    protected void t0(o1 o1Var, @Nullable MediaFormat mediaFormat) throws k2.q {
        int i10;
        o1 o1Var2 = this.L0;
        int[] iArr = null;
        if (o1Var2 != null) {
            o1Var = o1Var2;
        } else if (V() != null) {
            o1 o1VarE = new o1.b().e0(MimeTypes.AUDIO_RAW).Y(MimeTypes.AUDIO_RAW.equals(o1Var.f29347l) ? o1Var.A : (a4.o0.f214a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? a4.o0.W(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding")).N(o1Var.B).O(o1Var.C).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            if (this.K0 && o1VarE.f29360y == 6 && (i10 = o1Var.f29360y) < 6) {
                iArr = new int[i10];
                for (int i11 = 0; i11 < o1Var.f29360y; i11++) {
                    iArr[i11] = i11;
                }
            }
            o1Var = o1VarE;
        }
        try {
            this.I0.c(o1Var, 0, iArr);
        } catch (v.a e10) {
            throw f(e10, e10.f31377a, 5001);
        }
    }

    @Override // b3.o
    protected void u0(long j10) {
        this.I0.setOutputStreamOffsetUs(j10);
    }

    @Override // b3.o
    protected void w0() {
        super.w0();
        this.I0.handleDiscontinuity();
    }

    @Override // b3.o
    protected void x0(n2.g gVar) {
        if (!this.N0 || gVar.g()) {
            return;
        }
        if (Math.abs(gVar.f31588e - this.M0) > 500000) {
            this.M0 = gVar.f31588e;
        }
        this.N0 = false;
    }

    @Override // b3.o
    protected n2.i z(b3.n nVar, o1 o1Var, o1 o1Var2) {
        n2.i iVarE = nVar.e(o1Var, o1Var2);
        int i10 = iVarE.f31600e;
        if (b1(nVar, o1Var2) > this.J0) {
            i10 |= 64;
        }
        int i11 = i10;
        return new n2.i(nVar.f2000a, o1Var, o1Var2, i11 != 0 ? 0 : iVarE.f31599d, i11);
    }

    @Override // b3.o
    protected boolean z0(long j10, long j11, @Nullable b3.l lVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, o1 o1Var) throws k2.q {
        a4.a.e(byteBuffer);
        if (this.L0 != null && (i11 & 2) != 0) {
            ((b3.l) a4.a.e(lVar)).releaseOutputBuffer(i10, false);
            return true;
        }
        if (z10) {
            if (lVar != null) {
                lVar.releaseOutputBuffer(i10, false);
            }
            this.B0.f31578f += i12;
            this.I0.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.I0.handleBuffer(byteBuffer, j12, i12)) {
                return false;
            }
            if (lVar != null) {
                lVar.releaseOutputBuffer(i10, false);
            }
            this.B0.f31577e += i12;
            return true;
        } catch (v.b e10) {
            throw g(e10, e10.f31380c, e10.f31379b, 5001);
        } catch (v.e e11) {
            throw g(e11, o1Var, e11.f31384b, 5002);
        }
    }

    @Override // k2.f, k2.a3
    @Nullable
    public a4.v getMediaClock() {
        return this;
    }
}
