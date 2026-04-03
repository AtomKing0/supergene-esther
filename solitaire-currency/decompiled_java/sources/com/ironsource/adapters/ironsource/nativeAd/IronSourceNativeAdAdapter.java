package com.ironsource.adapters.ironsource.nativeAd;

import android.app.Activity;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.adapters.ironsource.nativeAd.IronSourceNativeAdAdapter;
import com.ironsource.bg;
import com.ironsource.environment.ContextProvider;
import com.ironsource.i9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.v8;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class IronSourceNativeAdAdapter extends AbstractNativeAdAdapter<IronSourceAdapter> {

    @Nullable
    private bg nativeAd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IronSourceNativeAdAdapter(@NotNull IronSourceAdapter adapter) {
        super(adapter);
        t.i(adapter, "adapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadNativeAdForBidding$lambda$0(IronSourceNativeAdAdapter this$0, JSONObject config, NativeAdSmashListener listener, String str) {
        t.i(this$0, "this$0");
        t.i(config, "$config");
        t.i(listener, "$listener");
        try {
            bg bgVarA = bg.f11400j.a();
            bgVarA.a(new IronSourceNativeAdListener(new IronSourceNativeAdViewBinder(bgVarA, this$0.getNativeAdProperties(config)), listener));
            Activity activity = ContextProvider.getInstance().getCurrentActiveActivity();
            JSONObject jSONObjectPrepareLoadParams = this$0.prepareLoadParams(config, str);
            t.h(activity, "activity");
            bgVarA.a(activity, jSONObjectPrepareLoadParams);
            this$0.nativeAd = bgVarA;
        } catch (Exception e10) {
            i9.d().a(e10);
            listener.onNativeAdLoadFailed(new IronSourceError(510, "IronSourceAdapter loadNativeAd exception " + e10.getMessage()));
        }
    }

    private final JSONObject prepareLoadParams(JSONObject jSONObject, String str) throws JSONException {
        JSONObject loadParams = new JSONObject().put("demandSourceName", getAdapter().getDemandSourceName(jSONObject)).put(v8.f15667r, "2").put("inAppBidding", true).put(getAdapter().ADM_KEY, d.b().a(str));
        HashMap<String, String> extraParams = getAdapter().getInitParams();
        t.h(extraParams, "extraParams");
        for (Map.Entry<String, String> entry : extraParams.entrySet()) {
            loadParams.put(entry.getKey(), entry.getValue());
        }
        t.h(loadParams, "loadParams");
        return loadParams;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void destroyNativeAd(@NotNull JSONObject config) {
        t.i(config, "config");
        bg bgVar = this.nativeAd;
        if (bgVar != null) {
            bgVar.destroy();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    @Nullable
    public Map<String, Object> getNativeAdBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject) {
        t.i(config, "config");
        return new HashMap();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAdForBidding(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull NativeAdSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
        getAdapter().initSDK(str, config);
        listener.onNativeAdInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAdForBidding(@NotNull final JSONObject config, @Nullable JSONObject jSONObject, @Nullable final String str, @NotNull final NativeAdSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
        postOnUIThread(new Runnable() { // from class: h6.a
            @Override // java.lang.Runnable
            public final void run() {
                IronSourceNativeAdAdapter.loadNativeAdForBidding$lambda$0(this.f26466a, config, listener, str);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(@NotNull IronSource.AD_UNIT adUnit, @Nullable JSONObject jSONObject) {
        t.i(adUnit, "adUnit");
    }
}
