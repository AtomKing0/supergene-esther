package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.he;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.ob;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m7 implements ge {
    private int[] A;
    private int[] B;
    private int[] C;
    int G;
    String H;
    String I;
    Set<Integer> J;
    private mb K;
    private IronSourceSegment L;
    private dr M;
    private ISErrorListener N;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13172l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private q9 f13176p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.ironsource.e f13177q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ArrayList<kb> f13178r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13180t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private jg f13181u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Context f13182v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int[] f13186z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f13161a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f13162b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f13163c = 5000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f13164d = 90000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f13165e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f13166f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f13167g = "supersonic_sdk.db";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final String f13168h = IronSourceConstants.EVENTS_PROVIDER;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final String f13169i = "placement";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f13170j = ad.f11275x0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f13171k = ad.I0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f13173m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13174n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13175o = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f13179s = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13183w = 100;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13184x = 5000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f13185y = 1;
    private Map<String, String> D = new HashMap();
    private Map<String, String> E = new HashMap();
    private String F = "";
    private final Object O = new Object();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m7.this.a();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kb f13188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSource.AD_UNIT f13189b;

        b(kb kbVar, IronSource.AD_UNIT ad_unit) {
            this.f13188a = kbVar;
            this.f13189b = ad_unit;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13188a.a("eventSessionId", m7.this.f13181u.b());
            this.f13188a.a("essn", Integer.valueOf(m7.this.f13181u.c()));
            String connectionType = IronSourceUtils.getConnectionType(m7.this.f13182v);
            if (m7.this.g(this.f13188a)) {
                this.f13188a.a(v8.i.f15868t, connectionType);
            }
            if (m7.this.a(connectionType, this.f13188a)) {
                kb kbVar = this.f13188a;
                kbVar.a(m7.this.b(kbVar));
            }
            String strD = s8.d(m7.this.f13182v);
            if (strD != null) {
                this.f13188a.a(v8.i.f15869u, strD);
            }
            int iA = m7.this.a(this.f13188a.c(), this.f13189b);
            if (iA != e.NOT_SUPPORTED.a()) {
                this.f13188a.a("adUnit", Integer.valueOf(iA));
            }
            m7.this.a(this.f13188a, "reason");
            m7.this.a(this.f13188a, IronSourceConstants.EVENTS_EXT1);
            if (!m7.this.E.isEmpty()) {
                for (Map.Entry entry : m7.this.E.entrySet()) {
                    if (!this.f13188a.b().has((String) entry.getKey()) && entry.getKey() != "eventId" && entry.getKey() != "timestamp") {
                        this.f13188a.a((String) entry.getKey(), entry.getValue());
                    }
                }
            }
            if (m7.this.i(this.f13188a)) {
                if (m7.this.h(this.f13188a) && !m7.this.e(this.f13188a)) {
                    this.f13188a.a("sessionDepth", Integer.valueOf(m7.this.c(this.f13188a)));
                }
                if (m7.this.j(this.f13188a)) {
                    m7.this.f(this.f13188a);
                }
                long jA = m7.this.f13181u.a();
                if (jA > 0) {
                    this.f13188a.a("firstSessionTimestamp", Long.valueOf(jA));
                }
                IronLog.EVENT.verbose(this.f13188a.toString());
                m7.this.f13178r.add(this.f13188a);
                m7.d(m7.this);
            }
            m7 m7Var = m7.this;
            boolean zA = m7Var.a(m7Var.B) ? m7.this.a(this.f13188a.c(), m7.this.B) : m7.this.d(this.f13188a);
            if (!m7.this.f13173m && zA) {
                m7.this.f13173m = true;
            }
            if (m7.this.f13176p != null) {
                if (m7.this.g()) {
                    m7.this.f();
                    return;
                }
                m7 m7Var2 = m7.this;
                if (m7Var2.b((ArrayList<kb>) m7Var2.f13178r) || zA) {
                    m7.this.a();
                }
            }
        }
    }

    class c implements he {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(he.a aVar) {
            try {
                if (aVar.c()) {
                    ArrayList<kb> arrayListA = m7.this.f13176p.a(m7.this.I);
                    m7.this.f13180t = arrayListA.size() + m7.this.f13178r.size();
                } else {
                    IronLog.INTERNAL.error("Failed to send events. Saving them back to storage.");
                    m7.this.a(m7.this.a(aVar.b(), aVar.a()));
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                if (m7.this.N != null) {
                    m7.this.N.onError(new IllegalStateException("Error on sending data ", e10));
                }
            }
            a(aVar.b());
        }

        @Override // com.ironsource.he
        public synchronized void a(final he.a aVar) {
            m7.this.K.a(new Runnable() { // from class: com.ironsource.xx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16210a.b(aVar);
                }
            });
        }

        public void a(ArrayList<kb> arrayList) {
            if (arrayList != null) {
                try {
                    arrayList.clear();
                } catch (Exception e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error("clearData exception: " + e10.getMessage());
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m7.this.f();
        }
    }

    public enum e {
        NOT_SUPPORTED(-1),
        INTERSTITIAL(2),
        REWARDED_VIDEO(3),
        NATIVE_AD(4),
        BANNER(8);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13199a;

        e(int i10) {
            this.f13199a = i10;
        }

        public int a() {
            return this.f13199a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i10, @Nullable IronSource.AD_UNIT ad_unit) {
        e eVar;
        int iA = e.NOT_SUPPORTED.a();
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO || ((i10 >= 1000 && i10 < 2000) || (i10 >= 91000 && i10 < 92000))) {
            eVar = e.REWARDED_VIDEO;
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL || ((i10 >= 2000 && i10 < 3000) || (i10 >= 92000 && i10 < 93000))) {
            eVar = e.INTERSTITIAL;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER || ((i10 >= 3000 && i10 < 4000) || (i10 >= 93000 && i10 < 94000))) {
            eVar = e.BANNER;
        } else {
            if (ad_unit != IronSource.AD_UNIT.NATIVE_AD && ((i10 < 4000 || i10 >= 5000) && (i10 < 94000 || i10 >= 95000))) {
                return iA;
            }
            eVar = e.NATIVE_AD;
        }
        return eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int b(kb kbVar) {
        return kbVar.c() + 90000;
    }

    static /* synthetic */ int d(m7 m7Var) {
        int i10 = m7Var.f13180t;
        m7Var.f13180t = i10 + 1;
        return i10;
    }

    protected abstract int c(kb kbVar);

    abstract void d();

    protected abstract boolean d(kb kbVar);

    protected abstract String e(int i10);

    void e() {
        this.f13178r = new ArrayList<>();
        this.f13180t = 0;
        this.f13177q = rb.a(this.H, this.G);
        mb mbVar = new mb(this.I + "EventThread");
        this.K = mbVar;
        mbVar.start();
        this.K.a();
        this.f13181u = el.N().h();
        this.J = new HashSet();
        d();
    }

    protected int f(int i10) {
        return a(i10, (IronSource.AD_UNIT) null);
    }

    protected abstract void f(kb kbVar);

    public void h() {
        this.K.a(new d());
    }

    protected abstract boolean j(kb kbVar);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(kb kbVar) {
        JSONObject jSONObjectB = kbVar.b();
        if (jSONObjectB == null) {
            return false;
        }
        return jSONObjectB.has("sessionDepth");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ArrayList<kb> arrayListA;
        try {
            this.f13173m = false;
            ArrayList<kb> arrayList = new ArrayList<>();
            try {
                synchronized (this.O) {
                    arrayListA = this.f13176p.a(this.I);
                    this.f13176p.b(this.I);
                }
                ob.c cVar = new ob.c(new ob.a(arrayListA, this.f13178r), this.f13184x);
                this.f13176p.a(cVar.a(), this.I);
                arrayList.addAll(cVar.b());
            } catch (Throwable th) {
                i9.d().a(th);
                IronLog.INTERNAL.error("CombinedEventList exception: " + th.getMessage());
                ISErrorListener iSErrorListener = this.N;
                if (iSErrorListener != null) {
                    iSErrorListener.onError(new IllegalStateException("Combined event exception: ", th));
                }
                arrayList.clear();
                arrayList.addAll(this.f13178r);
            }
            if (arrayList.size() > 0) {
                this.f13178r.clear();
                this.f13180t = 0;
                JSONObject jSONObjectB = xc.a().b();
                try {
                    a(jSONObjectB);
                    String strB = b();
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObjectB.put(ad.f11275x0, strB);
                    }
                    String strQ = com.ironsource.mediationsdk.p.m().q();
                    if (!TextUtils.isEmpty(strQ)) {
                        jSONObjectB.put(ad.I0, strQ);
                    }
                    Map<String, String> mapC = c();
                    if (!mapC.isEmpty()) {
                        for (Map.Entry<String, String> entry : mapC.entrySet()) {
                            if (!jSONObjectB.has(entry.getKey())) {
                                jSONObjectB.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    JSONObject jSONObjectA = new tb().a();
                    Iterator<String> itKeys = jSONObjectA.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectB.put(next, jSONObjectA.get(next));
                    }
                } catch (Throwable th2) {
                    i9.d().a(th2);
                    IronLog.INTERNAL.error("Exception while building the event general properties: " + th2.getMessage());
                }
                String strA = this.f13177q.a(arrayList, jSONObjectB);
                if (TextUtils.isEmpty(strA)) {
                    IronLog.INTERNAL.error("Failed to parse events.");
                    ISErrorListener iSErrorListener2 = this.N;
                    if (iSErrorListener2 != null) {
                        iSErrorListener2.onError(new IllegalStateException("Event parse failed"));
                        return;
                    }
                    return;
                }
                if (this.f13174n) {
                    try {
                        strA = Base64.encodeToString(si.a(strA, this.f13175o), 0);
                    } catch (Exception e10) {
                        i9.d().a(e10);
                        ISErrorListener iSErrorListener3 = this.N;
                        if (iSErrorListener3 != null) {
                            iSErrorListener3.onError(new IllegalStateException("Error on compression: ", e10));
                        }
                    }
                }
                ls.f13064a.a(new ub(new c(), strA, this.f13177q.b(), arrayList));
            }
        } catch (Throwable th3) {
            i9.d().a(th3);
            IronLog.INTERNAL.error("Send event exception: " + th3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return (this.f13180t >= this.f13183w || this.f13173m) && this.f13172l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(kb kbVar) {
        if (kbVar == null) {
            return false;
        }
        if (a(this.f13186z)) {
            return true ^ a(kbVar.c(), this.f13186z);
        }
        if (a(this.A)) {
            return a(kbVar.c(), this.A);
        }
        return true;
    }

    public Map<String, String> c() {
        return this.D;
    }

    @Override // com.ironsource.ge
    public void d(int i10) {
        this.f13175o = i10;
    }

    protected boolean h(kb kbVar) {
        return (kbVar.c() == 14 || kbVar.c() == 114 || kbVar.c() == 514 || kbVar.c() == 515 || kbVar.c() == 516 || kbVar.c() == 140 || kbVar.c() == 40 || kbVar.c() == 41 || kbVar.c() == 50 || kbVar.c() == 51 || kbVar.c() == 52) ? false : true;
    }

    public String b() {
        return this.F;
    }

    @Override // com.ironsource.ge
    public void c(int i10) {
        if (i10 > 0) {
            this.f13185y = i10;
        }
    }

    @Override // com.ironsource.ge
    public void d(int[] iArr, Context context) {
        this.C = iArr;
        IronSourceUtils.saveDefaultNonConnectivityEvents(context, this.I, iArr);
    }

    protected boolean g(kb kbVar) {
        return (kbVar.c() == 40 || kbVar.c() == 41 || kbVar.c() == 50 || kbVar.c() == 51 || kbVar.c() == 52) ? false : true;
    }

    @Override // com.ironsource.ge
    public void b(int i10) {
        if (i10 > 0) {
            this.f13183w = i10;
        }
    }

    public void c(boolean z10) {
        this.f13172l = z10;
    }

    private void b(String str) {
        com.ironsource.e eVar = this.f13177q;
        if (eVar == null || !eVar.c().equals(str)) {
            this.f13177q = rb.a(str, this.G);
        }
    }

    String a(String str, int i10) {
        return (TextUtils.isEmpty(str) || str.length() <= i10) ? str : str.substring(0, i10);
    }

    @Override // com.ironsource.ge
    public void c(int[] iArr, Context context) {
        this.f13186z = iArr;
        IronSourceUtils.saveDefaultOptOutEvents(context, this.I, iArr);
    }

    @Override // com.ironsource.ge
    public void b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.ironsource.e eVar = this.f13177q;
        if (eVar != null) {
            eVar.a(str);
        }
        IronSourceUtils.saveDefaultEventsURL(context, this.I, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<kb> a(ArrayList<kb> arrayList, String str) {
        String strA = a(str, 1024);
        Iterator<kb> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(strA);
        }
        return arrayList;
    }

    public void b(Map<String, String> map) {
        this.E.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.O) {
            this.f13176p.a(this.f13178r, this.I);
            this.f13178r.clear();
        }
    }

    @Override // com.ironsource.ge
    public void b(boolean z10) {
        this.f13179s = z10;
    }

    @Override // com.ironsource.ge
    public void a(int i10) {
        if (i10 > 0) {
            this.f13184x = i10;
        }
    }

    @Override // com.ironsource.ge
    public void b(int[] iArr, Context context) {
        this.B = iArr;
        IronSourceUtils.saveDefaultTriggerEvents(context, this.I, iArr);
    }

    public synchronized void a(Context context, IronSourceSegment ironSourceSegment) {
        String defaultEventsFormatterType = IronSourceUtils.getDefaultEventsFormatterType(context, this.I, this.H);
        this.H = defaultEventsFormatterType;
        b(defaultEventsFormatterType);
        this.f13177q.a(IronSourceUtils.getDefaultEventsURL(context, this.I, null));
        this.f13176p = q9.a(context, "supersonic_sdk.db", 5);
        this.K.a(new a());
        this.f13186z = IronSourceUtils.getDefaultOptOutEvents(context, this.I);
        this.A = IronSourceUtils.getDefaultOptInEvents(context, this.I);
        this.B = IronSourceUtils.getDefaultTriggerEvents(context, this.I);
        this.C = IronSourceUtils.getDefaultNonConnectivityEvents(context, this.I);
        this.L = ironSourceSegment;
        this.f13182v = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ArrayList<kb> arrayList) {
        return arrayList != null && arrayList.size() >= this.f13185y;
    }

    public synchronized void a(dr drVar) {
        this.M = drVar;
    }

    @Override // com.ironsource.ge
    public synchronized void a(kb kbVar) {
        a(kbVar, (IronSource.AD_UNIT) null);
    }

    public synchronized void a(kb kbVar, @Nullable IronSource.AD_UNIT ad_unit) {
        if (kbVar != null) {
            if (this.f13179s) {
                this.K.a(new b(kbVar, ad_unit));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(kb kbVar, String str) {
        a(kbVar, str, 1024);
    }

    private void a(kb kbVar, String str, int i10) {
        JSONObject jSONObjectB = kbVar.b();
        if (jSONObjectB == null || !jSONObjectB.has(str)) {
            return;
        }
        try {
            kbVar.a(str, a(jSONObjectB.optString(str, null), i10));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.L = ironSourceSegment;
    }

    public void a(ISErrorListener iSErrorListener) {
        this.N = iSErrorListener;
    }

    public void a(String str) {
        this.F = str;
    }

    @Override // com.ironsource.ge
    public void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.H = str;
        IronSourceUtils.saveDefaultEventsFormatterType(context, this.I, str);
        b(str);
    }

    protected void a(ArrayList<kb> arrayList) {
        if (arrayList != null) {
            synchronized (this.O) {
                this.f13176p.a(arrayList, this.I);
                this.f13180t = this.f13176p.a(this.I).size() + this.f13178r.size();
            }
        }
    }

    public void a(Map<String, String> map) {
        this.D.putAll(map);
    }

    public void a(Map<String, Object> map, int i10, String str) {
        map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(i10));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put(IronSourceConstants.AUCTION_FALLBACK, str);
    }

    private void a(JSONObject jSONObject) {
        try {
            IronSourceSegment ironSourceSegment = this.L;
            if (ironSourceSegment != null) {
                if (ironSourceSegment.getAge() > 0) {
                    jSONObject.put(IronSourceSegment.AGE, this.L.getAge());
                }
                if (!TextUtils.isEmpty(this.L.getGender())) {
                    jSONObject.put(IronSourceSegment.GENDER, this.L.getGender());
                }
                if (this.L.getLevel() > 0) {
                    jSONObject.put(IronSourceSegment.LEVEL, this.L.getLevel());
                }
                if (this.L.getIsPaying() != null) {
                    jSONObject.put(IronSourceSegment.PAYING, this.L.getIsPaying().get());
                }
                if (this.L.getIapt() > 0.0d) {
                    jSONObject.put(IronSourceSegment.IAPT, this.L.getIapt());
                }
                if (this.L.getUcd() > 0) {
                    jSONObject.put(IronSourceSegment.USER_CREATION_DATE, this.L.getUcd());
                }
            }
            dr drVar = this.M;
            if (drVar != null) {
                String strB = drVar.b();
                if (!TextUtils.isEmpty(strB)) {
                    jSONObject.put("segmentId", strB);
                }
                JSONObject jSONObjectA = this.M.a();
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObjectA.get(next));
                }
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.ge
    public void a(boolean z10) {
        this.f13174n = z10;
    }

    @Override // com.ironsource.ge
    public void a(int[] iArr, Context context) {
        this.A = iArr;
        IronSourceUtils.saveDefaultOptInEvents(context, this.I, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i10, int[] iArr) {
        if (!a(iArr)) {
            return false;
        }
        for (int i11 : iArr) {
            if (i10 == i11) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(String str, kb kbVar) {
        if (str.equalsIgnoreCase("none")) {
            return a(this.C) ? a(kbVar.c(), this.C) : this.J.contains(Integer.valueOf(kbVar.c()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }
}
