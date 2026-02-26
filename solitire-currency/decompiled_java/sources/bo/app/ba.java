package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.UUID;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ba implements e00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lx f2431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f2432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f2433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u30 f2435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u30 f2436f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f2430h = {kotlin.jvm.internal.o0.e(new kotlin.jvm.internal.a0(ba.class, "userId", "getUserId()Ljava/lang/String;", 0)), kotlin.jvm.internal.o0.e(new kotlin.jvm.internal.a0(ba.class, JsonStorageKeyNames.SESSION_ID_KEY, "getSessionId()Lcom/braze/models/SessionId;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final z9 f2429g = new z9();

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ba(lx lxVar, JSONObject jSONObject, double d10, int i10) {
        JSONObject jSONObject2 = (i10 & 2) != 0 ? new JSONObject() : jSONObject;
        d10 = (i10 & 4) != 0 ? DateTimeUtils.nowInSecondsPrecise() : d10;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.t.h(string, "randomUUID().toString()");
        this(lxVar, jSONObject2, d10, string);
    }

    public final void a(cc0 cc0Var) {
        this.f2436f.setValue(this, f2430h[1], cc0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !kotlin.jvm.internal.t.d(getClass(), obj.getClass())) {
            return false;
        }
        return kotlin.jvm.internal.t.d(this.f2434d, ((ba) obj).f2434d);
    }

    public final int hashCode() {
        return this.f2434d.hashCode();
    }

    public final String toString() {
        String string = forJsonPut().toString();
        kotlin.jvm.internal.t.h(string, "forJsonPut().toString()");
        return string;
    }

    public final void a(String str) {
        this.f2435e.setValue(this, f2430h[0], str);
    }

    @Override // com.braze.models.IPutIntoJson
    public final JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f2431a.f3378a);
            jSONObject.put("data", this.f2432b);
            jSONObject.put("time", this.f2433c);
            u30 u30Var = this.f2435e;
            KProperty[] kPropertyArr = f2430h;
            KProperty property = kPropertyArr[0];
            u30Var.getClass();
            kotlin.jvm.internal.t.i(this, "thisRef");
            kotlin.jvm.internal.t.i(property, "property");
            String str = (String) u30Var.f3985a;
            if (str != null && str.length() != 0) {
                u30 u30Var2 = this.f2435e;
                KProperty property2 = kPropertyArr[0];
                u30Var2.getClass();
                kotlin.jvm.internal.t.i(this, "thisRef");
                kotlin.jvm.internal.t.i(property2, "property");
                jSONObject.put("user_id", (String) u30Var2.f3985a);
            }
            u30 u30Var3 = this.f2436f;
            KProperty property3 = kPropertyArr[1];
            u30Var3.getClass();
            kotlin.jvm.internal.t.i(this, "thisRef");
            kotlin.jvm.internal.t.i(property3, "property");
            cc0 cc0Var = (cc0) u30Var3.f3985a;
            if (cc0Var != null) {
                jSONObject.put("session_id", cc0Var.f2502b);
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) aa.f2363a, 4, (Object) null);
        }
        return jSONObject;
    }

    public ba(lx type, JSONObject data, double d10, String uniqueIdentifier) {
        kotlin.jvm.internal.t.i(type, "type");
        kotlin.jvm.internal.t.i(data, "data");
        kotlin.jvm.internal.t.i(uniqueIdentifier, "uniqueIdentifier");
        this.f2431a = type;
        this.f2432b = data;
        this.f2433c = d10;
        this.f2434d = uniqueIdentifier;
        this.f2435e = new u30();
        this.f2436f = new u30();
        if (type == lx.UNKNOWN) {
            throw new IllegalArgumentException("Event type cannot be unknown.");
        }
    }
}
