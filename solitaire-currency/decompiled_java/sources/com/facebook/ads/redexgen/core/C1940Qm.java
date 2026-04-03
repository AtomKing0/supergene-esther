package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1940Qm {
    public int A00;
    public QJ A01;
    public QJ A02;
    public static String[] A04 = {"3L5xTrYaZHGbjsCndSxeOQfzJoqaksAO", "yNuit7zcaXLgcR4Esus3jmJQTJqqE", "DjfkS9z5OPUyV9QdiCBZ1KUSwMFmGRPN", "lc54RdKLiwdhlc59ssIRjbGGERTX6o9W", "6o2d", "DSh0O66K0UoAsbtG5khJTMnGYv0IzoNn", "Wt9X6yajIBXU34hiGluB33HbNXSszdRF", "6wPar1yvZmOBSMEilq5oC74eJWuAafP4"};
    public static OZ<C1940Qm> A03 = new C2583ga(20);

    public static C1940Qm A00() {
        C1940Qm c1940QmA33 = A03.A33();
        if (A04[5].charAt(2) == 'q') {
            throw new RuntimeException();
        }
        A04[5] = "RnCaU2E938mENSzRzPrAuXo67ZnkzA8g";
        C1940Qm record = c1940QmA33;
        return record == null ? new C1940Qm() : record;
    }

    public static void A01() {
        while (A03.A33() != null) {
        }
    }

    public static void A02(C1940Qm c1940Qm) {
        c1940Qm.A00 = 0;
        c1940Qm.A02 = null;
        c1940Qm.A01 = null;
        A03.AGv(c1940Qm);
    }
}
