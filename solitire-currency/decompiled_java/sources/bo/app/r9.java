package bo.app;

import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class r9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3751b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r9(String str, String str2) {
        super(0);
        this.f3750a = str;
        this.f3751b = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(v8.h.W, this.f3750a).put("value", this.f3751b);
        lx lxVar = lx.REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
