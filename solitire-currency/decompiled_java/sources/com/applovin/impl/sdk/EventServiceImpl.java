package com.applovin.impl.sdk;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.f6;
import com.applovin.impl.i4;
import com.applovin.impl.l1;
import com.applovin.impl.l4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.w4;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.v8;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class EventServiceImpl implements AppLovinEventService {
    public static final List<String> ALLOW_PRE_INIT_EVENT_TYPES = Arrays.asList("landing", v8.h.f15788e0, "resumed", "cf_start", "tos_ok", "gdpr_ok");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f6897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f6898b = new AtomicBoolean();

    public EventServiceImpl(j jVar) {
        this.f6897a = jVar;
    }

    private String b() {
        return ((String) this.f6897a.a(l4.f5743t0)) + "4.0/pix";
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f6898b.compareAndSet(false, true)) {
            this.f6897a.B().trackEvent("landing");
        }
    }

    public String toString() {
        return "EventService{}";
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        map2.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEventSynchronously(String str) {
        this.f6897a.I();
        if (n.a()) {
            this.f6897a.I().a("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        l1 l1Var = new l1(str, new HashMap());
        Map mapA = a(l1Var, true);
        HashMap map = new HashMap(l1Var.d());
        if (((Boolean) this.f6897a.a(l4.X4)).booleanValue() || ((Boolean) this.f6897a.a(l4.S4)).booleanValue()) {
            map.putAll(mapA);
            mapA = null;
        }
        this.f6897a.X().e(com.applovin.impl.sdk.network.d.b().d(b()).a(a()).b(mapA).c(map).a(a(l1Var, (Map) null)).c(((Boolean) this.f6897a.a(l4.f5652h5)).booleanValue()).a(((Boolean) this.f6897a.a(l4.F4)).booleanValue()).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            n.c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            this.f6897a.A().a("AppLovinEventService", "trackIAP", th);
        }
        trackEvent("iap", map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(l1 l1Var, Map map, boolean z10) {
        Map mapA = a(l1Var, false);
        HashMap map2 = new HashMap(l1Var.d());
        if (((Boolean) this.f6897a.a(l4.X4)).booleanValue() || ((Boolean) this.f6897a.a(l4.S4)).booleanValue()) {
            map2.putAll(mapA);
            mapA = null;
        }
        this.f6897a.X().e(com.applovin.impl.sdk.network.d.b().d(b()).a(a()).b(mapA).c(map2).a(a(l1Var, map)).c(((Boolean) this.f6897a.a(l4.f5652h5)).booleanValue()).a(((Boolean) this.f6897a.a(l4.F4)).booleanValue()).d(z10).a(i4.a.a(((Integer) this.f6897a.a(l4.P4)).intValue())).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        this.f6897a.I();
        if (n.a()) {
            this.f6897a.I().a("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        }
        final l1 l1Var = new l1(str, map);
        final boolean zContains = ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
        try {
            this.f6897a.j0().a((w4) new f6(this.f6897a, zContains, "submitTrackEventPostback", new Runnable() { // from class: com.applovin.impl.sdk.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7379a.a(l1Var, map2, zContains);
                }
            }), r5.b.OTHER);
        } catch (Throwable th) {
            this.f6897a.I();
            if (n.a()) {
                this.f6897a.I().a("AppLovinEventService", "Unable to track event: " + l1Var, th);
            }
            this.f6897a.A().a("AppLovinEventService", "trackEvent", th);
        }
    }

    private String a() {
        return ((String) this.f6897a.a(l4.f5751u0)) + "4.0/pix";
    }

    private Map a(l1 l1Var, boolean z10) {
        boolean zContains = this.f6897a.c(l4.f5779y0).contains(l1Var.c());
        Map mapA = this.f6897a.y().a((Map) null, z10, false);
        mapA.put(NotificationCompat.CATEGORY_EVENT, zContains ? l1Var.c() : "postinstall");
        mapA.put("event_id", l1Var.b());
        mapA.put("ts", Long.toString(l1Var.a()));
        if (!zContains) {
            mapA.put("sub_event", l1Var.c());
        }
        return z6.a(mapA);
    }

    private Map a(l1 l1Var, Map map) {
        Map map2 = CollectionUtils.map(map);
        boolean zContains = this.f6897a.c(l4.f5779y0).contains(l1Var.c());
        map2.put("AppLovin-Event", zContains ? l1Var.c() : "postinstall");
        if (!zContains) {
            map2.put("AppLovin-Sub-Event", l1Var.c());
        }
        return map2;
    }
}
