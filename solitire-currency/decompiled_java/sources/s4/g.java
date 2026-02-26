package s4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: MaterialSideContainerBackHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g extends s4.a<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f33549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f33550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f33551i;

    /* JADX INFO: compiled from: MaterialSideContainerBackHelper.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f33552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f33553b;

        a(boolean z10, int i10) {
            this.f33552a = z10;
            this.f33553b = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f33534b.setTranslationX(0.0f);
            g.this.k(0.0f, this.f33552a, this.f33553b);
        }
    }

    public g(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f33549g = resources.getDimension(e4.d.f24792k);
        this.f33550h = resources.getDimension(e4.d.f24791j);
        this.f33551i = resources.getDimension(e4.d.f24793l);
    }

    private boolean g(@GravityInt int i10, @GravityInt int i11) {
        return (GravityCompat.getAbsoluteGravity(i10, ViewCompat.getLayoutDirection(this.f33534b)) & i11) == i11;
    }

    private int i(boolean z10) {
        ViewGroup.LayoutParams layoutParams = this.f33534b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f33534b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f33534b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v10 = this.f33534b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f33537e);
        animatorSet.start();
    }

    public void h(@NonNull BackEventCompat backEventCompat, @GravityInt int i10, @Nullable Animator.AnimatorListener animatorListener, @Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z10 = backEventCompat.getSwipeEdge() == 0;
        boolean zG = g(i10, 3);
        float width = (this.f33534b.getWidth() * this.f33534b.getScaleX()) + i(zG);
        V v10 = this.f33534b;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (zG) {
            width = -width;
        }
        fArr[0] = width;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v10, (Property<V, Float>) property, fArr);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimatorOfFloat.setDuration(f4.a.c(this.f33535c, this.f33536d, backEventCompat.getProgress()));
        objectAnimatorOfFloat.addListener(new a(z10, i10));
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void j(@NonNull BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    @VisibleForTesting
    public void k(float f10, boolean z10, @GravityInt int i10) {
        float fA = a(f10);
        boolean zG = g(i10, 3);
        boolean z11 = z10 == zG;
        int width = this.f33534b.getWidth();
        int height = this.f33534b.getHeight();
        float f11 = width;
        if (f11 > 0.0f) {
            float f12 = height;
            if (f12 <= 0.0f) {
                return;
            }
            float f13 = this.f33549g / f11;
            float f14 = this.f33550h / f11;
            float f15 = this.f33551i / f12;
            V v10 = this.f33534b;
            if (zG) {
                f11 = 0.0f;
            }
            v10.setPivotX(f11);
            if (!z11) {
                f14 = -f13;
            }
            float fA2 = f4.a.a(0.0f, f14, fA);
            float f16 = fA2 + 1.0f;
            this.f33534b.setScaleX(f16);
            float fA3 = 1.0f - f4.a.a(0.0f, f15, fA);
            this.f33534b.setScaleY(fA3);
            V v11 = this.f33534b;
            if (v11 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v11;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    childAt.setPivotX(zG ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f17 = z11 ? 1.0f - fA2 : 1.0f;
                    float f18 = fA3 != 0.0f ? (f16 / fA3) * f17 : 1.0f;
                    childAt.setScaleX(f17);
                    childAt.setScaleY(f18);
                }
            }
        }
    }

    public void l(@NonNull BackEventCompat backEventCompat, @GravityInt int i10) {
        if (super.e(backEventCompat) == null) {
            return;
        }
        k(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, i10);
    }
}
