package com.facebook.ads.redexgen.core;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8 implements InterfaceC2466ed {
    public static byte[] A07;
    public static String[] A08 = {"QhNFYJC9gEUd0JRpeTZcIYaCPwaofmcY", "H7lFuH2c6lRKE1KzrEc8woYXA3m4qwgD", "VasthUCsKtAfJQ49O69n9k2VDB8sk6Ry", "CLNAbcda3kskZ9l1P61KK9o7E81JDy0P", "FTSbac7VR6oRDuoXxASKkUBG2ay4Jl1O", "oDWQMCtwqliv6oQHoqRk4BTd2HTxQUcC", "maa7C87UpzAlS2qduOc8uqrscl2NkhxH", ""};
    public static final String A09;
    public InterfaceC1999Su A00;
    public Executor A01;
    public boolean A02;
    public C2471ei A03;
    public final InterfaceC2476en A04 = new CH();
    public final InterfaceC2481es A05;
    public final InterfaceC2482et A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final InterfaceC2465ec A01(AbstractC2478ep abstractC2478ep) throws C2479eq {
        C2479eq c2479eq;
        String strA07 = A07(220, 7, 86);
        HttpURLConnection httpURLConnection = null;
        C9 c9A05 = null;
        boolean z10 = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(abstractC2478ep.A05(), WS.A04() ? A09() : null);
                A0H(httpURLConnectionA08, abstractC2478ep);
                A0G(httpURLConnectionA08, abstractC2478ep);
                if (this.A06.AAQ()) {
                    this.A06.ABN(httpURLConnectionA08, abstractC2478ep.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean z11 = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z10 = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (z11 || z10)) {
                    try {
                        AbstractC2483eu.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e10) {
                        this.A00.ABR(strA07, AbstractC2000Sv.A1z, new C2001Sw(e10));
                    } catch (Exception e11) {
                        this.A00.ABR(strA07, AbstractC2000Sv.A1y, new C2001Sw(e11));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && abstractC2478ep.A06() != null) {
                    A00(httpURLConnectionA08, abstractC2478ep.A06());
                }
                C9 c9A06 = httpURLConnectionA08.getDoInput() ? A06(httpURLConnectionA08) : new C9(httpURLConnectionA08, null);
                if (this.A06.AAQ()) {
                    this.A06.ABO(c9A06);
                }
                if (httpURLConnectionA08 != null) {
                    httpURLConnectionA08.disconnect();
                }
                return c9A06;
            } catch (Throwable th) {
                if (this.A06.AAQ()) {
                    this.A06.ABO(c9A05);
                }
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e12) {
            try {
                try {
                    c9A05 = A05(null);
                } catch (Throwable unused) {
                    if (c9A05 == null || c9A05.A94() <= 0) {
                        throw new C2479eq(e12, c9A05);
                    }
                    if (this.A06.AAQ()) {
                        this.A06.ABO(c9A05);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return c9A05;
                }
            } catch (Exception unused2) {
                Log.e(getClass().getSimpleName(), A07(117, 13, 98), e12);
                if (0 != 0 && c9A05.A94() > 0) {
                    if (this.A06.AAQ()) {
                        this.A06.ABO(null);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                c2479eq = new C2479eq(e12, null);
            }
            if (A08[7].length() == 19) {
                throw new RuntimeException();
            }
            A08[5] = "6Q02gTcavt1J3D6llCgnQfsLExV7BLlB";
            if (c9A05 == null || c9A05.A94() <= 0) {
                c2479eq = new C2479eq(e12, c9A05);
                throw c2479eq;
            }
            if (this.A06.AAQ()) {
                this.A06.ABO(c9A05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            return c9A05;
        }
    }

    public static String A07(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{59, 57, 102, 107, 14, 102, 100, 77, 64, 9, 77, 79, 30, 93, 75, 76, 82, 30, 42, 99, 121, 42, 100, 101, 126, 42, 107, 42, 124, 107, 102, 99, 110, 42, 95, 88, 70, 80, 31, 22, 80, 75, 120, 116, 23, 0, 116, 105, 116, 55, 59, 73, 79, 59, 38, 59, 38, 42, 126, 120, 115, 99, 100, 109, 42, 94, 4, 34, 43, 38, 55, 52, 34, 35, 71, 51, 46, 42, 34, 71, 90, 71, 71, 101, 116, 116, 105, 110, 103, 32, 116, 104, 101, 32, 104, 116, 116, 112, 32, 114, 101, 115, 112, 111, 110, 115, 101, 32, 116, 105, 109, 101, 100, 32, 111, 117, 116, 61, 22, 7, 4, 28, 1, 24, 83, 22, 1, 1, 28, 1, 23, 22, 4, 111, 122, 22, 7, 7, 27, 30, 20, 22, 3, 30, 24, 25, 88, 15, 90, 0, 0, 0, 90, 17, 24, 5, 26, 90, 2, 5, 27, 18, 25, 20, 24, 19, 18, 19, 76, 20, 31, 22, 5, 4, 18, 3, 74, 34, 35, 49, 90, 79, 89, 79, 72, 86, 26, 23, 81, 26, 23, 83, 120, 100, 100, 96, 62, 96, 98, 127, 104, 105, 88, 127, 99, 100, 27, 7, 7, 3, 93, 3, 1, 28, 11, 10, 35, 28, 1, 7, 41, 34, 51, 48, 40, 53, 44};
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x015a, code lost:
    
        r7 = r29.A00;
        r10 = java.lang.System.currentTimeMillis() - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0163, code lost:
    
        if (r30.A04 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0165, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0167, code lost:
    
        r7.ABI(r0, r10, 0, r2, 0, new java.util.concurrent.TimeoutException(A07(82, 35, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0183, code lost:
    
        r2 = r30.A04.length;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 44 out of bounds for length 31
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.core.InterfaceC2465ec A0J(com.facebook.ads.redexgen.core.AbstractC2478ep r30) throws com.facebook.ads.redexgen.core.C2479eq {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C8.A0J(com.facebook.ads.redexgen.X.ep):com.facebook.ads.redexgen.X.ec");
    }

    static {
        A0A();
        A09 = InterfaceC2466ed.class.getSimpleName();
    }

    public C8(C2471ei c2471ei, InterfaceC1999Su interfaceC1999Su, Executor executor) {
        A0B();
        this.A03 = c2471ei;
        this.A06 = new C7(c2471ei.A04());
        final InterfaceC2482et interfaceC2482et = this.A06;
        this.A05 = new CF(interfaceC2482et) { // from class: com.facebook.ads.redexgen.X.21
        };
        this.A01 = executor;
        this.A00 = interfaceC1999Su;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamAG3 = null;
        try {
            outputStreamAG3 = this.A05.AG3(httpURLConnection);
            if (outputStreamAG3 != null) {
                this.A05.AKN(outputStreamAG3, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStreamAG3 != null) {
                try {
                    outputStreamAG3.close();
                } catch (Exception unused) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStreamAG3 != null) {
                try {
                    outputStreamAG3.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final InterfaceC2465ec A02(AbstractC2478ep abstractC2478ep) {
        if (this.A03.A04()) {
            A0C(abstractC2478ep);
        }
        InterfaceC2465ec interfaceC2465ecA01 = null;
        try {
            interfaceC2465ecA01 = A01(abstractC2478ep);
            return interfaceC2465ecA01;
        } catch (C2479eq hre) {
            this.A05.ADE(hre);
            return interfaceC2465ecA01;
        } catch (Exception e10) {
            this.A05.ADE(new C2479eq(e10, interfaceC2465ecA01));
            return interfaceC2465ecA01;
        }
    }

    private final InterfaceC2465ec A03(String str, C2480er c2480er, C2474el c2474el) {
        return A02(new CB(str, c2480er, c2474el));
    }

    private final InterfaceC2465ec A04(String str, String str2, byte[] bArr, C2474el c2474el) {
        return A02(new CA(str, null, str2, bArr, c2474el));
    }

    private final C9 A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        byte[] responseBody = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                responseBody = this.A05.AGj(errorStream);
            }
            C9 c92 = new C9(httpURLConnection, responseBody);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
            return c92;
        } catch (Throwable th) {
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final C9 A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamAG2 = null;
        byte[] responseBody = null;
        try {
            inputStreamAG2 = this.A05.AG2(httpURLConnection);
            if (inputStreamAG2 != null) {
                responseBody = this.A05.AGj(inputStreamAG2);
            }
            C9 c92 = new C9(httpURLConnection, responseBody);
            if (inputStreamAG2 != null) {
                try {
                    inputStreamAG2.close();
                } catch (Exception unused) {
                }
            }
            return c92;
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[3].charAt(2) != strArr[0].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "UXNjV4lzV2ywD4tdDbD0LjxSkhTqZWDx";
            strArr2[0] = "ckNMQEffDKJwLTwRJSWHE7UL6GsW6bMO";
            if (inputStreamAG2 != null) {
                try {
                    inputStreamAG2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A05.AG1(str, proxy);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(str + A07(18, 19, 27), e10);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(PsExtractor.AUDIO_STREAM, 14, 1));
        String proxyAddress = System.getProperty(A07(206, 14, 98));
        int port = -1;
        if (proxyAddress != null) {
            try {
                port = Integer.parseInt(proxyAddress);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        if (!TextUtils.isEmpty(property) && port > 0 && port <= 65535) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, port));
        }
        return proxy;
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(AbstractC2478ep abstractC2478ep) {
        StringBuilder sb = new StringBuilder(A07(182, 10, 43));
        boolean zEquals = abstractC2478ep.A03().equals(EnumC2477eo.A06);
        String strA07 = A07(41, 1, 120);
        if (zEquals) {
            byte[] bArrA06 = abstractC2478ep.A06();
            if (A08[1].charAt(0) == 'l') {
                throw new RuntimeException();
            }
            A08[4] = "MgpsgMtpOSh21D9UNcI3ZUtvoefc4JIC";
            if (bArrA06 != null) {
                sb.append(A07(7, 5, 124));
                sb.append(new String(abstractC2478ep.A06(), Charset.forName(A07(130, 5, 83))));
                sb.append(strA07);
            }
        }
        for (Map.Entry<String, String> entry : abstractC2478ep.A02().A06().entrySet()) {
            sb.append(A07(2, 5, 87));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 47));
            sb.append(entry.getValue());
            sb.append(strA07);
        }
        sb.append(A07(0, 2, 10));
        sb.append(abstractC2478ep.A05());
        sb.append(strA07);
        String string = sb.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(AbstractC2478ep abstractC2478ep, InterfaceC2467ee interfaceC2467ee) {
        this.A04.A6q(this, interfaceC2467ee, this.A01).A04(abstractC2478ep);
        if (this.A03.A04()) {
            A0C(abstractC2478ep);
        }
    }

    private void A0E(String str, int i10, int i11) {
        String str2 = A09 + A07(12, 6, 47) + i10 + A07(65, 1, 96) + i11;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i10 + 1, i11);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, InterfaceC2467ee interfaceC2467ee, C2474el c2474el) {
        CA req = new CA(str, null, str2, bArr, c2474el);
        A0D(req, interfaceC2467ee);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC2478ep abstractC2478ep) {
        Map<String, String> mapA06 = abstractC2478ep.A02().A06();
        InterfaceC2464eb interfaceC2464ebA05 = abstractC2478ep.A02().A05();
        for (String str : mapA06.keySet()) {
            httpURLConnection.setRequestProperty(str, mapA06.get(str));
        }
        if (interfaceC2464ebA05 != null) {
            Map<String, String> mapA6Y = interfaceC2464ebA05.A6Y(this.A03.A03());
            for (String str2 : mapA6Y.keySet()) {
                httpURLConnection.setRequestProperty(str2, mapA6Y.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC2478ep abstractC2478ep) throws IOException {
        C2474el c2474elA02 = abstractC2478ep.A02();
        httpURLConnection.setConnectTimeout(c2474elA02.A00());
        httpURLConnection.setReadTimeout(c2474elA02.A02());
        this.A05.AGM(httpURLConnection, abstractC2478ep.A03(), abstractC2478ep.A04());
    }

    private final boolean A0I(Throwable th, long j10, AbstractC2478ep abstractC2478ep) {
        C2474el c2474elA02 = abstractC2478ep.A02();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j10) + 10;
        if (this.A06.AAQ()) {
            String str = A07(67, 15, 118) + jCurrentTimeMillis + A07(42, 7, 69) + c2474elA02.A00() + A07(49, 7, 10) + c2474elA02.A02();
        }
        if (this.A02) {
            long jA02 = c2474elA02.A02();
            if (A08[4].charAt(1) == 'Y') {
                throw new RuntimeException();
            }
            A08[7] = "tgQXMymp9cIZW";
            return jCurrentTimeMillis >= jA02;
        }
        long elapsedTime = c2474elA02.A00();
        return jCurrentTimeMillis >= elapsedTime;
    }

    public final C2471ei A0K() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2466ed
    @Deprecated
    public final InterfaceC2465ec AGC(String str, Map<String, String> parameters) {
        return A03(str, new C2480er(parameters), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2466ed
    @Deprecated
    public final InterfaceC2465ec AGD(String str, byte[] bArr) {
        return A04(str, A07(135, 47, 102), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2466ed
    public final void AGE(String str, byte[] bArr, InterfaceC2467ee interfaceC2467ee) {
        A0F(str, A07(135, 47, 102), bArr, interfaceC2467ee, this.A03.A00());
    }
}
