package com.facebook.ads.redexgen.core;

import java.io.ByteArrayInputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2739jK implements L9 {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C2739jK(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.facebook.ads.redexgen.core.L9
    public final void AFz(int i10) throws C2738jJ {
        this.A00 = new ByteArrayInputStream(this.A01);
        this.A00.skip(i10);
    }

    @Override // com.facebook.ads.redexgen.core.L9
    public final void close() throws C2738jJ {
    }

    @Override // com.facebook.ads.redexgen.core.L9
    public final int length() throws C2738jJ {
        return this.A01.length;
    }

    @Override // com.facebook.ads.redexgen.core.L9
    public final int read(byte[] bArr) throws C2738jJ {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
