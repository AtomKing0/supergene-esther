package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Z9 {
    public static ImageView A00(final C2387dL c2387dL, final C2030Ua c2030Ua, final AbstractC2662hy abstractC2662hy, final InterfaceC2118Xn interfaceC2118Xn, final Z5 z52, Handler handler, Z6 z62) {
        c2387dL.A0F().AAv(z52.name().toLowerCase(Locale.US));
        return abstractC2662hy.A2F() ? new Z4(c2387dL, handler, z62, abstractC2662hy.A1y(), new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2387dL c2387dL2 = c2387dL;
                C2030Ua c2030Ua2 = c2030Ua;
                InterfaceC2118Xn interfaceC2118Xn2 = interfaceC2118Xn;
                Z5 z53 = z52;
                AbstractC2662hy abstractC2662hy2 = abstractC2662hy;
                Z9.A04(c2387dL2, c2030Ua2, interfaceC2118Xn2, z53, abstractC2662hy2.A25(), abstractC2662hy2.A23());
            }
        }) : new ZA(c2387dL, new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Z8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2387dL c2387dL2 = c2387dL;
                C2030Ua c2030Ua2 = c2030Ua;
                InterfaceC2118Xn interfaceC2118Xn2 = interfaceC2118Xn;
                Z5 z53 = z52;
                AbstractC2662hy abstractC2662hy2 = abstractC2662hy;
                Z9.A04(c2387dL2, c2030Ua2, interfaceC2118Xn2, z53, abstractC2662hy2.A25(), abstractC2662hy2.A23());
            }
        });
    }

    public static ImageView A01(C2387dL c2387dL, C2030Ua c2030Ua, AbstractC2662hy abstractC2662hy, Z5 z52, InterfaceC2118Xn interfaceC2118Xn, Handler handler) {
        return A00(c2387dL, c2030Ua, abstractC2662hy, interfaceC2118Xn, z52, handler, Z6.A03);
    }

    public static void A04(C2387dL c2387dL, C2030Ua c2030Ua, InterfaceC2118Xn interfaceC2118Xn, Z5 z52, String str, N9 n92) {
        if (c2030Ua != null) {
            c2030Ua.A04(UZ.A0A, null);
        }
        c2387dL.A0F().AAu(z52.name().toLowerCase(Locale.US));
        if (O3.A00(c2387dL.A02()).A0O(c2387dL.A02(), true)) {
            interfaceC2118Xn.AAf(str, n92);
        } else {
            if (TextUtils.isEmpty(n92.A00())) {
                return;
            }
            WN.A0O(new WN(), c2387dL, WQ.A00(n92.A00()), str);
        }
    }
}
