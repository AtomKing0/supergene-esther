package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.Nullable;
import u0.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements k1.e<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f23201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f23202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ImageView f23204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f23205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f23206f;

    public e(int i10, int i11, ImageView imageView, String str, String str2, String str3) {
        this.f23201a = str;
        this.f23202b = str2;
        this.f23203c = str3;
        this.f23204d = imageView;
        this.f23205e = i10;
        this.f23206f = i11;
    }

    public static final void c(ImageView this_loadLogo, String str, int i10, int i11, String navigatedFrom) {
        t.i(this_loadLogo, "$this_loadLogo");
        t.i(navigatedFrom, "$navigatedFrom");
        try {
            com.bumptech.glide.b.u(this_loadLogo).p(str).h().b(new k1.f().b0(i11)).v0(new c(navigatedFrom, str)).t0(this_loadLogo);
        } catch (Exception e10) {
            OTLogger.a("OneTrust", 3, "error on showing " + navigatedFrom + " logo, " + e10);
        }
    }

    @Override // k1.e
    public final boolean a(Drawable drawable, Object obj, l1.h<Drawable> hVar, r0.a aVar, boolean z10) {
        OTLogger.a("OneTrust", 3, "Logo shown for " + this.f23201a + " for url " + this.f23202b);
        return false;
    }

    @Override // k1.e
    public final boolean b(@Nullable q qVar, @Nullable Object obj, @Nullable l1.h<Drawable> hVar, boolean z10) {
        OTLogger.a("OneTrust", 3, "Logo shown for " + this.f23201a + " failed for url " + this.f23202b);
        if (t.d(this.f23202b, this.f23203c)) {
            return false;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final ImageView imageView = this.f23204d;
        final String str = this.f23203c;
        final int i10 = this.f23205e;
        final int i11 = this.f23206f;
        final String str2 = this.f23201a;
        handler.post(new Runnable() { // from class: com.onetrust.otpublishers.headless.UI.extensions.d
            @Override // java.lang.Runnable
            public final void run() {
                e.c(imageView, str, i10, i11, str2);
            }
        });
        return false;
    }
}
