package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class uh0 extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z00 f4020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ka0 f4021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f4022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedPreferences f4023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4024f;

    public /* synthetic */ uh0(Context context, z00 z00Var, ka0 ka0Var) {
        this(context, z00Var, ka0Var, null, null);
    }

    public final synchronized void a(NotificationSubscriptionType notificationSubscriptionType) {
        b("push_subscribe", notificationSubscriptionType != null ? notificationSubscriptionType.forJsonPut() : null);
    }

    @Override // bo.app.f
    public final void b(Object obj, boolean z10) {
        l50 outboundObject = (l50) obj;
        kotlin.jvm.internal.t.i(outboundObject, "outboundObject");
        JSONObject jSONObject = outboundObject.f3305a;
        if (z10) {
            if (jSONObject.has("push_token")) {
                this.f4023e.edit().putString("push_token", jSONObject.optString("push_token")).apply();
                return;
            }
            return;
        }
        JSONObject jSONObjectC = c();
        JSONObject jSONObjectPlus = JsonUtils.plus(jSONObject, jSONObjectC);
        jSONObjectPlus.remove("push_token");
        JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject("custom");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("custom");
        try {
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) mh0.f3427a, 4, (Object) null);
        }
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
            jSONObjectPlus.put("custom", JsonUtils.plus(jSONObjectOptJSONObject2, jSONObjectOptJSONObject));
        } else {
            if (jSONObjectOptJSONObject == null) {
                if (jSONObjectOptJSONObject2 != null) {
                    jSONObjectPlus.put("custom", jSONObjectOptJSONObject2);
                }
                this.f4022d.edit().putString("user_cache_attributes_object", jSONObjectPlus.toString()).apply();
            }
            jSONObjectPlus.put("custom", jSONObjectOptJSONObject);
        }
        this.f4022d.edit().putString("user_cache_attributes_object", jSONObjectPlus.toString()).apply();
    }

    public final JSONObject c() {
        String string = this.f4022d.getString("user_cache_attributes_object", null);
        if (string == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new ph0(string), 4, (Object) null);
            return new JSONObject();
        }
    }

    public final synchronized void d() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) nh0.f3490a, 6, (Object) null);
        this.f4023e.edit().clear().apply();
    }

    public uh0(Context context, z00 pushRegistrationDataProvider, ka0 sdkEnablementProvider, String str, String str2) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(pushRegistrationDataProvider, "pushRegistrationDataProvider");
        kotlin.jvm.internal.t.i(sdkEnablementProvider, "sdkEnablementProvider");
        this.f4020b = pushRegistrationDataProvider;
        this.f4021c = sdkEnablementProvider;
        this.f4024f = str;
        String cacheFileSuffix = StringUtils.getCacheFileSuffix(context, str, str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.user_cache.v3" + cacheFileSuffix, 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f4022d = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.storage.user_cache.push_token_store" + cacheFileSuffix, 0);
        kotlin.jvm.internal.t.h(sharedPreferences2, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f4023e = sharedPreferences2;
    }

    public final boolean a(JSONObject jSONObject) {
        if (this.f4021c.f3236a.getBoolean("appboy_sdk_disabled", false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) rh0.f3790a, 6, (Object) null);
            return false;
        }
        this.f4022d.edit().putString("user_cache_attributes_object", jSONObject.toString()).apply();
        return true;
    }

    public final boolean a(String key, Object obj) {
        JSONObject jSONObject;
        Object obj2;
        kotlin.jvm.internal.t.i(key, "key");
        JSONObject jSONObjectC = c();
        if (jSONObjectC.has("custom")) {
            try {
                jSONObject = jSONObjectC.getJSONObject("custom");
                kotlin.jvm.internal.t.h(jSONObject, "userObjectFromCache.getJ…OM_ATTRIBUTES_OBJECT_KEY)");
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) lh0.f3336a, 4, (Object) null);
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = new JSONObject();
        }
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) new sh0(key, obj), 4, (Object) null);
                return false;
            }
        } else {
            obj2 = obj;
        }
        jSONObject.put(key, obj2);
        return b("custom", jSONObject);
    }

    @Override // bo.app.f
    public final Object b() {
        StringUtils.ifNonEmpty(this.f4024f, new oh0(this));
        JSONObject outboundJson = c();
        kotlin.jvm.internal.t.i(outboundJson, "outboundJson");
        try {
            String strA = ((i70) this.f4020b).a();
            if (strA == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) jh0.f3160a, 7, (Object) null);
            } else if (!kotlin.jvm.internal.t.d(strA, this.f4023e.getString("push_token", null))) {
                outboundJson.put("push_token", strA);
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) kh0.f3252a, 4, (Object) null);
        }
        this.f4022d.edit().clear().apply();
        return new l50(outboundJson);
    }

    public final boolean b(String str, Object obj) {
        Object obj2;
        JSONObject jSONObjectC = c();
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new th0(str, obj), 4, (Object) null);
                return false;
            }
        } else {
            obj2 = obj;
        }
        jSONObjectC.put(str, obj2);
        return a(jSONObjectC);
    }
}
