package com.facebook.ads.redexgen.core;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DialogInterfaceOnClickListenerC2106Xb implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1888Om A00;

    public DialogInterfaceOnClickListenerC2106Xb(C1888Om c1888Om) {
        this.A00 = c1888Om;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        dialogInterface.cancel();
    }
}
