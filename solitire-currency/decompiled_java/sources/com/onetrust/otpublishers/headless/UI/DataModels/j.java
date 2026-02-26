package com.onetrust.otpublishers.headless.UI.DataModels;

import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    @NotNull
    public static final ArrayList a(@Nullable JSONObject jSONObject, boolean z10) throws JSONException {
        i iVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return arrayList;
        }
        int length = jSONArrayNames.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject itemJson = jSONObject.getJSONObject(jSONArrayNames.get(i10).toString());
            int i11 = -1;
            if (z10) {
                t.h(itemJson, "itemJson");
                String string = jSONArrayNames.get(i10).toString();
                String strA = com.onetrust.otpublishers.headless.UI.extensions.g.a("Name", "", itemJson);
                t.i(itemJson, "<this>");
                t.i("consent", v8.h.W);
                try {
                    i11 = itemJson.getInt("consent");
                } catch (Exception unused) {
                }
                iVar = new i(string, strA, i11 != 0 ? i11 != 1 ? i11 != 2 ? k.NoToggle : k.AlwaysActive : k.Grant : k.Deny);
            } else {
                t.h(itemJson, "itemJson");
                String strA2 = com.onetrust.otpublishers.headless.UI.extensions.g.a("id", "-1", itemJson);
                String strA3 = com.onetrust.otpublishers.headless.UI.extensions.g.a("name", "", itemJson);
                t.i(itemJson, "<this>");
                t.i("consent", v8.h.W);
                try {
                    i11 = itemJson.getInt("consent");
                } catch (Exception unused2) {
                }
                iVar = new i(strA2, strA3, i11 != 0 ? i11 != 1 ? i11 != 2 ? k.NoToggle : k.AlwaysActive : k.Grant : k.Deny);
            }
            arrayList.add(iVar);
        }
        return arrayList;
    }

    @NotNull
    public static final JSONObject b(boolean z10, @NotNull String searchQuery, @NotNull JSONObject jSONObject, @NotNull JSONObject vendorObject) throws JSONException {
        JSONArray jSONArrayNames;
        t.i(jSONObject, "<this>");
        t.i(searchQuery, "searchQuery");
        t.i(vendorObject, "vendorObject");
        JSONObject jSONObject2 = new JSONObject();
        if ((searchQuery.length() == 0) || (jSONArrayNames = vendorObject.names()) == null) {
            return vendorObject;
        }
        String str = z10 ? "Name" : "name";
        int length = jSONArrayNames.length();
        for (int i10 = 0; i10 < length; i10++) {
            String string = jSONArrayNames.getString(i10);
            JSONObject jSONObject3 = vendorObject.getJSONObject(string);
            String string2 = jSONObject3.getString(str);
            t.h(string2, "vendor.getString(nameKey)");
            Locale ENGLISH = Locale.ENGLISH;
            t.h(ENGLISH, "ENGLISH");
            String lowerCase = string2.toLowerCase(ENGLISH);
            t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (r.N(lowerCase, searchQuery, true)) {
                jSONObject2.put(string, jSONObject3);
            }
        }
        return jSONObject2;
    }
}
