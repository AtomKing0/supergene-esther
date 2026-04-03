package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements u {
    @Override // com.moloco.sdk.internal.services.bidtoken.u
    @NotNull
    public MolocoPrivacy.PrivacySettings getPrivacy() {
        return MolocoPrivacy.INSTANCE.getPrivacySettings();
    }
}
