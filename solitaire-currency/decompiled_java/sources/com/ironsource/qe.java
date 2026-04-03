package com.ironsource;

import android.content.Context;
import com.ironsource.fo;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.BasePlacement;

/* JADX INFO: loaded from: classes4.dex */
public interface qe {

    public interface a {
        void a(Context context, String str, IronSource.AD_UNIT ad_unit);

        void c(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit);
    }

    fo.b a(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit);

    boolean b(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit);
}
