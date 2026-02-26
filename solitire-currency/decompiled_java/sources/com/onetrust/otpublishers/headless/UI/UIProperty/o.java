package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f22787a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22790d;

    @NonNull
    public final String a() {
        String str = this.f22790d;
        return str != null ? str : "activate";
    }

    @NonNull
    public final String toString() {
        StringBuilder sbA = n.a(this.f22787a, new StringBuilder("LinkProperty{linkTextProperty="), "url=");
        sbA.append(this.f22788b);
        sbA.append("actionDescription=");
        sbA.append(this.f22790d);
        sbA.append('}');
        return sbA.toString();
    }
}
