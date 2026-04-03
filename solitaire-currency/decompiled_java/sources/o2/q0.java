package o2;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.drm.WidevineUtil;
import java.util.Map;

/* JADX INFO: compiled from: WidevineUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return C.TIME_UNSET;
        }
        try {
            String str2 = map.get(str);
            return str2 != null ? Long.parseLong(str2) : C.TIME_UNSET;
        } catch (NumberFormatException unused) {
            return C.TIME_UNSET;
        }
    }

    @Nullable
    public static Pair<Long, Long> b(o oVar) {
        Map<String, String> mapQueryKeyStatus = oVar.queryKeyStatus();
        if (mapQueryKeyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(mapQueryKeyStatus, WidevineUtil.PROPERTY_LICENSE_DURATION_REMAINING)), Long.valueOf(a(mapQueryKeyStatus, WidevineUtil.PROPERTY_PLAYBACK_DURATION_REMAINING)));
    }
}
