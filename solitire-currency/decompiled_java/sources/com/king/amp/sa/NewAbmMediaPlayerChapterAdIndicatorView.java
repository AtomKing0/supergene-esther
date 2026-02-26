package com.king.amp.sa;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes4.dex */
public class NewAbmMediaPlayerChapterAdIndicatorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f16707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f16708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f16709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView[] f16710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f16711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f16712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16713g;

    public NewAbmMediaPlayerChapterAdIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    private void b(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f16707a = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f16707a, new FrameLayout.LayoutParams(-1, -2));
        this.f16708b = new FrameLayout(context);
        addView(this.f16708b, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context) {
        if (this.f16707a.getChildCount() > 0) {
            int width = this.f16707a.getWidth();
            int height = this.f16707a.getHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16708b.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.f16708b.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ((ImageView) this.f16707a.getChildAt(0)).getLayoutParams();
            ImageView imageView = new ImageView(context);
            this.f16709c = imageView;
            imageView.setImageResource(j6.d.f28709b);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            layoutParams3.leftMargin = layoutParams2.leftMargin;
            layoutParams3.topMargin = layoutParams2.topMargin;
            this.f16708b.addView(this.f16709c, layoutParams3);
        }
    }

    public void d(int i10, float f10) {
        ImageView imageView = this.f16709c;
        if (imageView != null) {
            imageView.setTranslationY((this.f16713g + 24) * (i10 + f10));
        }
    }

    public void e(final Context context, int i10) {
        this.f16710d = new ImageView[i10];
        this.f16711e = ContextCompat.getDrawable(context, j6.d.f28709b);
        this.f16712f = ContextCompat.getDrawable(context, j6.d.f28710c);
        this.f16711e.setAlpha(204);
        this.f16712f.setAlpha(204);
        this.f16713g = (int) getResources().getDimension(j6.c.f28707a);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f16710d[i11] = new ImageView(context);
            this.f16710d[i11].setImageDrawable(this.f16712f);
            int i12 = this.f16713g;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i12, i12);
            layoutParams.setMargins(0, 12, 0, 12);
            this.f16707a.addView(this.f16710d[i11], layoutParams);
        }
        this.f16707a.post(new Runnable() { // from class: com.king.amp.sa.q1
            @Override // java.lang.Runnable
            public final void run() {
                this.f16865a.c(context);
            }
        });
    }
}
