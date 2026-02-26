package bo.app;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ym extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f4374a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ym(JSONObject jSONObject) {
        super(0);
        this.f4374a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Server card has expired already. Not adding card to storage. Server card: " + this.f4374a;
    }
}
