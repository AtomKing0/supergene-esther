package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f70 extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f2778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f2780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k00 f2781m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f70(vb0 serverConfigStorageProvider, String urlBase, String str, ArrayList campaignIds, long j10, List dedupeIds) {
        super(new b90(urlBase + "push/redeliver"), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(campaignIds, "campaignIds");
        kotlin.jvm.internal.t.i(dedupeIds, "dedupeIds");
        this.f2778j = campaignIds;
        this.f2779k = j10;
        this.f2780l = dedupeIds;
        this.f2781m = k00.PUSH_REDELIVER;
    }

    @Override // bo.app.l00
    public final boolean a() {
        return false;
    }

    @Override // bo.app.tg, bo.app.l00
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        if (jSONObjectB == null) {
            return null;
        }
        try {
            String str = this.f3941b;
            if (str != null && !p9.q.z(str)) {
                jSONObjectB.put("user_id", this.f3941b);
            }
            jSONObjectB.put("campaign_ids", new JSONArray((Collection) this.f2778j));
            jSONObjectB.put("last_sync_at", this.f2779k);
            if (!this.f2780l.isEmpty()) {
                jSONObjectB.put("dedupe_ids", new JSONArray((Collection) this.f2780l));
            }
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) e70.f2712a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f2781m;
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(v00 internalPublisher, v00 externalPublisher, s50 apiResponse) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) d70.f2628a, 7, (Object) null);
        long j10 = apiResponse.f3830n;
        if (j10 != -1) {
            ((vw) internalPublisher).b(c70.class, new c70(j10));
        }
    }
}
