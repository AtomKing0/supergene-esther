package bo.app;

import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o9(String str, JSONObject jSONObject) {
        super(0);
        this.f3548a = str;
        this.f3549b = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(v8.h.W, this.f3548a).put("value", this.f3549b);
        lx lxVar = lx.NESTED_CUSTOM_ATTRIBUTE_MERGE;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
