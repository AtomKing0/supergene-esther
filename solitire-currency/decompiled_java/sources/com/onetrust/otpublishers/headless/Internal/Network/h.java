package com.onetrust.otpublishers.headless.Internal.Network;

import ab.y;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.UI.fragment.a3;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements ab.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject[] f21860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a3.a f21861b;

    public h(JSONObject[] jSONObjectArr, a3.a aVar) {
        this.f21860a = jSONObjectArr;
        this.f21861b = aVar;
    }

    @Override // ab.d
    public final void a(ab.b<String> bVar, y<String> yVar) {
        this.f21860a[0] = new JSONObject();
        OTLogger.a("NetworkRequestHandler", 4, "IAB Vendor Disclosure API Success : " + yVar.a());
        try {
            if (yVar.a() != null) {
                this.f21860a[0] = new JSONObject(yVar.a());
                this.f21861b.a(this.f21860a[0]);
            }
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while fetching IAB Vendor Disclosure details:  "), "NetworkRequestHandler", 6);
            this.f21861b.a(new JSONObject());
        }
    }

    @Override // ab.d
    public final void b(ab.b<String> bVar, Throwable th) {
        OTLogger.a("NetworkRequestHandler", 6, "IAB Vendor Disclosure API Failed :  " + th.getMessage());
        this.f21861b.a(new JSONObject());
    }
}
