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
public abstract class q6 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f6691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f6692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f6693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k2 f6694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f6695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f6696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ListView f6697g;

    class a extends k2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.k2
        protected j2 a() {
            return new j2.b(j2.c.SECTION_CENTERED).d("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return c.COUNT.ordinal();
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            return i10 == c.BIDDERS.ordinal() ? q6.this.f6695e : q6.this.f6696f;
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return i10 == c.BIDDERS.ordinal() ? q6.this.f6695e.size() : q6.this.f6696f.size();
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return i10 == c.BIDDERS.ordinal() ? new j4("BIDDERS") : new j4("WATERFALL");
        }
    }

    class b extends o3 {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ m2 f6699p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(v2 v2Var, Context context, m2 m2Var) {
            super(v2Var, context);
            this.f6699p = m2Var;
        }

        @Override // com.applovin.impl.o3, com.applovin.impl.j2
        public int d() {
            if (q6.this.f6691a.l0().b() == null || !q6.this.f6691a.l0().b().equals(this.f6699p.b())) {
                return 0;
            }
            return R.drawable.applovin_ic_check_mark_borderless;
        }

        @Override // com.applovin.impl.o3, com.applovin.impl.j2
        public int e() {
            if (q6.this.f6691a.l0().b() == null || !q6.this.f6691a.l0().b().equals(this.f6699p.b())) {
                return super.e();
            }
            return -16776961;
        }

        @Override // com.applovin.impl.j2
        public SpannedString k() {
            return StringUtils.createSpannedString(this.f6699p.a(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
        }
    }

    enum c {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public q6() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f6691a;
    }

    public void initialize(List<m2> list, List<m2> list2, final com.applovin.impl.sdk.j jVar) {
        this.f6691a = jVar;
        this.f6692b = list;
        this.f6693c = list2;
        this.f6695e = a(list);
        this.f6696f = a(list2);
        a aVar = new a(this);
        this.f6694d = aVar;
        aVar.a(new k2.a() { // from class: com.applovin.impl.zc
            @Override // com.applovin.impl.k2.a
            public final void a(d2 d2Var, j2 j2Var) {
                this.f7931a.a(jVar, d2Var, j2Var);
            }
        });
        this.f6694d.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f6697g = listView;
        listView.setAdapter((ListAdapter) this.f6694d);
    }

    @Override // com.applovin.impl.d3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f6695e = a(this.f6692b);
        this.f6696f = a(this.f6693c);
        this.f6694d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.j jVar, d2 d2Var, j2 j2Var) {
        List listB = a(d2Var).b();
        if (listB.equals(jVar.l0().b())) {
            jVar.l0().a((List) null);
        } else {
            jVar.l0().a(listB);
        }
        this.f6694d.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m2 m2Var = (m2) it.next();
            arrayList.add(new b(m2Var.d(), this, m2Var));
        }
        return arrayList;
    }

    private m2 a(d2 d2Var) {
        if (d2Var.b() == c.BIDDERS.ordinal()) {
            return (m2) this.f6692b.get(d2Var.a());
        }
        return (m2) this.f6693c.get(d2Var.a());
    }
}
