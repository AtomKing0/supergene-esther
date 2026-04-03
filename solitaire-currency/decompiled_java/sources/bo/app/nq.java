package bo.app;

import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.DeviceKey;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class nq implements IPutIntoJson, u00 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final lq f3502n = new lq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BrazeConfigurationProvider f3503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f3511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f3512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f3514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3515m;

    public nq(BrazeConfigurationProvider configurationProvider, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, Boolean bool3) {
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        this.f3503a = configurationProvider;
        this.f3504b = str;
        this.f3505c = str2;
        this.f3506d = str3;
        this.f3507e = str4;
        this.f3508f = str5;
        this.f3509g = str6;
        this.f3510h = str7;
        this.f3511i = bool;
        this.f3512j = bool2;
        this.f3513k = str8;
        this.f3514l = bool3;
    }

    @Override // bo.app.u00
    public final boolean isEmpty() {
        return forJsonPut().length() == 0;
    }

    @Override // com.braze.models.IPutIntoJson
    public final JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            lq lqVar = f3502n;
            lqVar.a(this.f3503a, jSONObject, DeviceKey.ANDROID_VERSION, this.f3504b);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.CARRIER, this.f3505c);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.BRAND, this.f3506d);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.MODEL, this.f3507e);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.RESOLUTION, this.f3510h);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.LOCALE, this.f3508f);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.NOTIFICATIONS_ENABLED, this.f3511i);
            lqVar.a(this.f3503a, jSONObject, DeviceKey.IS_BACKGROUND_RESTRICTED, this.f3512j);
            String str = this.f3513k;
            if (str != null && !p9.q.z(str)) {
                lqVar.a(this.f3503a, jSONObject, DeviceKey.GOOGLE_ADVERTISING_ID, this.f3513k);
            }
            Boolean bool = this.f3514l;
            if (bool != null) {
                lqVar.a(this.f3503a, jSONObject, DeviceKey.AD_TRACKING_ENABLED, bool);
            }
            String str2 = this.f3509g;
            if (str2 != null && !p9.q.z(str2)) {
                lqVar.a(this.f3503a, jSONObject, DeviceKey.TIMEZONE, this.f3509g);
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) mq.f3445a, 4, (Object) null);
        }
        return jSONObject;
    }
}
