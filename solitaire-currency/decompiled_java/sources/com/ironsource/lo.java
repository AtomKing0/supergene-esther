package com.ironsource;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class lo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f13059a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private static final GradientDrawable a() {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(Color.parseColor("#000000"));
            return gradientDrawable;
        }

        private final View a(Context context) {
            TextView textView = new TextView(context);
            textView.setText(CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(15.0f);
            textView.setBackground(a());
            textView.setAlpha(0.2f);
            textView.setPadding(21, 0, 21, 0);
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            return textView;
        }

        @NotNull
        public final View a(@NotNull Context context, @Nullable String str, @NotNull sg imageLoader) {
            kotlin.jvm.internal.t.i(context, "context");
            kotlin.jvm.internal.t.i(imageLoader, "imageLoader");
            if (str == null) {
                return a(context);
            }
            Object objA = imageLoader.a(str);
            if (v8.t.g(objA)) {
                objA = null;
            }
            Drawable drawable = (Drawable) objA;
            if (drawable == null) {
                return a(context);
            }
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            return imageView;
        }
    }
}
