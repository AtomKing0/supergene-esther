package com.google.android.material.appbar;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e4.g;

/* JADX INFO: compiled from: ViewUtilsLollipop.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8776a = {R.attr.stateListAnimator};

    static void a(@NonNull View view, float f10) {
        int integer = view.getResources().getInteger(g.f24846a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j10 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, e4.b.V, -e4.b.W}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j10));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f10).setDuration(j10));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
