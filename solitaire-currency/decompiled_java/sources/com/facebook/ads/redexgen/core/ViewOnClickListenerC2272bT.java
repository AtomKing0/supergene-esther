package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2272bT implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1741Is A00;

    static {
        A01();
    }

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{62, 37, 37, 38, 40, 43, 56};
    }

    public ViewOnClickListenerC2272bT(C1741Is c1741Is) {
        this.A00 = c1741Is;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0m(A00(0, 7, 120));
            if (this.A00.A0c.A0E() != null) {
                this.A00.A0c.A0E().ABr();
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
