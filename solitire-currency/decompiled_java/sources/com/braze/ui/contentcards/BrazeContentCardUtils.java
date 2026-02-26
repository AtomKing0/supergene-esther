package com.braze.ui.contentcards;

import android.os.Bundle;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import com.braze.ui.contentcards.BrazeContentCardUtils;
import h9.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrazeContentCardUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeContentCardUtils {

    @NotNull
    public static final BrazeContentCardUtils INSTANCE = new BrazeContentCardUtils();

    /* JADX INFO: renamed from: com.braze.ui.contentcards.BrazeContentCardUtils$getUriActionForCard$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeContentCardUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Card URL is null, returning null for getUriActionForCard";
        }
    }

    private BrazeContentCardUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int defaultCardHandling$lambda$0(Card cardA, Card cardB) {
        t.i(cardA, "cardA");
        t.i(cardB, "cardB");
        if (cardA.isPinned() && !cardB.isPinned()) {
            return -1;
        }
        if (cardA.isPinned() || !cardB.isPinned()) {
            if (cardA.getCreated() > cardB.getCreated()) {
                return -1;
            }
            if (cardA.getCreated() >= cardB.getCreated()) {
                if (cardA.getId().compareTo(cardB.getId()) > 0) {
                    return -1;
                }
                if (cardA.getId().compareTo(cardB.getId()) >= 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    @NotNull
    public final List<Card> defaultCardHandling(@NotNull List<? extends Card> cards) {
        t.i(cards, "cards");
        Comparator comparator = new Comparator() { // from class: i0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BrazeContentCardUtils.defaultCardHandling$lambda$0((Card) obj, (Card) obj2);
            }
        };
        ArrayList arrayList = new ArrayList();
        for (Object obj : cards) {
            if (!BrazeActionUtils.containsInvalidBrazeAction((Card) obj)) {
                arrayList.add(obj);
            }
        }
        return d0.I0(arrayList, comparator);
    }

    @Nullable
    public final UriAction getUriActionForCard(@NotNull Card card) {
        t.i(card, "card");
        String url = card.getUrl();
        if (url == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : card.getExtras().keySet()) {
            bundle.putString(str, card.getExtras().get(str));
        }
        return BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(url, bundle, card.getOpenUriInWebView(), card.getChannel());
    }
}
