package com.unity3d.services.ads.gmascar.managers;

/* JADX INFO: loaded from: classes4.dex */
public enum ScarBiddingManagerType {
    DISABLED("dis"),
    EAGER("eag");

    private final String name;

    private static class Constants {
        private static final String DIS = "dis";
        private static final String EAG = "eag";

        private Constants() {
        }
    }

    ScarBiddingManagerType(String str) {
        this.name = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType fromName(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = 99470(0x1848e, float:1.39387E-40)
            if (r0 == r1) goto L19
            r1 = 100171(0x1874b, float:1.4037E-40)
            if (r0 == r1) goto Lf
            goto L23
        Lf:
            java.lang.String r0 = "eag"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L23
            r2 = 0
            goto L24
        L19:
            java.lang.String r0 = "dis"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L23
            r2 = 1
            goto L24
        L23:
            r2 = -1
        L24:
            if (r2 == 0) goto L29
            com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType r2 = com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType.DISABLED
            return r2
        L29:
            com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType r2 = com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType.EAGER
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType.fromName(java.lang.String):com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType");
    }

    public String getName() {
        return this.name;
    }
}
