package com.moloco.sdk.publisher.init;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.publisher.MediationInfo;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class MolocoInitParams {
    public static final int $stable = 8;

    @NotNull
    private final Context appContext;

    @NotNull
    private final String appKey;

    @NotNull
    private final MediationInfo mediationInfo;

    public MolocoInitParams(@NotNull Context appContext, @NotNull String appKey, @NotNull MediationInfo mediationInfo) {
        t.i(appContext, "appContext");
        t.i(appKey, "appKey");
        t.i(mediationInfo, "mediationInfo");
        this.appContext = appContext;
        this.appKey = appKey;
        this.mediationInfo = mediationInfo;
    }

    public static /* synthetic */ MolocoInitParams copy$default(MolocoInitParams molocoInitParams, Context context, String str, MediationInfo mediationInfo, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = molocoInitParams.appContext;
        }
        if ((i10 & 2) != 0) {
            str = molocoInitParams.appKey;
        }
        if ((i10 & 4) != 0) {
            mediationInfo = molocoInitParams.mediationInfo;
        }
        return molocoInitParams.copy(context, str, mediationInfo);
    }

    @NotNull
    public final Context component1() {
        return this.appContext;
    }

    @NotNull
    public final String component2() {
        return this.appKey;
    }

    @NotNull
    public final MediationInfo component3() {
        return this.mediationInfo;
    }

    @NotNull
    public final MolocoInitParams copy(@NotNull Context appContext, @NotNull String appKey, @NotNull MediationInfo mediationInfo) {
        t.i(appContext, "appContext");
        t.i(appKey, "appKey");
        t.i(mediationInfo, "mediationInfo");
        return new MolocoInitParams(appContext, appKey, mediationInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MolocoInitParams)) {
            return false;
        }
        MolocoInitParams molocoInitParams = (MolocoInitParams) obj;
        return t.d(this.appContext, molocoInitParams.appContext) && t.d(this.appKey, molocoInitParams.appKey) && t.d(this.mediationInfo, molocoInitParams.mediationInfo);
    }

    @NotNull
    public final Context getAppContext() {
        return this.appContext;
    }

    @NotNull
    public final String getAppKey() {
        return this.appKey;
    }

    @NotNull
    public final MediationInfo getMediationInfo() {
        return this.mediationInfo;
    }

    public int hashCode() {
        return (((this.appContext.hashCode() * 31) + this.appKey.hashCode()) * 31) + this.mediationInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "MolocoInitParams(appContext=" + this.appContext + ", appKey=" + this.appKey + ", mediationInfo=" + this.mediationInfo + ')';
    }
}
