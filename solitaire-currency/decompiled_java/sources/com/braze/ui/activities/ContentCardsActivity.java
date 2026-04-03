package com.braze.ui.activities;

import android.os.Bundle;
import com.braze.BrazeInternal;
import com.braze.ui.R$layout;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentCardsActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ContentCardsActivity extends BrazeBaseFragmentActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (BrazeInternal.INSTANCE.getConfigurationProvider(this).getShouldUseWindowFlagSecureInActivities()) {
            getWindow().setFlags(8192, 8192);
        }
        setContentView(R$layout.com_braze_content_cards_activity);
    }
}
