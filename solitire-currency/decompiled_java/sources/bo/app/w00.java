package bo.app;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f4159c;

    public /* synthetic */ w00(int i10, Map map, int i11) {
        this(i10, (i11 & 2) != 0 ? kotlin.collections.r0.g() : map, (JSONObject) null);
    }

    public final JSONObject a() {
        return this.f4159c;
    }

    public final int b() {
        return this.f4157a;
    }

    public final Map c() {
        return this.f4158b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w00)) {
            return false;
        }
        w00 w00Var = (w00) obj;
        return this.f4157a == w00Var.f4157a && kotlin.jvm.internal.t.d(this.f4158b, w00Var.f4158b) && kotlin.jvm.internal.t.d(this.f4159c, w00Var.f4159c);
    }

    public final int hashCode() {
        int iHashCode = (this.f4158b.hashCode() + (this.f4157a * 31)) * 31;
        JSONObject jSONObject = this.f4159c;
        return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public final String toString() {
        return "HttpConnectorResult(responseCode=" + this.f4157a + ", responseHeaders=" + this.f4158b + ", jsonResponse=" + this.f4159c + ')';
    }

    public w00(int i10, Map responseHeaders, JSONObject jSONObject) {
        kotlin.jvm.internal.t.i(responseHeaders, "responseHeaders");
        this.f4157a = i10;
        this.f4158b = responseHeaders;
        this.f4159c = jSONObject;
    }
}
