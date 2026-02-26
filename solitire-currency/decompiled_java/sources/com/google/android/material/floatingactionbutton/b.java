package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
class b extends a {

    @Nullable
    private StateListAnimator N;

    b(FloatingActionButton floatingActionButton, w4.b bVar) {
        super(floatingActionButton, bVar);
    }

    @NonNull
    private StateListAnimator g0(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(a.H, h0(f10, f12));
        stateListAnimator.addState(a.I, h0(f10, f11));
        stateListAnimator.addState(a.J, h0(f10, f11));
        stateListAnimator.addState(a.K, h0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f9339v, "elevation", f10).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.f9339v;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f9339v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(a.C);
        stateListAnimator.addState(a.L, animatorSet);
        stateListAnimator.addState(a.M, h0(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    private Animator h0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f9339v, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f9339v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(a.C);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void B() {
        d0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void E(float f10, float f11, float f12) {
        if (this.f9339v.getStateListAnimator() == this.N) {
            StateListAnimator stateListAnimatorG0 = g0(f10, f11, f12);
            this.N = stateListAnimatorG0;
            this.f9339v.setStateListAnimator(stateListAnimatorG0);
        }
        if (X()) {
            d0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean J() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void T(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f9320c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(v4.b.a(colorStateList));
        } else {
            super.T(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean X() {
        return this.f9340w.a() || !Z();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float m() {
        return this.f9339v.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void r(@NonNull Rect rect) {
        if (this.f9340w.a()) {
            super.r(rect);
        } else if (Z()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f9327j - this.f9339v.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void b0() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void z() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void D(int[] iArr) {
    }
}
