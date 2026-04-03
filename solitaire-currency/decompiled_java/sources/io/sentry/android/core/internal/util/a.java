package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.ironsource.r8;
import io.sentry.SentryLevel;
import io.sentry.android.core.e1;
import io.sentry.k1;
import io.sentry.r0;
import io.sentry.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidConnectionStatusProvider.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.w0 f27293c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private volatile ConnectivityManager.NetworkCallback f27296f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27295e = new io.sentry.util.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<r0.b> f27294d = new ArrayList();

    /* JADX INFO: renamed from: io.sentry.android.core.internal.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidConnectionStatusProvider.java */
    class C0580a extends ConnectivityManager.NetworkCallback {
        C0580a() {
        }

        public void a() {
            r0.a aVarA = a.this.a();
            k1 k1VarA = a.this.f27295e.a();
            try {
                Iterator it = a.this.f27294d.iterator();
                while (it.hasNext()) {
                    ((r0.b) it.next()).a(aVarA);
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

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            a();
        }
    }

    public a(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.android.core.w0 w0Var2) {
        this.f27291a = e1.h(context);
        this.f27292b = w0Var;
        this.f27293c = w0Var2;
    }

    @NotNull
    private static r0.a f(@NotNull Context context, @NotNull ConnectivityManager connectivityManager, @NotNull w0 w0Var) {
        if (!m.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w0Var.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return r0.a.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() ? r0.a.CONNECTED : r0.a.DISCONNECTED;
            }
            w0Var.c(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return r0.a.DISCONNECTED;
        } catch (Throwable th) {
            w0Var.b(SentryLevel.WARNING, "Could not retrieve Connection Status", th);
            return r0.a.UNKNOWN;
        }
    }

    @SuppressLint({"ObsoleteSdkInt", "MissingPermission", "NewApi"})
    @Nullable
    public static String g(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.android.core.w0 w0Var2) {
        boolean zHasTransport;
        boolean zHasTransport2;
        ConnectivityManager connectivityManagerI = i(context, w0Var);
        if (connectivityManagerI == null) {
            return null;
        }
        boolean z10 = false;
        if (!m.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w0Var.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        try {
            zHasTransport = true;
            if (w0Var2.d() >= 23) {
                Network activeNetwork = connectivityManagerI.getActiveNetwork();
                if (activeNetwork == null) {
                    w0Var.c(SentryLevel.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities = connectivityManagerI.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    w0Var.c(SentryLevel.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean zHasTransport3 = networkCapabilities.hasTransport(3);
                zHasTransport2 = networkCapabilities.hasTransport(1);
                zHasTransport = networkCapabilities.hasTransport(0);
                z10 = zHasTransport3;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManagerI.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    w0Var.c(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                    return null;
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    zHasTransport2 = false;
                } else if (type != 1) {
                    if (type != 9) {
                        zHasTransport2 = false;
                    } else {
                        zHasTransport2 = false;
                        z10 = true;
                    }
                    zHasTransport = zHasTransport2;
                } else {
                    zHasTransport2 = true;
                    zHasTransport = false;
                }
            }
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Failed to retrieve network info", th);
        }
        if (z10) {
            return r8.f14658e;
        }
        if (zHasTransport2) {
            return r8.f14655b;
        }
        if (zHasTransport) {
            return r8.f14660g;
        }
        return null;
    }

    @Nullable
    public static String h(@NotNull NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasTransport(3)) {
            return r8.f14658e;
        }
        if (networkCapabilities.hasTransport(1)) {
            return r8.f14655b;
        }
        if (networkCapabilities.hasTransport(0)) {
            return r8.f14660g;
        }
        return null;
    }

    @Nullable
    private static ConnectivityManager i(@NotNull Context context, @NotNull w0 w0Var) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            w0Var.c(SentryLevel.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean j(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.android.core.w0 w0Var2, @NotNull ConnectivityManager.NetworkCallback networkCallback) {
        if (w0Var2.d() < 24) {
            w0Var.c(SentryLevel.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager connectivityManagerI = i(context, w0Var);
        if (connectivityManagerI == null) {
            return false;
        }
        if (!m.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w0Var.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            connectivityManagerI.registerDefaultNetworkCallback(networkCallback);
            return true;
        } catch (Throwable th) {
            w0Var.b(SentryLevel.WARNING, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void k(@NotNull Context context, @NotNull w0 w0Var, @NotNull ConnectivityManager.NetworkCallback networkCallback) {
        ConnectivityManager connectivityManagerI = i(context, w0Var);
        if (connectivityManagerI == null) {
            return;
        }
        try {
            connectivityManagerI.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            w0Var.b(SentryLevel.WARNING, "unregisterNetworkCallback failed", th);
        }
    }

    @Override // io.sentry.r0
    @NotNull
    public r0.a a() {
        ConnectivityManager connectivityManagerI = i(this.f27291a, this.f27292b);
        return connectivityManagerI == null ? r0.a.UNKNOWN : f(this.f27291a, connectivityManagerI, this.f27292b);
    }

    @Override // io.sentry.r0
    public boolean b(@NotNull r0.b bVar) {
        k1 k1VarA = this.f27295e.a();
        try {
            this.f27294d.add(bVar);
            if (k1VarA != null) {
                k1VarA.close();
            }
            if (this.f27296f == null) {
                k1VarA = this.f27295e.a();
                try {
                    if (this.f27296f == null) {
                        C0580a c0580a = new C0580a();
                        if (j(this.f27291a, this.f27292b, this.f27293c, c0580a)) {
                            this.f27296f = c0580a;
                            if (k1VarA != null) {
                                k1VarA.close();
                            }
                            return true;
                        }
                        if (k1VarA == null) {
                            return false;
                        }
                        k1VarA.close();
                        return false;
                    }
                    if (k1VarA != null) {
                        k1VarA.close();
                    }
                } finally {
                }
            }
            return true;
        } finally {
        }
    }

    @Override // io.sentry.r0
    public void c(@NotNull r0.b bVar) {
        k1 k1VarA = this.f27295e.a();
        try {
            this.f27294d.remove(bVar);
            if (this.f27294d.isEmpty() && this.f27296f != null) {
                k(this.f27291a, this.f27292b, this.f27296f);
                this.f27296f = null;
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

    @Override // io.sentry.r0
    @Nullable
    public String getConnectionType() {
        return g(this.f27291a, this.f27292b, this.f27293c);
    }
}
