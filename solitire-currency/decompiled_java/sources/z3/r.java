package z3;

import a4.a0;
import a4.o0;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.HashMap;
import java.util.Map;
import z3.e;

/* JADX INFO: compiled from: DefaultBandwidthMeter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements e, m0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.google.common.collect.y<Long> f37492p = com.google.common.collect.y.u(4800000L, 3100000L, 2100000L, 1500000L, 800000L);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.google.common.collect.y<Long> f37493q = com.google.common.collect.y.u(1500000L, 1000000L, 730000L, 440000L, 170000L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.google.common.collect.y<Long> f37494r = com.google.common.collect.y.u(2200000L, 1400000L, 1100000L, 910000L, 620000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.google.common.collect.y<Long> f37495s = com.google.common.collect.y.u(3000000L, 1900000L, 1400000L, 1000000L, 660000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.common.collect.y<Long> f37496t = com.google.common.collect.y.u(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.google.common.collect.y<Long> f37497u = com.google.common.collect.y.u(2800000L, 2400000L, 1600000L, 1100000L, 950000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private static r f37498v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.collect.a0<Integer, Long> f37499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.C0762a f37500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0 f37501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a4.d f37502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f37503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f37507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f37508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f37509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f37510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f37511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f37512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f37513o;

    /* JADX INFO: compiled from: DefaultBandwidthMeter.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Context f37514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Integer, Long> f37515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private a4.d f37517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f37518e;

        public b(Context context) {
            this.f37514a = context == null ? null : context.getApplicationContext();
            this.f37515b = b(o0.H(context));
            this.f37516c = 2000;
            this.f37517d = a4.d.f148a;
            this.f37518e = true;
        }

        private static Map<Integer, Long> b(String str) {
            int[] iArrI = r.i(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            com.google.common.collect.y<Long> yVar = r.f37492p;
            map.put(2, yVar.get(iArrI[0]));
            map.put(3, r.f37493q.get(iArrI[1]));
            map.put(4, r.f37494r.get(iArrI[2]));
            map.put(5, r.f37495s.get(iArrI[3]));
            map.put(10, r.f37496t.get(iArrI[4]));
            map.put(9, r.f37497u.get(iArrI[5]));
            map.put(7, yVar.get(iArrI[0]));
            return map;
        }

        public r a() {
            return new r(this.f37514a, this.f37515b, this.f37516c, this.f37517d, this.f37518e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] i(String str) {
        str.hashCode();
        switch (str) {
            case "AD":
            case "BM":
            case "BQ":
            case "GD":
            case "GL":
            case "KN":
            case "KY":
            case "LC":
            case "VC":
                return new int[]{1, 2, 0, 0, 2, 2};
            case "AE":
                return new int[]{1, 4, 4, 4, 4, 0};
            case "AF":
            case "GM":
                return new int[]{4, 3, 3, 4, 2, 2};
            case "AG":
                return new int[]{2, 4, 1, 2, 2, 2};
            case "AI":
                return new int[]{0, 2, 0, 3, 2, 2};
            case "AL":
            case "XK":
                return new int[]{1, 1, 1, 1, 2, 2};
            case "AM":
                return new int[]{2, 3, 2, 3, 2, 2};
            case "AO":
                return new int[]{4, 4, 3, 2, 2, 2};
            case "AQ":
            case "ER":
            case "SH":
                return new int[]{4, 2, 2, 2, 2, 2};
            case "AR":
            case "KG":
            case "TN":
            case "UY":
                return new int[]{2, 1, 1, 1, 2, 2};
            case "AS":
                return new int[]{2, 2, 3, 3, 2, 2};
            case "AT":
                return new int[]{1, 0, 1, 1, 0, 0};
            case "AU":
                return new int[]{0, 1, 1, 1, 2, 0};
            case "AW":
                return new int[]{1, 3, 4, 4, 2, 2};
            case "AX":
            case "LI":
            case "MS":
            case "PM":
            case "SM":
                return new int[]{0, 2, 2, 2, 2, 2};
            case "AZ":
            case "GF":
            case "LY":
            case "PK":
            case "SO":
            case "TO":
                return new int[]{3, 2, 3, 3, 2, 2};
            case "BA":
                return new int[]{1, 2, 1, 1, 2, 2};
            case "BB":
            case "DM":
            case "FO":
            case "GI":
                return new int[]{0, 2, 0, 0, 2, 2};
            case "BD":
                return new int[]{2, 1, 3, 3, 2, 2};
            case "BE":
                return new int[]{0, 1, 4, 4, 3, 2};
            case "BF":
                return new int[]{4, 3, 4, 3, 2, 2};
            case "BG":
            case "MT":
            case "SK":
                return new int[]{0, 0, 0, 0, 1, 2};
            case "BH":
                return new int[]{1, 2, 1, 3, 4, 2};
            case "BI":
            case "HT":
            case "KM":
            case "MG":
            case "NE":
            case "SD":
            case "TD":
            case "VE":
            case "YE":
                return new int[]{4, 4, 4, 4, 2, 2};
            case "BJ":
                return new int[]{4, 4, 3, 3, 2, 2};
            case "BL":
            case "CX":
            case "VA":
                return new int[]{1, 2, 2, 2, 2, 2};
            case "BN":
            case "CW":
                return new int[]{2, 2, 0, 0, 2, 2};
            case "BO":
                return new int[]{1, 2, 3, 2, 2, 2};
            case "BS":
                return new int[]{4, 4, 2, 2, 2, 2};
            case "BT":
                return new int[]{3, 1, 3, 2, 2, 2};
            case "BW":
                return new int[]{3, 2, 1, 0, 2, 2};
            case "BY":
                return new int[]{0, 1, 2, 3, 2, 2};
            case "BZ":
                return new int[]{2, 4, 2, 1, 2, 2};
            case "CA":
                return new int[]{0, 2, 2, 2, 3, 2};
            case "CD":
                return new int[]{4, 2, 3, 2, 2, 2};
            case "CF":
            case "KI":
                return new int[]{4, 2, 4, 2, 2, 2};
            case "CG":
            case "EG":
            case "GW":
                return new int[]{3, 4, 3, 3, 2, 2};
            case "CH":
                return new int[]{0, 0, 0, 1, 0, 2};
            case "CI":
            case "DZ":
            case "LR":
                return new int[]{3, 4, 4, 4, 2, 2};
            case "CK":
            case "PF":
                return new int[]{2, 2, 2, 1, 2, 2};
            case "CL":
            case "IL":
                return new int[]{1, 2, 2, 2, 3, 2};
            case "CM":
                return new int[]{3, 3, 3, 3, 2, 2};
            case "CN":
                return new int[]{2, 0, 1, 1, 3, 2};
            case "CO":
                return new int[]{2, 3, 4, 3, 2, 2};
            case "CR":
                return new int[]{2, 3, 4, 4, 2, 2};
            case "CU":
            case "DJ":
            case "SY":
            case "TJ":
            case "TL":
                return new int[]{4, 3, 4, 4, 2, 2};
            case "CV":
                return new int[]{2, 1, 0, 0, 2, 2};
            case "CY":
            case "KW":
                return new int[]{1, 0, 0, 0, 0, 2};
            case "CZ":
            case "NO":
                return new int[]{0, 0, 2, 0, 1, 2};
            case "DE":
                return new int[]{0, 1, 2, 2, 2, 3};
            case "DK":
                return new int[]{0, 0, 3, 2, 0, 2};
            case "DO":
                return new int[]{3, 4, 4, 4, 4, 2};
            case "EC":
                return new int[]{2, 3, 2, 1, 2, 2};
            case "EE":
            case "IS":
            case "LV":
            case "PT":
            case "SE":
            case "TW":
                return new int[]{0, 0, 0, 0, 0, 2};
            case "ES":
            case "IE":
                return new int[]{0, 1, 1, 1, 2, 2};
            case "ET":
                return new int[]{4, 3, 3, 1, 2, 2};
            case "FI":
                return new int[]{0, 0, 0, 3, 0, 2};
            case "FJ":
                return new int[]{3, 1, 2, 2, 2, 2};
            case "FK":
            case "KE":
            case "KP":
                return new int[]{3, 2, 2, 2, 2, 2};
            case "FM":
                return new int[]{4, 2, 4, 1, 2, 2};
            case "FR":
                return new int[]{1, 2, 3, 1, 0, 2};
            case "GA":
            case "TG":
                return new int[]{3, 4, 1, 0, 2, 2};
            case "GB":
                return new int[]{0, 0, 1, 1, 1, 1};
            case "GE":
                return new int[]{1, 1, 1, 2, 2, 2};
            case "GG":
            case "VI":
                return new int[]{0, 2, 0, 1, 2, 2};
            case "GH":
            case "NA":
            case "VU":
                return new int[]{3, 3, 3, 2, 2, 2};
            case "GN":
                return new int[]{4, 3, 4, 2, 2, 2};
            case "GP":
            case "MQ":
                return new int[]{2, 1, 2, 3, 2, 2};
            case "GQ":
                return new int[]{4, 2, 1, 4, 2, 2};
            case "GR":
            case "HR":
            case "SI":
                return new int[]{1, 0, 0, 0, 1, 2};
            case "GT":
                return new int[]{2, 3, 2, 2, 2, 2};
            case "GU":
            case "PE":
                return new int[]{1, 2, 4, 4, 4, 2};
            case "GY":
                return new int[]{3, 2, 2, 1, 2, 2};
            case "HK":
                return new int[]{0, 1, 2, 3, 2, 0};
            case "HU":
                return new int[]{0, 0, 0, 1, 3, 2};
            case "ID":
                return new int[]{3, 1, 2, 2, 3, 2};
            case "IM":
            case "UA":
                return new int[]{0, 2, 1, 1, 2, 2};
            case "IN":
                return new int[]{1, 1, 3, 2, 3, 3};
            case "IO":
            case "MH":
            case "TV":
            case "WF":
                return new int[]{4, 2, 2, 4, 2, 2};
            case "IQ":
                return new int[]{3, 2, 2, 3, 2, 2};
            case "IR":
                return new int[]{3, 0, 1, 1, 4, 1};
            case "IT":
                return new int[]{0, 0, 0, 1, 1, 2};
            case "JE":
            case "YT":
                return new int[]{4, 2, 2, 3, 2, 2};
            case "JM":
                return new int[]{2, 4, 3, 2, 2, 2};
            case "JO":
                return new int[]{2, 1, 1, 2, 2, 2};
            case "JP":
                return new int[]{0, 1, 1, 2, 2, 4};
            case "KH":
                return new int[]{2, 1, 4, 2, 2, 2};
            case "KR":
                return new int[]{0, 1, 1, 3, 4, 4};
            case "KZ":
                return new int[]{2, 1, 2, 2, 2, 2};
            case "LA":
                return new int[]{1, 2, 1, 3, 2, 2};
            case "LB":
                return new int[]{3, 3, 2, 4, 2, 2};
            case "LK":
                return new int[]{3, 1, 3, 3, 4, 2};
            case "LS":
                return new int[]{3, 3, 2, 2, 2, 2};
            case "LT":
                return new int[]{0, 0, 0, 0, 2, 2};
            case "LU":
                return new int[]{1, 0, 3, 2, 1, 4};
            case "MA":
                return new int[]{3, 3, 1, 1, 2, 2};
            case "MC":
                return new int[]{0, 2, 2, 0, 2, 2};
            case "MD":
            case "RS":
                return new int[]{1, 0, 0, 0, 2, 2};
            case "ME":
                return new int[]{2, 0, 0, 1, 2, 2};
            case "MF":
            case "RE":
                return new int[]{1, 2, 1, 2, 2, 2};
            case "MK":
                return new int[]{1, 0, 0, 1, 3, 2};
            case "ML":
            case "PG":
                return new int[]{4, 3, 3, 2, 2, 2};
            case "MM":
                return new int[]{2, 4, 2, 3, 2, 2};
            case "MN":
                return new int[]{2, 0, 1, 2, 2, 2};
            case "MO":
            case "MP":
                return new int[]{0, 2, 4, 4, 2, 2};
            case "MR":
            case "ZW":
                return new int[]{4, 2, 4, 4, 2, 2};
            case "MU":
                return new int[]{3, 1, 1, 2, 2, 2};
            case "MV":
                return new int[]{3, 4, 1, 4, 2, 2};
            case "MW":
                return new int[]{4, 2, 3, 3, 2, 2};
            case "MX":
                return new int[]{2, 4, 3, 4, 2, 2};
            case "MY":
                return new int[]{1, 0, 3, 1, 3, 2};
            case "MZ":
                return new int[]{3, 1, 2, 1, 2, 2};
            case "NC":
                return new int[]{3, 3, 4, 4, 2, 2};
            case "NG":
                return new int[]{3, 4, 2, 1, 2, 2};
            case "NI":
            case "PA":
            case "SV":
                return new int[]{2, 3, 3, 3, 2, 2};
            case "NL":
                return new int[]{0, 2, 2, 3, 0, 3};
            case "NP":
                return new int[]{2, 2, 4, 3, 2, 2};
            case "NR":
            case "NU":
                return new int[]{4, 2, 2, 1, 2, 2};
            case "NZ":
            case "PL":
                return new int[]{1, 1, 2, 2, 4, 2};
            case "OM":
                return new int[]{2, 3, 1, 3, 4, 2};
            case "PH":
                return new int[]{2, 1, 3, 3, 3, 0};
            case "PR":
                return new int[]{2, 0, 2, 1, 2, 1};
            case "PS":
                return new int[]{3, 4, 1, 2, 2, 2};
            case "PW":
                return new int[]{2, 2, 4, 1, 2, 2};
            case "QA":
                return new int[]{2, 4, 4, 4, 4, 2};
            case "RO":
                return new int[]{0, 0, 1, 2, 1, 2};
            case "RU":
                return new int[]{1, 0, 0, 0, 4, 3};
            case "RW":
                return new int[]{3, 4, 2, 0, 2, 2};
            case "SA":
                return new int[]{3, 1, 1, 1, 2, 2};
            case "SB":
                return new int[]{4, 2, 4, 3, 2, 2};
            case "SC":
            case "TM":
                return new int[]{4, 2, 1, 1, 2, 2};
            case "SG":
                return new int[]{1, 1, 2, 2, 2, 1};
            case "SL":
            case "UG":
                return new int[]{3, 3, 4, 3, 2, 2};
            case "SN":
                return new int[]{4, 4, 4, 3, 2, 2};
            case "SR":
                return new int[]{2, 4, 3, 0, 2, 2};
            case "SS":
                return new int[]{4, 3, 2, 3, 2, 2};
            case "ST":
                return new int[]{2, 2, 1, 2, 2, 2};
            case "SX":
            case "TC":
                return new int[]{1, 2, 1, 0, 2, 2};
            case "SZ":
                return new int[]{3, 3, 3, 4, 2, 2};
            case "TH":
                return new int[]{0, 2, 2, 3, 3, 4};
            case "TK":
                return new int[]{2, 2, 2, 4, 2, 2};
            case "TR":
                return new int[]{1, 1, 0, 0, 2, 2};
            case "TT":
                return new int[]{1, 4, 1, 3, 2, 2};
            case "TZ":
                return new int[]{3, 4, 3, 2, 2, 2};
            case "US":
                return new int[]{1, 0, 2, 2, 3, 1};
            case "UZ":
                return new int[]{2, 2, 3, 4, 2, 2};
            case "VG":
                return new int[]{2, 2, 1, 1, 2, 2};
            case "VN":
                return new int[]{0, 3, 3, 4, 2, 2};
            case "WS":
                return new int[]{3, 1, 3, 1, 2, 2};
            case "ZA":
                return new int[]{3, 2, 2, 1, 1, 2};
            case "ZM":
                return new int[]{3, 3, 4, 2, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    private long j(int i10) {
        Long l10 = this.f37499a.get(Integer.valueOf(i10));
        if (l10 == null) {
            l10 = this.f37499a.get(0);
        }
        if (l10 == null) {
            l10 = 1000000L;
        }
        return l10.longValue();
    }

    public static synchronized r k(Context context) {
        if (f37498v == null) {
            f37498v = new b(context).a();
        }
        return f37498v;
    }

    private static boolean l(o oVar, boolean z10) {
        return z10 && !oVar.d(8);
    }

    private void m(int i10, long j10, long j11) {
        if (i10 == 0 && j10 == 0 && j11 == this.f37511m) {
            return;
        }
        this.f37511m = j11;
        this.f37500b.c(i10, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(int i10) {
        int i11 = this.f37507i;
        if (i11 == 0 || this.f37503e) {
            if (this.f37512n) {
                i10 = this.f37513o;
            }
            if (i11 == i10) {
                return;
            }
            this.f37507i = i10;
            if (i10 != 1 && i10 != 0 && i10 != 8) {
                this.f37510l = j(i10);
                long jElapsedRealtime = this.f37502d.elapsedRealtime();
                m(this.f37504f > 0 ? (int) (jElapsedRealtime - this.f37505g) : 0, this.f37506h, this.f37510l);
                this.f37505g = jElapsedRealtime;
                this.f37506h = 0L;
                this.f37509k = 0L;
                this.f37508j = 0L;
                this.f37501c.i();
            }
        }
    }

    @Override // z3.e
    public void a(e.a aVar) {
        this.f37500b.e(aVar);
    }

    @Override // z3.m0
    public synchronized void b(k kVar, o oVar, boolean z10, int i10) {
        if (l(oVar, z10)) {
            this.f37506h += (long) i10;
        }
    }

    @Override // z3.e
    public void c(Handler handler, e.a aVar) {
        a4.a.e(handler);
        a4.a.e(aVar);
        this.f37500b.b(handler, aVar);
    }

    @Override // z3.m0
    public synchronized void d(k kVar, o oVar, boolean z10) {
        if (l(oVar, z10)) {
            if (this.f37504f == 0) {
                this.f37505g = this.f37502d.elapsedRealtime();
            }
            this.f37504f++;
        }
    }

    @Override // z3.m0
    public synchronized void f(k kVar, o oVar, boolean z10) {
        if (l(oVar, z10)) {
            a4.a.g(this.f37504f > 0);
            long jElapsedRealtime = this.f37502d.elapsedRealtime();
            int i10 = (int) (jElapsedRealtime - this.f37505g);
            this.f37508j += (long) i10;
            long j10 = this.f37509k;
            long j11 = this.f37506h;
            this.f37509k = j10 + j11;
            if (i10 > 0) {
                this.f37501c.c((int) Math.sqrt(j11), (j11 * 8000.0f) / i10);
                if (this.f37508j >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || this.f37509k >= 524288) {
                    this.f37510l = (long) this.f37501c.f(0.5f);
                }
                m(i10, this.f37506h, this.f37510l);
                this.f37505g = jElapsedRealtime;
                this.f37506h = 0L;
            }
            this.f37504f--;
        }
    }

    private r(@Nullable Context context, Map<Integer, Long> map, int i10, a4.d dVar, boolean z10) {
        this.f37499a = com.google.common.collect.a0.c(map);
        this.f37500b = new e.a.C0762a();
        this.f37501c = new k0(i10);
        this.f37502d = dVar;
        this.f37503e = z10;
        if (context == null) {
            this.f37507i = 0;
            this.f37510l = j(0);
            return;
        }
        a4.a0 a0VarD = a4.a0.d(context);
        int iF = a0VarD.f();
        this.f37507i = iF;
        this.f37510l = j(iF);
        a0VarD.i(new a0.c() { // from class: z3.q
            @Override // a4.a0.c
            public final void onNetworkTypeChanged(int i11) {
                this.f37491a.n(i11);
            }
        });
    }

    @Override // z3.e
    public m0 getTransferListener() {
        return this;
    }

    @Override // z3.m0
    public void e(k kVar, o oVar, boolean z10) {
    }
}
