package com.facebook.ads.redexgen.core;

import java.util.Random;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14476t {
    public static String[] A04 = {"IlrXm3tezuWbVMaXPLi828ioISQJgCfS", "NAwIzBHR00ZPv9WHAooSWGmMQnQsAYk8", "eu5lMmt7ol9PqHL84pZymZquGRu6o", "m2SAqTjU3gSqVMchVgPXeZMw5JHzzeRQ", "AbCmeSj5KlQ54JssPMwwYJBwucQ6C", "RqAiTasO9D9HsUdBZKTQCzdghtQ9E0yV", "WIBemWRSgRuyaEIJ1sL2dCgMu2IibJ9f", "z026p7uIfXqhY1JlsQjMBKUP7isQ63Up"};
    public int A00;
    public int A01;
    public int A02;
    public final /* synthetic */ C14486u A03;

    public C14476t(C14486u c14486u, int i10, int i11, int i12) {
        this.A03 = c14486u;
        this.A00 = i10;
        this.A01 = i11;
        this.A02 = i12;
    }

    public final int A00() {
        Random random = new Random();
        if (random.nextInt(this.A02) == 0) {
            if (this.A01 <= 0) {
                return this.A00;
            }
            int iNextInt = random.nextInt() % this.A01;
            int i10 = this.A00;
            String[] strArr = A04;
            String str = strArr[4];
            String str2 = strArr[2];
            int variation = str.length();
            if (variation != str2.length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "t99WXaELTOA6CPYhlrJz9JZjCbRHN";
            strArr2[2] = "SwFbG7SpSQOHKIZQBIcFbwrWU2Enz";
            return i10 + iNextInt;
        }
        return 0;
    }
}
