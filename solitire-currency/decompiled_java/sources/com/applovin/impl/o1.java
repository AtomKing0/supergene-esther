package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.ad.b;

/* JADX INFO: loaded from: classes2.dex */
abstract class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.applovin.impl.sdk.j f6451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Activity f6452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.applovin.impl.sdk.ad.b f6453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ViewGroup f6454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final FrameLayout.LayoutParams f6455e;

    o1(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.f6455e = layoutParams;
        this.f6453c = bVar;
        this.f6451a = jVar;
        this.f6452b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f6454d = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(layoutParams);
    }

    public void a(View view) {
        this.f6454d.removeView(view);
    }

    public void a(com.applovin.impl.adview.g gVar) {
        if (gVar == null || gVar.getParent() != null) {
            return;
        }
        a(this.f6453c.l(), (this.f6453c.x0() ? 3 : 5) | 48, gVar);
    }

    void a(b.d dVar, int i10, com.applovin.impl.adview.g gVar) {
        gVar.a(dVar.f6956a, dVar.f6960e, dVar.f6959d, i10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gVar.getLayoutParams());
        int i11 = dVar.f6958c;
        layoutParams.setMargins(i11, dVar.f6957b, i11, 0);
        layoutParams.gravity = i10;
        this.f6454d.addView(gVar, layoutParams);
    }
}
