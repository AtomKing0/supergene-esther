package com.king.amp.sa;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdVerification.java */
/* JADX INFO: loaded from: classes4.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private String f16836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private String f16837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f16838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private List<a> f16839d;

    /* JADX INFO: compiled from: AdVerification.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16842c;
    }

    @Nullable
    public String a() {
        return this.f16838c;
    }

    @Nullable
    public String b() {
        return this.f16836a;
    }

    @Nullable
    public String c() {
        return this.f16837b;
    }

    @Nullable
    public List<a> d() {
        return this.f16839d;
    }

    public boolean e(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("partner_name")) {
                this.f16836a = jSONObject.getString("partner_name");
            }
            if (jSONObject.has("partner_version")) {
                this.f16837b = jSONObject.getString("partner_version");
            }
            if (jSONObject.has("custom_data")) {
                this.f16838c = jSONObject.getString("custom_data");
            }
            this.f16839d = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("verifications");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                a aVar = new a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (jSONObject2.has(v8.h.W)) {
                    aVar.f16840a = jSONObject2.getString(v8.h.W);
                }
                if (jSONObject2.has("js")) {
                    aVar.f16841b = jSONObject2.getString("js");
                }
                if (jSONObject2.has("params")) {
                    aVar.f16842c = jSONObject2.getString("params");
                }
                this.f16839d.add(aVar);
            }
            List<a> list = this.f16839d;
            return (list == null || list.isEmpty()) ? false : true;
        } catch (JSONException e10) {
            Log.w("AdVerification", "Failed to parse json", e10);
            return false;
        }
    }
}
