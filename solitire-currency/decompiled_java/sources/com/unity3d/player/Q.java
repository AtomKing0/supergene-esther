package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes4.dex */
final class Q implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f23988a;

    Q(S s10) {
        this.f23988a = s10;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 == 6) {
            S s10 = this.f23988a;
            s10.a(s10.b(), false);
        }
        return false;
    }
}
