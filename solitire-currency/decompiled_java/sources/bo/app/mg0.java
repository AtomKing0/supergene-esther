package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class mg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONArray f3423a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg0(JSONArray jSONArray) {
        super(0);
        this.f3423a = jSONArray;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to deserialize triggered actions Json array: " + this.f3423a;
    }
}
