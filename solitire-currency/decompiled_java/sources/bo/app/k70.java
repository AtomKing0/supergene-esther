package bo.app;

import com.braze.support.BrazeLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k70 implements a10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3223a;

    public k70(int i10) {
        this.f3223a = i10;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            return new JSONObject().put("re_eligibility", this.f3223a);
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) j70.f3135a, 4, (Object) null);
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k70(JSONObject json) {
        this(json.optInt("re_eligibility", -1));
        kotlin.jvm.internal.t.i(json, "json");
    }
}
