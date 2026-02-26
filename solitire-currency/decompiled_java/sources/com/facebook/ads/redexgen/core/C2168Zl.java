package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2168Zl extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public C2168Zl(C2387dL c2387dL) {
        super(c2387dL);
        this.A03 = new ImageView(c2387dL);
        this.A02 = new ImageView(c2387dL);
        A00();
    }

    public C2168Zl(C2387dL c2387dL, AttributeSet attributeSet) {
        super(c2387dL, attributeSet);
        this.A03 = new ImageView(c2387dL, attributeSet);
        this.A02 = new ImageView(c2387dL, attributeSet);
        A00();
    }

    public C2168Zl(C2387dL c2387dL, AttributeSet attributeSet, int i10) {
        super(c2387dL, attributeSet, i10);
        this.A03 = new ImageView(c2387dL, attributeSet, i10);
        this.A02 = new ImageView(c2387dL, attributeSet, i10);
        A00();
    }

    public C2168Zl(C2387dL c2387dL, AttributeSet attributeSet, int i10, int i11) {
        super(c2387dL, attributeSet, i10, i11);
        this.A03 = new ImageView(c2387dL, attributeSet, i10, i11);
        this.A02 = new ImageView(c2387dL, attributeSet, i10, i11);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        EnumC2095Wq.A04(this.A03, EnumC2095Wq.A0B);
        setId(XP.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.A01 <= 0 || this.A00 <= 0) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        float fMin = Math.min(i14 / this.A01, i15 / this.A00);
        int i16 = (int) (this.A01 * fMin);
        int i17 = (int) (this.A00 * fMin);
        this.A02.layout(i10, i11, i12, i13);
        int blurBorderViewHeight = (i14 / 2) + i10;
        int blurBorderViewWidth = (i15 / 2) + i11;
        this.A03.layout(blurBorderViewHeight - (i16 / 2), blurBorderViewWidth - (i17 / 2), (i16 / 2) + blurBorderViewHeight, blurBorderViewWidth + (i17 / 2));
        this.A02.setVisibility(0);
    }

    public void setImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            XP.A0Q(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            XP.A0K(this.A02, 0);
        }
        if (bitmap != null) {
            this.A01 = bitmap.getWidth();
            this.A00 = bitmap.getHeight();
            this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.A03.setImageDrawable(null);
    }
}
