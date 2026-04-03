package com.vungle.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeAdOptionsView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h1 extends FrameLayout {
    private static final int AD_OPTIONS_VIEW_SIZE = 20;

    @NotNull
    public static final a Companion = new a(null);
    private ImageView icon;

    /* JADX INFO: compiled from: NativeAdOptionsView.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.icon = new ImageView(context);
        int iDpToPixels = com.vungle.ads.internal.util.x.INSTANCE.dpToPixels(context, 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPixels, iDpToPixels);
        ImageView imageView = this.icon;
        ImageView imageView2 = null;
        if (imageView == null) {
            kotlin.jvm.internal.t.A(v8.h.H0);
            imageView = null;
        }
        imageView.setLayoutParams(layoutParams);
        ImageView imageView3 = this.icon;
        if (imageView3 == null) {
            kotlin.jvm.internal.t.A(v8.h.H0);
        } else {
            imageView2 = imageView3;
        }
        addView(imageView2);
    }

    public final void destroy() {
        try {
            ImageView imageView = this.icon;
            if (imageView == null) {
                kotlin.jvm.internal.t.A(v8.h.H0);
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.w("NativeAd", "error msg: " + e10.getLocalizedMessage());
        }
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            kotlin.jvm.internal.t.A(v8.h.H0);
            imageView2 = null;
        }
        imageView2.setImageDrawable(null);
        removeAllViews();
        if (getParent() != null) {
            ViewParent parent = getParent();
            kotlin.jvm.internal.t.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
    }

    @NotNull
    public final ImageView getPrivacyIcon$vungle_ads_release() {
        ImageView imageView = this.icon;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.t.A(v8.h.H0);
        return null;
    }

    public final void renderTo(@NotNull FrameLayout rootView, int i10) {
        kotlin.jvm.internal.t.i(rootView, "rootView");
        if (getParent() != null) {
            ViewParent parent = getParent();
            kotlin.jvm.internal.t.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        rootView.addView(this);
        com.vungle.ads.internal.util.x xVar = com.vungle.ads.internal.util.x.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.t.h(context, "context");
        int iDpToPixels = xVar.dpToPixels(context, 20);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPixels, iDpToPixels);
        if (i10 == 0) {
            layoutParams.gravity = 8388659;
        } else if (i10 == 1) {
            layoutParams.gravity = 8388661;
        } else if (i10 == 2) {
            layoutParams.gravity = 8388691;
        } else if (i10 != 3) {
            layoutParams.gravity = 8388661;
        } else {
            layoutParams.gravity = 8388693;
        }
        setLayoutParams(layoutParams);
        rootView.requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.t.i(context, "context");
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.t.i(context, "context");
        initView(context);
    }
}
