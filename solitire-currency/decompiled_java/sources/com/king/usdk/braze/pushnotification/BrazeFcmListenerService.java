package com.king.usdk.braze.pushnotification;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.braze.push.BrazeFirebaseMessagingService;
import com.google.firebase.messaging.r0;
import com.king.usdk.braze.AndroidLogger;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BrazeFcmListenerService extends BrazeFirebaseMessagingService {
    private static final String TAG = "BrazeFcmListenerService";

    @Override // com.braze.push.BrazeFirebaseMessagingService, com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(r0 r0Var) {
        String str = TAG;
        AndroidLogger.d(str, "onMessageReceived: RemoteMessage received");
        Context applicationContext = getApplicationContext();
        if (!BrazeFirebaseMessagingService.isBrazePushNotification(r0Var)) {
            AndroidLogger.i(str, "handleMessageReceived: Ignoring RemoteMessage not originated by Braze.");
        } else if (BrazeFirebaseMessagingService.handleBrazeRemoteMessage(applicationContext, r0Var)) {
            AndroidLogger.d(str, "handleMessageReceived: Braze notification processed");
        } else {
            AndroidLogger.i(str, "handleMessageReceived: Braze notification NOT processed");
        }
    }

    @Override // com.braze.push.BrazeFirebaseMessagingService, com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NonNull String str) {
        super.onNewToken(str);
    }
}
