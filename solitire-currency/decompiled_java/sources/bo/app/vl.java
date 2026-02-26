package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class vl extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f4126b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl(Object obj, JSONArray jSONArray) {
        super(0);
        this.f4125a = obj;
        this.f4126b = jSONArray;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Unable to create Card JSON in array. Ignoring. Was on element: " + this.f4125a + " of json array: " + this.f4126b;
    }
}
