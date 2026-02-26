package com.braze.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageAnimationFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageFullViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlFullViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageModalViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageSlideupViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageViewWrapperFactory;
import com.braze.ui.inappmessage.listeners.DefaultHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageManagerBase.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageManagerBase {

    @Nullable
    private IInAppMessageManagerListener customControlInAppMessageManagerListener;

    @Nullable
    private IHtmlInAppMessageActionListener customHtmlInAppMessageActionListener;

    @Nullable
    private IInAppMessageAnimationFactory customInAppMessageAnimationFactory;

    @Nullable
    private IInAppMessageManagerListener customInAppMessageManagerListener;

    @Nullable
    private IInAppMessageViewFactory customInAppMessageViewFactory;

    @Nullable
    private IInAppMessageViewWrapperFactory customInAppMessageViewWrapperFactory;

    @NotNull
    private final IHtmlInAppMessageActionListener defaultHtmlInAppMessageActionListener;

    @NotNull
    private final IInAppMessageManagerListener defaultInAppMessageManagerListener;

    @NotNull
    private final IInAppMessageViewWrapperFactory defaultInAppMessageViewWrapperFactory;
    private boolean doesBackButtonDismissInAppMessageViewField = true;
    private boolean doesClickOutsideModalViewDismissInAppMessageViewField;

    @NotNull
    private final IInAppMessageAnimationFactory inAppMessageAnimationFactoryField;

    @NotNull
    private final IInAppMessageViewFactory inAppMessageFullViewFactory;

    @NotNull
    private final IInAppMessageViewFactory inAppMessageHtmlFullViewFactory;

    @NotNull
    private final IInAppMessageViewFactory inAppMessageHtmlViewFactory;

    @NotNull
    private final IInAppMessageViewFactory inAppMessageModalViewFactory;

    @NotNull
    private final IInAppMessageViewFactory inAppMessageSlideupViewFactory;

    @NotNull
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;

    @Nullable
    protected Activity mActivity;

    @Nullable
    protected Context mApplicationContext;
    private boolean shouldNextUnregisterBeSkipped;

    /* JADX INFO: compiled from: InAppMessageManagerBase.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageType.values().length];
            try {
                iArr[MessageType.SLIDEUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageType.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageType.HTML_FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageType.HTML.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.InAppMessageManagerBase$getDefaultInAppMessageViewFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageManagerBase.kt */
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
            return "Failed to find view factory for in-app message with type: " + this.$inAppMessage.getMessageType();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.InAppMessageManagerBase$setCustomHtmlInAppMessageActionListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageManagerBase.kt */
    static final class C12001 extends v implements a<String> {
        public static final C12001 INSTANCE = new C12001();

        C12001() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Custom htmlInAppMessageActionListener set";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.InAppMessageManagerBase$setCustomInAppMessageManagerListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageManagerBase.kt */
    static final class C12011 extends v implements a<String> {
        public static final C12011 INSTANCE = new C12011();

        C12011() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Custom InAppMessageManagerListener set";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.InAppMessageManagerBase$setCustomInAppMessageViewFactory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageManagerBase.kt */
    static final class C12021 extends v implements a<String> {
        public static final C12021 INSTANCE = new C12021();

        C12021() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Custom InAppMessageViewFactory set";
        }
    }

    public InAppMessageManagerBase() {
        DefaultInAppMessageWebViewClientListener defaultInAppMessageWebViewClientListener = new DefaultInAppMessageWebViewClientListener();
        this.inAppMessageWebViewClientListener = defaultInAppMessageWebViewClientListener;
        this.defaultHtmlInAppMessageActionListener = new DefaultHtmlInAppMessageActionListener();
        this.inAppMessageSlideupViewFactory = new DefaultInAppMessageSlideupViewFactory();
        this.inAppMessageModalViewFactory = new DefaultInAppMessageModalViewFactory();
        this.inAppMessageFullViewFactory = new DefaultInAppMessageFullViewFactory();
        this.inAppMessageHtmlFullViewFactory = new DefaultInAppMessageHtmlFullViewFactory(defaultInAppMessageWebViewClientListener);
        this.inAppMessageHtmlViewFactory = new DefaultInAppMessageHtmlViewFactory(defaultInAppMessageWebViewClientListener);
        this.inAppMessageAnimationFactoryField = new DefaultInAppMessageAnimationFactory();
        this.defaultInAppMessageManagerListener = new DefaultInAppMessageManagerListener();
        this.defaultInAppMessageViewWrapperFactory = new DefaultInAppMessageViewWrapperFactory();
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    @NotNull
    public IInAppMessageManagerListener getControlInAppMessageManagerListener() {
        IInAppMessageManagerListener iInAppMessageManagerListener = this.customControlInAppMessageManagerListener;
        return iInAppMessageManagerListener == null ? this.defaultInAppMessageManagerListener : iInAppMessageManagerListener;
    }

    @Nullable
    public IInAppMessageViewFactory getDefaultInAppMessageViewFactory(@NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        int i10 = WhenMappings.$EnumSwitchMapping$0[inAppMessage.getMessageType().ordinal()];
        if (i10 == 1) {
            return this.inAppMessageSlideupViewFactory;
        }
        if (i10 == 2) {
            return this.inAppMessageModalViewFactory;
        }
        if (i10 == 3) {
            return this.inAppMessageFullViewFactory;
        }
        if (i10 == 4) {
            return this.inAppMessageHtmlFullViewFactory;
        }
        if (i10 == 5) {
            return this.inAppMessageHtmlViewFactory;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new AnonymousClass1(inAppMessage), 6, (Object) null);
        return null;
    }

    public boolean getDoesBackButtonDismissInAppMessageView() {
        return this.doesBackButtonDismissInAppMessageViewField;
    }

    public boolean getDoesClickOutsideModalViewDismissInAppMessageView() {
        return this.doesClickOutsideModalViewDismissInAppMessageViewField;
    }

    @NotNull
    public IHtmlInAppMessageActionListener getHtmlInAppMessageActionListener() {
        IHtmlInAppMessageActionListener iHtmlInAppMessageActionListener = this.customHtmlInAppMessageActionListener;
        return iHtmlInAppMessageActionListener == null ? this.defaultHtmlInAppMessageActionListener : iHtmlInAppMessageActionListener;
    }

    @NotNull
    public IInAppMessageAnimationFactory getInAppMessageAnimationFactory() {
        IInAppMessageAnimationFactory iInAppMessageAnimationFactory = this.customInAppMessageAnimationFactory;
        return iInAppMessageAnimationFactory == null ? this.inAppMessageAnimationFactoryField : iInAppMessageAnimationFactory;
    }

    @NotNull
    public IInAppMessageManagerListener getInAppMessageManagerListener() {
        IInAppMessageManagerListener iInAppMessageManagerListener = this.customInAppMessageManagerListener;
        return iInAppMessageManagerListener == null ? this.defaultInAppMessageManagerListener : iInAppMessageManagerListener;
    }

    @Nullable
    public IInAppMessageViewFactory getInAppMessageViewFactory(@NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        IInAppMessageViewFactory iInAppMessageViewFactory = this.customInAppMessageViewFactory;
        return iInAppMessageViewFactory == null ? getDefaultInAppMessageViewFactory(inAppMessage) : iInAppMessageViewFactory;
    }

    @NotNull
    public IInAppMessageViewWrapperFactory getInAppMessageViewWrapperFactory() {
        IInAppMessageViewWrapperFactory iInAppMessageViewWrapperFactory = this.customInAppMessageViewWrapperFactory;
        return iInAppMessageViewWrapperFactory == null ? this.defaultInAppMessageViewWrapperFactory : iInAppMessageViewWrapperFactory;
    }

    public boolean getShouldNextUnregisterBeSkipped() {
        return this.shouldNextUnregisterBeSkipped;
    }

    public void setCustomHtmlInAppMessageActionListener(@Nullable IHtmlInAppMessageActionListener iHtmlInAppMessageActionListener) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12001.INSTANCE, 7, (Object) null);
        this.customHtmlInAppMessageActionListener = iHtmlInAppMessageActionListener;
    }

    public void setCustomInAppMessageManagerListener(@Nullable IInAppMessageManagerListener iInAppMessageManagerListener) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12011.INSTANCE, 7, (Object) null);
        this.customInAppMessageManagerListener = iInAppMessageManagerListener;
    }

    public void setCustomInAppMessageViewFactory(@Nullable IInAppMessageViewFactory iInAppMessageViewFactory) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12021.INSTANCE, 7, (Object) null);
        this.customInAppMessageViewFactory = iInAppMessageViewFactory;
    }

    public void setShouldNextUnregisterBeSkipped(boolean z10) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new InAppMessageManagerBase$shouldNextUnregisterBeSkipped$1(z10), 7, (Object) null);
        this.shouldNextUnregisterBeSkipped = z10;
    }
}
