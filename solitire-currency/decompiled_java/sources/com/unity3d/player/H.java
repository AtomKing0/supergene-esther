package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f23934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PermissionFragment f23935b;

    H(PermissionFragment permissionFragment, String[] strArr) {
        this.f23935b = permissionFragment;
        this.f23934a = strArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23935b.reportAllDenied(this.f23934a);
    }
}
