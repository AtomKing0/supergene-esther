package gatewayprotocol.v1;

import gatewayprotocol.v1.FeatureFlagsKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FeatureFlagsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeatureFlagsKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializefeatureFlags, reason: not valid java name */
    public static final NativeConfigurationOuterClass.FeatureFlags m4168initializefeatureFlags(@NotNull l<? super FeatureFlagsKt.Dsl, k0> block) {
        t.i(block, "block");
        FeatureFlagsKt.Dsl.Companion companion = FeatureFlagsKt.Dsl.Companion;
        NativeConfigurationOuterClass.FeatureFlags.Builder builderNewBuilder = NativeConfigurationOuterClass.FeatureFlags.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        FeatureFlagsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final NativeConfigurationOuterClass.FeatureFlags copy(@NotNull NativeConfigurationOuterClass.FeatureFlags featureFlags, @NotNull l<? super FeatureFlagsKt.Dsl, k0> block) {
        t.i(featureFlags, "<this>");
        t.i(block, "block");
        FeatureFlagsKt.Dsl.Companion companion = FeatureFlagsKt.Dsl.Companion;
        NativeConfigurationOuterClass.FeatureFlags.Builder builder = featureFlags.toBuilder();
        t.h(builder, "this.toBuilder()");
        FeatureFlagsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
