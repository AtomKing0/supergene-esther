package com.ironsource;

import android.app.Activity;
import com.ironsource.sdk.IronSourceNetwork;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class um implements tm {
    @Override // com.ironsource.tm
    public void a(@NotNull Activity activity, @NotNull mi adInstance, @NotNull Map<String, String> showParams) throws Exception {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(showParams, "showParams");
        IronSourceNetwork.showAd(activity, adInstance, showParams);
    }

    @Override // com.ironsource.tm
    public boolean a(@NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        return IronSourceNetwork.isAdAvailableForInstance(adInstance);
    }
}
