package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes4.dex */
public class HFPStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f23937a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioManager f23940d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f23938b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23939c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f23941e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23942f = 1;

    public HFPStatus(Context context) {
        this.f23940d = null;
        this.f23937a = context;
        this.f23940d = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    protected void clearHFPStat() {
        BroadcastReceiver broadcastReceiver = this.f23938b;
        if (broadcastReceiver != null) {
            this.f23937a.unregisterReceiver(broadcastReceiver);
            this.f23938b = null;
        }
        this.f23942f = 1;
        a();
    }

    protected boolean getHFPStat() {
        return this.f23942f == 2;
    }

    protected void requestHFPStat() {
        clearHFPStat();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) != 1) {
                    return;
                }
                HFPStatus hFPStatus = HFPStatus.this;
                hFPStatus.f23942f = 2;
                hFPStatus.a();
                HFPStatus hFPStatus2 = HFPStatus.this;
                if (hFPStatus2.f23939c) {
                    hFPStatus2.f23940d.setMode(3);
                }
            }
        };
        this.f23938b = broadcastReceiver;
        this.f23937a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f23941e = true;
            this.f23940d.startBluetoothSco();
        } catch (NullPointerException unused) {
            AbstractC3275z.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    protected void setHFPRecordingStat(boolean z10) {
        this.f23939c = z10;
        if (z10) {
            return;
        }
        this.f23940d.setMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f23941e) {
            this.f23941e = false;
            this.f23940d.stopBluetoothSco();
        }
    }

    public final void b() {
        clearHFPStat();
        deinitHFPStatusJni();
    }
}
