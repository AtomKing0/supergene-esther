package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14014z extends IOException {
    public static String[] A01 = {"2Muqh70O6MOkp58pfFL5fqQgJ22LbaOG", "jD6cmMLG7Gavhvnx7CsfZCp0TtnTBkr3", "DkdpbG", "GPGghQKRhEx8Hs8G8MSTaC4gxGmWiueB", "QluhzvyI33CjLqJI0scNHkzBaYypVFTM", "0eVVwOHP6sRTPOkeFOg2FrcrRKf9zLzm", "eMagzz7TAm5jMGA4xfPZ9Gt9YCxRiChS", "Ni0AzA"};
    public final int A00;

    public C14014z(int i10) {
        this.A00 = i10;
    }

    public C14014z(String str, int i10) {
        super(str);
        this.A00 = i10;
    }

    public C14014z(String str, Throwable th, int i10) {
        super(str, th);
        this.A00 = i10;
    }

    public C14014z(Throwable th, int i10) {
        super(th);
        this.A00 = i10;
    }

    public static boolean A00(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            boolean z10 = cause instanceof C14014z;
            String[] strArr = A01;
            if (strArr[7].length() == strArr[2].length()) {
                String[] strArr2 = A01;
                strArr2[1] = "gKwk6czfyck41TVkhXYTi4dwxHvcIOpw";
                strArr2[0] = "KQxTdd6uLlHWGTHHNKbBjwUH99zdNbRE";
                if (z10 && ((C14014z) cause).A00 == 2008) {
                    String[] strArr3 = A01;
                    if (strArr3[1].charAt(5) != strArr3[0].charAt(5)) {
                        String[] strArr4 = A01;
                        strArr4[1] = "s9AyCo5pkNnOJPMRH26C6HS8hSDLq3Tq";
                        strArr4[0] = "XtuWgVHjqru9RvBQwhBnbYNcJk0iYMoO";
                        return true;
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }
}
