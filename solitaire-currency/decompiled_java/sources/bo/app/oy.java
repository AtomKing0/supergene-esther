package bo.app;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class oy extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONArray f3592a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oy(JSONArray jSONArray) {
        super(1);
        this.f3592a = jSONArray;
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        return Boolean.valueOf(this.f3592a.opt(((Number) obj).intValue()) instanceof JSONObject);
    }
}
