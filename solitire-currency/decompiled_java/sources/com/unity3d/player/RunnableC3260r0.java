package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3260r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f24179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24180b;

    RunnableC3260r0(UnityPlayer unityPlayer, String str) {
        this.f24180b = unityPlayer;
        this.f24179a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        S s10 = this.f24180b.mSoftInput;
        if (s10 == null || (str = this.f24179a) == null || (editText = s10.f24003c) == null) {
            return;
        }
        editText.setText(str);
        s10.f24003c.setSelection(str.length());
    }
}
