package bo.app;

import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ee0 {
    public final ConcurrentHashMap a(SharedPreferences storagePrefs) {
        kotlin.jvm.internal.t.i(storagePrefs, "storagePrefs");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<String, ?> all = storagePrefs.getAll();
        if (all != null && !all.isEmpty()) {
            for (String remoteAssetKey : all.keySet()) {
                try {
                    String string = storagePrefs.getString(remoteAssetKey, null);
                    if (string != null && !p9.q.z(string)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ae0(string, remoteAssetKey), 7, (Object) null);
                        kotlin.jvm.internal.t.h(remoteAssetKey, "remoteAssetKey");
                        concurrentHashMap.put(remoteAssetKey, string);
                    }
                } catch (Exception e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new be0(remoteAssetKey), 4, (Object) null);
                }
            }
        }
        return concurrentHashMap;
    }
}
