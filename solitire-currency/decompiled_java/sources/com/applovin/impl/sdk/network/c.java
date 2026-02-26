package com.applovin.impl.sdk.network;

import android.text.TextUtils;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.n;
import com.applovin.impl.w4;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f7277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final n f7278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicBoolean f7279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7280j;

    c(b bVar, j jVar) {
        super("PersistentPostbackQueueSaveTask", jVar);
        this.f7279i = new AtomicBoolean();
        this.f7280j = false;
        this.f7277g = bVar;
        this.f7278h = jVar.I();
    }

    public List a(int i10) throws Throwable {
        ArrayList arrayList = new ArrayList();
        l lVarC = this.f7677a.C();
        if (!lVarC.b("persistent_postback_cache.json", j.n())) {
            n.h("PersistentPostbackQueueSaveTask", "Postbacks queue file does not exist.");
            return arrayList;
        }
        File fileA = lVarC.a("persistent_postback_cache.json", j.n());
        String strF = lVarC.f(fileA);
        if (TextUtils.isEmpty(strF)) {
            n.h("PersistentPostbackQueueSaveTask", "Postbacks queue file has no content.");
            return arrayList;
        }
        boolean z10 = false;
        try {
            JSONArray jSONArray = new JSONObject(strF).getJSONArray("pb");
            if (n.a()) {
                this.f7278h.a("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s)...");
            }
            arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
            Integer num = (Integer) this.f7677a.a(l4.f5767w2);
            for (int i11 = 0; i11 < jSONArray.length() && arrayList.size() < i10; i11++) {
                try {
                    d dVar = new d(jSONArray.getJSONObject(i11), this.f7677a);
                    if (dVar.c() < num.intValue()) {
                        arrayList.add(dVar);
                    } else {
                        n.h("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + dVar);
                    }
                } catch (Throwable th) {
                    n.c("PersistentPostbackQueueSaveTask", "Unable to deserialize postback from json", th);
                    this.f7677a.A().a("PersistentPostbackQueueSaveTask", "deserializePostback", th);
                }
            }
            if (n.a()) {
                this.f7278h.a("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            }
        } catch (Throwable th2) {
            try {
                n.c("PersistentPostbackQueueSaveTask", "Failed to load postback queue", th2);
                try {
                    this.f7677a.A().a("PersistentPostbackQueueSaveTask", "deserializePostbackQueue", th2);
                    if (((Boolean) this.f7677a.a(l4.H0)).booleanValue()) {
                        lVarC.a(fileA, "removeAfterDeserializationFail");
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z10 = true;
                    if (z10 && ((Boolean) this.f7677a.a(l4.H0)).booleanValue()) {
                        lVarC.a(fileA, "removeAfterDeserializationFail");
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        this.f7280j = arrayList.isEmpty();
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.f7277g.d());
    }

    private void a(List list) {
        if (!(this.f7280j && list.isEmpty()) && this.f7279i.compareAndSet(false, true)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                try {
                    jSONArray.put(dVar.q());
                } catch (Throwable th) {
                    n.c("PersistentPostbackQueueSaveTask", "Unable to serialize postback to JSON: " + dVar, th);
                    this.f7677a.A().a("PersistentPostbackQueueSaveTask", "serializePostback", th);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pb", jSONArray);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
                l lVarC = this.f7677a.C();
                if (lVarC.b((InputStream) byteArrayInputStream, lVarC.a("persistent_postback_cache.json", j.n()), true)) {
                    if (n.a()) {
                        this.f7278h.a("PersistentPostbackQueueSaveTask", "Exported postback queue to disk.");
                    }
                } else if (n.a()) {
                    this.f7278h.b("PersistentPostbackQueueSaveTask", "Unable to export postback queue to disk.");
                }
            } catch (Throwable th2) {
                n.c("PersistentPostbackQueueSaveTask", "Unable to export postbacks to disk: " + jSONArray, th2);
                this.f7677a.A().a("PersistentPostbackQueueSaveTask", "serializePostbackQueue", th2);
            }
            this.f7279i.set(false);
        }
    }
}
