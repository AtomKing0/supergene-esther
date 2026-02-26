package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f22818c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f22819d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f22820e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f22821f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f22822g = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f22823h = new h();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f22824i = new f();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f22825j = new f();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f22826k = new f();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o f22827l = new o();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o f22828m = new o();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p f22829n = new p();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22830o = true;

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("OTBannerUIProperty{backgroundColor='");
        sb.append(this.f22816a);
        sb.append("', layoutHeight='");
        sb.append(this.f22817b);
        sb.append("', summaryTitleTextProperty=");
        StringBuilder sbA = n.a(this.f22822g, n.a(this.f22821f, n.a(this.f22820e, n.a(this.f22819d, n.a(this.f22818c, sb, ", iabTitleTextProperty="), ", summaryTitleDescriptionTextProperty="), ", iabTitleDescriptionTextProperty="), ", summaryAdditionalDescriptionTextProperty="), ", acceptAllButtonProperty=");
        sbA.append(this.f22824i.toString());
        sbA.append(", rejectAllButtonProperty=");
        sbA.append(this.f22825j.toString());
        sbA.append(", closeButtonProperty=");
        sbA.append(this.f22823h.toString());
        sbA.append(", showPreferencesButtonProperty=");
        sbA.append(this.f22826k.toString());
        sbA.append(", policyLinkProperty=");
        sbA.append(this.f22827l.toString());
        sbA.append(", vendorListLinkProperty=");
        sbA.append(this.f22828m.toString());
        sbA.append(", logoProperty=");
        sbA.append(this.f22829n.toString());
        sbA.append(", applyUIProperty=");
        sbA.append(this.f22830o);
        sbA.append('}');
        return sbA.toString();
    }
}
