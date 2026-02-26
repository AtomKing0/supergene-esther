package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f2347a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a30(JSONObject jSONObject) {
        super(0);
        this.f2347a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to deserialize the in-app message: " + JsonUtils.getPrettyPrintedString(this.f2347a) + ". Returning null.";
    }
}
