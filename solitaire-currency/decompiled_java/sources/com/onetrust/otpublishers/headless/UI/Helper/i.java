package com.onetrust.otpublishers.headless.UI.Helper;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.UI.Helper.l;
import com.onetrust.otpublishers.headless.UI.UIProperty.q;
import com.onetrust.otpublishers.headless.UI.UIProperty.x;
import com.onetrust.otpublishers.headless.qrcode.OTQRCodeUtils;
import com.unity3d.services.UnityAdsConstants;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static int a(int i10, @NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return 20;
        }
        if (i10 == 4) {
            return 23;
        }
        if (i10 == 61) {
            return 22;
        }
        if (i10 == 66) {
            return 21;
        }
        switch (i10) {
        }
        return 20;
    }

    @NonNull
    @RequiresApi(api = 21)
    public static GradientDrawable b(boolean z10, String str, String str2, String str3, String str4, @NonNull ImageView imageView) {
        float f10;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setCornerRadius(Float.parseFloat(ExifInterface.GPS_MEASUREMENT_3D));
        if (z10) {
            gradientDrawable.setStroke(Integer.parseInt("2"), l(str));
            gradientDrawable.setColor(l(str2));
            f10 = 6.0f;
        } else {
            gradientDrawable.setStroke(Integer.parseInt("2"), l(str3));
            gradientDrawable.setColor(l(str4));
            f10 = 0.0f;
        }
        imageView.setElevation(f10);
        return gradientDrawable;
    }

    public static String c(@NonNull String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (!Pattern.compile(".*\\<[^>]+>.*", 32).matcher(str).matches()) {
            return str.replace(v8.i.f15837d, "").replace(v8.i.f15839e, "").replace("\"", "").replace("\\", "");
        }
        String strReplace = str.replace("\\/", UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
        if (strReplace.startsWith(v8.i.f15837d) || strReplace.endsWith(v8.i.f15839e)) {
            strReplace = strReplace.replace(v8.i.f15837d, "").replace(v8.i.f15839e, "").replace("\"", "").replace("\\", "");
        }
        return new SpannableStringBuilder(Html.fromHtml(strReplace, null, new l.a())).toString();
    }

    @RequiresApi(api = 21)
    public static void d(@NonNull Button button, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar) {
        button.setVisibility(fVar.d());
        button.setText(fVar.a());
        m(button, fVar, false);
    }

    @RequiresApi(api = 21)
    public static void e(@NonNull Button button, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, boolean z10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(Float.parseFloat(ExifInterface.GPS_MEASUREMENT_3D));
        if (z10) {
            gradientDrawable.setStroke(Integer.parseInt("2"), l(fVar.f22768k));
            gradientDrawable.setColor(l(fVar.f22766i));
            button.setTextColor(l(fVar.f22767j));
            button.setElevation(6.0f);
        } else {
            gradientDrawable.setStroke(Integer.parseInt("2"), l(fVar.f22761d));
            gradientDrawable.setColor(l(fVar.f22759b));
            button.setTextColor(l(fVar.c()));
            button.setElevation(0.0f);
        }
        button.setBackground(gradientDrawable);
        button.setMinHeight(5);
        button.setMinimumHeight(5);
    }

    public static void f(@NonNull TextView textView, @NonNull String str) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(l(str), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public static void g(@Nullable FragmentActivity fragmentActivity, String str, String str2, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar) {
        if (fragmentActivity == null || !com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(fragmentActivity, "TV Utils")) {
            return;
        }
        Dialog dialog = new Dialog(fragmentActivity);
        View viewInflate = fragmentActivity.getLayoutInflater().inflate(p6.e.O, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(p6.d.Y6);
        TextView textView = (TextView) viewInflate.findViewById(p6.d.N3);
        ImageView imageView = (ImageView) viewInflate.findViewById(p6.d.M3);
        textView.setText(str2);
        String str3 = fVar.f22766i;
        String str4 = fVar.f22767j;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            linearLayout.setBackgroundColor(l(str3));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
            textView.setTextColor(l(str4));
        }
        OTQRCodeUtils.b(str, fragmentActivity, "#00000000", str4, imageView, true);
        dialog.setContentView(viewInflate);
        dialog.create();
        dialog.setCancelable(true);
        dialog.show();
    }

    @RequiresApi(api = 21)
    public static void h(boolean z10, @NonNull Button button, @NonNull com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar, String str, boolean z11) {
        String str2;
        String str3;
        String str4;
        x xVar = cVar.f22370j;
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = xVar.f22873y;
        q qVar = xVar.B;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(Float.parseFloat(str));
        if (z10) {
            str2 = fVar.f22768k;
            str3 = fVar.f22766i;
            str4 = fVar.f22767j;
            button.setElevation(6.0f);
        } else if (z11) {
            str4 = qVar.f22799f;
            str3 = qVar.f22798e;
            button.setElevation(0.0f);
            str2 = str4;
        } else {
            String str5 = fVar.f22761d;
            String str6 = fVar.f22759b;
            String strC = fVar.c();
            button.setElevation(0.0f);
            str2 = str5;
            str3 = str6;
            str4 = strC;
        }
        gradientDrawable.setStroke(Integer.parseInt("2"), l(str2));
        gradientDrawable.setColor(l(str3));
        button.setTextColor(l(str4));
        button.setElevation(6.0f);
        button.setBackground(gradientDrawable);
        button.setMinHeight(0);
        button.setMinimumHeight(0);
    }

    @RequiresApi(api = 21)
    public static void i(boolean z10, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, @NonNull ImageView imageView) {
        Drawable background;
        String str;
        if (z10) {
            imageView.getDrawable().setTint(l(fVar.f22767j));
            if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
                imageView.setBackground(b(true, fVar.f22768k, fVar.f22766i, fVar.f22761d, fVar.f22759b, imageView));
                return;
            } else {
                background = imageView.getBackground();
                str = fVar.f22766i;
            }
        } else {
            imageView.getDrawable().setTint(l(fVar.c()));
            if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
                imageView.setBackground(b(false, fVar.f22768k, fVar.f22766i, fVar.f22761d, fVar.f22759b, imageView));
                return;
            } else {
                background = imageView.getBackground();
                str = fVar.f22759b;
            }
        }
        background.setTint(l(str));
    }

    @NonNull
    public static String j(@NonNull String str) {
        try {
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error on computing dark colors "), "TV Utils", 6);
        }
        boolean z10 = (((double) Integer.valueOf(str.substring(5, 7), 16).intValue()) * 0.114d) + ((((double) Integer.valueOf(str.substring(3, 5), 16).intValue()) * 0.587d) + (((double) Integer.valueOf(str.substring(1, 3), 16).intValue()) * 0.299d)) <= 90.0d;
        return str.substring(0, 1) + (z10 ? "bb" : "F1") + str.substring(1, str.length());
    }

    public static void k(Button button, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, boolean z10) {
        if (z10) {
            button.setElevation(6.0f);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22766i) && !com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22767j)) {
                button.getBackground().setTint(l(fVar.f22766i));
                button.setTextColor(l(fVar.f22767j));
            }
        } else {
            button.setElevation(0.0f);
            button.getBackground().setTint(l(fVar.f22759b));
            button.setTextColor(l(fVar.c()));
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            return;
        }
        e(button, fVar, z10);
    }

    public static int l(String str) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return 0;
        }
        return Color.parseColor(str);
    }

    @RequiresApi(api = 21)
    public static void m(@NonNull Button button, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, boolean z10) {
        button.setElevation(0.0f);
        if (fVar.c() != null) {
            button.setTextColor(l(fVar.c()));
        }
        button.getBackground().setTint(l(fVar.f22759b));
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            return;
        }
        e(button, fVar, z10);
    }
}
