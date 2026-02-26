package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.braze.Braze;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageSlideupView;
import com.braze.ui.support.ViewUtils;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultInAppMessageSlideupViewFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageSlideupViewFactory implements IInAppMessageViewFactory {

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.factories.DefaultInAppMessageSlideupViewFactory$createInAppMessageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageSlideupViewFactory.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The device is not currently in touch mode. This message requires user touch interaction to display properly.";
        }
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewFactory
    @Nullable
    public InAppMessageSlideupView createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage inAppMessage) {
        t.i(activity, "activity");
        t.i(inAppMessage, "inAppMessage");
        View viewInflate = activity.getLayoutInflater().inflate(R$layout.com_braze_inappmessage_slideup, (ViewGroup) null);
        t.g(viewInflate, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageSlideupView");
        InAppMessageSlideupView inAppMessageSlideupView = (InAppMessageSlideupView) viewInflate;
        if (ViewUtils.isDeviceNotInTouchMode(inAppMessageSlideupView)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return null;
        }
        InAppMessageSlideup inAppMessageSlideup = (InAppMessageSlideup) inAppMessage;
        Context applicationContext = activity.getApplicationContext();
        inAppMessageSlideupView.applyInAppMessageParameters(inAppMessage);
        String appropriateImageUrl = InAppMessageBaseView.Companion.getAppropriateImageUrl(inAppMessageSlideup);
        if (!(appropriateImageUrl == null || appropriateImageUrl.length() == 0)) {
            Braze.Companion companion = Braze.Companion;
            t.h(applicationContext, "applicationContext");
            IBrazeImageLoader imageLoader = companion.getInstance(applicationContext).getImageLoader();
            ImageView messageImageView = inAppMessageSlideupView.getMessageImageView();
            if (messageImageView != null) {
                imageLoader.renderUrlIntoInAppMessageView(applicationContext, inAppMessage, appropriateImageUrl, messageImageView, BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP);
            }
        }
        inAppMessageSlideupView.setMessageBackgroundColor(inAppMessageSlideup.getBackgroundColor());
        String message = inAppMessageSlideup.getMessage();
        if (message != null) {
            inAppMessageSlideupView.setMessage(message);
        }
        inAppMessageSlideupView.setMessageTextColor(inAppMessageSlideup.getMessageTextColor());
        inAppMessageSlideupView.setMessageTextAlign(inAppMessageSlideup.getMessageTextAlign());
        String icon = inAppMessageSlideup.getIcon();
        if (icon != null) {
            inAppMessageSlideupView.setMessageIcon(icon, inAppMessageSlideup.getIconColor(), inAppMessageSlideup.getIconBackgroundColor());
        }
        inAppMessageSlideupView.setMessageChevron(inAppMessageSlideup.getChevronColor(), inAppMessageSlideup.getClickAction());
        inAppMessageSlideupView.resetMessageMargins(inAppMessageSlideup.getImageDownloadSuccessful());
        return inAppMessageSlideupView;
    }
}
