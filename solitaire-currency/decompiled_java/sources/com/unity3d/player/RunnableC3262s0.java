package com.unity3d.player;

import android.text.InputFilter;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3262s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f24182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24183b;

    RunnableC3262s0(UnityPlayer unityPlayer, int i10) {
        this.f24183b = unityPlayer;
        this.f24182a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S s10 = this.f24183b.mSoftInput;
        if (s10 != null) {
            int i10 = this.f24182a;
            EditText editText = s10.f24003c;
            if (editText != null) {
                if (i10 > 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i10)});
                } else {
                    editText.setFilters(new InputFilter[0]);
                }
            }
        }
    }
}
