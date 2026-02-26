package gatewayprotocol.v1;

import gatewayprotocol.v1.AdRequestKt;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.CampaignStateOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AdRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdRequestKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeadRequest, reason: not valid java name */
    public static final AdRequestOuterClass.AdRequest m4148initializeadRequest(@NotNull l<? super AdRequestKt.Dsl, k0> block) {
        t.i(block, "block");
        AdRequestKt.Dsl.Companion companion = AdRequestKt.Dsl.Companion;
        AdRequestOuterClass.AdRequest.Builder builderNewBuilder = AdRequestOuterClass.AdRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AdRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final AdRequestOuterClass.AdRequest copy(@NotNull AdRequestOuterClass.AdRequest adRequest, @NotNull l<? super AdRequestKt.Dsl, k0> block) {
        t.i(adRequest, "<this>");
        t.i(block, "block");
        AdRequestKt.Dsl.Companion companion = AdRequestKt.Dsl.Companion;
        AdRequestOuterClass.AdRequest.Builder builder = adRequest.toBuilder();
        t.h(builder, "this.toBuilder()");
        AdRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final AdRequestOuterClass.BannerSize getBannerSizeOrNull(@NotNull AdRequestOuterClass.AdRequestOrBuilder adRequestOrBuilder) {
        t.i(adRequestOrBuilder, "<this>");
        if (adRequestOrBuilder.hasBannerSize()) {
            return adRequestOrBuilder.getBannerSize();
        }
        return null;
    }

    @Nullable
    public static final CampaignStateOuterClass.CampaignState getCampaignStateOrNull(@NotNull AdRequestOuterClass.AdRequestOrBuilder adRequestOrBuilder) {
        t.i(adRequestOrBuilder, "<this>");
        if (adRequestOrBuilder.hasCampaignState()) {
            return adRequestOrBuilder.getCampaignState();
        }
        return null;
    }

    @Nullable
    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfoOrNull(@NotNull AdRequestOuterClass.AdRequestOrBuilder adRequestOrBuilder) {
        t.i(adRequestOrBuilder, "<this>");
        if (adRequestOrBuilder.hasDynamicDeviceInfo()) {
            return adRequestOrBuilder.getDynamicDeviceInfo();
        }
        return null;
    }

    @Nullable
    public static final SessionCountersOuterClass.SessionCounters getSessionCountersOrNull(@NotNull AdRequestOuterClass.AdRequestOrBuilder adRequestOrBuilder) {
        t.i(adRequestOrBuilder, "<this>");
        if (adRequestOrBuilder.hasSessionCounters()) {
            return adRequestOrBuilder.getSessionCounters();
        }
        return null;
    }

    @Nullable
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfoOrNull(@NotNull AdRequestOuterClass.AdRequestOrBuilder adRequestOrBuilder) {
        t.i(adRequestOrBuilder, "<this>");
        if (adRequestOrBuilder.hasStaticDeviceInfo()) {
            return adRequestOrBuilder.getStaticDeviceInfo();
        }
        return null;
    }
}
