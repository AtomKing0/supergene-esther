package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zg0 implements j10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f4443c;

    public zg0(Context context, String str, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.triggers.re_eligibility" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f4441a = sharedPreferences;
        this.f4442b = a();
        this.f4443c = new LinkedHashMap();
    }

    public final boolean a(k10 triggeredAction) {
        kotlin.jvm.internal.t.i(triggeredAction, "triggeredAction");
        bh0 bh0Var = (bh0) triggeredAction;
        k70 k70Var = bh0Var.f2453b.f2888f;
        if (k70Var.f3223a == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new og0(triggeredAction), 7, (Object) null);
            return true;
        }
        if (!this.f4442b.containsKey(bh0Var.f2452a)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new pg0(triggeredAction), 7, (Object) null);
            return true;
        }
        if (k70Var.f3223a == -1) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new qg0(triggeredAction), 7, (Object) null);
            return false;
        }
        Long l10 = (Long) this.f4442b.get(bh0Var.f2452a);
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        long jNowInSeconds = DateTimeUtils.nowInSeconds() + ((long) bh0Var.f2453b.f2886d);
        int i10 = k70Var.f3223a;
        Integer numValueOf = i10 > 0 ? Integer.valueOf(i10) : null;
        if (jNowInSeconds >= ((long) (numValueOf != null ? numValueOf.intValue() : 0)) + jLongValue) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new rg0(jLongValue, k70Var), 7, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new sg0(jLongValue, k70Var), 7, (Object) null);
        return false;
    }

    public final void b(k10 triggeredAction) {
        kotlin.jvm.internal.t.i(triggeredAction, "triggeredAction");
        bh0 bh0Var = (bh0) triggeredAction;
        if (bh0Var.f2453b.f2888f.f3223a == -1) {
            this.f4442b.remove(bh0Var.f2452a);
            this.f4441a.edit().remove(bh0Var.f2452a).apply();
            return;
        }
        Long l10 = (Long) this.f4443c.get(bh0Var.f2452a);
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new wg0(triggeredAction, jLongValue), 7, (Object) null);
        this.f4442b.put(bh0Var.f2452a, Long.valueOf(jLongValue));
        this.f4441a.edit().putLong(bh0Var.f2452a, jLongValue).apply();
    }

    public final void a(k10 triggeredAction, long j10) {
        kotlin.jvm.internal.t.i(triggeredAction, "triggeredAction");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new tg0(triggeredAction, j10), 7, (Object) null);
        LinkedHashMap linkedHashMap = this.f4443c;
        bh0 bh0Var = (bh0) triggeredAction;
        String str = bh0Var.f2452a;
        Long l10 = (Long) this.f4442b.get(str);
        linkedHashMap.put(str, Long.valueOf(l10 != null ? l10.longValue() : 0L));
        this.f4442b.put(bh0Var.f2452a, Long.valueOf(j10));
        this.f4441a.edit().putLong(bh0Var.f2452a, j10).apply();
    }

    public final ConcurrentHashMap a() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            for (String actionId : this.f4441a.getAll().keySet()) {
                long j10 = this.f4441a.getLong(actionId, 0L);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new xg0(actionId), 7, (Object) null);
                Long lValueOf = Long.valueOf(j10);
                kotlin.jvm.internal.t.h(actionId, "actionId");
                concurrentHashMap.put(actionId, lValueOf);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) yg0.f4365a, 4, (Object) null);
        }
        return concurrentHashMap;
    }
}
