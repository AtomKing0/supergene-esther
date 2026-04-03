package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f9459a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private b f9460b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    ValueAnimator f9461c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f9462d = new a();

    /* JADX INFO: compiled from: StateListAnimator.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k kVar = k.this;
            if (kVar.f9461c == animator) {
                kVar.f9461c = null;
            }
        }
    }

    /* JADX INFO: compiled from: StateListAnimator.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f9464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f9465b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f9464a = iArr;
            this.f9465b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f9462d);
        this.f9459a.add(bVar);
    }
}
