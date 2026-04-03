package com.iab.omid.library.activision.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f10531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f10533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f10534e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f10530a = context;
        this.f10531b = (AudioManager) context.getSystemService("audio");
        this.f10532c = aVar;
        this.f10533d = cVar;
    }

    private float a() {
        return this.f10532c.a(this.f10531b.getStreamVolume(3), this.f10531b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f10533d.a(this.f10534e);
    }

    public void c() {
        this.f10534e = a();
        b();
        this.f10530a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f10530a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float fA = a();
        if (a(fA)) {
            this.f10534e = fA;
            b();
        }
    }

    private boolean a(float f10) {
        return f10 != this.f10534e;
    }
}
