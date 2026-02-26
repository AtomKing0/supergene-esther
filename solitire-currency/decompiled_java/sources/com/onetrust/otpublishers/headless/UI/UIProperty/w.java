package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f22839g = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f22840h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f22841i = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f22842j = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f22843k = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f22844l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o f22845m = new o();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f22846n = new o();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o f22847o = new o();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m f22848p = new m();

    @Nullable
    public final String a() {
        return this.f22836d;
    }

    @Nullable
    public final String b() {
        return this.f22835c;
    }

    @Nullable
    public final String c() {
        return this.f22837e;
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("OTPCDetailsUIProperty{backgroundColor='");
        sb.append(this.f22833a);
        sb.append("', lineBreakColor='");
        sb.append(this.f22834b);
        sb.append("', toggleThumbColorOn='");
        sb.append(this.f22835c);
        sb.append("', toggleThumbColorOff='");
        sb.append(this.f22836d);
        sb.append("', toggleTrackColor='");
        sb.append(this.f22837e);
        sb.append("', summaryTitleTextProperty=");
        StringBuilder sbA = n.a(this.f22844l, n.a(this.f22843k, n.a(this.f22842j, n.a(this.f22841i, n.a(this.f22839g, sb, ", summaryTitleDescriptionTextProperty="), ", consentTitleTextProperty="), ", legitInterestTitleTextProperty="), ", alwaysActiveTextProperty="), ", sdkListLinkProperty=");
        sbA.append(this.f22845m.toString());
        sbA.append(", vendorListLinkProperty=");
        sbA.append(this.f22846n.toString());
        sbA.append(", fullLegalTextLinkProperty=");
        sbA.append(this.f22847o.toString());
        sbA.append(", backIconProperty=");
        sbA.append(this.f22848p.toString());
        sbA.append('}');
        return sbA.toString();
    }
}
