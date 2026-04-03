package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class tc0 implements e10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3913a;

    public tc0(Context context, String str, String str2) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f3913a = context.getSharedPreferences("com.appboy.storage.session_storage" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
    }

    @Override // bo.app.e10
    public final void a(String sessionId) {
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
        SharedPreferences.Editor editorEdit = this.f3913a.edit();
        editorEdit.remove(sessionId);
        if (kotlin.jvm.internal.t.d(sessionId, this.f3913a.getString("current_open_session", null))) {
            editorEdit.remove("current_open_session");
        }
        editorEdit.apply();
    }

    @Override // bo.app.e10
    public final zb0 a() {
        String str = "";
        if (!this.f3913a.contains("current_open_session")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) rc0.f3771a, 7, (Object) null);
            return null;
        }
        try {
            String string = this.f3913a.getString(this.f3913a.getString("current_open_session", ""), "");
            if (string != null) {
                str = string;
            }
            return new zb0(new JSONObject(str));
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) sc0.f3848a, 4, (Object) null);
            return null;
        }
    }

    @Override // bo.app.e10
    public final void a(w40 session) {
        kotlin.jvm.internal.t.i(session, "session");
        String str = session.f4421a.f2502b;
        JSONObject jSONObjectForJsonPut = session.forJsonPut();
        SharedPreferences.Editor editorEdit = this.f3913a.edit();
        if (!jSONObjectForJsonPut.has("end_time")) {
            try {
                jSONObjectForJsonPut.put("end_time", DateTimeUtils.nowInSecondsPrecise());
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) qc0.f3702a, 4, (Object) null);
            }
        }
        editorEdit.putString(str, jSONObjectForJsonPut.toString());
        if (!session.f4424d) {
            editorEdit.putString("current_open_session", str);
        } else if (kotlin.jvm.internal.t.d(this.f3913a.getString("current_open_session", ""), str)) {
            editorEdit.remove("current_open_session");
        }
        editorEdit.apply();
    }
}
