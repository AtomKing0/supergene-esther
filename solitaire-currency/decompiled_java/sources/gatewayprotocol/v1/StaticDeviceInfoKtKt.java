package gatewayprotocol.v1;

import gatewayprotocol.v1.StaticDeviceInfoKt;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StaticDeviceInfoKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializestaticDeviceInfo, reason: not valid java name */
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo m4196initializestaticDeviceInfo(@NotNull l<? super StaticDeviceInfoKt.Dsl, k0> block) {
        t.i(block, "block");
        StaticDeviceInfoKt.Dsl.Companion companion = StaticDeviceInfoKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builderNewBuilder = StaticDeviceInfoOuterClass.StaticDeviceInfo.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        StaticDeviceInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo copy(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo, @NotNull l<? super StaticDeviceInfoKt.Dsl, k0> block) {
        t.i(staticDeviceInfo, "<this>");
        t.i(block, "block");
        StaticDeviceInfoKt.Dsl.Companion companion = StaticDeviceInfoKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder = staticDeviceInfo.toBuilder();
        t.h(builder, "this.toBuilder()");
        StaticDeviceInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android getAndroidOrNull(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfoOrBuilder staticDeviceInfoOrBuilder) {
        t.i(staticDeviceInfoOrBuilder, "<this>");
        if (staticDeviceInfoOrBuilder.hasAndroid()) {
            return staticDeviceInfoOrBuilder.getAndroid();
        }
        return null;
    }

    @Nullable
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios getIosOrNull(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfoOrBuilder staticDeviceInfoOrBuilder) {
        t.i(staticDeviceInfoOrBuilder, "<this>");
        if (staticDeviceInfoOrBuilder.hasIos()) {
            return staticDeviceInfoOrBuilder.getIos();
        }
        return null;
    }

    @NotNull
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android copy(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo.Android android2, @NotNull l<? super StaticDeviceInfoKt.AndroidKt.Dsl, k0> block) {
        t.i(android2, "<this>");
        t.i(block, "block");
        StaticDeviceInfoKt.AndroidKt.Dsl.Companion companion = StaticDeviceInfoKt.AndroidKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder builder = android2.toBuilder();
        t.h(builder, "this.toBuilder()");
        StaticDeviceInfoKt.AndroidKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios copy(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios ios, @NotNull l<? super StaticDeviceInfoKt.IosKt.Dsl, k0> block) {
        t.i(ios, "<this>");
        t.i(block, "block");
        StaticDeviceInfoKt.IosKt.Dsl.Companion companion = StaticDeviceInfoKt.IosKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.Builder builder = ios.toBuilder();
        t.h(builder, "this.toBuilder()");
        StaticDeviceInfoKt.IosKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
