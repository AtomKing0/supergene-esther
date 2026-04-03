package bo.app;

import com.braze.models.IPutIntoJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ea0 implements IPutIntoJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2719b;

    public ea0(String log, long j10) {
        kotlin.jvm.internal.t.i(log, "log");
        this.f2718a = log;
        this.f2719b = j10;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        return new JSONObject().put("log", this.f2718a).put("time", this.f2719b);
    }
}
