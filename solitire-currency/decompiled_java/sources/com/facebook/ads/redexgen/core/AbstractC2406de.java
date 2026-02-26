package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.de, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2406de {
    public static byte[] A00;
    public static String[] A01 = {"m5Jty9nXe8L2gKLWEWc3vH5rHCR7lq15", "nXqLn2RrfIlx0c2v1RTl0CneHVNjUcek", "yIjJHM1120PmYi1BMLCe9caFimcQ2nFl", "mlpcJRY57Lt3u3e0DOF4Ze17XEKszIMh", "yNEzWcoMu1kvA6ly91E0yJELmkdnUTW9", "LQJ0sSZIBnjE3wRe9pGlPD4TX9Tbmis1", "3e9PCxJTK3pug342JyVCHaGplQMI3S8I", "kyVsWmEjdCkwx1v5lgIpAQohzDFxobhM"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static WebResourceResponse A00(C2387dL c2387dL, WebResourceRequest webResourceRequest, Uri uri, String str, HashMap<String, String> map) throws IOException {
        String strA02 = A02(85, 5, 1);
        InterfaceC13984w interfaceC13984wA0H = C2446eJ.A06(c2387dL.A02()).A0H(c2387dL);
        SF.A0H(c2387dL, uri.toString());
        try {
            C2407df c2407df = new C2407df(c2387dL.A02(), uri, interfaceC13984wA0H);
            int iAvailable = c2407df.available();
            if (iAvailable <= 0) {
                A05(c2387dL, 1, new Pair[]{new Pair(A02(61, 9, 46), String.valueOf(iAvailable))});
                return null;
            }
            String strA03 = A03(webResourceRequest.getRequestHeaders());
            if (strA03 == null) {
                c2387dL.A0F().A65();
                A06(map, iAvailable);
                return new WebResourceResponse(str, null, 200, A02(44, 2, 122), map, c2407df);
            }
            try {
                C2405dd c2405ddA01 = A01(strA03);
                if (!c2405ddA01.A03) {
                    A05(c2387dL, 0, new Pair[]{new Pair(A02(94, 5, 77), c2405ddA01.A02 != null ? c2405ddA01.A02 : A02(90, 4, 30))});
                    return null;
                }
                int i10 = c2405ddA01.A01;
                int i11 = c2405ddA01.A00 == -1 ? iAvailable - 1 : c2405ddA01.A00;
                A06(map, iAvailable);
                map.put(A02(31, 13, 93), A02(75, 6, 3) + i10 + A02(1, 1, 92) + i11 + A02(2, 1, 88) + iAvailable);
                c2387dL.A0F().A65();
                return new WebResourceResponse(str, null, 206, A02(46, 15, 10), map, c2407df);
            } catch (NumberFormatException e10) {
                A05(c2387dL, 3, new Pair[]{new Pair(strA02, e10.toString())});
                return null;
            }
        } catch (IOException e11) {
            A05(c2387dL, 2, new Pair[]{new Pair(strA02, e11.toString())});
            return null;
        }
    }

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-114, -93, -95, 100, -104, -70, -70, -68, -57, -53, -124, -87, -72, -59, -66, -68, -54, -70, -26, -27, -21, -36, -27, -21, -92, -61, -36, -27, -34, -21, -33, -70, -26, -27, -21, -36, -27, -21, -92, -55, -40, -27, -34, -36, -29, -33, 116, -123, -106, -104, -115, -123, -112, 68, 103, -109, -110, -104, -119, -110, -104, -87, -66, -87, -79, -76, -87, -86, -76, -83, -127, -104, -109, -124, -110, 127, -106, -111, -126, -112, 61, -74, -62, -73, -72, -128, -115, -115, -118, -115, -90, -83, -92, -92, -39, -56, -43, -50, -52};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A05(C2387dL c2387dL, int i10, Pair<String, String>[] pairArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(81, 4, 57), i10);
            for (Pair<String, String> pair : pairArr) {
                jSONObject.put((String) pair.first, pair.second);
            }
        } catch (JSONException unused) {
        }
        c2387dL.A0F().A64(jSONObject.toString());
    }

    static {
        A04();
    }

    public static C2405dd A01(String str) {
        if (str == null) {
            C2405dd parseResult = new C2405dd();
            parseResult.A03 = false;
            parseResult.A02 = null;
            return parseResult;
        }
        String[] strArr = A01;
        if (strArr[0].charAt(24) != strArr[1].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[3] = "Dtu90aCnfjxtl3iZcl85ZURNtT9G66qF";
        strArr2[6] = "JBE4H6DVGxkCv3KpLfIzSFjkaXJMKyPO";
        String[] strArrSplit = str.split(A02(3, 1, 13));
        if (strArrSplit.length >= 2) {
            if (A02(70, 5, 5).equals(strArrSplit[0].toLowerCase(Locale.US).trim())) {
                if (strArrSplit[1].trim().split(A02(0, 1, 72)).length != 1) {
                    C2405dd c2405dd = new C2405dd();
                    c2405dd.A03 = false;
                    c2405dd.A02 = str;
                    return c2405dd;
                }
                String[] ranges = strArrSplit[1].trim().split(A02(1, 1, 92));
                C2405dd c2405dd2 = new C2405dd();
                c2405dd2.A03 = true;
                c2405dd2.A02 = str;
                c2405dd2.A01 = TextUtils.isEmpty(ranges[0]) ? 0 : Integer.parseInt(ranges[0]);
                if (ranges.length > 1) {
                    c2405dd2.A00 = TextUtils.isEmpty(ranges[1]) ? -1 : Integer.parseInt(ranges[1]);
                } else {
                    c2405dd2.A00 = -1;
                }
                return c2405dd2;
            }
        }
        C2405dd c2405dd3 = new C2405dd();
        c2405dd3.A03 = false;
        c2405dd3.A02 = str;
        return c2405dd3;
    }

    public static String A03(Map<String, String> map) {
        for (String str : map.keySet()) {
            Locale locale = Locale.US;
            String[] strArr = A01;
            String header = strArr[0];
            if (header.charAt(24) != strArr[1].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "WwPgvkKaNJbx73tjItPTyID0XOg3nGIt";
            strArr2[6] = "4YitGEy8BigPs3HGnT2LP2sfmluRsQ6B";
            if (A02(94, 5, 77).equals(str.toLowerCase(locale))) {
                return map.get(str);
            }
        }
        return null;
    }

    public static void A06(HashMap<String, String> map, int i10) {
        map.put(A02(4, 13, 61), A02(70, 5, 5));
        map.put(A02(17, 14, 93), String.valueOf(i10));
    }
}
