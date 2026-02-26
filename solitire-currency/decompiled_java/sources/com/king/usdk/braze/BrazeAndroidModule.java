package com.king.usdk.braze;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.braze.Braze;
import com.braze.BrazeActivityLifecycleCallbackListener;
import com.braze.BrazeUser;
import com.braze.configuration.BrazeConfig;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.Orientation;
import com.braze.events.IEventSubscriber;
import com.braze.events.IValueCallback;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.MessageButton;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.ironsource.v8;
import com.king.usdk.logger.Logger;
import e0.a;
import io.sentry.protocol.SentryStackFrame;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import o0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BrazeAndroidModule implements IInAppMessageManagerListener, IHtmlInAppMessageActionListener, IEventSubscriber<NoMatchingTriggerEvent> {
    private Activity mActivity;
    private long mBrazeAndroidPointer;
    private Context mContext;
    private final Boolean mEnableAnimation;
    private final boolean mEnableExperimentalHtmlBridge;
    private final boolean mEnableGeofencing;
    private final boolean mEnableLocationTracking;
    private String mExternalUserId;
    private ForcedIGPOrientation mForcedIGPOrientation;
    private final Logger mLogger;
    private Handler mMainHandler;
    private final Lock mNativeCallbackLock = new ReentrantLock();
    private String noShowCampaignKey = "NoShowCampaign";
    private final String FineLocationPermission = "android.permission.ACCESS_FINE_LOCATION";
    private final String CoarseLocationPermission = "android.permission.ACCESS_COARSE_LOCATION";
    private final String BackgroundLocationPermission = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private AtomicBoolean mAllowInAppMessages = new AtomicBoolean(true);
    private AtomicBoolean mInitialised = new AtomicBoolean(false);

    public enum ForcedIGPOrientation {
        NONE,
        PORTRAIT,
        LANDSCAPE
    }

    public enum LocationAccessLevel {
        NEVER,
        WHILE_IN_USE,
        ALWAYS
    }

    public enum LocationPrecision {
        NOT_AUTHORIZED,
        APPROXIMATE,
        PRECISE
    }

    public enum ReasonType {
        NOTHING_TO_SHOW,
        IGPS_DISABLED,
        LOAD_NOT_ON_TIME,
        TIMEOUT
    }

    @UsedByNativeCode
    public BrazeAndroidModule(Activity activity, long j10, long j11, boolean z10, ForcedIGPOrientation forcedIGPOrientation, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.mForcedIGPOrientation = ForcedIGPOrientation.NONE;
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        this.mLogger = new Logger(j10, z10);
        this.mBrazeAndroidPointer = j11;
        this.mForcedIGPOrientation = forcedIGPOrientation;
        this.mEnableAnimation = Boolean.valueOf(z11);
        this.mEnableLocationTracking = z12;
        this.mEnableGeofencing = z13;
        this.mEnableExperimentalHtmlBridge = z14;
        this.mMainHandler = new Handler(this.mActivity.getApplicationContext().getMainLooper());
    }

    private boolean callNativeIsInAppMessageOnTime() {
        this.mNativeCallbackLock.lock();
        boolean zIsInAppMessageOnTime = false;
        try {
            long j10 = this.mBrazeAndroidPointer;
            if (j10 != 0) {
                zIsInAppMessageOnTime = isInAppMessageOnTime(j10);
            }
        } catch (Throwable unused) {
        }
        this.mNativeCallbackLock.unlock();
        return zIsInAppMessageOnTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void configureBraze(Activity activity, String str, String str2, String str3, int i10, String str4, String str5, boolean z10, int i11, boolean z11, int i12, boolean z12, boolean z13) {
        BrazeConfig.Builder pushHtmlRenderingEnabled = new BrazeConfig.Builder().setApiKey(str).setCustomEndpoint(str2).setIsFirebaseCloudMessagingRegistrationEnabled(true).setFirebaseCloudMessagingSenderIdKey(str3).setDefaultNotificationAccentColor(i10).setHandlePushDeepLinksAutomatically(true).setSessionTimeout(i11).setTriggerActionMinimumTimeIntervalSeconds(i12).setAutomaticGeofenceRequestsEnabled(z13).setGeofencesEnabled(z13).setIsLocationCollectionEnabled(z12).setPushHtmlRenderingEnabled(z10);
        if (!str4.isEmpty()) {
            pushHtmlRenderingEnabled.setSmallNotificationIcon(str4);
        }
        if (!str5.isEmpty()) {
            pushHtmlRenderingEnabled.setLargeNotificationIcon(str5);
        }
        Braze.configure(activity, pushHtmlRenderingEnabled.build());
        BrazeLogger.setLogLevel(z11 ? 2 : Integer.MAX_VALUE);
        BrazeActivityLifecycleCallbackListener brazeActivityLifecycleCallbackListener = new BrazeActivityLifecycleCallbackListener();
        activity.getApplication().registerActivityLifecycleCallbacks(brazeActivityLifecycleCallbackListener);
        brazeActivityLifecycleCallbackListener.onActivityCreated(activity, new Bundle());
        brazeActivityLifecycleCallbackListener.onActivityStarted(activity);
        brazeActivityLifecycleCallbackListener.onActivityResumed(activity);
    }

    private boolean hasBackgroundLocationPermission() {
        return ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
    }

    private static native boolean isInAppMessageOnTime(long j10);

    private boolean isTestMessage(IInAppMessage iInAppMessage) {
        String triggerId;
        return !(iInAppMessage instanceof InAppMessageBase) || (triggerId = ((InAppMessageBase) iInAppMessage).getTriggerId()) == null || triggerId.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnBrazeSdkReady() {
        this.mNativeCallbackLock.lock();
        try {
            long j10 = this.mBrazeAndroidPointer;
            if (j10 != 0) {
                onBrazeSdkReady(j10);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    private void notifyOnMessageInteract(int i10, String str, String str2, int i11, String[] strArr, String[] strArr2) {
        this.mNativeCallbackLock.lock();
        try {
            long j10 = this.mBrazeAndroidPointer;
            if (j10 != 0) {
                onMessageInteract(j10, i10, str, str2, i11, strArr, strArr2);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    private void notifyOnMessageShow(int i10, String[] strArr, String[] strArr2, int i11) {
        this.mNativeCallbackLock.lock();
        try {
            long j10 = this.mBrazeAndroidPointer;
            if (j10 != 0) {
                onMessageShow(j10, i10, strArr, strArr2, i11);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    private void notifyOnMessageWillNotShow(ReasonType reasonType, String str, String[] strArr, String[] strArr2) {
        this.mNativeCallbackLock.lock();
        try {
            long j10 = this.mBrazeAndroidPointer;
            if (j10 != 0) {
                onMessageWillNotShow(j10, reasonType.ordinal(), str, strArr, strArr2);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    private void notifyOnMessageWillShow(int i10, String[] strArr, String[] strArr2) {
        this.mNativeCallbackLock.lock();
        try {
            long j10 = this.mBrazeAndroidPointer;
            if (j10 != 0) {
                onMessageWillShow(j10, i10, strArr, strArr2);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    private static native void onBrazeSdkReady(long j10);

    private static native void onMessageInteract(long j10, int i10, String str, String str2, int i11, String[] strArr, String[] strArr2);

    private static native void onMessageShow(long j10, int i10, String[] strArr, String[] strArr2, int i11);

    private static native void onMessageWillNotShow(long j10, int i10, String str, String[] strArr, String[] strArr2);

    private static native void onMessageWillShow(long j10, int i10, String[] strArr, String[] strArr2);

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomUserAttributeHelper(BrazeUser brazeUser, String str, Object obj) {
        if (obj instanceof Boolean) {
            brazeUser.setCustomUserAttribute(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Integer) {
            brazeUser.setCustomUserAttribute(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            brazeUser.setCustomUserAttribute(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            brazeUser.setCustomUserAttribute(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            brazeUser.setCustomUserAttribute(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            brazeUser.setCustomUserAttribute(str, (String) obj);
        } else {
            this.mLogger.e("Unsupported type for custom user attribute");
        }
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public void afterInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        Map<String, String> extras = iInAppMessage.getExtras();
        notifyOnMessageShow(iInAppMessage.getMessageType().ordinal(), (String[]) extras.keySet().toArray(new String[0]), (String[]) extras.values().toArray(new String[0]), iInAppMessage.hashCode());
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage iInAppMessage) {
        if (!this.mAllowInAppMessages.get()) {
            notifyOnMessageWillNotShow(ReasonType.IGPS_DISABLED, "", null, null);
            this.mLogger.d("Discarding in app message as promotions are disabled");
            return InAppMessageOperation.DISCARD;
        }
        this.mLogger.d("processing in app message now");
        Map<String, String> extras = iInAppMessage.getExtras();
        String[] strArr = (String[]) extras.keySet().toArray(new String[0]);
        String[] strArr2 = (String[]) extras.values().toArray(new String[0]);
        if (isTestMessage(iInAppMessage)) {
            this.mLogger.d("Test campaign. Display right away");
            return InAppMessageOperation.DISPLAY_NOW;
        }
        if (extras.containsKey(this.noShowCampaignKey)) {
            this.mLogger.d("Not displaying. It's a NO SHOW In App Message");
            notifyOnMessageWillNotShow(ReasonType.NOTHING_TO_SHOW, "", strArr, strArr2);
            return InAppMessageOperation.REENQUEUE;
        }
        if (!callNativeIsInAppMessageOnTime()) {
            notifyOnMessageWillNotShow(ReasonType.LOAD_NOT_ON_TIME, "", strArr, strArr2);
            this.mLogger.d("Not displaying. In App Message is NOT ON TIME");
            return InAppMessageOperation.REENQUEUE;
        }
        ForcedIGPOrientation forcedIGPOrientation = this.mForcedIGPOrientation;
        if (forcedIGPOrientation == ForcedIGPOrientation.PORTRAIT) {
            iInAppMessage.setOrientation(Orientation.PORTRAIT);
        } else if (forcedIGPOrientation == ForcedIGPOrientation.LANDSCAPE) {
            iInAppMessage.setOrientation(Orientation.LANDSCAPE);
        }
        iInAppMessage.setAnimateIn(this.mEnableAnimation.booleanValue());
        iInAppMessage.setAnimateOut(this.mEnableAnimation.booleanValue());
        notifyOnMessageWillShow(iInAppMessage.getMessageType().ordinal(), strArr, strArr2);
        return InAppMessageOperation.DISPLAY_NOW;
    }

    @UsedByNativeCode
    public void configure(final String str, final String str2, final String str3, final int i10, final String str4, final String str5, final boolean z10, final int i11, final boolean z11, final int i12) {
        this.mMainHandler.post(new Runnable() { // from class: com.king.usdk.braze.BrazeAndroidModule.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // java.lang.Runnable
            public void run() {
                if (BrazeAndroidModule.this.mInitialised.get()) {
                    return;
                }
                BrazeAndroidModule.configureBraze(BrazeAndroidModule.this.mActivity, str, str2, str3, i10, str4, str5, z10, i11, z11, i12, BrazeAndroidModule.this.mEnableLocationTracking, BrazeAndroidModule.this.mEnableGeofencing);
                if (BrazeAndroidModule.this.mEnableExperimentalHtmlBridge) {
                    BrazeInAppMessageManager.getInstance().setCustomInAppMessageViewFactory(new CustomInAppMessageViewFactory(BrazeAndroidModule.this.mActivity));
                }
                BrazeInAppMessageManager.getInstance().setCustomInAppMessageManagerListener(BrazeAndroidModule.this);
                BrazeInAppMessageManager.getInstance().setCustomHtmlInAppMessageActionListener(BrazeAndroidModule.this);
                Braze.getInstance(BrazeAndroidModule.this.mContext).subscribeToNoMatchingTriggerForEvent(BrazeAndroidModule.this);
                BrazeAndroidModule.this.mInitialised.set(true);
                if (BrazeAndroidModule.this.mExternalUserId != null) {
                    BrazeAndroidModule.this.mLogger.i("setting cached externalUserId [" + BrazeAndroidModule.this.mExternalUserId + v8.i.f15839e);
                    BrazeAndroidModule brazeAndroidModule = BrazeAndroidModule.this;
                    brazeAndroidModule.setExternalUserId(brazeAndroidModule.mExternalUserId);
                }
                new BrazeConfigurationProvider(BrazeAndroidModule.this.mContext);
                BrazeAndroidModule.this.notifyOnBrazeSdkReady();
            }
        });
    }

    @UsedByNativeCode
    public void disable() {
        this.mAllowInAppMessages.set(false);
    }

    @UsedByNativeCode
    public void disconnectFromNativeSide() {
        this.mNativeCallbackLock.lock();
        try {
            this.mBrazeAndroidPointer = 0L;
            Braze.getInstance(this.mContext).removeSingleSubscription(this, NoMatchingTriggerEvent.class);
            BrazeInAppMessageManager.getInstance().setCustomHtmlInAppMessageActionListener(null);
            BrazeInAppMessageManager.getInstance().setCustomInAppMessageManagerListener(null);
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    @UsedByNativeCode
    public void enable() {
        this.mAllowInAppMessages.set(true);
    }

    @UsedByNativeCode
    public void enableBackgroundLocation() {
        if (Build.VERSION.SDK_INT >= 29) {
            if (!hasBackgroundLocationPermission()) {
                ActivityCompat.requestPermissions(this.mActivity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 0);
            } else {
                this.mLogger.i("Initialize request location");
                initializeRequestLocation();
            }
        }
    }

    @UsedByNativeCode
    public void enableLocationTracking() {
        if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.shouldShowRequestPermissionRationale(this.mActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            enableBackgroundLocation();
        } else {
            ActivityCompat.requestPermissions(this.mActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0);
        }
    }

    @UsedByNativeCode
    public LocationAccessLevel getLocationAccessLevel() {
        return getLocationPrecision() == LocationPrecision.NOT_AUTHORIZED ? LocationAccessLevel.NEVER : hasBackgroundLocationPermission() ? LocationAccessLevel.ALWAYS : LocationAccessLevel.WHILE_IN_USE;
    }

    @UsedByNativeCode
    public LocationPrecision getLocationPrecision() {
        return ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 ? LocationPrecision.PRECISE : ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? LocationPrecision.APPROXIMATE : LocationPrecision.NOT_AUTHORIZED;
    }

    @UsedByNativeCode
    public boolean hasPreciseLocation() {
        return ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    @UsedByNativeCode
    public void initializeRequestLocation() {
        Braze.getInstance(this.mContext).requestLocationInitialization();
    }

    @UsedByNativeCode
    public boolean isEnabled() {
        return this.mAllowInAppMessages.get();
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public void onCloseClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Map<String, String> extras = iInAppMessage.getExtras();
        notifyOnMessageInteract(0, "", str, iInAppMessage.hashCode(), (String[]) extras.keySet().toArray(new String[0]), (String[]) extras.values().toArray(new String[0]));
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public boolean onCustomEventFired(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return false;
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* bridge */ /* synthetic */ boolean onInAppMessageButtonClicked(@NotNull IInAppMessage iInAppMessage, @NotNull MessageButton messageButton, @Nullable InAppMessageCloser inAppMessageCloser) {
        return b.f(this, iInAppMessage, messageButton, inAppMessageCloser);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* bridge */ /* synthetic */ boolean onInAppMessageClicked(@NotNull IInAppMessage iInAppMessage, @Nullable InAppMessageCloser inAppMessageCloser) {
        return b.h(this, iInAppMessage, inAppMessageCloser);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public void onInAppMessageDismissed(IInAppMessage iInAppMessage) {
        Map<String, String> extras = iInAppMessage.getExtras();
        notifyOnMessageInteract(0, "", "", iInAppMessage.hashCode(), (String[]) extras.keySet().toArray(new String[0]), (String[]) extras.values().toArray(new String[0]));
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public boolean onNewsfeedClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return false;
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public boolean onOtherUrlAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        Map<String, String> extras = iInAppMessage.getExtras();
        notifyOnMessageInteract(1, bundle.containsKey("abButtonId") ? bundle.getString("abButtonId") : new String(""), str, iInAppMessage.hashCode(), (String[]) extras.keySet().toArray(new String[0]), (String[]) extras.values().toArray(new String[0]));
        return false;
    }

    @UsedByNativeCode
    public void setCustomUserAttribute(final String str, final Object obj) {
        Braze.getInstance(this.mActivity).getCurrentUser(new IValueCallback<BrazeUser>() { // from class: com.king.usdk.braze.BrazeAndroidModule.3
            @Override // com.braze.events.IValueCallback
            public /* bridge */ /* synthetic */ void onError() {
                a.a(this);
            }

            @Override // com.braze.events.IValueCallback
            public void onSuccess(BrazeUser brazeUser) {
                BrazeAndroidModule.this.setCustomUserAttributeHelper(brazeUser, str, obj);
            }
        });
    }

    @UsedByNativeCode
    public void setCustomUserAttributeToNow(final String str) {
        Braze.getInstance(this.mActivity).getCurrentUser(new IValueCallback<BrazeUser>() { // from class: com.king.usdk.braze.BrazeAndroidModule.5
            @Override // com.braze.events.IValueCallback
            public /* bridge */ /* synthetic */ void onError() {
                a.a(this);
            }

            @Override // com.braze.events.IValueCallback
            public void onSuccess(BrazeUser brazeUser) {
                brazeUser.setCustomUserAttributeToNow(str);
            }
        });
    }

    @UsedByNativeCode
    public void setCustomUserAttributeToSecondsFromEpoch(final String str, final long j10) {
        Braze.getInstance(this.mActivity).getCurrentUser(new IValueCallback<BrazeUser>() { // from class: com.king.usdk.braze.BrazeAndroidModule.6
            @Override // com.braze.events.IValueCallback
            public /* bridge */ /* synthetic */ void onError() {
                a.a(this);
            }

            @Override // com.braze.events.IValueCallback
            public void onSuccess(BrazeUser brazeUser) {
                brazeUser.setCustomUserAttributeToSecondsFromEpoch(str, j10);
            }
        });
    }

    @UsedByNativeCode
    public void setExternalUserId(final String str) {
        this.mMainHandler.post(new Runnable() { // from class: com.king.usdk.braze.BrazeAndroidModule.8
            @Override // java.lang.Runnable
            public void run() {
                BrazeAndroidModule.this.mLogger.d("setExternalUserId [" + str + v8.i.f15839e);
                if (BrazeAndroidModule.this.mInitialised.get()) {
                    Braze.getInstance(BrazeAndroidModule.this.mActivity).changeUser(str);
                } else {
                    BrazeAndroidModule.this.mLogger.i("CACHED setExternalUserId [" + str + "] received before initialisation");
                }
                BrazeAndroidModule.this.mExternalUserId = str;
            }
        });
    }

    @UsedByNativeCode
    public void setMultipleCustomUserAttributes(final HashMap<String, Object> map) {
        Braze.getInstance(this.mActivity).getCurrentUser(new IValueCallback<BrazeUser>() { // from class: com.king.usdk.braze.BrazeAndroidModule.4
            @Override // com.braze.events.IValueCallback
            public /* bridge */ /* synthetic */ void onError() {
                a.a(this);
            }

            @Override // com.braze.events.IValueCallback
            public void onSuccess(BrazeUser brazeUser) {
                for (Map.Entry entry : map.entrySet()) {
                    BrazeAndroidModule.this.setCustomUserAttributeHelper(brazeUser, (String) entry.getKey(), entry.getValue());
                }
            }
        });
    }

    @UsedByNativeCode
    public void showLocationSettingsDialog() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(SentryStackFrame.JsonKeys.PACKAGE, this.mContext.getPackageName(), null));
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }

    @UsedByNativeCode
    public void triggerCustomEvent(final String str, HashMap<String, Object> map) {
        final BrazeProperties brazeProperties = new BrazeProperties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            brazeProperties.addProperty(entry.getKey(), entry.getValue());
        }
        this.mMainHandler.post(new Runnable() { // from class: com.king.usdk.braze.BrazeAndroidModule.2
            @Override // java.lang.Runnable
            public void run() {
                BrazeAndroidModule.this.mLogger.d("triggerPlacement [" + str + v8.i.f15839e);
                if (BrazeAndroidModule.this.mInitialised.get()) {
                    Braze.getInstance(BrazeAndroidModule.this.mActivity).logCustomEvent(str, brazeProperties);
                    return;
                }
                BrazeAndroidModule.this.mLogger.i("DROPPED triggerPlacement [" + str + "] happening before initialisation");
            }
        });
    }

    @UsedByNativeCode
    public void unsetCustomUserAttribute(final String str) {
        Braze.getInstance(this.mActivity).getCurrentUser(new IValueCallback<BrazeUser>() { // from class: com.king.usdk.braze.BrazeAndroidModule.7
            @Override // com.braze.events.IValueCallback
            public /* bridge */ /* synthetic */ void onError() {
                a.a(this);
            }

            @Override // com.braze.events.IValueCallback
            public void onSuccess(BrazeUser brazeUser) {
                brazeUser.unsetCustomUserAttribute(str);
            }
        });
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton) {
        Map<String, String> extras = iInAppMessage.getExtras();
        String[] strArr = (String[]) extras.keySet().toArray(new String[0]);
        String[] strArr2 = (String[]) extras.values().toArray(new String[0]);
        notifyOnMessageInteract(1, messageButton.getStringId(), messageButton.getUri() != null ? messageButton.getUri().toString().toString() : "", iInAppMessage.hashCode(), strArr, strArr2);
        return false;
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public boolean onInAppMessageClicked(IInAppMessage iInAppMessage) {
        Map<String, String> extras = iInAppMessage.getExtras();
        notifyOnMessageInteract(1, "", "", iInAppMessage.hashCode(), (String[]) extras.keySet().toArray(new String[0]), (String[]) extras.values().toArray(new String[0]));
        return false;
    }

    @Override // com.braze.events.IEventSubscriber
    public void trigger(NoMatchingTriggerEvent noMatchingTriggerEvent) {
        if (noMatchingTriggerEvent.getSourceEventType() == "custom_event") {
            notifyOnMessageWillNotShow(ReasonType.NOTHING_TO_SHOW, "", null, null);
        }
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public void afterInAppMessageViewClosed(IInAppMessage iInAppMessage) {
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public void beforeInAppMessageViewClosed(View view, IInAppMessage iInAppMessage) {
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public void beforeInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
    }
}
