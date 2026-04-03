package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class yf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v00 f4357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb0 f4358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f4359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4360d;

    public yf(Context applicationContext, vw eventPublisher, vb0 serverConfigStorageProvider) {
        kotlin.jvm.internal.t.i(applicationContext, "applicationContext");
        kotlin.jvm.internal.t.i(eventPublisher, "eventPublisher");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        this.f4357a = eventPublisher;
        this.f4358b = serverConfigStorageProvider;
        this.f4359c = applicationContext.getSharedPreferences("com.appboy.storage.sessions.messaging_session", 0);
    }

    public final void a() {
        long jNowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new xf(jNowInSeconds), 7, (Object) null);
        this.f4359c.edit().putLong("messaging_session_timestamp", jNowInSeconds).apply();
        this.f4360d = false;
    }
}
