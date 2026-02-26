package bo.app;

import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.DeviceKey;
import com.braze.support.BrazeLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class lq {
    public final void a(BrazeConfigurationProvider configurationProvider, JSONObject deviceExport, DeviceKey exportKey, Object obj) {
        kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
        kotlin.jvm.internal.t.i(deviceExport, "deviceExport");
        kotlin.jvm.internal.t.i(exportKey, "exportKey");
        if (!configurationProvider.isDeviceObjectAllowlistEnabled() || configurationProvider.getDeviceObjectAllowlist().contains(exportKey)) {
            deviceExport.putOpt(exportKey.getKey(), obj);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new kq(exportKey), 6, (Object) null);
        }
    }
}
