package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f7069h = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f7070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f7072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f7073d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7074e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7076g;

    public interface a {
        void a(int i10);
    }

    h(j jVar) {
        this.f7072c = jVar;
        Context contextN = j.n();
        this.f7071b = contextN;
        this.f7070a = (AudioManager) contextN.getSystemService("audio");
    }

    public static boolean a(int i10) {
        return i10 == 0 || i10 == 1;
    }

    private void c() {
        this.f7072c.I();
        if (n.a()) {
            this.f7072c.I().a("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.f7071b.unregisterReceiver(this);
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            b(this.f7070a.getRingerMode());
        }
    }

    public int a() {
        return this.f7070a.getRingerMode();
    }

    public void b(a aVar) {
        synchronized (this.f7074e) {
            if (this.f7073d.contains(aVar)) {
                this.f7073d.remove(aVar);
                if (this.f7073d.isEmpty()) {
                    c();
                }
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f7074e) {
            if (this.f7073d.contains(aVar)) {
                return;
            }
            this.f7073d.add(aVar);
            if (this.f7073d.size() == 1) {
                b();
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f7075f = true;
            this.f7076g = this.f7070a.getRingerMode();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f7075f = false;
            if (this.f7076g != this.f7070a.getRingerMode()) {
                this.f7076g = f7069h;
                b(this.f7070a.getRingerMode());
            }
        }
    }

    private void b() {
        this.f7072c.I();
        if (n.a()) {
            this.f7072c.I().a("AudioSessionManager", "Observing ringer mode...");
        }
        this.f7076g = f7069h;
        this.f7071b.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    private void b(final int i10) {
        if (this.f7075f) {
            return;
        }
        this.f7072c.I();
        if (n.a()) {
            this.f7072c.I().a("AudioSessionManager", "Ringer mode is " + i10);
        }
        synchronized (this.f7074e) {
            for (final a aVar : this.f7073d) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.a(i10);
                    }
                });
            }
        }
    }
}
