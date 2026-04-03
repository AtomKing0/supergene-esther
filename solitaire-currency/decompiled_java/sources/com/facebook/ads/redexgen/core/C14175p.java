package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14175p extends KL {
    public static String[] A00 = {"xFpGP6HPJdxG02oIdF9HxIihRC1N68eF", "SON7b0vH7pU6goQPwxtgPgRIrt0b", "K8DFrhhg1SsjCm4z8vXCiiOaNBIf4pDg", "gTEb8e", "wHRSkCegs17WrS1ZFDoTECKCsF5cwC3Q", "MW7m9Sx4Y", "aUUm4uG1aRzEZg1qhLXNvnDll0TBP1yk", "rrQmUhcDQBY8PjMlrfgiyZrhPVfY"};
    public static final int A02 = (int) (AbstractC2090Wl.A02 * 152.0f);
    public static final int A01 = (int) (AbstractC2090Wl.A02 * 60.0f);

    public C14175p(C2387dL c2387dL, KE ke, int i10, boolean z10, C1850My c1850My, String str, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, AbstractC2662hy abstractC2662hy, C1590Cw c1590Cw, C2030Ua c2030Ua, boolean z11) {
        super(c2387dL, ke, i10, z10, c1850My, false, str, us, interfaceC2118Xn, c2460eX, xh, abstractC2662hy, c1590Cw, c2030Ua, z11);
        int i11 = getResources().getConfiguration().orientation;
        A03(i11);
        A04(i11);
        A0A(i11);
        A01();
        A07(i11);
        A06(i11);
        A0D(i11);
        A08(i11);
        A0C(i11);
        XP.A0I(this.A0P);
        if (i11 == 1) {
            A09(i11);
        }
        A0B(i11);
        A02(i11);
        A05(i11);
        this.A0O.addView(this.A0M);
        addView(this.A0O);
    }

    private void A00() {
        XP.A0Z(((AbstractC2178Zv) this).A09, this.A0Q, ((AbstractC2178Zv) this).A08, this.A0U, ((KL) this).A04, this.A0P, this.A0I, this.A0K, this.A0J, this.A0L, this.A0N);
    }

    private void A01() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.A0L.setLayoutParams(layoutParams);
        this.A0L.setGravity(1);
        this.A0L.setOrientation(1);
    }

    private void A02(int i10) {
        A00();
        if (i10 == 1) {
            if (((KL) this).A04 != null && ((KL) this).A04.getVisibility() == 0) {
                this.A0O.addView(((KL) this).A04);
            }
            this.A0O.addView(this.A0U);
            this.A0O.addView(this.A0J);
            this.A0O.addView(((AbstractC2178Zv) this).A08);
            this.A0O.addView(this.A0I);
            if (this.A0Y) {
                A0o();
            }
        } else {
            this.A0L.addView(this.A0I);
            this.A0L.addView(((AbstractC2178Zv) this).A08);
            this.A0N.addView(this.A0L);
            this.A0N.addView(((AbstractC2178Zv) this).A09);
            this.A0N.addView(this.A0Q);
            this.A0M.addView(this.A0J);
            this.A0M.addView(this.A0N);
            this.A0M.addView(this.A0U);
            if (((KL) this).A04 != null && ((KL) this).A04.getVisibility() == 0) {
                this.A0M.addView(((KL) this).A04);
            }
        }
        this.A0O.addView(this.A0K);
    }

    private void A03(int i10) {
        if (i10 == 2) {
            ((KL) this).A05 = new CU(this.A0M, 400, 100, 0);
            this.A0W.set(false);
        }
    }

    private void A04(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0M.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, KL.A0l);
        if (i10 == 1) {
            this.A0M.setVisibility(8);
        } else {
            int i11 = getResources().getDisplayMetrics().widthPixels;
            if (A00[5].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[6] = "fxD9Evjxj1QSbkd6sjXNqMWP1zvaSe0y";
            strArr[2] = "LbyTcx7MzeGvJAIRAeX8dxGClI61VeIC";
            layoutParams.width = (int) (i11 * 0.4f);
            layoutParams.height = -2;
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            this.A0M.setPadding(KL.A0l, KL.A0l, KL.A0l, KL.A0l);
            A0s(this.A0M, -1728053248, new float[]{32.0f, 32.0f, 0.0f, 0.0f, 0.0f, 0.0f, 32.0f, 32.0f});
            this.A0M.setVisibility(0);
        }
        this.A0M.setLayoutParams(layoutParams);
    }

    private void A05(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0K.getLayoutParams();
        if (i10 == 1) {
            layoutParams.removeRule(20);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, 0, KL.A0r, 0);
            this.A0K.setPadding(KL.A0u, KL.A0u, 0, 0);
        } else {
            layoutParams.removeRule(21);
            layoutParams.addRule(20);
            if (A00[3].length() == 25) {
                throw new RuntimeException();
            }
            A00[3] = "loHD1sEgjyAFCmeIlD5ALXOeqArjH8d";
            layoutParams.setMargins(KL.A0r, 0, 0, 0);
        }
        layoutParams.addRule(12);
        this.A0K.setPadding(0, KL.A0u, KL.A0u, 0);
        this.A0K.setLayoutParams(layoutParams);
    }

    private void A06(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, KL.A0b);
        if (i10 == 1) {
            layoutParams.removeRule(15);
            ((KL) this).A02 = 30;
            layoutParams.addRule(14);
            layoutParams.setMargins(KL.A0r, 0, KL.A0r, KL.A0l);
            layoutParams.addRule(2, this.A0U.getId());
            ((AbstractC2178Zv) this).A08.setMinWidth(-1);
        } else {
            layoutParams.removeRule(2);
            ((KL) this).A02 = 16;
            layoutParams.width = -2;
            layoutParams.height = KL.A0i;
            if (this.A0I.getVisibility() != 0) {
                layoutParams.addRule(15);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            ((AbstractC2178Zv) this).A08.setMinWidth((int) (getResources().getDisplayMetrics().widthPixels * 0.12f));
        }
        layoutParams.addRule(14);
        ((AbstractC2178Zv) this).A08.setLayoutParams(layoutParams);
        ((AbstractC2178Zv) this).A08.setPadding(KL.A0s, 0, KL.A0s, 0);
        A0l();
    }

    private void A07(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(KL.A0c, KL.A0c);
        if (i10 == 1) {
            layoutParams.addRule(2, ((AbstractC2178Zv) this).A08.getId());
            layoutParams.setMargins(0, 0, 0, KL.A0u);
            layoutParams.addRule(14);
        } else {
            layoutParams.setMargins(0, 0, 0, KL.A0s);
            layoutParams.removeRule(14);
            layoutParams.removeRule(2);
        }
        this.A0I.setLayoutParams(layoutParams);
    }

    private void A08(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.removeRule(12);
        layoutParams.removeRule(3);
        if (i10 != 1) {
            layoutParams.addRule(3, this.A0U.getId());
            layoutParams.addRule(11);
            layoutParams.setMargins(0, KL.A0k, 0, 0);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(7, ((AbstractC2178Zv) this).A08.getId());
            layoutParams.setMargins(0, 0, 0, KL.A0l);
        }
        this.A0J.setLayoutParams(layoutParams);
    }

    private void A09(int i10) {
        if (i10 == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0P.getLayoutParams();
            layoutParams.addRule(14);
            layoutParams.addRule(3, this.A0Q.getId());
            layoutParams.setMargins(KL.A0t, 0, KL.A0t, KL.A0u);
            this.A0P.setTypeface(Typeface.DEFAULT);
            this.A0P.setTextSize(18.0f);
            this.A0P.setLayoutParams(layoutParams);
            this.A0P.setMaxLines(2);
        }
    }

    private void A0A(int i10) {
        int topMargin;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2178Zv) this).A09.getLayoutParams();
        if (i10 == 1) {
            layoutParams.width = A02;
            layoutParams.height = A02;
            layoutParams.setMargins(0, (-A02) / 4, 0, 0);
            layoutParams.addRule(14);
            topMargin = 30;
        } else {
            layoutParams.removeRule(3);
            layoutParams.removeRule(14);
            layoutParams.width = A01;
            layoutParams.height = A01;
            layoutParams.setMargins(0, 0, KL.A0u, 0);
            topMargin = 12;
        }
        if (!this.A0X) {
            ((AbstractC2178Zv) this).A09.setRadius(topMargin);
        }
        ((AbstractC2178Zv) this).A09.setLayoutParams(layoutParams);
    }

    private void A0B(int i10) {
        if (((KL) this).A04 == null || ((KL) this).A04.getVisibility() != 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((KL) this).A04.getLayoutParams();
        layoutParams.removeRule(5);
        layoutParams.removeRule(3);
        layoutParams.removeRule(2);
        if (i10 != 1) {
            layoutParams.addRule(3, this.A0U.getId());
            int i11 = KL.A0s;
            if (A00[3].length() == 25) {
                throw new RuntimeException();
            }
            A00[5] = "VmlO4tbuG";
            layoutParams.setMargins(0, i11, 0, 0);
        } else {
            if (this.A0J.getVisibility() == 0) {
                layoutParams.addRule(2, this.A0J.getId());
            } else {
                layoutParams.addRule(2, this.A0K.getId());
            }
            layoutParams.addRule(5, this.A0U.getId());
            layoutParams.setMargins(0, KL.A0u, 0, 0);
        }
        ((KL) this).A04.setLayoutParams(layoutParams);
    }

    private void A0C(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0U.getLayoutParams();
        layoutParams.removeRule(2);
        layoutParams.removeRule(3);
        if (i10 == 1) {
            if (this.A0J.getVisibility() == 0) {
                layoutParams.addRule(2, this.A0J.getId());
            } else {
                layoutParams.addRule(2, this.A0K.getId());
            }
            layoutParams.setMargins(KL.A0r, 0, KL.A0r, KL.A0o);
        } else {
            layoutParams.setMargins(0, KL.A0u, 0, 0);
            layoutParams.addRule(3, this.A0N.getId());
        }
        this.A0U.setLayoutParams(layoutParams);
    }

    private void A0D(int i10) {
        int i11;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0Q.getLayoutParams();
        if (i10 == 1) {
            layoutParams.removeRule(1);
            layoutParams.removeRule(15);
            layoutParams.removeRule(0);
            i11 = 4;
            layoutParams.addRule(14);
            layoutParams.addRule(3, ((AbstractC2178Zv) this).A09.getId());
            int i12 = KL.A0r;
            int i13 = KL.A0l;
            int textAlignment = KL.A0r;
            layoutParams.setMargins(i12, i13, textAlignment, KL.A0u);
            this.A0Q.setTypeface(Typeface.DEFAULT_BOLD);
            this.A0Q.setTextSize(30.0f);
            this.A0Q.setMaxLines(2);
        } else {
            layoutParams.removeRule(3);
            layoutParams.removeRule(14);
            i11 = 5;
            layoutParams.addRule(15);
            layoutParams.addRule(1, ((AbstractC2178Zv) this).A09.getId());
            layoutParams.addRule(0, this.A0L.getId());
            layoutParams.setMargins(0, 0, KL.A0u, 0);
            this.A0Q.setTypeface(Typeface.DEFAULT);
            this.A0Q.setTextSize(20.0f);
            this.A0Q.setMaxLines(1);
        }
        this.A0Q.setTextAlignment(i11);
        this.A0Q.setLayoutParams(layoutParams);
        this.A0Q.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.facebook.ads.redexgen.core.KL, com.facebook.ads.redexgen.core.AbstractC2178Zv
    public final void A0i(int i10) {
        super.A0i(i10);
        A00();
        A04(i10);
        A05(i10);
        A08(i10);
        A0B(i10);
        A0C(i10);
        A01();
        A07(i10);
        A06(i10);
        A0A(i10);
        A0D(i10);
        A09(i10);
        A02(i10);
    }

    @Override // com.facebook.ads.redexgen.core.KL
    public final void A0r(int i10) {
        if (((KL) this).A05 != null && i10 == 2) {
            ((KL) this).A05.A42(true, false);
        }
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
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2178Zv
    public void setInfo(C1848Mw c1848Mw, C1851Mz c1851Mz, String str, String str2, InterfaceC2100Wv interfaceC2100Wv, InterfaceC2187a4 interfaceC2187a4) {
        super.setInfo(c1848Mw, c1851Mz, str, str2, interfaceC2100Wv, interfaceC2187a4);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2178Zv
    public void setTitleMaxLines(int i10) {
        this.A0Q.setMaxLines(i10);
        this.A0Q.setEllipsize(TextUtils.TruncateAt.END);
    }
}
