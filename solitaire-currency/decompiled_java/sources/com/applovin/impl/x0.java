package com.applovin.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.d;
import com.applovin.impl.k2;
import com.applovin.impl.y0;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x0 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y0 f7720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f7721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListView f7722c;

    class a implements k2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7723a;

        /* JADX INFO: renamed from: com.applovin.impl.x0$a$a, reason: collision with other inner class name */
        class C0179a implements d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d2 f7725a;

            C0179a(d2 d2Var) {
                this.f7725a = d2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
                maxCreativeDebuggerDisplayedAdActivity.a((j1) x0.this.f7720a.d().get(this.f7725a.a()), x0.this.f7720a.e());
            }
        }

        a(c cVar) {
            this.f7723a = cVar;
        }

        @Override // com.applovin.impl.k2.a
        public void a(d2 d2Var, j2 j2Var) {
            if (d2Var.b() != y0.a.RECENT_ADS.ordinal()) {
                return;
            }
            d.a(x0.this, MaxCreativeDebuggerDisplayedAdActivity.class, this.f7723a, new C0179a(d2Var));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Creative Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.f7721b = (FrameLayout) findViewById(android.R.id.content);
        this.f7722c = (ListView) findViewById(R.id.listView);
        q7.a(this.f7721b, com.applovin.impl.sdk.j.f7084v0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        y0 y0Var = this.f7720a;
        if (y0Var != null) {
            y0Var.a((k2.a) null);
            this.f7720a.g();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        y0 y0Var = this.f7720a;
        if (y0Var == null) {
            finish();
            return;
        }
        this.f7722c.setAdapter((ListAdapter) y0Var);
        y0 y0Var2 = this.f7720a;
        if (y0Var2 != null && !y0Var2.e().w().g()) {
            a(R.string.applovin_creative_debugger_disabled_text);
            return;
        }
        y0 y0Var3 = this.f7720a;
        if (y0Var3 == null || !y0Var3.f()) {
            return;
        }
        a(R.string.applovin_creative_debugger_no_ads_text);
    }

    public void a(y0 y0Var, c cVar) {
        this.f7720a = y0Var;
        y0Var.a(new a(cVar));
    }

    private void a(int i10) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setText(i10);
        this.f7721b.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f7721b.bringChildToFront(textView);
    }
}
