package com.ironsource;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class mf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kf f13992a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f13994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13996e = mf.class.getSimpleName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f13997f = {"handleGetViewVisibility"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f13998g = {Cif.f12599h, Cif.f12600i, Cif.f12598g, "handleGetViewVisibility", Cif.f12601j};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private eu f13993b = new eu();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f14002d;

        a(String str, String str2, String str3, JSONObject jSONObject) {
            this.f13999a = str;
            this.f14000b = str2;
            this.f14001c = str3;
            this.f14002d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!mf.this.b(this.f13999a)) {
                    String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.f13999a;
                    Log.e(mf.this.f13996e, str);
                    mf.this.a(this.f14000b, str);
                    return;
                }
                if (this.f13999a.equalsIgnoreCase("handleGetViewVisibility")) {
                    mf.this.e(this.f14001c);
                } else if (this.f13999a.equalsIgnoreCase(Cif.f12601j) || this.f13999a.equalsIgnoreCase(Cif.f12600i)) {
                    mf.this.a(this.f14002d.getString("params"), this.f14001c, this.f14000b);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
                String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.f13999a;
                Log.e(mf.this.f13996e, str2);
                mf.this.a(this.f14000b, str2);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14005b;

        b(String str, String str2) {
            this.f14004a = str;
            this.f14005b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                mf.this.f13994c.evaluateJavascript(this.f14004a, null);
            } catch (Throwable th) {
                i9.d().a(th);
                Log.e(mf.this.f13996e, "injectJavaScriptIntoWebView | Error while trying inject JS into external adUnit: " + this.f14005b + "Android API level: " + Build.VERSION.SDK_INT);
            }
        }
    }

    private void d() {
        if (this.f13992a == null || this.f13993b == null) {
            return;
        }
        a(Cif.f12592a, a());
    }

    private boolean h(String str) {
        for (String str2 : this.f13997f) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(String str) {
        return str.equalsIgnoreCase(Cif.f12602k);
    }

    public String c() {
        return this.f13995d;
    }

    public void e() {
        if (this.f13992a == null || this.f13993b == null) {
            return;
        }
        a(Cif.f12593b, a());
    }

    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.f13995d);
            a(str, jSONObject);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void g(String str) {
        this.f13995d = str;
    }

    private String a(String str) {
        return String.format(Cif.f12612u, str);
    }

    private void d(String str) {
        ve.f15889a.d(new b("javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}", str));
    }

    public void b() {
        this.f13992a = null;
        this.f13993b = null;
    }

    public void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("method");
            if (TextUtils.isEmpty(strOptString) || !h(strOptString)) {
                a(jSONObject.optString(Cif.f12613v, Cif.f12594c), jSONObject);
            } else if (strOptString.equalsIgnoreCase("handleGetViewVisibility")) {
                a(jSONObject, (String) null, (String) null);
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
            Log.e(this.f13996e, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void e(String str) throws JSONException {
        JSONObject jSONObjectA = this.f13993b.a();
        jSONObjectA.put("adViewId", this.f13995d);
        a(str, jSONObjectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        for (String str2 : this.f13998g) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Cif.f12610s, this.f13993b.a());
            jSONObject.put(Cif.f12607p, jSONObject2);
            jSONObject.put("adViewId", c());
            return jSONObject;
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return new JSONObject();
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", jSONObject.getString("id"));
            jSONObject2.put("data", this.f13993b.a());
        } catch (Exception e10) {
            i9.d().a(e10);
            Log.e(this.f13996e, "Error while trying execute method buildVisibilityMessageForAdUnit | params: " + jSONObject);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject2;
    }

    public void a(WebView webView) {
        this.f13994c = webView;
    }

    public void a(kf kfVar) {
        this.f13992a = kfVar;
    }

    public void a(String str, int i10, boolean z10) {
        this.f13993b.a(str, i10, z10);
        if (i(str)) {
            d();
        }
    }

    public void a(String str, String str2) {
        kf kfVar = this.f13992a;
        if (kfVar != null) {
            kfVar.a(str, str2, this.f13995d);
        }
    }

    public void a(String str, String str2, String str3) throws JSONException {
        if (this.f13994c == null) {
            String str4 = "No external adUnit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.f13996e, str4);
            this.f13992a.a(str3, str4, this.f13995d);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException e10) {
            i9.d().a(e10);
            str = "\"" + str + "\"";
        }
        d(a(str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.f13995d);
        a(str2, jSONObject);
    }

    public void a(String str, JSONObject jSONObject) {
        kf kfVar = this.f13992a;
        if (kfVar != null) {
            kfVar.a(str, jSONObject);
        }
    }

    void a(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.f13992a == null) {
            xf.a(vp.f15952t, new sf().a(nb.f14127y, "mDelegate is null").a());
        } else {
            ve.f15889a.d(new a(str, str3, str2, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        a(a(jSONObject).toString(), str, str2);
    }
}
