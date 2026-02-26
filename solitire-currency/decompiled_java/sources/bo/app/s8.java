package bo.app;

import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3839b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s8(String str, String str2) {
        super(0);
        this.f3838a = str;
        this.f3839b = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(v8.h.W, this.f3838a).put("value", this.f3839b);
        lx lxVar = lx.ADD_TO_CUSTOM_ATTRIBUTE_ARRAY;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
