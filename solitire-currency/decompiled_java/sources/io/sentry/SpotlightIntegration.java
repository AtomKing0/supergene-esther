package io.sentry;

import com.ironsource.nb;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPOutputStream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class SpotlightIntegration implements v1, SentryOptions.b, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private SentryOptions f26964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private w0 f26965b = s2.e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private j1 f26966c = b3.e();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void z(@NotNull p5 p5Var) {
        try {
            if (this.f26964a == null) {
                throw new IllegalArgumentException("SentryOptions are required to send envelopes.");
            }
            HttpURLConnection httpURLConnectionQ = q(x());
            try {
                OutputStream outputStream = httpURLConnectionQ.getOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        this.f26964a.getSerializer().b(p5Var, gZIPOutputStream);
                        gZIPOutputStream.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        this.f26965b.c(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionQ.getResponseCode()));
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    this.f26965b.b(SentryLevel.ERROR, "An exception occurred while submitting the envelope to the Sentry server.", th);
                    this.f26965b.c(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionQ.getResponseCode()));
                } catch (Throwable th2) {
                    this.f26965b.c(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionQ.getResponseCode()));
                    n(httpURLConnectionQ);
                    throw th2;
                }
            }
            n(httpURLConnectionQ);
        } catch (Exception e10) {
            this.f26965b.b(SentryLevel.ERROR, "An exception occurred while creating the connection to spotlight.", e10);
        }
    }

    private void n(@NotNull HttpURLConnection httpURLConnection) {
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
    private HttpURLConnection q(@NotNull String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setReadTimeout(1000);
        httpURLConnection.setConnectTimeout(1000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty(nb.K, "application/x-sentry-envelope");
        httpURLConnection.setRequestProperty("Accept", nb.L);
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    @Override // io.sentry.SentryOptions.b
    public void a(@NotNull final p5 p5Var, @Nullable l0 l0Var) {
        try {
            this.f26966c.submit(new Runnable() { // from class: io.sentry.r8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28156a.z(p5Var);
                }
            });
        } catch (RejectedExecutionException e10) {
            this.f26965b.b(SentryLevel.WARNING, "Spotlight envelope submission rejected.", e10);
        }
    }

    @Override // io.sentry.v1
    public void c(@NotNull f1 f1Var, @NotNull SentryOptions sentryOptions) {
        this.f26964a = sentryOptions;
        this.f26965b = sentryOptions.getLogger();
        if (sentryOptions.getBeforeEnvelopeCallback() != null || !sentryOptions.isEnableSpotlight()) {
            this.f26965b.c(SentryLevel.DEBUG, "SpotlightIntegration is not enabled. BeforeEnvelopeCallback is already set or spotlight is not enabled.", new Object[0]);
            return;
        }
        this.f26966c = new t6();
        sentryOptions.setBeforeEnvelopeCallback(this);
        this.f26965b.c(SentryLevel.DEBUG, "SpotlightIntegration enabled.", new Object[0]);
        io.sentry.util.p.a("Spotlight");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26966c.a(0L);
        SentryOptions sentryOptions = this.f26964a;
        if (sentryOptions == null || sentryOptions.getBeforeEnvelopeCallback() != this) {
            return;
        }
        this.f26964a.setBeforeEnvelopeCallback(null);
    }

    @TestOnly
    public String x() {
        SentryOptions sentryOptions = this.f26964a;
        return (sentryOptions == null || sentryOptions.getSpotlightConnectionUrl() == null) ? io.sentry.util.y.a() ? "http://10.0.2.2:8969/stream" : "http://localhost:8969/stream" : this.f26964a.getSpotlightConnectionUrl();
    }
}
