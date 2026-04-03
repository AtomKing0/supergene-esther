package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p50 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3605a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p50(JSONObject jSONObject) {
        super(0);
        this.f3605a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Got server config: " + JsonUtils.getPrettyPrintedString(this.f3605a);
    }
}
