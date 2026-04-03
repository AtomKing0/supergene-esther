package com.onetrust.otpublishers.headless.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SwitchCompat f23764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f23765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final SwitchCompat f23766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f23767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f23768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f23769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23770h;

    public g(@NonNull RelativeLayout relativeLayout, @NonNull SwitchCompat switchCompat, @NonNull ImageView imageView, @NonNull SwitchCompat switchCompat2, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2) {
        this.f23763a = relativeLayout;
        this.f23764b = switchCompat;
        this.f23765c = imageView;
        this.f23766d = switchCompat2;
        this.f23767e = textView;
        this.f23768f = view;
        this.f23769g = textView2;
        this.f23770h = relativeLayout2;
    }

    @NonNull
    public final RelativeLayout a() {
        return this.f23763a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public final View getRoot() {
        return this.f23763a;
    }
}
