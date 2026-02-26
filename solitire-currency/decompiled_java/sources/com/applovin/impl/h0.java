package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.j2;
import com.applovin.impl.k2;
import com.applovin.impl.n6;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f5297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k2 f5298b;

    class a extends k2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f5299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f5300f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f5301g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f5302h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f5303i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list, List list2, List list3, List list4, List list5) {
            super(context);
            this.f5299e = list;
            this.f5300f = list2;
            this.f5301g = list3;
            this.f5302h = list4;
            this.f5303i = list5;
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return c.values().length;
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            List list;
            boolean z10 = true;
            if (i10 == c.MISSING_TC_NETWORKS.ordinal()) {
                list = this.f5299e;
            } else if (i10 == c.MISSING_AC_NETWORKS.ordinal()) {
                list = this.f5300f;
            } else {
                z10 = false;
                list = i10 == c.LISTED_TC_NETWORKS.ordinal() ? this.f5301g : i10 == c.LISTED_AC_NETWORKS.ordinal() ? this.f5302h : this.f5303i;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(h0.this.a((n6) it.next(), z10));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return i10 == c.MISSING_TC_NETWORKS.ordinal() ? this.f5299e.size() : i10 == c.MISSING_AC_NETWORKS.ordinal() ? this.f5300f.size() : i10 == c.LISTED_TC_NETWORKS.ordinal() ? this.f5301g.size() : i10 == c.LISTED_AC_NETWORKS.ordinal() ? this.f5302h.size() : this.f5303i.size();
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return i10 == c.MISSING_TC_NETWORKS.ordinal() ? new j4("MISSING TCF VENDORS (TC STRING)") : i10 == c.MISSING_AC_NETWORKS.ordinal() ? new j4("MISSING ATP NETWORKS (AC STRING)") : i10 == c.LISTED_TC_NETWORKS.ordinal() ? new j4("LISTED TCF VENDORS (TC STRING)") : i10 == c.LISTED_AC_NETWORKS.ordinal() ? new j4("LISTED ATP NETWORKS (AC STRING)") : new j4("NON-CONFIGURABLE NETWORKS");
        }
    }

    class b implements k2.a {
        b() {
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            z6.a(j2Var.c(), j2Var.b(), h0.this);
        }
    }

    private enum c {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f5297a;
    }

    public void initialize(List<n6> list, List<n6> list2, List<n6> list3, List<n6> list4, List<n6> list5, com.applovin.impl.sdk.j jVar) {
        this.f5297a = jVar;
        a aVar = new a(this, list, list2, list3, list4, list5);
        this.f5298b = aVar;
        aVar.a(new b());
        this.f5298b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f5298b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j2 a(n6 n6Var, boolean z10) {
        j2.b bVarA = j2.a();
        boolean zB = this.f5297a.k0().b();
        n6.a aVarF = n6Var.f();
        n6.a aVar = n6.a.TCF_VENDOR;
        if (aVarF == aVar || (n6Var.f() == n6.a.ATP_NETWORK && zB)) {
            String strC = n6Var.c();
            String str = n6Var.f() == aVar ? "IAB Vendor ID: " : "Google ATP ID: ";
            bVarA.d(strC).d(z10 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).b(strC).a(str + n6Var.d()).a(true);
        } else {
            bVarA.d(n6Var.b());
        }
        return bVarA.a();
    }
}
