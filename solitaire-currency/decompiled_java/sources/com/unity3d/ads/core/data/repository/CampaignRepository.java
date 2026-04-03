package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.CampaignStateOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CampaignRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface CampaignRepository {
    @Nullable
    CampaignStateOuterClass.Campaign getCampaign(@NotNull ByteString byteString);

    @NotNull
    CampaignStateOuterClass.CampaignState getCampaignState();

    void removeState(@NotNull ByteString byteString);

    void setCampaign(@NotNull ByteString byteString, @NotNull CampaignStateOuterClass.Campaign campaign);

    void setLoadTimestamp(@NotNull ByteString byteString);

    void setShowTimestamp(@NotNull ByteString byteString);
}
