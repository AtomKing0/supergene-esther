package com.braze.ui.inappmessage;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.window.OnBackInvokedCallback;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.PlaybackException;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;
import com.braze.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.inappmessage.views.IInAppMessageImmersiveView;
import com.braze.ui.inappmessage.views.IInAppMessageView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.support.ViewUtils;
import h9.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageViewWrapper implements IInAppMessageViewWrapper {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private List<? extends View> buttonViews;

    @Nullable
    private View clickableInAppMessageView;

    @Nullable
    private View closeButton;

    @Nullable
    private final Animation closingAnimation;

    @NotNull
    private final BrazeConfigurationProvider configurationProvider;

    @Nullable
    private ViewGroup contentViewGroupParentLayout;

    @Nullable
    private Runnable dismissRunnable;

    @NotNull
    private final IInAppMessage inAppMessage;

    @NotNull
    private final InAppMessageCloser inAppMessageCloser;

    @NotNull
    private final View inAppMessageView;

    @NotNull
    private final IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener;
    private boolean isAnimatingClose;

    @Nullable
    private final Animation openingAnimation;

    @Nullable
    private View previouslyFocusedView;

    @NotNull
    private HashMap<Integer, Integer> viewAccessibilityFlagMap;

    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final void resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto(@Nullable ViewGroup viewGroup, @NotNull Map<Integer, Integer> viewAccessibilityFlagMap) {
            t.i(viewAccessibilityFlagMap, "viewAccessibilityFlagMap");
            if (viewGroup == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) DefaultInAppMessageViewWrapper$Companion$resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto$1.INSTANCE, 6, (Object) null);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    int id = childAt.getId();
                    if (viewAccessibilityFlagMap.containsKey(Integer.valueOf(id))) {
                        Integer num = viewAccessibilityFlagMap.get(Integer.valueOf(id));
                        if (num != null) {
                            ViewCompat.setImportantForAccessibility(childAt, num.intValue());
                        }
                    } else {
                        ViewCompat.setImportantForAccessibility(childAt, 0);
                    }
                }
            }
        }

        public final void setAllViewGroupChildrenAsNonAccessibilityImportant(@Nullable ViewGroup viewGroup, @NotNull Map<Integer, Integer> viewAccessibilityFlagMap) {
            t.i(viewAccessibilityFlagMap, "viewAccessibilityFlagMap");
            if (viewGroup == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) DefaultInAppMessageViewWrapper$Companion$setAllViewGroupChildrenAsNonAccessibilityImportant$1.INSTANCE, 6, (Object) null);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    viewAccessibilityFlagMap.put(Integer.valueOf(childAt.getId()), Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                }
            }
        }
    }

    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageType.values().length];
            try {
                iArr[MessageType.MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageType.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageType.HTML_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageType.HTML.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Adding In-app message view to parent view group.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$3, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message view will animate into the visible area.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$4, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message view will be placed instantly into the visible area.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$closeInAppMessageView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class C11911 extends v implements a<String> {
        public static final C11911 INSTANCE = new C11911();

        C11911() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Closing in-app message view";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$closeInAppMessageView$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Returning focus to view after closing message. View: " + DefaultInAppMessageViewWrapper.this.getPreviouslyFocusedView();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$closeInAppMessageView$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class C11923 extends v implements a<String> {
        public static final C11923 INSTANCE = new C11923();

        C11923() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to request focus on previous view";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$open$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class C11971 extends v implements a<String> {
        public static final C11971 INSTANCE = new C11971();

        C11971() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Opening in-app message view wrapper";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$open$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    public static final class ViewOnLayoutChangeListenerC11982 implements View.OnLayoutChangeListener {
        final /* synthetic */ ViewGroup $parentViewGroup;
        final /* synthetic */ DefaultInAppMessageViewWrapper this$0;

        ViewOnLayoutChangeListenerC11982(ViewGroup viewGroup, DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
            this.$parentViewGroup = viewGroup;
            this.this$0 = defaultInAppMessageViewWrapper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onLayoutChange$lambda$0(DefaultInAppMessageViewWrapper this$0, ViewGroup parentViewGroup) {
            t.i(this$0, "this$0");
            t.i(parentViewGroup, "$parentViewGroup");
            this$0.addInAppMessageViewToViewGroup(parentViewGroup, this$0.getInAppMessage(), this$0.getInAppMessageView(), this$0.getInAppMessageViewLifecycleListener());
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            t.i(view, "view");
            this.$parentViewGroup.removeOnLayoutChangeListener(this);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new DefaultInAppMessageViewWrapper$open$2$onLayoutChange$1(i13, i11), 7, (Object) null);
            this.$parentViewGroup.removeView(this.this$0.getInAppMessageView());
            final ViewGroup viewGroup = this.$parentViewGroup;
            final DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper = this.this$0;
            viewGroup.post(new Runnable() { // from class: l0.j
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultInAppMessageViewWrapper.ViewOnLayoutChangeListenerC11982.onLayoutChange$lambda$0(defaultInAppMessageViewWrapper, viewGroup);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$open$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewWrapper.kt */
    static final class C11993 extends v implements a<String> {
        final /* synthetic */ int $parentViewGroupHeight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11993(int i10) {
            super(0);
            this.$parentViewGroupHeight = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Detected root view height of " + this.$parentViewGroupHeight;
        }
    }

    public DefaultInAppMessageViewWrapper(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage, @NotNull IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider configurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view, @Nullable List<? extends View> list, @Nullable View view2) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        t.i(inAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        t.i(configurationProvider, "configurationProvider");
        this.inAppMessageView = inAppMessageView;
        this.inAppMessage = inAppMessage;
        this.inAppMessageViewLifecycleListener = inAppMessageViewLifecycleListener;
        this.configurationProvider = configurationProvider;
        this.openingAnimation = animation;
        this.closingAnimation = animation2;
        this.clickableInAppMessageView = view;
        this.buttonViews = list;
        this.closeButton = view2;
        this.viewAccessibilityFlagMap = new HashMap<>();
        View clickableInAppMessageView = getClickableInAppMessageView();
        setClickableInAppMessageView(clickableInAppMessageView == null ? getInAppMessageView() : clickableInAppMessageView);
        if (getInAppMessage() instanceof InAppMessageSlideup) {
            TouchAwareSwipeDismissTouchListener touchAwareSwipeDismissTouchListener = new TouchAwareSwipeDismissTouchListener(getInAppMessageView(), createDismissCallbacks());
            touchAwareSwipeDismissTouchListener.setTouchListener(createTouchAwareListener());
            View clickableInAppMessageView2 = getClickableInAppMessageView();
            if (clickableInAppMessageView2 != null) {
                clickableInAppMessageView2.setOnTouchListener(touchAwareSwipeDismissTouchListener);
            }
        }
        View clickableInAppMessageView3 = getClickableInAppMessageView();
        if (clickableInAppMessageView3 != null) {
            clickableInAppMessageView3.setOnClickListener(createClickListener());
        }
        this.inAppMessageCloser = new InAppMessageCloser(this);
        View closeButton = getCloseButton();
        if (closeButton != null) {
            closeButton.setOnClickListener(createCloseInAppMessageClickListener());
        }
        createButtonClickListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addDismissRunnable$lambda$8() {
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final WindowInsetsCompat addInAppMessageViewToViewGroup$lambda$1(View inAppMessageView, DefaultInAppMessageViewWrapper this$0, View view, WindowInsetsCompat windowInsetsCompat) {
        t.i(inAppMessageView, "$inAppMessageView");
        t.i(this$0, "this$0");
        if (windowInsetsCompat == null) {
            return new WindowInsetsCompat(windowInsetsCompat);
        }
        IInAppMessageView iInAppMessageView = (IInAppMessageView) inAppMessageView;
        if (iInAppMessageView.getHasAppliedWindowInsets()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (a) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$2$2.INSTANCE, 7, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.V, (Throwable) null, false, (a) DefaultInAppMessageViewWrapper$addInAppMessageViewToViewGroup$2$1.INSTANCE, 6, (Object) null);
            iInAppMessageView.applyWindowInsets(windowInsetsCompat);
        }
        return windowInsetsCompat;
    }

    public static /* synthetic */ void announceForAccessibilityIfNecessary$default(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: announceForAccessibilityIfNecessary");
        }
        if ((i10 & 1) != 0) {
            str = "In app message displayed.";
        }
        defaultInAppMessageViewWrapper.announceForAccessibilityIfNecessary(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createButtonClickListeners$lambda$6$lambda$5$lambda$4$lambda$3(DefaultInAppMessageViewWrapper this$0, MessageButton button, IInAppMessageImmersive immersiveMessage, View view) {
        t.i(this$0, "this$0");
        t.i(button, "$button");
        t.i(immersiveMessage, "$immersiveMessage");
        this$0.getInAppMessageViewLifecycleListener().onButtonClicked(this$0.getInAppMessageCloser(), button, immersiveMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createClickListener$lambda$2(DefaultInAppMessageViewWrapper this$0, View view) {
        List<MessageButton> messageButtons;
        t.i(this$0, "this$0");
        IInAppMessage inAppMessage = this$0.getInAppMessage();
        IInAppMessageImmersive iInAppMessageImmersive = inAppMessage instanceof IInAppMessageImmersive ? (IInAppMessageImmersive) inAppMessage : null;
        boolean z10 = false;
        if (iInAppMessageImmersive != null && (messageButtons = iInAppMessageImmersive.getMessageButtons()) != null && messageButtons.isEmpty()) {
            z10 = true;
        }
        if (z10 || !(this$0.getInAppMessage() instanceof IInAppMessageImmersive)) {
            this$0.getInAppMessageViewLifecycleListener().onClicked(this$0.getInAppMessageCloser(), this$0.getInAppMessageView(), this$0.getInAppMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCloseInAppMessageClickListener$lambda$7(View view) {
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    public void addDismissRunnable() {
        if (getDismissRunnable() == null) {
            setDismissRunnable(new Runnable() { // from class: l0.g
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultInAppMessageViewWrapper.addDismissRunnable$lambda$8();
                }
            });
            getInAppMessageView().postDelayed(getDismissRunnable(), getInAppMessage().getDurationInMilliseconds());
        }
    }

    public void addInAppMessageViewToViewGroup(@NotNull ViewGroup parentViewGroup, @NotNull IInAppMessage inAppMessage, @NotNull final View inAppMessageView, @NotNull IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener) {
        t.i(parentViewGroup, "parentViewGroup");
        t.i(inAppMessage, "inAppMessage");
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        inAppMessageViewLifecycleListener.beforeOpened(inAppMessageView, inAppMessage);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
        parentViewGroup.addView(inAppMessageView, getLayoutParams(inAppMessage));
        if (inAppMessageView instanceof IInAppMessageView) {
            ViewCompat.requestApplyInsets(parentViewGroup);
            ViewCompat.setOnApplyWindowInsetsListener(parentViewGroup, new OnApplyWindowInsetsListener() { // from class: l0.e
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return DefaultInAppMessageViewWrapper.addInAppMessageViewToViewGroup$lambda$1(inAppMessageView, this, view, windowInsetsCompat);
                }
            });
        }
        if (inAppMessage.getAnimateIn()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass3.INSTANCE, 7, (Object) null);
            setAndStartAnimation(true);
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass4.INSTANCE, 7, (Object) null);
            if (inAppMessage.getDismissType() == DismissType.AUTO_DISMISS) {
                addDismissRunnable();
            }
            finalizeViewBeforeDisplay(inAppMessage, inAppMessageView, inAppMessageViewLifecycleListener);
        }
    }

    public void announceForAccessibilityIfNecessary(@Nullable String str) {
        if (!(getInAppMessageView() instanceof IInAppMessageImmersiveView)) {
            if (getInAppMessageView() instanceof InAppMessageHtmlBaseView) {
                getInAppMessageView().announceForAccessibility(str);
                return;
            }
            return;
        }
        String message = getInAppMessage().getMessage();
        if (!(getInAppMessage() instanceof IInAppMessageImmersive)) {
            getInAppMessageView().announceForAccessibility(message);
            return;
        }
        IInAppMessage inAppMessage = getInAppMessage();
        t.g(inAppMessage, "null cannot be cast to non-null type com.braze.models.inappmessage.IInAppMessageImmersive");
        String header = ((IInAppMessageImmersive) inAppMessage).getHeader();
        getInAppMessageView().announceForAccessibility(header + " . " + message);
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapper
    public void close() {
        if (getConfigurationProvider().isInAppMessageAccessibilityExclusiveModeEnabled()) {
            Companion.resetAllViewGroupChildrenToPreviousAccessibilityFlagOrAuto(getContentViewGroupParentLayout(), getViewAccessibilityFlagMap());
        }
        getInAppMessageView().removeCallbacks(getDismissRunnable());
        getInAppMessageViewLifecycleListener().beforeClosed(getInAppMessageView(), getInAppMessage());
        if (!getInAppMessage().getAnimateOut()) {
            closeInAppMessageView();
        } else {
            setAnimatingClose(true);
            setAndStartAnimation(false);
        }
    }

    public void closeInAppMessageView() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11911.INSTANCE, 7, (Object) null);
        ViewUtils.removeViewFromParent(getInAppMessageView());
        View inAppMessageView = getInAppMessageView();
        InAppMessageHtmlBaseView inAppMessageHtmlBaseView = inAppMessageView instanceof InAppMessageHtmlBaseView ? (InAppMessageHtmlBaseView) inAppMessageView : null;
        if (inAppMessageHtmlBaseView != null) {
            inAppMessageHtmlBaseView.finishWebViewDisplay();
        }
        if (getPreviouslyFocusedView() != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass2(), 7, (Object) null);
            try {
                View previouslyFocusedView = getPreviouslyFocusedView();
                if (previouslyFocusedView != null) {
                    previouslyFocusedView.requestFocus();
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11923.INSTANCE, 4, (Object) null);
            }
        }
        getInAppMessageViewLifecycleListener().afterClosed(getInAppMessage());
    }

    @NotNull
    public Animation.AnimationListener createAnimationListener(boolean z10) {
        return z10 ? new Animation.AnimationListener() { // from class: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.createAnimationListener.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@Nullable Animation animation) {
                if (DefaultInAppMessageViewWrapper.this.getInAppMessage().getDismissType() == DismissType.AUTO_DISMISS) {
                    DefaultInAppMessageViewWrapper.this.addDismissRunnable();
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) DefaultInAppMessageViewWrapper$createAnimationListener$1$onAnimationEnd$1.INSTANCE, 7, (Object) null);
                DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper = DefaultInAppMessageViewWrapper.this;
                defaultInAppMessageViewWrapper.finalizeViewBeforeDisplay(defaultInAppMessageViewWrapper.getInAppMessage(), DefaultInAppMessageViewWrapper.this.getInAppMessageView(), DefaultInAppMessageViewWrapper.this.getInAppMessageViewLifecycleListener());
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@Nullable Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@Nullable Animation animation) {
            }
        } : new Animation.AnimationListener() { // from class: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.createAnimationListener.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@Nullable Animation animation) {
                DefaultInAppMessageViewWrapper.this.getInAppMessageView().clearAnimation();
                DefaultInAppMessageViewWrapper.this.getInAppMessageView().setVisibility(8);
                DefaultInAppMessageViewWrapper.this.closeInAppMessageView();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@Nullable Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@Nullable Animation animation) {
            }
        };
    }

    public void createButtonClickListeners() {
        IInAppMessage inAppMessage = getInAppMessage();
        final IInAppMessageImmersive iInAppMessageImmersive = inAppMessage instanceof IInAppMessageImmersive ? (IInAppMessageImmersive) inAppMessage : null;
        if (iInAppMessageImmersive != null) {
            if (iInAppMessageImmersive.getMessageButtons().isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) DefaultInAppMessageViewWrapper$createButtonClickListeners$1$1.INSTANCE, 7, (Object) null);
                return;
            }
            List<View> buttonViews = getButtonViews();
            if (buttonViews != null) {
                int i10 = 0;
                for (Object obj : buttonViews) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        kotlin.collections.v.u();
                    }
                    View view = (View) obj;
                    final MessageButton messageButton = (MessageButton) d0.l0(iInAppMessageImmersive.getMessageButtons(), i10);
                    if (messageButton != null) {
                        view.setOnClickListener(new View.OnClickListener() { // from class: l0.h
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                DefaultInAppMessageViewWrapper.createButtonClickListeners$lambda$6$lambda$5$lambda$4$lambda$3(this.f30208a, messageButton, iInAppMessageImmersive, view2);
                            }
                        });
                    }
                    i10 = i11;
                }
            }
        }
    }

    @NotNull
    public View.OnClickListener createClickListener() {
        return new View.OnClickListener() { // from class: l0.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultInAppMessageViewWrapper.createClickListener$lambda$2(this.f30211a, view);
            }
        };
    }

    @NotNull
    public View.OnClickListener createCloseInAppMessageClickListener() {
        return new View.OnClickListener() { // from class: l0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultInAppMessageViewWrapper.createCloseInAppMessageClickListener$lambda$7(view);
            }
        };
    }

    @NotNull
    public SwipeDismissTouchListener.DismissCallbacks createDismissCallbacks() {
        return new SwipeDismissTouchListener.DismissCallbacks() { // from class: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.createDismissCallbacks.1
            @Override // com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener.DismissCallbacks
            public boolean canDismiss(@Nullable Object obj) {
                return true;
            }

            @Override // com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener.DismissCallbacks
            public void onDismiss(@NotNull View view, @Nullable Object obj) {
                t.i(view, "view");
                DefaultInAppMessageViewWrapper.this.getInAppMessage().setAnimateOut(false);
                BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
            }
        };
    }

    @NotNull
    public TouchAwareSwipeDismissTouchListener.ITouchListener createTouchAwareListener() {
        return new TouchAwareSwipeDismissTouchListener.ITouchListener() { // from class: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper.createTouchAwareListener.1
            @Override // com.braze.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener.ITouchListener
            public void onTouchEnded() {
            }

            @Override // com.braze.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener.ITouchListener
            public void onTouchStartedOrContinued() {
            }
        };
    }

    public void finalizeViewBeforeDisplay(@NotNull IInAppMessage inAppMessage, @NotNull View inAppMessageView, @NotNull IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener) {
        t.i(inAppMessage, "inAppMessage");
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        if (ViewUtils.isDeviceNotInTouchMode(inAppMessageView)) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[inAppMessage.getMessageType().ordinal()];
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
                ViewUtils.setFocusableInTouchModeAndRequestFocus(inAppMessageView);
            }
        } else {
            ViewUtils.setFocusableInTouchModeAndRequestFocus(inAppMessageView);
        }
        announceForAccessibilityIfNecessary$default(this, null, 1, null);
        inAppMessageViewLifecycleListener.afterOpened(inAppMessageView, inAppMessage);
    }

    @Nullable
    public List<View> getButtonViews() {
        return this.buttonViews;
    }

    @Nullable
    public View getClickableInAppMessageView() {
        return this.clickableInAppMessageView;
    }

    @Nullable
    public View getCloseButton() {
        return this.closeButton;
    }

    @Nullable
    public Animation getClosingAnimation() {
        return this.closingAnimation;
    }

    @NotNull
    public BrazeConfigurationProvider getConfigurationProvider() {
        return this.configurationProvider;
    }

    @Nullable
    public ViewGroup getContentViewGroupParentLayout() {
        return this.contentViewGroupParentLayout;
    }

    @Nullable
    public Runnable getDismissRunnable() {
        return this.dismissRunnable;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapper
    @NotNull
    public IInAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    @NotNull
    public InAppMessageCloser getInAppMessageCloser() {
        return this.inAppMessageCloser;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapper
    @NotNull
    public View getInAppMessageView() {
        return this.inAppMessageView;
    }

    @NotNull
    public IInAppMessageViewLifecycleListener getInAppMessageViewLifecycleListener() {
        return this.inAppMessageViewLifecycleListener;
    }

    @NotNull
    public ViewGroup.LayoutParams getLayoutParams(@Nullable IInAppMessage iInAppMessage) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (iInAppMessage instanceof InAppMessageSlideup) {
            layoutParams.gravity = ((InAppMessageSlideup) iInAppMessage).getSlideFrom() == SlideFrom.TOP ? 48 : 80;
        }
        return layoutParams;
    }

    @Nullable
    public Animation getOpeningAnimation() {
        return this.openingAnimation;
    }

    @NotNull
    public ViewGroup getParentViewGroup(@NotNull Activity activity) {
        t.i(activity, "activity");
        View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        t.h(viewFindViewById, "activity.window.decorVie…yId(android.R.id.content)");
        return (ViewGroup) viewFindViewById;
    }

    @Nullable
    public View getPreviouslyFocusedView() {
        return this.previouslyFocusedView;
    }

    @NotNull
    public HashMap<Integer, Integer> getViewAccessibilityFlagMap() {
        return this.viewAccessibilityFlagMap;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapper
    public boolean isAnimatingClose() {
        return this.isAnimatingClose;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewWrapper
    public void open(@NotNull final Activity activity) {
        t.i(activity, "activity");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11971.INSTANCE, 6, (Object) null);
        ViewGroup parentViewGroup = getParentViewGroup(activity);
        int height = parentViewGroup.getHeight();
        if (getConfigurationProvider().isInAppMessageAccessibilityExclusiveModeEnabled()) {
            setContentViewGroupParentLayout(parentViewGroup);
            getViewAccessibilityFlagMap().clear();
            Companion.setAllViewGroupChildrenAsNonAccessibilityImportant(getContentViewGroupParentLayout(), getViewAccessibilityFlagMap());
        }
        setPreviouslyFocusedView(activity.getCurrentFocus());
        if (height == 0) {
            parentViewGroup.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC11982(parentViewGroup, this));
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11993(height), 7, (Object) null);
            addInAppMessageViewToViewGroup(parentViewGroup, getInAppMessage(), getInAppMessageView(), getInAppMessageViewLifecycleListener());
        }
        if (!BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView() || Build.VERSION.SDK_INT < 33) {
            return;
        }
        activity.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(PlaybackException.CUSTOM_ERROR_CODE_BASE, new OnBackInvokedCallback() { // from class: com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$open$4$dismissInAppMessageCallback$1
            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
                activity.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this);
            }
        });
    }

    public void setAndStartAnimation(boolean z10) {
        Animation openingAnimation = z10 ? getOpeningAnimation() : getClosingAnimation();
        if (openingAnimation != null) {
            openingAnimation.setAnimationListener(createAnimationListener(z10));
        }
        getInAppMessageView().clearAnimation();
        getInAppMessageView().setAnimation(openingAnimation);
        if (openingAnimation != null) {
            openingAnimation.startNow();
        }
        getInAppMessageView().invalidate();
    }

    public void setAnimatingClose(boolean z10) {
        this.isAnimatingClose = z10;
    }

    public void setClickableInAppMessageView(@Nullable View view) {
        this.clickableInAppMessageView = view;
    }

    public void setContentViewGroupParentLayout(@Nullable ViewGroup viewGroup) {
        this.contentViewGroupParentLayout = viewGroup;
    }

    public void setDismissRunnable(@Nullable Runnable runnable) {
        this.dismissRunnable = runnable;
    }

    public void setPreviouslyFocusedView(@Nullable View view) {
        this.previouslyFocusedView = view;
    }

    public /* synthetic */ DefaultInAppMessageViewWrapper(View view, IInAppMessage iInAppMessage, IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, BrazeConfigurationProvider brazeConfigurationProvider, Animation animation, Animation animation2, View view2, List list, View view3, int i10, k kVar) {
        this(view, iInAppMessage, iInAppMessageViewLifecycleListener, brazeConfigurationProvider, animation, animation2, view2, (i10 & 128) != 0 ? null : list, (i10 & 256) != 0 ? null : view3);
    }
}
