package com.facebook.ads.redexgen.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2105Xa {
    public static final int A00 = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService A01 = Executors.newFixedThreadPool(A00);
    public static volatile boolean A02 = true;
}
