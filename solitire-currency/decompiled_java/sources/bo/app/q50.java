package bo.app;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q50 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3685a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q50(JSONObject jSONObject) {
        super(0);
        this.f3685a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Encountered Exception processing server config: " + this.f3685a;
    }
}
