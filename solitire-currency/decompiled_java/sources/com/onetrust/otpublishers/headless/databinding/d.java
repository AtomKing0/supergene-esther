package com.onetrust.otpublishers.headless.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f23739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwitchCompat f23740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f23741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f23742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f23743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23744g;

    public d(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull SwitchCompat switchCompat, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2) {
        this.f23738a = relativeLayout;
        this.f23739b = imageView;
        this.f23740c = switchCompat;
        this.f23741d = textView;
        this.f23742e = view;
        this.f23743f = textView2;
        this.f23744g = relativeLayout2;
    }

    @NonNull
    public static d b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View viewFindChildViewById;
        View viewInflate = layoutInflater.inflate(p6.e.f32879m, viewGroup, false);
        int i10 = p6.d.f32668d2;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, i10);
        if (imageView != null) {
            i10 = p6.d.f32680e5;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewInflate, i10);
            if (switchCompat != null) {
                i10 = p6.d.W6;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i10);
                if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i10 = p6.d.f32727j7))) != null) {
                    i10 = p6.d.f32808s7;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i10);
                    if (textView2 != null) {
                        i10 = p6.d.f32817t7;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, i10);
                        if (relativeLayout != null) {
                            return new d((RelativeLayout) viewInflate, imageView, switchCompat, textView, viewFindChildViewById, textView2, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
    }

    @NonNull
    public final RelativeLayout a() {
        return this.f23738a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public final View getRoot() {
        return this.f23738a;
    }
}
