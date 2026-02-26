package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class fv {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f2844b = TimeUnit.DAYS.toMillis(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f2845a;

    public fv(Context context, String str, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.event_data_validator" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f2845a = sharedPreferences;
        a();
    }

    public final void a() {
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        for (Map.Entry<String, ?> entry : this.f2845a.getAll().entrySet()) {
            try {
                Object value = entry.getValue();
                kotlin.jvm.internal.t.g(value, "null cannot be cast to non-null type kotlin.Long");
                if (jNowInMilliseconds >= ((Long) value).longValue()) {
                    String key = entry.getKey();
                    kotlin.jvm.internal.t.h(key, "entry.key");
                    this.f2845a.edit().remove(key).apply();
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new dv(entry), 4, (Object) null);
                String key2 = entry.getKey();
                kotlin.jvm.internal.t.h(key2, "entry.key");
                this.f2845a.edit().remove(key2).apply();
            }
        }
    }

    public final boolean a(e00 event) throws JSONException {
        kotlin.jvm.internal.t.i(event, "event");
        ba baVar = (ba) event;
        if (baVar.f2431a != lx.PUSH_CLICKED) {
            return true;
        }
        a();
        kotlin.jvm.internal.t.i(event, "event");
        int i10 = n60.f3470j;
        kotlin.jvm.internal.t.i(event, "event");
        String string = baVar.f2432b.getString(CmcdConfiguration.KEY_CONTENT_ID);
        kotlin.jvm.internal.t.h(string, "event.data.getString(IBrazeEvent.DATA_CAMPAIGN_ID)");
        String eventKey = baVar.f2431a + string;
        if (this.f2845a.contains(eventKey)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ev(event), 7, (Object) null);
            return false;
        }
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds() + f2844b;
        kotlin.jvm.internal.t.i(eventKey, "eventKey");
        this.f2845a.edit().putLong(eventKey, jNowInMilliseconds).apply();
        return true;
    }
}
