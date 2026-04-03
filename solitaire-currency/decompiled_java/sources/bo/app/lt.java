package bo.app;

import com.braze.support.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class lt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3347a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lt(JSONObject jSONObject) {
        super(0);
        this.f3347a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Parsed dust message json to:\n" + JsonUtils.getPrettyPrintedString(this.f3347a);
    }
}
