package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22880e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f22885j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f22881f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f22882g = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f22883h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f22884i = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f22886k = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f22887l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f22888m = new f();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f22889n = new m();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f22890o = new k();

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("OTSDKListUIProperty{backgroundColor='");
        sb.append(this.f22876a);
        sb.append("', lineBreakColor='");
        sb.append(this.f22877b);
        sb.append("', filterOnColor='");
        sb.append(this.f22878c);
        sb.append("', filterOffColor='");
        sb.append(this.f22879d);
        sb.append("', summaryTitle=");
        StringBuilder sbA = n.a(this.f22882g, n.a(this.f22881f, sb, ", summaryDescription="), ", searchBarProperty=");
        sbA.append(this.f22884i.toString());
        sbA.append(", filterList_SelectionColor='");
        sbA.append(this.f22885j);
        sbA.append("', filterList_NavItem=");
        StringBuilder sbA2 = n.a(this.f22887l, n.a(this.f22886k, sbA, ", filterList_SDKItem="), ", backIconProperty=");
        sbA2.append(this.f22889n.toString());
        sbA2.append(", filterIconProperty=");
        sbA2.append(this.f22890o.toString());
        sbA2.append('}');
        return sbA2.toString();
    }
}
