package com.braze.ui.inappmessage.factories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.braze.Braze;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.Orientation;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.ui.R$id;
import com.braze.ui.R$layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageFullViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageFullView;
import com.braze.ui.inappmessage.views.InAppMessageImageView;
import com.braze.ui.support.ViewUtils;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultInAppMessageFullViewFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageFullViewFactory implements IInAppMessageViewFactory {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: DefaultInAppMessageFullViewFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createInAppMessageView$lambda$4(View view, InAppMessageFullView view2, InAppMessageFull inAppMessageFull, Context applicationContext, View scrollView) {
        t.i(view2, "$view");
        t.i(inAppMessageFull, "$inAppMessageFull");
        int height = view.getHeight() / 2;
        ViewGroup.LayoutParams layoutParams = view2.findViewById(R$id.com_braze_inappmessage_full_text_and_button_content_parent).getLayoutParams();
        t.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iConvertDpToPixels = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
        if (!inAppMessageFull.getMessageButtons().isEmpty()) {
            t.h(applicationContext, "applicationContext");
            iConvertDpToPixels += (int) ViewUtils.convertDpToPixels(applicationContext, 64.0d);
        }
        int iMin = Math.min(scrollView.getHeight(), height - iConvertDpToPixels);
        t.h(scrollView, "scrollView");
        ViewUtils.setHeightOnViewLayoutParams(scrollView, iMin);
        scrollView.requestLayout();
        ImageView messageImageView = view2.getMessageImageView();
        if (messageImageView != null) {
            messageImageView.requestLayout();
        }
    }

    private final boolean resetLayoutParamsIfAppropriate(Activity activity, IInAppMessage iInAppMessage, InAppMessageFullView inAppMessageFullView) {
        if (!ViewUtils.isRunningOnTablet(activity) || iInAppMessage.getOrientation() == Orientation.ANY) {
            return false;
        }
        int longEdge = inAppMessageFullView.getLongEdge();
        int shortEdge = inAppMessageFullView.getShortEdge();
        if (longEdge <= 0 || shortEdge <= 0) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = iInAppMessage.getOrientation() == Orientation.LANDSCAPE ? new RelativeLayout.LayoutParams(longEdge, shortEdge) : new RelativeLayout.LayoutParams(shortEdge, longEdge);
        layoutParams.addRule(13, -1);
        View messageBackgroundObject = inAppMessageFullView.getMessageBackgroundObject();
        if (messageBackgroundObject == null) {
            return true;
        }
        messageBackgroundObject.setLayoutParams(layoutParams);
        return true;
    }

    @SuppressLint({"InflateParams"})
    @NotNull
    public final InAppMessageFullView getAppropriateFullView(@NotNull Activity activity, boolean z10) {
        t.i(activity, "activity");
        if (z10) {
            View viewInflate = activity.getLayoutInflater().inflate(R$layout.com_braze_inappmessage_full_graphic, (ViewGroup) null);
            t.g(viewInflate, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageFullView");
            return (InAppMessageFullView) viewInflate;
        }
        View viewInflate2 = activity.getLayoutInflater().inflate(R$layout.com_braze_inappmessage_full, (ViewGroup) null);
        t.g(viewInflate2, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageFullView");
        return (InAppMessageFullView) viewInflate2;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewFactory
    @NotNull
    public InAppMessageFullView createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage inAppMessage) {
        t.i(activity, "activity");
        t.i(inAppMessage, "inAppMessage");
        final Context applicationContext = activity.getApplicationContext();
        final InAppMessageFull inAppMessageFull = (InAppMessageFull) inAppMessage;
        boolean z10 = inAppMessageFull.getImageStyle() == ImageStyle.GRAPHIC;
        final InAppMessageFullView appropriateFullView = getAppropriateFullView(activity, z10);
        appropriateFullView.createAppropriateViews(activity, inAppMessageFull, z10);
        String appropriateImageUrl = InAppMessageBaseView.Companion.getAppropriateImageUrl(inAppMessageFull);
        if (!(appropriateImageUrl == null || appropriateImageUrl.length() == 0)) {
            Braze.Companion companion = Braze.Companion;
            t.h(applicationContext, "applicationContext");
            IBrazeImageLoader imageLoader = companion.getInstance(applicationContext).getImageLoader();
            ImageView messageImageView = appropriateFullView.getMessageImageView();
            if (messageImageView != null) {
                imageLoader.renderUrlIntoInAppMessageView(applicationContext, inAppMessage, appropriateImageUrl, messageImageView, BrazeViewBounds.NO_BOUNDS);
            }
        }
        View frameView = appropriateFullView.getFrameView();
        if (frameView != null) {
            frameView.setOnClickListener(null);
        }
        appropriateFullView.setMessageBackgroundColor(inAppMessageFull.getBackgroundColor());
        Integer frameColor = inAppMessageFull.getFrameColor();
        if (frameColor != null) {
            appropriateFullView.setFrameColor(frameColor.intValue());
        }
        appropriateFullView.setMessageButtons(inAppMessageFull.getMessageButtons());
        appropriateFullView.setMessageCloseButtonColor(inAppMessageFull.getCloseButtonColor());
        if (!z10) {
            String message = inAppMessageFull.getMessage();
            if (message != null) {
                appropriateFullView.setMessage(message);
            }
            appropriateFullView.setMessageTextColor(inAppMessageFull.getMessageTextColor());
            String header = inAppMessageFull.getHeader();
            if (header != null) {
                appropriateFullView.setMessageHeaderText(header);
            }
            appropriateFullView.setMessageHeaderTextColor(inAppMessageFull.getHeaderTextColor());
            appropriateFullView.setMessageHeaderTextAlignment(inAppMessageFull.getHeaderTextAlign());
            appropriateFullView.setMessageTextAlign(inAppMessageFull.getMessageTextAlign());
            appropriateFullView.resetMessageMargins(inAppMessageFull.getImageDownloadSuccessful());
            ImageView messageImageView2 = appropriateFullView.getMessageImageView();
            t.g(messageImageView2, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageImageView");
            ((InAppMessageImageView) messageImageView2).setToHalfParentHeight(true);
        }
        appropriateFullView.setLargerCloseButtonClickArea(appropriateFullView.getMessageCloseButtonView());
        resetLayoutParamsIfAppropriate(activity, inAppMessageFull, appropriateFullView);
        appropriateFullView.setupDirectionalNavigation(inAppMessageFull.getMessageButtons().size());
        final View viewFindViewById = appropriateFullView.findViewById(R$id.com_braze_inappmessage_full_scrollview);
        if (viewFindViewById != null) {
            final View viewFindViewById2 = appropriateFullView.findViewById(R$id.com_braze_inappmessage_full_all_content_parent);
            viewFindViewById.post(new Runnable() { // from class: m0.a
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultInAppMessageFullViewFactory.createInAppMessageView$lambda$4(viewFindViewById2, appropriateFullView, inAppMessageFull, applicationContext, viewFindViewById);
                }
            });
        }
        return appropriateFullView;
    }
}
