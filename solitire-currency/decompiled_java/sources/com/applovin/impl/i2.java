package com.applovin.impl;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f5367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f5368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f5369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f5370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j2 f5371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5372f;

    public void a(int i10) {
        this.f5372f = i10;
    }

    public j2 b() {
        return this.f5371e;
    }

    public int a() {
        return this.f5372f;
    }

    public void a(j2 j2Var) {
        this.f5371e = j2Var;
        this.f5367a.setText(j2Var.k());
        this.f5367a.setTextColor(j2Var.l());
        if (this.f5368b != null) {
            if (!TextUtils.isEmpty(j2Var.f())) {
                this.f5368b.setTypeface(null, 0);
                this.f5368b.setVisibility(0);
                this.f5368b.setText(j2Var.f());
                this.f5368b.setTextColor(j2Var.g());
                if (j2Var.p()) {
                    this.f5368b.setTypeface(null, 1);
                }
            } else {
                this.f5368b.setVisibility(8);
            }
        }
        if (this.f5369c != null) {
            if (j2Var.h() > 0) {
                this.f5369c.setImageResource(j2Var.h());
                this.f5369c.setColorFilter(j2Var.i());
                this.f5369c.setVisibility(0);
            } else {
                this.f5369c.setVisibility(8);
            }
        }
        if (this.f5370d != null) {
            if (j2Var.d() > 0) {
                this.f5370d.setImageResource(j2Var.d());
                this.f5370d.setColorFilter(j2Var.e());
                this.f5370d.setVisibility(0);
                return;
            }
            this.f5370d.setVisibility(8);
        }
    }
}
