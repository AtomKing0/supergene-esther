package com.unity3d.services.store.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.store.gpbl.StoreBilling;
import com.unity3d.services.store.gpbl.listeners.StoreEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StoreLifecycleListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StoreLifecycleListener implements Application.ActivityLifecycleCallbacks {

    @NotNull
    private final ArrayList<String> _purchaseTypes;

    @NotNull
    private final StoreBilling _storeBilling;

    @NotNull
    private final StoreEventListener _storeEventListener;

    public StoreLifecycleListener(@NotNull ArrayList<String> _purchaseTypes, @NotNull StoreBilling _storeBilling, @NotNull StoreEventListener _storeEventListener) {
        t.i(_purchaseTypes, "_purchaseTypes");
        t.i(_storeBilling, "_storeBilling");
        t.i(_storeEventListener, "_storeEventListener");
        this._purchaseTypes = _purchaseTypes;
        this._storeBilling = _storeBilling;
        this._storeEventListener = _storeEventListener;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        t.i(activity, "activity");
        try {
            Iterator<String> it = this._purchaseTypes.iterator();
            while (it.hasNext()) {
                this._storeBilling.getPurchases(it.next(), this._storeEventListener);
            }
        } catch (ClassNotFoundException e10) {
            DeviceLog.warning("Couldn't fetch purchases onActivityResumed. " + e10.getMessage());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        t.i(activity, "activity");
        t.i(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        t.i(activity, "activity");
    }
}
