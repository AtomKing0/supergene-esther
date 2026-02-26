package com.braze.models.cards;

import bo.app.e00;
import bo.app.el;
import bo.app.fl;
import bo.app.gl;
import bo.app.h00;
import bo.app.hl;
import bo.app.il;
import bo.app.jl;
import bo.app.kl;
import bo.app.ll;
import bo.app.m00;
import bo.app.ml;
import bo.app.nl;
import bo.app.ol;
import bo.app.pl;
import bo.app.ql;
import bo.app.tf;
import com.braze.enums.CardCategory;
import com.braze.enums.CardKey;
import com.braze.enums.CardType;
import com.braze.enums.Channel;
import com.braze.models.IPutIntoJson;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import h9.a;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import o9.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.j;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public class Card implements IPutIntoJson<JSONObject> {
    public static final el Companion = new el();
    private final h00 brazeManager;
    private final m00 cardAnalytics;
    private final ICardStorageProvider<?> cardStorage;
    private final CardType cardType;
    private EnumSet<CardCategory> categories;
    private final Channel channel;
    private final long created;
    private final long expiresAt;
    private final Map<String, String> extras;
    private final String id;
    private boolean isClicked;
    private final boolean isContentCard;
    private boolean isDismissedInternal;
    private boolean isDismissibleByUser;
    private boolean isIndicatorHighlightedInternal;
    private boolean isPinned;
    private final boolean isRemoved;
    private boolean isTest;
    private final JSONObject jsonObject;
    private ICardListener listener;
    private final boolean openUriInWebView;
    private final long updated;
    private final String url;
    private boolean wasViewedInternal;

    public Card(JSONObject jsonObject, CardKey.Provider cardKeysProvider, h00 h00Var, ICardStorageProvider<?> iCardStorageProvider, m00 m00Var) throws JSONException {
        t.i(jsonObject, "jsonObject");
        t.i(cardKeysProvider, "cardKeysProvider");
        this.jsonObject = jsonObject;
        this.brazeManager = h00Var;
        this.cardStorage = iCardStorageProvider;
        this.cardAnalytics = m00Var;
        this.extras = JsonUtils.convertJSONObjectToMap(jsonObject.optJSONObject(cardKeysProvider.getKey(CardKey.EXTRAS)));
        String string = jsonObject.getString(cardKeysProvider.getKey(CardKey.ID));
        t.h(string, "jsonObject.getString(car…vider.getKey(CardKey.ID))");
        this.id = string;
        this.isContentCard = cardKeysProvider.isContentCardProvider();
        this.cardType = CardType.DEFAULT;
        this.channel = cardKeysProvider.isContentCardProvider() ? Channel.CONTENT_CARD : Channel.NEWS_FEED;
        this.wasViewedInternal = jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.VIEWED));
        this.isDismissedInternal = jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.DISMISSED), false);
        this.isPinned = jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.PINNED), false);
        this.created = jsonObject.getLong(cardKeysProvider.getKey(CardKey.CREATED));
        this.expiresAt = jsonObject.optLong(cardKeysProvider.getKey(CardKey.EXPIRES_AT), -1L);
        this.openUriInWebView = jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.OPEN_URI_IN_WEBVIEW), false);
        this.isRemoved = jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.REMOVED), false);
        JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray(cardKeysProvider.getKey(CardKey.CATEGORIES));
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            this.categories = EnumSet.of(CardCategory.NO_CATEGORY);
        } else {
            EnumSet<CardCategory> enumSetNoneOf = EnumSet.noneOf(CardCategory.class);
            Iterator it = o.s(o.k(d0.a0(n9.o.u(0, jSONArrayOptJSONArray.length())), new fl(jSONArrayOptJSONArray)), new gl(jSONArrayOptJSONArray)).iterator();
            while (it.hasNext()) {
                CardCategory cardCategory = CardCategory.get((String) it.next());
                if (cardCategory != null) {
                    t.h(cardCategory, "get(categoryString)");
                    enumSetNoneOf.add(cardCategory);
                }
            }
            this.categories = enumSetNoneOf;
        }
        this.updated = this.jsonObject.optLong(cardKeysProvider.getKey(CardKey.UPDATED), this.created);
        this.isDismissibleByUser = this.jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.DISMISSIBLE), false);
        this.isIndicatorHighlightedInternal = this.jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.READ), this.wasViewedInternal);
        this.isClicked = this.jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.CLICKED), false);
        this.isTest = this.jsonObject.optBoolean(cardKeysProvider.getKey(CardKey.IS_TEST), false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(getClass(), obj.getClass())) {
            return false;
        }
        Card card = (Card) obj;
        return this.updated == card.updated && t.d(this.id, card.id);
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getCreated() {
        return this.created;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getOpenUriInWebView() {
        return this.openUriInWebView;
    }

    public String getUrl() {
        return this.url;
    }

    public final boolean getViewed() {
        return this.wasViewedInternal;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        long j10 = this.updated;
        return iHashCode + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final boolean isControl() {
        return getCardType() == CardType.CONTROL;
    }

    public final boolean isDismissibleByUser() {
        return this.isDismissibleByUser;
    }

    public final boolean isExpired() {
        long j10 = this.expiresAt;
        return j10 != -1 && j10 <= DateTimeUtils.nowInSeconds();
    }

    public final boolean isInCategorySet(EnumSet<CardCategory> categories) {
        t.i(categories, "categories");
        EnumSet<CardCategory> enumSet = this.categories;
        if (enumSet == null) {
            return false;
        }
        Iterator<CardCategory> it = categories.iterator();
        while (it.hasNext()) {
            if (enumSet.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isIndicatorHighlighted() {
        return this.isIndicatorHighlightedInternal;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final boolean isValidCard() {
        if (!q.z(this.id)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) kl.f3261a, 6, (Object) null);
        return false;
    }

    public final boolean logClick() {
        try {
            this.isClicked = true;
            if (this.brazeManager == null || this.cardAnalytics == null || this.cardStorage == null || !isValidCard()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new ml(this), 6, (Object) null);
                return false;
            }
            e00 e00VarB = this.cardAnalytics.b(this.id);
            if (e00VarB != null) {
                ((tf) this.brazeManager).a(e00VarB);
            }
            this.cardStorage.markCardAsClicked(this.id);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new ll(this), 7, (Object) null);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (a) new nl(this), 4, (Object) null);
            return false;
        }
    }

    public final boolean logImpression() {
        try {
            if (this.brazeManager == null || this.cardAnalytics == null || this.cardStorage == null || !isValidCard()) {
                return false;
            }
            if (isControl()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new pl(this), 6, (Object) null);
                e00 e00VarC = this.cardAnalytics.c(this.id);
                if (e00VarC != null) {
                    ((tf) this.brazeManager).a(e00VarC);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new ol(this), 6, (Object) null);
                e00 e00VarD = this.cardAnalytics.d(this.id);
                if (e00VarD != null) {
                    ((tf) this.brazeManager).a(e00VarD);
                }
            }
            this.cardStorage.markCardAsViewed(this.id);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (a) new ql(this), 4, (Object) null);
            return false;
        }
    }

    public final void setDismissed(boolean z10) {
        e00 e00VarA;
        if (this.isDismissedInternal && z10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) hl.f2988a, 6, (Object) null);
            return;
        }
        this.isDismissedInternal = z10;
        ICardStorageProvider<?> iCardStorageProvider = this.cardStorage;
        if (iCardStorageProvider != null) {
            iCardStorageProvider.markCardAsDismissed(this.id);
        }
        if (z10) {
            try {
                if (this.brazeManager == null || this.cardAnalytics == null || !isValidCard() || (e00VarA = this.cardAnalytics.a(this.id)) == null) {
                    return;
                }
                ((tf) this.brazeManager).a(e00VarA);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (a) il.f3071a, 4, (Object) null);
            }
        }
    }

    public final void setIndicatorHighlighted(boolean z10) {
        ICardStorageProvider<?> iCardStorageProvider;
        this.isIndicatorHighlightedInternal = z10;
        try {
            ICardListener iCardListener = this.listener;
            if (iCardListener != null) {
                iCardListener.onCardUpdate();
            }
        } catch (Exception unused) {
        }
        if (!z10 || (iCardStorageProvider = this.cardStorage) == null) {
            return;
        }
        try {
            iCardStorageProvider.markCardAsVisuallyRead(this.id);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) e10, false, (a) jl.f3166a, 4, (Object) null);
        }
    }

    public final void setListener(ICardListener iCardListener) {
        this.listener = iCardListener;
    }

    public final void setViewed(boolean z10) {
        this.wasViewedInternal = z10;
        ICardStorageProvider<?> iCardStorageProvider = this.cardStorage;
        if (iCardStorageProvider != null) {
            iCardStorageProvider.markCardAsViewed(this.id);
        }
    }

    public String toString() {
        return j.f("\n            Card{\n            extras=" + this.extras + "\n            id='" + this.id + "'\n            created=" + this.created + "\n            updated=" + this.updated + "\n            expiresAt=" + this.expiresAt + "\n            categories=" + this.categories + "\n            isContentCard=" + this.isContentCard + "\n            viewed=" + this.wasViewedInternal + "\n            isRead=" + this.isIndicatorHighlightedInternal + "\n            isDismissed=" + this.isDismissedInternal + "\n            isRemoved=" + this.isRemoved + "\n            isPinned=" + this.isPinned + "\n            isClicked=" + this.isClicked + "\n            openUriInWebview=" + this.openUriInWebView + "\n            isDismissibleByUser=" + this.isDismissibleByUser + "\n            isTest=" + this.isTest + "\n            json=" + JsonUtils.getPrettyPrintedString(this.jsonObject) + "\n            }\n\n        ");
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        return this.jsonObject;
    }
}
