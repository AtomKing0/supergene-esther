package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NetworkApi23.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class NetworkApi23 {
    @DoNotInline
    @Nullable
    public static final Network getActiveNetworkCompat(@NotNull ConnectivityManager connectivityManager) {
        t.i(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
