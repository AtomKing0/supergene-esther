package com.facebook.ads.redexgen.core;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2284bf {
    public static C5Q A00(final C2225ai c2225ai, int i10, final String str, final FH fh) {
        if (i10 == 1) {
            return new C5Q(c2225ai, str, fh) { // from class: com.facebook.ads.redexgen.X.0e
                public static final int A00 = (int) (AbstractC2090Wl.A02 * 20.0f);
                public static final int A01 = (int) (AbstractC2090Wl.A02 * 16.0f);

                @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
                public final boolean A02() {
                    return false;
                }

                @Override // com.facebook.ads.redexgen.core.C5Q
                public final void A1V(C2387dL c2387dL) {
                    C2207aQ titleDescContainer = getTitleDescContainer();
                    titleDescContainer.setAlignment(3);
                    titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    titleDescContainer.setPadding(0, 0, 0, A00);
                    getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayout = new LinearLayout(c2387dL);
                    XP.A0Q(linearLayout, new ColorDrawable(-1));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(3, getMediaContainer().getId());
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(1);
                    linearLayout.setPadding(A01, A01, A01, A01);
                    linearLayout.addView(titleDescContainer);
                    linearLayout.addView(getCtaButton());
                    addView(getMediaContainer());
                    addView(linearLayout);
                }
            };
        }
        return new C5Q(c2225ai, str, fh) { // from class: com.facebook.ads.redexgen.X.0f
            public static final int A00 = (int) (AbstractC2090Wl.A02 * 12.0f);

            @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
            public final boolean A01() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.core.C5Q, com.facebook.ads.redexgen.core.AbstractC2221ae
            public final boolean A0C() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.core.C5Q
            public final void A1V(C2387dL c2387dL) {
                C2207aQ titleDescContainer = getTitleDescContainer();
                titleDescContainer.setAlignment(3);
                RelativeLayout.LayoutParams adTitleAndDescriptionLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
                adTitleAndDescriptionLayoutParams.addRule(8, getMediaContainer().getId());
                titleDescContainer.setLayoutParams(adTitleAndDescriptionLayoutParams);
                titleDescContainer.setPadding(A00, A00, A00, A00);
                XP.A0P(titleDescContainer, getAdContextWrapper());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, getMediaContainer().getId());
                getCtaButton().setLayoutParams(layoutParams);
                addView(getMediaContainer());
                addView(titleDescContainer);
                addView(getCtaButton());
            }
        };
    }
}
