package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f2704a;

    public e50(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.offline.storagemap", 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f2704a = sharedPreferences;
    }

    public final String a() {
        String string = this.f2704a.getString("last_user", "");
        String str = string != null ? string : "";
        if (StringUtils.getByteSize(str) <= 997) {
            return str;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new b50(str), 6, (Object) null);
        String strTruncateToByteLength = StringUtils.truncateToByteLength(str, 997);
        a(strTruncateToByteLength);
        return strTruncateToByteLength;
    }

    public final void a(String userId) {
        kotlin.jvm.internal.t.i(userId, "userId");
        if (userId.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) c50.f2484a, 6, (Object) null);
        } else {
            if (StringUtils.getByteSize(userId) > 997) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new d50(userId), 6, (Object) null);
                return;
            }
            SharedPreferences.Editor editorEdit = this.f2704a.edit();
            editorEdit.putString("last_user", userId);
            editorEdit.apply();
        }
    }
}
