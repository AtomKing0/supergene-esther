package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h1 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j1 f5312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f5313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f5314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f5315d;

    private void b() {
        n2 n2Var = new n2();
        n2Var.a(this.f5313b.w().a(this.f5312a));
        String strB = this.f5313b.w().b(this.f5312a.a());
        if (strB != null) {
            n2Var.a("\nBid Response Preview:\n");
            n2Var.a(strB);
        }
        TextView textView = (TextView) findViewById(R.id.email_report_tv);
        this.f5314c = textView;
        textView.setText(n2Var.toString());
        this.f5314c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a()) {
            finish();
            return;
        }
        setTitle(this.f5312a.c() + " - " + this.f5312a.d());
        setContentView(R.layout.creative_debugger_displayed_ad_detail_activity);
        b();
        q7.a(findViewById(android.R.id.content), this.f5313b);
        Button button = (Button) findViewById(R.id.report_ad_button);
        this.f5315d = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.r9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6775a.a(view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.creative_debugger_displayed_ad_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!a()) {
            finish();
            return false;
        }
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f5313b.w().a(this.f5312a, (Context) this, false);
        return true;
    }

    public void a(j1 j1Var, com.applovin.impl.sdk.j jVar) {
        this.f5312a = j1Var;
        this.f5313b = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f5313b.w().a(this.f5312a, (Context) this, true);
    }

    private boolean a() {
        return (this.f5312a == null || this.f5313b == null) ? false : true;
    }
}
