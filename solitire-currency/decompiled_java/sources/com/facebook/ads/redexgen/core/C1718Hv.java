package com.facebook.ads.redexgen.core;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1718Hv {
    public final int A00;
    public final long A01;
    public final long A02;

    public C1718Hv(int i10, long j10, long j11) {
        this.A00 = i10;
        this.A02 = j10;
        this.A01 = j11;
    }

    public /* synthetic */ C1718Hv(int i10, long j10, long j11, C1717Hu c1717Hu) {
        this(i10, j10, j11);
    }

    public static C1718Hv A00(Parcel parcel) {
        return new C1718Hv(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final void A01(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A02);
        parcel.writeLong(this.A01);
    }
}
