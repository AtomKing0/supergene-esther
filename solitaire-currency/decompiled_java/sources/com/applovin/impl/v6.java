package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.j2;
import com.applovin.impl.k2;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v6 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f7623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k2 f7624b;

    class a extends k2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return d.values().length;
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            return i10 == d.SETTINGS.ordinal() ? v6.this.c() : v6.this.a();
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return i10 == d.SETTINGS.ordinal() ? e.values().length : c.values().length;
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return i10 == d.SETTINGS.ordinal() ? new j4("SETTINGS") : new j4("GDPR APPLICABILITY");
        }
    }

    class b implements k2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f7626a;

        b(com.applovin.impl.sdk.j jVar) {
            this.f7626a = jVar;
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            if (d2Var.b() == d.SETTINGS.ordinal()) {
                if (d2Var.a() == e.PRIVACY_POLICY_URL.ordinal()) {
                    if (this.f7626a.v().f() != null) {
                        w6.a(this.f7626a.v().f(), com.applovin.impl.sdk.j.n(), this.f7626a);
                        return;
                    } else {
                        z6.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", v6.this);
                        return;
                    }
                }
                if (d2Var.a() != e.TERMS_OF_SERVICE_URL.ordinal() || this.f7626a.v().h() == null) {
                    return;
                }
                w6.a(this.f7626a.v().h(), com.applovin.impl.sdk.j.n(), this.f7626a);
            }
        }
    }

    private enum c {
        DESCRIPTION,
        CONSENT_FLOW_GEOGRAPHY,
        DEBUG_USER_GEOGRAPHY
    }

    private enum d {
        SETTINGS,
        GDPR_APPLICABILITY
    }

    private enum e {
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(e.values().length);
        arrayList.add(b());
        arrayList.add(d());
        return arrayList;
    }

    private j2 d() {
        j2.b bVarD = j2.a().d("Terms of Service URL");
        if (this.f7623a.v().h() != null) {
            bVarD.a(R.drawable.applovin_ic_check_mark_bordered);
            bVarD.b(i0.a(R.color.applovin_sdk_checkmarkColor, this));
            bVarD.a(true);
        } else {
            bVarD.c("None");
            bVarD.a(false);
        }
        return bVarD.a();
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f7623a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f7623a = jVar;
        a aVar = new a(this);
        this.f7624b = aVar;
        aVar.a(new b(jVar));
        this.f7624b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("MAX Terms and Privacy Policy Flow");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f7624b);
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k2 k2Var = this.f7624b;
        if (k2Var != null) {
            k2Var.a((k2.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        ArrayList arrayList = new ArrayList(c.values().length);
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f7623a.t().getConsentFlowUserGeography();
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyD = this.f7623a.v().d();
        boolean z10 = z6.c(this.f7623a) && consentFlowUserGeographyD != AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
        arrayList.add(j2.a().d("AppLovin determines whether the user is located in a GDPR region. If the user is in a GDPR region, the MAX SDK presents Google UMP.\n\nYou can test the flow on debug mode by overriding the region check by setting the debug user geography.").a());
        arrayList.add(a(consentFlowUserGeography, !z10));
        arrayList.add(b(consentFlowUserGeographyD, z10));
        return arrayList;
    }

    private j2 b() {
        boolean z10 = this.f7623a.v().f() != null;
        return j2.a().d("Privacy Policy URL").a(z10 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(i0.a(z10 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this)).a(true).a();
    }

    private j2 a(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z10) {
        return j2.a().d("Consent Flow Geography").c(consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "Unknown").b(z10).a();
    }

    private j2 b(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z10) {
        return j2.a().d("Debug User Geography").c(consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "None").b(z10).a();
    }
}
