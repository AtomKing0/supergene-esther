package com.vungle.ads.internal.omsdk;

import android.util.Base64;
import android.view.View;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdEvents;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.vungle.ads.internal.model.i;
import com.vungle.ads.internal.util.p;
import h9.l;
import java.net.URL;
import kotlin.collections.u;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: NativeOMTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    @Nullable
    private AdEvents adEvents;

    @Nullable
    private AdSession adSession;

    @NotNull
    private final kotlinx.serialization.json.a json;

    /* JADX INFO: renamed from: com.vungle.ads.internal.omsdk.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeOMTracker.kt */
    static final class C0525a extends v implements l<kotlinx.serialization.json.c, k0> {
        public static final C0525a INSTANCE = new C0525a();

        C0525a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    public a(@NotNull String omSdkData) {
        i iVar;
        t.i(omSdkData, "omSdkData");
        kotlinx.serialization.json.a aVarB = m.b(null, C0525a.INSTANCE, 1, null);
        this.json = aVarB;
        try {
            AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
            Partner partnerCreatePartner = Partner.createPartner("Vungle", "7.4.2");
            byte[] bArrDecode = Base64.decode(omSdkData, 0);
            if (bArrDecode != null) {
                String str = new String(bArrDecode, p9.d.f32952b);
                KSerializer<Object> kSerializerB = z9.l.b(aVarB.a(), o0.j(i.class));
                t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                iVar = (i) aVarB.b(kSerializerB, str);
            } else {
                iVar = null;
            }
            VerificationScriptResource verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(iVar != null ? iVar.getVendorKey() : null, new URL(iVar != null ? iVar.getVendorURL() : null), iVar != null ? iVar.getParams() : null);
            t.h(verificationScriptResource, "verificationScriptResource");
            this.adSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(partnerCreatePartner, e.INSTANCE.getOM_JS$vungle_ads_release(), u.e(verificationScriptResource), null, null));
        } catch (Exception e10) {
            p.Companion.e("NativeOMTracker", "error occured when create omsdk adSession:", e10);
        }
    }

    public final void impressionOccurred() {
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.impressionOccurred();
        }
    }

    public final void start(@NotNull View view) {
        AdSession adSession;
        t.i(view, "view");
        if (!Omid.isActive() || (adSession = this.adSession) == null) {
            return;
        }
        adSession.registerAdView(view);
        adSession.start();
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        this.adEvents = adEventsCreateAdEvents;
        if (adEventsCreateAdEvents != null) {
            adEventsCreateAdEvents.loaded();
        }
    }

    public final void stop() {
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.finish();
        }
        this.adSession = null;
    }
}
