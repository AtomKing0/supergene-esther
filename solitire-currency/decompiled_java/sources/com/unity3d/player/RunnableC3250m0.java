package com.unity3d.player;

import android.content.Context;
import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: com.unity3d.player.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC3250m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f24147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f24149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f24150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f24151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f24152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f24153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f24154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f24155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f24156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Semaphore f24157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f24158m;

    RunnableC3250m0(UnityPlayer unityPlayer, UnityPlayer unityPlayer2, String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str2, int i11, boolean z14, boolean z15, Semaphore semaphore) {
        this.f24158m = unityPlayer;
        this.f24146a = unityPlayer2;
        this.f24147b = str;
        this.f24148c = i10;
        this.f24149d = z10;
        this.f24150e = z11;
        this.f24151f = z12;
        this.f24152g = z13;
        this.f24153h = str2;
        this.f24154i = i11;
        this.f24155j = z14;
        this.f24156k = z15;
        this.f24157l = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                UnityPlayer unityPlayer = this.f24158m;
                if (unityPlayer.mSoftInput != null) {
                    unityPlayer.dismissSoftInput();
                }
                UnityPlayer unityPlayer2 = this.f24158m;
                int iA = SoftInputProvider.a();
                Context context = this.f24158m.mContext;
                UnityPlayer unityPlayer3 = this.f24146a;
                unityPlayer2.mSoftInput = y6.a.a(iA) != 2 ? new C3230c0(context, unityPlayer3) : new X(context, unityPlayer3);
                this.f24158m.mSoftInput.a(this.f24147b, this.f24148c, this.f24149d, this.f24150e, this.f24151f, this.f24152g, this.f24153h, this.f24154i, this.f24155j, this.f24156k);
                S s10 = this.f24158m.mSoftInput;
                s10.f24006f = new C3248l0(this);
                s10.e();
                this.f24158m.nativeReportKeyboardConfigChanged();
            } catch (Exception e10) {
                AbstractC3275z.Log(6, "Exception when opening Softinput " + e10);
            }
        } finally {
            this.f24157l.release();
        }
    }
}
