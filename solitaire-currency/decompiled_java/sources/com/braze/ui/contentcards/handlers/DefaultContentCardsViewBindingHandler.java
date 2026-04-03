package com.braze.ui.contentcards.handlers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.braze.enums.CardType;
import com.braze.models.cards.Card;
import com.braze.ui.contentcards.view.BaseContentCardView;
import com.braze.ui.contentcards.view.CaptionedImageContentCardView;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import com.braze.ui.contentcards.view.DefaultContentCardView;
import com.braze.ui.contentcards.view.ImageOnlyContentCardView;
import com.braze.ui.contentcards.view.ShortNewsContentCardView;
import com.braze.ui.contentcards.view.TextAnnouncementContentCardView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultContentCardsViewBindingHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultContentCardsViewBindingHandler implements IContentCardsViewBindingHandler {

    @NotNull
    private final Map<CardType, BaseContentCardView<?>> contentCardViewCache = new LinkedHashMap();

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<DefaultContentCardsViewBindingHandler> CREATOR = new Parcelable.Creator<DefaultContentCardsViewBindingHandler>() { // from class: com.braze.ui.contentcards.handlers.DefaultContentCardsViewBindingHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DefaultContentCardsViewBindingHandler createFromParcel(@NotNull Parcel source) {
            t.i(source, "source");
            return new DefaultContentCardsViewBindingHandler();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DefaultContentCardsViewBindingHandler[] newArray(int i10) {
            return new DefaultContentCardsViewBindingHandler[i10];
        }
    };

    /* JADX INFO: compiled from: DefaultContentCardsViewBindingHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: DefaultContentCardsViewBindingHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardType.values().length];
            try {
                iArr[CardType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardType.CAPTIONED_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardType.SHORT_NEWS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CardType.TEXT_ANNOUNCEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @VisibleForTesting
    @NotNull
    public final BaseContentCardView<?> getContentCardsViewFromCache(@NotNull Context context, @NotNull CardType cardType) {
        t.i(context, "context");
        t.i(cardType, "cardType");
        if (!this.contentCardViewCache.containsKey(cardType) || this.contentCardViewCache.get(cardType) == null) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[cardType.ordinal()];
            this.contentCardViewCache.put(cardType, i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new DefaultContentCardView(context) : new TextAnnouncementContentCardView(context) : new ShortNewsContentCardView(context) : new CaptionedImageContentCardView(context) : new ImageOnlyContentCardView(context));
        }
        BaseContentCardView<?> baseContentCardView = this.contentCardViewCache.get(cardType);
        return baseContentCardView == null ? new DefaultContentCardView(context) : baseContentCardView;
    }

    @Override // com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler
    public int getItemViewType(@NotNull Context context, @NotNull List<? extends Card> cards, int i10) {
        t.i(context, "context");
        t.i(cards, "cards");
        if (i10 < 0 || i10 >= cards.size()) {
            return -1;
        }
        return cards.get(i10).getCardType().getValue();
    }

    @Override // com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler
    public void onBindViewHolder(@NotNull Context context, @NotNull List<? extends Card> cards, @NotNull ContentCardViewHolder viewHolder, int i10) {
        t.i(context, "context");
        t.i(cards, "cards");
        t.i(viewHolder, "viewHolder");
        if (i10 < 0 || i10 >= cards.size()) {
            return;
        }
        Card card = cards.get(i10);
        getContentCardsViewFromCache(context, card.getCardType()).bindViewHolder(viewHolder, card);
    }

    @Override // com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler
    @NotNull
    public ContentCardViewHolder onCreateViewHolder(@NotNull Context context, @NotNull List<? extends Card> cards, @NotNull ViewGroup viewGroup, int i10) {
        t.i(context, "context");
        t.i(cards, "cards");
        t.i(viewGroup, "viewGroup");
        return getContentCardsViewFromCache(context, CardType.Companion.fromValue(i10)).createViewHolder(viewGroup);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i10) {
        t.i(dest, "dest");
    }
}
