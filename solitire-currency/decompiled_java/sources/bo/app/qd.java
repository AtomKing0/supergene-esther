package bo.app;

import android.location.Location;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class qd {
    public static final Double a(qd qdVar, Location location) {
        qdVar.getClass();
        if (Build.VERSION.SDK_INT < 26 || !location.hasVerticalAccuracy()) {
            return null;
        }
        return Double.valueOf(location.getVerticalAccuracyMeters());
    }
}
