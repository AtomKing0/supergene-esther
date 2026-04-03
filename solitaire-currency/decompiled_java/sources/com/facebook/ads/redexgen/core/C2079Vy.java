package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2079Vy {
    public static String[] A01 = {"0TBfSTrFZZIPTbjcv3YvZ5KQe5wh6M4Z", "Y", "skEIHJjGP8F0E9LHs3c03M6jOmkdnZrb", "lNiM6G1VkMzjPhI0VWbHd", "xoZoqEy9j11lJxTnOEXOmkmQN9dBXrj3", "0lNV7cA9G3CxYQK", "ZSiJ5Be21P36sCEypxWEkyax05PjjigP", "3dFveWP5h629GmfNhsyVO5v38YfKmNKK"};
    public static final ThreadLocal<C2079Vy> A02 = new ThreadLocal<>();
    public final C2062Vh A00 = new C2062Vh();

    public static C2062Vh A00() {
        return A02().A00;
    }

    public static C2062Vh A01(C2078Vx c2078Vx) {
        C2062Vh currentStackTraces = new C2062Vh(A00());
        currentStackTraces.add(c2078Vx);
        return currentStackTraces;
    }

    public static C2079Vy A02() {
        C2079Vy c2079Vy = A02.get();
        if (c2079Vy == null) {
            C2079Vy c2079Vy2 = new C2079Vy();
            A02.set(c2079Vy2);
            return c2079Vy2;
        }
        return c2079Vy;
    }

    public static void A03(AbstractRunnableC2074Vt abstractRunnableC2074Vt) {
        C2062Vh c2062VhA06 = abstractRunnableC2074Vt.A06();
        if (c2062VhA06 != null) {
            C2062Vh createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.addAll(c2062VhA06);
        }
    }

    public static void A04(AbstractRunnableC2074Vt abstractRunnableC2074Vt) {
        C2062Vh c2062VhA06 = abstractRunnableC2074Vt.A06();
        if (c2062VhA06 != null) {
            C2062Vh c2062Vh = A02().A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[0] = "6tfOksRsBjIBNQljvPHCCYkD1Hr87lb7";
            c2062Vh.removeAll(c2062VhA06);
        }
    }
}
