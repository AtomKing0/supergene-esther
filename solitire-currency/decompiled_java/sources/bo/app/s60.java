package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class s60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f3832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f3834c;

    public s60(Context context, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f3832a = reentrantLock;
        ArrayList arrayList = new ArrayList();
        this.f3833b = arrayList;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.braze_push_delivery_storage" + StringUtils.getCacheFileSuffix(context, null, apiKey), 0);
        this.f3834c = sharedPreferences;
        reentrantLock.lock();
        try {
            arrayList.clear();
            Map<String, ?> all = sharedPreferences.getAll();
            kotlin.jvm.internal.t.h(all, "pdePrefs.all");
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String campaignId = it.next().getKey();
                ArrayList arrayList2 = this.f3833b;
                kotlin.jvm.internal.t.h(campaignId, "campaignId");
                arrayList2.add(new o60(campaignId, this.f3834c.getLong(campaignId, 0L)));
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(String pushCampaignId) {
        kotlin.jvm.internal.t.i(pushCampaignId, "pushCampaignId");
        ReentrantLock reentrantLock = this.f3832a;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new p60(pushCampaignId), 7, (Object) null);
            long jNowInSeconds = DateTimeUtils.nowInSeconds();
            this.f3834c.edit().putLong(pushCampaignId, jNowInSeconds).apply();
            this.f3833b.add(new o60(pushCampaignId, jNowInSeconds));
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(List events) {
        kotlin.jvm.internal.t.i(events, "events");
        ReentrantLock reentrantLock = this.f3832a;
        reentrantLock.lock();
        try {
            SharedPreferences.Editor editorEdit = this.f3834c.edit();
            Iterator it = events.iterator();
            while (it.hasNext()) {
                o60 o60Var = (o60) it.next();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new q60(o60Var), 7, (Object) null);
                String string = o60Var.f2432b.getString(CmcdConfiguration.KEY_CONTENT_ID);
                kotlin.jvm.internal.t.h(string, "data.getString(IBrazeEvent.DATA_CAMPAIGN_ID)");
                editorEdit.remove(string);
            }
            editorEdit.apply();
            this.f3833b.removeAll(events);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        ReentrantLock reentrantLock = this.f3832a;
        reentrantLock.lock();
        try {
            for (o60 o60Var : this.f3833b) {
                if (arrayList.size() >= 32) {
                    break;
                }
                arrayList.add(o60Var);
            }
            this.f3833b.removeAll(arrayList);
            return arrayList;
        } finally {
            reentrantLock.unlock();
        }
    }
}
