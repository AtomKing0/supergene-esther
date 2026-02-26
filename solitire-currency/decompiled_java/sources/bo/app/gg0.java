package bo.app;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class gg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f2911a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg0(JSONObject jSONObject) {
        super(0);
        this.f2911a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Encountered exception processing templated message: " + this.f2911a;
    }
}
