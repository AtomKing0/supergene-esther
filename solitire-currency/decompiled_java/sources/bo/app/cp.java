package bo.app;

import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.SdkFlavor;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class cp extends tg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k50 f2583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SdkFlavor f2584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l50 f2585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ca f2586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EnumSet f2587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f2589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final k00 f2590q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(vb0 serverConfigStorageProvider, String urlBase, k50 outboundRespondWith) {
        super(new b90(urlBase + "data"), serverConfigStorageProvider);
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(urlBase, "urlBase");
        kotlin.jvm.internal.t.i(outboundRespondWith, "outboundRespondWith");
        this.f2583j = outboundRespondWith;
        this.f2590q = k00.V3_DATA;
    }

    @Override // bo.app.tg, bo.app.l00
    public final void a(HashMap existingHeaders) {
        boolean z10;
        kotlin.jvm.internal.t.i(existingHeaders, "existingHeaders");
        super.a(existingHeaders);
        if (this.f2583j.isEmpty()) {
            return;
        }
        if (this.f2583j.b()) {
            existingHeaders.put("X-Braze-FeedRequest", com.ironsource.mediationsdk.metadata.a.f13688g);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f2583j.c()) {
            existingHeaders.put("X-Braze-TriggersRequest", com.ironsource.mediationsdk.metadata.a.f13688g);
        } else if (!z10) {
            return;
        }
        existingHeaders.put("X-Braze-DataRequest", com.ironsource.mediationsdk.metadata.a.f13688g);
    }

    @Override // bo.app.tg, bo.app.l00
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        if (jSONObjectB == null) {
            return null;
        }
        try {
            String str = this.f2588o;
            if (str != null) {
                jSONObjectB.put(App.JsonKeys.APP_VERSION, str);
            }
            String str2 = this.f2589p;
            if (str2 != null && !p9.q.z(str2)) {
                jSONObjectB.put("app_version_code", this.f2589p);
            }
            l50 l50Var = this.f2585l;
            if (l50Var != null && !l50Var.isEmpty()) {
                JSONArray jsonArrayForJsonPut = l50Var.f3306b;
                kotlin.jvm.internal.t.h(jsonArrayForJsonPut, "jsonArrayForJsonPut");
                jSONObjectB.put("attributes", jsonArrayForJsonPut);
            }
            ca caVar = this.f2586m;
            if (caVar != null && !caVar.f2496b) {
                jSONObjectB.put("events", JsonUtils.constructJsonArray(caVar.f2495a));
            }
            SdkFlavor sdkFlavor = this.f2584k;
            if (sdkFlavor != null) {
                jSONObjectB.put("sdk_flavor", sdkFlavor.forJsonPut());
            }
            EnumSet<BrazeSdkMetadata> set = this.f2587n;
            if (set != null) {
                BrazeSdkMetadata.Companion.getClass();
                kotlin.jvm.internal.t.i(set, "set");
                ArrayList arrayList = new ArrayList(kotlin.collections.w.v(set, 10));
                for (BrazeSdkMetadata it : set) {
                    kotlin.jvm.internal.t.h(it, "it");
                    arrayList.add(it.jsonKey);
                }
                jSONObjectB.put("sdk_metadata", new JSONArray((Collection) kotlin.collections.d0.H0(arrayList)));
            }
            jSONObjectB.put("respond_with", this.f2583j.forJsonPut());
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) bp.f2467a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.l00
    public final k00 c() {
        return this.f2590q;
    }

    public final k50 f() {
        return this.f2583j;
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(v00 internalPublisher) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        if (this.f2583j.c()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ap.f2396a, 7, (Object) null);
            ((vw) internalPublisher).b(te0.class, new te0(this));
        }
    }

    @Override // bo.app.tg, bo.app.b10
    public final void a(vw internalPublisher) {
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        if (this.f2583j.c()) {
            internalPublisher.b(ue0.class, new ue0(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    @Override // bo.app.l00
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r2 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            bo.app.nq r1 = r2.f3947h
            r0.add(r1)
            bo.app.l50 r1 = r2.f2585l
            r0.add(r1)
            bo.app.ca r1 = r2.f2586m
            r0.add(r1)
            bo.app.k50 r1 = r2.f2583j
            r0.add(r1)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L20
            goto L39
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L39
            java.lang.Object r1 = r0.next()
            bo.app.u00 r1 = (bo.app.u00) r1
            if (r1 == 0) goto L24
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L5b
            goto L24
        L39:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            bo.app.nq r1 = r2.f3947h
            r0.add(r1)
            java.util.Iterator r0 = r0.iterator()
        L47:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L5d
            java.lang.Object r1 = r0.next()
            bo.app.u00 r1 = (bo.app.u00) r1
            if (r1 == 0) goto L47
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L47
        L5b:
            r0 = 0
            goto L5e
        L5d:
            r0 = 1
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.cp.a():boolean");
    }
}
