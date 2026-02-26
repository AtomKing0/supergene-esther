package com.onetrust.otpublishers.headless.UI.Helper;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import com.onetrust.otpublishers.headless.UI.fragment.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static void a(@NonNull FragmentActivity fragmentActivity, @NonNull com.onetrust.otpublishers.headless.Internal.Event.a aVar, @Nullable OTConfiguration oTConfiguration, @NonNull OTUIDisplayReason oTUIDisplayReason, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
            return;
        }
        OTLogger.a("OneTrust", 4, "Showing Preference Center");
        OTLogger.a("OneTrust", 4, oTUIDisplayReason.logReason());
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(5);
        bVar.f21750f = oTUIDisplayReason;
        SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (new com.onetrust.otpublishers.headless.Internal.profile.d(fragmentActivity).t()) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(fragmentActivity, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            z10 = false;
            hVar = null;
        }
        StringBuilder sb = new StringBuilder("ui type ");
        sb.append((z10 ? hVar : sharedPreferences).getInt("OT_UI_MODE_TYPE", 102));
        OTLogger.a("OneTrust", 4, sb.toString());
        if (z10) {
            sharedPreferences = hVar;
        }
        if (sharedPreferences.getInt("OT_UI_MODE_TYPE", 102) == 101) {
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.k kVar = new com.onetrust.otpublishers.headless.UI.TVUI.fragments.k();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
            kVar.setArguments(bundle);
            kVar.f22573g = aVar;
            kVar.f22574h = 1;
            kVar.f22578l = oTConfiguration;
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.e(kVar, fragmentActivity, OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
        } else {
            l0 l0Var = new l0();
            Bundle bundle2 = new Bundle();
            bundle2.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
            l0Var.setArguments(bundle2);
            l0Var.D = aVar;
            l0Var.E = oTConfiguration;
            if (oTConfiguration != null && oTConfiguration.issSncOTUIWithBYOUIMethodsEnabled()) {
                l0Var.f23403z = oTPublishersHeadlessSDK;
            }
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.e(l0Var, fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        }
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        SharedPreferences sharedPreferences2 = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, new com.onetrust.otpublishers.headless.Internal.Preferences.e(fragmentActivity, "OTT_DEFAULT_USER").c(), "OT_ENABLE_MULTI_PROFILE")) {
            hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(fragmentActivity, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            z11 = false;
            hVar2 = null;
        }
        if (z11) {
            sharedPreferences2 = hVar2;
        }
        if (sharedPreferences2.getInt("OneTrustBannerShownToUser", -1) < 1) {
            com.onetrust.otpublishers.headless.Internal.c.c(fragmentActivity, 1);
        }
    }
}
