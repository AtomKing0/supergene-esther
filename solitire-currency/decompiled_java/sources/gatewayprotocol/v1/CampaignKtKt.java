package gatewayprotocol.v1;

import gatewayprotocol.v1.CampaignKt;
import gatewayprotocol.v1.CampaignStateOuterClass;
import gatewayprotocol.v1.TimestampsOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CampaignKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CampaignKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializecampaign, reason: not valid java name */
    public static final CampaignStateOuterClass.Campaign m4154initializecampaign(@NotNull l<? super CampaignKt.Dsl, k0> block) {
        t.i(block, "block");
        CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.Companion;
        CampaignStateOuterClass.Campaign.Builder builderNewBuilder = CampaignStateOuterClass.Campaign.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        CampaignKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final CampaignStateOuterClass.Campaign copy(@NotNull CampaignStateOuterClass.Campaign campaign, @NotNull l<? super CampaignKt.Dsl, k0> block) {
        t.i(campaign, "<this>");
        t.i(block, "block");
        CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.Companion;
        CampaignStateOuterClass.Campaign.Builder builder = campaign.toBuilder();
        t.h(builder, "this.toBuilder()");
        CampaignKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final TimestampsOuterClass.Timestamps getLoadTimestampOrNull(@NotNull CampaignStateOuterClass.CampaignOrBuilder campaignOrBuilder) {
        t.i(campaignOrBuilder, "<this>");
        if (campaignOrBuilder.hasLoadTimestamp()) {
            return campaignOrBuilder.getLoadTimestamp();
        }
        return null;
    }

    @Nullable
    public static final TimestampsOuterClass.Timestamps getShowTimestampOrNull(@NotNull CampaignStateOuterClass.CampaignOrBuilder campaignOrBuilder) {
        t.i(campaignOrBuilder, "<this>");
        if (campaignOrBuilder.hasShowTimestamp()) {
            return campaignOrBuilder.getShowTimestamp();
        }
        return null;
    }
}
