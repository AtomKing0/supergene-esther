package com.braze.models.cards;

import bo.app.h00;
import bo.app.m00;
import com.braze.enums.CardKey;
import com.braze.enums.CardType;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.JsonUtils;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;
import p9.j;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortNewsCard extends Card {
    private final CardType cardType;
    private final String description;
    private final String domain;
    private final String imageUrl;
    private final String title;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortNewsCard(JSONObject jsonObject, CardKey.Provider cardKeyProvider, h00 h00Var, ICardStorageProvider<?> iCardStorageProvider, m00 m00Var) throws JSONException {
        super(jsonObject, cardKeyProvider, h00Var, iCardStorageProvider, m00Var);
        t.i(jsonObject, "jsonObject");
        t.i(cardKeyProvider, "cardKeyProvider");
        String string = jsonObject.getString(cardKeyProvider.getKey(CardKey.SHORT_NEWS_DESCRIPTION));
        t.h(string, "jsonObject.getString(car….SHORT_NEWS_DESCRIPTION))");
        this.description = string;
        String string2 = jsonObject.getString(cardKeyProvider.getKey(CardKey.SHORT_NEWS_IMAGE));
        t.h(string2, "jsonObject.getString(car…ardKey.SHORT_NEWS_IMAGE))");
        this.imageUrl = string2;
        this.title = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.SHORT_NEWS_TITLE));
        this.url = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.SHORT_NEWS_URL));
        this.domain = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.SHORT_NEWS_DOMAIN));
        this.cardType = CardType.SHORT_NEWS;
    }

    @Override // com.braze.models.cards.Card
    public CardType getCardType() {
        return this.cardType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.braze.models.cards.Card
    public String getUrl() {
        return this.url;
    }

    @Override // com.braze.models.cards.Card
    public String toString() {
        return j.f("\n            ShortNewsCard{description='" + this.description + "'\n            imageUrl='" + this.imageUrl + "'\n            title='" + this.title + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "\n            " + super.toString() + "}\n\n        ");
    }
}
