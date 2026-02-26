package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3253o extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC3255p f24164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f24165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24167d;

    public C3253o(Handler handler, AudioManager audioManager, InterfaceC3255p interfaceC3255p) {
        super(handler);
        this.f24165b = audioManager;
        this.f24166c = 3;
        this.f24164a = interfaceC3255p;
        this.f24167d = audioManager.getStreamVolume(3);
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.f24165b;
        if (audioManager == null || this.f24164a == null || (streamVolume = audioManager.getStreamVolume(this.f24166c)) == this.f24167d) {
            return;
        }
        this.f24167d = streamVolume;
        this.f24164a.onAudioVolumeChanged(streamVolume);
    }
}
