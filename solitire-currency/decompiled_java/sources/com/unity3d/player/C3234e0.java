package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3234e0 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC3232d0 f24095a;

    public C3234e0(Handler handler, InterfaceC3232d0 interfaceC3232d0) {
        super(handler);
        this.f24095a = interfaceC3232d0;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        InterfaceC3232d0 interfaceC3232d0 = this.f24095a;
        if (interfaceC3232d0 != null) {
            ((OrientationLockListener) interfaceC3232d0).b();
        }
    }
}
