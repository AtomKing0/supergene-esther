package com.onetrust.otpublishers.headless.Internal.Event;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.c;
import com.onetrust.otpublishers.headless.Public.OTEventListener;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<OTEventListener> f21744a = new HashSet<>();

    public final void a(@NonNull b bVar) {
        int size = this.f21744a.size();
        if (size <= 0) {
            OTLogger.a("EventListenerSetter", 3, "Empty callback set. No oneTrustEventListener callback.");
            return;
        }
        OTLogger.a("EventListenerSetter", 4, "Sending oneTrustDataEventListener callback. oneTrustEventListener size = " + size);
        for (OTEventListener oTEventListener : this.f21744a) {
            String str = bVar.f21748d;
            switch (bVar.f21745a) {
                case 1:
                    oTEventListener.onShowBanner(bVar.f21750f);
                    break;
                case 2:
                    oTEventListener.onHideBanner();
                    break;
                case 3:
                    oTEventListener.onBannerClickedAcceptAll();
                    break;
                case 4:
                    oTEventListener.onBannerClickedRejectAll();
                    break;
                case 5:
                    oTEventListener.onShowPreferenceCenter(bVar.f21750f);
                    break;
                case 6:
                    oTEventListener.onHidePreferenceCenter();
                    break;
                case 7:
                    oTEventListener.onPreferenceCenterPurposeConsentChanged(bVar.f21746b, bVar.f21747c);
                    break;
                case 8:
                    oTEventListener.onPreferenceCenterAcceptAll();
                    break;
                case 9:
                    oTEventListener.onPreferenceCenterRejectAll();
                    break;
                case 10:
                    oTEventListener.onPreferenceCenterConfirmChoices();
                    break;
                case 11:
                    oTEventListener.onPreferenceCenterPurposeLegitimateInterestChanged(bVar.f21746b, bVar.f21747c);
                    break;
                case 12:
                    oTEventListener.onShowVendorList();
                    break;
                case 13:
                    oTEventListener.onHideVendorList();
                    break;
                case 14:
                    oTEventListener.onVendorConfirmChoices();
                    break;
                case 15:
                    if (c.q(bVar.f21749e)) {
                        oTEventListener.onVendorListVendorConsentChanged(bVar.f21746b, bVar.f21747c);
                    } else {
                        oTEventListener.onVendorListVendorConsentChanged(bVar.f21749e, bVar.f21746b, bVar.f21747c);
                    }
                    break;
                case 16:
                    oTEventListener.onVendorListVendorLegitimateInterestChanged(bVar.f21746b, bVar.f21747c);
                    break;
                case 17:
                    oTEventListener.allSDKViewsDismissed(str);
                    break;
                case 18:
                    oTEventListener.onSDKNoAction(str);
                    break;
                case 19:
                    oTEventListener.onVendorListAcceptAll();
                    break;
                case 20:
                    oTEventListener.onVendorListRejectAll();
                    break;
                case 24:
                    oTEventListener.onSdkListSdkConsentChanged(bVar.f21746b, bVar.f21747c);
                    break;
                case 25:
                    oTEventListener.onShowSdkList();
                    break;
                case 26:
                    oTEventListener.onHideSdkList();
                    break;
            }
        }
    }
}
