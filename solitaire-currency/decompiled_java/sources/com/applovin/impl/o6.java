package com.applovin.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o6 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f6467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6469c;

    private void a() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", this.f6469c);
        intent.putExtra("android.intent.extra.TITLE", this.f6468b);
        intent.putExtra("android.intent.extra.SUBJECT", this.f6468b);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f6467a;
    }

    public void initialize(String str, String str2, com.applovin.impl.sdk.j jVar) {
        this.f6467a = jVar;
        this.f6468b = str;
        this.f6469c = str2;
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_text_view_activity);
        setTitle(this.f6468b);
        ((TextView) findViewById(R.id.textView)).setText(this.f6469c);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        a();
        return true;
    }
}
