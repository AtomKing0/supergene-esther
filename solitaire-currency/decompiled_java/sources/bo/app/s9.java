package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3840a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s9(long j10) {
        super(0);
        this.f3840a = j10;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put("d", this.f3840a);
        lx lxVar = lx.SESSION_END;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
