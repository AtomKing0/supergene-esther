package com.braze.ui.inappmessage.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$id;
import com.braze.ui.inappmessage.config.BrazeInAppMessageParams;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageFullView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageFullView extends InAppMessageImmersiveBaseView {

    @Nullable
    private InAppMessageImageView inAppMessageImageView;
    private boolean isGraphic;

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageFullView$applyDisplayCutoutMarginsToCloseButton$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageFullView.kt */
    static final class AnonymousClass1 extends v implements h9.a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Close button layout params are null or not of the expected class. Not applying window insets.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageFullView$applyDisplayCutoutMarginsToContentArea$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageFullView.kt */
    static final class C12631 extends v implements h9.a<String> {
        public static final C12631 INSTANCE = new C12631();

        C12631() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Content area layout params are null or not of the expected class. Not applying window insets.";
        }
    }

    public InAppMessageFullView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final void applyDisplayCutoutMarginsToCloseButton(WindowInsetsCompat windowInsetsCompat, View view) {
        if (view.getLayoutParams() == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) AnonymousClass1.INSTANCE, 7, (Object) null);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        t.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(windowInsetsCompat) + marginLayoutParams.leftMargin, ViewUtils.getMaxSafeTopInset(windowInsetsCompat) + marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(windowInsetsCompat) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(windowInsetsCompat) + marginLayoutParams.bottomMargin);
    }

    private final void applyDisplayCutoutMarginsToContentArea(WindowInsetsCompat windowInsetsCompat, View view) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) C12631.INSTANCE, 7, (Object) null);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        t.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(windowInsetsCompat) + marginLayoutParams.leftMargin, marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(windowInsetsCompat) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(windowInsetsCompat) + marginLayoutParams.bottomMargin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetMessageMargins$lambda$2$lambda$1(InAppMessageFullView this$0, View msgClickableView, View view) {
        t.i(this$0, "this$0");
        t.i(msgClickableView, "$msgClickableView");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) InAppMessageFullView$resetMessageMargins$1$1$1.INSTANCE, 7, (Object) null);
        msgClickableView.performClick();
    }

    private final void setInAppMessageImageViewAttributes(Activity activity, IInAppMessageImmersive iInAppMessageImmersive, IInAppMessageImageView iInAppMessageImageView) {
        iInAppMessageImageView.setInAppMessageImageCropType(iInAppMessageImmersive.getCropType());
        if (!ViewUtils.isRunningOnTablet(activity)) {
            iInAppMessageImageView.setCornersRadiusPx(0.0f);
            return;
        }
        float fConvertDpToPixels = (float) ViewUtils.convertDpToPixels(activity, BrazeInAppMessageParams.getModalizedImageRadiusDp());
        if (iInAppMessageImmersive.getImageStyle() == ImageStyle.GRAPHIC) {
            iInAppMessageImageView.setCornersRadiusPx(fConvertDpToPixels);
        } else {
            iInAppMessageImageView.setCornersRadiiPx(fConvertDpToPixels, fConvertDpToPixels, 0.0f, 0.0f);
        }
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView, com.braze.ui.inappmessage.views.IInAppMessageView
    public void applyWindowInsets(@NotNull WindowInsetsCompat insets) {
        t.i(insets, "insets");
        super.applyWindowInsets(insets);
        View messageCloseButtonView = getMessageCloseButtonView();
        if (messageCloseButtonView != null) {
            applyDisplayCutoutMarginsToCloseButton(insets, messageCloseButtonView);
        }
        if (!this.isGraphic) {
            View viewFindViewById = findViewById(R$id.com_braze_inappmessage_full_text_and_button_content_parent);
            if (viewFindViewById != null) {
                applyDisplayCutoutMarginsToContentArea(insets, viewFindViewById);
                return;
            }
            return;
        }
        View singleButtonParent = findViewById(R$id.com_braze_inappmessage_full_button_layout_single);
        if (singleButtonParent != null && singleButtonParent.getVisibility() == 0) {
            t.h(singleButtonParent, "singleButtonParent");
            applyDisplayCutoutMarginsToContentArea(insets, singleButtonParent);
            return;
        }
        View dualButtonParent = findViewById(R$id.com_braze_inappmessage_full_button_layout_dual);
        if (dualButtonParent != null && dualButtonParent.getVisibility() == 0) {
            t.h(dualButtonParent, "dualButtonParent");
            applyDisplayCutoutMarginsToContentArea(insets, dualButtonParent);
        }
    }

    public void createAppropriateViews(@NotNull Activity activity, @NotNull IInAppMessageImmersive inAppMessage, boolean z10) {
        t.i(activity, "activity");
        t.i(inAppMessage, "inAppMessage");
        InAppMessageImageView inAppMessageImageView = (InAppMessageImageView) findViewById(R$id.com_braze_inappmessage_full_imageview);
        this.inAppMessageImageView = inAppMessageImageView;
        if (inAppMessageImageView != null) {
            setInAppMessageImageViewAttributes(activity, inAppMessage, inAppMessageImageView);
        }
        this.isGraphic = z10;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView
    @Nullable
    public View getFrameView() {
        return findViewById(R$id.com_braze_inappmessage_full_frame);
    }

    public int getLongEdge() {
        return findViewById(R$id.com_braze_inappmessage_full).getLayoutParams().height;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.IInAppMessageImmersiveView
    @NotNull
    public List<View> getMessageButtonViews(int i10) {
        ArrayList arrayList = new ArrayList();
        if (i10 == 1) {
            View viewFindViewById = findViewById(R$id.com_braze_inappmessage_full_button_layout_single);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            View viewFindViewById2 = findViewById(R$id.com_braze_inappmessage_full_button_single_one);
            if (viewFindViewById2 != null) {
                arrayList.add(viewFindViewById2);
            }
        } else if (i10 == 2) {
            View viewFindViewById3 = findViewById(R$id.com_braze_inappmessage_full_button_layout_dual);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(0);
            }
            View viewFindViewById4 = findViewById(R$id.com_braze_inappmessage_full_button_dual_one);
            View viewFindViewById5 = findViewById(R$id.com_braze_inappmessage_full_button_dual_two);
            if (viewFindViewById4 != null) {
                arrayList.add(viewFindViewById4);
            }
            if (viewFindViewById5 != null) {
                arrayList.add(viewFindViewById5);
            }
        }
        return arrayList;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView, com.braze.ui.inappmessage.views.IInAppMessageView
    @Nullable
    public View getMessageClickableView() {
        return findViewById(R$id.com_braze_inappmessage_full);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.IInAppMessageImmersiveView
    @Nullable
    public View getMessageCloseButtonView() {
        return findViewById(R$id.com_braze_inappmessage_full_close_button);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView
    @Nullable
    public TextView getMessageHeaderTextView() {
        return (TextView) findViewById(R$id.com_braze_inappmessage_full_header_text);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public TextView getMessageIconView() {
        return null;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public ImageView getMessageImageView() {
        return this.inAppMessageImageView;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public TextView getMessageTextView() {
        return (TextView) findViewById(R$id.com_braze_inappmessage_full_message);
    }

    public int getShortEdge() {
        return findViewById(R$id.com_braze_inappmessage_full).getLayoutParams().width;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.InAppMessageBaseView
    public void resetMessageMargins(boolean z10) {
        super.resetMessageMargins(z10);
        final View messageClickableView = getMessageClickableView();
        if (messageClickableView != null) {
            findViewById(R$id.com_braze_inappmessage_full_text_layout).setOnClickListener(new View.OnClickListener() { // from class: com.braze.ui.inappmessage.views.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InAppMessageFullView.resetMessageMargins$lambda$2$lambda$1(this.f8132a, messageClickableView, view);
                }
            });
        }
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    public void setMessageBackgroundColor(int i10) {
        View messageBackgroundObject = getMessageBackgroundObject();
        if ((messageBackgroundObject != null ? messageBackgroundObject.getBackground() : null) instanceof GradientDrawable) {
            InAppMessageViewUtils.setViewBackgroundColorFilter(messageBackgroundObject, i10);
            return;
        }
        if (this.isGraphic) {
            super.setMessageBackgroundColor(i10);
            return;
        }
        View viewFindViewById = findViewById(R$id.com_braze_inappmessage_full_all_content_parent);
        t.h(viewFindViewById, "findViewById(R.id.com_br…_full_all_content_parent)");
        InAppMessageViewUtils.setViewBackgroundColor(viewFindViewById, i10);
        View viewFindViewById2 = findViewById(R$id.com_braze_inappmessage_full_text_and_button_content_parent);
        t.h(viewFindViewById2, "findViewById(R.id.com_br…nd_button_content_parent)");
        InAppMessageViewUtils.setViewBackgroundColor(viewFindViewById2, i10);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public View getMessageBackgroundObject() {
        return findViewById(R$id.com_braze_inappmessage_full);
    }
}
