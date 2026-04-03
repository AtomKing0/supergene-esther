package com.braze.ui.contentcards.handlers;

import android.os.Parcel;
import android.os.Parcelable;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.ui.contentcards.BrazeContentCardUtils;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultContentCardsUpdateHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultContentCardsUpdateHandler implements IContentCardsUpdateHandler {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<DefaultContentCardsUpdateHandler> CREATOR = new Parcelable.Creator<DefaultContentCardsUpdateHandler>() { // from class: com.braze.ui.contentcards.handlers.DefaultContentCardsUpdateHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DefaultContentCardsUpdateHandler createFromParcel(@NotNull Parcel source) {
            t.i(source, "source");
            return new DefaultContentCardsUpdateHandler();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DefaultContentCardsUpdateHandler[] newArray(int i10) {
            return new DefaultContentCardsUpdateHandler[i10];
        }
    };

    /* JADX INFO: compiled from: DefaultContentCardsUpdateHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.braze.ui.contentcards.handlers.IContentCardsUpdateHandler
    @NotNull
    public List<Card> handleCardUpdate(@NotNull ContentCardsUpdatedEvent event) {
        t.i(event, "event");
        return BrazeContentCardUtils.INSTANCE.defaultCardHandling(event.getAllCards());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i10) {
        t.i(dest, "dest");
    }
}
