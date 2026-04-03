package com.onetrust.otpublishers.headless.UI.Helper;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.onetrust.otpublishers.headless.UI.fragment.d f22158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f22159b;

    public d(FragmentActivity fragmentActivity, com.onetrust.otpublishers.headless.UI.fragment.d dVar) {
        this.f22158a = dVar;
        this.f22159b = fragmentActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22158a.show(this.f22159b.getSupportFragmentManager(), OTFragmentTags.OT_AGE_GATE_FRAGMENT_TAG);
            this.f22159b.getLifecycle().removeObserver(this);
        }
    }
}
