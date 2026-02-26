package com.king.adscmp.sa;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.king.amp.sa.Logging;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTEventListener;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import e4.f;
import j6.e;

/* JADX INFO: loaded from: classes4.dex */
public class OneTrustNativeLaunchActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16518a = "AdsOnetrustNative";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OTPublishersHeadlessSDK f16520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FragmentActivity f16521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f16522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    b f16525h;

    class a extends OTEventListener {
        a() {
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void allSDKViewsDismissed(String str) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "allSDKViewsDismissed called.");
            OneTrustNativeLaunchActivity oneTrustNativeLaunchActivity = OneTrustNativeLaunchActivity.this;
            oneTrustNativeLaunchActivity.f16524g = oneTrustNativeLaunchActivity.f16520c.isOTUIPresent(OneTrustNativeLaunchActivity.this.f16521d);
            OneTrustNativeLaunchActivity.this.z("allSDKViewsDismissed");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onBannerClickedAcceptAll() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onBannerClickedAcceptAll called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onBannerClickedRejectAll() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onBannerClickedRejectAll called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onHideBanner() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onHideBanner called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onHidePreferenceCenter() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onHidePreferenceCenter called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onHideVendorList() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onHideVendorList called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterAcceptAll() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onPreferenceCenterAcceptAll called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterConfirmChoices() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onPreferenceCenterConfirmChoices called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterPurposeConsentChanged(String str, int i10) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onPreferenceCenterPurposeConsentChanged called.  PurposeID = " + str + " consentStatus = " + i10);
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterPurposeLegitimateInterestChanged(String str, int i10) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onPreferenceCenterPurposeLegitimateInterestChanged called. PurposeID = " + str + " legitInterest = " + i10);
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterRejectAll() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onPreferenceCenterRejectAll called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onShowBanner(OTUIDisplayReason oTUIDisplayReason) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onShowBanner called: " + oTUIDisplayReason.toString());
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onShowPreferenceCenter(OTUIDisplayReason oTUIDisplayReason) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onShowPreferenceCenter called: " + oTUIDisplayReason.toString());
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onShowVendorList() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onShowVendorList called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onVendorConfirmChoices() {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onVendorConfirmChoices called.");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onVendorListVendorConsentChanged(String str, int i10) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onVendorListVendorConsentChanged called. vendorId = " + str + " consentStatus = " + i10);
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onVendorListVendorLegitimateInterestChanged(String str, int i10) {
            Log.i(OneTrustNativeLaunchActivity.this.f16518a, "onVendorListVendorLegitimateInterestChanged called. vendorId = " + str + " legitInterest = " + i10);
        }
    }

    private class b extends FragmentManager.FragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.bottomsheet.a f16527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f16528b;

        private class a implements ViewTreeObserver.OnGlobalLayoutListener {
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FrameLayout frameLayout;
                com.google.android.material.bottomsheet.a aVar = b.this.f16527a;
                if (aVar == null || (frameLayout = (FrameLayout) aVar.findViewById(f.f24825f)) == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                OneTrustNativeLaunchActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                layoutParams.height = displayMetrics.heightPixels;
                frameLayout.setLayoutParams(layoutParams);
                frameLayout.requestLayout();
            }

            private a() {
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment instanceof com.google.android.material.bottomsheet.b) {
                this.f16527a = (com.google.android.material.bottomsheet.a) ((com.google.android.material.bottomsheet.b) fragment).getDialog();
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.f16528b);
            }
            super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        }

        private b() {
            this.f16528b = new a();
        }
    }

    private void w() {
        try {
            this.f16520c = new OTPublishersHeadlessSDK(this);
            x();
            if (this.f16519b) {
                Logging.logBreadcrumb("External", "OneTrust - otPublishersHeadlessSDK.showPreferenceCenterUI");
                this.f16520c.showPreferenceCenterUI(this, y(this));
            } else {
                Logging.logBreadcrumb("External", "OneTrust - otPublishersHeadlessSDK.showBannerUI");
                this.f16520c.showBannerUI(this, y(this));
            }
        } catch (Exception e10) {
            Log.e(this.f16518a, "exception in show ", e10);
            z("exception in show: " + e10.getMessage());
        }
    }

    private void x() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f16520c;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.addEventListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        Log.i(this.f16518a, "All OneTrust views are dismissed, dialog is closed");
        this.f16523f = str;
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f16518a = intent.getStringExtra("logTag");
        this.f16519b = intent.getBooleanExtra("showPC", false);
        boolean booleanExtra = intent.getBooleanExtra("disableOtLayoutPatch", false);
        this.f16522e = booleanExtra;
        this.f16523f = "";
        this.f16524g = false;
        this.f16521d = this;
        if (!booleanExtra) {
            this.f16525h = new b();
            getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f16525h, true);
        }
        w();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (!this.f16522e) {
            getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f16525h);
        }
        boolean z10 = this.f16524g || this.f16520c.isOTUIPresent(this.f16521d);
        Logging.logBreadcrumb("Internal", "AdsOnetrustNative - AdsOnetrustNative.onDialogClosed " + z10);
        AdsOnetrustNative.onDialogClosed(this.f16519b ? 1 : 0, z10, this.f16523f);
        super.onDestroy();
    }

    public OTConfiguration y(@NonNull Context context) {
        Typeface font = ResourcesCompat.getFont(context, e.f28711a);
        Typeface font2 = ResourcesCompat.getFont(context, e.f28712b);
        OTConfiguration.OTConfigurationBuilder oTConfigurationBuilderNewInstance = OTConfiguration.OTConfigurationBuilder.newInstance();
        if (font != null && font2 != null) {
            oTConfigurationBuilderNewInstance = oTConfigurationBuilderNewInstance.addOTTypeFace("king", font).addOTTypeFace("king_thin", font2);
        }
        return oTConfigurationBuilderNewInstance.build();
    }
}
