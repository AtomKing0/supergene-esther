package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class DialogInterfaceOnClickListenerC3270w0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24222a;

    DialogInterfaceOnClickListenerC3270w0(UnityPlayer unityPlayer) {
        this.f24222a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f24222a.finish();
    }
}
