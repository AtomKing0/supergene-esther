package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: loaded from: classes4.dex */
final class W extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f24036a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    W(Context context, S s10) {
        super(context);
        this.f24036a = s10;
    }

    @Override // android.widget.TextView
    public final void onEditorAction(int i10) {
        if (i10 == 6) {
            S s10 = this.f24036a;
            s10.a(s10.b(), false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            if (keyEvent.getAction() == 1) {
                S s10 = this.f24036a;
                s10.a(s10.b(), false);
            }
            return true;
        }
        if (i10 == 84) {
            return true;
        }
        if (i10 != 66 || keyEvent.getAction() != 0 || (getInputType() & 131072) != 0) {
            return super.onKeyPreIme(i10, keyEvent);
        }
        S s11 = this.f24036a;
        s11.a(s11.b(), false);
        return true;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i10, int i11) {
        super.onSelectionChanged(i10, i11);
        this.f24036a.f24002b.reportSoftInputSelection(i10, i11 - i10);
    }
}
