package u;

import a0.h;
import a0.r;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.e;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    @NotNull
    public static final e a(@NotNull Context context, @NotNull e.a aVar, @Nullable r rVar) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null || !a0.d.e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (rVar != null && rVar.getLevel() <= 5) {
                rVar.a("NetworkObserver", 5, "Unable to register network observer.", null);
            }
            return new c();
        }
        try {
            return new g(connectivityManager, aVar);
        } catch (Exception e10) {
            if (rVar != null) {
                h.a(rVar, "NetworkObserver", new RuntimeException("Failed to register network observer.", e10));
            }
            return new c();
        }
    }
}
