package com.facebook.ads.redexgen.core;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class SP {
    public static String[] A00 = {"WfUJfZecOVcHzzrBpx92ELEjWhu2m", "ABQQ5taiOepRv8Mi5iWio7B3aVpn", "lqinWbZDhv0Ny2jUIa5P6Phm3DGMmF2T", "dPu2X3zgdKacWkfyqxYrIyrhes", "b2oe8Nr0EFLLItrmCHMxvIgMHIYOeqfq", CmcdData.Factory.STREAMING_FORMAT_HLS, "yKBaB64vFuTn7zYoCnuYBPVEHVJ9GNEq", ""};
    public static final AtomicReference<C2361cu> A01 = new AtomicReference<>();

    public static C2361cu A00() {
        AtomicReference<C2361cu> atomicReference = A01;
        if (A00[2].charAt(13) != '2') {
            throw new RuntimeException();
        }
        A00[3] = "t";
        return atomicReference.get();
    }

    public static void A01(C2361cu c2361cu) {
        if (c2361cu == null) {
            return;
        }
        AB.A00(A01, null, c2361cu);
    }
}
