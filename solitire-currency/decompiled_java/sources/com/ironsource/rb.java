package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* JADX INFO: loaded from: classes4.dex */
class rb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f14671a = "ironbeast";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f14672b = "outcome";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f14673c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f14674d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f14675e = 0;

    rb() {
    }

    static e a(String str, int i10) {
        if (f14671a.equals(str)) {
            return new gj(i10);
        }
        if (f14672b.equals(str)) {
            return new nn(i10);
        }
        if (i10 == 2) {
            return new gj(i10);
        }
        if (i10 == 3) {
            return new nn(i10);
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NATIVE, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i10 + ")", 2);
        return null;
    }
}
