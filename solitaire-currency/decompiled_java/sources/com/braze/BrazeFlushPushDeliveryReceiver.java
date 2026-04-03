package com.braze;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bo.app.na;
import bo.app.oa;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public class BrazeFlushPushDeliveryReceiver extends BroadcastReceiver {
    public static final na Companion = new na();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(intent, "intent");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new oa(intent), 7, (Object) null);
        if (kotlin.jvm.internal.t.d(intent.getAction(), "com.braze.FLUSH_PUSH_DELIVERY")) {
            BrazeInternal.INSTANCE.performPushDeliveryFlush(context);
        }
    }
}
