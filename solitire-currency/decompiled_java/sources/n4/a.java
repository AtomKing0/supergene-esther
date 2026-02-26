package n4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import u4.b;

/* JADX INFO: compiled from: MaterialColors.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    @ColorInt
    public static int a(@ColorInt int i10, @IntRange(from = 0, to = 255) int i11) {
        return ColorUtils.setAlphaComponent(i10, (Color.alpha(i10) * i11) / 255);
    }

    @ColorInt
    public static int b(@NonNull Context context, @AttrRes int i10, @ColorInt int i11) {
        Integer numF = f(context, i10);
        return numF != null ? numF.intValue() : i11;
    }

    @ColorInt
    public static int c(Context context, @AttrRes int i10, String str) {
        return l(context, b.e(context, i10, str));
    }

    @ColorInt
    public static int d(@NonNull View view, @AttrRes int i10) {
        return l(view.getContext(), b.f(view, i10));
    }

    @ColorInt
    public static int e(@NonNull View view, @AttrRes int i10, @ColorInt int i11) {
        return b(view.getContext(), i10, i11);
    }

    @Nullable
    @ColorInt
    public static Integer f(@NonNull Context context, @AttrRes int i10) {
        TypedValue typedValueA = b.a(context, i10);
        if (typedValueA != null) {
            return Integer.valueOf(l(context, typedValueA));
        }
        return null;
    }

    @Nullable
    public static ColorStateList g(@NonNull Context context, @AttrRes int i10) {
        TypedValue typedValueA = b.a(context, i10);
        if (typedValueA == null) {
            return null;
        }
        int i11 = typedValueA.resourceId;
        if (i11 != 0) {
            return ContextCompat.getColorStateList(context, i11);
        }
        int i12 = typedValueA.data;
        if (i12 != 0) {
            return ColorStateList.valueOf(i12);
        }
        return null;
    }

    public static boolean h(@ColorInt int i10) {
        return i10 != 0 && ColorUtils.calculateLuminance(i10) > 0.5d;
    }

    @ColorInt
    public static int i(@ColorInt int i10, @ColorInt int i11) {
        return ColorUtils.compositeColors(i11, i10);
    }

    @ColorInt
    public static int j(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return i(i10, ColorUtils.setAlphaComponent(i11, Math.round(Color.alpha(i11) * f10)));
    }

    @ColorInt
    public static int k(@NonNull View view, @AttrRes int i10, @AttrRes int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return j(d(view, i10), d(view, i11), f10);
    }

    private static int l(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        return i10 != 0 ? ContextCompat.getColor(context, i10) : typedValue.data;
    }
}
