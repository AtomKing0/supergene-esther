package com.braze.ui.inappmessage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.Orientation;
import com.braze.events.BrazeUserChangeEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.models.inappmessage.InAppMessageImmersiveBase;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import com.braze.support.PermissionUtils;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer;
import com.braze.ui.inappmessage.views.IInAppMessageImmersiveView;
import com.braze.ui.inappmessage.views.IInAppMessageView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.support.ViewUtils;
import h9.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.a0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public class BrazeInAppMessageManager extends InAppMessageManagerBase {

    @Nullable
    private static volatile BrazeInAppMessageManager instance;

    @Nullable
    private IEventSubscriber<BrazeUserChangeEvent> brazeUserChangeEventSubscriber;

    @Nullable
    private IInAppMessage carryoverInAppMessage;

    @Nullable
    private BrazeConfigurationProvider configurationProvider;

    @Nullable
    private IEventSubscriber<InAppMessageEvent> inAppMessageEventSubscriber;

    @Nullable
    private IInAppMessageViewWrapper inAppMessageViewWrapper;

    @Nullable
    private Integer originalOrientation;

    @Nullable
    private IEventSubscriber<SdkDataWipeEvent> sdkDataWipeEventSubscriber;

    @Nullable
    private IInAppMessage unregisteredInAppMessage;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ReentrantLock instanceLock = new ReentrantLock();

    @NotNull
    private final IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener = new DefaultInAppMessageViewLifecycleListener();

    @NotNull
    public final AtomicBoolean displayingInAppMessage = new AtomicBoolean(false);

    @NotNull
    private final Stack<IInAppMessage> inAppMessageStack = new Stack<>();

    @NotNull
    private final Map<IInAppMessage, InAppMessageEvent> inAppMessageEventMap = new LinkedHashMap();

    @NotNull
    private String currentUserId = "";

    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean containsPushPermissionPrompt(IInAppMessage iInAppMessage) {
            return iInAppMessage instanceof InAppMessageHtml ? ((InAppMessageHtml) iInAppMessage).isPushPrimer() : BrazeActionUtils.containsAnyPushPermissionBrazeActions(iInAppMessage);
        }

        @NotNull
        public final BrazeInAppMessageManager getInstance() {
            if (BrazeInAppMessageManager.instance != null) {
                BrazeInAppMessageManager brazeInAppMessageManager = BrazeInAppMessageManager.instance;
                t.g(brazeInAppMessageManager, "null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
                return brazeInAppMessageManager;
            }
            ReentrantLock reentrantLock = BrazeInAppMessageManager.instanceLock;
            reentrantLock.lock();
            try {
                if (BrazeInAppMessageManager.instance == null) {
                    BrazeInAppMessageManager.instance = new BrazeInAppMessageManager();
                }
                k0 k0Var = k0.f35197a;
                reentrantLock.unlock();
                BrazeInAppMessageManager brazeInAppMessageManager2 = BrazeInAppMessageManager.instance;
                t.g(brazeInAppMessageManager2, "null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
                return brazeInAppMessageManager2;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppMessageOperation.values().length];
            try {
                iArr[InAppMessageOperation.DISPLAY_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppMessageOperation.DISPLAY_LATER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppMessageOperation.DISCARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InAppMessageOperation.REENQUEUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ IInAppMessage $inAppMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IInAppMessage iInAppMessage) {
            super(0);
            this.$inAppMessage = iInAppMessage;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Attempting to display in-app message with payload: " + JsonUtils.getPrettyPrintedString(this.$inAppMessage.forJsonPut());
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$10, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass10 extends v implements a<String> {
        public static final AnonymousClass10 INSTANCE = new AnonymousClass10();

        AnonymousClass10() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Creating view wrapper for base in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$11, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass11 extends v implements a<String> {
        public static final AnonymousClass11 INSTANCE = new AnonymousClass11();

        AnonymousClass11() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Creating view wrapper for in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$12, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass12 extends v implements a<String> {
        public static final AnonymousClass12 INSTANCE = new AnonymousClass12();

        AnonymousClass12() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message view includes HTML. Delaying display until the content has finished loading.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$14, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass14 extends v implements a<String> {
        final /* synthetic */ IInAppMessage $inAppMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(IInAppMessage iInAppMessage) {
            super(0);
            this.$inAppMessage = iInAppMessage;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Could not display in-app message with payload: " + JsonUtils.getPrettyPrintedString(this.$inAppMessage.forJsonPut());
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "A in-app message is currently being displayed. Adding in-app message back on the stack.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Expiration timestamp not defined. Continuing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not displaying control in-app message. Logging impression and ending display execution.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$5, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot show message containing an invalid Braze Action.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$6, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass6 extends v implements a<String> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Attempting to perform any fallback actions.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$7, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass7 extends v implements a<String> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        AnonymousClass7() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot show message containing a Push Prompt due to existing push prompt status, Android API version, or Target SDK level.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$8, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass8 extends v implements a<String> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        AnonymousClass8() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Attempting to perform any fallback actions.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$displayInAppMessage$9, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class AnonymousClass9 extends v implements a<String> {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        AnonymousClass9() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Creating view wrapper for immersive in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11611 extends v implements a<String> {
        public static final C11611 INSTANCE = new C11611();

        C11611() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Removing existing in-app message event subscriber before subscribing a new one.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11622 extends v implements a<String> {
        public static final C11622 INSTANCE = new C11622();

        C11622() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Subscribing in-app message event subscriber";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11634 extends v implements a<String> {
        public static final C11634 INSTANCE = new C11634();

        C11634() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Removing existing sdk data wipe event subscriber before subscribing a new one.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11645 extends v implements a<String> {
        public static final C11645 INSTANCE = new C11645();

        C11645() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Subscribing sdk data wipe subscriber";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11658 extends v implements a<String> {
        public static final C11658 INSTANCE = new C11658();

        C11658() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Removing existing user change event subscriber before subscribing a new one.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$registerInAppMessageManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11661 extends v implements a<String> {
        public static final C11661 INSTANCE = new C11661();

        C11661() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Null Activity passed to registerInAppMessageManager. Doing nothing";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$registerInAppMessageManager$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11672 extends v implements a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11672(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Registering InAppMessageManager with activity: " + this.$activity.getLocalClassName();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$registerInAppMessageManager$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11683 extends v implements a<String> {
        public static final C11683 INSTANCE = new C11683();

        C11683() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Activity had null applicationContext in registerInAppMessageManager. Doing Nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$registerInAppMessageManager$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11698 extends v implements a<String> {
        public static final C11698 INSTANCE = new C11698();

        C11698() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error while calling attempting to register the InAppMessageManager";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11701 extends v implements a<String> {
        public static final C11701 INSTANCE = new C11701();

        C11701() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "No activity is currently registered to receive in-app messages. Saving in-app message as unregistered in-app message. It will automatically be displayed when the next activity registers to receive in-app messages.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$10, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C117110 extends v implements a<String> {
        public static final C117110 INSTANCE = new C117110();

        C117110() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error running requestDisplayInAppMessage";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11722 extends v implements a<String> {
        public static final C11722 INSTANCE = new C11722();

        C11722() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "No activity is currently registered to receive in-app messages and the in-app message stack is empty. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11733 extends v implements a<String> {
        public static final C11733 INSTANCE = new C11733();

        C11733() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "A in-app message is currently being displayed. Ignoring request to display in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11744 extends v implements a<String> {
        public static final C11744 INSTANCE = new C11744();

        C11744() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The in-app message stack is empty. No in-app message will be displayed.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11755 extends v implements a<String> {
        public static final C11755 INSTANCE = new C11755();

        C11755() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISPLAY_NOW. The in-app message will be displayed.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11766 extends v implements a<String> {
        public static final C11766 INSTANCE = new C11766();

        C11766() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISPLAY_LATER. The in-app message will be pushed back onto the stack.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11777 extends v implements a<String> {
        public static final C11777 INSTANCE = new C11777();

        C11777() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISCARD. The in-app message will not be displayed and will not be put back on the stack.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11788 extends v implements a<String> {
        public static final C11788 INSTANCE = new C11788();

        C11788() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned REENQUEUE. The in-app message will not be displayed and will be marked as eligible for next time.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$requestDisplayInAppMessage$9, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11799 extends v implements a<String> {
        final /* synthetic */ IInAppMessage $inAppMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11799(IInAppMessage iInAppMessage) {
            super(0);
            this.$inAppMessage = iInAppMessage;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "An in-app message was requested to be re-enqueued, but it was not found. Discarding instead. In-app message = " + this.$inAppMessage;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$resetAfterInAppMessageClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11801 extends v implements a<String> {
        public static final C11801 INSTANCE = new C11801();

        C11801() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Resetting after in-app message close.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$resetAfterInAppMessageClose$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11812 extends v implements a<String> {
        final /* synthetic */ Integer $origOrientation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11812(Integer num) {
            super(0);
            this.$origOrientation = num;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting requested orientation to original orientation " + this.$origOrientation;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$unregisterInAppMessageManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11821 extends v implements a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11821(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            StringBuilder sb = new StringBuilder();
            sb.append("Skipping unregistration due to setShouldNextUnregisterBeSkipped being true. Activity: ");
            Activity activity = this.$activity;
            sb.append(activity != null ? activity.getLocalClassName() : null);
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$unregisterInAppMessageManager$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11832 extends v implements a<String> {
        public static final C11832 INSTANCE = new C11832();

        C11832() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Null Activity passed to unregisterInAppMessageManager.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$unregisterInAppMessageManager$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11843 extends v implements a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11843(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Unregistering InAppMessageManager from activity: " + this.$activity.getLocalClassName();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$unregisterInAppMessageManager$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11854 extends v implements a<String> {
        public static final C11854 INSTANCE = new C11854();

        C11854() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message view includes HTML. Removing the page finished listener.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$unregisterInAppMessageManager$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11865 extends v implements a<String> {
        public static final C11865 INSTANCE = new C11865();

        C11865() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error while calling attempting to unregister the InAppMessageManager";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$verifyOrientationStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11871 extends v implements a<String> {
        public static final C11871 INSTANCE = new C11871();

        C11871() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot verify orientation status with null Activity.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$verifyOrientationStatus$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11882 extends v implements a<String> {
        public static final C11882 INSTANCE = new C11882();

        C11882() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Running on tablet. In-app message can be displayed in any orientation.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$verifyOrientationStatus$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11893 extends v implements a<String> {
        public static final C11893 INSTANCE = new C11893();

        C11893() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Any orientation specified. In-app message can be displayed in any orientation.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.BrazeInAppMessageManager$verifyOrientationStatus$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInAppMessageManager.kt */
    static final class C11904 extends v implements a<String> {
        public static final C11904 INSTANCE = new C11904();

        C11904() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Requesting orientation lock.";
        }
    }

    private final IEventSubscriber<BrazeUserChangeEvent> createBrazeUserChangeEventSubscriber(final Context context) {
        return new IEventSubscriber() { // from class: l0.d
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                BrazeInAppMessageManager.createBrazeUserChangeEventSubscriber$lambda$10(this.f30204a, context, (BrazeUserChangeEvent) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createBrazeUserChangeEventSubscriber$lambda$10(BrazeInAppMessageManager this$0, Context context, BrazeUserChangeEvent event) {
        t.i(this$0, "this$0");
        t.i(context, "$context");
        t.i(event, "event");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, priority, (Throwable) null, false, (a) new BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$1(event), 6, (Object) null);
        if (!BrazeInternal.INSTANCE.getConfigurationProvider(context).isPreventInAppMessageDisplayForDifferentUsersEnabled()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, priority, (Throwable) null, false, (a) BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$2.INSTANCE, 6, (Object) null);
            return;
        }
        String currentUserId = event.getCurrentUserId();
        this$0.currentUserId = currentUserId;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$3(currentUserId), 7, (Object) null);
        a0.L(this$0.inAppMessageStack, new BrazeInAppMessageManager$createBrazeUserChangeEventSubscriber$1$4(this$0, currentUserId));
        if (!this$0.isInAppMessageForTheSameUser(this$0.carryoverInAppMessage, currentUserId)) {
            this$0.carryoverInAppMessage = null;
        }
        if (this$0.isInAppMessageForTheSameUser(this$0.unregisteredInAppMessage, currentUserId)) {
            return;
        }
        this$0.unregisteredInAppMessage = null;
    }

    private final IEventSubscriber<InAppMessageEvent> createInAppMessageEventSubscriber() {
        return new IEventSubscriber() { // from class: l0.c
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                BrazeInAppMessageManager.createInAppMessageEventSubscriber$lambda$9(this.f30203a, (InAppMessageEvent) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createInAppMessageEventSubscriber$lambda$9(BrazeInAppMessageManager this$0, InAppMessageEvent event) {
        t.i(this$0, "this$0");
        t.i(event, "event");
        IInAppMessage inAppMessage = event.getInAppMessage();
        this$0.inAppMessageEventMap.put(inAppMessage, event);
        this$0.addInAppMessage(inAppMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayInAppMessage$lambda$8(IInAppMessageViewWrapper iInAppMessageViewWrapper, BrazeInAppMessageManager this$0, Activity activity) {
        t.i(this$0, "this$0");
        if (iInAppMessageViewWrapper != null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeInAppMessageManager$displayInAppMessage$13$1.INSTANCE, 7, (Object) null);
                iInAppMessageViewWrapper.open(activity);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.E, (Throwable) e10, false, (a) BrazeInAppMessageManager$displayInAppMessage$13$2.INSTANCE, 4, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureSubscribedToInAppMessageEvents$lambda$1(BrazeInAppMessageManager this$0, SdkDataWipeEvent it) {
        t.i(this$0, "this$0");
        t.i(it, "it");
        this$0.inAppMessageStack.clear();
        this$0.carryoverInAppMessage = null;
        this$0.unregisteredInAppMessage = null;
    }

    @NotNull
    public static final BrazeInAppMessageManager getInstance() {
        return Companion.getInstance();
    }

    public void addInAppMessage(@Nullable IInAppMessage iInAppMessage) {
        if (iInAppMessage != null) {
            this.inAppMessageStack.push(iInAppMessage);
            requestDisplayInAppMessage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.braze.ui.inappmessage.IInAppMessageViewWrapper] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.app.Activity] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.braze.models.inappmessage.IInAppMessage] */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.app.Activity, android.content.Context] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.braze.ui.inappmessage.IInAppMessageViewFactory] */
    public void displayInAppMessage(@NotNull IInAppMessage inAppMessage, boolean z10) {
        ?? r14;
        Throwable th;
        ?? r142;
        ?? r11;
        IInAppMessageViewWrapper iInAppMessageViewWrapperCreateInAppMessageViewWrapper;
        ?? r12;
        final ?? CreateInAppMessageViewWrapper;
        ?? r122;
        final ?? r112;
        t.i(inAppMessage, "inAppMessage");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass1(inAppMessage), 6, (Object) null);
        if (!this.displayingInAppMessage.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 7, (Object) null);
            this.inAppMessageStack.push(inAppMessage);
            return;
        }
        try {
            r14 = this.mActivity;
            try {
                if (r14 == 0) {
                    this.carryoverInAppMessage = inAppMessage;
                    throw new Exception("No Activity is currently registered to receive in-app messages. Registering in-app message as carry-over in-app message. It will automatically be displayed when the next Activity registers to receive in-app messages.");
                }
                long expirationTimestamp = inAppMessage.getExpirationTimestamp();
                if (expirationTimestamp > 0) {
                    try {
                        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
                        if (jNowInMilliseconds > expirationTimestamp) {
                            throw new Exception("In-app message is expired. Doing nothing. Expiration: " + expirationTimestamp + ". Current time: " + jNowInMilliseconds);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r142 = inAppMessage;
                    }
                } else {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass3.INSTANCE, 7, (Object) null);
                }
                if (!verifyOrientationStatus(inAppMessage)) {
                    throw new Exception("Current orientation did not match specified orientation for in-app message. Doing nothing.");
                }
                BrazeConfigurationProvider brazeConfigurationProvider = this.configurationProvider;
                if (brazeConfigurationProvider == null) {
                    throw new Exception("configurationProvider is null. The in-app message will not be displayed and will not beput back on the stack.");
                }
                if (brazeConfigurationProvider.isPreventInAppMessageDisplayForDifferentUsersEnabled() && !isInAppMessageForTheSameUser(inAppMessage, this.currentUserId)) {
                    throw new Exception("The last identifier user " + this.currentUserId + " does not match the in-app message's user. The in-app message will not be displayed and will not be put back on the stack.");
                }
                if (inAppMessage.isControl()) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass4.INSTANCE, 7, (Object) null);
                    inAppMessage.logImpression();
                    resetAfterInAppMessageClose();
                    return;
                }
                if (BrazeActionUtils.containsInvalidBrazeAction(inAppMessage)) {
                    InAppMessageEvent inAppMessageEvent = this.inAppMessageEventMap.get(inAppMessage);
                    BrazeLogger.Priority priority = BrazeLogger.Priority.I;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (a) AnonymousClass5.INSTANCE, 6, (Object) null);
                    if (inAppMessageEvent != null) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (a) AnonymousClass6.INSTANCE, 6, (Object) null);
                        Context applicationContext = r14.getApplicationContext();
                        t.h(applicationContext, "activity.applicationContext");
                        BrazeInternal.retryInAppMessage(applicationContext, inAppMessageEvent);
                    }
                    resetAfterInAppMessageClose();
                    return;
                }
                if (Companion.containsPushPermissionPrompt(inAppMessage) && !PermissionUtils.wouldPushPermissionPromptDisplay(r14)) {
                    InAppMessageEvent inAppMessageEvent2 = this.inAppMessageEventMap.get(inAppMessage);
                    BrazeLogger.Priority priority2 = BrazeLogger.Priority.I;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority2, (Throwable) null, false, (a) AnonymousClass7.INSTANCE, 6, (Object) null);
                    if (inAppMessageEvent2 != null) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority2, (Throwable) null, false, (a) AnonymousClass8.INSTANCE, 6, (Object) null);
                        Context applicationContext2 = r14.getApplicationContext();
                        t.h(applicationContext2, "activity.applicationContext");
                        BrazeInternal.retryInAppMessage(applicationContext2, inAppMessageEvent2);
                    }
                    resetAfterInAppMessageClose();
                    return;
                }
                ?? inAppMessageViewFactory = getInAppMessageViewFactory(inAppMessage);
                if (inAppMessageViewFactory == 0) {
                    throw new Exception("ViewFactory from getInAppMessageViewFactory was null.");
                }
                ?? CreateInAppMessageView = inAppMessageViewFactory.createInAppMessageView(r14, inAppMessage);
                if (CreateInAppMessageView == 0) {
                    throw new Exception("The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack.");
                }
                if (CreateInAppMessageView.getParent() != null) {
                    throw new Exception("The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack.");
                }
                Animation openingAnimation = getInAppMessageAnimationFactory().getOpeningAnimation(inAppMessage);
                Animation closingAnimation = getInAppMessageAnimationFactory().getClosingAnimation(inAppMessage);
                ?? inAppMessageViewWrapperFactory = getInAppMessageViewWrapperFactory();
                if (CreateInAppMessageView instanceof IInAppMessageImmersiveView) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass9.INSTANCE, 7, (Object) null);
                    IInAppMessageImmersiveView iInAppMessageImmersiveView = (IInAppMessageImmersiveView) CreateInAppMessageView;
                    try {
                        CreateInAppMessageViewWrapper = inAppMessageViewWrapperFactory.createInAppMessageViewWrapper(CreateInAppMessageView, inAppMessage, this.inAppMessageViewLifecycleListener, brazeConfigurationProvider, openingAnimation, closingAnimation, iInAppMessageImmersiveView.getMessageClickableView(), iInAppMessageImmersiveView.getMessageButtonViews(((InAppMessageImmersiveBase) inAppMessage).getMessageButtons().size()), iInAppMessageImmersiveView.getMessageCloseButtonView());
                        r112 = r14;
                        r122 = CreateInAppMessageView;
                    } catch (Throwable th3) {
                        th = th3;
                        r142 = inAppMessage;
                    }
                } else {
                    try {
                        if (CreateInAppMessageView instanceof IInAppMessageView) {
                            r11 = r14;
                            ?? r123 = CreateInAppMessageView;
                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass10.INSTANCE, 7, (Object) null);
                            iInAppMessageViewWrapperCreateInAppMessageViewWrapper = inAppMessageViewWrapperFactory.createInAppMessageViewWrapper(r123, inAppMessage, this.inAppMessageViewLifecycleListener, brazeConfigurationProvider, openingAnimation, closingAnimation, ((IInAppMessageView) r123).getMessageClickableView());
                            r12 = r123;
                        } else {
                            r11 = r14;
                            ?? r124 = CreateInAppMessageView;
                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass11.INSTANCE, 7, (Object) null);
                            iInAppMessageViewWrapperCreateInAppMessageViewWrapper = inAppMessageViewWrapperFactory.createInAppMessageViewWrapper(r124, inAppMessage, this.inAppMessageViewLifecycleListener, brazeConfigurationProvider, openingAnimation, closingAnimation, r124);
                            r12 = r124;
                        }
                        CreateInAppMessageViewWrapper = iInAppMessageViewWrapperCreateInAppMessageViewWrapper;
                        r112 = r11;
                        r122 = r12;
                    } catch (Throwable th4) {
                        th = th4;
                        r14 = inAppMessage;
                    }
                }
                this.inAppMessageViewWrapper = CreateInAppMessageViewWrapper;
                if (r122 instanceof InAppMessageHtmlBaseView) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass12.INSTANCE, 7, (Object) null);
                    ((InAppMessageHtmlBaseView) r122).setHtmlPageFinishedListener(new IWebViewClientStateListener() { // from class: l0.b
                        @Override // com.braze.ui.inappmessage.listeners.IWebViewClientStateListener
                        public final void onPageFinished() {
                            BrazeInAppMessageManager.displayInAppMessage$lambda$8(CreateInAppMessageViewWrapper, this, r112);
                        }
                    });
                    return;
                } else {
                    if (CreateInAppMessageViewWrapper != 0) {
                        CreateInAppMessageViewWrapper.open(r112);
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            r14 = inAppMessage;
        }
        th = th;
        r142 = r14;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th, false, (a) new AnonymousClass14(r142), 4, (Object) null);
        resetAfterInAppMessageClose();
    }

    public void ensureSubscribedToInAppMessageEvents(@NotNull Context context) {
        t.i(context, "context");
        if (this.inAppMessageEventSubscriber != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11611.INSTANCE, 7, (Object) null);
            Braze.Companion.getInstance(context).removeSingleSubscription(this.inAppMessageEventSubscriber, InAppMessageEvent.class);
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11622.INSTANCE, 7, (Object) null);
        IEventSubscriber<InAppMessageEvent> iEventSubscriberCreateInAppMessageEventSubscriber = createInAppMessageEventSubscriber();
        Braze.Companion companion = Braze.Companion;
        companion.getInstance(context).subscribeToNewInAppMessages(iEventSubscriberCreateInAppMessageEventSubscriber);
        this.inAppMessageEventSubscriber = iEventSubscriberCreateInAppMessageEventSubscriber;
        if (this.sdkDataWipeEventSubscriber != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11634.INSTANCE, 6, (Object) null);
            companion.getInstance(context).removeSingleSubscription(this.sdkDataWipeEventSubscriber, SdkDataWipeEvent.class);
        }
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (a) C11645.INSTANCE, 6, (Object) null);
        IEventSubscriber<SdkDataWipeEvent> iEventSubscriber = new IEventSubscriber() { // from class: l0.a
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                BrazeInAppMessageManager.ensureSubscribedToInAppMessageEvents$lambda$1(this.f30199a, (SdkDataWipeEvent) obj);
            }
        };
        companion.getInstance(context).addSingleSynchronousSubscription(iEventSubscriber, SdkDataWipeEvent.class);
        this.sdkDataWipeEventSubscriber = iEventSubscriber;
        if (this.brazeUserChangeEventSubscriber != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (a) C11658.INSTANCE, 6, (Object) null);
            companion.getInstance(context).removeSingleSubscription(this.brazeUserChangeEventSubscriber, BrazeUserChangeEvent.class);
        }
        IEventSubscriber<BrazeUserChangeEvent> iEventSubscriberCreateBrazeUserChangeEventSubscriber = createBrazeUserChangeEventSubscriber(context);
        companion.getInstance(context).addSingleSynchronousSubscription(iEventSubscriberCreateBrazeUserChangeEventSubscriber, BrazeUserChangeEvent.class);
        this.brazeUserChangeEventSubscriber = iEventSubscriberCreateBrazeUserChangeEventSubscriber;
    }

    public void hideCurrentlyDisplayingInAppMessage(boolean z10) {
        setShouldNextUnregisterBeSkipped(false);
        IInAppMessageViewWrapper iInAppMessageViewWrapper = this.inAppMessageViewWrapper;
        if (iInAppMessageViewWrapper != null) {
            if (z10) {
                this.inAppMessageViewLifecycleListener.onDismissed(iInAppMessageViewWrapper.getInAppMessageView(), iInAppMessageViewWrapper.getInAppMessage());
            }
            iInAppMessageViewWrapper.close();
        }
    }

    public final boolean isCurrentlyDisplayingInAppMessage() {
        return this.displayingInAppMessage.get();
    }

    @VisibleForTesting
    public boolean isInAppMessageForTheSameUser(@Nullable IInAppMessage iInAppMessage, @NotNull String currentUserId) {
        t.i(currentUserId, "currentUserId");
        if (iInAppMessage == null) {
            return true;
        }
        InAppMessageEvent inAppMessageEvent = this.inAppMessageEventMap.get(iInAppMessage);
        String userId = inAppMessageEvent != null ? inAppMessageEvent.getUserId() : null;
        return userId == null || t.d(userId, currentUserId);
    }

    public void registerInAppMessageManager(@Nullable Activity activity) {
        try {
            if (activity == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C11661.INSTANCE, 6, (Object) null);
                return;
            }
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11672(activity), 6, (Object) null);
            this.mActivity = activity;
            if (this.mApplicationContext == null) {
                Context applicationContext = activity.getApplicationContext();
                this.mApplicationContext = applicationContext;
                if (applicationContext == null) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C11683.INSTANCE, 6, (Object) null);
                    return;
                }
            }
            if (this.configurationProvider == null) {
                Context context = this.mApplicationContext;
                this.configurationProvider = context != null ? new BrazeConfigurationProvider(context) : null;
            }
            IInAppMessage iInAppMessage = this.carryoverInAppMessage;
            if (iInAppMessage != null) {
                if (iInAppMessage != null) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeInAppMessageManager$registerInAppMessageManager$5$1.INSTANCE, 7, (Object) null);
                    iInAppMessage.setAnimateIn(false);
                    displayInAppMessage(iInAppMessage, true);
                }
                this.carryoverInAppMessage = null;
            } else {
                IInAppMessage iInAppMessage2 = this.unregisteredInAppMessage;
                if (iInAppMessage2 != null) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeInAppMessageManager$registerInAppMessageManager$6$1.INSTANCE, 7, (Object) null);
                    addInAppMessage(iInAppMessage2);
                    this.unregisteredInAppMessage = null;
                }
            }
            Context context2 = this.mApplicationContext;
            if (context2 != null) {
                ensureSubscribedToInAppMessageEvents(context2);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11698.INSTANCE, 4, (Object) null);
        }
    }

    public boolean requestDisplayInAppMessage() {
        InAppMessageOperation inAppMessageOperationBeforeInAppMessageDisplayed;
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                if (this.inAppMessageStack.empty()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11722.INSTANCE, 7, (Object) null);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C11701.INSTANCE, 6, (Object) null);
                    this.unregisteredInAppMessage = this.inAppMessageStack.pop();
                }
                return false;
            }
            if (this.displayingInAppMessage.get()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11733.INSTANCE, 7, (Object) null);
                return false;
            }
            if (this.inAppMessageStack.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11744.INSTANCE, 7, (Object) null);
                return false;
            }
            IInAppMessage inAppMessage = this.inAppMessageStack.pop();
            if (inAppMessage.isControl()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeInAppMessageManager$requestDisplayInAppMessage$inAppMessageOperation$1.INSTANCE, 7, (Object) null);
                IInAppMessageManagerListener controlInAppMessageManagerListener = getControlInAppMessageManagerListener();
                t.h(inAppMessage, "inAppMessage");
                inAppMessageOperationBeforeInAppMessageDisplayed = controlInAppMessageManagerListener.beforeInAppMessageDisplayed(inAppMessage);
            } else {
                IInAppMessageManagerListener inAppMessageManagerListener = getInAppMessageManagerListener();
                t.h(inAppMessage, "inAppMessage");
                inAppMessageOperationBeforeInAppMessageDisplayed = inAppMessageManagerListener.beforeInAppMessageDisplayed(inAppMessage);
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[inAppMessageOperationBeforeInAppMessageDisplayed.ordinal()];
            if (i10 == 1) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11755.INSTANCE, 7, (Object) null);
            } else {
                if (i10 == 2) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11766.INSTANCE, 7, (Object) null);
                    this.inAppMessageStack.push(inAppMessage);
                    return false;
                }
                if (i10 == 3) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11777.INSTANCE, 7, (Object) null);
                    return false;
                }
                if (i10 == 4) {
                    InAppMessageEvent inAppMessageEvent = this.inAppMessageEventMap.get(inAppMessage);
                    if (inAppMessageEvent != null) {
                        BrazeInternal brazeInternal = BrazeInternal.INSTANCE;
                        Context applicationContext = activity.getApplicationContext();
                        t.h(applicationContext, "activity.applicationContext");
                        brazeInternal.reenqueueInAppMessage(applicationContext, inAppMessageEvent);
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11788.INSTANCE, 7, (Object) null);
                    } else {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11799(inAppMessage), 7, (Object) null);
                    }
                    return false;
                }
            }
            BackgroundInAppMessagePreparer.prepareInAppMessageForDisplay(inAppMessage);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C117110.INSTANCE, 4, (Object) null);
            return false;
        }
    }

    public void resetAfterInAppMessageClose() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11801.INSTANCE, 6, (Object) null);
        this.inAppMessageViewWrapper = null;
        Activity activity = this.mActivity;
        Integer num = this.originalOrientation;
        this.displayingInAppMessage.set(false);
        if (activity == null || num == null) {
            return;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11812(num), 7, (Object) null);
        ViewUtils.setActivityRequestedOrientation(activity, num.intValue());
        this.originalOrientation = null;
    }

    public void unregisterInAppMessageManager(@Nullable Activity activity) {
        IInAppMessage inAppMessage;
        try {
            if (getShouldNextUnregisterBeSkipped()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11821(activity), 7, (Object) null);
                setShouldNextUnregisterBeSkipped(false);
                return;
            }
            if (activity == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C11832.INSTANCE, 6, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11843(activity), 6, (Object) null);
            }
            IInAppMessageViewWrapper iInAppMessageViewWrapper = this.inAppMessageViewWrapper;
            if (iInAppMessageViewWrapper != null) {
                View inAppMessageView = iInAppMessageViewWrapper.getInAppMessageView();
                if (inAppMessageView instanceof InAppMessageHtmlBaseView) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11854.INSTANCE, 7, (Object) null);
                    ((InAppMessageHtmlBaseView) inAppMessageView).setHtmlPageFinishedListener(null);
                }
                ViewUtils.removeViewFromParent(inAppMessageView);
                if (iInAppMessageViewWrapper.isAnimatingClose()) {
                    this.inAppMessageViewLifecycleListener.afterClosed(iInAppMessageViewWrapper.getInAppMessage());
                    inAppMessage = null;
                } else {
                    inAppMessage = iInAppMessageViewWrapper.getInAppMessage();
                }
                this.carryoverInAppMessage = inAppMessage;
                this.inAppMessageViewWrapper = null;
            } else {
                this.carryoverInAppMessage = null;
            }
            this.mActivity = null;
            this.displayingInAppMessage.set(false);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11865.INSTANCE, 4, (Object) null);
        }
    }

    @SuppressLint({"InlinedApi"})
    @VisibleForTesting
    public boolean verifyOrientationStatus(@NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        Activity activity = this.mActivity;
        Orientation orientation = inAppMessage.getOrientation();
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C11871.INSTANCE, 6, (Object) null);
        } else if (ViewUtils.isRunningOnTablet(activity)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11882.INSTANCE, 7, (Object) null);
        } else {
            if (orientation != Orientation.ANY) {
                if (!ViewUtils.isCurrentOrientationValid(activity.getResources().getConfiguration().orientation, orientation)) {
                    return false;
                }
                if (this.originalOrientation != null) {
                    return true;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11904.INSTANCE, 7, (Object) null);
                this.originalOrientation = Integer.valueOf(activity.getRequestedOrientation());
                ViewUtils.setActivityRequestedOrientation(activity, 14);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11893.INSTANCE, 7, (Object) null);
        }
        return true;
    }
}
