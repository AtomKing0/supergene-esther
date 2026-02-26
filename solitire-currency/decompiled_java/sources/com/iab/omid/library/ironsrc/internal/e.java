package com.iab.omid.library.ironsrc.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.ironsrc.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.weakreference.a f10819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f10821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10822d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f10819a = new com.iab.omid.library.ironsrc.weakreference.a(view);
        this.f10820b = view.getClass().getCanonicalName();
        this.f10821c = friendlyObstructionPurpose;
        this.f10822d = str;
    }

    public String a() {
        return this.f10822d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f10821c;
    }

    public com.iab.omid.library.ironsrc.weakreference.a c() {
        return this.f10819a;
    }

    public String d() {
        return this.f10820b;
    }
}
