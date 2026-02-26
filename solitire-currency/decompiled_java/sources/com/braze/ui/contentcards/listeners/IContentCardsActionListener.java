package com.braze.ui.contentcards.listeners;

import android.content.Context;
import com.braze.models.cards.Card;
import com.braze.ui.actions.IAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IContentCardsActionListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IContentCardsActionListener {
    boolean onContentCardClicked(@NotNull Context context, @NotNull Card card, @Nullable IAction iAction);

    void onContentCardDismissed(@NotNull Context context, @NotNull Card card);
}
