package bo.app;

import com.braze.Braze;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class tg extends u70 implements l00 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb0 f3942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f3943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public nq f3947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3948i;

    public /* synthetic */ tg(b90 b90Var, vb0 vb0Var) {
        this(b90Var, null, vb0Var);
    }

    public void a(HashMap existingHeaders) {
        kotlin.jvm.internal.t.i(existingHeaders, "existingHeaders");
        existingHeaders.put("X-Braze-Api-Key", this.f3945f);
        String str = this.f3948i;
        if (str == null || str.length() == 0) {
            return;
        }
        existingHeaders.put("X-Braze-Auth-Signature", this.f3948i);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            nq nqVar = this.f3947h;
            if (nqVar != null && !nqVar.isEmpty()) {
                jSONObject.put("device", nqVar.forJsonPut());
            }
            String str = this.f3944e;
            if (str != null) {
                jSONObject.put("device_id", str);
            }
            Long l10 = this.f3943d;
            if (l10 != null) {
                jSONObject.put("time", l10);
            }
            String str2 = this.f3945f;
            if (str2 != null) {
                jSONObject.put("api_key", str2);
            }
            String str3 = this.f3946g;
            if (str3 != null) {
                jSONObject.put("sdk_version", str3);
            }
            return jSONObject;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) sg.f3856a, 4, (Object) null);
            return null;
        }
    }

    public final Long d() {
        return this.f3943d;
    }

    public final b90 e() {
        return new b90(Braze.Companion.getApiEndpoint(this.f3996a.f2426b), false);
    }

    public String toString() {
        return hashCode() + " - " + JsonUtils.getPrettyPrintedString(b()) + "\nto target: " + e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg(b90 requestTarget, String str, vb0 serverConfigStorageProvider) {
        super(requestTarget);
        kotlin.jvm.internal.t.i(requestTarget, "requestTarget");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        this.f3941b = str;
        this.f3942c = serverConfigStorageProvider;
    }

    @Override // bo.app.b10
    public void a(v00 internalPublisher) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        ((vw) internalPublisher).b(v70.class, new v70(this));
    }

    @Override // bo.app.b10
    public void a(v00 internalPublisher, v00 externalPublisher, d10 responseError) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(responseError, "responseError");
        String strA = responseError.a();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new ig(strA), 6, (Object) null);
        if (responseError instanceof x30) {
            ((vw) internalPublisher).b(x30.class, responseError);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) jg.f3158a, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) kg.f3249a, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) lg.f3333a, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) mg.f3422a, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) ng.f3486a, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new og(this), 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new pg(this), 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) qg.f3709a, 6, (Object) null);
        }
        if (responseError instanceof i90) {
            ((vw) externalPublisher).b(BrazeSdkAuthenticationErrorEvent.class, new BrazeSdkAuthenticationErrorEvent((i90) responseError));
        }
    }

    @Override // bo.app.b10
    public void a(vw internalPublisher) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        internalPublisher.b(w70.class, new w70(this));
    }

    @Override // bo.app.b10
    public void a(v00 internalPublisher, v00 externalPublisher, s50 apiResponse) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        ma0 ma0Var = apiResponse.f3821e;
        if (ma0Var != null) {
            ((vw) externalPublisher).b(BrazeSdkAuthenticationErrorEvent.class, new BrazeSdkAuthenticationErrorEvent(new i90(ma0Var.f3402a, ma0Var.f3403b, ma0Var.f3404c, null)));
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, (BrazeLogger.Priority) null, (Throwable) null, c() == k00.SDK_DEBUGGER_LOG, new rg(this), 3, (Object) null);
    }
}
