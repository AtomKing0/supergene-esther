package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.d;
import com.applovin.impl.j2;
import com.applovin.impl.k2;
import com.applovin.impl.n6;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l6 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f5795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k2 f5796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f5797c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f5798d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f5799e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f5800f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f5801g = new ArrayList();

    class a extends k2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return e.values().length;
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            return i10 == e.IAB_TCF_PARAMETERS.ordinal() ? l6.this.c() : l6.this.a();
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return i10 == e.IAB_TCF_PARAMETERS.ordinal() ? d.values().length : c.values().length;
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return i10 == e.IAB_TCF_PARAMETERS.ordinal() ? new j4("IAB TCF Parameters") : new j4("CMP CONFIGURATION");
        }
    }

    class b implements k2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m6 f5803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f5804b;

        class a implements d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5806a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f5807b;

            a(String str, String str2) {
                this.f5806a = str;
                this.f5807b = str2;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                maxDebuggerTcfStringActivity.initialize(this.f5806a, this.f5807b, b.this.f5804b);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.l6$b$b, reason: collision with other inner class name */
        class C0163b implements d.b {
            C0163b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                maxDebuggerCmpNetworksListActivity.initialize(l6.this.f5799e, l6.this.f5800f, l6.this.f5797c, l6.this.f5798d, l6.this.f5801g, b.this.f5804b);
            }
        }

        b(m6 m6Var, com.applovin.impl.sdk.j jVar) {
            this.f5803a = m6Var;
            this.f5804b = jVar;
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            String strA;
            String strC;
            if (d2Var.b() != e.IAB_TCF_PARAMETERS.ordinal()) {
                if (d2Var.a() == c.CONFIGURED_NETWORKS.ordinal()) {
                    com.applovin.impl.d.a(l6.this, MaxDebuggerCmpNetworksListActivity.class, this.f5804b.e(), new C0163b());
                    return;
                } else {
                    z6.a(j2Var.c(), j2Var.b(), l6.this);
                    return;
                }
            }
            if (d2Var.a() == d.TC_STRING.ordinal()) {
                strA = n4.f6397s.a();
                strC = this.f5803a.k();
            } else {
                strA = n4.f6398t.a();
                strC = this.f5803a.c();
            }
            com.applovin.impl.d.a(l6.this, MaxDebuggerTcfStringActivity.class, this.f5804b.e(), new a(strA, strC));
        }
    }

    private enum c {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        CONFIGURED_NETWORKS
    }

    private enum d {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    private enum e {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f5795a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f5795a = jVar;
        m6 m6VarK0 = jVar.k0();
        a(m6VarK0.i());
        a aVar = new a(this);
        this.f5796b = aVar;
        aVar.a(new b(m6VarK0, jVar));
        this.f5796b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f5796b);
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k2 k2Var = this.f5796b;
        if (k2Var != null) {
            k2Var.a((k2.a) null);
        }
    }

    private void a(List list) {
        boolean zB = this.f5795a.k0().b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n6 n6Var = (n6) it.next();
            if (n6Var.f() == n6.a.TCF_VENDOR) {
                if (Boolean.TRUE.equals(n6Var.a())) {
                    a(n6Var, this.f5797c);
                } else {
                    a(n6Var, this.f5799e);
                }
            } else if (n6Var.f() != n6.a.ATP_NETWORK) {
                this.f5801g.add(n6Var);
            } else if (!zB) {
                this.f5801g.add(n6Var);
            } else if (Boolean.TRUE.equals(n6Var.a())) {
                a(n6Var, this.f5798d);
            } else {
                a(n6Var, this.f5800f);
            }
        }
    }

    private j2 b() {
        j2.b bVarA;
        String strA = n4.f6394p.a();
        Integer numE = this.f5795a.k0().e();
        if (StringUtils.isValidString(this.f5795a.k0().d())) {
            bVarA = j2.a(j2.c.RIGHT_DETAIL);
        } else {
            j2.b bVarB = j2.a(j2.c.DETAIL).b("Unknown CMP SDK ID");
            bVarA = bVarB.a("Your integrated CMP might not be Google-certified. " + ("SharedPreferences value for key " + strA + " is " + numE + ".") + "\n\nIf you use Google AdMob or Google Ad Manager, make sure that the integrated CMP is included in the list of Google-certified CMPs at: https://support.google.com/admob/answer/13554116").a(R.drawable.applovin_ic_warning).b(i0.a(R.color.applovin_sdk_warningColor, this)).a(true);
        }
        bVarA.d(strA);
        bVarA.c(numE != null ? numE.toString() : "No value set");
        bVarA.c(numE != null ? ViewCompat.MEASURED_STATE_MASK : SupportMenu.CATEGORY_MASK);
        return bVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(d.values().length);
        Integer numG = this.f5795a.k0().g();
        String strK = this.f5795a.k0().k();
        String strC = this.f5795a.k0().c();
        arrayList.add(a(n4.f6396r.a(), numG));
        arrayList.add(a(n4.f6397s.a(), strK, !p6.b(strK)));
        arrayList.add(a(n4.f6398t.a(), strC, false));
        return arrayList;
    }

    private void a(n6 n6Var, List list) {
        if (n6Var.d() != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (n6Var.d().equals(((n6) it.next()).d())) {
                    return;
                }
            }
        }
        list.add(n6Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        String str;
        ArrayList arrayList = new ArrayList(c.values().length);
        int size = this.f5799e.size() + this.f5800f.size();
        arrayList.add(b());
        arrayList.add(a(n4.f6395q.a(), this.f5795a.k0().f()));
        arrayList.add(j2.a(j2.c.DETAIL).d("To check which networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").a());
        j2.b bVarD = j2.a(j2.c.RIGHT_DETAIL).d("Configured CMP Networks");
        if (size > 0) {
            str = "Missing " + size + " network(s)";
        } else {
            str = "";
        }
        arrayList.add(bVarD.c(str).c(size > 0 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).a(this).a(true).a());
        return arrayList;
    }

    private j2 a(String str, Integer num) {
        return j2.a(j2.c.RIGHT_DETAIL).d(str).c(num != null ? num.toString() : "No value set").c(num != null ? ViewCompat.MEASURED_STATE_MASK : SupportMenu.CATEGORY_MASK).a();
    }

    private j2 a(String str, String str2, boolean z10) {
        boolean zIsValidString = StringUtils.isValidString(str2);
        if (zIsValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + "...";
        }
        j2.b bVarD = j2.a(j2.c.DETAIL).d(str);
        if (!zIsValidString) {
            str2 = "No value set";
        }
        j2.b bVarA = bVarD.c(str2).c(z10 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).a(zIsValidString);
        if (zIsValidString) {
            bVarA.a(this);
        }
        return bVarA.a();
    }
}
