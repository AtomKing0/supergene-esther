package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.a0;
import com.applovin.impl.j2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v2;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class e3 extends k2 implements AppLovinCommunicatorSubscriber, a0.a {
    private List A;
    private List B;
    private List C;
    private List D;
    private List E;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.applovin.impl.sdk.j f5087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f5088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f5089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f5090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f5092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f5093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Boolean f5094l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f5095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final StringBuilder f5096n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f5097o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f5098p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List f5099q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List f5100r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List f5101s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List f5102t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List f5103u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List f5104v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List f5105w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List f5106x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List f5107y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List f5108z;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5109a;

        static {
            int[] iArr = new int[a0.b.values().length];
            f5109a = iArr;
            try {
                iArr[a0.b.APP_DETAILS_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5109a[a0.b.INVALID_DEVELOPER_URI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5109a[a0.b.APPADSTXT_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5109a[a0.b.MISSING_APPLOVIN_ENTRIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5109a[a0.b.MISSING_NON_APPLOVIN_ENTRIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    private enum c {
        SUCCESS,
        WARNING,
        ERROR
    }

    public enum d {
        CMP,
        NETWORK_CONSENT_STATUSES,
        DO_NOT_SELL,
        COUNT
    }

    public enum e {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        MICRO_SDK_PARTNER_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public e3(Context context) {
        super(context);
        this.f5096n = new StringBuilder("");
        this.f5097o = new AtomicBoolean();
        this.f5098p = false;
        this.f5099q = new ArrayList();
        this.f5100r = new ArrayList();
        this.f5101s = new ArrayList();
        this.f5102t = new ArrayList();
        this.f5103u = new ArrayList();
        this.f5104v = new ArrayList();
        this.f5105w = new ArrayList();
        this.f5106x = new ArrayList();
        this.f5107y = new ArrayList();
        this.f5108z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = new ArrayList();
    }

    private List g() {
        boolean zC = this.f5087e.l0().c();
        List listB = this.f5087e.l0().b();
        return zC ? a((String) null, a(listB, false)) : a(a(listB, true), (String) null);
    }

    private List j() {
        String str;
        ArrayList arrayList = new ArrayList(7);
        try {
            str = this.f5532a.getPackageManager().getPackageInfo(this.f5532a.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(j2.a().d("Package Name").c(this.f5532a.getPackageName()).a());
        j2.b bVarD = j2.a().d("App Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        arrayList.add(j2.a().d("OS").c(z6.d()).a());
        arrayList.add(j2.a().d("Account").c(StringUtils.isValidString(this.f5093k) ? this.f5093k : "None").a());
        arrayList.add(j2.a().d("Mediation Provider").c(StringUtils.isValidString(this.f5087e.O()) ? this.f5087e.O() : "None").a());
        arrayList.add(j2.a().d("OM SDK Version").c(this.f5087e.W().c()).a());
        arrayList.add(a(com.applovin.impl.sdk.j.y0()));
        if (this.f5094l != null) {
            arrayList.add(j2.a().d("Google Families Policy").c(String.valueOf(this.f5094l)).a());
        }
        return arrayList;
    }

    private j2 l() {
        String strD = this.f5087e.k0().d();
        boolean zIsValidString = StringUtils.isValidString(strD);
        boolean zIsValidString2 = StringUtils.isValidString(this.f5087e.k0().k());
        j2.b bVarD = j2.a(j2.c.DETAIL).d("CMP (Consent Management Platform)");
        if (!zIsValidString) {
            strD = zIsValidString2 ? "Unknown" : "None";
        }
        j2.b bVarC = bVarD.c(strD);
        if (this.f5095m) {
            bVarC.a(true);
            if (zIsValidString2) {
                bVarC.a(this.f5532a);
            } else {
                bVarC.b("TC Data Not Found");
                bVarC.a("By January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                boolean z10 = this.f5087e.t().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
                bVarC.a(z10 ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning);
                bVarC.b(i0.a(z10 ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f5532a));
            }
        }
        return bVarC.a();
    }

    private j2 m() {
        return j2.a().d("MAX Terms and Privacy Policy Flow").a(this.f5532a).a(true).a();
    }

    private j2 n() {
        boolean zHasSupportedCmp = this.f5087e.q().hasSupportedCmp();
        return j2.a().d("Google UMP SDK").a(zHasSupportedCmp ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(i0.a(zHasSupportedCmp ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f5532a)).b("Google UMP SDK").a("In order to use MAX Terms and Privacy Policy Flow, you must add the Google User Messaging Platform SDK as a dependency.\n\nFor more details, see:\nhttps://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow").a(!zHasSupportedCmp).a();
    }

    private List q() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(j2.a().d("SDK Version").c(AppLovinSdk.VERSION).a());
        String str = (String) this.f5087e.a(l4.f5761v3);
        j2.b bVarD = j2.a().d("Plugin Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        arrayList.add(e());
        if (this.f5087e.A0()) {
            String strA = z6.a(this.f5087e.g0());
            arrayList.add(b("Unity Version", StringUtils.isValidString(strA) ? strA : "None"));
        }
        if (this.f5087e.v().j()) {
            arrayList.add(m());
            arrayList.add(n());
        } else if (this.f5087e.v().l()) {
            arrayList.add(u());
        }
        return arrayList;
    }

    private j2 r() {
        return j2.a().d("Network Consent Statuses").a(this.f5532a).a(true).a();
    }

    private List s() {
        ArrayList arrayList = new ArrayList(d.COUNT.ordinal());
        arrayList.add(l());
        if (StringUtils.isValidString(this.f5087e.k0().k())) {
            arrayList.add(r());
        } else {
            arrayList.add(new f4(l0.b(), false, this.f5532a));
        }
        arrayList.add(new f4(l0.a(), true, this.f5532a));
        return arrayList;
    }

    private j2 u() {
        return j2.a().d("Terms Flow").a(R.drawable.applovin_ic_x_mark).b(i0.a(R.color.applovin_sdk_xmarkColor, this.f5532a)).b("Terms Flow has been replaced").a(this.f5087e.v().g()).a(true).a();
    }

    private void y() {
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + z6.c(this.f5087e));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nTest Mode - ");
        sb2.append(this.f5087e.l0().c() ? "enabled" : "disabled");
        sb.append(sb2.toString());
        sb.append("\nTarget SDK - " + this.f5087e.y().C().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f5087e.a(l4.f5761v3);
        String strB = h.b();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nPlugin Version - ");
        if (!StringUtils.isValidString(str2)) {
            str2 = "None";
        }
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nAd Review Version - ");
        if (!StringUtils.isValidString(strB)) {
            strB = "Disabled";
        }
        sb4.append(strB);
        sb.append(sb4.toString());
        if (this.f5087e.A0()) {
            String strA = z6.a(this.f5087e.g0());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nUnity Version - ");
            sb5.append(StringUtils.isValidString(strA) ? strA : "None");
            sb.append(sb5.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(l0.a(this.f5532a));
        sb.append(this.f5087e.v().e());
        sb.append("\n========== CMP (CONSENT MANAGEMENT PLATFORM) ==========");
        sb.append(this.f5087e.k0().j());
        sb.append("\n========== NETWORK CONSENT STATUSES ==========");
        Iterator it = this.f5087e.k0().i().iterator();
        while (it.hasNext()) {
            sb.append(((n6) it.next()).e());
        }
        sb.append("\n========== NETWORKS ==========");
        Iterator it2 = this.f5100r.iterator();
        while (it2.hasNext()) {
            a(sb, ((v2) it2.next()).j());
        }
        Iterator it3 = this.f5101s.iterator();
        while (it3.hasNext()) {
            a(sb, ((v2) it3.next()).j());
        }
        Iterator it4 = this.f5099q.iterator();
        while (it4.hasNext()) {
            a(sb, ((v2) it4.next()).j());
        }
        sb.append("\n========== AD UNITS ==========");
        Iterator it5 = this.f5088f.iterator();
        while (it5.hasNext()) {
            a(sb, ((l) it5.next()).e());
        }
        sb.append("\n========== END ==========");
        com.applovin.impl.sdk.n.g("MediationDebuggerListAdapter", sb.toString());
        this.f5096n.append(sb.toString());
    }

    public boolean a(j2 j2Var) {
        if (j2Var.k() == null) {
            return false;
        }
        return "MAX Terms and Privacy Policy Flow".equals(j2Var.k().toString());
    }

    public void b(boolean z10) {
        this.f5098p = z10;
    }

    @Override // com.applovin.impl.k2
    protected List c(int i10) {
        return i10 == e.APP_INFO.ordinal() ? this.f5106x : i10 == e.MAX.ordinal() ? this.f5107y : i10 == e.PRIVACY.ordinal() ? this.f5108z : i10 == e.ADS.ordinal() ? this.A : i10 == e.INCOMPLETE_NETWORKS.ordinal() ? this.B : i10 == e.MICRO_SDK_PARTNER_NETWORKS.ordinal() ? this.C : i10 == e.COMPLETED_NETWORKS.ordinal() ? this.D : this.E;
    }

    public boolean d() {
        return this.f5098p;
    }

    @Override // com.applovin.impl.k2
    protected j2 e(int i10) {
        return i10 == e.APP_INFO.ordinal() ? new j4("APP INFO") : i10 == e.MAX.ordinal() ? new j4("MAX") : i10 == e.PRIVACY.ordinal() ? new j4("PRIVACY") : i10 == e.ADS.ordinal() ? new j4("ADS") : i10 == e.INCOMPLETE_NETWORKS.ordinal() ? new j4("INCOMPLETE SDK INTEGRATIONS") : i10 == e.MICRO_SDK_PARTNER_NETWORKS.ordinal() ? new j4("APPLOVIN MICRO SDK PARTNERS") : i10 == e.COMPLETED_NETWORKS.ordinal() ? new j4("COMPLETED SDK INTEGRATIONS") : new j4("MISSING SDK INTEGRATIONS");
    }

    public List f() {
        return this.f5088f;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public String h() {
        return this.f5092j;
    }

    public String i() {
        return this.f5091i;
    }

    public List k() {
        return this.f5103u;
    }

    public List o() {
        return this.f5089g;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f5108z = s();
            c();
            return;
        }
        if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.B = a(this.f5099q);
            this.C = a(this.f5100r);
            this.D = a(this.f5101s);
            c();
            return;
        }
        if ("live_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = a(a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("live_networks"), true), (String) null);
            c();
        } else if ("test_mode_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = a((String) null, a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("test_mode_networks"), false));
            c();
        }
    }

    public String p() {
        return this.f5096n.toString();
    }

    public com.applovin.impl.sdk.j t() {
        return this.f5087e;
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f5097o.get() + "}";
    }

    public List v() {
        return this.f5105w;
    }

    public List w() {
        return this.f5104v;
    }

    public boolean x() {
        return this.f5097o.get();
    }

    @Override // com.applovin.impl.k2
    protected int b() {
        return e.COUNT.ordinal();
    }

    @Override // com.applovin.impl.k2
    protected int d(int i10) {
        return i10 == e.APP_INFO.ordinal() ? this.f5106x.size() : i10 == e.MAX.ordinal() ? this.f5107y.size() : i10 == e.PRIVACY.ordinal() ? this.f5108z.size() : i10 == e.ADS.ordinal() ? this.A.size() : i10 == e.INCOMPLETE_NETWORKS.ordinal() ? this.B.size() : i10 == e.MICRO_SDK_PARTNER_NETWORKS.ordinal() ? this.C.size() : i10 == e.COMPLETED_NETWORKS.ordinal() ? this.D.size() : this.E.size();
    }

    private void b(List list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m mVarF = ((l) it.next()).f();
            Iterator it2 = mVarF.a().iterator();
            while (it2.hasNext()) {
                hashSet.add(((u7) it2.next()).b());
            }
            Iterator it3 = mVarF.e().iterator();
            while (it3.hasNext()) {
                hashSet2.add(((u7) it3.next()).b());
            }
        }
        this.f5103u = new ArrayList(hashSet);
        this.f5104v = new ArrayList(hashSet2);
        Collections.sort(this.f5103u);
        Collections.sort(this.f5104v);
    }

    public void a(List list, List list2, List list3, List list4, String str, String str2, String str3, Boolean bool, boolean z10, com.applovin.impl.sdk.j jVar) {
        this.f5087e = jVar;
        this.f5088f = list2;
        this.f5089g = list3;
        this.f5090h = list4;
        this.f5091i = str;
        this.f5092j = str2;
        this.f5093k = str3;
        this.f5094l = bool;
        this.f5095m = z10;
        if (list != null && this.f5097o.compareAndSet(false, true)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("MediationDebuggerListAdapter", "Populating networks...");
            }
            jVar.k0().a(list);
            c(list);
            b(list2);
            d(this.f5101s);
            this.f5106x.addAll(j());
            this.f5107y.addAll(q());
            this.f5108z.addAll(s());
            this.A.addAll(g());
            this.B = a(this.f5099q);
            this.C = a(this.f5100r);
            this.D = a(this.f5101s);
            this.E = a(this.f5102t);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_networks_updated");
            arrayList.add("test_mode_networks_updated");
            AppLovinCommunicator.getInstance(this.f5532a).subscribe(this, arrayList);
            y();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.h9
            @Override // java.lang.Runnable
            public final void run() {
                this.f5344a.notifyDataSetChanged();
            }
        });
    }

    private j2 b(String str, String str2) {
        j2.b bVarD = j2.a().d(str);
        if (StringUtils.isValidString(str2)) {
            bVarD.c(str2);
        } else {
            bVarD.a(R.drawable.applovin_ic_x_mark);
            bVarD.b(i0.a(R.color.applovin_sdk_xmarkColor, this.f5532a));
        }
        return bVarD.a();
    }

    private void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v2 v2Var = (v2) it.next();
            if (!v2Var.H()) {
                if (v2Var.q() != v2.a.INCOMPLETE_INTEGRATION && v2Var.q() != v2.a.INVALID_INTEGRATION) {
                    if (v2Var.q() == v2.a.COMPLETE) {
                        if (v2Var.z()) {
                            this.f5100r.add(v2Var);
                        } else {
                            this.f5101s.add(v2Var);
                        }
                    } else if (v2Var.q() == v2.a.MISSING) {
                        this.f5102t.add(v2Var);
                    }
                } else if (v2Var.z()) {
                    this.f5100r.add(v2Var);
                } else {
                    this.f5099q.add(v2Var);
                }
            }
        }
    }

    private j2 e() {
        String string;
        j2.b bVarD = j2.a().d("Ad Review Version");
        String strB = h.b();
        if (StringUtils.isValidString(strB)) {
            String strA = h.a();
            if (!StringUtils.isValidString(strA) || strA.equals(this.f5087e.b0())) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("MAX Ad Review integrated with wrong SDK key. Please check that your ");
                sb.append(this.f5087e.A0() ? "SDK key is downloaded" : "Gradle plugin snippet is integrated");
                sb.append(" from the correct account.");
                string = sb.toString();
            }
        } else {
            string = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps.";
        }
        if (string != null) {
            bVarD.b("MAX Ad Review").a(string).a(R.drawable.applovin_ic_x_mark).b(i0.a(R.color.applovin_sdk_xmarkColor, this.f5532a)).a(true);
        } else {
            bVarD.c(strB);
        }
        return bVarD.a();
    }

    private void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v2 v2Var = (v2) it.next();
            if (v2Var.y() == v2.b.READY) {
                this.f5105w.add(v2Var);
            }
        }
    }

    private j2 b(String str) {
        j2.b bVarA = j2.a();
        if (this.f5087e.l0().c()) {
            bVarA.a(this.f5532a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.isValidString(str) ? "" : "Select ");
        sb.append("Test Mode Network");
        j2.b bVarD = bVarA.d(sb.toString());
        if (!this.f5087e.l0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").a(true).a();
    }

    @Override // com.applovin.impl.a0.a
    public void a(y yVar, String str) {
        z zVar;
        String strA;
        c cVarA;
        c cVar;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (z zVar2 : this.f5090h) {
            List list = (List) yVar.a().get(zVar2.b());
            if (list == null || !list.contains(zVar2)) {
                this.f5087e.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5087e.I().b("MediationDebuggerListAdapter", str + " is missing a required entry: " + zVar2.d());
                }
                arrayList.add(zVar2);
            }
        }
        if (arrayList.isEmpty()) {
            str2 = "All required entries found at " + str + ".";
            cVar = c.SUCCESS;
        } else {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    zVar = (z) it.next();
                    if (zVar.g()) {
                        break;
                    }
                } else {
                    zVar = null;
                    break;
                }
            }
            if (zVar != null) {
                a0.b bVar = a0.b.MISSING_APPLOVIN_ENTRIES;
                strA = a(bVar, str, zVar.d());
                cVarA = a(bVar);
            } else {
                a0.b bVar2 = a0.b.MISSING_NON_APPLOVIN_ENTRIES;
                strA = a(bVar2, str, null);
                cVarA = a(bVar2);
            }
            String str3 = strA;
            cVar = cVarA;
            str2 = str3;
        }
        this.f5107y.add(a(str2, cVar));
        c();
    }

    @Override // com.applovin.impl.a0.a
    public void a(a0.b bVar, String str) {
        if (bVar == a0.b.APP_DETAILS_NOT_FOUND) {
            this.f5087e.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5087e.I().a("MediationDebuggerListAdapter", "Could not retrieve app details for this package name; app-ads.txt row will not show on the mediation debugger.");
                return;
            }
            return;
        }
        this.f5107y.add(a(a(bVar, str, null), a(bVar)));
        c();
    }

    private void a(StringBuilder sb, String str) {
        String string = sb.toString();
        if (string.length() + str.length() >= ((Integer) this.f5087e.a(l4.f5726r)).intValue()) {
            com.applovin.impl.sdk.n.g("MediationDebuggerListAdapter", string);
            this.f5096n.append(string);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private List a(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(j2.a().d("View Ad Units (" + this.f5088f.size() + ")").a(this.f5532a).a(true).a());
        arrayList.add(a(str));
        arrayList.add(b(str2));
        if (!this.f5089g.isEmpty()) {
            arrayList.add(j2.a().d("Selective Init Ad Units (" + this.f5089g.size() + ")").a(this.f5532a).a(true).a());
        }
        arrayList.add(j2.a().d("Test Mode Enabled").c(String.valueOf(this.f5087e.l0().c())).a());
        return arrayList;
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new o3((v2) it.next(), this.f5532a));
        }
        return arrayList;
    }

    private j2 a(String str) {
        j2.b bVarA = j2.a();
        if (!this.f5087e.l0().c()) {
            bVarA.a(this.f5532a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.isValidString(str) ? "" : "Select ");
        sb.append("Live Network");
        j2.b bVarD = bVarA.d(sb.toString());
        if (this.f5087e.l0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").a(true).a();
    }

    private j2 a(boolean z10) {
        return j2.a().d("Java 8").a(z10 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(i0.a(z10 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f5532a)).b("Upgrade to Java 8").a("For optimal performance, please enable Java 8 support. This will be required in a future SDK release. See: https://developers.applovin.com/en/android/overview/integration").a(!z10).a();
    }

    private j2 a(String str, c cVar) {
        int i10;
        int iA;
        if (cVar == c.SUCCESS) {
            i10 = R.drawable.applovin_ic_check_mark_bordered;
            iA = i0.a(R.color.applovin_sdk_checkmarkColor, this.f5532a);
        } else if (cVar == c.WARNING) {
            i10 = R.drawable.applovin_ic_warning;
            iA = i0.a(R.color.applovin_sdk_warningColor, this.f5532a);
        } else {
            i10 = R.drawable.applovin_ic_x_mark;
            iA = i0.a(R.color.applovin_sdk_xmarkColor, this.f5532a);
        }
        return j2.a().d("app-ads.txt").a(i10).b(iA).b("app-ads.txt").a(str).a(true).a();
    }

    private String a(a0.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "app-ads.txt URL";
        }
        int i10 = a.f5109a[bVar.ordinal()];
        if (i10 == 1) {
            return "Could not retrieve app details from the Play Store for this package name. Check back once this app has been published on the Play Store.";
        }
        if (i10 == 2) {
            return "Unable to find a valid developer URL from the Play Store listing.";
        }
        if (i10 == 3) {
            return "Unable to find app-ads.txt file or parse entries of the file at " + str + ".\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        if (i10 != 4) {
            if (i10 != 5) {
                return "";
            }
            return "Text file at " + str + " is missing some of the suggested lines.\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        return "Text file at " + str + " is missing the required AppLovin line:\n\n" + str2 + "\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
    }

    private c a(a0.b bVar) {
        int i10 = a.f5109a[bVar.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return c.ERROR;
        }
        if (i10 != 5) {
            return c.ERROR;
        }
        return c.WARNING;
    }

    private String a(List list, boolean z10) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (z10) {
            for (m2 m2Var : this.f5103u) {
                if (list.equals(m2Var.b())) {
                    return m2Var.a();
                }
            }
            for (m2 m2Var2 : this.f5104v) {
                if (list.equals(m2Var2.b())) {
                    return m2Var2.a();
                }
            }
        } else {
            for (v2 v2Var : this.f5105w) {
                if (list.equals(v2Var.u())) {
                    return v2Var.g();
                }
            }
        }
        return g9.a(",", list);
    }
}
