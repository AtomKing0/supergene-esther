package bo.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import bo.app.ca0;
import bo.app.h90;
import bo.app.ia0;
import bo.app.tf;
import com.braze.BrazeFlushPushDeliveryReceiver;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.b2;
import p9.r;
import v8.s;
import y9.a;

/* JADX INFO: loaded from: classes2.dex */
public final class tf implements h00 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f3918v = {"android.os.deadsystemexception"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ci f3921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v00 f3922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BrazeConfigurationProvider f3923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vb0 f3924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final kx f3925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final yf f3926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ka0 f3927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b70 f3928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s60 f3929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y60 f3930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f3931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f3932n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ReentrantLock f3933o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b2 f3934p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final fv f3935q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile String f3936r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f3937s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f3938t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Class f3939u;

    public tf(Context context, String str, String apiKey, ci sessionManager, vw internalEventPublisher, BrazeConfigurationProvider configurationProvider, vb0 serverConfigStorageProvider, kx eventStorageManager, yf messagingSessionManager, ka0 sdkEnablementProvider, b70 pushMaxManager, s60 pushDeliveryManager, y60 pushIdentifierStorageProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        kotlin.jvm.internal.t.i(sessionManager, "sessionManager");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(eventStorageManager, "eventStorageManager");
        kotlin.jvm.internal.t.i(messagingSessionManager, "messagingSessionManager");
        kotlin.jvm.internal.t.i(sdkEnablementProvider, "sdkEnablementProvider");
        kotlin.jvm.internal.t.i(pushMaxManager, "pushMaxManager");
        kotlin.jvm.internal.t.i(pushDeliveryManager, "pushDeliveryManager");
        kotlin.jvm.internal.t.i(pushIdentifierStorageProvider, "pushIdentifierStorageProvider");
        this.f3919a = context;
        this.f3920b = str;
        this.f3921c = sessionManager;
        this.f3922d = internalEventPublisher;
        this.f3923e = configurationProvider;
        this.f3924f = serverConfigStorageProvider;
        this.f3925g = eventStorageManager;
        this.f3926h = messagingSessionManager;
        this.f3927i = sdkEnablementProvider;
        this.f3928j = pushMaxManager;
        this.f3929k = pushDeliveryManager;
        this.f3930l = pushIdentifierStorageProvider;
        this.f3931m = new AtomicInteger(0);
        this.f3932n = new AtomicInteger(0);
        this.f3933o = new ReentrantLock();
        this.f3934p = kotlinx.coroutines.h2.b(null, 1, null);
        this.f3935q = new fv(context, a(), apiKey);
        this.f3936r = "";
        this.f3937s = new AtomicBoolean(false);
        this.f3938t = new AtomicBoolean(false);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) he.f2976a, 6, (Object) null);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.f0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                tf.a(this.f26533a, (h90) obj);
            }
        }, h90.class);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.g0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                tf.a(this.f26535a, (ca0) obj);
            }
        }, ca0.class);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.h0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                tf.a(this.f26537a, (ia0) obj);
            }
        }, ia0.class);
    }

    public static final void a(tf this$0, h90 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        throw null;
    }

    public final void b() {
        w40 w40Var;
        if (this.f3927i.f3236a.getBoolean("appboy_sdk_disabled", false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) cf.f2508a, 6, (Object) null);
            return;
        }
        ci ciVar = this.f3921c;
        ReentrantLock reentrantLock = ciVar.f2544h;
        reentrantLock.lock();
        try {
            if (ciVar.c() && (w40Var = ciVar.f2548l) != null) {
                ciVar.f2538b.a(w40Var);
            }
            b2.a.a(ciVar.f2547k, null, 1, null);
            ciVar.a();
            ((vw) ciVar.f2539c).b(ec0.class, ec0.f2726a);
            v8.k0 k0Var = v8.k0.f35197a;
            reentrantLock.unlock();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new df(this), 6, (Object) null);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final void a(tf this$0, ca0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, priority, (Throwable) null, false, (h9.a) ie.f3048a, 6, (Object) null);
        if (this$0.f3924f.E()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, priority, (Throwable) null, false, (h9.a) ne.f3482a, 6, (Object) null);
            this$0.a(new ba0(this$0.f3924f, this$0.f3923e.getBaseUrlForRequests(), this$0.f3920b));
        }
    }

    public static final void a(tf this$0, ia0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.D;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, priority, (Throwable) null, true, (h9.a) je.f3152a, 2, (Object) null);
        List list = it.f3040a;
        this$0.getClass();
        if (list.isEmpty()) {
            return;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, priority, (Throwable) null, true, (h9.a) qf.f3707a, 2, (Object) null);
        this$0.a(new ha0(this$0.f3924f, this$0.f3923e.getBaseUrlForRequests(), this$0.f3920b, list));
    }

    public final void a(tg request) {
        kotlin.jvm.internal.t.i(request, "request");
        if (this.f3927i.f3236a.getBoolean("appboy_sdk_disabled", false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ke.f3245a, 6, (Object) null);
            return;
        }
        request.f3941b = this.f3920b;
        v00 v00Var = this.f3922d;
        kotlin.jvm.internal.t.i(request, "request");
        ((vw) v00Var).b(tr.class, new tr(4, null, null, request, 6));
    }

    public final boolean a(Throwable th) {
        ReentrantLock reentrantLock = this.f3933o;
        reentrantLock.lock();
        try {
            this.f3931m.getAndIncrement();
            if (kotlin.jvm.internal.t.d(this.f3936r, th.getMessage()) && this.f3932n.get() > 3 && this.f3931m.get() < 25) {
                reentrantLock.unlock();
                return true;
            }
            if (kotlin.jvm.internal.t.d(this.f3936r, th.getMessage())) {
                this.f3932n.getAndIncrement();
            } else {
                this.f3932n.set(0);
            }
            if (this.f3931m.get() >= 25) {
                this.f3931m.set(0);
            }
            this.f3936r = th.getMessage();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final String a() {
        return this.f3920b;
    }

    public final void a(Throwable throwable, boolean z10) {
        kotlin.jvm.internal.t.i(throwable, "throwable");
        try {
            if (a(throwable)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new pe(throwable), 6, (Object) null);
                return;
            }
            String string = throwable.toString();
            String str = f3918v[0];
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = string.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (r.P(lowerCase, str, false, 2, null)) {
                return;
            }
            z9 z9Var = ba.f2429g;
            cc0 cc0VarD = this.f3921c.d();
            z9Var.getClass();
            kotlin.jvm.internal.t.i(throwable, "throwable");
            e00 e00VarA = z9Var.a(new z8(throwable, cc0VarD, z10));
            if (e00VarA != null) {
                a(e00VarA);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) qe.f3705a, 4, (Object) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(bo.app.e00 r25) {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.tf.a(bo.app.e00):boolean");
    }

    public final void a(long j10) {
        Object systemService = this.f3919a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent intent = new Intent(this.f3919a, (Class<?>) BrazeFlushPushDeliveryReceiver.class);
        intent.setAction("com.braze.FLUSH_PUSH_DELIVERY");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3919a, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | C.BUFFER_FLAG_FIRST_SAMPLE);
        if (j10 <= 0) {
            alarmManager.cancel(broadcast);
            ArrayList arrayListA = this.f3929k.a();
            if (!arrayListA.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) hf.f2978a, 7, (Object) null);
                a(new u60(this.f3924f, this.f3923e.getBaseUrlForRequests(), this.f3920b, arrayListA));
                return;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) Cif.f3051a, 7, (Object) null);
                return;
            }
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new jf(j10), 7, (Object) null);
        alarmManager.set(2, SystemClock.elapsedRealtime() + j10, broadcast);
    }

    public final void a(j50 respondWithBuilder) {
        kotlin.jvm.internal.t.i(respondWithBuilder, "respondWithBuilder");
        vb0 vb0Var = this.f3924f;
        vb0Var.getClass();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) vb0Var, priority, (Throwable) null, false, (h9.a) jb0.f3146a, 6, (Object) null);
        s sVar = null;
        if (!a.C0755a.b(vb0Var.f4106c, null, 1, null)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) vb0Var, priority, (Throwable) null, false, (h9.a) kb0.f3238a, 6, (Object) null);
        } else {
            sVar = new s(Long.valueOf(vb0Var.d()), Boolean.valueOf(vb0Var.d() <= 0));
        }
        if (sVar != null) {
            i50 outboundConfigParams = new i50(((Number) sVar.c()).longValue(), ((Boolean) sVar.d()).booleanValue());
            kotlin.jvm.internal.t.i(outboundConfigParams, "outboundConfigParams");
            respondWithBuilder.f3125d = outboundConfigParams;
        }
        if (this.f3937s.get()) {
            respondWithBuilder.f3124c = Boolean.TRUE;
        }
        respondWithBuilder.f3122a = this.f3920b;
        a(new cp(this.f3924f, this.f3923e.getBaseUrlForRequests(), respondWithBuilder.a()));
        this.f3937s.set(false);
    }

    public final void a(boolean z10) {
        this.f3937s.set(z10);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new sf(this), 6, (Object) null);
    }
}
