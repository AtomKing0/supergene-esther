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
public final class CaptionedImageCard extends Card {
    private final float aspectRatio;
    private final CardType cardType;
    private final String description;
    private final String domain;
    private final String imageUrl;
    private final String title;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptionedImageCard(JSONObject jsonObject, CardKey.Provider cardKeyProvider, h00 h00Var, ICardStorageProvider<?> iCardStorageProvider, m00 m00Var) throws JSONException {
        super(jsonObject, cardKeyProvider, h00Var, iCardStorageProvider, m00Var);
        t.i(jsonObject, "jsonObject");
        t.i(cardKeyProvider, "cardKeyProvider");
        String string = jsonObject.getString(cardKeyProvider.getKey(CardKey.CAPTIONED_IMAGE_IMAGE));
        t.h(string, "jsonObject.getString(car…y.CAPTIONED_IMAGE_IMAGE))");
        this.imageUrl = string;
        String string2 = jsonObject.getString(cardKeyProvider.getKey(CardKey.CAPTIONED_IMAGE_TITLE));
        t.h(string2, "jsonObject.getString(car…y.CAPTIONED_IMAGE_TITLE))");
        this.title = string2;
        String string3 = jsonObject.getString(cardKeyProvider.getKey(CardKey.CAPTIONED_IMAGE_DESCRIPTION));
        t.h(string3, "jsonObject.getString(car…IONED_IMAGE_DESCRIPTION))");
        this.description = string3;
        this.url = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.CAPTIONED_IMAGE_URL));
        this.domain = JsonUtils.getOptionalString(jsonObject, cardKeyProvider.getKey(CardKey.CAPTIONED_IMAGE_DOMAIN));
        this.aspectRatio = (float) jsonObject.optDouble(cardKeyProvider.getKey(CardKey.CAPTIONED_IMAGE_ASPECT_RATIO), 0.0d);
        this.cardType = CardType.CAPTIONED_IMAGE;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
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
        return j.f("\n            CaptionedImageCard{imageUrl='" + this.imageUrl + "'\n            title='" + this.title + "'\n            description='" + this.description + "'\n            url='" + getUrl() + "'\n            domain='" + this.domain + "'\n            aspectRatio=" + this.aspectRatio + "\n            " + super.toString() + "}\n\n        ");
    }
}
