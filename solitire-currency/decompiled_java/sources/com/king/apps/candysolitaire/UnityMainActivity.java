package com.king.apps.candysolitaire;

import android.content.Intent;
import android.os.Bundle;
import com.king.usdk.lifecycle.UsdkLifecycle;
import com.unity3d.player.UnityPlayerActivity;

/* JADX INFO: loaded from: classes4.dex */
public class UnityMainActivity extends UnityPlayerActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f17038a = false;

    static {
        System.loadLibrary("usdk-all-bundle");
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        UsdkLifecycle.onActivityResult(i10, i11, intent);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UsdkLifecycle.onCreate(getIntent());
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        UsdkLifecycle.onDestroy();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        UsdkLifecycle.onNewIntent(intent);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        UsdkLifecycle.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (f17038a) {
            this.mUnityPlayer.windowFocusChanged(true);
        }
        f17038a = true;
        UsdkLifecycle.onResume();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        UsdkLifecycle.onStart();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        UsdkLifecycle.onStop();
    }
}
