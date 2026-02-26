package com.unity3d.ads.core.data.datasource;

import com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase;
import com.unity3d.services.core.misc.JsonFlattener;
import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: AndroidLegacyUserConsentDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidLegacyUserConsentDataSource implements LegacyUserConsentDataSource {

    @NotNull
    private final FlattenerRulesUseCase flattenerRulesUseCase;

    @NotNull
    private final JsonStorage privateStorage;

    public AndroidLegacyUserConsentDataSource(@NotNull FlattenerRulesUseCase flattenerRulesUseCase, @NotNull JsonStorage privateStorage) {
        t.i(flattenerRulesUseCase, "flattenerRulesUseCase");
        t.i(privateStorage, "privateStorage");
        this.flattenerRulesUseCase = flattenerRulesUseCase;
        this.privateStorage = privateStorage;
    }

    @Override // com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource
    @Nullable
    public String getPrivacyData() {
        JSONObject jSONObjectFlattenJson;
        JSONObject data = this.privateStorage.getData();
        if (data == null || (jSONObjectFlattenJson = new JsonFlattener(data).flattenJson(".", this.flattenerRulesUseCase.invoke())) == null) {
            return null;
        }
        return jSONObjectFlattenJson.toString();
    }
}
