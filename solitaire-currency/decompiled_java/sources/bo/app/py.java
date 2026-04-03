package bo.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class py extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONArray f3667a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public py(JSONArray jSONArray) {
        super(1);
        this.f3667a = jSONArray;
    }

    @Override // h9.l
    public final Object invoke(Object obj) throws JSONException {
        Object obj2 = this.f3667a.get(((Number) obj).intValue());
        if (obj2 != null) {
            return (JSONObject) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }
}
