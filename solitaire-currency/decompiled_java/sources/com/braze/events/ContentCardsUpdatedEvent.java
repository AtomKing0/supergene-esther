package com.braze.events;

import com.braze.models.cards.Card;
import com.braze.support.DateTimeUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class ContentCardsUpdatedEvent {
    public static final Companion Companion = new Companion(null);
    private final List<Card> contentCards;
    private final boolean isFromOfflineStorage;
    private final long timestampSeconds;
    private final String userId;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final ContentCardsUpdatedEvent getEmptyUpdate() {
            return new ContentCardsUpdatedEvent(v.l(), null, DateTimeUtils.nowInSeconds(), true);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContentCardsUpdatedEvent(List<? extends Card> contentCards, String str, long j10, boolean z10) {
        t.i(contentCards, "contentCards");
        this.contentCards = contentCards;
        this.userId = str;
        this.timestampSeconds = j10;
        this.isFromOfflineStorage = z10;
    }

    public final List<Card> getAllCards() {
        return d0.R0(this.contentCards);
    }

    public final int getCardCount() {
        return this.contentCards.size();
    }

    public final boolean isFromOfflineStorage() {
        return this.isFromOfflineStorage;
    }

    public final boolean isTimestampOlderThan(long j10) {
        return TimeUnit.SECONDS.toMillis(this.timestampSeconds + j10) < DateTimeUtils.nowInMilliseconds();
    }

    public String toString() {
        return "ContentCardsUpdatedEvent{userId='" + this.userId + "', timestampSeconds=" + this.timestampSeconds + ", isFromOfflineStorage=" + this.isFromOfflineStorage + ", card count=" + getCardCount() + '}';
    }
}
