package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.qi;
import com.ironsource.xp;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SSAFactory {
    public static xp getPublisherInstance(Activity activity) throws Exception {
        return qi.a((Context) activity);
    }

    public static xp getPublisherTestInstance(Activity activity, int i10) throws Exception {
        return qi.a(activity, i10);
    }
}
