package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.b70;
import bo.app.c70;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb0 f2419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f2420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f2421c;

    public b70(Context context, vw internalEventPublisher, vb0 serverConfigStorageProvider, String apiKey, String str) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        this.f2419a = serverConfigStorageProvider;
        this.f2420b = context.getSharedPreferences("com.braze.storage.braze_push_max_storage" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        this.f2421c = context.getSharedPreferences("com.braze.storage.braze_push_max_metadata" + StringUtils.getCacheFileSuffix(context, str, apiKey), 0);
        internalEventPublisher.c(new IEventSubscriber() { // from class: i.a
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                b70.a(this.f26522a, (c70) obj);
            }
        }, c70.class);
        a();
    }

    public static final void a(b70 this$0, c70 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.f2421c.edit().putLong(v8.i.V, it.f2489a).apply();
    }

    public final void b() {
        this.f2420b.edit().clear().apply();
        this.f2421c.edit().clear().apply();
    }

    public final void a(String pushCampaign) {
        kotlin.jvm.internal.t.i(pushCampaign, "pushCampaign");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new a70(pushCampaign), 7, (Object) null);
        if (!p9.q.z(pushCampaign)) {
            this.f2420b.edit().putLong(pushCampaign, DateTimeUtils.nowInSeconds()).apply();
        }
    }

    public final void a() {
        long jNowInSeconds = DateTimeUtils.nowInSeconds() - TimeUnit.DAYS.toSeconds(45L);
        SharedPreferences pushMaxPrefs = this.f2420b;
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
        List<z60> listP0 = kotlin.collections.d0.P0(arrayList);
        SharedPreferences.Editor editorEdit = this.f2420b.edit();
        for (z60 z60Var : listP0) {
            if (this.f2420b.getLong(z60Var.f4403a, 0L) < jNowInSeconds) {
                editorEdit.remove(z60Var.f4403a);
            }
        }
        editorEdit.apply();
    }
}
