package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f22709e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f22710f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f22711g = new f();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.c> f22712h = new ArrayList<>();

    @NonNull
    public final ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.c> a() {
        return this.f22712h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OTConsentPreferencesUIProperty{show='");
        sb.append(this.f22705a);
        sb.append("', backgroundColor='null', titleTextProperty=");
        StringBuilder sbA = n.a(this.f22710f, n.a(this.f22709e, sb, ", descriptionTextProperty="), ", showOTLogo=");
        sbA.append(this.f22708d);
        sbA.append(", saveChoicesButtonProperty=");
        sbA.append(this.f22711g.toString());
        sbA.append(", otConsentPreferencesPurposeModelHashSet=");
        sbA.append(this.f22712h);
        sbA.append('}');
        return sbA.toString();
    }
}
