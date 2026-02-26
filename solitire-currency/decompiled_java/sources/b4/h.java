package b4;

import a4.m0;
import a4.o0;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.TsExtractor;
import b3.l;
import b3.v;
import b4.z;
import com.google.android.gms.common.Scopes;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.nio.ByteBuffer;
import java.util.List;
import k2.b3;
import k2.o1;
import k2.p1;

/* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends b3.o {

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final int[] f2115p1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private static boolean f2116q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private static boolean f2117r1;
    private final Context G0;
    private final n H0;
    private final z.a I0;
    private final long J0;
    private final int K0;
    private final boolean L0;
    private b M0;
    private boolean N0;
    private boolean O0;

    @Nullable
    private Surface P0;

    @Nullable
    private i Q0;
    private boolean R0;
    private int S0;
    private boolean T0;
    private boolean U0;
    private boolean V0;
    private long W0;
    private long X0;
    private long Y0;
    private int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private int f2118a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private int f2119b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private long f2120c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private long f2121d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private long f2122e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private int f2123f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private int f2124g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private int f2125h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private int f2126i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private float f2127j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @Nullable
    private b0 f2128k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private boolean f2129l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private int f2130m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    @Nullable
    c f2131n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    @Nullable
    private l f2132o1;

    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    @RequiresApi(26)
    private static final class a {
        @DoNotInline
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(v8.h.f15785d);
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i10 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i10 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    protected static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2135c;

        public b(int i10, int i11, int i12) {
            this.f2133a = i10;
            this.f2134b = i11;
            this.f2135c = i12;
        }
    }

    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    @RequiresApi(23)
    private final class c implements l.c, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f2136a;

        public c(b3.l lVar) {
            Handler handlerV = o0.v(this);
            this.f2136a = handlerV;
            lVar.b(this, handlerV);
        }

        private void b(long j10) {
            h hVar = h.this;
            if (this != hVar.f2131n1) {
                return;
            }
            if (j10 == Long.MAX_VALUE) {
                hVar.y1();
                return;
            }
            try {
                hVar.x1(j10);
            } catch (k2.q e10) {
                h.this.M0(e10);
            }
        }

        @Override // b3.l.c
        public void a(b3.l lVar, long j10, long j11) {
            if (o0.f214a >= 30) {
                b(j10);
            } else {
                this.f2136a.sendMessageAtFrontOfQueue(Message.obtain(this.f2136a, 0, (int) (j10 >> 32), (int) j10));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(o0.M0(message.arg1, message.arg2));
            return true;
        }
    }

    public h(Context context, l.b bVar, b3.q qVar, long j10, boolean z10, @Nullable Handler handler, @Nullable z zVar, int i10) {
        this(context, bVar, qVar, j10, z10, handler, zVar, i10, 30.0f);
    }

    @RequiresApi(29)
    private static void C1(b3.l lVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        lVar.setParameters(bundle);
    }

    private void D1() {
        this.X0 = this.J0 > 0 ? SystemClock.elapsedRealtime() + this.J0 : C.TIME_UNSET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [b4.n] */
    /* JADX WARN: Type inference failed for: r4v0, types: [b3.o, b4.h, k2.f] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v6, types: [b4.i] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private void E1(@Nullable Object obj) throws k2.q {
        ?? C = obj instanceof Surface ? (Surface) obj : 0;
        if (C == 0) {
            i iVar = this.Q0;
            if (iVar != null) {
                C = iVar;
            } else {
                b3.n nVarW = W();
                if (nVarW != null && J1(nVarW)) {
                    C = i.c(this.G0, nVarW.f2006g);
                    this.Q0 = C;
                }
            }
        }
        if (this.P0 == C) {
            if (C == 0 || C == this.Q0) {
                return;
            }
            v1();
            u1();
            return;
        }
        this.P0 = C;
        this.H0.m(C);
        this.R0 = false;
        int state = getState();
        b3.l lVarV = V();
        if (lVarV != null) {
            if (o0.f214a < 23 || C == 0 || this.N0) {
                D0();
                n0();
            } else {
                F1(lVarV, C);
            }
        }
        if (C == 0 || C == this.Q0) {
            a1();
            Z0();
            return;
        }
        v1();
        Z0();
        if (state == 2) {
            D1();
        }
    }

    private boolean J1(b3.n nVar) {
        return o0.f214a >= 23 && !this.f2129l1 && !b1(nVar.f2000a) && (!nVar.f2006g || i.b(this.G0));
    }

    private void Z0() {
        b3.l lVarV;
        this.T0 = false;
        if (o0.f214a < 23 || !this.f2129l1 || (lVarV = V()) == null) {
            return;
        }
        this.f2131n1 = new c(lVarV);
    }

    private void a1() {
        this.f2128k1 = null;
    }

    @RequiresApi(21)
    private static void c1(MediaFormat mediaFormat, int i10) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i10);
    }

    private static boolean d1() {
        return "NVIDIA".equals(o0.f216c);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean f1() {
        String str;
        int i10 = o0.f214a;
        byte b10 = 7;
        if (i10 <= 28) {
            String str2 = o0.f215b;
            str2.hashCode();
            switch (str2) {
            }
            return true;
        }
        if (i10 <= 27 && "HWEML".equals(o0.f215b)) {
            return true;
        }
        str = o0.f217d;
        str.hashCode();
        switch (str) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                break;
            default:
                if (i10 <= 26) {
                    String str3 = o0.f215b;
                    str3.hashCode();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            b10 = !str3.equals("GIONEE_SWW1609") ? (byte) -1 : (byte) 0;
                            break;
                        case -2144781185:
                            b10 = !str3.equals("GIONEE_SWW1627") ? (byte) -1 : (byte) 1;
                            break;
                        case -2144781160:
                            b10 = !str3.equals("GIONEE_SWW1631") ? (byte) -1 : (byte) 2;
                            break;
                        case -2097309513:
                            b10 = !str3.equals("K50a40") ? (byte) -1 : (byte) 3;
                            break;
                        case -2022874474:
                            b10 = !str3.equals("CP8676_I02") ? (byte) -1 : (byte) 4;
                            break;
                        case -1978993182:
                            b10 = !str3.equals("NX541J") ? (byte) -1 : (byte) 5;
                            break;
                        case -1978990237:
                            b10 = !str3.equals("NX573J") ? (byte) -1 : (byte) 6;
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                                b10 = -1;
                            }
                            break;
                        case -1936688066:
                            b10 = !str3.equals("PGN610") ? (byte) -1 : (byte) 8;
                            break;
                        case -1936688065:
                            b10 = !str3.equals("PGN611") ? (byte) -1 : (byte) 9;
                            break;
                        case -1931988508:
                            b10 = !str3.equals("AquaPowerM") ? (byte) -1 : (byte) 10;
                            break;
                        case -1885099851:
                            b10 = !str3.equals("RAIJIN") ? (byte) -1 : (byte) 11;
                            break;
                        case -1696512866:
                            b10 = !str3.equals("XT1663") ? (byte) -1 : (byte) 12;
                            break;
                        case -1680025915:
                            b10 = !str3.equals("ComioS1") ? (byte) -1 : (byte) 13;
                            break;
                        case -1615810839:
                            b10 = !str3.equals("Phantom6") ? (byte) -1 : (byte) 14;
                            break;
                        case -1600724499:
                            b10 = !str3.equals("pacificrim") ? (byte) -1 : (byte) 15;
                            break;
                        case -1554255044:
                            b10 = !str3.equals("vernee_M5") ? (byte) -1 : (byte) 16;
                            break;
                        case -1481772737:
                            b10 = !str3.equals("panell_dl") ? (byte) -1 : (byte) 17;
                            break;
                        case -1481772730:
                            b10 = !str3.equals("panell_ds") ? (byte) -1 : (byte) 18;
                            break;
                        case -1481772729:
                            b10 = !str3.equals("panell_dt") ? (byte) -1 : (byte) 19;
                            break;
                        case -1320080169:
                            b10 = !str3.equals("GiONEE_GBL7319") ? (byte) -1 : (byte) 20;
                            break;
                        case -1217592143:
                            b10 = !str3.equals("BRAVIA_ATV2") ? (byte) -1 : (byte) 21;
                            break;
                        case -1180384755:
                            b10 = !str3.equals("iris60") ? (byte) -1 : (byte) 22;
                            break;
                        case -1139198265:
                            b10 = !str3.equals("Slate_Pro") ? (byte) -1 : (byte) 23;
                            break;
                        case -1052835013:
                            b10 = !str3.equals("namath") ? (byte) -1 : (byte) 24;
                            break;
                        case -993250464:
                            b10 = !str3.equals("A10-70F") ? (byte) -1 : (byte) 25;
                            break;
                        case -993250458:
                            b10 = !str3.equals("A10-70L") ? (byte) -1 : (byte) 26;
                            break;
                        case -965403638:
                            b10 = !str3.equals("s905x018") ? (byte) -1 : (byte) 27;
                            break;
                        case -958336948:
                            b10 = !str3.equals("ELUGA_Ray_X") ? (byte) -1 : (byte) 28;
                            break;
                        case -879245230:
                            b10 = !str3.equals("tcl_eu") ? (byte) -1 : (byte) 29;
                            break;
                        case -842500323:
                            b10 = !str3.equals("nicklaus_f") ? (byte) -1 : (byte) 30;
                            break;
                        case -821392978:
                            b10 = !str3.equals("A7000-a") ? (byte) -1 : (byte) 31;
                            break;
                        case -797483286:
                            b10 = !str3.equals("SVP-DTV15") ? (byte) -1 : (byte) 32;
                            break;
                        case -794946968:
                            b10 = !str3.equals("watson") ? (byte) -1 : (byte) 33;
                            break;
                        case -788334647:
                            b10 = !str3.equals("whyred") ? (byte) -1 : (byte) 34;
                            break;
                        case -782144577:
                            b10 = !str3.equals("OnePlus5T") ? (byte) -1 : (byte) 35;
                            break;
                        case -575125681:
                            b10 = !str3.equals("GiONEE_CBL7513") ? (byte) -1 : (byte) 36;
                            break;
                        case -521118391:
                            b10 = !str3.equals("GIONEE_GBL7360") ? (byte) -1 : (byte) 37;
                            break;
                        case -430914369:
                            b10 = !str3.equals("Pixi4-7_3G") ? (byte) -1 : (byte) 38;
                            break;
                        case -290434366:
                            b10 = !str3.equals("taido_row") ? (byte) -1 : (byte) 39;
                            break;
                        case -282781963:
                            b10 = !str3.equals("BLACK-1X") ? (byte) -1 : (byte) 40;
                            break;
                        case -277133239:
                            b10 = !str3.equals("Z12_PRO") ? (byte) -1 : (byte) 41;
                            break;
                        case -173639913:
                            b10 = !str3.equals("ELUGA_A3_Pro") ? (byte) -1 : (byte) 42;
                            break;
                        case -56598463:
                            b10 = !str3.equals("woods_fn") ? (byte) -1 : (byte) 43;
                            break;
                        case 2126:
                            b10 = !str3.equals("C1") ? (byte) -1 : (byte) 44;
                            break;
                        case 2564:
                            b10 = !str3.equals("Q5") ? (byte) -1 : (byte) 45;
                            break;
                        case 2715:
                            b10 = !str3.equals("V1") ? (byte) -1 : (byte) 46;
                            break;
                        case 2719:
                            b10 = !str3.equals("V5") ? (byte) -1 : (byte) 47;
                            break;
                        case 3091:
                            b10 = !str3.equals("b5") ? (byte) -1 : (byte) 48;
                            break;
                        case 3483:
                            b10 = !str3.equals("mh") ? (byte) -1 : (byte) 49;
                            break;
                        case 73405:
                            b10 = !str3.equals("JGZ") ? (byte) -1 : (byte) 50;
                            break;
                        case 75537:
                            b10 = !str3.equals("M04") ? (byte) -1 : (byte) 51;
                            break;
                        case 75739:
                            b10 = !str3.equals("M5c") ? (byte) -1 : (byte) 52;
                            break;
                        case 76779:
                            b10 = !str3.equals("MX6") ? (byte) -1 : (byte) 53;
                            break;
                        case 78669:
                            b10 = !str3.equals("P85") ? (byte) -1 : (byte) 54;
                            break;
                        case 79305:
                            b10 = !str3.equals("PLE") ? (byte) -1 : (byte) 55;
                            break;
                        case 80618:
                            b10 = !str3.equals("QX1") ? (byte) -1 : (byte) 56;
                            break;
                        case 88274:
                            b10 = !str3.equals("Z80") ? (byte) -1 : (byte) 57;
                            break;
                        case 98846:
                            b10 = !str3.equals("cv1") ? (byte) -1 : (byte) 58;
                            break;
                        case 98848:
                            b10 = !str3.equals("cv3") ? (byte) -1 : (byte) 59;
                            break;
                        case 99329:
                            b10 = !str3.equals("deb") ? (byte) -1 : (byte) 60;
                            break;
                        case 101481:
                            b10 = !str3.equals("flo") ? (byte) -1 : (byte) 61;
                            break;
                        case 1513190:
                            b10 = !str3.equals("1601") ? (byte) -1 : (byte) 62;
                            break;
                        case 1514184:
                            b10 = !str3.equals("1713") ? (byte) -1 : (byte) 63;
                            break;
                        case 1514185:
                            b10 = !str3.equals("1714") ? (byte) -1 : (byte) 64;
                            break;
                        case 2133089:
                            b10 = !str3.equals("F01H") ? (byte) -1 : (byte) 65;
                            break;
                        case 2133091:
                            b10 = !str3.equals("F01J") ? (byte) -1 : (byte) 66;
                            break;
                        case 2133120:
                            b10 = !str3.equals("F02H") ? (byte) -1 : (byte) 67;
                            break;
                        case 2133151:
                            b10 = !str3.equals("F03H") ? (byte) -1 : (byte) 68;
                            break;
                        case 2133182:
                            b10 = !str3.equals("F04H") ? (byte) -1 : (byte) 69;
                            break;
                        case 2133184:
                            b10 = !str3.equals("F04J") ? (byte) -1 : (byte) 70;
                            break;
                        case 2436959:
                            b10 = !str3.equals("P681") ? (byte) -1 : (byte) 71;
                            break;
                        case 2463773:
                            b10 = !str3.equals("Q350") ? (byte) -1 : (byte) 72;
                            break;
                        case 2464648:
                            b10 = !str3.equals("Q427") ? (byte) -1 : (byte) 73;
                            break;
                        case 2689555:
                            b10 = !str3.equals("XE2X") ? (byte) -1 : (byte) 74;
                            break;
                        case 3154429:
                            b10 = !str3.equals("fugu") ? (byte) -1 : (byte) 75;
                            break;
                        case 3284551:
                            b10 = !str3.equals("kate") ? (byte) -1 : (byte) 76;
                            break;
                        case 3351335:
                            b10 = !str3.equals("mido") ? (byte) -1 : (byte) 77;
                            break;
                        case 3386211:
                            b10 = !str3.equals("p212") ? (byte) -1 : (byte) 78;
                            break;
                        case 41325051:
                            b10 = !str3.equals("MEIZU_M5") ? (byte) -1 : (byte) 79;
                            break;
                        case 51349633:
                            b10 = !str3.equals("601LV") ? (byte) -1 : (byte) 80;
                            break;
                        case 51350594:
                            b10 = !str3.equals("602LV") ? (byte) -1 : (byte) 81;
                            break;
                        case 55178625:
                            b10 = !str3.equals("Aura_Note_2") ? (byte) -1 : (byte) 82;
                            break;
                        case 61542055:
                            b10 = !str3.equals("A1601") ? (byte) -1 : (byte) 83;
                            break;
                        case 65355429:
                            b10 = !str3.equals("E5643") ? (byte) -1 : (byte) 84;
                            break;
                        case 66214468:
                            b10 = !str3.equals("F3111") ? (byte) -1 : (byte) 85;
                            break;
                        case 66214470:
                            b10 = !str3.equals("F3113") ? (byte) -1 : (byte) 86;
                            break;
                        case 66214473:
                            b10 = !str3.equals("F3116") ? (byte) -1 : (byte) 87;
                            break;
                        case 66215429:
                            b10 = !str3.equals("F3211") ? (byte) -1 : (byte) 88;
                            break;
                        case 66215431:
                            b10 = !str3.equals("F3213") ? (byte) -1 : (byte) 89;
                            break;
                        case 66215433:
                            b10 = !str3.equals("F3215") ? (byte) -1 : (byte) 90;
                            break;
                        case 66216390:
                            b10 = !str3.equals("F3311") ? (byte) -1 : (byte) 91;
                            break;
                        case 76402249:
                            b10 = !str3.equals("PRO7S") ? (byte) -1 : (byte) 92;
                            break;
                        case 76404105:
                            b10 = !str3.equals("Q4260") ? (byte) -1 : (byte) 93;
                            break;
                        case 76404911:
                            b10 = !str3.equals("Q4310") ? (byte) -1 : (byte) 94;
                            break;
                        case 80963634:
                            b10 = !str3.equals("V23GB") ? (byte) -1 : (byte) 95;
                            break;
                        case 82882791:
                            b10 = !str3.equals("X3_HK") ? (byte) -1 : (byte) 96;
                            break;
                        case 98715550:
                            b10 = !str3.equals("i9031") ? (byte) -1 : (byte) 97;
                            break;
                        case 101370885:
                            b10 = !str3.equals("l5460") ? (byte) -1 : (byte) 98;
                            break;
                        case 102844228:
                            b10 = !str3.equals("le_x6") ? (byte) -1 : (byte) 99;
                            break;
                        case 165221241:
                            b10 = !str3.equals("A2016a40") ? (byte) -1 : (byte) 100;
                            break;
                        case 182191441:
                            b10 = !str3.equals("CPY83_I00") ? (byte) -1 : (byte) 101;
                            break;
                        case 245388979:
                            b10 = !str3.equals("marino_f") ? (byte) -1 : (byte) 102;
                            break;
                        case 287431619:
                            b10 = !str3.equals("griffin") ? (byte) -1 : (byte) 103;
                            break;
                        case 307593612:
                            b10 = !str3.equals("A7010a48") ? (byte) -1 : (byte) 104;
                            break;
                        case 308517133:
                            b10 = !str3.equals("A7020a48") ? (byte) -1 : (byte) 105;
                            break;
                        case 316215098:
                            b10 = !str3.equals("TB3-730F") ? (byte) -1 : (byte) 106;
                            break;
                        case 316215116:
                            b10 = !str3.equals("TB3-730X") ? (byte) -1 : (byte) 107;
                            break;
                        case 316246811:
                            b10 = !str3.equals("TB3-850F") ? (byte) -1 : (byte) 108;
                            break;
                        case 316246818:
                            b10 = !str3.equals("TB3-850M") ? (byte) -1 : (byte) 109;
                            break;
                        case 407160593:
                            b10 = !str3.equals("Pixi5-10_4G") ? (byte) -1 : (byte) 110;
                            break;
                        case 507412548:
                            b10 = !str3.equals("QM16XE_U") ? (byte) -1 : (byte) 111;
                            break;
                        case 793982701:
                            b10 = !str3.equals("GIONEE_WBL5708") ? (byte) -1 : (byte) 112;
                            break;
                        case 794038622:
                            b10 = !str3.equals("GIONEE_WBL7365") ? (byte) -1 : (byte) 113;
                            break;
                        case 794040393:
                            b10 = !str3.equals("GIONEE_WBL7519") ? (byte) -1 : (byte) 114;
                            break;
                        case 835649806:
                            b10 = !str3.equals("manning") ? (byte) -1 : (byte) 115;
                            break;
                        case 917340916:
                            b10 = !str3.equals("A7000plus") ? (byte) -1 : (byte) 116;
                            break;
                        case 958008161:
                            b10 = !str3.equals("j2xlteins") ? (byte) -1 : (byte) 117;
                            break;
                        case 1060579533:
                            b10 = !str3.equals("panell_d") ? (byte) -1 : (byte) 118;
                            break;
                        case 1150207623:
                            b10 = !str3.equals("LS-5017") ? (byte) -1 : (byte) 119;
                            break;
                        case 1176899427:
                            b10 = !str3.equals("itel_S41") ? (byte) -1 : (byte) 120;
                            break;
                        case 1280332038:
                            b10 = !str3.equals("hwALE-H") ? (byte) -1 : (byte) 121;
                            break;
                        case 1306947716:
                            b10 = !str3.equals("EverStar_S") ? (byte) -1 : (byte) 122;
                            break;
                        case 1349174697:
                            b10 = !str3.equals("htc_e56ml_dtul") ? (byte) -1 : (byte) 123;
                            break;
                        case 1522194893:
                            b10 = !str3.equals("woods_f") ? (byte) -1 : (byte) 124;
                            break;
                        case 1691543273:
                            b10 = !str3.equals("CPH1609") ? (byte) -1 : (byte) 125;
                            break;
                        case 1691544261:
                            b10 = !str3.equals("CPH1715") ? (byte) -1 : (byte) 126;
                            break;
                        case 1709443163:
                            b10 = !str3.equals("iball8735_9806") ? (byte) -1 : (byte) 127;
                            break;
                        case 1865889110:
                            b10 = !str3.equals("santoni") ? (byte) -1 : (byte) 128;
                            break;
                        case 1906253259:
                            b10 = !str3.equals("PB2-670M") ? (byte) -1 : (byte) 129;
                            break;
                        case 1977196784:
                            b10 = !str3.equals("Infinix-X572") ? (byte) -1 : (byte) 130;
                            break;
                        case 2006372676:
                            b10 = !str3.equals("BRAVIA_ATV3_4K") ? (byte) -1 : (byte) 131;
                            break;
                        case 2019281702:
                            b10 = !str3.equals("DM-01K") ? (byte) -1 : (byte) 132;
                            break;
                        case 2029784656:
                            b10 = !str3.equals("HWBLN-H") ? (byte) -1 : (byte) 133;
                            break;
                        case 2030379515:
                            b10 = !str3.equals("HWCAM-H") ? (byte) -1 : (byte) 134;
                            break;
                        case 2033393791:
                            b10 = !str3.equals("ASUS_X00AD_2") ? (byte) -1 : (byte) 135;
                            break;
                        case 2047190025:
                            b10 = !str3.equals("ELUGA_Note") ? (byte) -1 : (byte) 136;
                            break;
                        case 2047252157:
                            b10 = !str3.equals("ELUGA_Prim") ? (byte) -1 : (byte) 137;
                            break;
                        case 2048319463:
                            b10 = !str3.equals("HWVNS-H") ? (byte) -1 : (byte) 138;
                            break;
                        case 2048855701:
                            b10 = !str3.equals("HWWAS-H") ? (byte) -1 : (byte) 139;
                            break;
                        default:
                            b10 = -1;
                            break;
                    }
                    switch (b10) {
                        default:
                            str.hashCode();
                            if (!str.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                        case 131:
                        case 132:
                        case 133:
                        case 134:
                        case 135:
                        case 136:
                        case 137:
                        case 138:
                        case TsExtractor.TS_STREAM_TYPE_DTS_UHD /* 139 */:
                            return true;
                    }
                }
                break;
        }
        return true;
    }

    public static int g1(b3.n nVar, o1 o1Var) {
        int iIntValue;
        int i10 = o1Var.f29352q;
        int i11 = o1Var.f29353r;
        if (i10 == -1 || i11 == -1) {
            return -1;
        }
        String str = o1Var.f29347l;
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair<Integer, Integer> pairQ = b3.v.q(o1Var);
            str = (pairQ == null || !((iIntValue = ((Integer) pairQ.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                return l1(i10 * i11, 2);
            case "video/hevc":
                return Math.max(2097152, l1(i10 * i11, 2));
            case "video/avc":
                String str2 = o0.f217d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(o0.f216c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && nVar.f2006g)))) {
                    return -1;
                }
                return l1(o0.l(i10, 16) * o0.l(i11, 16) * 16 * 16, 2);
            case "video/x-vnd.on2.vp9":
                return l1(i10 * i11, 4);
            default:
                return -1;
        }
    }

    @Nullable
    private static Point h1(b3.n nVar, o1 o1Var) {
        int i10 = o1Var.f29353r;
        int i11 = o1Var.f29352q;
        boolean z10 = i10 > i11;
        int i12 = z10 ? i10 : i11;
        if (z10) {
            i10 = i11;
        }
        float f10 = i10 / i12;
        for (int i13 : f2115p1) {
            int i14 = (int) (i13 * f10);
            if (i13 <= i12 || i14 <= i10) {
                break;
            }
            if (o0.f214a >= 21) {
                int i15 = z10 ? i14 : i13;
                if (!z10) {
                    i13 = i14;
                }
                Point pointB = nVar.b(i15, i13);
                if (nVar.u(pointB.x, pointB.y, o1Var.f29354s)) {
                    return pointB;
                }
            } else {
                try {
                    int iL = o0.l(i13, 16) * 16;
                    int iL2 = o0.l(i14, 16) * 16;
                    if (iL * iL2 <= b3.v.N()) {
                        int i16 = z10 ? iL2 : iL;
                        if (!z10) {
                            iL = iL2;
                        }
                        return new Point(i16, iL);
                    }
                } catch (v.c unused) {
                }
            }
        }
        return null;
    }

    private static List<b3.n> j1(Context context, b3.q qVar, o1 o1Var, boolean z10, boolean z11) throws v.c {
        String str = o1Var.f29347l;
        if (str == null) {
            return com.google.common.collect.y.q();
        }
        List<b3.n> decoderInfos = qVar.getDecoderInfos(str, z10, z11);
        String strM = b3.v.m(o1Var);
        if (strM == null) {
            return com.google.common.collect.y.m(decoderInfos);
        }
        List<b3.n> decoderInfos2 = qVar.getDecoderInfos(strM, z10, z11);
        return (o0.f214a < 26 || !MimeTypes.VIDEO_DOLBY_VISION.equals(o1Var.f29347l) || decoderInfos2.isEmpty() || a.a(context)) ? com.google.common.collect.y.k().j(decoderInfos).j(decoderInfos2).k() : com.google.common.collect.y.m(decoderInfos2);
    }

    protected static int k1(b3.n nVar, o1 o1Var) {
        if (o1Var.f29348m == -1) {
            return g1(nVar, o1Var);
        }
        int size = o1Var.f29349n.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += o1Var.f29349n.get(i10).length;
        }
        return o1Var.f29348m + length;
    }

    private static int l1(int i10, int i11) {
        return (i10 * 3) / (i11 * 2);
    }

    private static boolean n1(long j10) {
        return j10 < -30000;
    }

    private static boolean o1(long j10) {
        return j10 < -500000;
    }

    private void q1() {
        if (this.Z0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.I0.n(this.Z0, jElapsedRealtime - this.Y0);
            this.Z0 = 0;
            this.Y0 = jElapsedRealtime;
        }
    }

    private void s1() {
        int i10 = this.f2123f1;
        if (i10 != 0) {
            this.I0.B(this.f2122e1, i10);
            this.f2122e1 = 0L;
            this.f2123f1 = 0;
        }
    }

    private void t1() {
        int i10 = this.f2124g1;
        if (i10 == -1 && this.f2125h1 == -1) {
            return;
        }
        b0 b0Var = this.f2128k1;
        if (b0Var != null && b0Var.f2079a == i10 && b0Var.f2080b == this.f2125h1 && b0Var.f2081c == this.f2126i1 && b0Var.f2082d == this.f2127j1) {
            return;
        }
        b0 b0Var2 = new b0(this.f2124g1, this.f2125h1, this.f2126i1, this.f2127j1);
        this.f2128k1 = b0Var2;
        this.I0.D(b0Var2);
    }

    private void u1() {
        if (this.R0) {
            this.I0.A(this.P0);
        }
    }

    private void v1() {
        b0 b0Var = this.f2128k1;
        if (b0Var != null) {
            this.I0.D(b0Var);
        }
    }

    private void w1(long j10, long j11, o1 o1Var) {
        l lVar = this.f2132o1;
        if (lVar != null) {
            lVar.a(j10, j11, o1Var, Z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        L0();
    }

    @RequiresApi(17)
    private void z1() {
        Surface surface = this.P0;
        i iVar = this.Q0;
        if (surface == iVar) {
            this.P0 = null;
        }
        iVar.release();
        this.Q0 = null;
    }

    protected void A1(b3.l lVar, int i10, long j10) {
        t1();
        m0.a("releaseOutputBuffer");
        lVar.releaseOutputBuffer(i10, true);
        m0.c();
        this.f2121d1 = SystemClock.elapsedRealtime() * 1000;
        this.B0.f31577e++;
        this.f2118a1 = 0;
        r1();
    }

    @RequiresApi(21)
    protected void B1(b3.l lVar, int i10, long j10, long j11) {
        t1();
        m0.a("releaseOutputBuffer");
        lVar.releaseOutputBuffer(i10, j11);
        m0.c();
        this.f2121d1 = SystemClock.elapsedRealtime() * 1000;
        this.B0.f31577e++;
        this.f2118a1 = 0;
        r1();
    }

    @Override // b3.o
    @CallSuper
    protected void F0() {
        super.F0();
        this.f2119b1 = 0;
    }

    @RequiresApi(23)
    protected void F1(b3.l lVar, Surface surface) {
        lVar.setOutputSurface(surface);
    }

    protected boolean G1(long j10, long j11, boolean z10) {
        return o1(j10) && !z10;
    }

    protected boolean H1(long j10, long j11, boolean z10) {
        return n1(j10) && !z10;
    }

    protected boolean I1(long j10, long j11) {
        return n1(j10) && j11 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    @Override // b3.o
    protected b3.m J(Throwable th, @Nullable b3.n nVar) {
        return new g(th, nVar, this.P0);
    }

    protected void K1(b3.l lVar, int i10, long j10) {
        m0.a("skipVideoBuffer");
        lVar.releaseOutputBuffer(i10, false);
        m0.c();
        this.B0.f31578f++;
    }

    protected void L1(int i10, int i11) {
        n2.e eVar = this.B0;
        eVar.f31580h += i10;
        int i12 = i10 + i11;
        eVar.f31579g += i12;
        this.Z0 += i12;
        int i13 = this.f2118a1 + i12;
        this.f2118a1 = i13;
        eVar.f31581i = Math.max(i13, eVar.f31581i);
        int i14 = this.K0;
        if (i14 <= 0 || this.Z0 < i14) {
            return;
        }
        q1();
    }

    protected void M1(long j10) {
        this.B0.a(j10);
        this.f2122e1 += j10;
        this.f2123f1++;
    }

    @Override // b3.o
    protected boolean P0(b3.n nVar) {
        return this.P0 != null || J1(nVar);
    }

    @Override // b3.o
    protected int S0(b3.q qVar, o1 o1Var) throws v.c {
        boolean z10;
        int i10 = 0;
        if (!a4.x.o(o1Var.f29347l)) {
            return b3.a(0);
        }
        boolean z11 = o1Var.f29350o != null;
        List<b3.n> listJ1 = j1(this.G0, qVar, o1Var, z11, false);
        if (z11 && listJ1.isEmpty()) {
            listJ1 = j1(this.G0, qVar, o1Var, false, false);
        }
        if (listJ1.isEmpty()) {
            return b3.a(1);
        }
        if (!b3.o.T0(o1Var)) {
            return b3.a(2);
        }
        b3.n nVar = listJ1.get(0);
        boolean zM = nVar.m(o1Var);
        if (zM) {
            z10 = true;
        } else {
            for (int i11 = 1; i11 < listJ1.size(); i11++) {
                b3.n nVar2 = listJ1.get(i11);
                if (nVar2.m(o1Var)) {
                    z10 = false;
                    zM = true;
                    nVar = nVar2;
                    break;
                }
            }
            z10 = true;
        }
        int i12 = zM ? 4 : 3;
        int i13 = nVar.p(o1Var) ? 16 : 8;
        int i14 = nVar.f2007h ? 64 : 0;
        int i15 = z10 ? 128 : 0;
        if (o0.f214a >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(o1Var.f29347l) && !a.a(this.G0)) {
            i15 = 256;
        }
        if (zM) {
            List<b3.n> listJ12 = j1(this.G0, qVar, o1Var, z11, true);
            if (!listJ12.isEmpty()) {
                b3.n nVar3 = b3.v.u(listJ12, o1Var).get(0);
                if (nVar3.m(o1Var) && nVar3.p(o1Var)) {
                    i10 = 32;
                }
            }
        }
        return b3.c(i12, i13, i10, i14, i15);
    }

    @Override // b3.o
    protected boolean X() {
        return this.f2129l1 && o0.f214a < 23;
    }

    @Override // b3.o
    protected float Y(float f10, o1 o1Var, o1[] o1VarArr) {
        float fMax = -1.0f;
        for (o1 o1Var2 : o1VarArr) {
            float f11 = o1Var2.f29354s;
            if (f11 != -1.0f) {
                fMax = Math.max(fMax, f11);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f10;
    }

    @Override // b3.o
    protected List<b3.n> a0(b3.q qVar, o1 o1Var, boolean z10) throws v.c {
        return b3.v.u(j1(this.G0, qVar, o1Var, z10, this.f2129l1), o1Var);
    }

    protected boolean b1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (h.class) {
            if (!f2116q1) {
                f2117r1 = f1();
                f2116q1 = true;
            }
        }
        return f2117r1;
    }

    @Override // b3.o
    @TargetApi(17)
    protected l.a c0(b3.n nVar, o1 o1Var, @Nullable MediaCrypto mediaCrypto, float f10) {
        i iVar = this.Q0;
        if (iVar != null && iVar.f2140a != nVar.f2006g) {
            z1();
        }
        String str = nVar.f2002c;
        b bVarI1 = i1(nVar, o1Var, l());
        this.M0 = bVarI1;
        MediaFormat mediaFormatM1 = m1(o1Var, str, bVarI1, f10, this.L0, this.f2129l1 ? this.f2130m1 : 0);
        if (this.P0 == null) {
            if (!J1(nVar)) {
                throw new IllegalStateException();
            }
            if (this.Q0 == null) {
                this.Q0 = i.c(this.G0, nVar.f2006g);
            }
            this.P0 = this.Q0;
        }
        return l.a.b(nVar, mediaFormatM1, o1Var, this.P0, mediaCrypto);
    }

    protected void e1(b3.l lVar, int i10, long j10) {
        m0.a("dropVideoBuffer");
        lVar.releaseOutputBuffer(i10, false);
        m0.c();
        L1(0, 1);
    }

    @Override // b3.o
    @TargetApi(29)
    protected void f0(n2.g gVar) throws k2.q {
        if (this.O0) {
            ByteBuffer byteBuffer = (ByteBuffer) a4.a.e(gVar.f31589f);
            if (byteBuffer.remaining() >= 7) {
                byte b10 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                byteBuffer.position(0);
                if (b10 == -75 && s10 == 60 && s11 == 1 && b11 == 4) {
                    if (b12 == 0 || b12 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        C1(V(), bArr);
                    }
                }
            }
        }
    }

    @Override // k2.a3, k2.c3
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // k2.f, k2.v2.b
    public void handleMessage(int i10, @Nullable Object obj) throws k2.q {
        if (i10 == 1) {
            E1(obj);
            return;
        }
        if (i10 == 7) {
            this.f2132o1 = (l) obj;
            return;
        }
        if (i10 == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.f2130m1 != iIntValue) {
                this.f2130m1 = iIntValue;
                if (this.f2129l1) {
                    D0();
                    return;
                }
                return;
            }
            return;
        }
        if (i10 != 4) {
            if (i10 != 5) {
                super.handleMessage(i10, obj);
                return;
            } else {
                this.H0.o(((Integer) obj).intValue());
                return;
            }
        }
        this.S0 = ((Integer) obj).intValue();
        b3.l lVarV = V();
        if (lVarV != null) {
            lVarV.setVideoScalingMode(this.S0);
        }
    }

    protected b i1(b3.n nVar, o1 o1Var, o1[] o1VarArr) {
        int iG1;
        int iMax = o1Var.f29352q;
        int iMax2 = o1Var.f29353r;
        int iK1 = k1(nVar, o1Var);
        if (o1VarArr.length == 1) {
            if (iK1 != -1 && (iG1 = g1(nVar, o1Var)) != -1) {
                iK1 = Math.min((int) (iK1 * 1.5f), iG1);
            }
            return new b(iMax, iMax2, iK1);
        }
        int length = o1VarArr.length;
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            o1 o1VarE = o1VarArr[i10];
            if (o1Var.f29359x != null && o1VarE.f29359x == null) {
                o1VarE = o1VarE.b().J(o1Var.f29359x).E();
            }
            if (nVar.e(o1Var, o1VarE).f31599d != 0) {
                int i11 = o1VarE.f29352q;
                z10 |= i11 == -1 || o1VarE.f29353r == -1;
                iMax = Math.max(iMax, i11);
                iMax2 = Math.max(iMax2, o1VarE.f29353r);
                iK1 = Math.max(iK1, k1(nVar, o1VarE));
            }
        }
        if (z10) {
            a4.t.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + ViewHierarchyNode.JsonKeys.X + iMax2);
            Point pointH1 = h1(nVar, o1Var);
            if (pointH1 != null) {
                iMax = Math.max(iMax, pointH1.x);
                iMax2 = Math.max(iMax2, pointH1.y);
                iK1 = Math.max(iK1, g1(nVar, o1Var.b().j0(iMax).Q(iMax2).E()));
                a4.t.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + ViewHierarchyNode.JsonKeys.X + iMax2);
            }
        }
        return new b(iMax, iMax2, iK1);
    }

    @Override // b3.o, k2.a3
    public boolean isReady() {
        i iVar;
        if (super.isReady() && (this.T0 || (((iVar = this.Q0) != null && this.P0 == iVar) || V() == null || this.f2129l1))) {
            this.X0 = C.TIME_UNSET;
            return true;
        }
        if (this.X0 == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.X0) {
            return true;
        }
        this.X0 = C.TIME_UNSET;
        return false;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    protected MediaFormat m1(o1 o1Var, String str, b bVar, float f10, boolean z10, int i10) {
        Pair<Integer, Integer> pairQ;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", o1Var.f29352q);
        mediaFormat.setInteger("height", o1Var.f29353r);
        a4.w.e(mediaFormat, o1Var.f29349n);
        a4.w.c(mediaFormat, "frame-rate", o1Var.f29354s);
        a4.w.d(mediaFormat, "rotation-degrees", o1Var.f29355t);
        a4.w.b(mediaFormat, o1Var.f29359x);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(o1Var.f29347l) && (pairQ = b3.v.q(o1Var)) != null) {
            a4.w.d(mediaFormat, Scopes.PROFILE, ((Integer) pairQ.first).intValue());
        }
        mediaFormat.setInteger("max-width", bVar.f2133a);
        mediaFormat.setInteger("max-height", bVar.f2134b);
        a4.w.d(mediaFormat, "max-input-size", bVar.f2135c);
        if (o0.f214a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (z10) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            c1(mediaFormat, i10);
        }
        return mediaFormat;
    }

    @Override // b3.o, k2.f
    protected void n() {
        a1();
        Z0();
        this.R0 = false;
        this.f2131n1 = null;
        try {
            super.n();
        } finally {
            this.I0.m(this.B0);
        }
    }

    @Override // b3.o, k2.f
    protected void o(boolean z10, boolean z11) throws k2.q {
        super.o(z10, z11);
        boolean z12 = h().f29075a;
        a4.a.g((z12 && this.f2130m1 == 0) ? false : true);
        if (this.f2129l1 != z12) {
            this.f2129l1 = z12;
            D0();
        }
        this.I0.o(this.B0);
        this.U0 = z11;
        this.V0 = false;
    }

    @Override // b3.o, k2.f
    protected void p(long j10, boolean z10) throws k2.q {
        super.p(j10, z10);
        Z0();
        this.H0.j();
        this.f2120c1 = C.TIME_UNSET;
        this.W0 = C.TIME_UNSET;
        this.f2118a1 = 0;
        if (z10) {
            D1();
        } else {
            this.X0 = C.TIME_UNSET;
        }
    }

    @Override // b3.o
    protected void p0(Exception exc) {
        a4.t.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.I0.C(exc);
    }

    protected boolean p1(long j10, boolean z10) throws k2.q {
        int iW = w(j10);
        if (iW == 0) {
            return false;
        }
        if (z10) {
            n2.e eVar = this.B0;
            eVar.f31576d += iW;
            eVar.f31578f += this.f2119b1;
        } else {
            this.B0.f31582j++;
            L1(iW, this.f2119b1);
        }
        S();
        return true;
    }

    @Override // b3.o, k2.f
    @TargetApi(17)
    protected void q() {
        try {
            super.q();
        } finally {
            if (this.Q0 != null) {
                z1();
            }
        }
    }

    @Override // b3.o
    protected void q0(String str, l.a aVar, long j10, long j11) {
        this.I0.k(str, j10, j11);
        this.N0 = b1(str);
        this.O0 = ((b3.n) a4.a.e(W())).n();
        if (o0.f214a < 23 || !this.f2129l1) {
            return;
        }
        this.f2131n1 = new c((b3.l) a4.a.e(V()));
    }

    @Override // b3.o, k2.f
    protected void r() {
        super.r();
        this.Z0 = 0;
        this.Y0 = SystemClock.elapsedRealtime();
        this.f2121d1 = SystemClock.elapsedRealtime() * 1000;
        this.f2122e1 = 0L;
        this.f2123f1 = 0;
        this.H0.k();
    }

    @Override // b3.o
    protected void r0(String str) {
        this.I0.l(str);
    }

    void r1() {
        this.V0 = true;
        if (this.T0) {
            return;
        }
        this.T0 = true;
        this.I0.A(this.P0);
        this.R0 = true;
    }

    @Override // b3.o, k2.f
    protected void s() {
        this.X0 = C.TIME_UNSET;
        q1();
        s1();
        this.H0.l();
        super.s();
    }

    @Override // b3.o
    @Nullable
    protected n2.i s0(p1 p1Var) throws k2.q {
        n2.i iVarS0 = super.s0(p1Var);
        this.I0.p(p1Var.f29409b, iVarS0);
        return iVarS0;
    }

    @Override // b3.o, k2.f, k2.a3
    public void setPlaybackSpeed(float f10, float f11) throws k2.q {
        super.setPlaybackSpeed(f10, f11);
        this.H0.i(f10);
    }

    @Override // b3.o
    protected void t0(o1 o1Var, @Nullable MediaFormat mediaFormat) {
        b3.l lVarV = V();
        if (lVarV != null) {
            lVarV.setVideoScalingMode(this.S0);
        }
        if (this.f2129l1) {
            this.f2124g1 = o1Var.f29352q;
            this.f2125h1 = o1Var.f29353r;
        } else {
            a4.a.e(mediaFormat);
            boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f2124g1 = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f2125h1 = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f10 = o1Var.f29356u;
        this.f2127j1 = f10;
        if (o0.f214a >= 21) {
            int i10 = o1Var.f29355t;
            if (i10 == 90 || i10 == 270) {
                int i11 = this.f2124g1;
                this.f2124g1 = this.f2125h1;
                this.f2125h1 = i11;
                this.f2127j1 = 1.0f / f10;
            }
        } else {
            this.f2126i1 = o1Var.f29355t;
        }
        this.H0.g(o1Var.f29354s);
    }

    @Override // b3.o
    @CallSuper
    protected void v0(long j10) {
        super.v0(j10);
        if (this.f2129l1) {
            return;
        }
        this.f2119b1--;
    }

    @Override // b3.o
    protected void w0() {
        super.w0();
        Z0();
    }

    @Override // b3.o
    @CallSuper
    protected void x0(n2.g gVar) throws k2.q {
        boolean z10 = this.f2129l1;
        if (!z10) {
            this.f2119b1++;
        }
        if (o0.f214a >= 23 || !z10) {
            return;
        }
        x1(gVar.f31588e);
    }

    protected void x1(long j10) throws k2.q {
        W0(j10);
        t1();
        this.B0.f31577e++;
        r1();
        v0(j10);
    }

    @Override // b3.o
    protected n2.i z(b3.n nVar, o1 o1Var, o1 o1Var2) {
        n2.i iVarE = nVar.e(o1Var, o1Var2);
        int i10 = iVarE.f31600e;
        int i11 = o1Var2.f29352q;
        b bVar = this.M0;
        if (i11 > bVar.f2133a || o1Var2.f29353r > bVar.f2134b) {
            i10 |= 256;
        }
        if (k1(nVar, o1Var2) > this.M0.f2135c) {
            i10 |= 64;
        }
        int i12 = i10;
        return new n2.i(nVar.f2000a, o1Var, o1Var2, i12 != 0 ? 0 : iVarE.f31599d, i12);
    }

    @Override // b3.o
    protected boolean z0(long j10, long j11, @Nullable b3.l lVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, o1 o1Var) throws k2.q {
        boolean z12;
        long j13;
        a4.a.e(lVar);
        if (this.W0 == C.TIME_UNSET) {
            this.W0 = j10;
        }
        if (j12 != this.f2120c1) {
            this.H0.h(j12);
            this.f2120c1 = j12;
        }
        long jD0 = d0();
        long j14 = j12 - jD0;
        if (z10 && !z11) {
            K1(lVar, i10, j14);
            return true;
        }
        double dE0 = e0();
        boolean z13 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j15 = (long) ((j12 - j10) / dE0);
        if (z13) {
            j15 -= jElapsedRealtime - j11;
        }
        if (this.P0 == this.Q0) {
            if (!n1(j15)) {
                return false;
            }
            K1(lVar, i10, j14);
            M1(j15);
            return true;
        }
        long j16 = jElapsedRealtime - this.f2121d1;
        if (this.V0 ? this.T0 : !(z13 || this.U0)) {
            j13 = j16;
            z12 = false;
        } else {
            z12 = true;
            j13 = j16;
        }
        if (this.X0 == C.TIME_UNSET && j10 >= jD0 && (z12 || (z13 && I1(j15, j13)))) {
            long jNanoTime = System.nanoTime();
            w1(j14, jNanoTime, o1Var);
            if (o0.f214a >= 21) {
                B1(lVar, i10, j14, jNanoTime);
            } else {
                A1(lVar, i10, j14);
            }
            M1(j15);
            return true;
        }
        if (z13 && j10 != this.W0) {
            long jNanoTime2 = System.nanoTime();
            long jB = this.H0.b((j15 * 1000) + jNanoTime2);
            long j17 = (jB - jNanoTime2) / 1000;
            boolean z14 = this.X0 != C.TIME_UNSET;
            if (G1(j17, j11, z11) && p1(j10, z14)) {
                return false;
            }
            if (H1(j17, j11, z11)) {
                if (z14) {
                    K1(lVar, i10, j14);
                } else {
                    e1(lVar, i10, j14);
                }
                M1(j17);
                return true;
            }
            if (o0.f214a >= 21) {
                if (j17 < 50000) {
                    w1(j14, jB, o1Var);
                    B1(lVar, i10, j14, jB);
                    M1(j17);
                    return true;
                }
            } else if (j17 < 30000) {
                if (j17 > 11000) {
                    try {
                        Thread.sleep((j17 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                w1(j14, jB, o1Var);
                A1(lVar, i10, j14);
                M1(j17);
                return true;
            }
        }
        return false;
    }

    public h(Context context, l.b bVar, b3.q qVar, long j10, boolean z10, @Nullable Handler handler, @Nullable z zVar, int i10, float f10) {
        super(2, bVar, qVar, z10, f10);
        this.J0 = j10;
        this.K0 = i10;
        Context applicationContext = context.getApplicationContext();
        this.G0 = applicationContext;
        this.H0 = new n(applicationContext);
        this.I0 = new z.a(handler, zVar);
        this.L0 = d1();
        this.X0 = C.TIME_UNSET;
        this.f2124g1 = -1;
        this.f2125h1 = -1;
        this.f2127j1 = -1.0f;
        this.S0 = 1;
        this.f2130m1 = 0;
        a1();
    }
}
