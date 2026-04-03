package com.ironsource.sdk.controller;

import com.ironsource.bl;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15126b = "MD5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15127a;

    s(String str) {
        this.f15127a = str;
    }

    static String a() {
        return UUID.randomUUID().toString();
    }

    String b() {
        return this.f15127a;
    }

    private String a(String str) {
        try {
            return bl.a(str);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return b(str);
        }
    }

    private String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(f15126b);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return "";
        }
    }

    private String a(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    boolean a(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(a(str + str2 + this.f15127a));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }
}
