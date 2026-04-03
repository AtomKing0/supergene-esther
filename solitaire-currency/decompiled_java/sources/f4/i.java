package f4;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f25684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private TimeInterpolator f25685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25687e;

    public i(long j10, long j11) {
        this.f25685c = null;
        this.f25686d = 0;
        this.f25687e = 1;
        this.f25683a = j10;
        this.f25684b = j11;
    }

    @NonNull
    static i b(@NonNull ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f25686d = valueAnimator.getRepeatCount();
        iVar.f25687e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f25669b : interpolator instanceof AccelerateInterpolator ? a.f25670c : interpolator instanceof DecelerateInterpolator ? a.f25671d : interpolator;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f25683a;
    }

    public long d() {
        return this.f25684b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f25685c;
        return timeInterpolator != null ? timeInterpolator : a.f25669b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f25686d;
    }

    public int h() {
        return this.f25687e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j10, long j11, @NonNull TimeInterpolator timeInterpolator) {
        this.f25686d = 0;
        this.f25687e = 1;
        this.f25683a = j10;
        this.f25684b = j11;
        this.f25685c = timeInterpolator;
    }
}
