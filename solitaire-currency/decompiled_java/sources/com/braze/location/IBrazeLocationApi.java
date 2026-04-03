package com.braze.location;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.LocationProviderName;
import com.braze.models.IBrazeLocation;
import h9.l;
import java.util.EnumSet;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public interface IBrazeLocationApi {
    void initWithContext(Context context, EnumSet<LocationProviderName> enumSet, BrazeConfigurationProvider brazeConfigurationProvider);

    boolean requestSingleLocationUpdate(l<? super IBrazeLocation, k0> lVar);
}
