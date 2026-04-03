package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class bh0 implements k10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g90 f2453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dg0 f2455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f2456e;

    public bh0(JSONObject json) throws JSONException {
        kotlin.jvm.internal.t.i(json, "json");
        ArrayList arrayList = new ArrayList();
        this.f2456e = arrayList;
        String string = json.getString("id");
        kotlin.jvm.internal.t.h(string, "json.getString(ID)");
        this.f2452a = string;
        this.f2453b = new g90(json);
        JSONArray triggers = json.getJSONArray("trigger_condition");
        if (triggers.length() > 0) {
            ng0 ng0Var = ng0.f3487a;
            kotlin.jvm.internal.t.h(triggers, "triggers");
            arrayList.addAll(ng0.a(triggers));
        }
        this.f2454c = json.optBoolean("prefetch", true);
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = (JSONObject) this.f2453b.forJsonPut();
            if (jSONObject != null) {
                jSONObject.put("id", this.f2452a);
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f2456e.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((f10) it.next()).forJsonPut());
                }
                jSONObject.put("trigger_condition", jSONArray);
                jSONObject.put("prefetch", this.f2454c);
                return jSONObject;
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public final g90 c() {
        return this.f2453b;
    }

    public final boolean b(g10 event) {
        kotlin.jvm.internal.t.i(event, "event");
        if ((this.f2453b.f2883a != -1 && DateTimeUtils.nowInSeconds() <= this.f2453b.f2883a) || (this.f2453b.f2884b != -1 && DateTimeUtils.nowInSeconds() >= this.f2453b.f2884b)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ah0(this, event), 7, (Object) null);
            return false;
        }
        Iterator it = this.f2456e.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (((f10) it.next()).a(event)) {
                return i10 != -1;
            }
            i10++;
        }
        return false;
    }
}
