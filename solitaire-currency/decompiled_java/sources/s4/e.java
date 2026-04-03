package s4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: MaterialBottomContainerBackHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e extends s4.a<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f33546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f33547h;

    /* JADX INFO: compiled from: MaterialBottomContainerBackHelper.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.f33534b.setTranslationY(0.0f);
            e.this.k(0.0f);
        }
    }

    public e(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f33546g = resources.getDimension(e4.d.f24789h);
        this.f33547h = resources.getDimension(e4.d.f24790i);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f33534b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f33534b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v10 = this.f33534b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator animatorG = g();
        animatorG.setDuration(this.f33537e);
        animatorG.start();
    }

    public void h(@NonNull BackEventCompat backEventCompat, @Nullable Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f33534b, (Property<V, Float>) View.TRANSLATION_Y, this.f33534b.getHeight() * this.f33534b.getScaleY());
        objectAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimatorOfFloat.setDuration(f4.a.c(this.f33535c, this.f33536d, backEventCompat.getProgress()));
        objectAnimatorOfFloat.addListener(new a());
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void i(@NonNull BackEventCompat backEventCompat, @Nullable Animator.AnimatorListener animatorListener) {
        Animator animatorG = g();
        animatorG.setDuration(f4.a.c(this.f33535c, this.f33536d, backEventCompat.getProgress()));
        if (animatorListener != null) {
            animatorG.addListener(animatorListener);
        }
        animatorG.start();
    }

    public void j(@NonNull BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    @VisibleForTesting
    public void k(float f10) {
        float fA = a(f10);
        float width = this.f33534b.getWidth();
        float height = this.f33534b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f11 = this.f33546g / width;
        float f12 = this.f33547h / height;
        float fA2 = 1.0f - f4.a.a(0.0f, f11, fA);
        float fA3 = 1.0f - f4.a.a(0.0f, f12, fA);
        this.f33534b.setScaleX(fA2);
        this.f33534b.setPivotY(height);
        this.f33534b.setScaleY(fA3);
        V v10 = this.f33534b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View childAt = viewGroup.getChildAt(i10);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA3 != 0.0f ? fA2 / fA3 : 1.0f);
            }
        }
    }

    public void l(@NonNull BackEventCompat backEventCompat) {
        if (super.e(backEventCompat) == null) {
            return;
        }
        k(backEventCompat.getProgress());
    }
}
