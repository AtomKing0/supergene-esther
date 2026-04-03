package com.iab.omid.library.applovin.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.applovin.weakreference.a f10683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f10685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10686d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f10683a = new com.iab.omid.library.applovin.weakreference.a(view);
        this.f10684b = view.getClass().getCanonicalName();
        this.f10685c = friendlyObstructionPurpose;
        this.f10686d = str;
    }

    public String a() {
        return this.f10686d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f10685c;
    }

    public com.iab.omid.library.applovin.weakreference.a c() {
        return this.f10683a;
    }

    public String d() {
        return this.f10684b;
    }
}
