package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import com.applovin.impl.m0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f6375a = {7, 4, 2, 1, 11};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f6376b = {5, 6, 12, 10, 3, 9, 8, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f6377c = {15, 13};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f6378d = {20};

    public static String a(String str, com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(l4.f5735s0), str, jVar);
    }

    public static String b(String str, com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(l4.f5727r0), str, jVar);
    }

    public static Map c(com.applovin.impl.sdk.j jVar) {
        HashMap map = new HashMap();
        String str = (String) jVar.a(l4.f5662j);
        if (StringUtils.isValidString(str)) {
            map.put("device_token", str);
        } else if (!((Boolean) jVar.a(l4.F4)).booleanValue()) {
            map.put("api_key", jVar.b0());
        }
        map.putAll(z6.a(jVar.y().e()));
        return map;
    }

    public static String d(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(l4.f5719q0), "4.0/ad", jVar);
    }

    public static String e(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(l4.f5711p0), "4.0/ad", jVar);
    }

    public static Long f(com.applovin.impl.sdk.j jVar) {
        m0.d dVarA = jVar.u().a();
        if (dVarA == null) {
            return null;
        }
        double dC = z6.c(dVarA.b());
        double d10 = z6.d(dVarA.a());
        if (d10 == 0.0d) {
            return null;
        }
        return Long.valueOf((long) (dC / d10));
    }

    public static String g(com.applovin.impl.sdk.j jVar) {
        NetworkInfo networkInfoB = b(com.applovin.impl.sdk.j.n());
        if (networkInfoB == null) {
            return "unknown";
        }
        int type = networkInfoB.getType();
        int subtype = networkInfoB.getSubtype();
        return type == 1 ? com.ironsource.r8.f14655b : type == 0 ? a(subtype, f6375a) ? "2g" : a(subtype, f6376b) ? com.ironsource.r8.f14654a : a(subtype, f6377c) ? "4g" : a(subtype, f6378d) ? "5g" : "mobile" : "unknown";
    }

    public static void a(JSONObject jSONObject, boolean z10, com.applovin.impl.sdk.j jVar) {
        jVar.r().a(jSONObject, z10);
    }

    public static void b(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", null);
        if (StringUtils.isValidString(string)) {
            jVar.b(n4.D, string);
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().d("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static void a(int i10, com.applovin.impl.sdk.j jVar) {
        if (i10 == 401) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "SDK key \"" + jVar.b0() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
            return;
        }
        if (i10 == 418) {
            jVar.h0().a(l4.f5622e, Boolean.TRUE);
            jVar.h0().e();
        } else if (i10 >= 400 && i10 < 500) {
            if (((Boolean) jVar.a(l4.f5638g)).booleanValue()) {
                jVar.N0();
            }
        } else if (i10 == -1 && ((Boolean) jVar.a(l4.f5638g)).booleanValue()) {
            jVar.N0();
        }
    }

    private static NetworkInfo b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static void c(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (jVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    m4 m4VarH0 = jVar.h0();
                    if (jSONObject.isNull("settings")) {
                        return;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
                    m4VarH0.a(jSONObject2);
                    m4VarH0.e();
                    String strB = l4.X5.b();
                    if (JsonUtils.valueExists(jSONObject2, strB)) {
                        o4.b(n4.F, JsonUtils.getBoolean(jSONObject2, strB, Boolean.FALSE), com.applovin.impl.sdk.j.n());
                        return;
                    }
                    return;
                }
                return;
            } catch (JSONException e10) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("ConnectionUtils", "Unable to parse settings out of API response", e10);
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static String b(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(l4.f5711p0), ((Boolean) jVar.a(l4.U2)).booleanValue() ? "5.0/ad" : "4.0/ad", jVar);
    }

    public static String a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (jVar != null) {
            return str + str2;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.j.n()).edit();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, null);
                if (object != null) {
                    o4.a(next, object, (SharedPreferences) null, editorEdit);
                }
            }
            if (((Boolean) jVar.a(l4.T5)).booleanValue()) {
                o4.a(editorEdit);
            } else {
                editorEdit.apply();
            }
        }
    }

    public static byte[] a(InputStream inputStream, com.applovin.impl.sdk.j jVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) jVar.a(l4.N2)).intValue()];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 > 0) {
                byteArrayOutputStream.write(bArr, 0, i10);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo networkInfoB = b(context);
        if (networkInfoB != null) {
            return networkInfoB.isConnected();
        }
        return false;
    }

    private static boolean a(int i10, int[] iArr) {
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(l4.f5719q0), ((Boolean) jVar.a(l4.U2)).booleanValue() ? "5.0/ad" : "4.0/ad", jVar);
    }
}
