package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$dimen;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.utils.InAppMessageButtonViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: InAppMessageImmersiveBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageImmersiveBaseView extends InAppMessageBaseView implements IInAppMessageImmersiveView {

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView$setLargerCloseButtonClickArea$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageImmersiveBaseView.kt */
    static final class AnonymousClass1 extends v implements h9.a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot increase click area for view if view and/or parent are null.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView$setupDirectionalNavigation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageImmersiveBaseView.kt */
    static final class C12651 extends v implements h9.a<String> {
        public static final C12651 INSTANCE = new C12651();

        C12651() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "closeButtonId is null. Cannot continue setting up navigation.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView$setupDirectionalNavigation$2, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageImmersiveBaseView.kt */
    static final class AnonymousClass2 extends v implements h9.a<String> {
        final /* synthetic */ int $numButtons;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i10) {
            super(0);
            this.$numButtons = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot setup directional navigation. Got unsupported number of buttons: " + this.$numButtons;
        }
    }

    public InAppMessageImmersiveBaseView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setLargerCloseButtonClickArea$lambda$5(View view, InAppMessageImmersiveBaseView this$0, ViewParent viewParent) {
        t.i(this$0, "this$0");
        Rect rect = new Rect();
        view.getHitRect(rect);
        int dimensionPixelSize = this$0.getContext().getResources().getDimensionPixelSize(R$dimen.com_braze_inappmessage_close_button_click_area_width);
        int dimensionPixelSize2 = this$0.getContext().getResources().getDimensionPixelSize(R$dimen.com_braze_inappmessage_close_button_click_area_height);
        int iWidth = (dimensionPixelSize - rect.width()) / 2;
        int iHeight = (dimensionPixelSize2 - rect.height()) / 2;
        rect.top -= iHeight;
        rect.bottom += iHeight;
        rect.left -= iWidth;
        rect.right += iWidth;
        ((View) viewParent).setTouchDelegate(new TouchDelegate(rect, view));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        t.i(event, "event");
        if (isInTouchMode() || event.getKeyCode() != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.dispatchKeyEvent(event);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    @Nullable
    public abstract View getFrameView();

    @NotNull
    public abstract List<View> getMessageButtonViews(int i10);

    @Nullable
    public abstract /* synthetic */ View getMessageCloseButtonView();

    @Nullable
    public abstract TextView getMessageHeaderTextView();

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public abstract TextView getMessageTextView();

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @NotNull KeyEvent event) {
        t.i(event, "event");
        if (i10 != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.onKeyDown(i10, event);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    public void resetMessageMargins(boolean z10) {
        super.resetMessageMargins(z10);
        TextView messageTextView = getMessageTextView();
        if (q.z(String.valueOf(messageTextView != null ? messageTextView.getText() : null))) {
            ViewUtils.removeViewFromParent(getMessageTextView());
        }
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (q.z(String.valueOf(messageHeaderTextView != null ? messageHeaderTextView.getText() : null))) {
            ViewUtils.removeViewFromParent(getMessageHeaderTextView());
        }
        InAppMessageViewUtils.resetMessageMarginsIfNecessary(getMessageTextView(), getMessageHeaderTextView());
    }

    public void setFrameColor(int i10) {
        View frameView = getFrameView();
        if (frameView != null) {
            InAppMessageViewUtils.setFrameColor(frameView, Integer.valueOf(i10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLargerCloseButtonClickArea(@Nullable final View view) {
        if (view == null || view.getParent() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return;
        }
        final ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ((View) parent).post(new Runnable() { // from class: com.braze.ui.inappmessage.views.e
                @Override // java.lang.Runnable
                public final void run() {
                    InAppMessageImmersiveBaseView.setLargerCloseButtonClickArea$lambda$5(view, this, parent);
                }
            });
        }
    }

    public void setMessageButtons(@NotNull List<? extends MessageButton> messageButtons) {
        t.i(messageButtons, "messageButtons");
        InAppMessageButtonViewUtils.setButtons(getMessageButtonViews(messageButtons.size()), messageButtons);
    }

    public void setMessageCloseButtonColor(int i10) {
        View messageCloseButtonView = getMessageCloseButtonView();
        if (messageCloseButtonView != null) {
            InAppMessageViewUtils.setViewBackgroundColorFilter(messageCloseButtonView, i10);
        }
    }

    public void setMessageHeaderText(@NotNull String text) {
        t.i(text, "text");
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView == null) {
            return;
        }
        messageHeaderTextView.setText(text);
    }

    public void setMessageHeaderTextAlignment(@NotNull TextAlign textAlign) {
        t.i(textAlign, "textAlign");
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            InAppMessageViewUtils.setTextAlignment(messageHeaderTextView, textAlign);
        }
    }

    public void setMessageHeaderTextColor(int i10) {
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            InAppMessageViewUtils.setTextViewColor(messageHeaderTextView, i10);
        }
    }

    public void setupDirectionalNavigation(int i10) {
        List<View> messageButtonViews = getMessageButtonViews(i10);
        final View messageCloseButtonView = getMessageCloseButtonView();
        Integer numValueOf = messageCloseButtonView != null ? Integer.valueOf(messageCloseButtonView.getId()) : null;
        if (numValueOf == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) C12651.INSTANCE, 6, (Object) null);
            return;
        }
        if (i10 == 0) {
            messageCloseButtonView.setNextFocusUpId(numValueOf.intValue());
            messageCloseButtonView.setNextFocusDownId(numValueOf.intValue());
            messageCloseButtonView.setNextFocusRightId(numValueOf.intValue());
            messageCloseButtonView.setNextFocusLeftId(numValueOf.intValue());
        } else if (i10 == 1) {
            View view = messageButtonViews.get(0);
            Integer numValueOf2 = Integer.valueOf(view.getId());
            view.setNextFocusLeftId(numValueOf.intValue());
            view.setNextFocusRightId(numValueOf.intValue());
            view.setNextFocusUpId(numValueOf.intValue());
            view.setNextFocusDownId(numValueOf.intValue());
            messageCloseButtonView.setNextFocusUpId(numValueOf2.intValue());
            messageCloseButtonView.setNextFocusDownId(numValueOf2.intValue());
            messageCloseButtonView.setNextFocusRightId(numValueOf2.intValue());
            messageCloseButtonView.setNextFocusLeftId(numValueOf2.intValue());
            messageCloseButtonView = view;
            numValueOf = numValueOf2;
        } else if (i10 != 2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new AnonymousClass2(i10), 6, (Object) null);
        } else {
            View view2 = messageButtonViews.get(1);
            View view3 = messageButtonViews.get(0);
            Integer numValueOf3 = Integer.valueOf(view2.getId());
            Integer numValueOf4 = Integer.valueOf(view3.getId());
            view2.setNextFocusLeftId(numValueOf4.intValue());
            view2.setNextFocusRightId(numValueOf4.intValue());
            view2.setNextFocusUpId(numValueOf.intValue());
            view2.setNextFocusDownId(numValueOf.intValue());
            view3.setNextFocusLeftId(numValueOf3.intValue());
            view3.setNextFocusRightId(numValueOf3.intValue());
            view3.setNextFocusUpId(numValueOf.intValue());
            view3.setNextFocusDownId(numValueOf.intValue());
            messageCloseButtonView.setNextFocusUpId(numValueOf3.intValue());
            messageCloseButtonView.setNextFocusDownId(numValueOf3.intValue());
            messageCloseButtonView.setNextFocusRightId(numValueOf3.intValue());
            messageCloseButtonView.setNextFocusLeftId(numValueOf4.intValue());
            messageCloseButtonView = view2;
            numValueOf = numValueOf3;
        }
        setNextFocusUpId(numValueOf.intValue());
        setNextFocusDownId(numValueOf.intValue());
        setNextFocusRightId(numValueOf.intValue());
        setNextFocusLeftId(numValueOf.intValue());
        if (Build.VERSION.SDK_INT >= 26 && messageCloseButtonView != null) {
            messageCloseButtonView.setFocusedByDefault(true);
        }
        if (messageCloseButtonView != null) {
            messageCloseButtonView.post(new Runnable() { // from class: com.braze.ui.inappmessage.views.d
                @Override // java.lang.Runnable
                public final void run() {
                    messageCloseButtonView.requestFocus();
                }
            });
        }
    }
}
