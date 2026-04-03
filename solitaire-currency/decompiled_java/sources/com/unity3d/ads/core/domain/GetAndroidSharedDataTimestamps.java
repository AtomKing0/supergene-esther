package com.unity3d.ads.core.domain;

import android.os.SystemClock;
import com.unity3d.ads.core.extensions.TimestampExtensionsKt;
import com.unity3d.services.core.properties.SdkProperties;
import gatewayprotocol.v1.TimestampsKt;
import gatewayprotocol.v1.TimestampsOuterClass;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetAndroidSharedDataTimestamps.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidSharedDataTimestamps implements GetSharedDataTimestamps {
    @Override // com.unity3d.ads.core.domain.GetSharedDataTimestamps
    @NotNull
    public TimestampsOuterClass.Timestamps invoke() {
        TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
        TimestampsOuterClass.Timestamps.Builder builderNewBuilder = TimestampsOuterClass.Timestamps.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TimestampsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setTimestamp(TimestampExtensionsKt.fromMillis(System.currentTimeMillis()));
        dsl_create.setSessionTimestamp(SystemClock.elapsedRealtime() - SdkProperties.getInitializationTime());
        return dsl_create._build();
    }
}
