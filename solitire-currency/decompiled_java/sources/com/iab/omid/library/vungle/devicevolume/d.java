package com.iab.omid.library.vungle.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f11054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f11055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f11056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f11057e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f11053a = context;
        this.f11054b = (AudioManager) context.getSystemService("audio");
        this.f11055c = aVar;
        this.f11056d = cVar;
    }

    private float a() {
        return this.f11055c.a(this.f11054b.getStreamVolume(3), this.f11054b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f11056d.a(this.f11057e);
    }

    public void c() {
        this.f11057e = a();
        b();
        this.f11053a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f11053a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float fA = a();
        if (a(fA)) {
            this.f11057e = fA;
            b();
        }
    }

    private boolean a(float f10) {
        return f10 != this.f11057e;
    }
}
