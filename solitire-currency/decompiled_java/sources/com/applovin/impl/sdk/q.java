package com.applovin.impl.sdk;

import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.text.TextUtils;
import android.view.InputEvent;
import com.applovin.impl.e4;
import com.applovin.impl.f6;
import com.applovin.impl.l4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f7330b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MeasurementManager f7333e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TopicsManager f7336h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f7331c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f7332d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f7334f = new AtomicReference(new JSONArray());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f7335g = new d(this, null);

    class a implements OutcomeReceiver {
        a() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().a("PrivacySandboxService", "Failed to register impression", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().a("PrivacySandboxService", "Successfully registered impression");
            }
        }
    }

    class b implements OutcomeReceiver {
        b() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().a("PrivacySandboxService", "Failed to register click", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().a("PrivacySandboxService", "Successfully registered click");
            }
        }
    }

    class c implements OutcomeReceiver {
        c() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().a("PrivacySandboxService", "Failed to register conversion", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().a("PrivacySandboxService", "Successfully registered conversion");
            }
        }
    }

    private class d implements OutcomeReceiver {
        private d() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(GetTopicsResponse getTopicsResponse) {
            List<Topic> topics = getTopicsResponse.getTopics();
            int size = topics.size();
            q.this.f7329a.I();
            if (n.a()) {
                q.this.f7329a.I().d("PrivacySandboxService", size + " topic(s) received");
            }
            JSONArray jSONArray = new JSONArray();
            for (Topic topic : topics) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putInt(jSONObject, "id", topic.getTopicId());
                JsonUtils.putLong(jSONObject, "model", topic.getModelVersion());
                JsonUtils.putLong(jSONObject, "taxonomy", topic.getTaxonomyVersion());
                jSONArray.put(jSONObject);
            }
            q.this.f7334f.set(jSONArray);
            q.this.b(((Boolean) q.this.f7329a.a(l4.f5709o6)).booleanValue(), ((Long) q.this.f7329a.a(l4.f5693m6)).longValue());
        }

        /* synthetic */ d(q qVar, a aVar) {
            this();
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            String str;
            Long l10 = (Long) q.this.f7329a.a(l4.f5701n6);
            boolean z10 = l10.longValue() == -1;
            q.this.f7329a.I();
            if (n.a()) {
                n nVarI = q.this.f7329a.I();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to retrieve topics");
                if (z10) {
                    str = "";
                } else {
                    str = ", retrying in " + l10 + " ms";
                }
                sb.append(str);
                nVarI.a("PrivacySandboxService", sb.toString(), exc);
            }
            if (z10) {
                return;
            }
            q.this.b(((Boolean) q.this.f7329a.a(l4.f5717p6)).booleanValue(), l10.longValue());
        }
    }

    protected q(j jVar) {
        this.f7329a = jVar;
        this.f7330b = jVar.j0().a();
        Context contextN = j.n();
        this.f7333e = (MeasurementManager) contextN.getSystemService(MeasurementManager.class);
        this.f7336h = (TopicsManager) contextN.getSystemService(TopicsManager.class);
        if (((Boolean) jVar.a(l4.f5685l6)).booleanValue()) {
            b(((Boolean) jVar.a(l4.f5709o6)).booleanValue(), 0L);
        }
    }

    private boolean c(String str) {
        synchronized (this.f7332d) {
            if (this.f7331c.contains(str)) {
                return false;
            }
            this.f7331c.add(str);
            return true;
        }
    }

    public void b(final List list) {
        a("register impression", new Runnable() { // from class: com.applovin.impl.sdk.e1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7028a.a(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (list == null || list.isEmpty() || this.f7333e == null || !e4.e(j.f7085w0)) {
            return;
        }
        this.f7329a.I();
        if (n.a()) {
            this.f7329a.I().a("PrivacySandboxService", "Registering impression...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f7333e.registerSource(Uri.parse((String) it.next()), null, this.f7330b, new a());
        }
    }

    public void b(final List list, final InputEvent inputEvent) {
        a("register click", new Runnable() { // from class: com.applovin.impl.sdk.g1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7066a.a(list, inputEvent);
            }
        });
    }

    public void b(final String str) {
        a("register conversion trigger event", new Runnable() { // from class: com.applovin.impl.sdk.f1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7038a.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z10, final long j10) {
        a("retrieve topics", new Runnable() { // from class: com.applovin.impl.sdk.d1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7019a.a(z10, j10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, InputEvent inputEvent) {
        if (list == null || list.isEmpty() || this.f7333e == null || !e4.e(j.f7085w0)) {
            return;
        }
        this.f7329a.I();
        if (n.a()) {
            this.f7329a.I().a("PrivacySandboxService", "Registering click...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f7333e.registerSource(Uri.parse((String) it.next()), inputEvent, this.f7330b, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str) || this.f7333e == null || !e4.e(j.f7085w0)) {
            return;
        }
        this.f7329a.I();
        if (n.a()) {
            this.f7329a.I().a("PrivacySandboxService", "Registering conversion: " + str);
        }
        this.f7333e.registerTrigger(Uri.parse(str), this.f7330b, new c());
    }

    public JSONArray a() {
        return (JSONArray) this.f7334f.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z10, long j10) {
        if (this.f7336h == null) {
            return;
        }
        final GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setShouldRecordObservation(z10).setAdsSdkName("AppLovin").build();
        if (j10 > 0) {
            this.f7329a.j0().a(new f6(this.f7329a, true, "getTopics", new Runnable() { // from class: com.applovin.impl.sdk.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7078a.a(getTopicsRequestBuild);
                }
            }), r5.b.OTHER, j10);
        } else {
            this.f7336h.getTopics(getTopicsRequestBuild, this.f7330b, this.f7335g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GetTopicsRequest getTopicsRequest) {
        this.f7336h.getTopics(getTopicsRequest, this.f7330b, this.f7335g);
    }

    private void a(String str, Runnable runnable) {
        try {
            this.f7329a.I();
            if (n.a()) {
                this.f7329a.I().a("PrivacySandboxService", "Running operation: " + str);
            }
            runnable.run();
        } catch (Throwable th) {
            this.f7329a.I();
            if (n.a()) {
                this.f7329a.I().a("PrivacySandboxService", "Failed to run operation: " + str, th);
            }
            if (c(str)) {
                this.f7329a.A().a("PrivacySandboxService", str, th);
            }
        }
    }
}
