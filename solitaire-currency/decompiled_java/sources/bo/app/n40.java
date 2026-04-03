package bo.app;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n40 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b90 f3465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f3466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3467c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n40(b90 b90Var, HashMap map, JSONObject jSONObject) {
        super(0);
        this.f3465a = b90Var;
        this.f3466b = map;
        this.f3467c = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        Object[] requestArgs = {this.f3465a, this.f3466b, this.f3467c};
        String str = com.braze.support.i.f8121a;
        kotlin.jvm.internal.t.i(requestArgs, "requestArgs");
        long jHashCode = 1;
        for (int i10 = 0; i10 < 3; i10++) {
            jHashCode *= (long) requestArgs[i10].hashCode();
        }
        String hexString = Long.toHexString(jHashCode);
        kotlin.jvm.internal.t.h(hexString, "toHexString(\n    request…lement.hashCode()\n    }\n)");
        return hexString;
    }
}
