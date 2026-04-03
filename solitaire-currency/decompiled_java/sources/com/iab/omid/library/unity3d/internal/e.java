package com.iab.omid.library.unity3d.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.unity3d.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.weakreference.a f10944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f10946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10947d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f10944a = new com.iab.omid.library.unity3d.weakreference.a(view);
        this.f10945b = view.getClass().getCanonicalName();
        this.f10946c = friendlyObstructionPurpose;
        this.f10947d = str;
    }

    public String a() {
        return this.f10947d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f10946c;
    }

    public com.iab.omid.library.unity3d.weakreference.a c() {
        return this.f10944a;
    }

    public String d() {
        return this.f10945b;
    }
}
