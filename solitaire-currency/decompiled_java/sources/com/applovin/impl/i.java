package com.applovin.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5359b;

    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5364a;

        a(String str) {
            this.f5364a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f5364a;
        }
    }

    public i(String str, com.applovin.impl.sdk.j jVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f5359b = str;
        this.f5358a = jVar;
    }

    public JSONObject a() {
        if (c() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f5359b.substring(d().length()), 0), "UTF-8"));
                this.f5358a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5358a.I().a("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e10) {
                this.f5358a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5358a.I().a("AdToken", "Unable to decode token '" + this.f5359b + "' into JSON", e10);
                }
                this.f5358a.A().a("AdToken", "decodeFullAdResponseStr", e10);
                return null;
            }
        } catch (UnsupportedEncodingException e11) {
            this.f5358a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5358a.I().a("AdToken", "Unable to process ad response from token '" + this.f5359b + "'", e11);
            }
            this.f5358a.A().a("AdToken", "decodeFullAdResponse", e11);
            return null;
        }
    }

    public String b() {
        return this.f5359b;
    }

    public a c() {
        return a(l4.f5765w0) != null ? a.REGULAR : a(l4.f5772x0) != null ? a.AD_RESPONSE_JSON : a.UNSPECIFIED;
    }

    public String d() {
        String strA = a(l4.f5765w0);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = a(l4.f5772x0);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return strA2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        String str = this.f5359b;
        String str2 = ((i) obj).f5359b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f5359b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdToken{id=" + StringUtils.prefixToIndex(32, this.f5359b) + ", type=" + c() + '}';
    }

    private String a(l4 l4Var) {
        for (String str : this.f5358a.c(l4Var)) {
            if (this.f5359b.startsWith(str)) {
                return str;
            }
        }
        return null;
    }
}
