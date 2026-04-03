package bo.app;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.managers.BrazeGeofenceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class ci0 implements l10 {
    public final xy A;
    public final kn B;
    public final iu C;
    public final cs D;
    public final v80 E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BrazeConfigurationProvider f2550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p00 f2551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s60 f2552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o00 f2553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vb0 f2556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public uh0 f2557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zq f2558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final vw f2559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final xs f2560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final iw f2561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final zo f2562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ci f2563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final kx f2564p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b70 f2565q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k90 f2566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final yf f2567s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y60 f2568t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final la0 f2569u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final tf f2570v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final cg0 f2571w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final BrazeGeofenceManager f2572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final zd f2573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final gy f2574z;

    public ci0(Context applicationContext, e50 offlineUserStorageProvider, BrazeConfigurationProvider configurationProvider, v00 externalEventPublisher, p00 deviceIdProvider, z00 registrationDataProvider, s60 pushDeliveryManager, boolean z10, boolean z11, o00 deviceDataProvider, boolean z12) {
        kotlin.jvm.internal.t.i(applicationContext, "applicationContext");
        kotlin.jvm.internal.t.i(offlineUserStorageProvider, "offlineUserStorageProvider");
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        kotlin.jvm.internal.t.i(externalEventPublisher, "externalEventPublisher");
        kotlin.jvm.internal.t.i(deviceIdProvider, "deviceIdProvider");
        kotlin.jvm.internal.t.i(registrationDataProvider, "registrationDataProvider");
        kotlin.jvm.internal.t.i(pushDeliveryManager, "pushDeliveryManager");
        kotlin.jvm.internal.t.i(deviceDataProvider, "deviceDataProvider");
        this.f2549a = applicationContext;
        this.f2550b = configurationProvider;
        this.f2551c = deviceIdProvider;
        this.f2552d = pushDeliveryManager;
        this.f2553e = deviceDataProvider;
        this.f2554f = offlineUserStorageProvider.a();
        this.f2555g = g().getBrazeApiKey().toString();
        ka0 ka0Var = new ka0(b());
        ju juVar = new ju(b());
        this.f2556h = new vb0(b(), a());
        this.f2559k = new vw(ka0Var, true);
        vb0 vb0VarV = v();
        this.f2560l = new xs(b(), p(), vb0VarV, q(), a());
        vb0 vb0VarV2 = v();
        new w90(b(), p(), vb0VarV2);
        cv cvVar = new cv(new tc0(b(), q(), a()), p());
        this.f2562n = new zo(b(), p(), new ao(b()));
        Context contextB = b();
        vw vwVarP = p();
        Object systemService = b().getSystemService(NotificationCompat.CATEGORY_ALARM);
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        this.f2563o = new ci(contextB, cvVar, vwVarP, externalEventPublisher, (AlarmManager) systemService, g().getSessionTimeoutSeconds(), g().isSessionStartBasedTimeoutEnabled());
        this.f2564p = new kx(new ex(new pc0(b(), q(), a()), p()));
        this.f2565q = new b70(b(), p(), v(), a(), q());
        this.f2566r = new k90(b(), q(), a());
        this.f2567s = new yf(b(), p(), v());
        this.f2568t = new y60(b(), a(), q());
        this.f2569u = new la0(b(), q(), a());
        this.f2570v = new tf(b(), q(), a(), f(), p(), g(), v(), l(), e(), ka0Var, t(), r(), s());
        this.f2571w = new cg0(b(), d(), p(), externalEventPublisher, g(), q(), a());
        this.f2572x = new BrazeGeofenceManager(b(), a(), d(), g(), v(), p());
        this.f2573y = new zd(b(), d(), g());
        this.f2574z = new gy(b(), a(), q(), p(), externalEventPublisher, v(), d());
        this.A = new xy(b(), q(), d());
        this.B = new kn(b(), q(), a(), d());
        y70 y70Var = new y70(c00.a(), p(), externalEventPublisher, n(), v(), h(), d(), juVar);
        this.C = new iu(p(), d(), 0);
        this.D = new cs(this);
        this.E = new v80(k(), y70Var, z10, z12);
        if (kotlin.jvm.internal.t.d(q(), "")) {
            a(new uh0(b(), registrationDataProvider, ka0Var));
            a(new zq(b()));
        } else {
            a(new uh0(b(), registrationDataProvider, ka0Var, q(), a()));
            a(new zq(b(), q(), a()));
        }
        i().a(z11);
        this.f2561m = new iw(b(), c(), p(), d(), x(), j(), w(), w().b(), l(), o(), externalEventPublisher, g(), h(), u(), v(), m(), r());
    }

    public final String a() {
        return this.f2555g;
    }

    public final Context b() {
        return this.f2549a;
    }

    public final zd c() {
        return this.f2573y;
    }

    public final h00 d() {
        return this.f2570v;
    }

    public final yf e() {
        return this.f2567s;
    }

    public final ci f() {
        return this.f2563o;
    }

    public final BrazeConfigurationProvider g() {
        return this.f2550b;
    }

    public final kn h() {
        return this.B;
    }

    public final zo i() {
        return this.f2562n;
    }

    public final zq j() {
        zq zqVar = this.f2558j;
        if (zqVar != null) {
            return zqVar;
        }
        kotlin.jvm.internal.t.A("deviceCache");
        return null;
    }

    public final cs k() {
        return this.D;
    }

    public final kx l() {
        return this.f2564p;
    }

    public final gy m() {
        return this.f2574z;
    }

    public final xy n() {
        return this.A;
    }

    public final BrazeGeofenceManager o() {
        return this.f2572x;
    }

    public final vw p() {
        return this.f2559k;
    }

    public final String q() {
        return this.f2554f;
    }

    public final s60 r() {
        return this.f2552d;
    }

    public final y60 s() {
        return this.f2568t;
    }

    public final b70 t() {
        return this.f2565q;
    }

    public final la0 u() {
        return this.f2569u;
    }

    public final vb0 v() {
        return this.f2556h;
    }

    public final cg0 w() {
        return this.f2571w;
    }

    public final uh0 x() {
        uh0 uh0Var = this.f2557i;
        if (uh0Var != null) {
            return uh0Var;
        }
        kotlin.jvm.internal.t.A("userCache");
        return null;
    }

    public final void a(zq zqVar) {
        kotlin.jvm.internal.t.i(zqVar, "<set-?>");
        this.f2558j = zqVar;
    }

    public final void a(uh0 uh0Var) {
        kotlin.jvm.internal.t.i(uh0Var, "<set-?>");
        this.f2557i = uh0Var;
    }
}
