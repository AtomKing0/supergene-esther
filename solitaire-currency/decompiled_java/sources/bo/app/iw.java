package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.ac0;
import bo.app.am;
import bo.app.ch0;
import bo.app.d30;
import bo.app.dc0;
import bo.app.ds;
import bo.app.ec0;
import bo.app.eh0;
import bo.app.es;
import bo.app.gb0;
import bo.app.hy;
import bo.app.iw;
import bo.app.uc0;
import bo.app.uz;
import bo.app.v40;
import bo.app.ve0;
import bo.app.xe0;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.location.IBrazeLocationApi;
import com.braze.managers.BrazeGeofenceManager;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import y9.a;

/* JADX INFO: loaded from: classes2.dex */
public final class iw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y00 f3083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v00 f3084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h00 f3085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final uh0 f3086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zq f3087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h10 f3088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j10 f3089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final kx f3090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BrazeGeofenceManager f3091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v00 f3092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BrazeConfigurationProvider f3093l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final kn f3094m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final la0 f3095n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final vb0 f3096o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final gy f3097p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final s60 f3098q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f3099r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f3100s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ve0 f3101t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f3102u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f3103v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f3104w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f3105x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicBoolean f3106y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicBoolean f3107z;

    public iw(Context applicationContext, zd locationManager, vw internalEventPublisher, h00 brazeManager, uh0 userCache, zq deviceCache, cg0 triggerManager, j10 triggerReEligibilityManager, kx eventStorageManager, BrazeGeofenceManager geofenceManager, v00 externalEventPublisher, BrazeConfigurationProvider configurationProvider, kn contentCardsStorageProvider, la0 sdkMetadataCache, vb0 serverConfigStorageProvider, gy featureFlagsManager, s60 pushDeliveryManager) {
        kotlin.jvm.internal.t.i(applicationContext, "applicationContext");
        kotlin.jvm.internal.t.i(locationManager, "locationManager");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(userCache, "userCache");
        kotlin.jvm.internal.t.i(deviceCache, "deviceCache");
        kotlin.jvm.internal.t.i(triggerManager, "triggerManager");
        kotlin.jvm.internal.t.i(triggerReEligibilityManager, "triggerReEligibilityManager");
        kotlin.jvm.internal.t.i(eventStorageManager, "eventStorageManager");
        kotlin.jvm.internal.t.i(geofenceManager, "geofenceManager");
        kotlin.jvm.internal.t.i(externalEventPublisher, "externalEventPublisher");
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        kotlin.jvm.internal.t.i(contentCardsStorageProvider, "contentCardsStorageProvider");
        kotlin.jvm.internal.t.i(sdkMetadataCache, "sdkMetadataCache");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(featureFlagsManager, "featureFlagsManager");
        kotlin.jvm.internal.t.i(pushDeliveryManager, "pushDeliveryManager");
        this.f3082a = applicationContext;
        this.f3083b = locationManager;
        this.f3084c = internalEventPublisher;
        this.f3085d = brazeManager;
        this.f3086e = userCache;
        this.f3087f = deviceCache;
        this.f3088g = triggerManager;
        this.f3089h = triggerReEligibilityManager;
        this.f3090i = eventStorageManager;
        this.f3091j = geofenceManager;
        this.f3092k = externalEventPublisher;
        this.f3093l = configurationProvider;
        this.f3094m = contentCardsStorageProvider;
        this.f3095n = sdkMetadataCache;
        this.f3096o = serverConfigStorageProvider;
        this.f3097p = featureFlagsManager;
        this.f3098q = pushDeliveryManager;
        this.f3099r = new AtomicBoolean(false);
        this.f3100s = new AtomicBoolean(false);
        this.f3102u = new AtomicBoolean(false);
        this.f3103v = new AtomicBoolean(false);
        this.f3104w = new AtomicBoolean(false);
        this.f3105x = new AtomicBoolean(false);
        this.f3106y = new AtomicBoolean(false);
        this.f3107z = new AtomicBoolean(false);
    }

    public static final void a(iw this$0, am it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        try {
            h00 h00Var = this$0.f3085d;
            kn knVar = this$0.f3094m;
            i.k.a(h00Var, knVar.f3266c, knVar.f3267d);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) gv.f2926a, 4, (Object) null);
        }
    }

    public final IEventSubscriber b() {
        return new IEventSubscriber() { // from class: i.r
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26555a, (ds) obj);
            }
        };
    }

    public final IEventSubscriber c() {
        return new IEventSubscriber() { // from class: i.x
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26562a, (es) obj);
            }
        };
    }

    public final IEventSubscriber d() {
        final Semaphore semaphore = null;
        return new IEventSubscriber() { // from class: i.p
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26550a, semaphore, (Throwable) obj);
            }
        };
    }

    public final IEventSubscriber e() {
        return new IEventSubscriber() { // from class: i.b0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26525a, (hy) obj);
            }
        };
    }

    public final IEventSubscriber f() {
        return new IEventSubscriber() { // from class: i.n
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26546a, (uz) obj);
            }
        };
    }

    public final IEventSubscriber g() {
        return new IEventSubscriber() { // from class: i.t
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26558a, (d30) obj);
            }
        };
    }

    public final IEventSubscriber h() {
        return new IEventSubscriber() { // from class: i.q
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26553a, (v40) obj);
            }
        };
    }

    public final IEventSubscriber i() {
        return new IEventSubscriber() { // from class: i.a0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26523a, (gb0) obj);
            }
        };
    }

    public final IEventSubscriber j() {
        return new IEventSubscriber() { // from class: i.o
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26548a, (ac0) obj);
            }
        };
    }

    public final IEventSubscriber k() {
        return new IEventSubscriber() { // from class: i.v
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26560a, (dc0) obj);
            }
        };
    }

    public final IEventSubscriber l() {
        return new IEventSubscriber() { // from class: i.u
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26559a, (ec0) obj);
            }
        };
    }

    public final IEventSubscriber m() {
        return new IEventSubscriber() { // from class: i.y
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26563a, (uc0) obj);
            }
        };
    }

    public final IEventSubscriber n() {
        return new IEventSubscriber() { // from class: i.s
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26557a, (ve0) obj);
            }
        };
    }

    public final IEventSubscriber o() {
        return new IEventSubscriber() { // from class: i.c0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26527a, (xe0) obj);
            }
        };
    }

    public final IEventSubscriber p() {
        return new IEventSubscriber() { // from class: i.z
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26564a, (ch0) obj);
            }
        };
    }

    public final IEventSubscriber q() {
        return new IEventSubscriber() { // from class: i.m
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26544a, (eh0) obj);
            }
        };
    }

    public final void r() {
        if (!this.f3103v.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) jv.f3180a, 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) iv.f3081a, 7, (Object) null);
        h00 h00Var = this.f3085d;
        kn knVar = this.f3094m;
        i.k.a(h00Var, knVar.f3266c, knVar.f3267d);
    }

    public final void s() {
        if (!this.f3106y.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lv.f3351a, 7, (Object) null);
            return;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) kv.f3285a, 7, (Object) null);
        tf tfVar = (tf) this.f3085d;
        if (tfVar.f3924f.x()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) nf.f3484a, 6, (Object) null);
            tfVar.a(new hs(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), tfVar.f3920b));
        }
    }

    public final void t() {
        List listL;
        if (!this.f3105x.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) pv.f3665a, 7, (Object) null);
            return;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ov.f3582a, 7, (Object) null);
        tf tfVar = (tf) this.f3085d;
        if (tfVar.f3924f.D()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) pf.f3626a, 7, (Object) null);
            vb0 vb0Var = tfVar.f3924f;
            String baseUrlForRequests = tfVar.f3923e.getBaseUrlForRequests();
            String str = tfVar.f3920b;
            b70 b70Var = tfVar.f3928j;
            long j10 = b70Var.f2421c.getLong(v8.i.V, -1L) - b70Var.f2419a.o();
            SharedPreferences pushMaxPrefs = b70Var.f2420b;
            kotlin.jvm.internal.t.h(pushMaxPrefs, "pushMaxPrefs");
            ArrayList arrayList = new ArrayList();
            Map<String, ?> all = pushMaxPrefs.getAll();
            kotlin.jvm.internal.t.h(all, "this.all");
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String campaignId = it.next().getKey();
                kotlin.jvm.internal.t.h(campaignId, "campaignId");
                arrayList.add(new z60(campaignId, pushMaxPrefs.getLong(campaignId, 0L)));
            }
            List listP0 = kotlin.collections.d0.P0(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listP0) {
                if (((z60) obj).f4404b > j10) {
                    arrayList2.add(obj);
                }
            }
            List listP02 = kotlin.collections.d0.P0(arrayList2);
            ArrayList arrayList3 = new ArrayList(kotlin.collections.w.v(listP02, 10));
            Iterator it2 = listP02.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((z60) it2.next()).f4403a);
            }
            long j11 = tfVar.f3928j.f2421c.getLong(v8.i.V, -1L);
            y60 y60Var = tfVar.f3930l;
            long jP = tfVar.f3924f.p();
            y60Var.getClass();
            if (jP <= 0) {
                listL = kotlin.collections.v.l();
            } else {
                long jNowInSeconds = DateTimeUtils.nowInSeconds() - jP;
                ArrayList arrayList4 = new ArrayList();
                Map<String, ?> all2 = y60Var.f4328a.getAll();
                kotlin.jvm.internal.t.h(all2, "storagePrefs.all");
                for (Map.Entry<String, ?> entry : all2.entrySet()) {
                    Long l10 = (Long) entry.getValue();
                    if (l10 != null && l10.longValue() >= jNowInSeconds) {
                        String key = entry.getKey();
                        kotlin.jvm.internal.t.h(key, "it.key");
                        arrayList4.add(key);
                    }
                }
                listL = arrayList4;
            }
            tfVar.a(new f70(vb0Var, baseUrlForRequests, str, arrayList3, j11, listL));
        }
    }

    public final void u() {
        if (!this.f3107z.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) rv.f3807a, 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) qv.f3732a, 7, (Object) null);
        ((vw) this.f3084c).b(ca0.class, new ca0());
    }

    public final void v() {
        j50 j50Var = new j50();
        if (((tf) this.f3085d).f3938t.get()) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) uv.f4053a, 7, (Object) null);
            j50Var.f3123b = Boolean.TRUE;
            tf tfVar = (tf) this.f3085d;
            tfVar.f3938t.set(false);
            BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new rf(tfVar), 6, (Object) null);
        }
        if (((tf) this.f3085d).f3937s.get()) {
            this.f3099r.set(true);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) vv.f4143a, 7, (Object) null);
            j50Var.f3124c = Boolean.TRUE;
            ((tf) this.f3085d).a(false);
        }
        Boolean bool = j50Var.f3124c;
        Boolean bool2 = Boolean.TRUE;
        if (kotlin.jvm.internal.t.d(bool, bool2) || kotlin.jvm.internal.t.d(j50Var.f3123b, bool2)) {
            ((tf) this.f3085d).a(j50Var);
        }
    }

    public static final void a(iw this$0, ds dsVar) {
        ve0 ve0Var;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(dsVar, "<name for destructuring parameter 0>");
        l00 l00Var = dsVar.f2679a;
        nq nqVar = ((tg) l00Var).f3947h;
        if (nqVar != null) {
            this$0.f3087f.a(nqVar, false);
        }
        if (l00Var instanceof cp) {
            cp cpVar = (cp) l00Var;
            if (cpVar.f2583j.c()) {
                if (this$0.f3099r.compareAndSet(true, false)) {
                    ((cg0) this$0.f3088g).b(new g50());
                }
                if (this$0.f3100s.compareAndSet(true, false) && (ve0Var = this$0.f3101t) != null) {
                    ((cg0) this$0.f3088g).b(new m60(ve0Var.f4112a, ve0Var.f4113b));
                    this$0.f3101t = null;
                }
                ((tf) this$0.f3085d).a(true);
            }
            l50 l50Var = cpVar.f2585l;
            if (l50Var != null) {
                this$0.f3086e.a((Object) l50Var, false);
                if (l50Var.f3305a.has("push_token")) {
                    this$0.f3086e.d();
                    this$0.f3087f.c();
                }
            }
            ca caVar = cpVar.f2586m;
            if (caVar != null) {
                for (e00 e00Var : caVar.f2495a) {
                    v00 v00Var = this$0.f3084c;
                    List events = kotlin.collections.u.e(e00Var);
                    kotlin.jvm.internal.t.i(events, "events");
                    ((vw) v00Var).b(tr.class, new tr(2, events, null, null, 12));
                }
            }
            if (cpVar.f2583j.f3217d != null) {
                vb0 vb0Var = this$0.f3096o;
                vb0Var.getClass();
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) vb0Var, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) pb0.f3617a, 6, (Object) null);
                if (vb0Var.f4106c.f()) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) vb0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) qb0.f3700a, 7, (Object) null);
                    a.C0755a.c(vb0Var.f4106c, null, 1, null);
                }
            }
        }
        if (l00Var instanceof u60) {
            s60 s60Var = this$0.f3098q;
            List events2 = ((u60) l00Var).f3993j;
            s60Var.getClass();
            kotlin.jvm.internal.t.i(events2, "events");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) s60Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new r60(events2), 7, (Object) null);
            ReentrantLock reentrantLock = s60Var.f3832a;
            reentrantLock.lock();
            try {
                s60Var.f3833b.addAll(events2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static final void a(iw this$0, es esVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(esVar, "<name for destructuring parameter 0>");
        l00 l00Var = esVar.f2749a;
        nq nqVar = ((tg) l00Var).f3947h;
        if (nqVar != null) {
            this$0.f3087f.a(nqVar, true);
        }
        if (l00Var instanceof cp) {
            cp cpVar = (cp) l00Var;
            l50 l50Var = cpVar.f2585l;
            if (l50Var != null) {
                this$0.f3086e.a((Object) l50Var, true);
            }
            ca caVar = cpVar.f2586m;
            if (caVar != null) {
                kx kxVar = this$0.f3090i;
                Set events = caVar.f2495a;
                kxVar.getClass();
                kotlin.jvm.internal.t.i(events, "events");
                if (kxVar.f3287b) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) kxVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new gx(events), 6, (Object) null);
                } else {
                    kxVar.f3286a.a(events);
                }
            }
            if (cpVar.f2583j.c()) {
                ((tf) this$0.f3085d).a(false);
            }
            EnumSet enumSet = cpVar.f2587n;
            if (enumSet != null) {
                this$0.f3095n.a(enumSet);
            }
            if (cpVar.f2583j.f3217d != null) {
                vb0 vb0Var = this$0.f3096o;
                vb0Var.getClass();
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) vb0Var, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) pb0.f3617a, 6, (Object) null);
                if (vb0Var.f4106c.f()) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) vb0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) qb0.f3700a, 7, (Object) null);
                    a.C0755a.c(vb0Var.f4106c, null, 1, null);
                }
            }
        }
        if (l00Var instanceof u60) {
            this$0.f3098q.a(((u60) l00Var).f3993j);
        }
    }

    public static final void a(iw this$0, hy hyVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(hyVar, "<name for destructuring parameter 0>");
        ((vw) this$0.f3092k).b(FeatureFlagsUpdatedEvent.class, this$0.f3097p.a(hyVar.f3008a));
    }

    public static final void a(iw this$0, uz uzVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(uzVar, "<name for destructuring parameter 0>");
        this$0.f3091j.registerGeofences(uzVar.f4062a);
    }

    public static final void a(iw this$0, d30 d30Var) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(d30Var, "<name for destructuring parameter 0>");
        g10 g10Var = d30Var.f2617a;
        k10 k10Var = d30Var.f2618b;
        IInAppMessage iInAppMessage = d30Var.f2619c;
        String str = d30Var.f2620d;
        synchronized (this$0.f3089h) {
            if (((zg0) this$0.f3089h).a(k10Var)) {
                ((vw) this$0.f3092k).b(InAppMessageEvent.class, new InAppMessageEvent(g10Var, k10Var, iInAppMessage, str));
                ((zg0) this$0.f3089h).a(k10Var, DateTimeUtils.nowInSeconds());
                h10 h10Var = this$0.f3088g;
                long jNowInSeconds = DateTimeUtils.nowInSeconds();
                cg0 cg0Var = (cg0) h10Var;
                cg0Var.f2526l = cg0Var.f2527m;
                cg0Var.f2527m = jNowInSeconds;
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) cg0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new kf0(jNowInSeconds), 7, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new sv(k10Var), 7, (Object) null);
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    public static final void a(iw this$0, v40 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        ((tf) this$0.f3085d).a(true);
        this$0.v();
    }

    public static final void a(iw this$0, gb0 gb0Var) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(gb0Var, "<name for destructuring parameter 0>");
        fb0 fb0Var = gb0Var.f2893a;
        this$0.f3091j.configureFromServerConfig(fb0Var);
        if (this$0.f3102u.get()) {
            if (fb0Var.f2799j) {
                this$0.r();
            }
            if (fb0Var.f2802m) {
                if (this$0.f3104w.compareAndSet(false, true)) {
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) mv.f3451a, 7, (Object) null);
                    tf tfVar = (tf) this$0.f3097p.f2932d;
                    tfVar.getClass();
                    BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lf.f3331a, 7, (Object) null);
                    tfVar.a(new ny(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), tfVar.f3920b));
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) nv.f3523a, 7, (Object) null);
                }
            }
            if (fb0Var.f2804o) {
                this$0.t();
            }
            if (fb0Var.f2809t) {
                this$0.s();
            }
            if (fb0Var.f2814y) {
                this$0.u();
            }
        }
    }

    public static final void a(iw this$0, ac0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) wv.f4227a, 7, (Object) null);
        zd zdVar = (zd) this$0.f3083b;
        sd sdVar = zdVar.f4431b;
        yd manualLocationUpdateCallback = new yd(zdVar);
        sdVar.getClass();
        kotlin.jvm.internal.t.i(manualLocationUpdateCallback, "manualLocationUpdateCallback");
        IBrazeLocationApi iBrazeLocationApi = sdVar.f3849a;
        if (iBrazeLocationApi != null) {
            iBrazeLocationApi.requestSingleLocationUpdate(manualLocationUpdateCallback);
        }
        z9 z9Var = ba.f2429g;
        cc0 sessionId = it.f2368a.f4421a;
        z9Var.getClass();
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
        e00 e00VarA = z9Var.a(new t9(sessionId));
        if (e00VarA != null) {
            ((ba) e00VarA).a(it.f2368a.f4421a);
        }
        if (e00VarA != null) {
            ((tf) this$0.f3085d).a(e00VarA);
        }
        ((tf) this$0.f3085d).a(true);
        tf tfVar = (tf) this$0.f3085d;
        tfVar.f3938t.set(true);
        BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new rf(tfVar), 6, (Object) null);
        this$0.f3086e.d();
        this$0.f3087f.c();
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) tv.f3972a, 7, (Object) null);
        ((tf) this$0.f3085d).a(0L);
        if (this$0.f3093l.isAutomaticGeofenceRequestsEnabled()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) xv.f4304a, 7, (Object) null);
            BrazeInternal.requestGeofenceRefresh(this$0.f3082a, false);
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) yv.f4384a, 7, (Object) null);
        }
        this$0.f3097p.b();
        this$0.v();
    }

    public static final void a(iw this$0, dc0 message) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(message, "message");
        this$0.getClass();
        zb0 zb0Var = message.f2643a;
        z9 z9Var = ba.f2429g;
        long jB = zb0Var.b();
        z9Var.getClass();
        e00 e00VarA = z9Var.a(new s9(jB));
        if (e00VarA != null) {
            ((ba) e00VarA).a(zb0Var.f4421a);
            ((tf) this$0.f3085d).a(e00VarA);
        }
        Braze.Companion.getInstance(this$0.f3082a).requestImmediateDataFlush();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) tv.f3972a, 7, (Object) null);
        ((tf) this$0.f3085d).a(0L);
    }

    public static final void a(iw this$0, ec0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) zv.f4486a, 7, (Object) null);
        this$0.f3102u.set(true);
        if (this$0.f3096o.w()) {
            this$0.r();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) aw.f2403a, 7, (Object) null);
        }
        if (this$0.f3096o.z()) {
            if (this$0.f3104w.compareAndSet(false, true)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) mv.f3451a, 7, (Object) null);
                tf tfVar = (tf) this$0.f3097p.f2932d;
                tfVar.getClass();
                BrazeLogger.brazelog$default(brazeLogger, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lf.f3331a, 7, (Object) null);
                tfVar.a(new ny(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), tfVar.f3920b));
            } else {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) nv.f3523a, 7, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) bw.f2474a, 7, (Object) null);
        }
        if (this$0.f3096o.D()) {
            this$0.t();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) cw.f2603a, 7, (Object) null);
        }
        if (this$0.f3096o.x()) {
            this$0.s();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) dw.f2689a, 7, (Object) null);
        }
        if (this$0.f3096o.E()) {
            this$0.u();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ew.f2754a, 7, (Object) null);
        }
    }

    public static final void a(iw this$0, uc0 throwable) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(throwable, "storageException");
        try {
            tf tfVar = (tf) this$0.f3085d;
            tfVar.getClass();
            kotlin.jvm.internal.t.i(throwable, "throwable");
            tfVar.a((Throwable) throwable, false);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) fw.f2846a, 4, (Object) null);
        }
    }

    public static final void a(iw this$0, ve0 message) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(message, "message");
        this$0.f3100s.set(true);
        this$0.f3101t = message;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) hw.f3006a, 6, (Object) null);
        h00 h00Var = this$0.f3085d;
        j50 j50Var = new j50();
        j50Var.f3124c = Boolean.TRUE;
        ((tf) h00Var).a(j50Var);
    }

    public static final void a(iw this$0, xe0 xe0Var) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(xe0Var, "<name for destructuring parameter 0>");
        ((cg0) this$0.f3088g).b(xe0Var.f4267a);
    }

    public static final void a(iw this$0, ch0 ch0Var) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(ch0Var, "<name for destructuring parameter 0>");
        ((cg0) this$0.f3088g).a(ch0Var.f2532a, ch0Var.f2533b);
    }

    public static final void a(iw this$0, eh0 eh0Var) {
        ve0 ve0Var;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(eh0Var, "<name for destructuring parameter 0>");
        ((cg0) this$0.f3088g).a(eh0Var.f2736a);
        if (this$0.f3099r.compareAndSet(true, false)) {
            ((cg0) this$0.f3088g).b(new g50());
        }
        if (!this$0.f3100s.compareAndSet(true, false) || (ve0Var = this$0.f3101t) == null) {
            return;
        }
        ((cg0) this$0.f3088g).b(new m60(ve0Var.f4112a, ve0Var.f4113b));
        this$0.f3101t = null;
    }

    public final IEventSubscriber a() {
        return new IEventSubscriber() { // from class: i.w
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                iw.a(this.f26561a, (am) obj);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(bo.app.iw r8, java.util.concurrent.Semaphore r9, java.lang.Throwable r10) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.t.i(r8, r0)
            if (r10 == 0) goto L32
            bo.app.h00 r0 = r8.f3085d     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            bo.app.tf r0 = (bo.app.tf) r0     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r0.getClass()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            java.lang.String r1 = "throwable"
            kotlin.jvm.internal.t.i(r10, r1)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r1 = 1
            r0.a(r10, r1)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            goto L32
        L18:
            r8 = move-exception
            goto L2c
        L1a:
            r10 = move-exception
            r3 = r10
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE     // Catch: java.lang.Throwable -> L18
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E     // Catch: java.lang.Throwable -> L18
            r4 = 0
            bo.app.hv r5 = bo.app.hv.f3005a     // Catch: java.lang.Throwable -> L18
            r6 = 4
            r7 = 0
            r1 = r8
            com.braze.support.BrazeLogger.brazelog$default(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L18
            if (r9 == 0) goto L37
            goto L34
        L2c:
            if (r9 == 0) goto L31
            r9.release()
        L31:
            throw r8
        L32:
            if (r9 == 0) goto L37
        L34:
            r9.release()
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.iw.a(bo.app.iw, java.util.concurrent.Semaphore, java.lang.Throwable):void");
    }
}
