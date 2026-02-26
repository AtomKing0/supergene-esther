package com.onetrust.otpublishers.headless.UI.DataModels;

import com.onetrust.otpublishers.headless.UI.UIProperty.u;
import com.onetrust.otpublishers.headless.UI.UIProperty.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f22038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f22039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f22041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f22042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f22043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f22044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f22045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f22046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f22047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f22048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f22049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f22050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f22051n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final String f22052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f22053p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final String f22054q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    public final String f22055r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    public final String f22056s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    public final u f22057t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public final v f22058u;

    public a(@NotNull String alertMoreInfoText, @Nullable String str, boolean z10, @NotNull String bannerRejectAllButtonText, boolean z11, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, boolean z12, boolean z13, @NotNull String bannerAdditionalDescPlacement, boolean z14, @Nullable String str9, @NotNull String bannerDPDTitle, @NotNull String bannerDPDDescription, @NotNull u otBannerUIProperty, @Nullable v vVar) {
        t.i(alertMoreInfoText, "alertMoreInfoText");
        t.i(bannerRejectAllButtonText, "bannerRejectAllButtonText");
        t.i(bannerAdditionalDescPlacement, "bannerAdditionalDescPlacement");
        t.i(bannerDPDTitle, "bannerDPDTitle");
        t.i(bannerDPDDescription, "bannerDPDDescription");
        t.i(otBannerUIProperty, "otBannerUIProperty");
        this.f22038a = alertMoreInfoText;
        this.f22039b = str;
        this.f22040c = z10;
        this.f22041d = bannerRejectAllButtonText;
        this.f22042e = z11;
        this.f22043f = str2;
        this.f22044g = str3;
        this.f22045h = str4;
        this.f22046i = str5;
        this.f22047j = str6;
        this.f22048k = str7;
        this.f22049l = str8;
        this.f22050m = z12;
        this.f22051n = z13;
        this.f22052o = bannerAdditionalDescPlacement;
        this.f22053p = z14;
        this.f22054q = str9;
        this.f22055r = bannerDPDTitle;
        this.f22056s = bannerDPDDescription;
        this.f22057t = otBannerUIProperty;
        this.f22058u = vVar;
    }

    public final boolean a(int i10) {
        if (i10 != 0) {
            if (i10 == 1 && this.f22051n && !this.f22042e) {
                return true;
            }
        } else if (this.f22051n && this.f22042e) {
            return true;
        }
        return false;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.d(this.f22038a, aVar.f22038a) && t.d(this.f22039b, aVar.f22039b) && this.f22040c == aVar.f22040c && t.d(this.f22041d, aVar.f22041d) && this.f22042e == aVar.f22042e && t.d(this.f22043f, aVar.f22043f) && t.d(this.f22044g, aVar.f22044g) && t.d(this.f22045h, aVar.f22045h) && t.d(this.f22046i, aVar.f22046i) && t.d(this.f22047j, aVar.f22047j) && t.d(this.f22048k, aVar.f22048k) && t.d(this.f22049l, aVar.f22049l) && this.f22050m == aVar.f22050m && this.f22051n == aVar.f22051n && t.d(this.f22052o, aVar.f22052o) && this.f22053p == aVar.f22053p && t.d(this.f22054q, aVar.f22054q) && t.d(this.f22055r, aVar.f22055r) && t.d(this.f22056s, aVar.f22056s) && t.d(this.f22057t, aVar.f22057t) && t.d(this.f22058u, aVar.f22058u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int iHashCode = this.f22038a.hashCode() * 31;
        String str = this.f22039b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.f22040c;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int iHashCode3 = (this.f22041d.hashCode() + ((iHashCode2 + r12) * 31)) * 31;
        boolean z11 = this.f22042e;
        ?? r02 = z11;
        if (z11) {
            r02 = 1;
        }
        int i10 = (iHashCode3 + r02) * 31;
        String str2 = this.f22043f;
        int iHashCode4 = (i10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22044g;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f22045h;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f22046i;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f22047j;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f22048k;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f22049l;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        boolean z12 = this.f22050m;
        ?? r03 = z12;
        if (z12) {
            r03 = 1;
        }
        int i11 = (iHashCode10 + r03) * 31;
        boolean z13 = this.f22051n;
        ?? r04 = z13;
        if (z13) {
            r04 = 1;
        }
        int iHashCode11 = (this.f22052o.hashCode() + ((i11 + r04) * 31)) * 31;
        boolean z14 = this.f22053p;
        int i12 = (iHashCode11 + (z14 ? 1 : z14)) * 31;
        String str9 = this.f22054q;
        int iHashCode12 = (this.f22057t.hashCode() + ((this.f22056s.hashCode() + ((this.f22055r.hashCode() + ((i12 + (str9 == null ? 0 : str9.hashCode())) * 31)) * 31)) * 31)) * 31;
        v vVar = this.f22058u;
        return iHashCode12 + (vVar != null ? vVar.hashCode() : 0);
    }

    @NotNull
    public final String toString() {
        return "BannerData(alertMoreInfoText=" + this.f22038a + ", alertAllowCookiesText=" + this.f22039b + ", bannerShowRejectAllButton=" + this.f22040c + ", bannerRejectAllButtonText=" + this.f22041d + ", bannerSettingButtonDisplayLink=" + this.f22042e + ", bannerMPButtonColor=" + this.f22043f + ", bannerMPButtonTextColor=" + this.f22044g + ", textColor=" + this.f22045h + ", buttonColor=" + this.f22046i + ", buttonTextColor=" + this.f22047j + ", backgroundColor=" + this.f22048k + ", bannerLinksTextColor=" + this.f22049l + ", showBannerAcceptButton=" + this.f22050m + ", showBannerCookieSetting=" + this.f22051n + ", bannerAdditionalDescPlacement=" + this.f22052o + ", isIABEnabled=" + this.f22053p + ", iABType=" + this.f22054q + ", bannerDPDTitle=" + this.f22055r + ", bannerDPDDescription=" + this.f22056s + ", otBannerUIProperty=" + this.f22057t + ", otGlobalUIProperty=" + this.f22058u + ')';
    }
}
