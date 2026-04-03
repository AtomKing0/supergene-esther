package com.king.usdk.nativesharing;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class NativeSharingReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static int f17208a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        NativeSharing.SharedToNetwork(componentName != null ? componentName.getPackageName() : "Unknown", intent.getIntExtra(NativeSharing.sCallbackHandleId, f17208a));
    }
}
