package com.iab.omid.library.activision.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.activision.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.activision.weakreference.a f10548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f10550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10551d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f10548a = new com.iab.omid.library.activision.weakreference.a(view);
        this.f10549b = view.getClass().getCanonicalName();
        this.f10550c = friendlyObstructionPurpose;
        this.f10551d = str;
    }

    public String a() {
        return this.f10551d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f10550c;
    }

    public com.iab.omid.library.activision.weakreference.a c() {
        return this.f10548a;
    }

    public String d() {
        return this.f10549b;
    }
}
