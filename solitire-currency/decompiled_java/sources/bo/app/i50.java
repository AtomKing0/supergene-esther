package bo.app;

import com.braze.models.IPutIntoJson;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i50 implements IPutIntoJson, u00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3022b;

    public i50(long j10, boolean z10) {
        this.f3021a = j10;
        this.f3022b = z10;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("config_time", this.f3021a);
        return jSONObject;
    }

    @Override // bo.app.u00
    public final boolean isEmpty() {
        return !this.f3022b;
    }
}
