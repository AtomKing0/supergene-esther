package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NetworkApi21.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class NetworkApi21 {
    @DoNotInline
    @Nullable
    public static final NetworkCapabilities getNetworkCapabilitiesCompat(@NotNull ConnectivityManager connectivityManager, @Nullable Network network) {
        t.i(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    @DoNotInline
    public static final boolean hasCapabilityCompat(@NotNull NetworkCapabilities networkCapabilities, int i10) {
        t.i(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i10);
    }

    @DoNotInline
    public static final void unregisterNetworkCallbackCompat(@NotNull ConnectivityManager connectivityManager, @NotNull ConnectivityManager.NetworkCallback networkCallback) {
        t.i(connectivityManager, "<this>");
        t.i(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
