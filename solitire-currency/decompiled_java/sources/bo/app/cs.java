package bo.app;

import bo.app.cs;
import bo.app.tr;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.DeviceKey;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class cs {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final wr f2595d = new wr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l10 f2596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f2598c;

    public cs(l10 udm) {
        kotlin.jvm.internal.t.i(udm, "udm");
        this.f2596a = udm;
        this.f2597b = new ConcurrentHashMap();
        this.f2598c = new ConcurrentHashMap();
        a().c(new IEventSubscriber() { // from class: i.e
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                cs.a(this.f26531a, (tr) obj);
            }
        }, tr.class);
    }

    public static final void a(cs this$0, tr trVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(trVar, "<name for destructuring parameter 0>");
        int i10 = trVar.f3965a;
        List<e00> events = trVar.f3966b;
        cc0 cc0Var = trVar.f3967c;
        int iA = gc0.a(i10);
        if (iA == 0) {
            this$0.getClass();
            kotlin.jvm.internal.t.i(events, "events");
            for (e00 e00Var : events) {
                this$0.f2598c.putIfAbsent(((ba) e00Var).f2434d, e00Var);
            }
            return;
        }
        if (iA == 1) {
            this$0.getClass();
            kotlin.jvm.internal.t.i(events, "events");
            for (e00 e00Var2 : events) {
                this$0.f2597b.putIfAbsent(((ba) e00Var2).f2434d, e00Var2);
            }
            return;
        }
        if (iA != 2) {
            return;
        }
        if (cc0Var == null) {
            this$0.getClass();
            return;
        }
        ConcurrentHashMap concurrentHashMap = this$0.f2598c;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) bs.f2470a, 7, (Object) null);
        Collection collectionValues = concurrentHashMap.values();
        kotlin.jvm.internal.t.h(collectionValues, "events.values");
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            ((ba) ((e00) it.next())).a(cc0Var);
        }
        this$0.f2597b.putAll(concurrentHashMap);
        Set setKeySet = concurrentHashMap.keySet();
        kotlin.jvm.internal.t.h(setKeySet, "events.keys");
        Iterator it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            this$0.f2598c.remove((String) it2.next());
        }
    }

    public final vb0 b() {
        return ((ci0) this.f2596a).f2556h;
    }

    public final vw a() {
        return ((ci0) this.f2596a).f2559k;
    }

    public final l00 a(l00 brazeRequest) {
        LinkedHashSet linkedHashSet;
        ca caVar;
        kotlin.jvm.internal.t.i(brazeRequest, "brazeRequest");
        wr wrVar = f2595d;
        ci0 ci0Var = (ci0) this.f2596a;
        BrazeConfigurationProvider configurationProvider = ci0Var.f2550b;
        k90 sdkAuthenticationCache = ci0Var.f2566r;
        String deviceId = ((jr) ci0Var.f2551c).a();
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        kotlin.jvm.internal.t.i(sdkAuthenticationCache, "sdkAuthenticationCache");
        kotlin.jvm.internal.t.i(brazeRequest, "brazeRequest");
        kotlin.jvm.internal.t.i(deviceId, "deviceId");
        tg tgVar = (tg) brazeRequest;
        tgVar.f3944e = deviceId;
        tgVar.f3945f = configurationProvider.getBrazeApiKey().f3835a;
        tgVar.f3946g = "32.1.0";
        tgVar.f3943d = Long.valueOf(DateTimeUtils.nowInSeconds());
        if (configurationProvider.isSdkAuthenticationEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) wrVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new ur(sdkAuthenticationCache), 6, (Object) null);
            tgVar.f3948i = sdkAuthenticationCache.f3233d.getString("auth_signature", null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) wrVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) vr.f4132a, 6, (Object) null);
        }
        if (brazeRequest instanceof cp) {
            cp dataSyncRequest = (cp) brazeRequest;
            kotlin.jvm.internal.t.i(dataSyncRequest, "dataSyncRequest");
            ci0 ci0Var2 = (ci0) this.f2596a;
            dataSyncRequest.f2588o = ((hr) ci0Var2.f2553e).f2996c;
            dataSyncRequest.f2584k = ci0Var2.f2550b.getSdkFlavor();
            dataSyncRequest.f2589p = ((hr) ((ci0) this.f2596a).f2553e).b();
            ci0 ci0Var3 = (ci0) this.f2596a;
            o00 o00Var = ci0Var3.f2553e;
            zq deviceCache = ci0Var3.j();
            hr hrVar = (hr) o00Var;
            hrVar.getClass();
            kotlin.jvm.internal.t.i(deviceCache, "deviceCache");
            deviceCache.f4473e = hrVar.a();
            nq nqVar = (nq) deviceCache.a();
            dataSyncRequest.f3947h = nqVar;
            if (nqVar != null && nqVar.f3515m) {
                if (((ci0) this.f2596a).f2550b.getShouldOptInWhenPushAuthorized()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) xr.f4295a, 6, (Object) null);
                    ((ci0) this.f2596a).x().a(NotificationSubscriptionType.OPTED_IN);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) yr.f4380a, 6, (Object) null);
                }
            }
            if (nqVar != null && nqVar.forJsonPut().has(DeviceKey.NOTIFICATIONS_ENABLED.getKey())) {
                ((ci0) this.f2596a).x().d();
            }
            dataSyncRequest.f2585l = (l50) ((ci0) this.f2596a).x().a();
            synchronized (this) {
                Collection collectionValues = this.f2597b.values();
                kotlin.jvm.internal.t.h(collectionValues, "brazeEventMap.values");
                linkedHashSet = new LinkedHashSet();
                Iterator it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e00 event = (e00) it.next();
                    kotlin.jvm.internal.t.h(event, "event");
                    linkedHashSet.add(event);
                    collectionValues.remove(event);
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new zr(event), 7, (Object) null);
                    if (linkedHashSet.size() >= 32) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) as.f2399a, 6, (Object) null);
                        break;
                    }
                }
                caVar = new ca(linkedHashSet);
            }
            dataSyncRequest.f2586m = caVar;
            if (!linkedHashSet.isEmpty()) {
                Iterator it2 = linkedHashSet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((ba) ((e00) it2.next())).f2431a == lx.SESSION_START) {
                        ci0 ci0Var4 = (ci0) this.f2596a;
                        dataSyncRequest.f2587n = ci0Var4.f2569u.b(ci0Var4.f2550b.getSdkMetadata());
                        break;
                    }
                }
            }
        } else if (brazeRequest instanceof u60) {
            tgVar.f3947h = ((hr) ((ci0) this.f2596a).f2553e).a();
            ArrayList arrayListA = ((ci0) this.f2596a).f2552d.a();
            kotlin.jvm.internal.t.i(arrayListA, "<set-?>");
            ((u60) brazeRequest).f3993j = arrayListA;
        } else if (brazeRequest instanceof mn) {
            kn knVar = ((ci0) this.f2596a).B;
            mn mnVar = (mn) brazeRequest;
            mnVar.f3435j = knVar.f3266c;
            mnVar.f3436k = knVar.f3267d;
        }
        return brazeRequest;
    }
}
