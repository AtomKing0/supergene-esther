package bo.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3997a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u8(String str) {
        super(0);
        this.f3997a = str;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f3997a);
        jSONObject.put("ids", jSONArray);
        return new ba(lx.CONTENT_CARDS_CLICK, jSONObject, 0.0d, 12);
    }
}
