package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class i70 implements z00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BrazeConfigurationProvider f3029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f3030b;

    public i70(Context context, BrazeConfigurationProvider configurationProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        this.f3029a = configurationProvider;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.push_registration", 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f3030b = sharedPreferences;
    }

    public final synchronized String a() {
        int versionCode;
        int i10;
        if ((this.f3029a.isFirebaseCloudMessagingRegistrationEnabled() || this.f3029a.isAdmMessagingRegistrationEnabled()) && this.f3030b.contains("version_code") && (versionCode = this.f3029a.getVersionCode()) != (i10 = this.f3030b.getInt("version_code", Integer.MIN_VALUE))) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new g70(i10, versionCode), 6, (Object) null);
            return null;
        }
        if (this.f3030b.contains("device_identifier")) {
            if (!kotlin.jvm.internal.t.d(String.valueOf(722989291), this.f3030b.getString("device_identifier", ""))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) h70.f2959a, 6, (Object) null);
                return null;
            }
        }
        return this.f3030b.getString("registration_id", null);
    }

    public final synchronized void a(String str) {
        if (str != null) {
            this.f3030b.edit().putString("registration_id", str).putInt("version_code", this.f3029a.getVersionCode()).putString("device_identifier", String.valueOf(722989291)).apply();
        } else {
            throw new NullPointerException("Provided push token is null. Cannot set null push token.");
        }
    }
}
