package com.iab.omid.library.vungle.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.vungle.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.vungle.weakreference.a f11071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f11073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11074d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f11071a = new com.iab.omid.library.vungle.weakreference.a(view);
        this.f11072b = view.getClass().getCanonicalName();
        this.f11073c = friendlyObstructionPurpose;
        this.f11074d = str;
    }

    public String a() {
        return this.f11074d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f11073c;
    }

    public com.iab.omid.library.vungle.weakreference.a c() {
        return this.f11071a;
    }

    public String d() {
        return this.f11072b;
    }
}
