package gatewayprotocol.v1;

import gatewayprotocol.v1.NativeConfigurationKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: NativeConfigurationKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeConfigurationKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializenativeConfiguration, reason: not valid java name */
    public static final NativeConfigurationOuterClass.NativeConfiguration m4181initializenativeConfiguration(@NotNull l<? super NativeConfigurationKt.Dsl, k0> block) {
        t.i(block, "block");
        NativeConfigurationKt.Dsl.Companion companion = NativeConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.NativeConfiguration.Builder builderNewBuilder = NativeConfigurationOuterClass.NativeConfiguration.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        NativeConfigurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final NativeConfigurationOuterClass.NativeConfiguration copy(@NotNull NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration, @NotNull l<? super NativeConfigurationKt.Dsl, k0> block) {
        t.i(nativeConfiguration, "<this>");
        t.i(block, "block");
        NativeConfigurationKt.Dsl.Companion companion = NativeConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.NativeConfiguration.Builder builder = nativeConfiguration.toBuilder();
        t.h(builder, "this.toBuilder()");
        NativeConfigurationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final NativeConfigurationOuterClass.AdOperationsConfiguration getAdOperationsOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasAdOperations()) {
            return nativeConfigurationOrBuilder.getAdOperations();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.RequestPolicy getAdPolicyOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasAdPolicy()) {
            return nativeConfigurationOrBuilder.getAdPolicy();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.DiagnosticEventsConfiguration getDiagnosticEventsOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasDiagnosticEvents()) {
            return nativeConfigurationOrBuilder.getDiagnosticEvents();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.FeatureFlags getFeatureFlagsOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasFeatureFlags()) {
            return nativeConfigurationOrBuilder.getFeatureFlags();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.RequestPolicy getInitPolicyOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasInitPolicy()) {
            return nativeConfigurationOrBuilder.getInitPolicy();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.RequestPolicy getOperativeEventPolicyOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasOperativeEventPolicy()) {
            return nativeConfigurationOrBuilder.getOperativeEventPolicy();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.RequestPolicy getOtherPolicyOrNull(@NotNull NativeConfigurationOuterClass.NativeConfigurationOrBuilder nativeConfigurationOrBuilder) {
        t.i(nativeConfigurationOrBuilder, "<this>");
        if (nativeConfigurationOrBuilder.hasOtherPolicy()) {
            return nativeConfigurationOrBuilder.getOtherPolicy();
        }
        return null;
    }
}
