package com.onetrust.otpublishers.headless.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f23736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final h f23737b;

    public c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull h hVar) {
        this.f23736a = coordinatorLayout;
        this.f23737b = hVar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public final View getRoot() {
        return this.f23736a;
    }
}
