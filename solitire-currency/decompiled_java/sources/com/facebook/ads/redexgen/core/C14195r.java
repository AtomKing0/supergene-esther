package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.ads.RequestConfiguration;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14195r extends KL {
    public static String[] A00 = {RequestConfiguration.MAX_AD_CONTENT_RATING_G, "KzTy2hy9hhtw1RMGA4AWQtLCSBRvIgNx", "TFXx3faCMHKsw8ZQwSQJp4p3qrvSFGQZ", "FDPqMwfpfrBnIs9VqOwKhGqv0efVrSDC", "w99CmZO3gVFe1JaqJ0AV2MifxVBEUT0K", "IReileYPgfNfW", "Qab6Yr7DAj1gKX83C9lxa", "vvhOodmvLfB1cs4WARwmrAXLlmUlw4y7"};
    public static final int A01 = (int) (AbstractC2090Wl.A02 * 152.0f);

    public C14195r(C2387dL c2387dL, KE ke, int i10, boolean z10, C1850My c1850My, String str, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, AbstractC2662hy abstractC2662hy, C1590Cw c1590Cw, C2030Ua c2030Ua, boolean z11) {
        super(c2387dL, ke, i10, z10, c1850My, false, str, us, interfaceC2118Xn, c2460eX, xh, abstractC2662hy, c1590Cw, c2030Ua, z11);
        int i11 = getResources().getConfiguration().orientation;
        A00();
        A07(i11);
        A09(i11);
        XP.A0I(this.A0P);
        A06(i11);
        A02(i11);
        A05(i11);
        A04(i11);
        A03(i11);
        A08(i11);
        A0A(((KL) this).A04, i11);
        addView(this.A0O);
    }

    private void A00() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        int i10 = (int) (getResources().getDisplayMetrics().widthPixels * 0.1f);
        layoutParams.setMargins(i10, 0, i10, 0);
        this.A0N.setLayoutParams(layoutParams);
    }

    private void A01(int i10) {
        if (((AbstractC2178Zv) this).A08.getParent() != null) {
            KE ke = ((AbstractC2178Zv) this).A08;
            if (A00[6].length() != 21) {
                throw new RuntimeException();
            }
            A00[6] = "77Sm8WMgdJozvQKOpKshJ";
            XP.A0H(ke);
        }
        if (i10 == 1) {
            A0v(this.A0O);
            this.A0O.addView(this.A0I);
            this.A0O.addView(this.A0U);
            this.A0O.addView(((AbstractC2178Zv) this).A08);
            this.A0O.addView(this.A0K);
            this.A0O.addView(this.A0J);
        } else {
            this.A0N.addView(((AbstractC2178Zv) this).A09);
            this.A0N.addView(this.A0Q);
            this.A0N.addView(this.A0P);
            this.A0N.addView(((AbstractC2178Zv) this).A08);
            this.A0N.addView(this.A0U);
            A0v(this.A0N);
            this.A0N.addView(this.A0I);
            this.A0O.addView(this.A0J);
            this.A0O.addView(this.A0N);
            this.A0O.addView(this.A0K);
        }
        if (this.A0Y) {
            A0o();
        }
    }

    private void A02(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0K.getLayoutParams();
        layoutParams.setMargins(0, 0, KL.A0r, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.A0K.setLayoutParams(layoutParams);
        this.A0K.setPadding(KL.A0u, KL.A0u, 0, 0);
    }

    private void A03(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, KL.A0b);
        if (i10 == 1) {
            layoutParams.setMargins(KL.A0r, 0, KL.A0r, KL.A0l);
            layoutParams.addRule(2, this.A0U.getId());
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.addRule(3, this.A0I.getId());
        }
        layoutParams.addRule(14);
        ((AbstractC2178Zv) this).A08.setLayoutParams(layoutParams);
        A0l();
    }

    private void A04(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0I.getLayoutParams();
        if (i10 == 1) {
            layoutParams.removeRule(3);
            KE ke = ((AbstractC2178Zv) this).A08;
            if (A00[0].length() != 1) {
                throw new RuntimeException();
            }
            A00[0] = CmcdData.Factory.STREAM_TYPE_LIVE;
            layoutParams.addRule(2, ke.getId());
        } else {
            layoutParams.removeRule(2);
            layoutParams.setMargins(0, 0, 0, KL.A0u);
            layoutParams.addRule(3, this.A0P.getId());
        }
        this.A0I.setLayoutParams(layoutParams);
    }

    private void A05(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i10 == 1) {
            layoutParams.removeRule(11);
            layoutParams.addRule(7, ((AbstractC2178Zv) this).A08.getId());
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.removeRule(7);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, KL.A0l, 0);
        }
        layoutParams.addRule(12);
        this.A0J.setPadding(0, 0, 0, KL.A0l);
        this.A0J.setLayoutParams(layoutParams);
    }

    private void A06(int i10) {
        int i11;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0P.getLayoutParams();
        if (i10 == 1) {
            i11 = KL.A0t;
            this.A0P.setMaxLines(4);
        } else {
            i11 = KL.A0u;
            this.A0P.setMaxLines(2);
        }
        int horizontalMargin = KL.A0u;
        layoutParams.setMargins(i11, horizontalMargin, i11, KL.A0l);
        layoutParams.addRule(14);
        int horizontalMargin2 = this.A0Q.getId();
        layoutParams.addRule(3, horizontalMargin2);
        layoutParams.addRule(14);
        this.A0P.setTypeface(Typeface.DEFAULT);
        this.A0P.setTextSize(18.0f);
        this.A0P.setLayoutParams(layoutParams);
    }

    private void A07(int i10) {
        int topMargin;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2178Zv) this).A09.getLayoutParams();
        if (i10 == 1) {
            layoutParams.width = A01;
            layoutParams.height = A01;
            layoutParams.setMargins(0, (-A01) / 4, 0, 0);
            topMargin = 30;
        } else {
            layoutParams.removeRule(3);
            layoutParams.removeRule(14);
            int i11 = KL.A0h;
            if (A00[0].length() != 1) {
                throw new RuntimeException();
            }
            A00[1] = "bedGjlLGZ2badAr5t95UZlauyGcNPG4D";
            layoutParams.width = i11;
            layoutParams.height = KL.A0h;
            layoutParams.setMargins(0, KL.A0l, 0, 0);
            topMargin = 15;
        }
        if (!this.A0X) {
            ((AbstractC2178Zv) this).A09.setRadius(topMargin);
        }
        layoutParams.addRule(14);
        ((AbstractC2178Zv) this).A09.setLayoutParams(layoutParams);
    }

    private void A08(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0U.getLayoutParams();
        if (i10 == 1) {
            layoutParams.removeRule(3);
            if (this.A0J.getVisibility() == 0) {
                layoutParams.addRule(2, this.A0J.getId());
            } else {
                layoutParams.addRule(2, this.A0K.getId());
            }
            layoutParams.setMargins(KL.A0r, 0, KL.A0r, KL.A0p);
        } else {
            layoutParams.removeRule(2);
            layoutParams.addRule(3, ((AbstractC2178Zv) this).A08.getId());
            layoutParams.setMargins(0, KL.A0l, 0, 0);
        }
        this.A0U.setLayoutParams(layoutParams);
    }

    private void A09(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0Q.getLayoutParams();
        this.A0Q.setTypeface(Typeface.DEFAULT_BOLD);
        this.A0Q.setTextSize(30.0f);
        int i11 = 0;
        if (i10 == 1) {
            i11 = KL.A0r;
        }
        int horizontalMargin = KL.A0l;
        layoutParams.setMargins(i11, horizontalMargin, i11, 0);
        layoutParams.addRule(14);
        int horizontalMargin2 = ((AbstractC2178Zv) this).A09.getId();
        layoutParams.addRule(3, horizontalMargin2);
        this.A0Q.setLayoutParams(layoutParams);
        this.A0P.setMaxLines(2);
    }

    private void A0A(TextView textView, int i10) {
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        if (A00[5].length() == 30) {
            throw new RuntimeException();
        }
        A00[2] = "MzAm3HoD6orDxlJQlGTEx6IPe7UcdOUI";
        if (i10 == 1) {
            layoutParams.removeRule(3);
            if (this.A0J.getVisibility() == 0) {
                layoutParams.addRule(2, this.A0J.getId());
            } else {
                layoutParams.addRule(2, this.A0K.getId());
            }
            layoutParams.addRule(5, this.A0U.getId());
        } else {
            layoutParams.removeRule(2);
            if (A00[6].length() != 21) {
                A00[6] = "7zj9JJJnjsPUDa1S35qln";
                layoutParams.removeRule(5);
                layoutParams.addRule(3, this.A0U.getId());
            } else {
                A00[6] = "ItVyc3UmcGyu1CZchDJaM";
                layoutParams.removeRule(5);
                layoutParams.addRule(3, this.A0U.getId());
            }
        }
        layoutParams.setMargins(0, KL.A0u, 0, 0);
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.KL, com.facebook.ads.redexgen.core.AbstractC2178Zv
    public final void A0i(int i10) {
        super.A0i(i10);
        XP.A0Z(this.A0N, ((AbstractC2178Zv) this).A09, this.A0Q, this.A0U, ((KL) this).A04, this.A0P, this.A0K, this.A0J, this.A0I);
        A00();
        A07(i10);
        A0A(((KL) this).A04, i10);
        A08(i10);
        A04(i10);
        A03(i10);
        A09(i10);
        A06(i10);
        A02(i10);
        A05(i10);
    }

    @Override // com.facebook.ads.redexgen.core.KL
    public final void A0r(int i10) {
    }

    @Override // com.facebook.ads.redexgen.core.KL
    public final void A0t(ViewGroup viewGroup, RelativeLayout relativeLayout, int i10) {
        if (i10 == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2178Zv) this).A09.getLayoutParams();
            layoutParams.addRule(3, relativeLayout.getId());
            ((AbstractC2178Zv) this).A09.setLayoutParams(layoutParams);
            viewGroup.addView(((AbstractC2178Zv) this).A09);
            viewGroup.addView(this.A0Q);
            viewGroup.addView(this.A0P);
        }
        A01(i10);
    }
}
