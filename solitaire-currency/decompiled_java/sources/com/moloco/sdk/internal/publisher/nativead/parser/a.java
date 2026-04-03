package com.moloco.sdk.internal.publisher.nativead.parser;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.moloco.sdk.internal.publisher.nativead.model.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v8.t;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public final a.AbstractC0316a.C0317a a(JSONObject jSONObject, int i10, boolean z10) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Integer numValueOf = jSONObject.has("type") ? Integer.valueOf(jSONObject.getInt("type")) : null;
        Integer numValueOf2 = jSONObject.has("len") ? Integer.valueOf(jSONObject.getInt("len")) : null;
        String string = jSONObject.getString("value");
        t.h(string, "getString(\"value\")");
        return new a.AbstractC0316a.C0317a(i10, z10, numValueOf, numValueOf2, string);
    }

    public final a.c b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String url = jSONObject.getString("url");
        String string = jSONObject.has("fallback") ? jSONObject.getString("fallback") : null;
        List<String> listH = h(jSONObject.optJSONArray("clicktrackers"));
        t.h(url, "url");
        return new a.c(url, listH, string);
    }

    @NotNull
    public final Object c(@NotNull String nativeOrtbString) {
        t.i(nativeOrtbString, "nativeOrtbString");
        try {
            JSONObject jSONObject = new JSONObject(nativeOrtbString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("native");
            if (jSONObjectOptJSONObject != null) {
                t.h(jSONObjectOptJSONObject, "it.optJSONObject(\"native\") ?: it");
                jSONObject = jSONObjectOptJSONObject;
            }
            t.a aVar = v8.t.f35208b;
            return v8.t.b(new com.moloco.sdk.internal.publisher.nativead.model.a(jSONObject.has("ver") ? jSONObject.getString("ver") : null, d(jSONObject.optJSONArray("assets")), b(jSONObject.optJSONObject("link")), h(jSONObject.optJSONArray("imptrackers")), f(jSONObject.optJSONArray("eventtrackers")), jSONObject.has("privacy") ? jSONObject.getString("privacy") : null));
        } catch (Exception e10) {
            t.a aVar2 = v8.t.f35208b;
            return v8.t.b(u.a(e10));
        }
    }

    public final List<a.AbstractC0316a> d(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return v.l();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            if (jSONObject.has("id")) {
                int i11 = jSONObject.getInt("id");
                boolean z10 = jSONObject.optInt("required", 0) == 1;
                Object objG = g(jSONObject.optJSONObject("title"), i11, z10);
                if (objG == null && (objG = e(jSONObject.optJSONObject("img"), i11, z10)) == null && (objG = i(jSONObject.optJSONObject("video"), i11, z10)) == null) {
                    objG = a(jSONObject.optJSONObject("data"), i11, z10);
                }
                if (objG != null) {
                    arrayList.add(objG);
                }
            }
        }
        return arrayList;
    }

    public final a.AbstractC0316a.b e(JSONObject jSONObject, int i10, boolean z10) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Integer numValueOf = jSONObject.has("type") ? Integer.valueOf(jSONObject.getInt("type")) : null;
        String string = jSONObject.getString("url");
        kotlin.jvm.internal.t.h(string, "getString(\"url\")");
        return new a.AbstractC0316a.b(i10, z10, numValueOf, string, jSONObject.has("w") ? Integer.valueOf(jSONObject.getInt("w")) : null, jSONObject.has(CmcdData.Factory.STREAMING_FORMAT_HLS) ? Integer.valueOf(jSONObject.getInt(CmcdData.Factory.STREAMING_FORMAT_HLS)) : null);
    }

    public final List<a.b> f(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return v.l();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            arrayList.add(new a.b(jSONObject.getInt(NotificationCompat.CATEGORY_EVENT), jSONObject.getInt("method"), jSONObject.has("url") ? jSONObject.getString("url") : null));
        }
        return arrayList;
    }

    public final a.AbstractC0316a.c g(JSONObject jSONObject, int i10, boolean z10) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("text");
        kotlin.jvm.internal.t.h(string, "getString(\"text\")");
        return new a.AbstractC0316a.c(i10, z10, string, jSONObject.has("len") ? Integer.valueOf(jSONObject.getInt("len")) : null);
    }

    public final List<String> h(JSONArray jSONArray) {
        if (jSONArray == null) {
            return v.l();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }

    public final a.AbstractC0316a.d i(JSONObject jSONObject, int i10, boolean z10) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("vasttag");
        kotlin.jvm.internal.t.h(string, "getString(\"vasttag\")");
        return new a.AbstractC0316a.d(i10, z10, string);
    }
}
