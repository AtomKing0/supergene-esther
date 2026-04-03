package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$dimen;
import com.braze.ui.R$id;
import com.braze.ui.inappmessage.config.BrazeInAppMessageParams;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageModalView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageModalView extends InAppMessageImmersiveBaseView {

    @Nullable
    private InAppMessageModal inAppMessage;

    @Nullable
    private InAppMessageImageView inAppMessageImageView;

    public InAppMessageModalView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetMessageMargins$lambda$0(InAppMessageModalView this$0, View view) {
        t.i(this$0, "this$0");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) InAppMessageModalView$resetMessageMargins$1$1.INSTANCE, 7, (Object) null);
        View messageClickableView = this$0.getMessageClickableView();
        if (messageClickableView != null) {
            messageClickableView.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resizeGraphicFrameIfAppropriate$lambda$2(InAppMessageModalView this$0, int i10, int i11, int i12, double d10) {
        t.i(this$0, "this$0");
        double dMin = Math.min(this$0.getMeasuredWidth() - i10, i11);
        double dMin2 = Math.min(this$0.getMeasuredHeight() - i10, i12);
        double d11 = dMin / dMin2;
        View viewFindViewById = this$0.findViewById(R$id.com_braze_inappmessage_modal_graphic_bound);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            t.g(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (d10 >= d11) {
                layoutParams2.width = (int) dMin;
                layoutParams2.height = (int) (dMin / d10);
            } else {
                layoutParams2.width = (int) (d10 * dMin2);
                layoutParams2.height = (int) dMin2;
            }
            viewFindViewById.setLayoutParams(layoutParams2);
        }
    }

    public void applyInAppMessageParameters(@NotNull Context context, @NotNull InAppMessageModal inAppMessage) {
        t.i(context, "context");
        t.i(inAppMessage, "inAppMessage");
        this.inAppMessage = inAppMessage;
        InAppMessageImageView inAppMessageImageView = (InAppMessageImageView) findViewById(R$id.com_braze_inappmessage_modal_imageview);
        this.inAppMessageImageView = inAppMessageImageView;
        if (inAppMessageImageView != null) {
            setInAppMessageImageViewAttributes(context, inAppMessage, inAppMessageImageView);
        }
        resizeGraphicFrameIfAppropriate(context, inAppMessage);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView
    @Nullable
    public View getFrameView() {
        return findViewById(R$id.com_braze_inappmessage_modal_frame);
    }

    @Nullable
    protected final InAppMessageModal getInAppMessage() {
        return this.inAppMessage;
    }

    @Nullable
    protected final InAppMessageImageView getInAppMessageImageView() {
        return this.inAppMessageImageView;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.IInAppMessageImmersiveView
    @NotNull
    public List<View> getMessageButtonViews(int i10) {
        ArrayList arrayList = new ArrayList();
        if (i10 == 1) {
            View viewFindViewById = findViewById(R$id.com_braze_inappmessage_modal_button_layout_single);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            View viewFindViewById2 = findViewById(R$id.com_braze_inappmessage_modal_button_single_one);
            if (viewFindViewById2 != null) {
                arrayList.add(viewFindViewById2);
            }
        } else if (i10 == 2) {
            View viewFindViewById3 = findViewById(R$id.com_braze_inappmessage_modal_button_layout_dual);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(0);
            }
            View viewFindViewById4 = findViewById(R$id.com_braze_inappmessage_modal_button_dual_one);
            View viewFindViewById5 = findViewById(R$id.com_braze_inappmessage_modal_button_dual_two);
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
        return findViewById(R$id.com_braze_inappmessage_modal);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.IInAppMessageImmersiveView
    @Nullable
    public View getMessageCloseButtonView() {
        return findViewById(R$id.com_braze_inappmessage_modal_close_button);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView
    @Nullable
    public TextView getMessageHeaderTextView() {
        return (TextView) findViewById(R$id.com_braze_inappmessage_modal_header_text);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public TextView getMessageIconView() {
        return (TextView) findViewById(R$id.com_braze_inappmessage_modal_icon);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public ImageView getMessageImageView() {
        return this.inAppMessageImageView;
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public TextView getMessageTextView() {
        return (TextView) findViewById(R$id.com_braze_inappmessage_modal_message);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        Context context = getContext();
        t.h(context, "this.context");
        resizeGraphicFrameIfAppropriate(context, this.inAppMessage);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView, com.braze.ui.inappmessage.views.InAppMessageBaseView
    public void resetMessageMargins(boolean z10) {
        super.resetMessageMargins(z10);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.com_braze_inappmessage_modal_image_layout);
        if ((z10 || getMessageIconView() != null) && relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
        }
        View viewFindViewById = findViewById(R$id.com_braze_inappmessage_modal_text_layout);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.braze.ui.inappmessage.views.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InAppMessageModalView.resetMessageMargins$lambda$0(this.f8144a, view);
                }
            });
        }
    }

    protected void resizeGraphicFrameIfAppropriate(@NotNull Context context, @Nullable InAppMessageModal inAppMessageModal) {
        Bitmap bitmap;
        t.i(context, "context");
        if (inAppMessageModal == null || (bitmap = inAppMessageModal.getBitmap()) == null || inAppMessageModal.getImageStyle() != ImageStyle.GRAPHIC) {
            return;
        }
        final double width = ((double) bitmap.getWidth()) / ((double) bitmap.getHeight());
        Resources resources = context.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.com_braze_inappmessage_modal_margin);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.com_braze_inappmessage_modal_max_width);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.com_braze_inappmessage_modal_max_height);
        post(new Runnable() { // from class: com.braze.ui.inappmessage.views.f
            @Override // java.lang.Runnable
            public final void run() {
                InAppMessageModalView.resizeGraphicFrameIfAppropriate$lambda$2(this.f8139a, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, width);
            }
        });
    }

    protected final void setInAppMessage(@Nullable InAppMessageModal inAppMessageModal) {
        this.inAppMessage = inAppMessageModal;
    }

    protected final void setInAppMessageImageView(@Nullable InAppMessageImageView inAppMessageImageView) {
        this.inAppMessageImageView = inAppMessageImageView;
    }

    protected void setInAppMessageImageViewAttributes(@NotNull Context context, @NotNull IInAppMessageImmersive inAppMessage, @NotNull IInAppMessageImageView inAppMessageImageView) {
        t.i(context, "context");
        t.i(inAppMessage, "inAppMessage");
        t.i(inAppMessageImageView, "inAppMessageImageView");
        float fConvertDpToPixels = (float) ViewUtils.convertDpToPixels(context, BrazeInAppMessageParams.getModalizedImageRadiusDp());
        if (inAppMessage.getImageStyle() == ImageStyle.GRAPHIC) {
            inAppMessageImageView.setCornersRadiusPx(fConvertDpToPixels);
        } else {
            inAppMessageImageView.setCornersRadiiPx(fConvertDpToPixels, fConvertDpToPixels, 0.0f, 0.0f);
        }
        inAppMessageImageView.setInAppMessageImageCropType(inAppMessage.getCropType());
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    public void setMessageBackgroundColor(int i10) {
        View viewFindViewById = findViewById(R$id.com_braze_inappmessage_modal);
        t.h(viewFindViewById, "findViewById(R.id.com_braze_inappmessage_modal)");
        InAppMessageViewUtils.setViewBackgroundColorFilter(viewFindViewById, i10);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageBaseView
    @Nullable
    public Drawable getMessageBackgroundObject() {
        View messageClickableView = getMessageClickableView();
        if (messageClickableView != null) {
            return messageClickableView.getBackground();
        }
        return null;
    }
}
