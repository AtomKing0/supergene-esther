package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.qf;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f11839b = "dj";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11840c = "supersonic_shared_preferen";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11841d = "version";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11842e = "back_button_state";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f11843f = "search_keys";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11844g = "^\\d+_\\d+$";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static dj f11845h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f11846a;

    private dj(Context context) {
        this.f11846a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized dj a(Context context) {
        if (f11845h == null) {
            f11845h = new dj(context);
        }
        return f11845h;
    }

    public static synchronized dj e() {
        return f11845h;
    }

    public qf.a b() {
        int i10 = Integer.parseInt(this.f11846a.getString(f11842e, "2"));
        return i10 == 0 ? qf.a.None : i10 == 1 ? qf.a.Device : i10 == 2 ? qf.a.Controller : qf.a.Controller;
    }

    public String c() {
        return this.f11846a.getString("version", "-1");
    }

    public List<String> d() {
        String string = this.f11846a.getString(f11843f, null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            wp wpVar = new wp(string);
            if (wpVar.a(v8.h.R)) {
                try {
                    arrayList.addAll(wpVar.a((JSONArray) wpVar.b(v8.h.R)));
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                }
            }
        }
        return arrayList;
    }

    private boolean b(String str) {
        return str.matches(f11844g);
    }

    public String a(String str) {
        String string = this.f11846a.getString(str, null);
        return string != null ? string : JsonUtils.EMPTY_JSON;
    }

    public void c(String str) {
        SharedPreferences.Editor editorEdit = this.f11846a.edit();
        editorEdit.putString(f11842e, str);
        editorEdit.apply();
    }

    public void d(String str) {
        if (c().equalsIgnoreCase(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f11846a.edit();
        editorEdit.putString("version", str);
        editorEdit.apply();
    }

    public void e(String str) {
        SharedPreferences.Editor editorEdit = this.f11846a.edit();
        editorEdit.putString(f11843f, str);
        editorEdit.apply();
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = (String[]) this.f11846a.getAll().keySet().toArray(new String[0]);
        SharedPreferences.Editor editorEdit = this.f11846a.edit();
        for (String str : strArr) {
            if (b(str)) {
                arrayList.add(str);
                editorEdit.remove(str);
            }
        }
        editorEdit.apply();
        return arrayList;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f11846a.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public boolean a(String str, String str2, String str3) {
        String string = this.f11846a.getString("ssaUserData", null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor editorEdit = this.f11846a.edit();
            editorEdit.putString("ssaUserData", jSONObject.toString());
            editorEdit.apply();
            return true;
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }
}
