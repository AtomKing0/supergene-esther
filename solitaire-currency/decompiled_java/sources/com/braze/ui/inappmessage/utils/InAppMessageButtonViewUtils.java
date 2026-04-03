package com.braze.ui.inappmessage.utils;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.R$dimen;
import com.braze.ui.R$drawable;
import com.braze.ui.R$id;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageButtonViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InAppMessageButtonViewUtils {

    @NotNull
    public static final InAppMessageButtonViewUtils INSTANCE = new InAppMessageButtonViewUtils();

    private InAppMessageButtonViewUtils() {
    }

    @NotNull
    public static final Drawable getButtonDrawable(@NotNull Context context, @NotNull MessageButton messageButton, int i10, int i11, boolean z10) {
        t.i(context, "context");
        t.i(messageButton, "messageButton");
        Drawable drawable = getDrawable(context, R$drawable.com_braze_inappmessage_button_background);
        drawable.mutate();
        t.g(drawable, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
        Drawable drawableFindDrawableByLayerId = ((RippleDrawable) drawable).findDrawableByLayerId(R$id.com_braze_inappmessage_button_background_ripple_internal_gradient);
        t.g(drawableFindDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawableFindDrawableByLayerId;
        if (z10) {
            i10 = i11;
        }
        gradientDrawable.setStroke(i10, messageButton.getBorderColor());
        gradientDrawable.setColor(messageButton.getBackgroundColor());
        return drawable;
    }

    @NotNull
    public static final Drawable getDrawable(@NotNull Context context, int i10) {
        t.i(context, "context");
        Drawable drawable = context.getResources().getDrawable(i10, null);
        t.h(drawable, "context.resources.getDrawable(drawableId, null)");
        return drawable;
    }

    public static final void setButton(@NotNull Button button, @NotNull MessageButton messageButton, int i10, int i11) {
        t.i(button, "button");
        t.i(messageButton, "messageButton");
        button.setText(messageButton.getText());
        button.setContentDescription(messageButton.getText());
        InAppMessageViewUtils.setTextViewColor(button, messageButton.getTextColor());
        StateListDrawable stateListDrawable = new StateListDrawable();
        button.setStateListAnimator(null);
        Context context = button.getContext();
        t.h(context, "button.context");
        Drawable buttonDrawable = getButtonDrawable(context, messageButton, i10, i11, false);
        Context context2 = button.getContext();
        t.h(context2, "button.context");
        stateListDrawable.addState(new int[]{R.attr.state_focused}, getButtonDrawable(context2, messageButton, i10, i11, true));
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, buttonDrawable);
        button.setBackground(stateListDrawable);
    }

    public static final void setButtons(@NotNull List<? extends View> buttonViews, @NotNull List<? extends MessageButton> messageButtons) {
        t.i(buttonViews, "buttonViews");
        t.i(messageButtons, "messageButtons");
        int size = buttonViews.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = buttonViews.get(i10);
            MessageButton messageButton = messageButtons.get(i10);
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R$dimen.com_braze_inappmessage_button_border_stroke);
            int dimensionPixelSize2 = view.getContext().getResources().getDimensionPixelSize(R$dimen.com_braze_inappmessage_button_border_stroke_focused);
            if (messageButtons.size() <= i10) {
                view.setVisibility(8);
            } else if (view instanceof Button) {
                setButton((Button) view, messageButton, dimensionPixelSize, dimensionPixelSize2);
            }
        }
    }
}
