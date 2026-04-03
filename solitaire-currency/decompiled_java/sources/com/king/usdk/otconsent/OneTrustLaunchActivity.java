package com.king.usdk.otconsent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.king.usdk.logger.Logger;
import com.king.usdk.otconsent.OneTrustHelper;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTEventListener;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import e4.f;

/* JADX INFO: loaded from: classes4.dex */
public class OneTrustLaunchActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f17219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FragmentActivity f17220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Logger f17221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OTPublishersHeadlessSDK f17222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OneTrustHelper.c f17223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17224f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17225g = false;

    class a extends OTEventListener {
        a() {
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void allSDKViewsDismissed(String str) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::allSDKViewsDismissed called");
            OneTrustLaunchActivity oneTrustLaunchActivity = OneTrustLaunchActivity.this;
            oneTrustLaunchActivity.f17225g = oneTrustLaunchActivity.f17222d.isOTUIPresent(OneTrustLaunchActivity.this.f17220b);
            OneTrustLaunchActivity.this.y("allSDKViewsDismissed");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onBannerClickedAcceptAll() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onBannerClickedAcceptAll called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onBannerClickedRejectAll() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onBannerClickedRejectAll called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onHideBanner() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onHideBanner called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onHidePreferenceCenter() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onHidePreferenceCenter called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onHideVendorList() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onHideVendorList called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterAcceptAll() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onPreferenceCenterAcceptAll called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterConfirmChoices() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onPreferenceCenterConfirmChoices called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterPurposeConsentChanged(String str, int i10) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onPreferenceCenterPurposeConsentChanged called with  purposeId=" + str + " consentStatus=" + i10);
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterPurposeLegitimateInterestChanged(String str, int i10) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onPreferenceCenterPurposeLegitimateInterestChanged called with purposeId=" + str + " and legitInterest=" + i10);
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onPreferenceCenterRejectAll() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onPreferenceCenterRejectAll called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onShowBanner(OTUIDisplayReason oTUIDisplayReason) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onShowBanner called: " + oTUIDisplayReason.toString());
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onShowPreferenceCenter(OTUIDisplayReason oTUIDisplayReason) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onShowPreferenceCenter called: " + oTUIDisplayReason.toString());
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onShowVendorList() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onShowVendorList called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onVendorConfirmChoices() {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onVendorConfirmChoices called");
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onVendorListVendorConsentChanged(String str, int i10) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onVendorListVendorConsentChanged called with vendorId=" + str + " and consentStatus=" + i10);
        }

        @Override // com.onetrust.otpublishers.headless.Public.OTEventListener
        public void onVendorListVendorLegitimateInterestChanged(String str, int i10) {
            OneTrustLaunchActivity.this.f17221c.i("OTEventListener::onVendorListVendorLegitimateInterestChanged called with vendorId=" + str + " and legitInterest=" + i10);
        }
    }

    private void w() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f17222d;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.addEventListener(new a());
        }
    }

    private OTConfiguration x(@NonNull Context context) {
        Typeface font = ResourcesCompat.getFont(context, com.king.usdk.otconsent.b.f17231a);
        Typeface font2 = ResourcesCompat.getFont(context, com.king.usdk.otconsent.b.f17232b);
        OTConfiguration.OTConfigurationBuilder oTConfigurationBuilderNewInstance = OTConfiguration.OTConfigurationBuilder.newInstance();
        if (font != null && font2 != null) {
            oTConfigurationBuilderNewInstance.addOTTypeFace("king", font).addOTTypeFace("king_thin", font2);
        }
        return oTConfigurationBuilderNewInstance.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) {
        this.f17221c.i("OneTrustActivity::onDialogClosed: dialog is closed with message '" + str + "'");
        this.f17224f = str;
        finish();
        overridePendingTransition(0, 0);
    }

    private void z() {
        try {
            this.f17222d = new OTPublishersHeadlessSDK(this);
            w();
            if (this.f17223e == OneTrustHelper.c.Consent) {
                OneTrustHelper.logBreadcrumb("OneTrustLaunchActivity::showDialog: showBannerUI", this.f17221c);
                this.f17222d.showBannerUI(this, x(this));
            } else {
                OneTrustHelper.logBreadcrumb("OneTrustLaunchActivity::showDialog: showPreferenceCenterUI", this.f17221c);
                this.f17222d.showPreferenceCenterUI(this, x(this));
            }
        } catch (Exception e10) {
            this.f17221c.e("OneTrustActivity::showDialog: exception=" + e10.getMessage());
            y("exception: " + e10.getMessage());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17220b = this;
        Intent intent = getIntent();
        this.f17221c = new Logger(intent.getLongExtra("log-state", 0L), intent.getBooleanExtra("log-enabled", false));
        String stringExtra = intent.getStringExtra("dialog-type");
        this.f17223e = stringExtra != null ? OneTrustHelper.c.valueOf(stringExtra) : OneTrustHelper.c.Consent;
        if (Build.VERSION.SDK_INT < 35) {
            this.f17219a = new b(this, null);
            getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f17219a, true);
        }
        z();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f17219a != null) {
            getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f17219a);
        }
        boolean z10 = this.f17225g || this.f17222d.isOTUIPresent(this.f17220b);
        OneTrustHelper.logBreadcrumb("OneTrustLaunchActivity::onDestroy: dialog is closed with result '" + z10 + "'", this.f17221c);
        OneTrustHelper.onDialogClosed(this.f17223e, z10, this.f17224f);
        super.onDestroy();
    }

    private class b extends FragmentManager.FragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.bottomsheet.a f17227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f17228b;

        private class a implements ViewTreeObserver.OnGlobalLayoutListener {
            private a() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FrameLayout frameLayout;
                com.google.android.material.bottomsheet.a aVar = b.this.f17227a;
                if (aVar == null || (frameLayout = (FrameLayout) aVar.findViewById(f.f24825f)) == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                OneTrustLaunchActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                layoutParams.height = displayMetrics.heightPixels;
                frameLayout.setLayoutParams(layoutParams);
                frameLayout.requestLayout();
            }

            /* synthetic */ a(b bVar, a aVar) {
                this();
            }
        }

        private b() {
            this.f17228b = new a(this, null);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment instanceof com.google.android.material.bottomsheet.b) {
                this.f17227a = (com.google.android.material.bottomsheet.a) ((com.google.android.material.bottomsheet.b) fragment).getDialog();
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.f17228b);
            }
            super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        }

        /* synthetic */ b(OneTrustLaunchActivity oneTrustLaunchActivity, a aVar) {
            this();
        }
    }
}
