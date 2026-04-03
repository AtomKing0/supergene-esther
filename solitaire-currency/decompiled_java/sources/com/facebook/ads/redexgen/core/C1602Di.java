package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Di, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1602Di extends AbstractC2010Tf<C13533d> {
    public static String[] A01 = {"Xm4oO1fgaoMOjj45N8r00LATVp4gHrYG", "MO5WiyOQHdAIBAUWSCIdsXDipyRYP8jB", "8ZD7midsUGLLHTawsvmUwyHXKE63ocNK", "eXsxAyUW", "", "KTVY2IhXiCn688zdyYvQYy9fTV", "AuZpLEz4ubgydEKdqdaVeIvdhtRZUWrW", "O3ESmZOEeO27LGblO6LyKeoijHa02l1o"};
    public final /* synthetic */ C13583i A00;

    public C1602Di(C13583i c13583i) {
        this.A00 = c13583i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Tf
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C13533d c13533d) {
        int iA00 = c13533d.A00();
        int duration = c13533d.A01();
        int currentPosition = this.A00.A00;
        if (currentPosition > 0 && iA00 == duration) {
            int currentPosition2 = this.A00.A00;
            if (duration > currentPosition2) {
                return;
            }
        }
        int currentPosition3 = iA00 + 500;
        if (duration < currentPosition3) {
            if (duration == 0) {
                C13583i c13583i = this.A00;
                int currentPosition4 = this.A00.A00;
                c13583i.A0j(currentPosition4);
                return;
            }
            this.A00.A0j(duration);
            return;
        }
        C13583i c13583i2 = this.A00;
        String[] strArr = A01;
        String str = strArr[7];
        String str2 = strArr[0];
        int duration2 = str.charAt(6);
        int currentPosition5 = str2.charAt(6);
        if (duration2 == currentPosition5) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "eYEuq0G9XeIp1YNIhTPdTiyuyz";
        strArr2[3] = "ZD2QUH1g";
        c13583i2.A0j(iA00);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2010Tf
    public final Class<C13533d> A01() {
        return C13533d.class;
    }
}
