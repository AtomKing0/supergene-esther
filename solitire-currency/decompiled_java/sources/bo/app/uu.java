package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class uu {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4042k = BrazeLogger.getBrazeLogTag((Class<?>) uu.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k00 f4043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cs f4044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d10 f4047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f4048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ox f4051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public rd0 f4052j;

    public uu(k00 destination, cs dispatchDataProvider) {
        kotlin.jvm.internal.t.i(destination, "destination");
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
        this.f4043a = destination;
        this.f4044b = dispatchDataProvider;
        this.f4048f = new ArrayList();
        int iOrdinal = destination.ordinal();
        this.f4050h = iOrdinal != 0 ? iOrdinal != 2 ? 0L : 75L : 25L;
        this.f4051i = new ox(c().e(), c().f(), c().g());
    }

    public ox a() {
        return this.f4051i;
    }

    public abstract void a(long j10);

    public final rd0 b() throws NoSuchAlgorithmException {
        Map mapQ;
        vb0 vb0VarC = c();
        ReentrantLock reentrantLock = vb0VarC.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = vb0VarC.f4107d;
            if (fb0Var == null || (mapQ = fb0Var.E) == null) {
                mapQ = vb0VarC.q();
            }
            reentrantLock.unlock();
            ra0 ra0Var = (ra0) mapQ.get(this.f4043a);
            if (ra0Var == null) {
                this.f4052j = null;
                return null;
            }
            rd0 rd0Var = this.f4052j;
            int i10 = ra0Var.f3760b;
            int i11 = ra0Var.f3759a;
            if (rd0Var == null) {
                cs dispatchDataProvider = this.f4044b;
                String specificName = String.valueOf(this.f4043a.hashCode());
                kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
                kotlin.jvm.internal.t.i("com.braze.endpointqueue.tokenbucket", "filePrefix");
                kotlin.jvm.internal.t.i(specificName, "specificName");
                ci0 ci0Var = (ci0) dispatchDataProvider.f2596a;
                Context context = ci0Var.f2549a;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.endpointqueue.tokenbucket." + specificName + StringUtils.getCacheFileSuffix(context, ci0Var.f2554f, ci0Var.f2555g), 0);
                kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ODE_PRIVATE\n            )");
                rd0Var = new rd0(i11, i10, sharedPreferences);
            } else if (i11 >= 1 && i10 >= 1 && (rd0Var.f3773a != i11 || rd0Var.f3774b != i10)) {
                rd0Var.f3773a = i11;
                rd0Var.f3774b = i10;
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) rd0Var, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new qd0(i11, i10), 6, (Object) null);
            }
            this.f4052j = rd0Var;
            return rd0Var;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final vb0 c() {
        return ((ci0) this.f4044b.f2596a).f2556h;
    }

    public boolean d() {
        return false;
    }

    public void a(long j10, z80 requestInfo, n apiResponse) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        Long l10 = apiResponse.f3459b;
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        this.f4045c = j10;
        s50 s50Var = apiResponse instanceof s50 ? (s50) apiResponse : null;
        this.f4047e = s50Var != null ? s50Var.f3820d : null;
        ox oxVarA = a();
        int i10 = oxVarA.f3587b;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) oxVarA, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new mx(oxVarA), 7, (Object) null);
        l9.c random = oxVarA.f3590e;
        int i11 = oxVarA.f3591f * oxVarA.f3589d;
        kotlin.jvm.internal.t.i(random, "random");
        int iMin = Math.min(i10, i11) + random.d(Math.abs(i10 - i11) + 1);
        oxVarA.f3591f = Math.max(oxVarA.f3588c, Math.min(oxVarA.f3586a, iMin));
        BrazeLogger.brazelog$default(brazeLogger, (Object) oxVarA, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new nx(oxVarA, i10, iMin), 7, (Object) null);
        this.f4049g = jLongValue + j10 + ((long) oxVarA.f3591f);
        BrazeLogger.brazelog$default(brazeLogger, f4042k, (BrazeLogger.Priority) null, (Throwable) null, d(), (h9.a) new ru(j10, this), 6, (Object) null);
    }

    public final String c(long j10) {
        String string;
        String strR0 = kotlin.collections.d0.r0(this.f4048f, "\n\n", null, null, 0, null, new tu(j10), 30, null);
        StringBuilder sb = new StringBuilder("\n            |EndpointQueue: ");
        sb.append(this.f4043a);
        sb.append("\n            |   lastFailureAt = ");
        sb.append(this.f4045c - j10);
        sb.append("\n            |   lastSuccessAt = ");
        sb.append(this.f4046d - j10);
        sb.append("\n            |   failureBackoffUntil = ");
        sb.append(this.f4049g - j10);
        sb.append("\n            |   lastResponseError = ");
        sb.append(this.f4047e);
        sb.append("\n            |   pendingWaitDuration = ");
        sb.append(this.f4050h);
        sb.append("\n            |   endpointRateLimiter = ");
        rd0 rd0Var = this.f4052j;
        if (rd0Var == null || (string = rd0Var.toString()) == null) {
            string = "unset";
        }
        sb.append(string);
        sb.append("\n            |   requestInfoQueue: \n            |");
        sb.append(strR0);
        sb.append("\n        ");
        return p9.j.h(sb.toString(), null, 1, null);
    }

    public void a(long j10, z80 requestInfo, s50 apiResponse) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        a().f3591f = 0;
        this.f4046d = j10;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f4042k, (BrazeLogger.Priority) null, (Throwable) null, d(), (h9.a) new su(j10, this), 6, (Object) null);
    }

    public final void b(long j10) {
        ArrayList arrayList = this.f4048f;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            a90 a90Var = ((z80) obj).f4413d;
            if (a90Var == a90.PENDING_START || a90Var == a90.PENDING_RETRY) {
                arrayList2.add(obj);
            }
        }
        List listI0 = kotlin.collections.d0.I0(arrayList2, new nu());
        if (listI0.size() >= 2) {
            int size = listI0.size();
            for (int i10 = 1; i10 < size; i10++) {
                z80 z80Var = (z80) listI0.get(i10);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f4042k, (BrazeLogger.Priority) null, (Throwable) null, d(), (h9.a) new ou(z80Var), 6, (Object) null);
                z80Var.a(j10, a90.BATCHED);
            }
        }
    }
}
