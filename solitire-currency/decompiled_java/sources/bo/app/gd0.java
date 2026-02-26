package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class gd0 extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final md0 f2898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g10 f2899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k00 f2900l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f2901m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f2902n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f2903o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final md0 f2904p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final k50 f2905q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd0(vb0 serverConfigStorageProvider, String urlBase, md0 templatedTriggeredAction, g10 triggerEvent, String str) {
        super(new b90(urlBase + com.vungle.ads.internal.model.b.KEY_TEMPLATE), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(templatedTriggeredAction, "templatedTriggeredAction");
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        this.f2898j = templatedTriggeredAction;
        this.f2899k = triggerEvent;
        this.f2900l = k00.TEMPLATE_REQUEST;
        this.f2901m = templatedTriggeredAction.d();
        this.f2902n = a(templatedTriggeredAction.c());
        this.f2903o = templatedTriggeredAction.e();
        this.f2904p = templatedTriggeredAction;
        this.f2905q = new j50().a(str).a();
    }

    @Override // bo.app.l00
    public final boolean a() {
        return false;
    }

    @Override // bo.app.tg, bo.app.l00
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        if (jSONObjectB == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trigger_id", this.f2901m);
            jSONObject.put("trigger_event_type", this.f2899k.a());
            e00 e00Var = ((we0) this.f2899k).f4203c;
            jSONObject.put("data", e00Var != null ? ((ba) e00Var).forJsonPut() : null);
            jSONObjectB.put(com.vungle.ads.internal.model.b.KEY_TEMPLATE, jSONObject);
            String str = this.f2905q.f3214a;
            if (!(str == null || str.length() == 0)) {
                jSONObjectB.put("respond_with", this.f2905q.forJsonPut());
            }
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) fd0.f2821a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f2900l;
    }

    @Override // bo.app.tg
    public final String toString() {
        return "TemplateRequest(templatedTriggeredAction=" + this.f2898j + ", triggerEvent=" + this.f2899k + ", triggerAnalyticsId='" + this.f2901m + "', templatePayloadExpirationTimestamp=" + this.f2903o + ", getTemplatedDataExpiration=" + (((we0) this.f2899k).f4202b + this.f2902n) + "triggeredAction=" + this.f2904p + ')';
    }

    public static long a(g90 g90Var) {
        int i10 = g90Var.f2887e;
        return i10 == -1 ? TimeUnit.SECONDS.toMillis(g90Var.f2886d + 30) : i10;
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(v00 internalPublisher, v00 externalPublisher, d10 responseError) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(responseError, "responseError");
        super.a(internalPublisher, externalPublisher, responseError);
        if (responseError instanceof t) {
            ((vw) internalPublisher).b(ch0.class, new ch0(this.f2899k, this.f2898j));
        }
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(v00 internalPublisher, v00 externalPublisher, s50 apiResponse) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        InAppMessageBase inAppMessageBase = apiResponse.f3823g;
        if (inAppMessageBase != null) {
            inAppMessageBase.setLocalPrefetchedAssetPaths(kotlin.collections.r0.u(this.f2898j.f2657f));
        }
    }
}
