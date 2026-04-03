package com.facebook.ads.redexgen.core;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2200aJ extends LinearLayout {
    public int A00;
    public List<GradientDrawable> A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public C2200aJ(C2387dL c2387dL, C1850My c1850My, int i10) {
        super(c2387dL);
        this.A00 = -1;
        setOrientation(0);
        setGravity(17);
        float f10 = AbstractC2090Wl.A02;
        int i11 = (int) (8.0f * f10);
        int i12 = (int) (6.0f * f10);
        this.A02 = (int) (1.0f * f10);
        this.A04 = c1850My.A05(false);
        this.A03 = OP.A02(this.A04, 128);
        this.A01 = new ArrayList();
        for (int margin = 0; margin < i10; margin++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i11, i11);
            gradientDrawable.setStroke(this.A02, 0);
            ImageView imageView = new ImageView(c2387dL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, i12, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.A01.add(gradientDrawable);
            addView(imageView);
        }
        A00(0);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A00(int r6) {
        /*
            r5 = this;
            int r0 = r5.A00
            if (r0 != r6) goto L5
            return
        L5:
            r5.A00 = r6
            r4 = 0
        L8:
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            int r0 = r0.size()
            if (r4 >= r0) goto L40
            if (r4 != r6) goto L3c
            int r3 = r5.A04
            int r2 = r5.A04
        L16:
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r1 = r0.get(r4)
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r0 = r5.A02
            r1.setStroke(r0, r2)
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r0 = r0.get(r4)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r0.setColor(r3)
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r0 = r0.get(r4)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r0.invalidateSelf()
            int r4 = r4 + 1
            goto L8
        L3c:
            int r3 = r5.A03
            r2 = 0
            goto L16
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2200aJ.A00(int):void");
    }
}
