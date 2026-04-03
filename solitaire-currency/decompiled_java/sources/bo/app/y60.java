package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class y60 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f4327b = TimeUnit.DAYS.toSeconds(45);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4328a;

    public y60(Context context, String str, String str2) {
        kotlin.jvm.internal.t.i(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.push_identifier_storage" + StringUtils.getCacheFileSuffix(context, str2, str), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.f4328a = sharedPreferences;
        a();
    }

    public final void a() {
        long jNowInSeconds = DateTimeUtils.nowInSeconds() - f4327b;
        SharedPreferences.Editor editorEdit = this.f4328a.edit();
        Map<String, ?> all = this.f4328a.getAll();
        kotlin.jvm.internal.t.h(all, "storagePrefs.all");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            Long l10 = (Long) entry.getValue();
            if (l10 == null || l10.longValue() < jNowInSeconds) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new v60(entry, jNowInSeconds), 6, (Object) null);
                editorEdit.remove(entry.getKey());
            }
        }
        editorEdit.apply();
    }

    public final boolean a(String pushId) {
        kotlin.jvm.internal.t.i(pushId, "pushId");
        if (p9.q.z(pushId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) w60.f4170a, 7, (Object) null);
            return true;
        }
        kotlin.jvm.internal.t.i(pushId, "pushId");
        if (this.f4328a.contains(pushId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new x60(pushId), 7, (Object) null);
            return false;
        }
        a();
        kotlin.jvm.internal.t.i(pushId, "pushId");
        this.f4328a.edit().putLong(pushId, DateTimeUtils.nowInSeconds()).apply();
        return true;
    }
}
