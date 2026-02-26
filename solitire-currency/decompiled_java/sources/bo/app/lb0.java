package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class lb0 extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONArray f3323a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lb0(JSONArray jSONArray) {
        super(1);
        this.f3323a = jSONArray;
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return Boolean.valueOf(this.f3323a.opt(((Number) obj).intValue()) instanceof String);
    }
}
