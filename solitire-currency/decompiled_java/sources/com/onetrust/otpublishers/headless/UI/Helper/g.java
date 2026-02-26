package com.onetrust.otpublishers.headless.UI.Helper;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.UIProperty.a0;
import com.onetrust.otpublishers.headless.UI.UIProperty.b0;
import com.onetrust.otpublishers.headless.UI.fragment.l1;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static void a(@NonNull FragmentActivity fragmentActivity, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        a0 a0VarC;
        try {
            a0VarC = new b0(fragmentActivity).c(oTPublishersHeadlessSDK.getUcpHandler(), 22);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error in getting consent preferences data :"), "OneTrust", 6);
            a0VarC = null;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG)) {
            return;
        }
        if (a0VarC != null && com.onetrust.otpublishers.headless.Internal.b.a(a0VarC.f22705a)) {
            if (a0VarC.f22712h.size() > 0) {
                l1 l1Var = new l1();
                Bundle bundle = new Bundle();
                bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG);
                l1Var.setArguments(bundle);
                l1Var.f23416n = oTPublishersHeadlessSDK;
                try {
                    l1Var.show(fragmentActivity.getSupportFragmentManager(), OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG);
                } catch (IllegalStateException e11) {
                    OTLogger.a("OneTrust", 3, "Activity in illegal state to add a UCP fragment " + e11);
                    if (fragmentActivity.isDestroyed()) {
                        OTLogger.a("OneTrust", 6, "showUIOnForeground UCP: Activity is destroyed");
                    } else {
                        fragmentActivity.getLifecycle().addObserver(new f(fragmentActivity, l1Var));
                    }
                }
                OTLogger.a("OneTrust", 4, "Showing Consent Preferences");
                return;
            }
            OTLogger.a("OneTrust", 6, "Please enable to Universal Consent Purposes from Template Configuration and add purposes to display the UC Purposes Preference Center.");
        }
        OTLogger.a("OneTrust", 6, "Consent Preferences UI is not configured to show for this app id.\n Please enable it from admin UI and try again");
    }
}
