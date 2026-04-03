package com.iab.omid.library.applovin.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f10666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f10668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f10669e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f10665a = context;
        this.f10666b = (AudioManager) context.getSystemService("audio");
        this.f10667c = aVar;
        this.f10668d = cVar;
    }

    private float a() {
        return this.f10667c.a(this.f10666b.getStreamVolume(3), this.f10666b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f10668d.a(this.f10669e);
    }

    public void c() {
        this.f10669e = a();
        b();
        this.f10665a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f10665a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float fA = a();
        if (a(fA)) {
            this.f10669e = fA;
            b();
        }
    }

    private boolean a(float f10) {
        return f10 != this.f10669e;
    }
}
