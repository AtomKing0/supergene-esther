package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;

/* JADX INFO: loaded from: classes4.dex */
public class InterstitialActivity extends ControllerActivity {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f14849r = "InterstitialActivity";

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(f14849r, "onCreate");
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Logger.i(f14849r, v8.h.f15818t0);
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Logger.i(f14849r, v8.h.f15820u0);
    }
}
