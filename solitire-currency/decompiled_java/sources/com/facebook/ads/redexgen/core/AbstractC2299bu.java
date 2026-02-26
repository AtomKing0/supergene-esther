package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2299bu {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C2298bt>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C2298bt>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C2298bt A01(C2387dL c2387dL, AbstractC2662hy abstractC2662hy, int i10, InterfaceC2296br interfaceC2296br) {
        C2298bt c2298bt = new C2298bt(c2387dL, abstractC2662hy, c2387dL.A02().A0A(), i10);
        c2298bt.A0b(interfaceC2296br);
        c2298bt.A0X();
        A01.put(abstractC2662hy.A17(), new WeakReference<>(c2298bt));
        return c2298bt;
    }

    public static C2298bt A02(String str) {
        WeakReference<C2298bt> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC2662hy abstractC2662hy, C2298bt c2298bt) {
        A01.put(abstractC2662hy.A17(), new WeakReference<>(c2298bt));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}
