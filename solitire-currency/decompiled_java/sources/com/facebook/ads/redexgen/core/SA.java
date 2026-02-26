package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SA implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ SF A01;

    public SA(SF sf, SB sb) {
        this.A01 = sf;
        new Handler(Looper.getMainLooper()).post(new C2412dk(this, sf, sb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(SB sb) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C2446eJ c2446eJA06 = C2446eJ.A06(this.A01.A04.A02());
        Uri uriA00 = WQ.A00(sb.A08);
        long jA0S = sb.A00;
        if (jA0S == -1) {
            jA0S = U7.A0S(this.A01.A04);
        }
        c2446eJA06.A0I(uriA00, new C2411dj(this, sb, jA0S, jCurrentTimeMillis), jA0S);
    }
}
