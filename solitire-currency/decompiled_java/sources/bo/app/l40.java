package bo.app;

import com.braze.support.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l40 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v8.l f3299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b90 f3300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o40 f3302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Map f3303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3304f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l40(v8.l lVar, b90 b90Var, long j10, o40 o40Var, Map map, JSONObject jSONObject) {
        super(0);
        this.f3299a = lVar;
        this.f3300b = b90Var;
        this.f3301c = j10;
        this.f3302d = o40Var;
        this.f3303e = map;
        this.f3304f = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return p9.j.h("\n                |Made request with id => \"" + ((String) this.f3299a.getValue()) + "\"\n                |to url: " + this.f3300b + "\n                |took: " + this.f3301c + "ms\n                \n                |with response headers:\n                " + o40.a(this.f3302d, this.f3303e) + "\n                |\n                |and response JSON:\n                |" + JsonUtils.getPrettyPrintedString(this.f3304f) + "\n                ", null, 1, null);
    }
}
