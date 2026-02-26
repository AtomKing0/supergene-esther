package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Rect f9155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f9156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f9157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f9158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x4.k f9160f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, x4.k kVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.f9155a = rect;
        this.f9156b = colorStateList2;
        this.f9157c = colorStateList;
        this.f9158d = colorStateList3;
        this.f9159e = i10;
        this.f9160f = kVar;
    }

    @NonNull
    static b a(@NonNull Context context, @StyleRes int i10) {
        Preconditions.checkArgument(i10 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, e4.k.N2);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(e4.k.O2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e4.k.Q2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e4.k.P2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e4.k.R2, 0));
        ColorStateList colorStateListA = u4.c.a(context, typedArrayObtainStyledAttributes, e4.k.S2);
        ColorStateList colorStateListA2 = u4.c.a(context, typedArrayObtainStyledAttributes, e4.k.X2);
        ColorStateList colorStateListA3 = u4.c.a(context, typedArrayObtainStyledAttributes, e4.k.V2);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(e4.k.W2, 0);
        x4.k kVarM = x4.k.b(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.T2, 0), typedArrayObtainStyledAttributes.getResourceId(e4.k.U2, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, kVarM, rect);
    }

    int b() {
        return this.f9155a.bottom;
    }

    int c() {
        return this.f9155a.top;
    }

    void d(@NonNull TextView textView) {
        e(textView, null, null);
    }

    void e(@NonNull TextView textView, @Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        x4.g gVar = new x4.g();
        x4.g gVar2 = new x4.g();
        gVar.setShapeAppearanceModel(this.f9160f);
        gVar2.setShapeAppearanceModel(this.f9160f);
        if (colorStateList == null) {
            colorStateList = this.f9157c;
        }
        gVar.Y(colorStateList);
        gVar.d0(this.f9159e, this.f9158d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f9156b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f9156b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f9155a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
