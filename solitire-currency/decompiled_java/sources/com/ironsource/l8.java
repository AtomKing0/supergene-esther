package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes4.dex */
public class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12990a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IronSourceError f12991b = null;

    public IronSourceError a() {
        return this.f12991b;
    }

    public boolean b() {
        return this.f12990a;
    }

    public void c() {
        this.f12990a = true;
        this.f12991b = null;
    }

    public String toString() {
        StringBuilder sb;
        if (b()) {
            sb = new StringBuilder();
            sb.append("valid:");
            sb.append(this.f12990a);
        } else {
            sb = new StringBuilder();
            sb.append("valid:");
            sb.append(this.f12990a);
            sb.append(", IronSourceError:");
            sb.append(this.f12991b);
        }
        return sb.toString();
    }

    public void a(IronSourceError ironSourceError) {
        this.f12990a = false;
        this.f12991b = ironSourceError;
    }
}
