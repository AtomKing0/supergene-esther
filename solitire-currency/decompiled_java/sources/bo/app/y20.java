package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class y20 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f4316a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y20(JSONObject jSONObject) {
        super(0);
        this.f4316a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "In-app message type was unknown for in-app message: " + JsonUtils.getPrettyPrintedString(this.f4316a);
    }
}
