package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC14647k extends AbstractC2984nW<C14637j, AbstractC14627i, C2802kM> implements InterfaceC2803kN {
    public static byte[] A01;
    public static String[] A02 = {"gN8", "v0q6HziqC5r28rLi1ZsQmD2OK0fgspik", "XftI4eRfVNg33Op0jQPz8O6PbCkMHbWE", "SdzNGuU6dc81VqISrLBD", "AmzsDcSyCxTNGO", "BjhKb3Az99p878kvj1gxEmyEzdFIjRD", "VkdZ1nUYKY17rCLbk1Npuh3A0WHSXOLE", "WDjquUi0atGhsKhHWhKEDeyGOzHRt12i"};
    public final String A00;

    public static String A0L(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            byte b10 = (byte) ((bArrCopyOfRange[i13] - i12) - 100);
            if (A02[0].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "7OO3CpMfw2stGNBOXFHDwltwdlKTQaUN";
            strArr[7] = "XdJDd6VP529P2X7c3MAKusUlyNrjc2WF";
            bArrCopyOfRange[i13] = b10;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        if (A02[0].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[5] = "V56IsTeJwH5mFHCmn3IS5snx7jCRlGG";
        strArr[4] = "owU73l6HwKvTqc";
        A01 = new byte[]{28, 53, 44, 63, 55, 44, 42, 59, 44, 43, -25, 43, 44, 42, 54, 43, 44, -25, 44, 57, 57, 54, 57};
    }

    public abstract J7 A0g(byte[] bArr, int i10, boolean z10) throws C2802kM;

    static {
        A0M();
    }

    public AbstractC14647k(String str) {
        super(new C14637j[2], new AbstractC14627i[2]);
        this.A00 = str;
        A0d(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.0w] */
    @Override // com.facebook.ads.redexgen.core.AbstractC2984nW
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final C12960w A0c() {
        return new AbstractC14627i(this) { // from class: com.facebook.ads.redexgen.X.0w
            public final AbstractC14647k A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC14627i, com.facebook.ads.redexgen.core.AbstractC2985nX
            public final void A0B() {
                this.A00.A0h(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2984nW
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public final C2802kM A0Y(C14637j c14637j, AbstractC14627i abstractC14627i, boolean z10) {
        try {
            ByteBuffer inputData = (ByteBuffer) C3M.A01(c14637j.A02);
            abstractC14627i.A0C(c14637j.A01, A0g(inputData.array(), inputData.limit(), z10), c14637j.A00);
            abstractC14627i.A01(Integer.MIN_VALUE);
            return null;
        } catch (C2802kM e10) {
            return e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2984nW
    /* JADX INFO: renamed from: A0J, reason: merged with bridge method [inline-methods] */
    public final C2802kM A0Z(Throwable th) {
        return new C2802kM(A0L(0, 23, 99), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2984nW
    /* JADX INFO: renamed from: A0K, reason: merged with bridge method [inline-methods] */
    public final C14637j A0a() {
        return new C14637j();
    }

    public final void A0h(AbstractC14627i abstractC14627i) {
        super.A0f(abstractC14627i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2803kN
    public final void AIx(long j10) {
    }
}
