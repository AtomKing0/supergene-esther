package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.j2;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v2;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class x2 extends k2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v2 f7729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f7730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f7731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f7732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f7733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f7734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SpannedString f7735k;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    x2(v2 v2Var, Context context) {
        super(context);
        this.f7729e = v2Var;
        if (v2Var.q() == v2.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f7735k = new SpannedString(spannableString);
        } else {
            this.f7735k = new SpannedString("");
        }
        this.f7730f = g();
        this.f7731g = b(v2Var.n());
        this.f7732h = e();
        this.f7733i = a(v2Var.f());
        this.f7734j = j();
        notifyDataSetChanged();
    }

    private j2 f() {
        if (this.f7729e.I()) {
            return null;
        }
        return j2.a().d("Initialization Status").c(f(this.f7729e.i())).a(false).a();
    }

    private List g() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(i(), arrayList);
        CollectionUtils.addObjectIfExists(d(), arrayList);
        CollectionUtils.addObjectIfExists(f(), arrayList);
        return arrayList;
    }

    private j2 i() {
        j2.b bVarC = j2.a().d("SDK").c(this.f7729e.p());
        if (TextUtils.isEmpty(this.f7729e.p())) {
            bVarC.a(a(this.f7729e.G())).b(b(this.f7729e.G()));
        }
        return bVarC.a();
    }

    private List j() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.f7729e.v())) {
            arrayList.add(j2.a(j2.c.DETAIL).d(this.f7729e.v()).a());
        }
        if (this.f7729e.y() == v2.b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.f7729e.s() != null) {
            arrayList.add(c(this.f7729e.s()));
        }
        arrayList.add(a(this.f7729e.y()));
        return arrayList;
    }

    public boolean a(d2 d2Var) {
        return d2Var.b() == a.TEST_ADS.ordinal() && d2Var.a() == this.f7734j.size() - 1;
    }

    @Override // com.applovin.impl.k2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.k2
    protected List c(int i10) {
        return i10 == a.INTEGRATIONS.ordinal() ? this.f7730f : i10 == a.PERMISSIONS.ordinal() ? this.f7731g : i10 == a.CONFIGURATION.ordinal() ? this.f7732h : i10 == a.DEPENDENCIES.ordinal() ? this.f7733i : this.f7734j;
    }

    @Override // com.applovin.impl.k2
    protected int d(int i10) {
        return i10 == a.INTEGRATIONS.ordinal() ? this.f7730f.size() : i10 == a.PERMISSIONS.ordinal() ? this.f7731g.size() : i10 == a.CONFIGURATION.ordinal() ? this.f7732h.size() : i10 == a.DEPENDENCIES.ordinal() ? this.f7733i.size() : this.f7734j.size();
    }

    @Override // com.applovin.impl.k2
    protected j2 e(int i10) {
        return i10 == a.INTEGRATIONS.ordinal() ? new j4("INTEGRATIONS") : i10 == a.PERMISSIONS.ordinal() ? new j4("PERMISSIONS") : i10 == a.CONFIGURATION.ordinal() ? new j4("CONFIGURATION") : i10 == a.DEPENDENCIES.ordinal() ? new j4("DEPENDENCIES") : new j4("TEST ADS");
    }

    public v2 h() {
        return this.f7729e;
    }

    public void k() {
        this.f7730f = g();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d1 d1Var = (d1) it.next();
                arrayList.add(a(d1Var.b(), d1Var.a(), d1Var.c(), true));
            }
        }
        return arrayList;
    }

    private List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c4 c4Var = (c4) it.next();
                arrayList.add(a(c4Var.b(), c4Var.a(), c4Var.c(), true));
            }
        }
        return arrayList;
    }

    private String f(int i10) {
        return (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i10 || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i10 || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i10) ? "Initialized" : MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i10 ? "Failure" : MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i10 ? "Initializing..." : "Not Initialized";
    }

    private j2 a(v2.b bVar) {
        j2.b bVarA = j2.a();
        if (bVar == v2.b.READY) {
            bVarA.a(this.f5532a);
        }
        return bVarA.d("Test Mode").c(bVar.c()).c(bVar.d()).b("Restart Required").a(bVar.b()).a(true).a();
    }

    private int b(boolean z10) {
        return i0.a(z10 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f5532a);
    }

    private j2 c(List list) {
        return j2.a().d("Region/VPN Required").c(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private j2 d() {
        j2.b bVarC = j2.a().d("Adapter").c(this.f7729e.c());
        if (TextUtils.isEmpty(this.f7729e.c())) {
            bVarC.a(a(this.f7729e.A())).b(b(this.f7729e.A()));
        }
        return bVarC.a();
    }

    private List e() {
        ArrayList arrayList = new ArrayList(1);
        if (this.f7729e.E()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://developers.applovin.com/en/android/overview/integration", com.applovin.impl.sdk.j.y0(), true));
        }
        return arrayList;
    }

    private int c(boolean z10) {
        return z10 ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private int d(boolean z10) {
        return i0.a(z10 ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f5532a);
    }

    private j2 a(String str, String str2, boolean z10, boolean z11) {
        return j2.a(z10 ? j2.c.RIGHT_DETAIL : j2.c.DETAIL).d(str).a(z10 ? null : this.f7735k).b("Instructions").a(str2).a(z10 ? R.drawable.applovin_ic_check_mark_bordered : c(z11)).b(z10 ? i0.a(R.color.applovin_sdk_checkmarkColor, this.f5532a) : d(z11)).a(!z10).a();
    }

    private int a(boolean z10) {
        return z10 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }
}
