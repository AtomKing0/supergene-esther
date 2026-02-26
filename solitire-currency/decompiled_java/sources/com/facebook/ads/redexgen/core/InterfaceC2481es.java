package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.es, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC2481es {
    boolean ADE(C2479eq c2479eq);

    HttpURLConnection AG1(String str, Proxy proxy) throws IOException;

    InputStream AG2(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream AG3(HttpURLConnection httpURLConnection) throws IOException;

    void AGM(HttpURLConnection httpURLConnection, EnumC2477eo enumC2477eo, String str) throws IOException;

    byte[] AGj(InputStream inputStream) throws IOException;

    void AKN(OutputStream outputStream, byte[] bArr) throws IOException;
}
