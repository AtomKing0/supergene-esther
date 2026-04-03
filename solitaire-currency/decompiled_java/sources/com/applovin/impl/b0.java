package com.applovin.impl;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SensorManager f4877a = (SensorManager) com.applovin.impl.sdk.j.n().getSystemService("sensor");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f4878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4879c;

    public b0(com.applovin.impl.sdk.j jVar) {
        boolean zBooleanValue = ((Boolean) jVar.a(l4.Y)).booleanValue();
        this.f4879c = zBooleanValue;
        if (zBooleanValue) {
            HandlerThread handlerThread = new HandlerThread("AppLovinSdk:background_sensor_manager");
            handlerThread.start();
            this.f4878b = new Handler(handlerThread.getLooper());
        }
    }

    public Sensor a(int i10) {
        return this.f4877a.getDefaultSensor(i10);
    }

    public void b(final SensorEventListener sensorEventListener, final Sensor sensor, final int i10) {
        if (this.f4879c) {
            this.f4878b.post(new Runnable() { // from class: com.applovin.impl.m8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5891a.a(sensorEventListener, sensor, i10);
                }
            });
        } else {
            this.f4877a.registerListener(sensorEventListener, sensor, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SensorEventListener sensorEventListener, Sensor sensor, int i10) {
        this.f4877a.registerListener(sensorEventListener, sensor, i10, this.f4878b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SensorEventListener sensorEventListener) {
        this.f4877a.unregisterListener(sensorEventListener);
    }

    public void b(final SensorEventListener sensorEventListener) {
        if (this.f4879c) {
            this.f4878b.post(new Runnable() { // from class: com.applovin.impl.l8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5823a.a(sensorEventListener);
                }
            });
        } else {
            this.f4877a.unregisterListener(sensorEventListener);
        }
    }
}
