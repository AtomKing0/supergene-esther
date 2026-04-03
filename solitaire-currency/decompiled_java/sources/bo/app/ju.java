package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ju {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3179a;

    public ju(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("persistent.com.braze.requests.metadata.last_req_at", 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…LE, Context.MODE_PRIVATE)");
        this.f3179a = sharedPreferences;
    }

    public final long a(b90 target) {
        kotlin.jvm.internal.t.i(target, "target");
        String str = "uri-" + target.f2425a.hashCode();
        long j10 = this.f3179a.getLong(str, 0L);
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        this.f3179a.edit().putLong(str, jNowInMilliseconds).apply();
        return Math.min(jNowInMilliseconds - j10, 7200000L);
    }

    public final long b(b90 target) {
        kotlin.jvm.internal.t.i(target, "target");
        String str = "uri-at-" + target.f2425a.hashCode();
        long j10 = this.f3179a.getLong(str, 1L);
        this.f3179a.edit().putLong(str, 1 + j10).apply();
        return j10;
    }

    public final void c(b90 target) {
        kotlin.jvm.internal.t.i(target, "target");
        this.f3179a.edit().putLong("uri-at-" + target.f2425a.hashCode(), 1L).apply();
    }
}
