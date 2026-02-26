package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import e4.f;
import s4.h;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f9642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f9643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f9644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9645d;

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9644c = h.g(context, e4.b.I, f4.a.f25669b);
    }

    private static void d(@NonNull View view, int i10, int i11) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i10, ViewCompat.getPaddingEnd(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean e(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f9642a.getPaddingTop() == i11 && this.f9642a.getPaddingBottom() == i12) {
            return z10;
        }
        d(this.f9642a, i11, i12);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i10, int i11) {
        this.f9642a.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.f9642a.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f9644c).setStartDelay(j11).start();
        if (this.f9643b.getVisibility() == 0) {
            this.f9643b.setAlpha(0.0f);
            this.f9643b.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f9644c).setStartDelay(j11).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i10, int i11) {
        this.f9642a.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.f9642a.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f9644c).setStartDelay(j11).start();
        if (this.f9643b.getVisibility() == 0) {
            this.f9643b.setAlpha(1.0f);
            this.f9643b.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f9644c).setStartDelay(j11).start();
        }
    }

    void c(float f10) {
        if (f10 != 1.0f) {
            this.f9643b.setTextColor(n4.a.j(n4.a.d(this, e4.b.f24756m), this.f9643b.getCurrentTextColor(), f10));
        }
    }

    public Button getActionView() {
        return this.f9643b;
    }

    public TextView getMessageView() {
        return this.f9642a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f9642a = (TextView) findViewById(f.L);
        this.f9643b = (Button) findViewById(f.K);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto Lb
            return
        Lb:
            android.content.res.Resources r0 = r7.getResources()
            int r2 = e4.d.f24786f
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            int r3 = e4.d.f24784e
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f9642a
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L30
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L30
            r3 = r1
            goto L31
        L30:
            r3 = r4
        L31:
            if (r3 == 0) goto L4a
            int r5 = r7.f9645d
            if (r5 <= 0) goto L4a
            android.widget.Button r5 = r7.f9643b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f9645d
            if (r5 <= r6) goto L4a
            int r2 = r0 - r2
            boolean r0 = r7.e(r1, r0, r2)
            if (r0 == 0) goto L55
            goto L56
        L4a:
            if (r3 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r2
        L4e:
            boolean r0 = r7.e(r4, r0, r0)
            if (r0 == 0) goto L55
            goto L56
        L55:
            r1 = r4
        L56:
            if (r1 == 0) goto L5b
            super.onMeasure(r8, r9)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f9645d = i10;
    }
}
