package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.e;

/* JADX INFO: loaded from: classes2.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f4840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4841b;

    public g(e.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        e eVarA = e.a(aVar, activity);
        this.f4840a = eVarA;
        addView(eVarA);
    }

    public void a(e.a aVar) {
        if (aVar == null || aVar == this.f4840a.getStyle()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f4840a.getLayoutParams();
        removeView(this.f4840a);
        e eVarA = e.a(aVar, getContext());
        this.f4840a = eVarA;
        addView(eVarA);
        this.f4840a.setLayoutParams(layoutParams);
        this.f4840a.a(this.f4841b);
    }

    public void a(int i10, int i11, int i12, int i13) {
        this.f4841b = i10;
        int i14 = i11 + i10 + i12;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i14;
            layoutParams.width = i14;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i14, i14));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i10, i10, i13);
        layoutParams2.setMargins(i12, i12, i12, 0);
        this.f4840a.setLayoutParams(layoutParams2);
        this.f4840a.a(i10);
    }
}
