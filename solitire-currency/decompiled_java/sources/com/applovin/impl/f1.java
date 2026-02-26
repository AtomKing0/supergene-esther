package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class f1 implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b0 f5166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f5167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f5168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5169e;

    public interface a {
        void a();

        void b();
    }

    public f1(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f5165a = jVar;
        b0 b0Var = new b0(jVar);
        this.f5166b = b0Var;
        this.f5167c = b0Var.a(1);
        this.f5168d = aVar;
    }

    public void a() {
        if (Boolean.parseBoolean(this.f5165a.g0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.f5166b.b(this);
        this.f5166b.b(this, this.f5167c, (int) TimeUnit.MILLISECONDS.toMicros(50L));
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void b() {
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.f5166b.b(this);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f5166b.b(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            a();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float fMax = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f10 = this.f5169e;
            float f11 = (f10 * 0.5f) + (fMax * 0.5f);
            this.f5169e = f11;
            if (f10 < 0.8f && f11 > 0.8f) {
                this.f5168d.a();
            } else {
                if (f10 <= -0.8f || f11 >= -0.8f) {
                    return;
                }
                this.f5168d.b();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
