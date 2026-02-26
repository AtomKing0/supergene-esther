package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3228b0 extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f24077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C3230c0 f24078b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3228b0(C3230c0 c3230c0, Context context, S s10) {
        super(context);
        this.f24078b = c3230c0;
        this.f24077a = s10;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            if (keyEvent.getAction() == 1) {
                this.f24078b.f24084h.onBackPressed();
            }
            return true;
        }
        if (i10 == 84) {
            return true;
        }
        if (i10 == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            S s10 = this.f24077a;
            s10.a(s10.b(), false);
            return true;
        }
        if (i10 != 111 || keyEvent.getAction() != 0) {
            return super.onKeyPreIme(i10, keyEvent);
        }
        S s11 = this.f24077a;
        s11.a(s11.b(), true);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            requestFocus();
            this.f24077a.f();
        }
    }
}
