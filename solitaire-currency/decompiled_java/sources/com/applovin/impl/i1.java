package com.applovin.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import com.applovin.impl.j2;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class i1 extends j2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final j1 f5365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f5366o;

    public i1(j1 j1Var, Context context) {
        super(j2.c.DETAIL);
        this.f5365n = j1Var;
        this.f5366o = context;
        this.f5439c = r();
        this.f5440d = q();
    }

    private SpannedString q() {
        return new SpannedString("Displayed " + z6.a(this.f5365n.b(), true));
    }

    private SpannedString r() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f5365n.c());
        spannableStringBuilder.append((CharSequence) " - ");
        spannableStringBuilder.append((CharSequence) this.f5365n.d());
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.j2
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.j2
    public int e() {
        return i0.a(R.color.applovin_sdk_disclosureButtonColor, this.f5366o);
    }

    @Override // com.applovin.impl.j2
    public boolean o() {
        return true;
    }
}
