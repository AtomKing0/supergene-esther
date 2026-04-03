package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.ac0;
import bo.app.rc;
import com.braze.enums.GeofenceTransitionType;
import com.braze.events.IEventSubscriber;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class rc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f3764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f3765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f3766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3770h;

    public rc(Context context, String apiKey, vb0 serverConfigStorageProvider, v00 internalIEventMessenger) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(internalIEventMessenger, "internalIEventMessenger");
        ((vw) internalIEventMessenger).c(new IEventSubscriber() { // from class: i.e0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                rc.a(this.f26532a, (ac0) obj);
            }
        }, ac0.class);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.managers.geofences.eligibility.global." + apiKey, 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f3763a = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.appboy.managers.geofences.eligibility.individual." + apiKey, 0);
        kotlin.jvm.internal.t.h(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f3764b = sharedPreferences2;
        this.f3765c = a(sharedPreferences2);
        this.f3766d = new AtomicBoolean(false);
        this.f3767e = sharedPreferences.getLong("last_request_global", 0L);
        this.f3768f = sharedPreferences.getLong("last_report_global", 0L);
        this.f3769g = serverConfigStorageProvider.n();
        this.f3770h = serverConfigStorageProvider.m();
    }

    public static final void a(rc this$0, ac0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.f3766d.set(false);
    }

    public final ConcurrentHashMap a(SharedPreferences sharedPreferences) {
        kotlin.jvm.internal.t.i(sharedPreferences, "sharedPreferences");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && !all.isEmpty()) {
            Set<String> setKeySet = all.keySet();
            if (setKeySet.isEmpty()) {
                return concurrentHashMap;
            }
            for (String reEligibilityId : setKeySet) {
                long j10 = sharedPreferences.getLong(reEligibilityId, 0L);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new cc(this, reEligibilityId), 7, (Object) null);
                Long lValueOf = Long.valueOf(j10);
                kotlin.jvm.internal.t.h(reEligibilityId, "reEligibilityId");
                concurrentHashMap.put(reEligibilityId, lValueOf);
            }
        }
        return concurrentHashMap;
    }

    public final boolean a(long j10, BrazeGeofence geofence, GeofenceTransitionType transitionType) {
        kotlin.jvm.internal.t.i(geofence, "geofence");
        kotlin.jvm.internal.t.i(transitionType, "transitionType");
        String geofenceId = geofence.getId();
        long j11 = j10 - this.f3768f;
        if (this.f3770h > j11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new dc(j11, this, geofenceId), 7, (Object) null);
            return false;
        }
        kotlin.jvm.internal.t.i(geofenceId, "geofenceId");
        kotlin.jvm.internal.t.i(transitionType, "transitionType");
        StringBuilder sb = new StringBuilder();
        String string = transitionType.toString();
        Locale US = Locale.US;
        kotlin.jvm.internal.t.h(US, "US");
        String lowerCase = string.toLowerCase(US);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        sb.append('_');
        sb.append(geofenceId);
        String string2 = sb.toString();
        int cooldownEnterSeconds = transitionType == GeofenceTransitionType.ENTER ? geofence.getCooldownEnterSeconds() : geofence.getCooldownExitSeconds();
        if (this.f3765c.containsKey(string2)) {
            Long l10 = (Long) this.f3765c.get(string2);
            if (l10 != null) {
                long jLongValue = j10 - l10.longValue();
                if (cooldownEnterSeconds > jLongValue) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ec(jLongValue, cooldownEnterSeconds, geofenceId, transitionType), 7, (Object) null);
                    return false;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new fc(jLongValue, cooldownEnterSeconds, geofenceId, transitionType), 7, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new gc(geofenceId, transitionType), 7, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new hc(j11, this, geofenceId), 7, (Object) null);
        this.f3765c.put(string2, Long.valueOf(j10));
        this.f3764b.edit().putLong(string2, j10).apply();
        this.f3768f = j10;
        this.f3763a.edit().putLong("last_report_global", j10).apply();
        return true;
    }

    public final String a(String reEligibilityId) {
        kotlin.jvm.internal.t.i(reEligibilityId, "reEligibilityId");
        try {
            return new p9.f("_").d(reEligibilityId, 2).get(1);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new nc(reEligibilityId), 4, (Object) null);
            return null;
        }
    }

    public final void a(long j10) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new qc(j10), 7, (Object) null);
        this.f3767e = j10;
        this.f3763a.edit().putLong("last_request_global", this.f3767e).apply();
    }
}
