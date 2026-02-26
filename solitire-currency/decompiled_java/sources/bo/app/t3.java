package bo.app;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.braze.Braze;
import com.braze.support.BrazeLogger;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class t3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f3890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f3892d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t3(String str, Braze braze, String str2, String str3) {
        super(0);
        this.f3889a = str;
        this.f3890b = braze;
        this.f3891c = str2;
        this.f3892d = str3;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        String str = this.f3889a;
        if (str == null || p9.q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3890b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) q3.f3680a, 6, (Object) null);
        } else {
            String str2 = this.f3891c;
            if (str2 == null || p9.q.z(str2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3890b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) r3.f3744a, 6, (Object) null);
            } else {
                String str3 = this.f3892d;
                if (str3 == null || p9.q.z(str3)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3890b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) s3.f3818a, 6, (Object) null);
                } else {
                    tf tfVar = ((ci0) this.f3890b.getUdm$android_sdk_base_release()).f2570v;
                    int i10 = k60.f3219j;
                    String campaignId = this.f3889a;
                    String actionId = this.f3891c;
                    String actionType = this.f3892d;
                    kotlin.jvm.internal.t.i(campaignId, "campaignId");
                    kotlin.jvm.internal.t.i(actionId, "actionId");
                    kotlin.jvm.internal.t.i(actionType, "actionType");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, campaignId);
                    jSONObject.put(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, actionId);
                    LinkedHashMap linkedHashMap = lx.f3353b;
                    tfVar.a(new k60(jSONObject, actionType));
                }
            }
        }
        return v8.k0.f35197a;
    }
}
