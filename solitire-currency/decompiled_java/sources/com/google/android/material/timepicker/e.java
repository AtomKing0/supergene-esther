package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import e4.h;
import e4.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x4.i;

/* JADX INFO: compiled from: RadialViewGroup.java */
/* JADX INFO: loaded from: classes3.dex */
class e extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f9908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private x4.g f9910c;

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(List<View> list, ConstraintSet constraintSet, int i10) {
        Iterator<View> it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            constraintSet.constrainCircle(it.next().getId(), e4.f.f24822c, i10, size);
            size += 360.0f / list.size();
        }
    }

    private Drawable c() {
        x4.g gVar = new x4.g();
        this.f9910c = gVar;
        gVar.W(new i(0.5f));
        this.f9910c.Y(ColorStateList.valueOf(-1));
        return this.f9910c;
    }

    private static boolean g(View view) {
        return "skip".equals(view.getTag());
    }

    private void i() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f9908a);
            handler.post(this.f9908a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        i();
    }

    @Dimension
    int d(int i10) {
        return i10 == 2 ? Math.round(this.f9909b * 0.66f) : this.f9909b;
    }

    @Dimension
    public int e() {
        return this.f9909b;
    }

    public void f(@Dimension int i10) {
        this.f9909b = i10;
        h();
    }

    protected void h() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != e4.f.f24822c && !g(childAt)) {
                int i11 = (Integer) childAt.getTag(e4.f.f24832m);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!map.containsKey(i11)) {
                    map.put(i11, new ArrayList());
                }
                ((List) map.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            b((List) entry.getValue(), constraintSet, d(((Integer) entry.getKey()).intValue()));
        }
        constraintSet.applyTo(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        i();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i10) {
        this.f9910c.Y(ColorStateList.valueOf(i10));
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(h.f24857i, this);
        ViewCompat.setBackground(this, c());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f24923a4, i10, 0);
        this.f9909b = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.f24931b4, 0);
        this.f9908a = new Runnable() { // from class: com.google.android.material.timepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f9907a.h();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }
}
