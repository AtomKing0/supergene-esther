package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import gatewayprotocol.v1.CampaignKt;
import gatewayprotocol.v1.CampaignStateKt;
import gatewayprotocol.v1.CampaignStateOuterClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.o0;
import s9.y;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: AndroidCampaignRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidCampaignRepository implements CampaignRepository {

    @NotNull
    private final y<Map<String, CampaignStateOuterClass.Campaign>> campaigns;

    @NotNull
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public AndroidCampaignRepository(@NotNull GetSharedDataTimestamps getSharedDataTimestamps) {
        t.i(getSharedDataTimestamps, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps;
        this.campaigns = o0.a(r0.g());
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    @Nullable
    public CampaignStateOuterClass.Campaign getCampaign(@NotNull ByteString opportunityId) {
        t.i(opportunityId, "opportunityId");
        return this.campaigns.getValue().get(opportunityId.toStringUtf8());
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    @NotNull
    public CampaignStateOuterClass.CampaignState getCampaignState() {
        Collection<CampaignStateOuterClass.Campaign> collectionValues = this.campaigns.getValue().values();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionValues) {
            if (((CampaignStateOuterClass.Campaign) obj).hasShowTimestamp()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        s sVar = new s(arrayList, arrayList2);
        List list = (List) sVar.a();
        List list2 = (List) sVar.b();
        CampaignStateKt.Dsl.Companion companion = CampaignStateKt.Dsl.Companion;
        CampaignStateOuterClass.CampaignState.Builder builderNewBuilder = CampaignStateOuterClass.CampaignState.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        CampaignStateKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.addAllShownCampaigns(dsl_create.getShownCampaigns(), list);
        dsl_create.addAllLoadedCampaigns(dsl_create.getLoadedCampaigns(), list2);
        return dsl_create._build();
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void removeState(@NotNull ByteString opportunityId) {
        Map<String, CampaignStateOuterClass.Campaign> value;
        String stringUtf8;
        t.i(opportunityId, "opportunityId");
        y<Map<String, CampaignStateOuterClass.Campaign>> yVar = this.campaigns;
        do {
            value = yVar.getValue();
            stringUtf8 = opportunityId.toStringUtf8();
            t.h(stringUtf8, "opportunityId.toStringUtf8()");
        } while (!yVar.d(value, r0.k(value, stringUtf8)));
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void setCampaign(@NotNull ByteString opportunityId, @NotNull CampaignStateOuterClass.Campaign campaign) {
        Map<String, CampaignStateOuterClass.Campaign> value;
        t.i(opportunityId, "opportunityId");
        t.i(campaign, "campaign");
        y<Map<String, CampaignStateOuterClass.Campaign>> yVar = this.campaigns;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, r0.o(value, v8.y.a(opportunityId.toStringUtf8(), campaign))));
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void setLoadTimestamp(@NotNull ByteString opportunityId) {
        t.i(opportunityId, "opportunityId");
        CampaignStateOuterClass.Campaign campaign = getCampaign(opportunityId);
        if (campaign != null) {
            CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.Companion;
            CampaignStateOuterClass.Campaign.Builder builder = campaign.toBuilder();
            t.h(builder, "this.toBuilder()");
            CampaignKt.Dsl dsl_create = companion._create(builder);
            dsl_create.setLoadTimestamp(this.getSharedDataTimestamps.invoke());
            k0 k0Var = k0.f35197a;
            setCampaign(opportunityId, dsl_create._build());
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void setShowTimestamp(@NotNull ByteString opportunityId) {
        t.i(opportunityId, "opportunityId");
        CampaignStateOuterClass.Campaign campaign = getCampaign(opportunityId);
        if (campaign != null) {
            CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.Companion;
            CampaignStateOuterClass.Campaign.Builder builder = campaign.toBuilder();
            t.h(builder, "this.toBuilder()");
            CampaignKt.Dsl dsl_create = companion._create(builder);
            dsl_create.setShowTimestamp(this.getSharedDataTimestamps.invoke());
            k0 k0Var = k0.f35197a;
            setCampaign(opportunityId, dsl_create._build());
        }
    }
}
