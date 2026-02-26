package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class fj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f2832b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(String str, JSONObject jSONObject) {
        super(0);
        this.f2831a = str;
        this.f2832b = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set custom json attribute " + this.f2831a + " with value \n" + JsonUtils.getPrettyPrintedString(this.f2832b) + '.';
    }
}
