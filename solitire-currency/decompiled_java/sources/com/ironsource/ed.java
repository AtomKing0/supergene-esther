package com.ironsource;

import android.content.Context;
import com.ironsource.ad;
import com.ironsource.environment.ContextProvider;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11914a = "adunit_data";

    public void a(Context context) {
        bd.a().c(context);
    }

    public void a(@NotNull String str, @NotNull ad.a aVar) {
        JSONObject jSONObjectOptJSONObject;
        try {
            String strName = aVar.name();
            bd bdVarA = bd.a();
            JSONObject jSONObjectOptJSONObject2 = bdVarA.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f11914a);
            if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(strName)) == null || jSONObjectOptJSONObject.remove(str) == null) {
                return;
            }
            bdVarA.b(f11914a, jSONObjectOptJSONObject2.put(strName, jSONObjectOptJSONObject));
        } catch (JSONException e10) {
            i9.d().a(e10);
        }
    }

    public void a(String str, Object obj) {
        bd.a().b(str, obj);
    }

    public void a(@NotNull String str, @NotNull Object obj, @NotNull ad.a aVar) {
        try {
            String strName = aVar.name();
            bd bdVarA = bd.a();
            JSONObject jSONObjectOptJSONObject = bdVarA.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f11914a);
            if (jSONObjectOptJSONObject == null) {
                bdVarA.b(f11914a, new JSONObject().put(strName, new JSONObject().put(str, obj)));
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(strName);
            if (jSONObjectOptJSONObject2 == null) {
                bdVarA.b(f11914a, jSONObjectOptJSONObject.put(strName, new JSONObject().put(str, obj)));
            } else {
                bdVarA.b(f11914a, jSONObjectOptJSONObject.put(strName, jSONObjectOptJSONObject2.put(str, obj)));
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        bd.a().a(str, jSONObject);
    }

    public void a(Map<String, Object> map) {
        bd.a().a(map);
    }
}
