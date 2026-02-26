package com.ironsource.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.hj;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.lang.ref.WeakReference;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a<Listener extends AdapterAdListener> extends BaseAdAdapter<u, Listener> implements AdapterAdFullScreenInterface<Listener>, AdapterBannerInterface<Listener>, AdapterNativeAdInterface<Listener>, AdapterBindAdViewInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f13276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected WeakReference<Listener> f13277b;

    public a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        super(ad_unit, networkSettings, uuid);
        this.f13277b = new WeakReference<>(null);
        this.f13276a = abstractAdapter;
    }

    public static a<?> a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return new z(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return new o(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return new j(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return new t(abstractAdapter, networkSettings, uuid);
        }
        IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
        return null;
    }

    private void b(String str) {
        IronLog.INTERNAL.error(a("Method '" + str + "' is not supported for " + getClass().getName()));
    }

    protected abstract void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData);

    protected abstract IronSource.AD_UNIT b();

    public void c(JSONObject jSONObject) {
        b("onAdViewWillBind");
    }

    public void d(JSONObject jSONObject) {
        b("onAdViewWillBind");
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface
    public void destroyAd(@NotNull AdData adData) {
        a(hj.a(adData.getConfiguration()));
    }

    protected void e(JSONObject jSONObject) {
        b("showAd");
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public boolean isAdAvailable(@NotNull AdData adData) {
        return b(hj.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface
    public void loadAd(@NotNull AdData adData, @NotNull Activity activity, @NotNull ISBannerSize iSBannerSize, @NotNull Listener listener) {
        a(adData, listener);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface
    public void onAdViewBound(@NotNull AdData adData) {
        c(hj.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface
    public void onAdViewWillBind(@NotNull AdData adData) {
        d(hj.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter
    public void releaseMemory() {
        IronLog.INTERNAL.verbose(a());
        AbstractAdapter abstractAdapter = this.f13276a;
        if (abstractAdapter != null) {
            abstractAdapter.releaseMemory(b(), new JSONObject());
            this.f13276a = null;
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public void showAd(@NotNull AdData adData, @NotNull Listener listener) {
        this.f13277b = new WeakReference<>(listener);
        e(hj.a(adData.getConfiguration()));
    }

    protected String a() {
        return a((String) null);
    }

    protected boolean b(JSONObject jSONObject) {
        b("isAdAvailable");
        return false;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface
    public void loadAd(@NotNull AdData adData, @NotNull Activity activity, @NotNull Listener listener) {
        a(adData, listener);
    }

    protected String a(String str) {
        String string = b().toString();
        if (TextUtils.isEmpty(str)) {
            return string;
        }
        return string + " - " + str;
    }

    private void a(@NotNull AdData adData, @NotNull Listener listener) {
        this.f13277b = new WeakReference<>(listener);
        a(hj.a(adData.getConfiguration()), hj.a(adData.getAdUnitData()), adData);
    }

    protected void a(JSONObject jSONObject) {
        b("destroyAd");
    }
}
