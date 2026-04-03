package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class g30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f2859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f2860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f2861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f2862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f2863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f2864g;

    public g30(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.f2858a = num;
        this.f2859b = num2;
        this.f2860c = num3;
        this.f2861d = num4;
        this.f2862e = num5;
        this.f2863f = num6;
        this.f2864g = num7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g30)) {
            return false;
        }
        g30 g30Var = (g30) obj;
        return kotlin.jvm.internal.t.d(this.f2858a, g30Var.f2858a) && kotlin.jvm.internal.t.d(this.f2859b, g30Var.f2859b) && kotlin.jvm.internal.t.d(this.f2860c, g30Var.f2860c) && kotlin.jvm.internal.t.d(this.f2861d, g30Var.f2861d) && kotlin.jvm.internal.t.d(this.f2862e, g30Var.f2862e) && kotlin.jvm.internal.t.d(this.f2863f, g30Var.f2863f) && kotlin.jvm.internal.t.d(this.f2864g, g30Var.f2864g);
    }

    public final int hashCode() {
        Integer num = this.f2858a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f2859b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f2860c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f2861d;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f2862e;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f2863f;
        int iHashCode6 = (iHashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.f2864g;
        return iHashCode6 + (num7 != null ? num7.hashCode() : 0);
    }

    public final String toString() {
        return "InAppMessageTheme(backgroundColor=" + this.f2858a + ", textColor=" + this.f2859b + ", closeButtonColor=" + this.f2860c + ", iconColor=" + this.f2861d + ", iconBackgroundColor=" + this.f2862e + ", headerTextColor=" + this.f2863f + ", frameColor=" + this.f2864g + ')';
    }
}
