package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes3.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final b f9165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final b f9166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final b f9167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    final b f9168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    final b f9169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    final b f9170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    final b f9171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    final Paint f9172h;

    c(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(u4.b.d(context, e4.b.f24766w, j.class.getCanonicalName()), e4.k.D2);
        this.f9165a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.H2, 0));
        this.f9171g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.F2, 0));
        this.f9166b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.G2, 0));
        this.f9167c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.I2, 0));
        ColorStateList colorStateListA = u4.c.a(context, typedArrayObtainStyledAttributes, e4.k.J2);
        this.f9168d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.L2, 0));
        this.f9169e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.K2, 0));
        this.f9170f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e4.k.M2, 0));
        Paint paint = new Paint();
        this.f9172h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
