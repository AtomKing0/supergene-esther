package bo.app;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o60 extends ba {
    /* JADX WARN: Illegal instructions before constructor call */
    public o60(String campaignId, long j10) throws JSONException {
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        LinkedHashMap linkedHashMap = lx.f3353b;
        JSONObject jSONObjectPut = new JSONObject().put(CmcdConfiguration.KEY_CONTENT_ID, campaignId);
        kotlin.jvm.internal.t.h(jSONObjectPut, "JSONObject().put(IBrazeE…_CAMPAIGN_ID, campaignId)");
        this(jSONObjectPut, j10);
    }

    public o60(JSONObject jSONObject, double d10) {
        super(lx.PUSH_DELIVERY_EVENT, jSONObject, d10, 8);
    }
}
