package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDialogFragment f23603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f23604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23605c;

    public b(com.google.android.material.bottomsheet.b bVar, FragmentActivity fragmentActivity, String str) {
        this.f23603a = bVar;
        this.f23604b = fragmentActivity;
        this.f23605c = str;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f23603a.show(this.f23604b.getSupportFragmentManager(), this.f23605c);
            this.f23604b.getLifecycle().removeObserver(this);
        }
    }
}
