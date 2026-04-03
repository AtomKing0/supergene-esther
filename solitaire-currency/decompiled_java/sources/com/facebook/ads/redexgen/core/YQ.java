package com.facebook.ads.redexgen.core;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YQ extends LinearLayout {
    public static String[] A04 = {"iBjFS74UqofOwX9raECs8wFiPopmP8ZT", "DvkIZsK2SfYDf1PYliynkurznpBmB2mx", "JthO9De0vDUnz", "alrxHoKVfabvqyWYzjdfx1EKUXaFGyZT", "MSxuugz3RBTPC5P7p9BXefIxh5y8oQF5", "xAXGeIm", "UaB9zlLwJ5ijSfJwpwiqdPYYRduUW", "7D"};
    public static final int A05 = (int) (AbstractC2090Wl.A02 * 10.0f);
    public static final int A06 = (int) (AbstractC2090Wl.A02 * 16.0f);
    public static final int A07 = (int) (AbstractC2090Wl.A02 * 40.0f);
    public int A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final C2387dL A03;

    public YQ(C2387dL c2387dL, int i10) {
        super(c2387dL);
        this.A03 = c2387dL;
        this.A01 = new ImageView(c2387dL);
        this.A02 = new LinearLayout(c2387dL);
        this.A00 = i10;
        A00();
    }

    private void A00() {
        A01();
        setToolbarActionMode(this.A00);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A07, A07);
        layoutParams2.setMargins(A06, 0, A06, 0);
        this.A01.setLayoutParams(layoutParams2);
        this.A02.addView(this.A01, layoutParams2);
        addView(this.A02, layoutParams);
    }

    private void A01() {
        this.A01.setColorFilter(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Integer.MIN_VALUE);
        this.A01.setBackground(gradientDrawable);
        this.A01.setPadding(A05, A05, A05, A05);
    }

    public final boolean A02() {
        return (this.A00 == 2 || this.A00 == 4) ? false : true;
    }

    public int getToolbarActionMode() {
        return this.A00;
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setInitialUnskippableSeconds(int i10) {
        if (i10 > 0) {
            setToolbarActionMode(2);
        }
    }

    public void setToolbarActionMode(int i10) {
        XX xx;
        this.A03.A0F().AFR(i10);
        this.A00 = i10;
        setVisibility(4);
        switch (i10) {
            case 0:
                xx = XX.NAV_CROSS;
                setVisibility(0);
                break;
            case 1:
                xx = XX.ICON_SKIP;
                String[] strArr = A04;
                if (strArr[4].charAt(14) != strArr[1].charAt(14)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A04;
                strArr2[2] = "tOoZDmetKHu9g";
                strArr2[7] = "rn";
                setVisibility(0);
                break;
            case 8:
                xx = XX.OTHER_SKIP;
                setVisibility(0);
                break;
            default:
                xx = XX.NAV_CROSS;
                break;
        }
        this.A01.setImageBitmap(XY.A01(xx));
        if (i10 == 1) {
            XP.A0E(1005, this.A01);
        } else {
            XP.A0E(1002, this.A01);
        }
    }
}
