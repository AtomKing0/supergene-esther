package com.braze.ui.contentcards.handlers;

import android.os.Parcelable;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IContentCardsUpdateHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IContentCardsUpdateHandler extends Parcelable {
    @NotNull
    List<Card> handleCardUpdate(@NotNull ContentCardsUpdatedEvent contentCardsUpdatedEvent);
}
