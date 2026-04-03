package com.applovin.impl;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5551e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5552f = -1;

    private k7() {
    }

    public static k7 a(b8 b8Var, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        List<String> listExplode;
        int size;
        long seconds;
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = b8Var.d();
            if (TextUtils.isEmpty(strD)) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("VastTracker", "Unable to create tracker. Could not find URL.");
                }
                return null;
            }
            k7 k7Var = new k7();
            k7Var.f5549c = strD;
            k7Var.f5547a = (String) b8Var.a().get("id");
            k7Var.f5548b = (String) b8Var.a().get(NotificationCompat.CATEGORY_EVENT);
            k7Var.f5550d = ((Boolean) jVar.a(l4.E4)).booleanValue();
            if (e7Var != null) {
                k7Var.f5550d = JsonUtils.getBoolean(e7Var.b(), "vast_fire_trackers_from_webview", Boolean.valueOf(k7Var.f5550d)).booleanValue();
            }
            k7Var.f5552f = a(k7Var.b(), e7Var);
            String str = (String) b8Var.a().get(TypedValues.CycleType.S_WAVE_OFFSET);
            if (StringUtils.isValidString(str)) {
                String strTrim = str.trim();
                if (strTrim.contains("%")) {
                    k7Var.f5552f = StringUtils.parseInt(strTrim.substring(0, strTrim.length() - 1));
                } else if (strTrim.contains(":") && (size = (listExplode = CollectionUtils.explode(strTrim, ":")).size()) > 0) {
                    int i10 = size - 1;
                    long j10 = 0;
                    for (int i11 = i10; i11 >= 0; i11--) {
                        String str2 = listExplode.get(i11);
                        if (StringUtils.isNumeric(str2)) {
                            int i12 = Integer.parseInt(str2);
                            if (i11 == i10) {
                                seconds = i12;
                            } else if (i11 == size - 2) {
                                seconds = TimeUnit.MINUTES.toSeconds(i12);
                            } else if (i11 == size - 3) {
                                seconds = TimeUnit.HOURS.toSeconds(i12);
                            }
                            j10 += seconds;
                        }
                    }
                    k7Var.f5551e = j10;
                    k7Var.f5552f = -1;
                }
            }
            return k7Var;
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastTracker", "Error occurred while initializing", th);
            }
            jVar.A().a("VastTracker", th);
            return null;
        }
    }

    public String b() {
        return this.f5548b;
    }

    public String c() {
        return this.f5549c;
    }

    public boolean d() {
        return this.f5550d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k7)) {
            return false;
        }
        k7 k7Var = (k7) obj;
        if (this.f5551e != k7Var.f5551e || this.f5552f != k7Var.f5552f) {
            return false;
        }
        String str = this.f5547a;
        if (str == null ? k7Var.f5547a != null : !str.equals(k7Var.f5547a)) {
            return false;
        }
        String str2 = this.f5548b;
        if (str2 == null ? k7Var.f5548b == null : str2.equals(k7Var.f5548b)) {
            return this.f5549c.equals(k7Var.f5549c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f5547a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f5548b;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f5549c.hashCode()) * 31;
        long j10 = this.f5551e;
        return ((iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f5552f;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f5547a + "', event='" + this.f5548b + "', uriString='" + this.f5549c + "', offsetSeconds=" + this.f5551e + ", offsetPercent=" + this.f5552f + '}';
    }

    public boolean a(long j10, int i10) {
        long j11 = this.f5551e;
        boolean z10 = j11 >= 0;
        boolean z11 = j10 >= j11;
        int i11 = this.f5552f;
        boolean z12 = i11 >= 0;
        boolean z13 = i10 >= i11;
        if (z10 && z11) {
            return true;
        }
        return z12 && z13;
    }

    private static int a(String str, e7 e7Var) {
        if (TtmlNode.START.equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (e7Var != null) {
            return e7Var.g();
        }
        return 95;
    }

    public static k7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        k7 k7Var = new k7();
        String string = JsonUtils.getString(jSONObject, "uri_string", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        k7Var.f5549c = string;
        k7Var.f5547a = JsonUtils.getString(jSONObject, ViewHierarchyNode.JsonKeys.IDENTIFIER, "");
        k7Var.f5548b = JsonUtils.getString(jSONObject, NotificationCompat.CATEGORY_EVENT, "");
        k7Var.f5551e = JsonUtils.getLong(jSONObject, "offset_seconds", -1L);
        k7Var.f5552f = JsonUtils.getInt(jSONObject, "offset_percent", -1);
        return k7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, ViewHierarchyNode.JsonKeys.IDENTIFIER, this.f5547a);
        JsonUtils.putString(jSONObject, NotificationCompat.CATEGORY_EVENT, this.f5548b);
        JsonUtils.putString(jSONObject, "uri_string", this.f5549c);
        JsonUtils.putLong(jSONObject, "offset_seconds", this.f5551e);
        JsonUtils.putInt(jSONObject, "offset_percent", this.f5552f);
        return jSONObject;
    }
}
