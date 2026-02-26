package com.unity3d.player;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class AudioVolumeHandler implements InterfaceC3255p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3257q f23915a;

    AudioVolumeHandler(Context context) {
        C3257q c3257q = new C3257q(context);
        this.f23915a = c3257q;
        c3257q.a(this);
    }

    public final void a() {
        this.f23915a.a();
        this.f23915a = null;
    }

    @Override // com.unity3d.player.InterfaceC3255p
    public final native void onAudioVolumeChanged(int i10);
}
