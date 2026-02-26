package com.moloco.sdk.internal.publisher.nativead;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.nativead.ui.e;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import h9.l;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.o;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements NativeAd.Assets {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final C0313a f18054k = new C0313a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final t f18056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.a f18057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final r f18058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a> f18059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public h9.a<k0> f18060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.internal.publisher.nativead.model.c f18061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final Uri f18062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public ViewGroup f18063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public e f18064j;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.a$a, reason: collision with other inner class name */
    public static final class C0313a {
        public /* synthetic */ C0313a(k kVar) {
            this();
        }

        public C0313a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Context context, @NotNull t viewVisibilityTracker, @NotNull com.moloco.sdk.internal.a viewLifecycleOwner, @NotNull r watermark, @NotNull l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a> vastAdPlaylistController) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(viewLifecycleOwner, "viewLifecycleOwner");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(vastAdPlaylistController, "vastAdPlaylistController");
        this.f18055a = context;
        this.f18056b = viewVisibilityTracker;
        this.f18057c = viewLifecycleOwner;
        this.f18058d = watermark;
        this.f18059e = vastAdPlaylistController;
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        this.f18062h = cVar != null ? cVar.c(1) : null;
    }

    public final ViewGroup a(Uri uri) {
        return new com.moloco.sdk.internal.publisher.nativead.ui.d(this.f18055a, uri, this.f18058d, this.f18060f, null, null, 48, null);
    }

    public final e b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVarInvoke = this.f18059e.invoke(aVar);
        aVarInvoke.d();
        return new e(this.f18055a, aVarInvoke, this.f18056b, this.f18057c, this.f18058d, this.f18060f);
    }

    public final void c() {
        e eVar = this.f18064j;
        if (eVar != null) {
            eVar.b();
        }
        this.f18064j = null;
    }

    public final void d(ViewGroup viewGroup) {
        ViewParent parent = viewGroup.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "NativeAdAssetsProvider", "Detaching view " + viewGroup.getClass().getSimpleName() + " from parent " + viewGroup2.getClass().getSimpleName(), null, false, 12, null);
            viewGroup2.removeView(viewGroup);
        }
    }

    public final void e(@Nullable com.moloco.sdk.internal.publisher.nativead.model.c cVar) {
        this.f18061g = cVar;
    }

    public final void f(@Nullable h9.a<k0> aVar) {
        this.f18060f = aVar;
    }

    @Nullable
    public final com.moloco.sdk.internal.publisher.nativead.model.c g() {
        return this.f18061g;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public String getCallToActionText() {
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar != null) {
            return cVar.a(7);
        }
        return null;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public String getDescription() {
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar != null) {
            return cVar.a(5);
        }
        return null;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public Uri getIconUri() {
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar != null) {
            return cVar.c(0);
        }
        return null;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public Uri getMainImageUri() {
        return this.f18062h;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public View getMediaView() {
        Uri uriC;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVarG;
        e eVar = this.f18064j;
        if (eVar != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "NativeAdAssetsProvider", "Using cached video view", null, false, 12, null);
            d(eVar);
            return eVar;
        }
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar != null && (aVarG = cVar.g(2)) != null) {
            e eVarB = b(aVarG);
            this.f18064j = eVarB;
            return eVarB;
        }
        ViewGroup viewGroup = this.f18063i;
        if (viewGroup != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "NativeAdAssetsProvider", "Using cached image view", null, false, 12, null);
            d(viewGroup);
            return viewGroup;
        }
        com.moloco.sdk.internal.publisher.nativead.model.c cVar2 = this.f18061g;
        if (cVar2 == null || (uriC = cVar2.c(1)) == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "NativeAdAssetsProvider", "Missing video and image asset", new Exception(), false, 8, null);
            return null;
        }
        ViewGroup viewGroupA = a(uriC);
        this.f18063i = viewGroupA;
        return viewGroupA;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public Float getRating() {
        String strA;
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar == null || (strA = cVar.a(6)) == null) {
            return null;
        }
        return o.j(strA);
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public String getSponsorText() {
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar != null) {
            return cVar.a(4);
        }
        return null;
    }

    @Override // com.moloco.sdk.publisher.NativeAd.Assets
    @Nullable
    public String getTitle() {
        com.moloco.sdk.internal.publisher.nativead.model.c cVar = this.f18061g;
        if (cVar != null) {
            return cVar.e(3);
        }
        return null;
    }
}
