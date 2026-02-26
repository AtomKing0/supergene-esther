package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class DialogInterfaceOnCancelListenerC3226a0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3230c0 f24050a;

    DialogInterfaceOnCancelListenerC3226a0(C3230c0 c3230c0) {
        this.f24050a = c3230c0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        F f10 = this.f24050a.f24006f;
        if (f10 != null) {
            ((C3248l0) f10).a();
        }
    }
}
