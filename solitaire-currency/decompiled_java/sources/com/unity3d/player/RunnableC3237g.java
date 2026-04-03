package com.unity3d.player;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3237g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set f24102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f24105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f24106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24108g;

    RunnableC3237g(Set set, String str, int i10, long j10, long j11, int i11, int i12) {
        this.f24102a = set;
        this.f24103b = str;
        this.f24104c = i10;
        this.f24105d = j10;
        this.f24106e = j11;
        this.f24107f = i11;
        this.f24108g = i12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f24102a.iterator();
        while (it.hasNext()) {
            ((IAssetPackManagerDownloadStatusCallback) it.next()).onStatusUpdate(this.f24103b, this.f24104c, this.f24105d, this.f24106e, this.f24107f, this.f24108g);
        }
    }
}
