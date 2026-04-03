package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class hd0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f2975a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd0(JSONObject jSONObject) {
        super(0);
        this.f2975a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Parsing templated triggered action with JSON: " + JsonUtils.getPrettyPrintedString(this.f2975a);
    }
}
