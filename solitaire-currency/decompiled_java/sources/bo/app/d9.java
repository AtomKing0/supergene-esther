package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2634b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d9(String str, String str2) {
        super(0);
        this.f2633a = str;
        this.f2634b = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put("geo_id", this.f2633a).put("event_type", this.f2634b);
        lx lxVar = lx.GEOFENCE;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
