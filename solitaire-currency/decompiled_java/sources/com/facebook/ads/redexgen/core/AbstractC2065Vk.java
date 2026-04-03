package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2065Vk {
    public static void A00(AbstractRunnableC2061Vg abstractRunnableC2061Vg) {
        new Handler(Looper.getMainLooper()).post(abstractRunnableC2061Vg);
    }
}
