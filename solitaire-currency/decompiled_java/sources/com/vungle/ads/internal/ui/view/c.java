package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vungle.ads.internal.util.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MediaView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends RelativeLayout {
    private ImageView imageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context);
        t.i(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ImageView imageView = this.imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            t.A("imageView");
            imageView = null;
        }
        imageView.setLayoutParams(layoutParams);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            t.A("imageView");
            imageView3 = null;
        }
        imageView3.setAdjustViewBounds(true);
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            t.A("imageView");
        } else {
            imageView2 = imageView4;
        }
        addView(imageView2);
        requestLayout();
    }

    public final void destroy() {
        ImageView imageView = null;
        try {
            ImageView imageView2 = this.imageView;
            if (imageView2 == null) {
                t.A("imageView");
                imageView2 = null;
            }
            Drawable drawable = imageView2.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (Exception e10) {
            p.Companion.w("NativeAd", "error msg: " + e10.getLocalizedMessage());
        }
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            t.A("imageView");
            imageView3 = null;
        }
        imageView3.setImageDrawable(null);
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            t.A("imageView");
            imageView4 = null;
        }
        if (imageView4.getParent() != null) {
            ImageView imageView5 = this.imageView;
            if (imageView5 == null) {
                t.A("imageView");
                imageView5 = null;
            }
            ViewParent parent = imageView5.getParent();
            t.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            ImageView imageView6 = this.imageView;
            if (imageView6 == null) {
                t.A("imageView");
            } else {
                imageView = imageView6;
            }
            viewGroup.removeView(imageView);
        }
    }

    @NotNull
    public final ImageView getMainImage$vungle_ads_release() {
        ImageView imageView = this.imageView;
        if (imageView != null) {
            return imageView;
        }
        t.A("imageView");
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        t.i(context, "context");
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t.i(context, "context");
        initView(context);
    }
}
