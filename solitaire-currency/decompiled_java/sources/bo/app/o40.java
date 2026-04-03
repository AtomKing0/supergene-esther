package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o40 implements x00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x00 f3542a;

    public o40(b00 httpConnector) {
        kotlin.jvm.internal.t.i(httpConnector, "httpConnector");
        this.f3542a = httpConnector;
    }

    public static final String a(o40 o40Var, Map map) {
        o40Var.getClass();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add("|\"" + ((String) entry.getKey()) + "\" => \"" + ((String) entry.getValue()) + '\"');
        }
        return kotlin.collections.d0.r0(arrayList, "\n", null, null, 0, null, null, 62, null);
    }

    @Override // bo.app.x00
    public final w00 a(b90 requestTarget, HashMap requestHeaders, JSONObject payload) {
        kotlin.jvm.internal.t.i(requestTarget, "requestTarget");
        kotlin.jvm.internal.t.i(requestHeaders, "requestHeaders");
        kotlin.jvm.internal.t.i(payload, "payload");
        v8.l lVarA = v8.n.a(new n40(requestTarget, requestHeaders, payload));
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, (BrazeLogger.Priority) null, (Throwable) null, requestTarget.f2428d, new j40(lVarA, requestTarget, this, requestHeaders, payload), 3, (Object) null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) k40.f3213a, 4, (Object) null);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        w00 w00VarA = this.f3542a.a(requestTarget, requestHeaders, payload);
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new l40(lVarA, requestTarget, System.currentTimeMillis() - jCurrentTimeMillis, this, w00VarA.f4158b, w00VarA.f4159c), 7, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) m40.f3392a, 4, (Object) null);
        }
        return w00VarA;
    }
}
