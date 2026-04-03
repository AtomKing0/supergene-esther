package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zq extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final sq f4469f = new sq();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BrazeConfigurationProvider f4470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f4471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f4472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public nq f4473e;

    public /* synthetic */ zq(Context context) {
        this(context, null, null);
    }

    @Override // bo.app.f
    public final void b(Object obj, boolean z10) {
        String str = JsonUtils.EMPTY_JSON;
        nq outboundObject = (nq) obj;
        kotlin.jvm.internal.t.i(outboundObject, "outboundObject");
        if (z10) {
            try {
                String string = this.f4471c.getString("cached_device", JsonUtils.EMPTY_JSON);
                if (string != null) {
                    str = string;
                }
                this.f4471c.edit().putString("cached_device", com.braze.support.JsonUtils.mergeJsonObjects(new JSONObject(str), outboundObject.forJsonPut()).toString()).apply();
                this.f4472d.edit().putBoolean("sfone", false).putInt("ldov", Build.VERSION.SDK_INT).apply();
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) tq.f3963a, 4, (Object) null);
            }
        }
    }

    public final void c() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) uq.f4036a, 6, (Object) null);
        this.f4472d.edit().putBoolean("sfone", true).apply();
    }

    public zq(Context context, String str, String str2) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f4470b = new BrazeConfigurationProvider(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.device_cache.v3" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.f4471c = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.storage.device_cache.metadata" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        kotlin.jvm.internal.t.h(sharedPreferences2, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.f4472d = sharedPreferences2;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    @Override // bo.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b() {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.zq.b():java.lang.Object");
    }
}
