package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    public static boolean a(@NonNull Context context, @NonNull OTUXParams oTUXParams) {
        boolean z10;
        if (oTUXParams.getUxParam() != null) {
            com.onetrust.otpublishers.headless.Internal.c.g(context, oTUXParams.getUxParam());
            z10 = true;
        } else {
            z10 = false;
        }
        if (oTUXParams.getOTSDKTheme() != null) {
            com.onetrust.otpublishers.headless.Internal.c.p(context, oTUXParams.getOTSDKTheme());
        }
        return z10;
    }
}
