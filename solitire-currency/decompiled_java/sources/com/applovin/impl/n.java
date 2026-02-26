package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.autofill.HintConstants;
import androidx.core.view.ViewCompat;
import com.applovin.impl.d;
import com.applovin.impl.j2;
import com.applovin.impl.k2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallSegmentsActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f6367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f6368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k2 f6369c;

    class a extends k2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f6370e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, l lVar) {
            super(context);
            this.f6370e = lVar;
        }

        @Override // com.applovin.impl.k2
        protected int b() {
            return this.f6370e.g().size();
        }

        @Override // com.applovin.impl.k2
        protected List c(int i10) {
            ArrayList arrayList = new ArrayList();
            m mVar = (m) this.f6370e.g().get(i10);
            arrayList.add(n.this.c(mVar.c()));
            if (mVar.b() != null) {
                arrayList.add(n.this.a("AB Test Experiment Name", mVar.b()));
            }
            w7 w7VarD = mVar.d();
            n nVar = n.this;
            arrayList.add(nVar.a("Device ID Targeting", nVar.a(w7VarD.a())));
            n nVar2 = n.this;
            arrayList.add(nVar2.a("Device Type Targeting", nVar2.b(w7VarD.b())));
            if (w7VarD.c() != null) {
                arrayList.add(n.this.a(w7VarD.c()));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.k2
        protected int d(int i10) {
            m mVar = (m) this.f6370e.g().get(i10);
            return (mVar.b() != null ? 1 : 0) + 3 + (mVar.d().c() == null ? 0 : 1);
        }

        @Override // com.applovin.impl.k2
        protected j2 e(int i10) {
            return i10 == b.TARGETED_WATERFALL.ordinal() ? new j4("TARGETED WATERFALL FOR CURRENT DEVICE") : i10 == b.OTHER_WATERFALLS.ordinal() ? new j4("OTHER WATERFALLS") : new j4("");
        }
    }

    public enum b {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f6368b;
    }

    public void initialize(final l lVar, final com.applovin.impl.sdk.j jVar) {
        this.f6367a = lVar;
        this.f6368b = jVar;
        a aVar = new a(this, lVar);
        this.f6369c = aVar;
        aVar.a(new k2.a() { // from class: com.applovin.impl.rb
            @Override // com.applovin.impl.k2.a
            public final void a(d2 d2Var, j2 j2Var) {
                this.f6779a.a(jVar, lVar, d2Var, j2Var);
            }
        });
        this.f6369c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f6367a.d());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.f6369c);
        listView.setDividerHeight(0);
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k2 k2Var = this.f6369c;
        if (k2Var != null) {
            k2Var.a((k2.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return str.equals(HintConstants.AUTOFILL_HINT_PHONE) ? "Phones" : str.equals("tablet") ? "Tablets" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j2 c(String str) {
        return j2.a(j2.c.RIGHT_DETAIL).b(StringUtils.createSpannedString(str, ViewCompat.MEASURED_STATE_MASK, 18, 1)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.j jVar, final l lVar, final d2 d2Var, j2 j2Var) {
        if (d2Var.a() == 0) {
            d.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new d.b() { // from class: com.applovin.impl.sb
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    n.a(lVar, d2Var, jVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        } else {
            d.a(this, MaxDebuggerWaterfallSegmentsActivity.class, jVar.e(), new d.b() { // from class: com.applovin.impl.tb
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    n.a(lVar, d2Var, jVar, (MaxDebuggerWaterfallSegmentsActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(l lVar, d2 d2Var, com.applovin.impl.sdk.j jVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(lVar, (m) lVar.g().get(d2Var.b()), null, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(l lVar, d2 d2Var, com.applovin.impl.sdk.j jVar, MaxDebuggerWaterfallSegmentsActivity maxDebuggerWaterfallSegmentsActivity) {
        m mVar = (m) lVar.g().get(d2Var.b());
        maxDebuggerWaterfallSegmentsActivity.initialize(mVar.c(), mVar.d().c(), jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j2 a(String str, String str2) {
        return j2.a(j2.c.RIGHT_DETAIL).d(str).c(str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j2 a(List list) {
        return j2.a(j2.c.DETAIL).d("Segment Targeting").a(StringUtils.createSpannedString(list.size() + " segment group(s)", -7829368, 14)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return str.equals("idfa") ? "IDFA Only" : str.equals("dnt") ? "No IDFA Only" : "All";
    }
}
