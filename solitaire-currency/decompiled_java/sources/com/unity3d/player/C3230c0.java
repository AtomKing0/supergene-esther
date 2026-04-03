package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3230c0 extends S {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    U f24084h;

    public C3230c0(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
    }

    @Override // com.unity3d.player.S
    public final void a(String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str2, int i11, boolean z14, boolean z15) {
        U u10 = new U(this.f24001a, this.f24002b);
        this.f24084h = u10;
        u10.a(this, z14, z15);
        this.f24084h.setOnDismissListener(new Y(this));
        super.a(str, i10, z10, z11, z12, z13, str2, i11, z14, z15);
        this.f24002b.getViewTreeObserver().addOnGlobalLayoutListener(new Z(this));
        this.f24003c.requestFocus();
        this.f24084h.setOnCancelListener(new DialogInterfaceOnCancelListenerC3226a0(this));
    }

    @Override // com.unity3d.player.S
    public final void c() {
        this.f24084h.dismiss();
    }

    @Override // com.unity3d.player.S
    protected EditText createEditText(S s10) {
        return new C3228b0(this, this.f24001a, s10);
    }

    @Override // com.unity3d.player.S
    public final void e() {
        this.f24084h.show();
    }

    protected void reportSoftInputArea() {
        if (this.f24084h.isShowing()) {
            this.f24002b.reportSoftInputArea(this.f24084h.a());
        }
    }

    @Override // com.unity3d.player.S
    public final void a(boolean z10) {
        this.f24004d = z10;
        this.f24084h.a(z10);
    }
}
