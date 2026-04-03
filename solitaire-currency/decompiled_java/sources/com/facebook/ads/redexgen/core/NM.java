package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NM implements InterfaceC2116Xl {
    public static String[] A02 = {"YUGwJzzikBNzfLIllCMdkir2Jyj8DuFq", "ntVfVONdyCctXWp", "AonpNDk7AlTTh7WnvPqW51ITIbVwFUJp", "NJZ9S98WzFijxyBcJxql7T6JOIFmEfw7", "8QFO", "nOxceDp", "zcnAPzBVA2CXXQsDQKs94da1Vf1b77Qu", "s6TvhQwfXdUE9Ss2QaqLkXkKVbAwWXrL"};
    public final /* synthetic */ R0 A00;
    public final /* synthetic */ NI A01;

    public NM(NI ni, R0 r02) {
        this.A01 = ni;
        this.A00 = r02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2116Xl
    public final void ACC(AbstractC2117Xm abstractC2117Xm) {
        if (abstractC2117Xm.getToolbarActionMode() == 8) {
            this.A01.A0W();
            return;
        }
        this.A01.A0D.A04(UZ.A07, null);
        if (this.A01.A0e()) {
            return;
        }
        NI ni = this.A01;
        if (A02[3].charAt(29) != 'f') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "pLKL5MIsKfCUMWoMxvxDNCAoAO8BGlnS";
        strArr[7] = "7PsgTAKpTeXTqL7VuWAjeXRdKL6HZN4L";
        if (ni.A0b()) {
            this.A01.A0a(this.A00);
        } else {
            this.A00.finish(1);
        }
    }
}
