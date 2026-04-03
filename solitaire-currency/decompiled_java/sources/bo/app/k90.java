package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f3233d;

    public k90(Context context, String str, String str2) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f3230a = context;
        this.f3231b = str;
        this.f3232c = str2;
        this.f3233d = context.getSharedPreferences("com.braze.storage.sdk_auth_cache" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
    }

    public final void a(String str) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new j90(str), 6, (Object) null);
        this.f3233d.edit().putString("auth_signature", str).apply();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k90)) {
            return false;
        }
        k90 k90Var = (k90) obj;
        return kotlin.jvm.internal.t.d(this.f3230a, k90Var.f3230a) && kotlin.jvm.internal.t.d(this.f3231b, k90Var.f3231b) && kotlin.jvm.internal.t.d(this.f3232c, k90Var.f3232c);
    }

    public final int hashCode() {
        int iHashCode = this.f3230a.hashCode() * 31;
        String str = this.f3231b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3232c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SdkAuthenticationCache(context=");
        sb.append(this.f3230a);
        sb.append(", userId=");
        sb.append(this.f3231b);
        sb.append(", apiKey=");
        return h1.a(sb, this.f3232c, ')');
    }
}
