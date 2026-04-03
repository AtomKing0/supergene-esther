package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3266u0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24190c;

    RunnableC3266u0(UnityPlayer unityPlayer, int i10, int i11) {
        this.f24190c = unityPlayer;
        this.f24188a = i10;
        this.f24189b = i11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        S s10 = this.f24190c.mSoftInput;
        if (s10 != null) {
            int i11 = this.f24188a;
            int i12 = this.f24189b;
            EditText editText = s10.f24003c;
            if (editText == null || editText.getText().length() < (i10 = i12 + i11)) {
                return;
            }
            s10.f24003c.setSelection(i11, i10);
        }
    }
}
