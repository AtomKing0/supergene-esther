package com.iab.omid.library.unity3d.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f10927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f10929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f10930e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f10926a = context;
        this.f10927b = (AudioManager) context.getSystemService("audio");
        this.f10928c = aVar;
        this.f10929d = cVar;
    }

    private float a() {
        return this.f10928c.a(this.f10927b.getStreamVolume(3), this.f10927b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f10929d.a(this.f10930e);
    }

    public void c() {
        this.f10930e = a();
        b();
        this.f10926a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f10926a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float fA = a();
        if (a(fA)) {
            this.f10930e = fA;
            b();
        }
    }

    private boolean a(float f10) {
        return f10 != this.f10930e;
    }
}
