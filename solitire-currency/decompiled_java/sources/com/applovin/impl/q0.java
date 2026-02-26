package com.applovin.impl;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.ironsource.v8;
import io.sentry.protocol.App;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f6627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JSONObject f6628b;

    public enum a {
        NONE(0),
        IS_AL_GDPR(1000),
        IS_ELIGIBLE_FOR_TERMS_AND_PRIVACY_POLICY_ALERT(1001),
        HAS_TERMS_OF_SERVICE_URI(1002);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6634a;

        a(int i10) {
            this.f6634a = i10;
        }

        public int b() {
            return this.f6634a;
        }
    }

    public enum b {
        ALERT,
        POST_ALERT,
        EVENT,
        REINIT,
        CMP_LOAD,
        CMP_SHOW,
        DECISION
    }

    public q0(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f6627a = jVar;
        this.f6628b = jSONObject;
    }

    public static q0 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        b bVarC = c(JsonUtils.getString(jSONObject, "type", null));
        return bVarC == b.ALERT ? new r0(jSONObject, jVar) : bVarC == b.EVENT ? new t0(jSONObject, jVar) : new q0(jSONObject, jVar);
    }

    public int b() {
        return JsonUtils.getInt(this.f6628b, "id", -1);
    }

    public b c() {
        return c(JsonUtils.getString(this.f6628b, "type", null));
    }

    public String toString() {
        return "ConsentFlowState{id=" + b() + ", type=" + c() + "}";
    }

    private static b c(String str) {
        if ("alert".equalsIgnoreCase(str)) {
            return b.ALERT;
        }
        if ("post_alert".equalsIgnoreCase(str)) {
            return b.POST_ALERT;
        }
        if (NotificationCompat.CATEGORY_EVENT.equalsIgnoreCase(str)) {
            return b.EVENT;
        }
        if ("cmp_load".equalsIgnoreCase(str)) {
            return b.CMP_LOAD;
        }
        if ("cmp_show".equalsIgnoreCase(str)) {
            return b.CMP_SHOW;
        }
        if ("decision".equalsIgnoreCase(str)) {
            return b.DECISION;
        }
        if ("reinit".equalsIgnoreCase(str)) {
            return b.REINIT;
        }
        throw new IllegalArgumentException("Invalid type provided: " + str);
    }

    protected String b(String str) {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f6628b, str, (JSONObject) null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "replacements", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String string = JsonUtils.getObjectAtIndex(jSONArray, i10, "").toString();
            if ("<APP_NAME>".equalsIgnoreCase(string)) {
                String str2 = (String) this.f6627a.y().J().get(App.JsonKeys.APP_NAME);
                if (StringUtils.isValidString(str2)) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(com.applovin.impl.sdk.j.a("THIS_APP"));
                }
            } else {
                arrayList.add(string);
            }
        }
        return com.applovin.impl.sdk.j.a(JsonUtils.getString(jSONObject, v8.h.W, null), arrayList);
    }

    public a a() {
        return a(JsonUtils.getString(this.f6628b, "decision_type", null));
    }

    public int a(Boolean bool) {
        int i10 = JsonUtils.getInt(this.f6628b, "destination_state_id", -1);
        if (i10 > 0) {
            return i10;
        }
        if (bool != null) {
            return bool.booleanValue() ? JsonUtils.getInt(this.f6628b, "destination_state_id_true", -1) : JsonUtils.getInt(this.f6628b, "destination_state_id_false", -1);
        }
        throw new IllegalStateException("Decision needed for state: " + i10);
    }

    private static a a(String str) {
        if ("is_al_gdpr".equalsIgnoreCase(str)) {
            return a.IS_AL_GDPR;
        }
        if ("is_eligible_for_terms_and_privacy_policy_alert".equalsIgnoreCase(str)) {
            return a.IS_ELIGIBLE_FOR_TERMS_AND_PRIVACY_POLICY_ALERT;
        }
        if ("has_terms_of_service_uri".equalsIgnoreCase(str)) {
            return a.HAS_TERMS_OF_SERVICE_URI;
        }
        return a.NONE;
    }
}
