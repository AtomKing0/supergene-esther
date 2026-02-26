package com.onetrust.otpublishers.headless.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f23733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final f f23734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f23735c;

    public b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull f fVar, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.f23733a = coordinatorLayout;
        this.f23734b = fVar;
        this.f23735c = coordinatorLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public final View getRoot() {
        return this.f23733a;
    }
}
