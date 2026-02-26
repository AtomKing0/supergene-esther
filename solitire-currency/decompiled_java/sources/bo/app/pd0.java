package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.StringUtils;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public final class pd0 {
    public static SharedPreferences a(cs dispatchDataProvider) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
        kotlin.jvm.internal.t.i("com.braze.requestframework.tokenbucket", "filePrefix");
        kotlin.jvm.internal.t.i("", "specificName");
        ci0 ci0Var = (ci0) dispatchDataProvider.f2596a;
        Context context = ci0Var.f2549a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.requestframework.tokenbucket." + StringUtils.getCacheFileSuffix(context, ci0Var.f2554f, ci0Var.f2555g), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ODE_PRIVATE\n            )");
        return sharedPreferences;
    }
}
