package com.facebook.ads.redexgen.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1554Bk implements InterfaceC2467ee {
    public final /* synthetic */ C13171r A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public C1554Bk(C13171r c13171r, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = c13171r;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2467ee
    public final void ACo(InterfaceC2465ec interfaceC2465ec) {
        C13171r.A06(interfaceC2465ec.A6v(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2467ee
    public final void ADC(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}
