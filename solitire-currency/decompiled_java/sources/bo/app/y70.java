package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.BrazeNetworkFailureEvent;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class y70 implements c10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x00 f4333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f4334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v00 f4335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xy f4336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vb0 f4337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kn f4338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h00 f4339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ju f4340h;

    public y70(o40 httpConnector, vw internalEventPublisher, v00 externalEventPublisher, xy feedStorageProvider, vb0 serverConfigStorageProvider, kn contentCardsStorageProvider, h00 brazeManager, ju endpointMetadataProvider) {
        kotlin.jvm.internal.t.i(httpConnector, "httpConnector");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(externalEventPublisher, "externalEventPublisher");
        kotlin.jvm.internal.t.i(feedStorageProvider, "feedStorageProvider");
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(contentCardsStorageProvider, "contentCardsStorageProvider");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(endpointMetadataProvider, "endpointMetadataProvider");
        this.f4333a = httpConnector;
        this.f4334b = internalEventPublisher;
        this.f4335c = externalEventPublisher;
        this.f4336d = feedStorageProvider;
        this.f4337e = serverConfigStorageProvider;
        this.f4338f = contentCardsStorageProvider;
        this.f4339g = brazeManager;
        this.f4340h = endpointMetadataProvider;
    }

    @Override // bo.app.c10
    public final void a(z80 requestInfo, a80 requestDispatchCallback, boolean z10) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(requestDispatchCallback, "requestDispatchCallback");
        if (z10) {
            a(requestInfo, requestDispatchCallback);
        } else {
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new x70(this, requestInfo, requestDispatchCallback, null), 3, null);
        }
    }

    public final void a(z80 z80Var, a80 a80Var) {
        ju juVar;
        n fh0Var;
        n fh0Var2;
        v00 v00Var;
        x00 x00Var = this.f4333a;
        v00 v00Var2 = this.f4334b;
        v00 v00Var3 = this.f4335c;
        xy xyVar = this.f4336d;
        h00 h00Var = this.f4339g;
        vb0 vb0Var = this.f4337e;
        kn knVar = this.f4338f;
        ju juVar2 = this.f4340h;
        ih ihVar = new ih(z80Var, x00Var, v00Var2, v00Var3, xyVar, h00Var, vb0Var, knVar, juVar2, a80Var);
        ((tg) ihVar.f3061g).f3943d = Long.valueOf(DateTimeUtils.nowInSeconds());
        b90 b90VarE = ((tg) ihVar.f3061g).e();
        JSONObject jSONObjectB = ihVar.f3061g.b();
        if (jSONObjectB == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) ihVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new wg(b90VarE), 6, (Object) null);
            fh0Var2 = new fh0(ihVar.f3061g, new w00(-1, (Map) null, 6));
            juVar = juVar2;
        } else {
            juVar = juVar2;
            ihVar.f3060f.put("X-Braze-Last-Req-Ms-Ago", String.valueOf(juVar.a(b90VarE)));
            ihVar.f3060f.put("X-Braze-Req-Attempt", String.valueOf(juVar.b(b90VarE)));
            ihVar.f3060f.put("X-Braze-Req-Tokens-Remaining", String.valueOf(z80Var.f4414e));
            Integer num = z80Var.f4415f;
            if (num != null) {
                ihVar.f3060f.put("X-Braze-Ept-Req-Tokens-Remaining", String.valueOf(num.intValue()));
            }
            int i10 = c00.f2479a;
            w00 w00VarA = x00Var.a(b90VarE, ihVar.f3060f, jSONObjectB);
            if (w00VarA.f4159c != null) {
                fh0Var = new s50(ihVar.f3061g, w00VarA, h00Var);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) ihVar, BrazeLogger.Priority.E, (Throwable) null, false, (h9.a) xg.f4270a, 6, (Object) null);
                ((vw) v00Var3).b(BrazeNetworkFailureEvent.class, new BrazeNetworkFailureEvent(ihVar.f3061g, w00VarA));
                fh0Var = new fh0(ihVar.f3061g, w00VarA);
            }
            fh0Var2 = fh0Var;
        }
        if (fh0Var2 instanceof s50) {
            s50 apiResponse = (s50) fh0Var2;
            kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
            d10 d10Var = apiResponse.f3820d;
            if (d10Var == null) {
                juVar.c(((tg) ihVar.f3061g).e());
                v00Var = v00Var2;
                ihVar.f3061g.a(v00Var, v00Var3, apiResponse);
                a80Var.a(apiResponse);
            } else {
                v00Var = v00Var2;
                ihVar.a(d10Var);
                ihVar.f3061g.a(v00Var, v00Var3, apiResponse.f3820d);
                a80Var.a((n) apiResponse);
            }
            kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
            String str = ((tf) h00Var).f3920b;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) ihVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new fh(str), 6, (Object) null);
            JSONArray jSONArray = apiResponse.f3829m;
            if (jSONArray != null) {
                vg.a(jSONArray, new ah(ihVar, jSONArray, str));
            }
            dm dmVar = apiResponse.f3822f;
            if (dmVar != null) {
                vg.a(dmVar, new yg(ihVar, dmVar, str));
            }
            fb0 fb0Var = apiResponse.f3825i;
            if (fb0Var != null) {
                vg.a(fb0Var, new ch(ihVar, fb0Var));
            }
            ArrayList arrayList = apiResponse.f3824h;
            if (arrayList != null) {
                vg.a(arrayList, new eh(ihVar, arrayList));
            }
            ArrayList arrayList2 = apiResponse.f3826j;
            if (arrayList2 != null) {
                vg.a(arrayList2, new bh(ihVar, arrayList2));
            }
            JSONArray jSONArray2 = apiResponse.f3827k;
            if (jSONArray2 != null) {
                vg.a(jSONArray2, new zg(ihVar, jSONArray2));
            }
            InAppMessageBase inAppMessageBase = apiResponse.f3823g;
            if (inAppMessageBase != null) {
                vg.a(inAppMessageBase, new dh(ihVar, inAppMessageBase, str));
            }
            String str2 = apiResponse.f3828l;
            if (str2 != null) {
                ((vw) v00Var).b(ys.class, new ys(str2));
            }
            r90 r90Var = apiResponse.f3831o;
            if (r90Var != null) {
                ((vw) v00Var).b(x90.class, new x90(r90Var));
            }
            if (apiResponse.f3820d instanceof i90) {
                ((vw) v00Var).b(ds.class, new ds(ihVar.f3061g));
                return;
            } else {
                ((vw) v00Var).b(es.class, new es(ihVar.f3061g));
                return;
            }
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) ihVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) hh.f2981a, 6, (Object) null);
        y40 y40Var = new y40(ihVar.f3061g, fh0Var2.f3458a);
        ihVar.f3061g.a(v00Var2, v00Var3, y40Var);
        ((vw) v00Var2).b(ds.class, new ds(ihVar.f3061g));
        ihVar.a(y40Var);
        a80Var.a(fh0Var2);
    }
}
