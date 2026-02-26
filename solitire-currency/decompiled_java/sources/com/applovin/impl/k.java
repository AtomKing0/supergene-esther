package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class k extends k2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final l f5508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f5509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u7 f5510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f5512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f5513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f5514k;

    enum a {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    class b extends o3 {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final u7 f5520p;

        b(u7 u7Var, String str, boolean z10) {
            super(u7Var.b().d(), k.this.f5532a);
            this.f5520p = u7Var;
            this.f5439c = StringUtils.createSpannedString(u7Var.b().a(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.f5440d = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f5438b = z10;
        }

        @Override // com.applovin.impl.j2
        public int g() {
            return -12303292;
        }

        @Override // com.applovin.impl.o3, com.applovin.impl.j2
        public boolean o() {
            return this.f5438b;
        }

        public u7 v() {
            return this.f5520p;
        }
    }

    k(l lVar, m mVar, u7 u7Var, Context context) {
        super(context);
        this.f5508e = lVar;
        this.f5510g = u7Var;
        this.f5509f = mVar != null ? mVar : lVar.f();
        this.f5511h = mVar != null ? mVar.c() : lVar.d();
        this.f5512i = h();
        this.f5513j = e();
        this.f5514k = l();
        notifyDataSetChanged();
    }

    private j2 f() {
        return j2.a().d("AB Test Experiment Name").c(j().b()).a();
    }

    private j2 g() {
        return j2.a().d("ID").c(this.f5508e.c()).a();
    }

    private List h() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(g());
        arrayList.add(d());
        if (this.f5509f.b() != null) {
            arrayList.add(f());
        }
        if (this.f5510g != null) {
            arrayList.add(i());
        }
        return arrayList;
    }

    private j2 i() {
        return j2.a().d("Selected Network").c(this.f5510g.b().a()).a();
    }

    private List l() {
        u7 u7Var = this.f5510g;
        if (u7Var != null && u7Var.d()) {
            return new ArrayList();
        }
        List<u7> listE = this.f5509f.e();
        ArrayList arrayList = new ArrayList(listE.size());
        for (u7 u7Var2 : listE) {
            u7 u7Var3 = this.f5510g;
            if (u7Var3 == null || u7Var3.b().c().equals(u7Var2.b().c())) {
                arrayList.add(new b(u7Var2, null, this.f5510g == null));
                for (p3 p3Var : u7Var2.c()) {
                    arrayList.add(j2.a().d(p3Var.a()).c(p3Var.b()).b(true).a());
                }
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.k2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.k2
    protected List c(int i10) {
        return i10 == a.INFO.ordinal() ? this.f5512i : i10 == a.BIDDERS.ordinal() ? this.f5513j : this.f5514k;
    }

    @Override // com.applovin.impl.k2
    protected int d(int i10) {
        return i10 == a.INFO.ordinal() ? this.f5512i.size() : i10 == a.BIDDERS.ordinal() ? this.f5513j.size() : this.f5514k.size();
    }

    @Override // com.applovin.impl.k2
    protected j2 e(int i10) {
        return i10 == a.INFO.ordinal() ? new j4("INFO") : i10 == a.BIDDERS.ordinal() ? new j4("BIDDERS") : new j4("WATERFALL");
    }

    public m j() {
        return this.f5509f;
    }

    public String k() {
        return this.f5511h;
    }

    private j2 d() {
        return j2.a().d("Ad Format").c(this.f5508e.b()).a();
    }

    private List e() {
        u7 u7Var = this.f5510g;
        if (u7Var != null && !u7Var.d()) {
            return new ArrayList();
        }
        List<u7> listA = this.f5509f.a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (u7 u7Var2 : listA) {
            u7 u7Var3 = this.f5510g;
            if (u7Var3 == null || u7Var3.b().c().equals(u7Var2.b().c())) {
                arrayList.add(new b(u7Var2, u7Var2.a() != null ? u7Var2.a().a() : "", this.f5510g == null));
            }
        }
        return arrayList;
    }
}
