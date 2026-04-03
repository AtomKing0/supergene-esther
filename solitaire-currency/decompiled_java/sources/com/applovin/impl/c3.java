package com.applovin.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.d;
import com.applovin.impl.e3;
import com.applovin.impl.k2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.mediation.MaxDebuggerUnifiedFlowActivity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c3 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e3 f4938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f4939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f4940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ListView f4941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.applovin.impl.a f4942e;

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            c3.this.a();
            c3 c3Var = c3.this;
            c3Var.b((Context) c3Var);
        }
    }

    class b implements k2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.c f4944a;

        class a implements d.b {
            a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerUnifiedFlowActivity maxDebuggerUnifiedFlowActivity) {
                maxDebuggerUnifiedFlowActivity.initialize(c3.this.f4938a.t());
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.c3$b$b, reason: collision with other inner class name */
        class C0161b implements d.b {
            C0161b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                maxDebuggerTcfInfoListActivity.initialize(c3.this.f4938a.t());
            }
        }

        class c implements d.b {
            c() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                maxDebuggerTcfConsentStatusesListActivity.initialize(c3.this.f4938a.t());
            }
        }

        class d implements d.b {
            d() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(c3.this.f4938a.f(), false, c3.this.f4938a.t());
            }
        }

        class e implements d.b {
            e() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                maxDebuggerTestLiveNetworkActivity.initialize(c3.this.f4938a.k(), c3.this.f4938a.w(), c3.this.f4938a.t());
            }
        }

        class f implements d.b {
            f() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                maxDebuggerTestModeNetworkActivity.initialize(c3.this.f4938a.v(), c3.this.f4938a.t());
            }
        }

        class g implements d.b {
            g() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(c3.this.f4938a.o(), true, c3.this.f4938a.t());
            }
        }

        class h implements d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j2 f4953a;

            h(j2 j2Var) {
                this.f4953a = j2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                maxDebuggerDetailActivity.initialize(((o3) this.f4953a).r());
            }
        }

        b(com.applovin.impl.c cVar) {
            this.f4944a = cVar;
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            int iB = d2Var.b();
            if (iB == e3.e.APP_INFO.ordinal()) {
                z6.a(j2Var.c(), j2Var.b(), c3.this);
                return;
            }
            if (iB == e3.e.MAX.ordinal()) {
                if (c3.this.f4938a.a(j2Var)) {
                    com.applovin.impl.d.a(c3.this, MaxDebuggerUnifiedFlowActivity.class, this.f4944a, new a());
                    return;
                } else {
                    z6.a(j2Var.c(), j2Var.b(), c3.this);
                    return;
                }
            }
            if (iB == e3.e.PRIVACY.ordinal()) {
                if (d2Var.a() != e3.d.CMP.ordinal()) {
                    if (d2Var.a() == e3.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        com.applovin.impl.d.a(c3.this, MaxDebuggerTcfConsentStatusesListActivity.class, this.f4944a, new c());
                        return;
                    }
                    return;
                } else if (StringUtils.isValidString(c3.this.f4938a.t().k0().k())) {
                    com.applovin.impl.d.a(c3.this, MaxDebuggerTcfInfoListActivity.class, this.f4944a, new C0161b());
                    return;
                } else {
                    z6.a(j2Var.c(), j2Var.b(), c3.this);
                    return;
                }
            }
            if (iB != e3.e.ADS.ordinal()) {
                if ((iB == e3.e.MICRO_SDK_PARTNER_NETWORKS.ordinal() || iB == e3.e.INCOMPLETE_NETWORKS.ordinal() || iB == e3.e.COMPLETED_NETWORKS.ordinal()) && (j2Var instanceof o3)) {
                    com.applovin.impl.d.a(c3.this, MaxDebuggerDetailActivity.class, this.f4944a, new h(j2Var));
                    return;
                }
                return;
            }
            if (d2Var.a() == e3.b.AD_UNITS.ordinal()) {
                if (c3.this.f4938a.f().size() > 0) {
                    com.applovin.impl.d.a(c3.this, MaxDebuggerAdUnitsListActivity.class, this.f4944a, new d());
                    return;
                } else {
                    z6.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", c3.this);
                    return;
                }
            }
            if (d2Var.a() == e3.b.SELECT_LIVE_NETWORKS.ordinal()) {
                if (c3.this.f4938a.k().size() <= 0 && c3.this.f4938a.w().size() <= 0) {
                    z6.a("Complete Integrations", "Please complete integrations in order to access this.", c3.this);
                    return;
                } else if (c3.this.f4938a.t().l0().c()) {
                    z6.a("Restart Required", j2Var.b(), c3.this);
                    return;
                } else {
                    com.applovin.impl.d.a(c3.this, MaxDebuggerTestLiveNetworkActivity.class, this.f4944a, new e());
                    return;
                }
            }
            if (d2Var.a() != e3.b.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                if (d2Var.a() == e3.b.INITIALIZATION_AD_UNITS.ordinal()) {
                    com.applovin.impl.d.a(c3.this, MaxDebuggerAdUnitsListActivity.class, this.f4944a, new g());
                }
            } else if (!c3.this.f4938a.t().l0().c()) {
                c3.this.getSdk().l0().a();
                z6.a("Restart Required", j2Var.b(), c3.this);
            } else if (c3.this.f4938a.v().size() > 0) {
                com.applovin.impl.d.a(c3.this, MaxDebuggerTestModeNetworkActivity.class, this.f4944a, new f());
            } else {
                z6.a("Complete Integrations", "Please complete integrations in order to access this.", c3.this);
            }
        }
    }

    private void c() {
        a();
        com.applovin.impl.a aVar = new com.applovin.impl.a(this, 50, R.attr.progressBarStyleLarge);
        this.f4942e = aVar;
        aVar.setColor(-3355444);
        this.f4940c.addView(this.f4942e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f4940c.bringChildToFront(this.f4942e);
        this.f4942e.a();
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        e3 e3Var = this.f4938a;
        if (e3Var != null) {
            return e3Var.t();
        }
        return null;
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(com.applovin.sdk.R.layout.mediation_debugger_list_view);
        this.f4940c = (FrameLayout) findViewById(R.id.content);
        ListView listView = (ListView) findViewById(com.applovin.sdk.R.id.listView);
        this.f4941d = listView;
        listView.setAdapter((ListAdapter) this.f4938a);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.applovin.sdk.R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        e3 e3Var = this.f4938a;
        if (e3Var != null) {
            e3Var.unregisterDataSetObserver(this.f4939b);
            this.f4938a.a((k2.a) null);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.applovin.sdk.R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        e3 e3Var = this.f4938a;
        if (e3Var == null || e3Var.x()) {
            return;
        }
        c();
    }

    public void setListAdapter(e3 e3Var, c cVar) {
        DataSetObserver dataSetObserver;
        e3 e3Var2 = this.f4938a;
        if (e3Var2 != null && (dataSetObserver = this.f4939b) != null) {
            e3Var2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f4938a = e3Var;
        this.f4939b = new a();
        b((Context) this);
        this.f4938a.registerDataSetObserver(this.f4939b);
        this.f4938a.a(new b(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.applovin.impl.a aVar = this.f4942e;
        if (aVar != null) {
            aVar.b();
            this.f4940c.removeView(this.f4942e);
            this.f4942e = null;
        }
    }

    private void b() {
        String strP = this.f4938a.p();
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", strP);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        z6.a(this.f4938a.i(), this.f4938a.h(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context) {
        if (!StringUtils.isValidString(this.f4938a.h()) || this.f4938a.d()) {
            return;
        }
        this.f4938a.b(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.v8
            @Override // java.lang.Runnable
            public final void run() {
                this.f7643a.a(context);
            }
        });
    }
}
