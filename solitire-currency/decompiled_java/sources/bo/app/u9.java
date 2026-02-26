package bo.app;

import com.braze.support.JsonUtils;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String[] f4000b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u9(String str, String[] strArr) {
        super(0);
        this.f3999a = str;
        this.f4000b = strArr;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(v8.h.W, this.f3999a);
        String[] strArr = this.f4000b;
        if (strArr == null) {
            jSONObject.put("value", JSONObject.NULL);
        } else {
            jSONObject.put("value", JsonUtils.constructJsonArray(strArr));
        }
        return new ba(lx.SET_CUSTOM_ATTRIBUTE_ARRAY, jSONObject, 0.0d, 12);
    }
}
