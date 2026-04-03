package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: InAppMessageBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageBaseView extends RelativeLayout implements IInAppMessageView {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean hasAppliedWindowInsets;

    /* JADX INFO: compiled from: InAppMessageBaseView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @Nullable
        public final String getAppropriateImageUrl(@NotNull IInAppMessageWithImage inAppMessage) {
            t.i(inAppMessage, "inAppMessage");
            String localImageUrl = inAppMessage.getLocalImageUrl();
            if (!(localImageUrl == null || q.z(localImageUrl))) {
                if (new File(localImageUrl).exists()) {
                    return localImageUrl;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (h9.a) new InAppMessageBaseView$Companion$getAppropriateImageUrl$1(localImageUrl), 6, (Object) null);
            }
            return inAppMessage.getRemoteImageUrl();
        }
    }

    public InAppMessageBaseView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageView
    public void applyWindowInsets(@NotNull WindowInsetsCompat insets) {
        t.i(insets, "insets");
        setHasAppliedWindowInsets(true);
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageView
    public boolean getHasAppliedWindowInsets() {
        return this.hasAppliedWindowInsets;
    }

    @Nullable
    public abstract Object getMessageBackgroundObject();

    @Nullable
    public abstract TextView getMessageIconView();

    @Nullable
    public abstract ImageView getMessageImageView();

    @Nullable
    public abstract TextView getMessageTextView();

    public void resetMessageMargins(boolean z10) {
        CharSequence text;
        String string;
        ImageView messageImageView = getMessageImageView();
        if (messageImageView != null) {
            if (z10) {
                ViewUtils.removeViewFromParent(getMessageIconView());
            } else {
                ViewUtils.removeViewFromParent(messageImageView);
            }
        }
        TextView messageIconView = getMessageIconView();
        boolean z11 = false;
        if (messageIconView != null && (text = messageIconView.getText()) != null && (string = text.toString()) != null && q.z(string)) {
            z11 = true;
        }
        if (z11) {
            ViewUtils.removeViewFromParent(getMessageIconView());
        }
    }

    public void setHasAppliedWindowInsets(boolean z10) {
        this.hasAppliedWindowInsets = z10;
    }

    public void setMessage(@NotNull String text) {
        t.i(text, "text");
        TextView messageTextView = getMessageTextView();
        if (messageTextView == null) {
            return;
        }
        messageTextView.setText(text);
    }

    public void setMessageBackgroundColor(int i10) {
        Object messageBackgroundObject = getMessageBackgroundObject();
        t.g(messageBackgroundObject, "null cannot be cast to non-null type android.view.View");
        InAppMessageViewUtils.setViewBackgroundColor((View) messageBackgroundObject, i10);
    }

    public void setMessageIcon(@NotNull String icon, int i10, int i11) {
        t.i(icon, "icon");
        TextView messageIconView = getMessageIconView();
        if (messageIconView != null) {
            Context context = getContext();
            t.h(context, "context");
            InAppMessageViewUtils.setIcon(context, icon, i10, i11, messageIconView);
        }
    }

    public void setMessageImageView(@NotNull Bitmap bitmap) {
        t.i(bitmap, "bitmap");
        ImageView messageImageView = getMessageImageView();
        if (messageImageView != null) {
            InAppMessageViewUtils.setImage(bitmap, messageImageView);
        }
    }

    public void setMessageTextAlign(@NotNull TextAlign textAlign) {
        t.i(textAlign, "textAlign");
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            InAppMessageViewUtils.setTextAlignment(messageTextView, textAlign);
        }
    }

    public void setMessageTextColor(int i10) {
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            InAppMessageViewUtils.setTextViewColor(messageTextView, i10);
        }
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageView
    @Nullable
    public View getMessageClickableView() {
        return this;
    }
}
