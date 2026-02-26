package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.df, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2407df extends InputStream {
    public int A00;
    public long A01;
    public InterfaceC2999nl A02;
    public final Uri A03;
    public final InterfaceC13984w A04;
    public final C2361cu A05;
    public final String A06;

    public C2407df(C2361cu c2361cu, Uri uri, InterfaceC13984w interfaceC13984w) throws IOException {
        this.A05 = c2361cu;
        this.A04 = interfaceC13984w;
        this.A03 = uri;
        this.A06 = C2446eJ.A09(this.A05, this.A03);
        A00(0);
    }

    private void A00(int i10) throws IOException {
        if (this.A02 != null) {
            this.A02.close();
        }
        this.A02 = this.A04.A5A();
        this.A01 = (int) this.A02.AFy(new AnonymousClass56(this.A03, i10, -1L, this.A06));
    }

    @Override // java.io.InputStream
    public final int available() {
        return ((int) this.A01) - this.A00;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b10 = new byte[1];
        return read(b10);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.A02.read(bArr, i10, i11);
        int read = this.A00;
        this.A00 = read + i12;
        return i12;
    }

    @Override // java.io.InputStream
    public final long skip(long j10) throws IOException {
        long j11 = this.A01 - ((long) this.A00);
        if (j11 <= 0) {
            return 0L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        this.A00 = (int) (((long) this.A00) + j10);
        A00(this.A00);
        return j10;
    }
}
