package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: FlowLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9452d;

    private static int a(int i10, int i11, int i12) {
        return i11 != Integer.MIN_VALUE ? i11 != 1073741824 ? i12 : i10 : Math.min(i12, i10);
    }

    public int b(@NonNull View view) {
        Object tag = view.getTag(e4.f.I);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f9451c;
    }

    protected int getItemSpacing() {
        return this.f9450b;
    }

    protected int getLineSpacing() {
        return this.f9449a;
    }

    protected int getRowCount() {
        return this.f9452d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            this.f9452d = 0;
            return;
        }
        this.f9452d = 1;
        boolean z11 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = (i12 - i10) - paddingLeft;
        int measuredWidth = paddingRight;
        int i15 = paddingTop;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(e4.f.I, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    marginEnd = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = measuredWidth + marginStart + childAt.getMeasuredWidth();
                if (!this.f9451c && measuredWidth2 > i14) {
                    i15 = this.f9449a + paddingTop;
                    this.f9452d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(e4.f.I, Integer.valueOf(this.f9452d - 1));
                int i17 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i17;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z11) {
                    childAt.layout(i14 - measuredWidth3, i15, (i14 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i17, i15, measuredWidth3, measuredHeight);
                }
                measuredWidth += marginStart + marginEnd + childAt.getMeasuredWidth() + this.f9450b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i12 = marginLayoutParams.leftMargin + 0;
                    i13 = marginLayoutParams.rightMargin + 0;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = paddingLeft2;
                if (paddingLeft2 + i12 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i18;
                } else {
                    paddingLeft = getPaddingLeft();
                    i15 = this.f9449a + paddingTop;
                }
                int measuredWidth = paddingLeft + i12 + childAt.getMeasuredWidth();
                int measuredHeight = i15 + childAt.getMeasuredHeight();
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i12 + i13 + childAt.getMeasuredWidth() + this.f9450b;
                if (i17 == getChildCount() - 1) {
                    i16 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i16 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i10) {
        this.f9450b = i10;
    }

    protected void setLineSpacing(int i10) {
        this.f9449a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f9451c = z10;
    }
}
