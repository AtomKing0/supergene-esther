package com.unity3d.ads.core.domain.privacy;

import com.unity3d.services.core.misc.JsonFlattenerRules;
import kotlin.collections.u;
import kotlin.collections.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LegacyUserConsentFlattenerRulesUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LegacyUserConsentFlattenerRulesUseCase implements FlattenerRulesUseCase {
    @Override // com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase
    @NotNull
    public JsonFlattenerRules invoke() {
        return new JsonFlattenerRules(v.q("privacy", "unity", "pipl"), u.e("value"), v.q("ts", "exclude", "pii", "nonBehavioral", "nonbehavioral"));
    }
}
