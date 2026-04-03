package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class fl extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONArray f2834a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fl(JSONArray jSONArray) {
        super(1);
        this.f2834a = jSONArray;
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return Boolean.valueOf(this.f2834a.opt(((Number) obj).intValue()) instanceof String);
    }
}
