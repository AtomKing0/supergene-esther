package com.onetrust.otpublishers.headless.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f23754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f23755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f23756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f23757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final SwitchCompat f23758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f23759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f23760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f23761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final SearchView f23762j;

    public f(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull SwitchCompat switchCompat, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView3, @NonNull SearchView searchView) {
        this.f23753a = relativeLayout;
        this.f23754b = imageView;
        this.f23755c = imageView2;
        this.f23756d = recyclerView;
        this.f23757e = textView;
        this.f23758f = switchCompat;
        this.f23759g = textView2;
        this.f23760h = relativeLayout2;
        this.f23761i = textView3;
        this.f23762j = searchView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public final View getRoot() {
        return this.f23753a;
    }
}
