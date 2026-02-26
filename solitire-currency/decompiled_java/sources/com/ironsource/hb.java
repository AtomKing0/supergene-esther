package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class hb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final hb f12462a = new hb();

    private hb() {
    }

    @NotNull
    public final IronSourceError a() {
        return a(this, df.ISErrorInitDecryptionFailure, null, 2, null);
    }

    @NotNull
    public final IronSourceError b() {
        return a(this, df.ISErrorInitHttpRequestFailed, null, 2, null);
    }

    @NotNull
    public final IronSourceError c() {
        return a(this, df.ISErrorInitInvalidResponse, null, 2, null);
    }

    @NotNull
    public final IronSourceError d() {
        return a(this, df.ISErrorLoadADMDecryptionFailure, null, 2, null);
    }

    @NotNull
    public final IronSourceError e() {
        return a(this, df.ISErrorLoadADMEmptyServerData, null, 2, null);
    }

    @NotNull
    public final IronSourceError f() {
        return a(this, df.ISErrorLoadADMEmptyWaterfall, null, 2, null);
    }

    @NotNull
    public final IronSourceError g() {
        return a(this, df.ISErrorLoadADMInvalidConfigurationForRequestedNetwork, null, 2, null);
    }

    @NotNull
    public final IronSourceError h() {
        return a(this, df.ISErrorLoadADMInvalidJSON, null, 2, null);
    }

    @NotNull
    public final IronSourceError i() {
        return a(this, df.ISErrorLoadADMNoAuctionID, null, 2, null);
    }

    @NotNull
    public final IronSourceError j() {
        return a(this, df.ISErrorLoadADMNoConfigurationForRequestedNetwork, null, 2, null);
    }

    @NotNull
    public final IronSourceError k() {
        return a(this, df.ISErrorLoadBannerNetworkViewIsNull, null, 2, null);
    }

    @NotNull
    public final IronSourceError l() {
        return a(this, df.ISErrorLoadBannerNotSupportedSize, null, 2, null);
    }

    @NotNull
    public final IronSourceError m() {
        return a(this, df.ISErrorLoadBannerSizeIsNull, null, 2, null);
    }

    @NotNull
    public final IronSourceError n() {
        return a(this, df.ISErrorLoadBiddingInNonBidding, null, 2, null);
    }

    @NotNull
    public final IronSourceError o() {
        return a(this, df.ISErrorLoadInstanceNotInInitResponse, null, 2, null);
    }

    @NotNull
    public final IronSourceError p() {
        return a(this, df.ISErrorLoadNoAdFormatConfigurations, null, 2, null);
    }

    @NotNull
    public final IronSourceError q() {
        return a(this, df.ISErrorLoadNullADM, null, 2, null);
    }

    @NotNull
    public final IronSourceError r() {
        return a(this, df.ISErrorLoadSDKNotInitialized, null, 2, null);
    }

    @NotNull
    public final IronSourceError s() {
        return a(this, df.ISErrorLoadTimedOut, null, 2, null);
    }

    @NotNull
    public final IronSourceError t() {
        return a(this, df.ISErrorShowNotReadyToShowAd, null, 2, null);
    }

    private final IronSourceError a(df dfVar, IronSourceError ironSourceError) {
        String strC;
        if (ironSourceError != null) {
            strC = dfVar.c() + " Underlying network error: '" + ironSourceError.getErrorCode() + ':' + ironSourceError.getErrorMessage() + '\'';
        } else {
            strC = dfVar.c();
        }
        return new IronSourceError(dfVar.b(), strC);
    }

    public static /* synthetic */ IronSourceError b(hb hbVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return hbVar.b(str);
    }

    public static /* synthetic */ IronSourceError c(hb hbVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return hbVar.d(str);
    }

    @NotNull
    public final IronSourceError d(@Nullable String str) {
        return a(df.ISErrorRewardedLoadNoConfig, str);
    }

    private final IronSourceError a(df dfVar, String str) {
        if (str == null || str.length() == 0) {
            str = dfVar.c();
        }
        return new IronSourceError(dfVar.b(), str);
    }

    @NotNull
    public final IronSourceError b(@NotNull IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        return a(df.ISErrorLoadNetworkFailed, error);
    }

    @NotNull
    public final IronSourceError c(@NotNull IronSourceError networkError) {
        kotlin.jvm.internal.t.i(networkError, "networkError");
        return a(df.ISErrorShowNetworkFailed, networkError);
    }

    static /* synthetic */ IronSourceError a(hb hbVar, df dfVar, IronSourceError ironSourceError, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            ironSourceError = null;
        }
        return hbVar.a(dfVar, ironSourceError);
    }

    @NotNull
    public final IronSourceError b(@Nullable String str) {
        return a(df.ISErrorInterstitialLoadNoConfig, str);
    }

    @NotNull
    public final IronSourceError c(@NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        return a(df.ISErrorLoadNetworkFailed, description);
    }

    public static /* synthetic */ IronSourceError a(hb hbVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return hbVar.a(str);
    }

    @NotNull
    public final IronSourceError a(@NotNull IronSourceError networkError) {
        kotlin.jvm.internal.t.i(networkError, "networkError");
        return a(df.ISErrorInitNetworkFailed, networkError);
    }

    @NotNull
    public final IronSourceError a(@Nullable String str) {
        return a(df.ISErrorBannerLoadNoConfig, str);
    }
}
