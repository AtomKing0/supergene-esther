package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class zg extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f4439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f4440b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zg(ih ihVar, JSONArray jSONArray) {
        super(0);
        this.f4439a = ihVar;
        this.f4440b = jSONArray;
    }

    @Override // h9.a
    public final Object invoke() {
        ((vw) this.f4439a.f3055a).b(hy.class, new hy(this.f4440b));
        return v8.k0.f35197a;
    }
}
