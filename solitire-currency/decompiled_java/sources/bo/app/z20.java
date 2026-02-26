package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z20 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f4390a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z20(JSONObject jSONObject) {
        super(0);
        this.f4390a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Unknown in-app message type. Returning null: " + JsonUtils.getPrettyPrintedString(this.f4390a);
    }
}
