package bo.app;

import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3141b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j9(String str, int i10) {
        super(0);
        this.f3140a = str;
        this.f3141b = i10;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(v8.h.W, this.f3140a).put("value", this.f3141b);
        lx lxVar = lx.INCREMENT;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
