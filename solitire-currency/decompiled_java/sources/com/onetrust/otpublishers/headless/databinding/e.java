package com.onetrust.otpublishers.headless.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f23746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f23748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f23749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final SwitchCompat f23750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f23751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f23752h;

    public e(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SwitchCompat switchCompat, @NonNull View view, @NonNull TextView textView4) {
        this.f23745a = relativeLayout;
        this.f23746b = textView;
        this.f23747c = relativeLayout2;
        this.f23748d = textView2;
        this.f23749e = textView3;
        this.f23750f = switchCompat;
        this.f23751g = view;
        this.f23752h = textView4;
    }

    @NonNull
    public final RelativeLayout a() {
        return this.f23745a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public final View getRoot() {
        return this.f23745a;
    }
}
