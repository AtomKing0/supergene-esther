package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1603Dj extends AbstractC2010Tf<C3Q> {
    public static String[] A01 = {"Etf6rxr38TN0vQCp7eNtUvsDOmNclbJq", "tsAjjvZCMDWdS", "8hGTWRVePtIxVw2NOXuq9knVHvw3DPvW", "EWxkCjZIostDvyF", "5rZAWcCWfjjM2", "LrhlSMt3F2A2PPkpDiBfjHpLA", "jQk7ZNmPb7V9ueUuvUfiKmSE", "mvg7pIDRu6IgLugvRarlC3XDTGoYv5EO"};
    public final /* synthetic */ C13583i A00;

    public C1603Dj(C13583i c13583i) {
        this.A00 = c13583i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Tf
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C3Q c3q) {
        int iA00 = c3q.A00();
        int currentPositionMS = this.A00.A00;
        if (currentPositionMS > 0) {
            int currentPositionMS2 = this.A00.A0C.getDuration();
            if (iA00 == currentPositionMS2) {
                int duration = this.A00.A0C.getDuration();
                int currentPositionMS3 = this.A00.A00;
                if (duration > currentPositionMS3) {
                    return;
                }
            }
        }
        C13583i c13583i = this.A00;
        if (A01[5].length() == 7) {
            throw new RuntimeException();
        }
        A01[5] = "7AA42mFgyTVlZSuOszNfTs49";
        c13583i.A0k(iA00);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2010Tf
    public final Class<C3Q> A01() {
        return C3Q.class;
    }
}
