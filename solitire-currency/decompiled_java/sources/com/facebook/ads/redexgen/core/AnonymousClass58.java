package com.facebook.ads.redexgen.core;

import android.system.ErrnoException;
import android.system.OsConstants;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.58, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass58 {
    public static boolean A00(Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
