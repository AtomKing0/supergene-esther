package com.moloco.sdk.internal.client_metrics_data;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum c {
    SDKInit("sdk_init_time"),
    SDKPerformInitAttempt("sdk_perform_init_time_ms"),
    SDKInitHttpRequest("sdk_init_request_time_ms"),
    SDKInitCacheRead("sdk_init_cache_read_time_ms"),
    SDKInitCacheWrite("sdk_init_cache_write_time_ms"),
    SDKInitCacheClear("sdk_init_cache_clear_time_ms"),
    CreateAd("create_ad_time_ms"),
    CreateAdAwaitAdFactory("create_ad_await_ad_factory_time_ms"),
    LoadAd("load_ad_time"),
    NativePrepareAd("native_ad_load_prepare_time"),
    BidTokenFetch("bid_token_fetch_time"),
    ServerBidTokenFetch("sbt_fetch_time_ms"),
    ServerBidTokenApiFetchTime("sbt_api_fetch_time_ms"),
    ClientBidTokenBuild("bid_token_build_time_ms"),
    LoadToShow("load_to_show_time"),
    CreateToLoad("ad_create_to_load_ms");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17594a;

    c(String str) {
        this.f17594a = str;
    }

    @NotNull
    public final String c() {
        return this.f17594a;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.f17594a;
    }
}
