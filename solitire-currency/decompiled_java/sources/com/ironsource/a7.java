package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
class a7 extends i2 {
    a7(g2 g2Var, @NotNull xk xkVar) {
        super(g2Var, xkVar);
    }

    private boolean n() {
        return b().b() > 0;
    }

    private boolean p() {
        return b().d() >= 0;
    }

    void l() {
        if (o()) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    void m() {
        if (o()) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    boolean o() {
        return b().a() == g2.a.MANUAL_WITH_LOAD_ON_SHOW;
    }

    void q() {
        if (o() && d()) {
            IronLog.INTERNAL.verbose();
            a(b().c());
        }
    }

    void r() {
        if (!n()) {
            IronLog.INTERNAL.verbose("banner reload interval is disabled");
        } else if (o() && p()) {
            IronLog.INTERNAL.verbose();
            a(b().d());
        }
    }
}
