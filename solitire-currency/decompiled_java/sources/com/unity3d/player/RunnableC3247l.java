package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3247l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerStatusQueryCallback f24137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f24138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f24139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f24140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f24141e;

    RunnableC3247l(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j10, String[] strArr, int[] iArr, int[] iArr2) {
        this.f24137a = iAssetPackManagerStatusQueryCallback;
        this.f24138b = j10;
        this.f24139c = strArr;
        this.f24140d = iArr;
        this.f24141e = iArr2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24137a.onStatusResult(this.f24138b, this.f24139c, this.f24140d, this.f24141e);
    }
}
