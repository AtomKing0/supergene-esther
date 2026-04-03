package o2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClearKeyUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    public static byte[] a(byte[] bArr) {
        return a4.o0.f214a >= 27 ? bArr : a4.o0.h0(c(a4.o0.A(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (a4.o0.f214a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(a4.o0.A(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (i10 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return a4.o0.h0(sb.toString());
        } catch (JSONException e10) {
            a4.t.d("ClearKeyUtil", "Failed to adjust response data: " + a4.o0.A(bArr), e10);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
