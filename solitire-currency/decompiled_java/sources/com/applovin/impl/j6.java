package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.n6;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j6 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f5484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k2 f5485b;

    class a extends k2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f5487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f5488g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, ArrayList arrayList, ArrayList arrayList2, boolean z10) {
            super(context);
            this.f5486e = arrayList;
            this.f5487f = arrayList2;
            this.f5488g = z10;
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return b.values().length;
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            return i10 == b.TC_NETWORKS.ordinal() ? this.f5486e : this.f5487f;
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return i10 == b.TC_NETWORKS.ordinal() ? this.f5486e.size() : this.f5487f.size();
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            if (i10 == b.TC_NETWORKS.ordinal()) {
                return new j4("TCF VENDORS (TC STRING)");
            }
            return new j4(this.f5488g ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
        }
    }

    private enum b {
        TC_NETWORKS,
        AC_NETWORKS
    }

    private j2 a(String str, String str2) {
        return j2.a().d(str).c(str2).a();
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f5484a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f5484a = jVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strA = l0.b().a(this);
        boolean zB = jVar.k0().b();
        if (!zB) {
            arrayList2.add(a("Has User Consent", strA));
        }
        for (n6 n6Var : jVar.k0().i()) {
            Boolean boolA = n6Var.a();
            if (boolA != null) {
                if (n6Var.f() == n6.a.TCF_VENDOR) {
                    arrayList.add(a(n6Var.b(), String.valueOf(boolA)));
                } else if (n6Var.f() == n6.a.ATP_NETWORK) {
                    arrayList2.add(a(n6Var.b(), String.valueOf(boolA)));
                }
            } else if (zB && n6Var.f() == n6.a.ATP_NETWORK) {
                arrayList2.add(a(n6Var.b(), strA));
            }
        }
        a aVar = new a(this, arrayList, arrayList2, zB);
        this.f5485b = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f5485b);
    }
}
