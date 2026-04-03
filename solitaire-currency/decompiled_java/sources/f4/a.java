package f4;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f25668a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f25669b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f25670c = new FastOutLinearInInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f25671d = new LinearOutSlowInInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f25672e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static float b(float f10, float f11, float f12, float f13, float f14) {
        return f14 <= f12 ? f10 : f14 >= f13 ? f11 : a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    public static int c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }
}
