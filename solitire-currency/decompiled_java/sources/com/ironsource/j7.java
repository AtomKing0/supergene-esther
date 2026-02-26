package com.ironsource;

import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n2;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class j7<Listener extends n2> extends g7<Listener> implements AdapterAdRewardListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ta f12711r;

    class a extends yp {
        a() {
        }

        @Override // com.ironsource.yp
        public void a() {
            j7.this.U();
        }
    }

    public j7(ko koVar, i1 i1Var, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, v2 v2Var, f5 f5Var, Listener listener) {
        super(koVar, i1Var, baseAdAdapter, v2Var, f5Var, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f12823g == null) {
            IronLog.INTERNAL.verbose(a("placement is null "));
            x1 x1Var = this.f12820d;
            if (x1Var != null) {
                x1Var.f16112k.f("mCurrentPlacement is null state = " + this.f12821e);
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(a("placement name = " + j()));
        if (this.f12820d != null) {
            HashMap map = new HashMap();
            if (com.ironsource.mediationsdk.p.m().s() != null) {
                for (String str : com.ironsource.mediationsdk.p.m().s().keySet()) {
                    map.put(ContentMetadata.KEY_CUSTOM_PREFIX + str, com.ironsource.mediationsdk.p.m().s().get(str));
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f12820d.f16111j.a(j(), this.f12823g.getRewardName(), this.f12823g.getRewardAmount(), jCurrentTimeMillis, IronSourceUtils.getTransId(jCurrentTimeMillis, c()), ta.a(this.f12711r), map, com.ironsource.mediationsdk.p.m().l());
        }
        ((n2) this.f12818b).a((j7<?>) this, this.f12823g);
    }

    @Override // com.ironsource.g7, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        this.f12711r = new ta();
        super.onAdClosed();
    }

    @Override // com.ironsource.k7, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        this.f12711r = null;
        super.onAdOpened();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        if (u().c()) {
            u().a(new a());
        } else {
            U();
        }
    }
}
