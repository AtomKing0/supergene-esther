package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InsetsAnimationCallback.java */
/* JADX INFO: loaded from: classes3.dex */
class c extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f8941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f8944d;

    public c(View view) {
        super(0);
        this.f8944d = new int[2];
        this.f8941a = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f8941a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f8941a.getLocationOnScreen(this.f8944d);
        this.f8942b = this.f8944d[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        Iterator<WindowInsetsAnimationCompat> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                this.f8941a.setTranslationY(f4.a.c(this.f8943c, 0, r0.getInterpolatedFraction()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    @NonNull
    public WindowInsetsAnimationCompat.BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f8941a.getLocationOnScreen(this.f8944d);
        int i10 = this.f8942b - this.f8944d[1];
        this.f8943c = i10;
        this.f8941a.setTranslationY(i10);
        return boundsCompat;
    }
}
