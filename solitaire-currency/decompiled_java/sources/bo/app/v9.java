package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class v9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zc0 f4096b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v9(String str, zc0 zc0Var) {
        super(0);
        this.f4095a = str;
        this.f4096b = zc0Var;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        String str;
        JSONObject jSONObjectPut = new JSONObject().put("group_id", this.f4095a);
        int iOrdinal = this.f4096b.ordinal();
        if (iOrdinal == 0) {
            str = "subscribed";
        } else {
            if (iOrdinal != 1) {
                throw new v8.q();
            }
            str = "unsubscribed";
        }
        JSONObject eventData = jSONObjectPut.put("status", str);
        lx lxVar = lx.SUBSCRIPTION_GROUP_UPDATE;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
