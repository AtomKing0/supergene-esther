package com.braze.ui.activities;

import androidx.fragment.app.FragmentActivity;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;

/* JADX INFO: compiled from: BrazeBaseFragmentActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeBaseFragmentActivity extends FragmentActivity {
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BrazeInAppMessageManager.Companion.getInstance().unregisterInAppMessageManager(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BrazeInAppMessageManager.Companion.getInstance().registerInAppMessageManager(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (BrazeInternal.INSTANCE.getConfigurationProvider(this).getShouldUseWindowFlagSecureInActivities()) {
            getWindow().setFlags(8192, 8192);
        }
        Braze.Companion.getInstance(this).openSession(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Braze.Companion.getInstance(this).closeSession(this);
    }
}
