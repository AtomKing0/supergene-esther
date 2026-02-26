package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.np, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3003np implements InterfaceC13713v {
    public static final List<C3004nq> A01 = new ArrayList(50);
    public final Handler A00;

    public C3003np(Handler handler) {
        this.A00 = handler;
    }

    public static C3004nq A00() {
        C3004nq c3004nq;
        synchronized (A01) {
            c3004nq = A01.isEmpty() ? new C3004nq() : A01.remove(A01.size() - 1);
        }
        return c3004nq;
    }

    public static void A01(C3004nq c3004nq) {
        synchronized (A01) {
            if (A01.size() < 50) {
                A01.add(c3004nq);
            }
        }
    }

    public final boolean A03(Runnable runnable) {
        return this.A00.post(runnable);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final Looper A8J() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final boolean A9f(int i10) {
        return this.A00.hasMessages(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final C3004nq AC7(int i10) {
        return A00().A01(this.A00.obtainMessage(i10), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final C3004nq AC8(int i10, int i11, int i12) {
        return A00().A01(this.A00.obtainMessage(i10, i11, i12), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final C3004nq AC9(int i10, int i11, int i12, Object obj) {
        return A00().A01(this.A00.obtainMessage(i10, i11, i12, obj), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final C3004nq ACA(int i10, Object obj) {
        return A00().A01(this.A00.obtainMessage(i10, obj), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final void AHj(int i10) {
        this.A00.removeMessages(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final boolean AIQ(int i10) {
        return this.A00.sendEmptyMessage(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final boolean AIR(int i10, long j10) {
        return this.A00.sendEmptyMessageAtTime(i10, j10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13713v
    public final boolean AIT(InterfaceC13703u interfaceC13703u) {
        return ((C3004nq) interfaceC13703u).A03(this.A00);
    }
}
