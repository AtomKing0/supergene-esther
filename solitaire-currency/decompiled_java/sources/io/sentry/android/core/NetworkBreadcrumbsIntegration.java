package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.NonNull;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.o5;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class NetworkBreadcrumbsIntegration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27056d = new io.sentry.util.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f27057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private SentryOptions f27058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @TestOnly
    @Nullable
    volatile c f27059g;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ io.sentry.f1 f27060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SentryOptions f27061b;

        a(io.sentry.f1 f1Var, SentryOptions sentryOptions) {
            this.f27060a = f1Var;
            this.f27061b = sentryOptions;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkBreadcrumbsIntegration.this.f27057e) {
                return;
            }
            io.sentry.k1 k1VarA = NetworkBreadcrumbsIntegration.this.f27056d.a();
            try {
                NetworkBreadcrumbsIntegration.this.f27059g = new c(this.f27060a, NetworkBreadcrumbsIntegration.this.f27054b, this.f27061b.getDateProvider());
                if (io.sentry.android.core.internal.util.a.j(NetworkBreadcrumbsIntegration.this.f27053a, NetworkBreadcrumbsIntegration.this.f27055c, NetworkBreadcrumbsIntegration.this.f27054b, NetworkBreadcrumbsIntegration.this.f27059g)) {
                    NetworkBreadcrumbsIntegration.this.f27055c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
                    io.sentry.util.p.a("NetworkBreadcrumbs");
                } else {
                    NetworkBreadcrumbsIntegration.this.f27055c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f27063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f27064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f27065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f27066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f27067e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        final String f27068f;

        @SuppressLint({"NewApi"})
        b(@NotNull NetworkCapabilities networkCapabilities, @NotNull w0 w0Var, long j10) {
            io.sentry.util.w.c(networkCapabilities, "NetworkCapabilities is required");
            io.sentry.util.w.c(w0Var, "BuildInfoProvider is required");
            this.f27063a = networkCapabilities.getLinkDownstreamBandwidthKbps();
            this.f27064b = networkCapabilities.getLinkUpstreamBandwidthKbps();
            int signalStrength = w0Var.d() >= 29 ? networkCapabilities.getSignalStrength() : 0;
            this.f27065c = signalStrength > -100 ? signalStrength : 0;
            this.f27067e = networkCapabilities.hasTransport(4);
            String strH = io.sentry.android.core.internal.util.a.h(networkCapabilities);
            this.f27068f = strH == null ? "" : strH;
            this.f27066d = j10;
        }

        boolean a(@NotNull b bVar) {
            int iAbs = Math.abs(this.f27065c - bVar.f27065c);
            int iAbs2 = Math.abs(this.f27063a - bVar.f27063a);
            int iAbs3 = Math.abs(this.f27064b - bVar.f27064b);
            boolean z10 = io.sentry.n.l((double) Math.abs(this.f27066d - bVar.f27066d)) < 5000.0d;
            return this.f27067e == bVar.f27067e && this.f27068f.equals(bVar.f27068f) && (z10 || iAbs <= 5) && (z10 || (((double) iAbs2) > Math.max(1000.0d, ((double) Math.abs(this.f27063a)) * 0.1d) ? 1 : (((double) iAbs2) == Math.max(1000.0d, ((double) Math.abs(this.f27063a)) * 0.1d) ? 0 : -1)) <= 0) && (z10 || (((double) iAbs3) > Math.max(1000.0d, ((double) Math.abs(this.f27064b)) * 0.1d) ? 1 : (((double) iAbs3) == Math.max(1000.0d, ((double) Math.abs(this.f27064b)) * 0.1d) ? 0 : -1)) <= 0);
        }
    }

    static final class c extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        final io.sentry.f1 f27069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        final w0 f27070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        Network f27071c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        NetworkCapabilities f27072d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f27073e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        final o5 f27074f;

        c(@NotNull io.sentry.f1 f1Var, @NotNull w0 w0Var, @NotNull o5 o5Var) {
            this.f27069a = (io.sentry.f1) io.sentry.util.w.c(f1Var, "Scopes are required");
            this.f27070b = (w0) io.sentry.util.w.c(w0Var, "BuildInfoProvider is required");
            this.f27074f = (o5) io.sentry.util.w.c(o5Var, "SentryDateProvider is required");
        }

        private Breadcrumb a(String str) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType("system");
            breadcrumb.setCategory("network.event");
            breadcrumb.setData("action", str);
            breadcrumb.setLevel(SentryLevel.INFO);
            return breadcrumb;
        }

        @Nullable
        private b b(@Nullable NetworkCapabilities networkCapabilities, @NotNull NetworkCapabilities networkCapabilities2, long j10, long j11) {
            if (networkCapabilities == null) {
                return new b(networkCapabilities2, this.f27070b, j11);
            }
            b bVar = new b(networkCapabilities, this.f27070b, j10);
            b bVar2 = new b(networkCapabilities2, this.f27070b, j11);
            if (bVar.a(bVar2)) {
                return null;
            }
            return bVar2;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            if (network.equals(this.f27071c)) {
                return;
            }
            this.f27069a.c(a("NETWORK_AVAILABLE"));
            this.f27071c = network;
            this.f27072d = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            if (network.equals(this.f27071c)) {
                long jG = this.f27074f.a().g();
                b bVarB = b(this.f27072d, networkCapabilities, this.f27073e, jG);
                if (bVarB == null) {
                    return;
                }
                this.f27072d = networkCapabilities;
                this.f27073e = jG;
                Breadcrumb breadcrumbA = a("NETWORK_CAPABILITIES_CHANGED");
                breadcrumbA.setData("download_bandwidth", Integer.valueOf(bVarB.f27063a));
                breadcrumbA.setData("upload_bandwidth", Integer.valueOf(bVarB.f27064b));
                breadcrumbA.setData("vpn_active", Boolean.valueOf(bVarB.f27067e));
                breadcrumbA.setData("network_type", bVarB.f27068f);
                int i10 = bVarB.f27065c;
                if (i10 != 0) {
                    breadcrumbA.setData("signal_strength", Integer.valueOf(i10));
                }
                io.sentry.l0 l0Var = new io.sentry.l0();
                l0Var.j("android:networkCapabilities", bVarB);
                this.f27069a.addBreadcrumb(breadcrumbA, l0Var);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            if (network.equals(this.f27071c)) {
                this.f27069a.c(a("NETWORK_LOST"));
                this.f27071c = null;
                this.f27072d = null;
            }
        }
    }

    public NetworkBreadcrumbsIntegration(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.w0 w0Var2) {
        this.f27053a = (Context) io.sentry.util.w.c(e1.h(context), "Context is required");
        this.f27054b = (w0) io.sentry.util.w.c(w0Var, "BuildInfoProvider is required");
        this.f27055c = (io.sentry.w0) io.sentry.util.w.c(w0Var2, "ILogger is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        io.sentry.k1 k1VarA = this.f27056d.a();
        try {
            if (this.f27059g != null) {
                io.sentry.android.core.internal.util.a.k(this.f27053a, this.f27055c, this.f27059g);
                this.f27055c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration removed.", new Object[0]);
            }
            this.f27059g = null;
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        io.sentry.w0 w0Var = this.f27055c;
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        w0Var.c(sentryLevel, "NetworkBreadcrumbsIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
        this.f27058f = sentryOptions;
        if (sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()) {
            if (this.f27054b.d() < 24) {
                this.f27055c.c(sentryLevel, "NetworkCallbacks need Android N+.", new Object[0]);
                return;
            }
            try {
                sentryOptions.getExecutorService().submit(new a(f1Var, sentryOptions));
            } catch (Throwable th) {
                this.f27055c.b(SentryLevel.ERROR, "Error submitting NetworkBreadcrumbsIntegration task.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27057e = true;
        try {
            ((SentryOptions) io.sentry.util.w.c(this.f27058f, "Options is required")).getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.x1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27555a.B();
                }
            });
        } catch (Throwable th) {
            this.f27055c.b(SentryLevel.ERROR, "Error submitting NetworkBreadcrumbsIntegration task.", th);
        }
    }
}
