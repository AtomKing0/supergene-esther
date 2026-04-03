package com.onetrust.otpublishers.headless.gpp;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f23801a = Pattern.compile("^[0-1]*$", 2);

    public static String a(int i10, int i11) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = "0";
            if (i10 <= 0) {
                break;
            }
            if ((i10 & 1) == 1) {
                str = "1";
            }
            sb.insert(0, str);
            i10 >>= 1;
        }
        while (sb.length() < i11) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
