package com.onetrust.otpublishers.headless.gpp;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f23787a = Pattern.compile("^[0-1]*$", 2);

    public static String a(String str) {
        if (!f23787a.matcher(str).matches()) {
            OTLogger.a("GPPBase64UrlEncoder", 6, "Base64Url encoding failed");
        }
        while (str.length() % 6 > 0) {
            str = str.concat("0");
        }
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (i10 <= str.length() - 6) {
            int i11 = i10 + 6;
            String strSubstring = str.substring(i10, i11);
            try {
                if (!g.f23801a.matcher(strSubstring).matches()) {
                    OTLogger.a("GPPIntegerEncoder", 6, "Integer decode failed");
                }
                int i12 = 0;
                int i13 = 0;
                while (i12 < strSubstring.length()) {
                    int i14 = i12 + 1;
                    if (strSubstring.charAt(strSubstring.length() - i14) == '1') {
                        i13 += 1 << i12;
                    }
                    i12 = i14;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i13));
                i10 = i11;
            } catch (Exception unused) {
                OTLogger.a("GPPBase64UrlEncoder", 6, "Base64Url encoding failed");
            }
        }
        return sb.toString();
    }
}
