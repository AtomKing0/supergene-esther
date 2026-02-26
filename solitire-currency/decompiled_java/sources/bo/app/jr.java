package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.StringUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class jr implements p00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v8.l f3175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f3176b;

    public jr(Context context, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        this.f3175a = v8.n.a(new ir(context));
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.device_id" + StringUtils.getCacheFileSuffix(context, null, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f3176b = sharedPreferences;
    }

    public final String a() {
        String string = this.f3176b.getString("device_id", null);
        if (string == null) {
            Object value = this.f3175a.getValue();
            kotlin.jvm.internal.t.h(value, "<get-nonPartitionedDeviceIdPrefs>(...)");
            string = ((SharedPreferences) value).getString("device_id", null);
            Object value2 = this.f3175a.getValue();
            kotlin.jvm.internal.t.h(value2, "<get-nonPartitionedDeviceIdPrefs>(...)");
            ((SharedPreferences) value2).edit().clear().apply();
        }
        if ((this.f3176b.contains("persistent_device_id") && (!kotlin.jvm.internal.t.d(this.f3176b.getString("persistent_device_id", null), String.valueOf(722989291)))) || string == null) {
            string = UUID.randomUUID().toString();
            kotlin.jvm.internal.t.h(string, "randomUUID().toString()");
        }
        this.f3176b.edit().putString("persistent_device_id", String.valueOf(722989291)).putString("device_id", string).apply();
        return string;
    }
}
