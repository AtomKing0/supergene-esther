package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class jf extends FrameLayout implements hg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12733b = "IronSourceAdContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private of f12734a;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12736b;

        a(String str, String str2) {
            this.f12735a = str;
            this.f12736b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jf jfVar = jf.this;
            jfVar.removeView(jfVar.f12734a.getPresentingView());
            jf.this.f12734a.a(this.f12735a, this.f12736b);
            jf.this.f12734a = null;
        }
    }

    public jf(Context context) {
        super(context);
    }

    private void b() throws Exception {
        JSONObject jSONObject;
        try {
            jSONObject = this.f12734a.c().a().getJSONObject(Cif.f12607p).getJSONObject(Cif.f12610s);
        } catch (Exception e10) {
            i9.d().a(e10);
            jSONObject = new JSONObject();
        }
        jSONObject.put("adViewId", this.f12734a.b());
        this.f12734a.c().a(v8.g.R, jSONObject);
    }

    @Override // com.ironsource.hg
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        this.f12734a.c(jSONObject, str, str2);
    }

    @Override // com.ironsource.hg
    public WebView getPresentingView() {
        return this.f12734a.getPresentingView();
    }

    public hf getSize() {
        of ofVar = this.f12734a;
        return ofVar != null ? ofVar.d() : new hf();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        Logger.i(f12733b, "onVisibilityChanged: " + i10);
        of ofVar = this.f12734a;
        if (ofVar == null) {
            return;
        }
        try {
            ofVar.c().a(Cif.f12602k, i10, isShown());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        Logger.i(f12733b, "onWindowVisibilityChanged: " + i10);
        of ofVar = this.f12734a;
        if (ofVar == null) {
            return;
        }
        try {
            ofVar.c().a(Cif.f12603l, i10, isShown());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public jf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.ironsource.hg
    public void b(JSONObject jSONObject, String str, String str2) {
        this.f12734a.b(jSONObject, str, str2);
    }

    public jf(of ofVar, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(ofVar.d().c(), ofVar.d().a()));
        this.f12734a = ofVar;
        addView(ofVar.getPresentingView());
    }

    public void a() throws Exception {
        of ofVar = this.f12734a;
        if (ofVar == null || ofVar.c() == null) {
            throw new Exception("mAdPresenter or mAdPresenter.getAdViewLogic() are null");
        }
        b();
    }

    @Override // com.ironsource.hg
    public synchronized void a(String str, String str2) {
        of ofVar = this.f12734a;
        if (ofVar != null && ofVar.c() != null && this.f12734a.getPresentingView() != null) {
            this.f12734a.c().e();
            ve.f15889a.d(new a(str, str2));
        }
    }

    @Override // com.ironsource.hg
    public void a(String str, String str2, String str3) {
        of ofVar = this.f12734a;
        if (ofVar == null) {
            return;
        }
        ofVar.a(str, str2, str3);
    }

    @Override // com.ironsource.hg
    public void a(JSONObject jSONObject, String str, String str2) {
        this.f12734a.a(jSONObject, str, str2);
    }
}
