package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
final class Y implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3230c0 f24046a;

    Y(C3230c0 c3230c0) {
        this.f24046a = c3230c0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f24046a.invokeOnClose();
    }
}
