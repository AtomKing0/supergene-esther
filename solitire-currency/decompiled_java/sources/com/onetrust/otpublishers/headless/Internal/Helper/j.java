package com.onetrust.otpublishers.headless.Internal.Helper;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class j {
    public static void a(Exception exc, StringBuilder sb, String str, int i10) {
        sb.append(exc.getMessage());
        OTLogger.a(str, i10, sb.toString());
    }
}
