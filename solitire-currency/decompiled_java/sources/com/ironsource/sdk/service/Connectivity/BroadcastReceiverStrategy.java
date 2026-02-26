package com.ironsource.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.s8;
import com.ironsource.yd;
import com.ironsource.zd;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BroadcastReceiverStrategy implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zd f15293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f15294b = new BroadcastReceiver() { // from class: com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String strB = s8.b(context);
            if (strB.equals("none")) {
                BroadcastReceiverStrategy.this.f15293a.a();
            } else {
                BroadcastReceiverStrategy.this.f15293a.a(strB, new JSONObject());
            }
        }
    };

    public BroadcastReceiverStrategy(zd zdVar) {
        this.f15293a = zdVar;
    }

    @Override // com.ironsource.yd
    public void b(Context context) {
        try {
            context.registerReceiver(this.f15294b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.yd
    public JSONObject c(Context context) {
        return new JSONObject();
    }

    @Override // com.ironsource.yd
    public void a() {
        this.f15294b = null;
    }

    @Override // com.ironsource.yd
    public void a(Context context) {
        try {
            context.unregisterReceiver(this.f15294b);
        } catch (IllegalArgumentException e10) {
            i9.d().a(e10);
        } catch (Exception e11) {
            i9.d().a(e11);
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e11);
        }
    }
}
