package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f9466n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f9467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f9468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9469c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9471e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9478l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9470d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f9472f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9473g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f9474h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f9475i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9476j = f9466n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9477k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private TextUtils.TruncateAt f9479m = null;

    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    static class a extends Exception {
    }

    private l(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f9467a = charSequence;
        this.f9468b = textPaint;
        this.f9469c = i10;
        this.f9471e = charSequence.length();
    }

    @NonNull
    public static l b(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i10) {
        return new l(charSequence, textPaint, i10);
    }

    public StaticLayout a() throws a {
        if (this.f9467a == null) {
            this.f9467a = "";
        }
        int iMax = Math.max(0, this.f9469c);
        CharSequence charSequenceEllipsize = this.f9467a;
        if (this.f9473g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f9468b, iMax, this.f9479m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f9471e);
        this.f9471e = iMin;
        if (this.f9478l && this.f9473g == 1) {
            this.f9472f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f9470d, iMin, this.f9468b, iMax);
        builderObtain.setAlignment(this.f9472f);
        builderObtain.setIncludePad(this.f9477k);
        builderObtain.setTextDirection(this.f9478l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f9479m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f9473g);
        float f10 = this.f9474h;
        if (f10 != 0.0f || this.f9475i != 1.0f) {
            builderObtain.setLineSpacing(f10, this.f9475i);
        }
        if (this.f9473g > 1) {
            builderObtain.setHyphenationFrequency(this.f9476j);
        }
        return builderObtain.build();
    }

    @NonNull
    public l c(@NonNull Layout.Alignment alignment) {
        this.f9472f = alignment;
        return this;
    }

    @NonNull
    public l d(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f9479m = truncateAt;
        return this;
    }

    @NonNull
    public l e(int i10) {
        this.f9476j = i10;
        return this;
    }

    @NonNull
    public l f(boolean z10) {
        this.f9477k = z10;
        return this;
    }

    public l g(boolean z10) {
        this.f9478l = z10;
        return this;
    }

    @NonNull
    public l h(float f10, float f11) {
        this.f9474h = f10;
        this.f9475i = f11;
        return this;
    }

    @NonNull
    public l i(@IntRange(from = 0) int i10) {
        this.f9473g = i10;
        return this;
    }

    @NonNull
    public l j(@Nullable m mVar) {
        return this;
    }
}
