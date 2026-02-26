package bo.app;

import com.braze.support.BrazeLogger;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class mn extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k00 f3438m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mn(vb0 serverConfigStorageProvider, String urlBase, long j10, long j11, String str, int i10) {
        super(new b90(urlBase + "content_cards/sync"), str, serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        this.f3435j = j10;
        this.f3436k = j11;
        this.f3437l = i10;
        this.f3438m = k00.CONTENT_CARD_SYNC;
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
            jSONObjectB.put("last_full_sync_at", this.f3436k);
            jSONObjectB.put("last_card_updated_at", this.f3435j);
            String str = this.f3941b;
            if (str != null && !p9.q.z(str)) {
                jSONObjectB.put("user_id", this.f3941b);
            }
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) ln.f3343a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f3438m;
    }

    @Override // bo.app.tg, bo.app.l00
    public final void a(HashMap existingHeaders) {
        kotlin.jvm.internal.t.i(existingHeaders, "existingHeaders");
        super.a(existingHeaders);
        existingHeaders.put("X-Braze-DataRequest", com.ironsource.mediationsdk.metadata.a.f13688g);
        existingHeaders.put("X-Braze-ContentCardsRequest", com.ironsource.mediationsdk.metadata.a.f13688g);
        existingHeaders.put("BRAZE-SYNC-RETRY-COUNT", String.valueOf(this.f3437l));
    }
}
