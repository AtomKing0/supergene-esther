package com.onetrust.otpublishers.headless.UI.DataModels;

import com.onetrust.otpublishers.headless.UI.UIProperty.x;
import com.onetrust.otpublishers.headless.UI.UIProperty.z;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f22099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f22100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f22101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f22102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f22103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f22104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f22105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f22106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final String f22107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c f22108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c f22109l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.UIProperty.a f22110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c f22111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final z f22112o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final x f22113p;

    public h(boolean z10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull String consentLabel, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.c summaryTitle, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.c summaryDescription, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.a searchBarProperty, @NotNull com.onetrust.otpublishers.headless.UI.UIProperty.c allowAllToggleTextProperty, @NotNull z otSdkListUIProperty, @Nullable x xVar) {
        t.i(consentLabel, "consentLabel");
        t.i(summaryTitle, "summaryTitle");
        t.i(summaryDescription, "summaryDescription");
        t.i(searchBarProperty, "searchBarProperty");
        t.i(allowAllToggleTextProperty, "allowAllToggleTextProperty");
        t.i(otSdkListUIProperty, "otSdkListUIProperty");
        this.f22098a = z10;
        this.f22099b = str;
        this.f22100c = str2;
        this.f22101d = str3;
        this.f22102e = str4;
        this.f22103f = str5;
        this.f22104g = str6;
        this.f22105h = str7;
        this.f22106i = str8;
        this.f22107j = consentLabel;
        this.f22108k = summaryTitle;
        this.f22109l = summaryDescription;
        this.f22110m = searchBarProperty;
        this.f22111n = allowAllToggleTextProperty;
        this.f22112o = otSdkListUIProperty;
        this.f22113p = xVar;
    }

    @Nullable
    public final String a() {
        return this.f22100c;
    }

    @NotNull
    public final com.onetrust.otpublishers.headless.UI.UIProperty.a b() {
        return this.f22110m;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f22098a == hVar.f22098a && t.d(this.f22099b, hVar.f22099b) && t.d(this.f22100c, hVar.f22100c) && t.d(this.f22101d, hVar.f22101d) && t.d(this.f22102e, hVar.f22102e) && t.d(this.f22103f, hVar.f22103f) && t.d(this.f22104g, hVar.f22104g) && t.d(this.f22105h, hVar.f22105h) && t.d(this.f22106i, hVar.f22106i) && t.d(this.f22107j, hVar.f22107j) && t.d(this.f22108k, hVar.f22108k) && t.d(this.f22109l, hVar.f22109l) && t.d(this.f22110m, hVar.f22110m) && t.d(this.f22111n, hVar.f22111n) && t.d(this.f22112o, hVar.f22112o) && t.d(this.f22113p, hVar.f22113p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    public final int hashCode() {
        boolean z10 = this.f22098a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.f22099b;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22100c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22101d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f22102e;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f22103f;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f22104g;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f22105h;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f22106i;
        int iHashCode8 = (this.f22112o.hashCode() + ((this.f22111n.hashCode() + ((this.f22110m.hashCode() + ((this.f22109l.hashCode() + ((this.f22108k.hashCode() + ((this.f22107j.hashCode() + ((iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        x xVar = this.f22113p;
        return iHashCode8 + (xVar != null ? xVar.hashCode() : 0);
    }

    @NotNull
    public final String toString() {
        return "SDKListData(showSdkDescription=" + this.f22098a + ", backButtonColor=" + this.f22099b + ", backgroundColor=" + this.f22100c + ", filterOnColor=" + this.f22101d + ", filterOffColor=" + this.f22102e + ", dividerColor=" + this.f22103f + ", toggleThumbColorOn=" + this.f22104g + ", toggleThumbColorOff=" + this.f22105h + ", toggleTrackColor=" + this.f22106i + ", consentLabel=" + this.f22107j + ", summaryTitle=" + this.f22108k + ", summaryDescription=" + this.f22109l + ", searchBarProperty=" + this.f22110m + ", allowAllToggleTextProperty=" + this.f22111n + ", otSdkListUIProperty=" + this.f22112o + ", otPCUIProperty=" + this.f22113p + ')';
    }
}
