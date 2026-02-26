package com.braze.models.cards;

import bo.app.h00;
import bo.app.h1;
import bo.app.m00;
import com.braze.enums.CardKey;
import com.braze.enums.CardType;
import com.braze.storage.ICardStorageProvider;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ControlCard extends Card {
    private final CardType cardType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlCard(JSONObject jsonObject, CardKey.Provider cardKeysProvider, h00 h00Var, ICardStorageProvider<?> iCardStorageProvider, m00 m00Var) {
        super(jsonObject, cardKeysProvider, h00Var, iCardStorageProvider, m00Var);
        t.i(jsonObject, "jsonObject");
        t.i(cardKeysProvider, "cardKeysProvider");
        this.cardType = CardType.CONTROL;
    }

    @Override // com.braze.models.cards.Card
    public CardType getCardType() {
        return this.cardType;
    }

    @Override // com.braze.models.cards.Card
    public String toString() {
        return h1.a(new StringBuilder("ControlCard{"), super.toString(), '}');
    }
}
