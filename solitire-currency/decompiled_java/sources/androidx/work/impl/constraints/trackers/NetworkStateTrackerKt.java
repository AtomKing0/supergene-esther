package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NetworkStateTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkStateTrackerKt {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("NetworkStateTracker");
        t.h(strTagWithPrefix, "tagWithPrefix(\"NetworkStateTracker\")");
        TAG = strTagWithPrefix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final ConstraintTracker<NetworkState> NetworkStateTracker(@NotNull Context context, @NotNull TaskExecutor taskExecutor) {
        t.i(context, "context");
        t.i(taskExecutor, "taskExecutor");
        return Build.VERSION.SDK_INT >= 24 ? new NetworkStateTracker24(context, taskExecutor) : new NetworkStateTrackerPre24(context, taskExecutor);
    }

    @NotNull
    public static final NetworkState getActiveNetworkState(@NotNull ConnectivityManager connectivityManager) {
        t.i(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return new NetworkState(activeNetworkInfo != null && activeNetworkInfo.isConnected(), isActiveNetworkValidated(connectivityManager), ConnectivityManagerCompat.isActiveNetworkMetered(connectivityManager), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }

    public static final boolean isActiveNetworkValidated(@NotNull ConnectivityManager connectivityManager) {
        t.i(connectivityManager, "<this>");
        try {
            NetworkCapabilities networkCapabilitiesCompat = NetworkApi21.getNetworkCapabilitiesCompat(connectivityManager, NetworkApi23.getActiveNetworkCompat(connectivityManager));
            if (networkCapabilitiesCompat != null) {
                return NetworkApi21.hasCapabilityCompat(networkCapabilitiesCompat, 16);
            }
            return false;
        } catch (SecurityException e10) {
            Logger.get().error(TAG, "Unable to validate active network", e10);
            return false;
        }
    }

    public static /* synthetic */ void getActiveNetworkState$annotations(ConnectivityManager connectivityManager) {
    }
}
