package s4;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.compose.animation.core.AnimationConstants;
import androidx.core.view.animation.PathInterpolatorCompat;

/* JADX INFO: compiled from: MaterialBackAnimationHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class a<V extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final TimeInterpolator f33533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final V f33534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f33535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f33536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f33537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private BackEventCompat f33538f;

    public a(@NonNull V v10) {
        this.f33534b = v10;
        Context context = v10.getContext();
        this.f33533a = h.g(context, e4.b.K, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.f33535c = h.f(context, e4.b.B, AnimationConstants.DefaultDurationMillis);
        this.f33536d = h.f(context, e4.b.E, 150);
        this.f33537e = h.f(context, e4.b.D, 100);
    }

    public float a(float f10) {
        return this.f33533a.getInterpolation(f10);
    }

    @Nullable
    protected BackEventCompat b() {
        if (this.f33538f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat backEventCompat = this.f33538f;
        this.f33538f = null;
        return backEventCompat;
    }

    @Nullable
    public BackEventCompat c() {
        BackEventCompat backEventCompat = this.f33538f;
        this.f33538f = null;
        return backEventCompat;
    }

    protected void d(@NonNull BackEventCompat backEventCompat) {
        this.f33538f = backEventCompat;
    }

    @Nullable
    protected BackEventCompat e(@NonNull BackEventCompat backEventCompat) {
        if (this.f33538f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = this.f33538f;
        this.f33538f = backEventCompat;
        return backEventCompat2;
    }
}
