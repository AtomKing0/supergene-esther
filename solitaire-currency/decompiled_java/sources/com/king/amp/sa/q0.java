package com.king.amp.sa;

import android.app.Activity;
import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/* JADX INFO: compiled from: AttitudeManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class q0 implements SensorEventListener, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f16858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f16859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f16860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Sensor f16861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f16862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f16863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f16864g = new float[3];

    q0(Activity activity) {
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.f16859b = sensorManager;
        this.f16860c = sensorManager.getDefaultSensor(1);
        this.f16861d = sensorManager.getDefaultSensor(2);
        this.f16858a = activity;
        activity.getApplication().registerActivityLifecycleCallbacks(this);
        onActivityResumed(this.f16858a);
    }

    private void b() {
        Activity activity = this.f16858a;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.f16858a = null;
        }
    }

    public float[] a() {
        float[] fArr;
        synchronized (this.f16864g) {
            fArr = (float[]) this.f16864g.clone();
        }
        return fArr;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity == this.f16858a) {
            this.f16859b.unregisterListener(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == this.f16858a) {
            this.f16859b.registerListener(this, this.f16860c, 2);
            this.f16859b.registerListener(this, this.f16861d, 2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        b();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent.sensor.getType() == 1) {
            this.f16862e = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() != 2) {
            return;
        } else {
            this.f16863f = (float[]) sensorEvent.values.clone();
        }
        float[] fArr2 = this.f16862e;
        if (fArr2 == null || (fArr = this.f16863f) == null) {
            return;
        }
        float[] fArr3 = new float[9];
        if (SensorManager.getRotationMatrix(fArr3, new float[9], fArr2, fArr)) {
            synchronized (this.f16864g) {
                SensorManager.getOrientation(fArr3, this.f16864g);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
