package com.google.android.datatransport.cct;

/* JADX INFO: compiled from: StringMerger.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    static String a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb.append(str2.charAt(i10));
            }
        }
        return sb.toString();
    }
}
