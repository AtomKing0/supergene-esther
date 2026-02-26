package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzatc implements Runnable {
    private zzatc() {
        throw null;
    }

    /* synthetic */ zzatc(zzatb zzatbVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzatd.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzatd.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzatd.zzb;
        } catch (Throwable th) {
            zzatd.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
