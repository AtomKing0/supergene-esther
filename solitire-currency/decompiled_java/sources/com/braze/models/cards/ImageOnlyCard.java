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
public final class ImageOnlyCard extends Card {
    private final float aspectRatio;
    private final CardType cardType;
    private final String domain;
    private final String imageUrl;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOnlyCard(JSONObject jsonObject, CardKey.Provider cardKeyProvider, h00 h00Var, ICardStorageProvider<?> iCardStorageProvider, m00 m00Var) throws JSONException {
        super(jsonObject, cardKeyProvider, h00Var, iCardStorageProvider, m00Var);
        t.i(jsonObject, "jsonObject");
        t.i(cardKeyProvider, "cardKeyProvider");
        String string = jsonObject.getString(cardKeyProvider.getKey(CardKey.IMAGE_ONLY_IMAGE));
        t.h(string, "jsonObject.getString(car…ardKey.IMAGE_ONLY_IMAGE))");
        this.imageUrl = string;
        this.url = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.IMAGE_ONLY_URL));
        this.domain = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.IMAGE_ONLY_DOMAIN));
        this.aspectRatio = (float) jsonObject.optDouble(cardKeyProvider.getKey(CardKey.IMAGE_ONLY_ASPECT_RATIO), 0.0d);
        this.cardType = CardType.IMAGE;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // com.braze.models.cards.Card
    public CardType getCardType() {
        return this.cardType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.braze.models.cards.Card
    public String getUrl() {
        return this.url;
    }

    @Override // com.braze.models.cards.Card
    public String toString() {
        return j.f("\n            ImageOnlyCard{imageUrl='" + this.imageUrl + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "'\n            aspectRatio=" + this.aspectRatio + "\n            " + super.toString() + "}\n            \n        ");
    }
}
