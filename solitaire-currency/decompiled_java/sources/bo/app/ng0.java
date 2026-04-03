package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ng0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ng0 f3487a = new ng0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3488b = BrazeLogger.getBrazeLogTag((Class<?>) ng0.class);

    public static InAppMessageBase a(JSONObject jSONObject, h00 brazeManager) {
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        try {
            if (jSONObject == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f3488b, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) eg0.f2733a, 14, (Object) null);
                return null;
            }
            String string = jSONObject.getString("type");
            if (!kotlin.jvm.internal.t.d(string, "inapp")) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f3488b, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new fg0(string), 12, (Object) null);
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (jSONObject2 == null) {
                return null;
            }
            return com.braze.support.j.a(jSONObject2, brazeManager);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f3488b, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new gg0(jSONObject), 8, (Object) null);
            return null;
        }
    }

    public final dh0 b(JSONObject actionJson, h00 brazeManager) {
        String string;
        kotlin.jvm.internal.t.i(actionJson, "actionJson");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        try {
            string = actionJson.getString("type");
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f3488b, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new kg0(actionJson), 8, (Object) null);
        }
        if (kotlin.jvm.internal.t.d(string, "inapp")) {
            return new q30(actionJson, brazeManager);
        }
        if (kotlin.jvm.internal.t.d(string, "templated_iam")) {
            return new md0(actionJson, brazeManager);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new jg0(string), 6, (Object) null);
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList a(org.json.JSONArray r13) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.ng0.a(org.json.JSONArray):java.util.ArrayList");
    }

    public final ArrayList a(JSONArray jSONArray, h00 brazeManager) {
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        try {
            if (jSONArray == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f3488b, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lg0.f3334a, 14, (Object) null);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject actionJson = jSONArray.getJSONObject(i10);
                kotlin.jvm.internal.t.h(actionJson, "actionJson");
                dh0 dh0VarB = b(actionJson, brazeManager);
                if (dh0VarB != null) {
                    arrayList.add(dh0VarB);
                }
            }
            return arrayList;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f3488b, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new mg0(jSONArray), 8, (Object) null);
            return null;
        }
    }
}
