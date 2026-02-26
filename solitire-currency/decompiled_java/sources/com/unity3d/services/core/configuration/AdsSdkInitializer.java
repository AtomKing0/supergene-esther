package com.unity3d.services.core.configuration;

import android.content.Context;
import androidx.startup.Initializer;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AdsSdkInitializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdsSdkInitializer implements Initializer<k0> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ k0 create(Context context) {
        create2(context);
        return k0.f35197a;
    }

    @Override // androidx.startup.Initializer
    @NotNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return v.l();
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public void create2(@NotNull Context context) {
        t.i(context, "context");
        ClientProperties.setApplicationContext(context.getApplicationContext());
        SdkProperties.setAppInitializationTimeSinceEpoch(System.currentTimeMillis());
    }
}
