package com.onetrust.otpublishers.headless.UI.Helper;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.UI.fragment.l1;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f22160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f22161b;

    public f(FragmentActivity fragmentActivity, l1 l1Var) {
        this.f22160a = l1Var;
        this.f22161b = fragmentActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22160a.show(this.f22161b.getSupportFragmentManager(), OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG);
            this.f22161b.getLifecycle().removeObserver(this);
        }
    }
}
