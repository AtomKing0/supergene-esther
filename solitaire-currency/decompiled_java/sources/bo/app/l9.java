package bo.app;

import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f3316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f3317c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l9(String str, double d10, double d11) {
        super(0);
        this.f3315a = str;
        this.f3316b = d10;
        this.f3317c = d11;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(v8.h.W, this.f3315a).put("latitude", this.f3316b).put("longitude", this.f3317c);
        lx lxVar = lx.LOCATION_CUSTOM_ATTRIBUTE_ADD;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
