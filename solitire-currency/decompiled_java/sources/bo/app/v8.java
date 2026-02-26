package bo.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class v8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4078a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v8(String str) {
        super(0);
        this.f4078a = str;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f4078a);
        jSONObject.put("ids", jSONArray);
        return new ba(lx.CONTENT_CARDS_CONTROL_IMPRESSION, jSONObject, 0.0d, 12);
    }
}
