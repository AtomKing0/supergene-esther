package bo.app;

import com.braze.support.JsonUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j40 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v8.l f3116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b90 f3117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o40 f3118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f3119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3120e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j40(v8.l lVar, b90 b90Var, o40 o40Var, HashMap map, JSONObject jSONObject) {
        super(0);
        this.f3116a = lVar;
        this.f3117b = b90Var;
        this.f3118c = o40Var;
        this.f3119d = map;
        this.f3120e = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        String str;
        StringBuilder sb = new StringBuilder("\n                |Making request with id => \"");
        sb.append((String) this.f3116a.getValue());
        sb.append("\"\n                |to url: ");
        sb.append(this.f3117b);
        sb.append("\n                \n                |with headers:\n                ");
        sb.append(o40.a(this.f3118c, this.f3119d));
        sb.append("\n                |\n                |");
        if (this.f3120e == null) {
            str = "";
        } else {
            str = "and JSON :\n" + JsonUtils.getPrettyPrintedString(this.f3120e);
        }
        return p9.j.h(d1.a(sb, str, "\n                "), null, 1, null);
    }
}
