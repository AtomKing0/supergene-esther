package bo.app;

import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.LocationProviderName;
import com.braze.support.BrazeLogger;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes2.dex */
public final class vd {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.util.EnumSet] */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.EnumSet] */
    public final EnumSet a(BrazeConfigurationProvider appConfigurationProvider) {
        kotlin.jvm.internal.t.i(appConfigurationProvider, "appConfigurationProvider");
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        n0Var.f29834a = EnumSet.of(LocationProviderName.PASSIVE, LocationProviderName.NETWORK);
        if (!appConfigurationProvider.getCustomLocationProviderNames().isEmpty()) {
            n0Var.f29834a = appConfigurationProvider.getCustomLocationProviderNames();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new ud(n0Var), 6, (Object) null);
        }
        T allowedLocationProviders = n0Var.f29834a;
        kotlin.jvm.internal.t.h(allowedLocationProviders, "allowedLocationProviders");
        return (EnumSet) allowedLocationProviders;
    }
}
