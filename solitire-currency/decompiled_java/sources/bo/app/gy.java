package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.gy;
import bo.app.iy;
import bo.app.jy;
import bo.app.v70;
import bo.app.w70;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.models.FeatureFlag;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class gy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v00 f2929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f2930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb0 f2931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h00 f2932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f2933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f2934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedPreferences f2935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedPreferences f2936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SharedPreferences f2937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f2938j;

    public gy(Context context, String apiKey, String str, vw internalEventPublisher, v00 externalEventPublisher, vb0 serverConfigStorageProvider, h00 brazeManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(externalEventPublisher, "externalEventPublisher");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        this.f2929a = internalEventPublisher;
        this.f2930b = externalEventPublisher;
        this.f2931c = serverConfigStorageProvider;
        this.f2932d = brazeManager;
        this.f2933e = kotlin.collections.v.l();
        this.f2934f = new AtomicBoolean(false);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.managers.featureflags.eligibility" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f2935g = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.managers.featureflags.storage" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f2936h = sharedPreferences2;
        SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.braze.managers.featureflags.impressions" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences3, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f2937i = sharedPreferences3;
        this.f2938j = new AtomicInteger(0);
        a();
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.g
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                gy.a(this.f26534a, (w70) obj);
            }
        }, w70.class);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.h
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                gy.a(this.f26536a, (v70) obj);
            }
        }, v70.class);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.i
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                gy.a(this.f26538a, (jy) obj);
            }
        }, jy.class);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.j
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                gy.a(this.f26540a, (iy) obj);
            }
        }, iy.class);
    }

    public static final void a(gy this$0, w70 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        if (it.f4171a instanceof ny) {
            this$0.f2938j.incrementAndGet();
        }
    }

    public final void b() {
        this.f2937i.edit().clear().apply();
    }

    public static final void a(gy this$0, v70 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        if (it.f4077a instanceof ny) {
            this$0.f2938j.decrementAndGet();
        }
    }

    public static final void a(gy this$0, jy it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.f2934f.set(true);
        long jNowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new fy(jNowInSeconds), 6, (Object) null);
        this$0.f2935g.edit().putLong("last_refresh", jNowInSeconds).apply();
    }

    public static final void a(gy this$0, iy it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.f2934f.set(true);
        if (this$0.f2934f.get()) {
            List list = this$0.f2933e;
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(((FeatureFlag) it2.next()).deepcopy$android_sdk_base_release());
            }
            ((vw) this$0.f2930b).b(FeatureFlagsUpdatedEvent.class, new FeatureFlagsUpdatedEvent(arrayList));
        }
    }

    public final void a() {
        SharedPreferences sharedPreferences = this.f2936h;
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && !all.isEmpty()) {
            Set<String> setKeySet = all.keySet();
            if (setKeySet.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) vx.f4153a, 6, (Object) null);
                this.f2933e = kotlin.collections.v.l();
                return;
            }
            for (String str : setKeySet) {
                String str2 = (String) all.get(str);
                if (str2 != null) {
                    try {
                    } catch (Exception e10) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new xx(str2), 4, (Object) null);
                    }
                    if (!p9.q.z(str2)) {
                        FeatureFlag featureFlagA = com.braze.support.f.f8118a.a(new JSONObject(str2));
                        if (featureFlagA != null) {
                            arrayList.add(featureFlagA);
                        }
                    }
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new wx(str), 6, (Object) null);
            }
            this.f2933e = arrayList;
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ux.f4056a, 7, (Object) null);
        this.f2933e = kotlin.collections.v.l();
    }

    public final FeatureFlagsUpdatedEvent a(JSONArray featureFlagsJson) {
        kotlin.jvm.internal.t.i(featureFlagsJson, "featureFlagsData");
        kotlin.jvm.internal.t.i(featureFlagsJson, "featureFlagsJson");
        ArrayList arrayList = new ArrayList();
        Iterator it = o9.o.s(o9.o.k(kotlin.collections.d0.a0(n9.o.u(0, featureFlagsJson.length())), new oy(featureFlagsJson)), new py(featureFlagsJson)).iterator();
        while (it.hasNext()) {
            FeatureFlag featureFlagA = com.braze.support.f.f8118a.a((JSONObject) it.next());
            if (featureFlagA != null) {
                arrayList.add(featureFlagA);
            }
        }
        this.f2933e = arrayList;
        SharedPreferences.Editor editorEdit = this.f2936h.edit();
        editorEdit.clear();
        for (FeatureFlag featureFlag : this.f2933e) {
            try {
                editorEdit.putString(featureFlag.getId(), featureFlag.forJsonPut().toString());
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new dy(featureFlag), 4, (Object) null);
            }
        }
        editorEdit.apply();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ey.f2758a, 7, (Object) null);
        List list = this.f2933e;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((FeatureFlag) it2.next()).deepcopy$android_sdk_base_release());
        }
        return new FeatureFlagsUpdatedEvent(arrayList2);
    }
}
