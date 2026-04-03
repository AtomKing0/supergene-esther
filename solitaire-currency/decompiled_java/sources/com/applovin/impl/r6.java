package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.j2;
import com.applovin.impl.k2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r6 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f6759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f6760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k2 f6761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f6762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ListView f6763e;

    class a extends k2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f6764e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.f6764e = list;
        }

        @Override // com.applovin.impl.k2
        protected j2 a() {
            return new j2.b(j2.c.SECTION_CENTERED).d("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            return r6.this.f6762d;
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return this.f6764e.size();
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return new j4("TEST MODE NETWORKS");
        }
    }

    class b implements k2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f6766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f6767b;

        b(List list, com.applovin.impl.sdk.j jVar) {
            this.f6766a = list;
            this.f6767b = jVar;
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            List listU = ((v2) this.f6766a.get(d2Var.a())).u();
            if (listU.equals(this.f6767b.l0().b())) {
                this.f6767b.l0().a((List) null);
            } else {
                this.f6767b.l0().a(listU);
            }
            r6.this.f6761c.notifyDataSetChanged();
        }
    }

    class c extends o3 {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ v2 f6769p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(v2 v2Var, Context context, v2 v2Var2) {
            super(v2Var, context);
            this.f6769p = v2Var2;
        }

        @Override // com.applovin.impl.o3, com.applovin.impl.j2
        public int d() {
            if (this.f6769p.u().equals(r6.this.f6759a.l0().b())) {
                return R.drawable.applovin_ic_check_mark_borderless;
            }
            return 0;
        }

        @Override // com.applovin.impl.o3, com.applovin.impl.j2
        public int e() {
            if (this.f6769p.u().equals(r6.this.f6759a.l0().b())) {
                return -16776961;
            }
            return super.e();
        }

        @Override // com.applovin.impl.j2
        public SpannedString k() {
            return StringUtils.createSpannedString(this.f6769p.g(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
        }
    }

    public r6() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f6759a;
    }

    public void initialize(List<v2> list, com.applovin.impl.sdk.j jVar) {
        this.f6759a = jVar;
        this.f6760b = list;
        this.f6762d = a(list);
        a aVar = new a(this, list);
        this.f6761c = aVar;
        aVar.a(new b(list, jVar));
        this.f6761c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f6763e = listView;
        listView.setAdapter((ListAdapter) this.f6761c);
    }

    @Override // com.applovin.impl.d3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f6762d = a(this.f6760b);
        this.f6761c.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v2 v2Var = (v2) it.next();
            arrayList.add(new c(v2Var, this, v2Var));
        }
        return arrayList;
    }
}
