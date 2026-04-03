package com.facebook.ads.redexgen.core;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1721Hy {
    public final int A00;
    public final long A01;

    public C1721Hy(int i10, long j10) {
        this.A00 = i10;
        this.A01 = j10;
    }

    public /* synthetic */ C1721Hy(int i10, long j10, C1720Hx c1720Hx) {
        this(i10, j10);
    }

    public static C1721Hy A00(Parcel parcel) {
        return new C1721Hy(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
