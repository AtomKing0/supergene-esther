package com.braze.ui.inappmessage.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.GravityCompat;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InAppMessageViewUtils {

    @NotNull
    public static final InAppMessageViewUtils INSTANCE = new InAppMessageViewUtils();

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageViewUtils$closeInAppMessageOnKeycodeBack$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageViewUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Back button intercepted by in-app message view, closing in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageViewUtils$setDrawableColor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageViewUtils.kt */
    static final class C12591 extends v implements a<String> {
        public static final C12591 INSTANCE = new C12591();

        C12591() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "LayerDrawable for button background did not have the expected number of layers or the 0th layer was not a GradientDrawable.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.InAppMessageViewUtils$setIcon$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageViewUtils.kt */
    static final class C12601 extends v implements a<String> {
        public static final C12601 INSTANCE = new C12601();

        C12601() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Caught exception setting icon typeface. Not rendering icon.";
        }
    }

    private InAppMessageViewUtils() {
    }

    public static final void closeInAppMessageOnKeycodeBack() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    public static final void resetMessageMarginsIfNecessary(@Nullable TextView textView, @Nullable TextView textView2) {
        if (textView2 != null || textView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(textView.getLayoutParams().width, textView.getLayoutParams().height);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
    }

    public static final void setDrawableColor(@NotNull Drawable drawable, @ColorInt int i10) {
        t.i(drawable, "drawable");
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            if (layerDrawable.getNumberOfLayers() <= 0 || !(layerDrawable.getDrawable(0) instanceof GradientDrawable)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12591.INSTANCE, 7, (Object) null);
            } else {
                Drawable drawable2 = layerDrawable.getDrawable(0);
                t.h(drawable2, "drawable.getDrawable(0)");
                setDrawableColor(drawable2, i10);
            }
        }
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i10);
        } else {
            INSTANCE.setDrawableColorFilter(drawable, i10);
        }
    }

    private final void setDrawableColorFilter(Drawable drawable, @ColorInt int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            drawable.setColorFilter(new BlendModeColorFilter(i10, BlendMode.SRC_ATOP));
        } else {
            drawable.setColorFilter(i10, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static final void setFrameColor(@NotNull View view, @Nullable Integer num) {
        t.i(view, "view");
        if (num != null) {
            view.setBackgroundColor(num.intValue());
        }
    }

    public static final void setIcon(@NotNull Context context, @Nullable String str, int i10, int i11, @NotNull TextView textView) {
        t.i(context, "context");
        t.i(textView, "textView");
        if (str != null) {
            try {
                textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf"));
                textView.setText(str);
                setTextViewColor(textView, i10);
                if (textView.getBackground() == null) {
                    setViewBackgroundColor(textView, i11);
                    return;
                }
                Drawable background = textView.getBackground();
                t.h(background, "textView.background");
                setDrawableColor(background, i11);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C12601.INSTANCE, 4, (Object) null);
            }
        }
    }

    public static final void setImage(@Nullable Bitmap bitmap, @NotNull ImageView imageView) {
        t.i(imageView, "imageView");
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static final void setTextAlignment(@NotNull TextView textView, @NotNull TextAlign textAlign) {
        t.i(textView, "textView");
        t.i(textAlign, "textAlign");
        if (textAlign == TextAlign.START) {
            textView.setGravity(GravityCompat.START);
        } else if (textAlign == TextAlign.END) {
            textView.setGravity(GravityCompat.END);
        } else if (textAlign == TextAlign.CENTER) {
            textView.setGravity(17);
        }
    }

    public static final void setTextViewColor(@NotNull TextView textView, int i10) {
        t.i(textView, "textView");
        textView.setTextColor(i10);
    }

    public static final void setViewBackgroundColor(@NotNull View view, int i10) {
        t.i(view, "view");
        view.setBackgroundColor(i10);
    }

    public static final void setViewBackgroundColorFilter(@NotNull View view, @ColorInt int i10) {
        t.i(view, "view");
        InAppMessageViewUtils inAppMessageViewUtils = INSTANCE;
        Drawable background = view.getBackground();
        t.h(background, "view.background");
        inAppMessageViewUtils.setDrawableColorFilter(background, i10);
        view.getBackground().setAlpha(Color.alpha(i10));
    }
}
