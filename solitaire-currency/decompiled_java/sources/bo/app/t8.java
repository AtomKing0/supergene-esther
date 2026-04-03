package bo.app;

import com.braze.support.JsonUtils;
import java.util.LinkedHashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class t8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3903b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t8(String str, String str2) {
        super(0);
        this.f3902a = str;
        this.f3903b = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        cc0 cc0Var;
        JSONObject jSONObject = new JSONObject(this.f3902a);
        String value = jSONObject.getString("name");
        LinkedHashMap linkedHashMap = lx.f3353b;
        kotlin.jvm.internal.t.h(value, "eventTypeString");
        kotlin.jvm.internal.t.i(value, "value");
        Object obj = lx.f3353b.get(value);
        if (obj == null) {
            obj = lx.UNKNOWN;
        }
        lx eventType = (lx) obj;
        JSONObject eventData = jSONObject.getJSONObject("data");
        double d10 = jSONObject.getDouble("time");
        String optionalString = JsonUtils.getOptionalString(jSONObject, "user_id");
        String sessionId = JsonUtils.getOptionalString(jSONObject, "session_id");
        kotlin.jvm.internal.t.h(eventData, "data");
        String uniqueIdentifier = this.f3903b;
        kotlin.jvm.internal.t.i(eventType, "eventType");
        kotlin.jvm.internal.t.i(eventData, "eventData");
        kotlin.jvm.internal.t.i(uniqueIdentifier, "uniqueIdentifier");
        ba baVar = new ba(eventType, eventData, d10, uniqueIdentifier);
        baVar.a(optionalString);
        if (sessionId != null) {
            kotlin.jvm.internal.t.i(sessionId, "sessionId");
            UUID uuidFromString = UUID.fromString(sessionId);
            kotlin.jvm.internal.t.h(uuidFromString, "fromString(sessionId)");
            cc0Var = new cc0(uuidFromString);
        } else {
            cc0Var = null;
        }
        baVar.a(cc0Var);
        return baVar;
    }
}
