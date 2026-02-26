package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.j2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v2;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class o3 extends j2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final v2 f6461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f6462o;

    public o3(v2 v2Var, Context context) {
        super(j2.c.DETAIL);
        this.f6461n = v2Var;
        this.f6462o = context;
        this.f5439c = t();
        this.f5440d = s();
    }

    private SpannedString q() {
        if (!this.f6461n.A()) {
            return StringUtils.createListItemDetailSpannedString("Adapter Missing", SupportMenu.CATEGORY_MASK);
        }
        if (TextUtils.isEmpty(this.f6461n.c())) {
            return StringUtils.createListItemDetailSpannedString("Adapter Found", ViewCompat.MEASURED_STATE_MASK);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f6461n.c(), ViewCompat.MEASURED_STATE_MASK));
        if (this.f6461n.B()) {
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("  LATEST  ", i0.a(R.color.applovin_sdk_orangeColor, this.f6462o)));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f6461n.k(), ViewCompat.MEASURED_STATE_MASK));
        }
        if (!this.f6461n.C()) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("INCOMPATIBLE WITH MAX SDK VERSION", SupportMenu.CATEGORY_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString s() {
        if (!o()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) u());
        spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
        spannableStringBuilder.append((CharSequence) q());
        if (this.f6461n.q() == v2.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Invalid Integration", SupportMenu.CATEGORY_MASK));
        } else if (this.f6461n.q() == v2.a.INCOMPLETE_INTEGRATION && this.f6461n.F()) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Mismatched SDK/Adapter Versions", SupportMenu.CATEGORY_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString t() {
        return StringUtils.createSpannedString(this.f6461n.g(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
    }

    private SpannedString u() {
        if (!this.f6461n.G()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", SupportMenu.CATEGORY_MASK);
        }
        if (!StringUtils.isValidString(this.f6461n.p())) {
            return StringUtils.createListItemDetailSpannedString(this.f6461n.A() ? "Retrieving SDK Version..." : "SDK Found", ViewCompat.MEASURED_STATE_MASK);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f6461n.p(), ViewCompat.MEASURED_STATE_MASK));
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.j2
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.j2
    public int e() {
        return i0.a(R.color.applovin_sdk_disclosureButtonColor, this.f6462o);
    }

    @Override // com.applovin.impl.j2
    public int h() {
        int iH = this.f6461n.h();
        return iH > 0 ? iH : R.drawable.applovin_ic_mediation_placeholder;
    }

    @Override // com.applovin.impl.j2
    public boolean o() {
        return this.f6461n.q() != v2.a.MISSING;
    }

    public v2 r() {
        return this.f6461n;
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + ((Object) this.f5439c) + ", detailText=" + ((Object) this.f5440d) + ", network=" + this.f6461n + "}";
    }
}
