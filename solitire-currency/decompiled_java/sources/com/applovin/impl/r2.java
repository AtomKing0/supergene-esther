package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.y1;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r2 extends z1 {
    public r2(com.applovin.impl.sdk.j jVar) {
        super(jVar, y1.b.MEDIATED_AD);
    }

    public void a(y1 y1Var, q2 q2Var) {
        a(y1Var, q2Var, new HashMap());
    }

    public void a(y1 y1Var, q2 q2Var, Map map) {
        a(y1Var, q2Var.getFormat(), q2Var.getAdUnitId(), q2Var, null, map);
    }

    public void a(y1 y1Var, q2 q2Var, MaxError maxError) {
        a(y1Var, q2Var.getFormat(), q2Var.getAdUnitId(), q2Var, maxError, new HashMap());
    }

    public void a(y1 y1Var, MaxAdFormat maxAdFormat, String str, MaxError maxError) {
        a(y1Var, maxAdFormat, str, null, maxError, new HashMap());
    }

    private void a(y1 y1Var, MaxAdFormat maxAdFormat, String str, q2 q2Var, MaxError maxError, Map map) {
        if (q2Var != null) {
            map.putAll(a2.a(q2Var));
        } else {
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map);
        }
        if (maxError != null) {
            a2.a(maxError);
        }
        d(y1Var, map);
    }
}
