package com.king.amp.sa;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes4.dex */
public class AbmMediaPlayerChapterAdIndicatorView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView[] f16647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f16648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f16649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16650d;

    public AbmMediaPlayerChapterAdIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(Context context, int i10) {
        this.f16647a = new ImageView[i10];
        this.f16648b = ContextCompat.getDrawable(context, j6.d.f28709b);
        this.f16649c = ContextCompat.getDrawable(context, j6.d.f28710c);
        this.f16648b.setAlpha(204);
        this.f16649c.setAlpha(204);
        int dimension = (int) getResources().getDimension(j6.c.f28707a);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f16647a[i11] = new ImageView(context);
            this.f16647a[i11].setImageDrawable(this.f16649c);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(0, 12, 0, 12);
            addView(this.f16647a[i11], layoutParams);
        }
        this.f16650d = 0;
        this.f16647a[0].setImageDrawable(this.f16648b);
    }

    public void b(int i10) {
        this.f16647a[this.f16650d].setImageDrawable(this.f16649c);
        this.f16647a[i10].setImageDrawable(this.f16648b);
        this.f16650d = i10;
    }
}
