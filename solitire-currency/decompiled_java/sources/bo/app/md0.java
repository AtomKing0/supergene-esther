package bo.app;

import android.content.Context;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class md0 extends dh0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h00 f3409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f3411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3412j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public md0(JSONObject json, h00 brazeManager) throws JSONException {
        super(json);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        this.f3411i = new ArrayList();
        this.f3412j = -1L;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new hd0(json), 7, (Object) null);
        this.f3409g = brazeManager;
        JSONObject jSONObject = json.getJSONObject("data");
        String string = jSONObject.getString("trigger_id");
        kotlin.jvm.internal.t.h(string, "dataObject.getString(TRIGGER_ID)");
        this.f3410h = string;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("prefetch_image_urls");
        if (jSONArrayOptJSONArray != null) {
            a(jSONArrayOptJSONArray, t70.IMAGE);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("prefetch_zip_urls");
        if (jSONArrayOptJSONArray2 != null) {
            a(jSONArrayOptJSONArray2, t70.ZIP);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("prefetch_file_urls");
        if (jSONArrayOptJSONArray3 != null) {
            a(jSONArrayOptJSONArray3, t70.FILE);
        }
    }

    public final void a(JSONArray jSONArray, t70 t70Var) {
        Iterator it = o9.o.s(o9.o.k(kotlin.collections.d0.a0(n9.o.u(0, jSONArray.length())), new id0(jSONArray)), new jd0(jSONArray)).iterator();
        while (it.hasNext()) {
            this.f3411i.add(new s70(t70Var, (String) it.next()));
        }
    }

    public final String d() {
        return this.f3410h;
    }

    public final long e() {
        return this.f3412j;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObjectB = super.b();
            if (jSONObjectB == null) {
                return null;
            }
            jSONObjectB.put("type", "templated_iam");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trigger_id", this.f3410h);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (s70 s70Var : this.f3411i) {
                int iOrdinal = s70Var.f3836a.ordinal();
                if (iOrdinal == 0) {
                    jSONArray2.put(s70Var.f3837b);
                } else if (iOrdinal == 1) {
                    jSONArray.put(s70Var.f3837b);
                } else if (iOrdinal == 2) {
                    jSONArray3.put(s70Var.f3837b);
                }
            }
            jSONObject.put("prefetch_image_urls", jSONArray);
            jSONObject.put("prefetch_zip_urls", jSONArray2);
            jSONObject.put("prefetch_file_urls", jSONArray3);
            jSONObjectB.put("data", jSONObject);
            return jSONObjectB;
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) kd0.f3244a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.k10
    public final void a(Context context, v00 internalEventPublisher, g10 triggerEvent, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        this.f3412j = j10;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ld0(this), 7, (Object) null);
        tf tfVar = (tf) this.f3409g;
        tfVar.getClass();
        kotlin.jvm.internal.t.i(this, "templatedTriggeredAction");
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        tfVar.a(new gd0(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), this, triggerEvent, tfVar.f3920b));
    }

    @Override // bo.app.k10
    public final ArrayList a() {
        return new ArrayList(this.f3411i);
    }
}
