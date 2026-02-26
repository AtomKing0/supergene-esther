package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NetworkStateTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {

    @NotNull
    private final ConnectivityManager connectivityManager;

    @NotNull
    private final NetworkStateTracker24$networkCallback$1 networkCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(@NotNull Context context, @NotNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        t.i(context, "context");
        t.i(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(@NotNull Network network, @NotNull NetworkCapabilities capabilities) {
                t.i(network, "network");
                t.i(capabilities, "capabilities");
                Logger.get().debug(NetworkStateTrackerKt.TAG, "Network capabilities changed: " + capabilities);
                NetworkStateTracker24 networkStateTracker24 = this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@NotNull Network network) {
                t.i(network, "network");
                Logger.get().debug(NetworkStateTrackerKt.TAG, "Network connection lost");
                NetworkStateTracker24 networkStateTracker24 = this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e10) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e10);
        } catch (SecurityException e11) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e11);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        try {
            Logger.get().debug(NetworkStateTrackerKt.TAG, "Unregistering network callback");
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e10) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e10);
        } catch (SecurityException e11) {
            Logger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e11);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    @NotNull
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }
}
