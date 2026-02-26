package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.braze.models.cards.Card;
import com.braze.models.cards.ImageOnlyCard;
import com.braze.ui.R$id;
import com.braze.ui.R$layout;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageOnlyContentCardView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ImageOnlyContentCardView extends BaseContentCardView<ImageOnlyCard> {

    /* JADX INFO: compiled from: ImageOnlyContentCardView.kt */
    private final class ViewHolder extends ContentCardViewHolder {

        @Nullable
        private final ImageView imageView;
        final /* synthetic */ ImageOnlyContentCardView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ImageOnlyContentCardView imageOnlyContentCardView, View view) {
            super(view, imageOnlyContentCardView.isUnreadIndicatorEnabled());
            t.i(view, "view");
            this.this$0 = imageOnlyContentCardView;
            this.imageView = (ImageView) view.findViewById(R$id.com_braze_content_cards_image_only_card_image);
        }

        @Nullable
        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOnlyContentCardView(@NotNull Context context) {
        super(context);
        t.i(context, "context");
    }

    @Override // com.braze.ui.contentcards.view.BaseContentCardView
    public void bindViewHolder(@NotNull ContentCardViewHolder viewHolder, @NotNull Card card) {
        t.i(viewHolder, "viewHolder");
        t.i(card, "card");
        if (card instanceof ImageOnlyCard) {
            super.bindViewHolder(viewHolder, card);
            ImageOnlyCard imageOnlyCard = (ImageOnlyCard) card;
            setOptionalCardImage(((ViewHolder) viewHolder).getImageView(), imageOnlyCard.getAspectRatio(), imageOnlyCard.getImageUrl(), card);
        }
    }

    @Override // com.braze.ui.contentcards.view.BaseContentCardView
    @NotNull
    public ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup) {
        t.i(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.com_braze_image_only_content_card, viewGroup, false);
        t.h(view, "view");
        setViewBackground(view);
        return new ViewHolder(this, view);
    }
}
