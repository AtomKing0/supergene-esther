package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.services.core.configuration.ExperimentsBase;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: AndroidBoldExperimentHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidBoldExperimentHandler implements BoldExperimentHandler {

    @NotNull
    public static final String BOLD_VERSION = "version";

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String EXPO_NODE_NAME = "expo";

    @NotNull
    private final ByteStringDataSource gatewayCacheDataSource;

    @NotNull
    private final k0 ioDispatcher;

    /* JADX INFO: compiled from: AndroidBoldExperimentHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public AndroidBoldExperimentHandler(@NotNull ByteStringDataSource gatewayCacheDataSource, @NotNull k0 ioDispatcher) {
        t.i(gatewayCacheDataSource, "gatewayCacheDataSource");
        t.i(ioDispatcher, "ioDispatcher");
        this.gatewayCacheDataSource = gatewayCacheDataSource;
        this.ioDispatcher = ioDispatcher;
    }

    @Override // com.unity3d.ads.core.domain.BoldExperimentHandler
    public void invoke(@NotNull String configData) {
        t.i(configData, "configData");
        Object objOpt = new JSONObject(configData).opt(EXPO_NODE_NAME);
        JSONObject jSONObject = objOpt instanceof JSONObject ? (JSONObject) objOpt : null;
        Object objOpt2 = jSONObject != null ? jSONObject.opt(ExperimentsBase.EXP_TAG_IS_BOLD_NEXT_SESSION) : null;
        JSONObject jSONObject2 = objOpt2 instanceof JSONObject ? (JSONObject) objOpt2 : null;
        Object objOpt3 = jSONObject2 != null ? jSONObject2.opt("version") : null;
        String str = objOpt3 instanceof String ? (String) objOpt3 : null;
        if (str != null) {
            kotlinx.coroutines.k.d(p0.a(this.ioDispatcher), null, null, new AndroidBoldExperimentHandler$invoke$1$1(this, str, null), 3, null);
        }
    }
}
