package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f5390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5391c;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private i7() {
    }

    static i7 a(b8 b8Var, i7 i7Var, com.applovin.impl.sdk.j jVar) {
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (i7Var == null) {
            try {
                i7Var = new i7();
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastNonVideoResource", "Error occurred while initializing", th);
                }
                jVar.A().a("VastNonVideoResource", th);
                return null;
            }
        }
        if (i7Var.f5390b == null && !StringUtils.isValidString(i7Var.f5391c)) {
            String strA = a(b8Var, "StaticResource");
            if (URLUtil.isValidUrl(strA)) {
                i7Var.f5390b = Uri.parse(strA);
                i7Var.f5389a = a.STATIC;
                return i7Var;
            }
            String strA2 = a(b8Var, "IFrameResource");
            if (StringUtils.isValidString(strA2)) {
                i7Var.f5389a = a.IFRAME;
                if (URLUtil.isValidUrl(strA2)) {
                    i7Var.f5390b = Uri.parse(strA2);
                } else {
                    i7Var.f5391c = strA2;
                }
                return i7Var;
            }
            String strA3 = a(b8Var, "HTMLResource");
            if (StringUtils.isValidString(strA3)) {
                i7Var.f5389a = a.HTML;
                if (URLUtil.isValidUrl(strA3)) {
                    i7Var.f5390b = Uri.parse(strA3);
                } else {
                    i7Var.f5391c = strA3;
                }
            }
        }
        return i7Var;
    }

    public String b() {
        return this.f5391c;
    }

    public Uri c() {
        return this.f5390b;
    }

    public a d() {
        return this.f5389a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i7)) {
            return false;
        }
        i7 i7Var = (i7) obj;
        if (this.f5389a != i7Var.f5389a) {
            return false;
        }
        Uri uri = this.f5390b;
        if (uri == null ? i7Var.f5390b != null : !uri.equals(i7Var.f5390b)) {
            return false;
        }
        String str = this.f5391c;
        String str2 = i7Var.f5391c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        a aVar = this.f5389a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f5390b;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f5391c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f5389a + ", resourceUri=" + this.f5390b + ", resourceContents='" + this.f5391c + "'}";
    }

    private static String a(b8 b8Var, String str) {
        b8 b8VarC = b8Var.c(str);
        if (b8VarC != null) {
            return b8VarC.d();
        }
        return null;
    }

    public void a(Uri uri) {
        this.f5390b = uri;
    }

    public void a(String str) {
        this.f5391c = str;
    }

    public static i7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "type", null);
        a aVarValueOf = string == null ? null : a.valueOf(string);
        String string2 = JsonUtils.getString(jSONObject, "resource_uri", null);
        Uri uri = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        i7 i7Var = new i7();
        i7Var.f5389a = aVarValueOf;
        i7Var.f5390b = uri;
        i7Var.f5391c = JsonUtils.getString(jSONObject, "resource_contents", null);
        return i7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a aVar = this.f5389a;
        JsonUtils.putString(jSONObject, "type", aVar == null ? null : aVar.toString());
        Uri uri = this.f5390b;
        JsonUtils.putString(jSONObject, "resource_uri", uri != null ? uri.toString() : null);
        JsonUtils.putString(jSONObject, "resource_contents", this.f5391c);
        return jSONObject;
    }
}
