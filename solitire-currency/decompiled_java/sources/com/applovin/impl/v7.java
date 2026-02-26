package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.j2;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v7 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f7639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k2 f7640c;

    class a extends k2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f7641e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.f7641e = list;
        }

        @Override // com.applovin.impl.k2
        protected j2 a() {
            return new j2.b(j2.c.SECTION_CENTERED).d("A plus in front of each segment indicates inclusion and a minus indicates exclusion. The comma in comma-separated values functions as an ∨ (or) operator, and a new row functions as an ∧ (and) operator.").a();
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            return this.f7641e;
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            return this.f7641e.size();
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return new j4("SEGMENT TARGETING");
        }
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(j2.a(j2.c.DETAIL).d((String) it.next()).a());
        }
        return arrayList;
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f7639b;
    }

    public void initialize(String str, List<String> list, com.applovin.impl.sdk.j jVar) {
        this.f7638a = str;
        this.f7639b = jVar;
        a aVar = new a(this, a(list));
        this.f7640c = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f7638a);
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f7640c);
    }
}
