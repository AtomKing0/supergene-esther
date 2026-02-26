package com.king.amp.sa;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: NetworkType.java */
/* JADX INFO: loaded from: classes4.dex */
public class p1 {
    @NonNull
    public static String a(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "UNKNOWN" : "OTHER" : "ETHERNET" : "WIFI" : "CELLULAR" : "NONE";
    }
}
