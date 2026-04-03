package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1682Gk {
    public final C4J A00 = new C4J(10);

    public final Metadata A00(InterfaceC2853lN interfaceC2853lN, InterfaceC1700Hc interfaceC1700Hc) throws IOException {
        int tagLength = 0;
        Metadata metadataA0S = null;
        while (true) {
            try {
                interfaceC2853lN.AG9(this.A00.A0l(), 0, 10);
                this.A00.A0f(0);
                if (this.A00.A0K() != 4801587) {
                    break;
                }
                this.A00.A0g(3);
                int iA0H = this.A00.A0H();
                int framesLength = iA0H + 10;
                if (metadataA0S == null) {
                    byte[] bArr = new byte[framesLength];
                    System.arraycopy(this.A00.A0l(), 0, bArr, 0, 10);
                    interfaceC2853lN.AG9(bArr, 10, iA0H);
                    metadataA0S = new C14848i(interfaceC1700Hc).A0S(bArr, framesLength);
                } else {
                    interfaceC2853lN.A3z(iA0H);
                }
                tagLength += framesLength;
            } catch (EOFException unused) {
            }
        }
        interfaceC2853lN.AI1();
        interfaceC2853lN.A3z(tagLength);
        return metadataA0S;
    }
}
