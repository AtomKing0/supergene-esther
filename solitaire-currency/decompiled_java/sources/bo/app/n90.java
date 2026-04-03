package bo.app;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n90 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3476a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n90(JSONObject jSONObject) {
        super(0);
        this.f3476a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "sdkDebuggerObject contains invalid values. Disabling SDK debugging. " + this.f3476a;
    }
}
