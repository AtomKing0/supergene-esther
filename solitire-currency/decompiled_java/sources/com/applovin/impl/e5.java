package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.e f5135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinPostbackListener f5136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r5.b f5137i;

    class a implements AppLovinPostbackListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i10) {
            e5.this.e();
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            if (e5.this.f5136h != null) {
                e5.this.f5136h.onPostbackSuccess(e5.this.f5135g.f());
            }
        }
    }

    public e5(com.applovin.impl.sdk.network.e eVar, r5.b bVar, com.applovin.impl.sdk.j jVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", jVar);
        if (eVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f5135g = eVar;
        this.f5136h = appLovinPostbackListener;
        this.f5137i = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        b bVar = new b(this.f5135g, b());
        bVar.a(this.f5137i);
        b().j0().a(bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (StringUtils.isValidString(this.f5135g.f())) {
            if (this.f5135g.u()) {
                b().q0().a(this.f5135g, new a());
                return;
            } else {
                e();
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.d(this.f7678b, "Requested URL is not valid; nothing to do...");
        }
        AppLovinPostbackListener appLovinPostbackListener = this.f5136h;
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f5135g.f(), AppLovinErrorCodes.INVALID_URL);
        }
    }

    class b extends z5 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final String f5139m;

        b(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
            this.f5139m = e5.this.f5135g.f();
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, Object obj, int i10) {
            if (obj instanceof String) {
                for (String str2 : this.f7677a.c(l4.f5687m0)) {
                    if (str2.startsWith(str2)) {
                        String str3 = (String) obj;
                        if (TextUtils.isEmpty(str3)) {
                            continue;
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(str3);
                                n0.c(jSONObject, this.f7677a);
                                n0.b(jSONObject, this.f7677a);
                                n0.a(jSONObject, this.f7677a);
                                break;
                            } catch (JSONException unused) {
                                continue;
                            }
                        }
                    }
                }
            }
            if (e5.this.f5136h != null) {
                e5.this.f5136h.onPostbackSuccess(this.f5139m);
            }
            if (e5.this.f5135g.t()) {
                this.f7677a.r().a(e5.this.f5135g.s(), this.f5139m, i10, obj, null, true);
            }
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, Object obj) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Failed to dispatch postback. Error code: " + i10 + " URL: " + this.f5139m);
            }
            if (e5.this.f5136h != null) {
                e5.this.f5136h.onPostbackFailure(this.f5139m, i10);
            }
            if (e5.this.f5135g.t()) {
                this.f7677a.r().a(e5.this.f5135g.s(), this.f5139m, i10, obj, str2, false);
            }
        }
    }
}
