package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2308c3 {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2307c2 A00(C2387dL c2387dL, JSONObject jSONObject, SF sf, C2030Ua c2030Ua, C2285bg c2285bg, boolean z10) {
        boolean z11;
        String strA0S;
        boolean z12 = z10;
        String strA01 = A01(101, 3, 41);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String strOptString = jSONObject.optString(A01(51, 26, 104));
        arrayList3.add(strOptString);
        if (z12) {
            strA0S = sf.A0S(strOptString);
            if (strOptString.equals(strA0S)) {
                z12 = false;
                z11 = false;
            } else {
                z11 = z12;
            }
        } else {
            z11 = z12;
            strA0S = strOptString;
        }
        c2030Ua.A04(UZ.A0P, null);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(92, 4, 49));
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optString(strA01) != null) {
                arrayList.add(jSONObjectOptJSONObject.optString(strA01));
                if (z11) {
                    jSONObjectOptJSONObject.put(strA01, sf.A0R(jSONObjectOptJSONObject.optString(strA01)));
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A01(77, 15, 113));
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    String strOptString2 = jSONArrayOptJSONArray.optString(i10);
                    arrayList.add(strOptString2);
                    if (z11) {
                        jSONArrayOptJSONArray.put(i10, sf.A0R(strOptString2));
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(A01(43, 8, 37));
            if (jSONArrayOptJSONArray2 != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                    A03(arrayList, arrayList2, jSONArrayOptJSONArray2.optJSONObject(i11), sf, z11);
                }
            } else {
                A03(arrayList, arrayList2, jSONObject, sf, z11);
            }
        } catch (JSONException unused) {
            c2285bg.A04(AbstractC2000Sv.A15, A01(0, 43, 35));
        }
        return new C2307c2(jSONObject, strA0S, arrayList, arrayList2, arrayList3, z12);
    }

    public static String A01(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-87, -42, -42, -45, -42, -124, -40, -42, -59, -46, -41, -54, -45, -42, -47, -51, -46, -53, -124, -82, -73, -77, -78, -124, -51, -46, -124, -39, -44, -56, -59, -40, -55, -89, -59, -57, -52, -55, -56, -71, -42, -48, -41, -55, -57, -40, -43, -37, -39, -53, -46, 13, 34, 23, 10, 22, 18, 12, 8, 28, 13, 20, 8, 21, 10, 34, 14, 27, 8, 17, 29, 22, 21, 8, 30, 27, 21, 23, 32, 22, 17, 21, 19, 36, 22, 17, 27, 31, 19, 25, 23, 37, -37, -43, -31, -32, -35, -31, -43, -37, -39, -33, -36, -42, -32, -45, -50, -49, -39, -55, -33, -36, -42};
    }

    public static void A03(ArrayList<String> imageUrls, ArrayList<String> videoUrls, JSONObject jSONObject, SF sf, boolean z10) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(96, 5, 51));
        if (jSONObjectOptJSONObject != null) {
            String strA01 = A01(101, 3, 41);
            if (jSONObjectOptJSONObject.optString(strA01) != null) {
                String strOptString = jSONObjectOptJSONObject.optString(strA01);
                imageUrls.add(strOptString);
                if (z10) {
                    jSONObjectOptJSONObject.put(strA01, sf.A0R(strOptString));
                }
            }
        }
        String strA012 = A01(104, 9, 41);
        if (!TextUtils.isEmpty(jSONObject.optString(strA012))) {
            String strOptString2 = jSONObject.optString(strA012);
            videoUrls.add(strOptString2);
            if (z10) {
                jSONObject.put(strA012, sf.A0S(strOptString2));
            }
        }
    }
}
