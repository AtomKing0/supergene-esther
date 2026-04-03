package com.braze.ui.contentcards.listeners;

import android.content.Context;
import com.braze.models.cards.Card;
import com.braze.ui.actions.IAction;
import k0.a;

/* JADX INFO: compiled from: DefaultContentCardsActionListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultContentCardsActionListener implements IContentCardsActionListener {
    @Override // com.braze.ui.contentcards.listeners.IContentCardsActionListener
    public /* synthetic */ boolean onContentCardClicked(Context context, Card card, IAction iAction) {
        return a.a(this, context, card, iAction);
    }

    @Override // com.braze.ui.contentcards.listeners.IContentCardsActionListener
    public /* synthetic */ void onContentCardDismissed(Context context, Card card) {
        a.b(this, context, card);
    }
}
