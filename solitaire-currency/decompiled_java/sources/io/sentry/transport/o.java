package io.sentry.transport;

import com.ironsource.nb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.c4;
import io.sentry.p5;
import io.sentry.w0;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpConnection.java */
/* JADX INFO: loaded from: classes5.dex */
final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Charset f28291e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Proxy f28292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c4 f28293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final b0 f28295d;

    public o(@NotNull SentryOptions sentryOptions, @NotNull c4 c4Var, @NotNull b0 b0Var) {
        this(sentryOptions, c4Var, m.a(), b0Var);
    }

    private void a(@NotNull HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
    }

    @NotNull
    private HttpURLConnection b() throws IOException {
        HttpURLConnection httpURLConnectionE = e();
        for (Map.Entry<String, String> entry : this.f28293b.a().entrySet()) {
            httpURLConnectionE.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnectionE.setRequestMethod("POST");
        httpURLConnectionE.setDoOutput(true);
        httpURLConnectionE.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnectionE.setRequestProperty(nb.K, "application/x-sentry-envelope");
        httpURLConnectionE.setRequestProperty("Accept", nb.L);
        httpURLConnectionE.setRequestProperty("Connection", "close");
        httpURLConnectionE.setConnectTimeout(this.f28294c.getConnectionTimeoutMillis());
        httpURLConnectionE.setReadTimeout(this.f28294c.getReadTimeoutMillis());
        SSLSocketFactory sslSocketFactory = this.f28294c.getSslSocketFactory();
        if ((httpURLConnectionE instanceof HttpsURLConnection) && sslSocketFactory != null) {
            ((HttpsURLConnection) httpURLConnectionE).setSSLSocketFactory(sslSocketFactory);
        }
        httpURLConnectionE.connect();
        return httpURLConnectionE;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c(@org.jetbrains.annotations.NotNull java.net.HttpURLConnection r5) {
        /*
            r4 = this;
            java.io.InputStream r5 = r5.getErrorStream()     // Catch: java.io.IOException -> L4b
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f
            java.nio.charset.Charset r2 = io.sentry.transport.o.f28291e     // Catch: java.lang.Throwable -> L3f
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L3f
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L3f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r1.<init>()     // Catch: java.lang.Throwable -> L35
            r2 = 1
        L16:
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L28
            if (r2 != 0) goto L23
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch: java.lang.Throwable -> L35
        L23:
            r1.append(r3)     // Catch: java.lang.Throwable -> L35
            r2 = 0
            goto L16
        L28:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L35
            r0.close()     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L34
            r5.close()     // Catch: java.io.IOException -> L4b
        L34:
            return r1
        L35:
            r1 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L3a
            goto L3e
        L3a:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L3f
        L3e:
            throw r1     // Catch: java.lang.Throwable -> L3f
        L3f:
            r0 = move-exception
            if (r5 == 0) goto L4a
            r5.close()     // Catch: java.lang.Throwable -> L46
            goto L4a
        L46:
            r5 = move-exception
            r0.addSuppressed(r5)     // Catch: java.io.IOException -> L4b
        L4a:
            throw r0     // Catch: java.io.IOException -> L4b
        L4b:
            java.lang.String r5 = "Failed to obtain error message while analyzing send failure."
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.o.c(java.net.HttpURLConnection):java.lang.String");
    }

    private boolean d(int i10) {
        return i10 == 200;
    }

    @NotNull
    private d0 f(@NotNull HttpURLConnection httpURLConnection) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                i(httpURLConnection, responseCode);
                if (d(responseCode)) {
                    this.f28294c.getLogger().c(SentryLevel.DEBUG, "Envelope sent successfully.", new Object[0]);
                    return d0.e();
                }
                w0 logger = this.f28294c.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.c(sentryLevel, "Request failed, API returned %s", Integer.valueOf(responseCode));
                if (this.f28294c.isDebug()) {
                    this.f28294c.getLogger().c(sentryLevel, "%s", c(httpURLConnection));
                }
                return d0.b(responseCode);
            } catch (IOException e10) {
                this.f28294c.getLogger().a(SentryLevel.ERROR, e10, "Error reading and logging the response stream", new Object[0]);
                a(httpURLConnection);
                return d0.a();
            }
        } finally {
            a(httpURLConnection);
        }
    }

    @Nullable
    private Proxy g(@Nullable SentryOptions.i iVar) {
        if (iVar != null) {
            String strC = iVar.c();
            String strA = iVar.a();
            if (strC != null && strA != null) {
                try {
                    return new Proxy(iVar.d() != null ? iVar.d() : Proxy.Type.HTTP, new InetSocketAddress(strA, Integer.parseInt(strC)));
                } catch (NumberFormatException e10) {
                    this.f28294c.getLogger().a(SentryLevel.ERROR, e10, "Failed to parse Sentry Proxy port: " + iVar.c() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    @NotNull
    HttpURLConnection e() throws IOException {
        return (HttpURLConnection) (this.f28292a == null ? this.f28293b.b().openConnection() : this.f28293b.b().openConnection(this.f28292a));
    }

    @NotNull
    public d0 h(@NotNull p5 p5Var) throws IOException {
        d0 d0VarF;
        this.f28294c.getSocketTagger().b();
        try {
            OutputStream outputStream = b().getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f28294c.getSerializer().b(p5Var, gZIPOutputStream);
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } finally {
            try {
            } finally {
            }
        }
        return d0VarF;
    }

    public void i(@NotNull HttpURLConnection httpURLConnection, int i10) {
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        this.f28295d.I0(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i10);
    }

    o(@NotNull SentryOptions sentryOptions, @NotNull c4 c4Var, @NotNull m mVar, @NotNull b0 b0Var) {
        this.f28293b = c4Var;
        this.f28294c = sentryOptions;
        this.f28295d = b0Var;
        Proxy proxyG = g(sentryOptions.getProxy());
        this.f28292a = proxyG;
        if (proxyG == null || sentryOptions.getProxy() == null) {
            return;
        }
        String strE = sentryOptions.getProxy().e();
        String strB = sentryOptions.getProxy().b();
        if (strE == null || strB == null) {
            return;
        }
        mVar.b(new w(strE, strB));
    }
}
