package bo.app;

import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class eb0 extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONArray f2721a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb0(JSONArray jSONArray) {
        super(1);
        this.f2721a = jSONArray;
    }

    @Override // h9.l
    public final Object invoke(Object obj) throws JSONException {
        Object obj2 = this.f2721a.get(((Number) obj).intValue());
        if (obj2 != null) {
            return (String) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
