package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.ui.R$id;
import com.braze.ui.R$layout;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: CaptionedImageContentCardView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class CaptionedImageContentCardView extends BaseContentCardView<CaptionedImageCard> {

    /* JADX INFO: compiled from: CaptionedImageContentCardView.kt */
    private final class ViewHolder extends ContentCardViewHolder {

        @Nullable
        private final TextView description;

        @Nullable
        private final ImageView imageView;
        final /* synthetic */ CaptionedImageContentCardView this$0;

        @Nullable
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull CaptionedImageContentCardView captionedImageContentCardView, View view) {
            super(view, captionedImageContentCardView.isUnreadIndicatorEnabled());
            t.i(view, "view");
            this.this$0 = captionedImageContentCardView;
            this.title = (TextView) view.findViewById(R$id.com_braze_content_cards_captioned_image_title);
            this.description = (TextView) view.findViewById(R$id.com_braze_content_cards_captioned_image_description);
            this.imageView = (ImageView) view.findViewById(R$id.com_braze_content_cards_captioned_image_card_image);
        }

        @Nullable
        public final TextView getDescription() {
            return this.description;
        }

        @Nullable
        public final ImageView getImageView() {
            return this.imageView;
        }

        @Nullable
        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptionedImageContentCardView(@NotNull Context context) {
        super(context);
        t.i(context, "context");
    }

    @Override // com.braze.ui.contentcards.view.BaseContentCardView
    public void bindViewHolder(@NotNull ContentCardViewHolder viewHolder, @NotNull Card card) {
        t.i(viewHolder, "viewHolder");
        t.i(card, "card");
        if (card instanceof CaptionedImageCard) {
            super.bindViewHolder(viewHolder, card);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            TextView title = viewHolder2.getTitle();
            if (title != null) {
                setOptionalTextView(title, ((CaptionedImageCard) card).getTitle());
            }
            TextView description = viewHolder2.getDescription();
            if (description != null) {
                setOptionalTextView(description, ((CaptionedImageCard) card).getDescription());
            }
            CaptionedImageCard captionedImageCard = (CaptionedImageCard) card;
            String domain = captionedImageCard.getDomain();
            String url = domain == null || q.z(domain) ? card.getUrl() : captionedImageCard.getDomain();
            if (url != null) {
                viewHolder2.setActionHintText(url);
            }
            setOptionalCardImage(viewHolder2.getImageView(), captionedImageCard.getAspectRatio(), captionedImageCard.getImageUrl(), card);
            viewHolder.itemView.setContentDescription(captionedImageCard.getTitle() + " .  " + captionedImageCard.getDescription());
        }
    }

    @Override // com.braze.ui.contentcards.view.BaseContentCardView
    @NotNull
    public ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup) {
        t.i(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.com_braze_captioned_image_content_card, viewGroup, false);
        t.h(view, "view");
        setViewBackground(view);
        return new ViewHolder(this, view);
    }
}
