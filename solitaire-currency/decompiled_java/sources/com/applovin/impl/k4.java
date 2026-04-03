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
public class k4 implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b0 f5539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Sensor f5540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Sensor f5541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f5543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f5544h;

    public k4(com.applovin.impl.sdk.j jVar) {
        this.f5542f = jVar;
        b0 b0Var = new b0(jVar);
        this.f5539c = b0Var;
        this.f5540d = b0Var.a(9);
        this.f5541e = b0Var.a(4);
        this.f5537a = ((Integer) jVar.a(l4.R3)).intValue();
        this.f5538b = ((Float) jVar.a(l4.Q3)).floatValue();
    }

    private void a(Sensor sensor) {
        try {
            this.f5539c.b(this, sensor, (int) TimeUnit.MILLISECONDS.toMicros(this.f5537a));
        } catch (Throwable th) {
            this.f5542f.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5542f.I().a("SensorDataManager", "Unable to register sensor listener", th);
            }
        }
    }

    public float b() {
        return this.f5544h;
    }

    public void c() {
        if (Boolean.parseBoolean(this.f5542f.g0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.f5539c.b(this);
        if (((Boolean) this.f5542f.h0().a(l4.O3)).booleanValue()) {
            a(this.f5540d);
        }
        if (((Boolean) this.f5542f.h0().a(l4.P3)).booleanValue()) {
            a(this.f5541e);
        }
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f5539c.b(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            c();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f5543g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f10 = this.f5544h * this.f5538b;
            this.f5544h = f10;
            this.f5544h = f10 + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }

    public float a() {
        if (this.f5543g == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos(r0[2] / 9.81f));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
