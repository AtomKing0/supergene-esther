package com.braze.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import com.braze.support.ReflectionUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.r0;
import h9.a;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeFirebaseMessagingService extends FirebaseMessagingService {

    @NotNull
    private static final String CONTEXT_ATTACH_METHOD = "attachBaseContext";

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String FCM_SERVICE_OMR_METHOD = "onMessageReceived";

    /* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final boolean handleBrazeRemoteMessage(@NotNull Context context, @NotNull r0 remoteMessage) {
            t.i(context, "context");
            t.i(remoteMessage, "remoteMessage");
            if (!isBrazePushNotification(remoteMessage)) {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.Priority priority = BrazeLogger.Priority.I;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1(remoteMessage), 6, (Object) null);
                BrazeConfigurationProvider configurationProvider = BrazeInternal.INSTANCE.getConfigurationProvider(context);
                if (!configurationProvider.isFallbackFirebaseMessagingServiceEnabled()) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$4.INSTANCE, 7, (Object) null);
                    return false;
                }
                String fallbackFirebaseMessagingServiceClasspath = configurationProvider.getFallbackFirebaseMessagingServiceClasspath();
                if (fallbackFirebaseMessagingServiceClasspath == null) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$3.INSTANCE, 7, (Object) null);
                    return false;
                }
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$2(fallbackFirebaseMessagingServiceClasspath), 6, (Object) null);
                invokeFallbackFirebaseService$android_sdk_ui_release(fallbackFirebaseMessagingServiceClasspath, remoteMessage, context);
                return false;
            }
            Map<String, String> data = remoteMessage.getData();
            t.h(data, "remoteMessage.data");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$5(data), 6, (Object) null);
            Intent intent = new Intent("firebase_messaging_service_routing_action");
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$6(key, value), 6, (Object) null);
                bundle.putString(key, value);
            }
            intent.putExtras(bundle);
            BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, context, intent, false, 4, null);
            return true;
        }

        public final void invokeFallbackFirebaseService$android_sdk_ui_release(@NotNull String classpath, @NotNull r0 remoteMessage, @NotNull Context context) {
            t.i(classpath, "classpath");
            t.i(remoteMessage, "remoteMessage");
            t.i(context, "context");
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object objConstructObjectQuietly$default = ReflectionUtils.constructObjectQuietly$default(reflectionUtils, classpath, null, null, 6, null);
            if (objConstructObjectQuietly$default == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$1(classpath), 7, (Object) null);
                return;
            }
            Method declaredMethodQuietly = reflectionUtils.getDeclaredMethodQuietly(classpath, BrazeFirebaseMessagingService.CONTEXT_ATTACH_METHOD, Context.class);
            if (declaredMethodQuietly == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$4.INSTANCE, 7, (Object) null);
                return;
            }
            declaredMethodQuietly.setAccessible(true);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$2(classpath), 7, (Object) null);
            if (!ReflectionUtils.invokeMethodQuietly(objConstructObjectQuietly$default, declaredMethodQuietly, context).c().booleanValue()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$3(classpath), 7, (Object) null);
                return;
            }
            Method methodQuietly = ReflectionUtils.getMethodQuietly(classpath, BrazeFirebaseMessagingService.FCM_SERVICE_OMR_METHOD, (Class<?>[]) new Class[]{r0.class});
            if (methodQuietly == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$5(classpath), 7, (Object) null);
            } else {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$6(classpath), 7, (Object) null);
                ReflectionUtils.invokeMethodQuietly(objConstructObjectQuietly$default, methodQuietly, remoteMessage).c().booleanValue();
            }
        }

        public final boolean isBrazePushNotification(@NotNull r0 remoteMessage) {
            t.i(remoteMessage, "remoteMessage");
            Map<String, String> data = remoteMessage.getData();
            t.h(data, "remoteMessage.data");
            return t.d(com.ironsource.mediationsdk.metadata.a.f13688g, data.get("_ab"));
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeFirebaseMessagingService$onNewToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ String $newToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(0);
            this.$newToken = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "No configured API key, not registering token in onNewToken. Token: " + this.$newToken;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeFirebaseMessagingService$onNewToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ String $newToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str) {
            super(0);
            this.$newToken = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Automatic FirebaseMessagingService.OnNewToken() registration disabled, not registering token: " + this.$newToken;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeFirebaseMessagingService$onNewToken$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ String $newToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str) {
            super(0);
            this.$newToken = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Registering Firebase push token in onNewToken. Token: " + this.$newToken;
        }
    }

    public static final boolean handleBrazeRemoteMessage(@NotNull Context context, @NotNull r0 r0Var) {
        return Companion.handleBrazeRemoteMessage(context, r0Var);
    }

    public static final boolean isBrazePushNotification(@NotNull r0 r0Var) {
        return Companion.isBrazePushNotification(r0Var);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(@NotNull r0 remoteMessage) {
        t.i(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        Companion.handleBrazeRemoteMessage(this, remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NotNull String newToken) {
        t.i(newToken, "newToken");
        super.onNewToken(newToken);
        BrazeInternal.applyPendingRuntimeConfiguration(this);
        BrazeConfigurationProvider configurationProvider = BrazeInternal.INSTANCE.getConfigurationProvider(this);
        Braze.Companion companion = Braze.Companion;
        String configuredApiKey = companion.getConfiguredApiKey(configurationProvider);
        if (configuredApiKey == null || configuredApiKey.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass1(newToken), 6, (Object) null);
        } else if (!configurationProvider.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass2(newToken), 6, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass3(newToken), 6, (Object) null);
            companion.getInstance(this).setRegisteredPushToken(newToken);
        }
    }
}
