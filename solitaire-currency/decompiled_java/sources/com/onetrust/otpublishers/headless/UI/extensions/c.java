package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.drawable.Drawable;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.jetbrains.annotations.Nullable;
import u0.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements k1.e<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f23194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f23195b;

    public c(String str, String str2) {
        this.f23194a = str;
        this.f23195b = str2;
    }

    @Override // k1.e
    public final boolean a(Drawable drawable, Object obj, l1.h<Drawable> hVar, r0.a aVar, boolean z10) {
        OTLogger.a("OneTrust", 3, "Logo shown for " + this.f23194a + " for url " + this.f23195b);
        return false;
    }

    @Override // k1.e
    public final boolean b(@Nullable q qVar, @Nullable Object obj, @Nullable l1.h<Drawable> hVar, boolean z10) {
        OTLogger.a("OneTrust", 3, "Logo shown for " + this.f23194a + " failed for url " + this.f23195b);
        return false;
    }
}
