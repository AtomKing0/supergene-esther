package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class O implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f23973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f23974b;

    public O(long j10, long j11) {
        this.f23973a = j10;
        this.f23974b = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f23973a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.f23974b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}
