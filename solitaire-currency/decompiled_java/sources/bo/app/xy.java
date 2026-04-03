package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.enums.CardKey;
import com.braze.events.FeedUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.r;

/* JADX INFO: loaded from: classes2.dex */
public final class xy implements ICardStorageProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h00 f4307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f4308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractSet f4309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractSet f4310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ty f4311e;

    public xy(Context context, String str, h00 brazeManager) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        this.f4307a = brazeManager;
        this.f4311e = new ty();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.feedstorageprovider" + StringUtils.getCacheFileSuffix(context, str == null ? "" : str), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…Id, Context.MODE_PRIVATE)");
        this.f4308b = sharedPreferences;
        this.f4309c = a(uy.VIEWED_CARDS);
        this.f4310d = a(uy.READ_CARDS);
        a(str);
    }

    public final FeedUpdatedEvent a(JSONArray cardJsonStringArray, String str, boolean z10, long j10) {
        List listW;
        if (cardJsonStringArray.length() == 0) {
            listW = new ArrayList();
        } else {
            CardKey.Provider cardKeyProvider = new CardKey.Provider(false);
            h00 brazeManager = this.f4307a;
            ty cardAnalyticsProvider = this.f4311e;
            kotlin.jvm.internal.t.i(cardJsonStringArray, "cardJsonStringArray");
            kotlin.jvm.internal.t.i(cardKeyProvider, "cardKeyProvider");
            kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
            kotlin.jvm.internal.t.i(this, "cardStorageProvider");
            kotlin.jvm.internal.t.i(cardAnalyticsProvider, "cardAnalyticsProvider");
            listW = o9.o.w(o9.o.t(o9.m.c(o9.o.s(o9.o.k(kotlin.collections.d0.a0(n9.o.u(0, cardJsonStringArray.length())), new tl(cardJsonStringArray)), new ul(cardJsonStringArray)).iterator()), new wl(cardAnalyticsProvider, cardKeyProvider, brazeManager, this, cardJsonStringArray)));
        }
        List<Card> list = listW;
        for (Card card : list) {
            if (this.f4309c.contains(card.getId())) {
                card.setViewed(true);
                card.setIndicatorHighlighted(true);
            }
            if (this.f4310d.contains(card.getId())) {
                card.setIndicatorHighlighted(true);
            }
        }
        return new FeedUpdatedEvent(list, str, z10, j10);
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsClicked(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsDismissed(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsViewed(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        if (this.f4309c.contains(cardId)) {
            return;
        }
        this.f4309c.add(cardId);
        a(this.f4309c, uy.VIEWED_CARDS);
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsVisuallyRead(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        if (this.f4310d.contains(cardId)) {
            return;
        }
        this.f4310d.add(cardId);
        a(this.f4310d, uy.READ_CARDS);
    }

    public final void a(AbstractSet cardIds, uy property) {
        kotlin.jvm.internal.t.i(cardIds, "cardIds");
        kotlin.jvm.internal.t.i(property, "property");
        String str = property.f4060a;
        SharedPreferences.Editor editorEdit = this.f4308b.edit();
        if (cardIds.isEmpty()) {
            editorEdit.remove(str);
        } else {
            editorEdit.putStringSet(str, cardIds);
        }
        editorEdit.apply();
    }

    public final void a(String str) {
        SharedPreferences.Editor editorEdit = this.f4308b.edit();
        editorEdit.putString("uid", str);
        editorEdit.apply();
    }

    public final AbstractSet a(uy uyVar) {
        String str = uyVar.f4061b;
        if (this.f4308b.contains(str)) {
            HashSet hashSet = null;
            String input = this.f4308b.getString(str, null);
            if (input != null) {
                kotlin.jvm.internal.t.i(input, "input");
                hashSet = new HashSet();
                String[] strArr = (String[]) r.C0(input, new String[]{";"}, false, 0, 6, null).toArray(new String[0]);
                Collections.addAll(hashSet, Arrays.copyOf(strArr, strArr.length));
            }
            SharedPreferences.Editor editorEdit = this.f4308b.edit();
            editorEdit.remove(str);
            editorEdit.apply();
            if (hashSet != null) {
                a(hashSet, uyVar);
                return hashSet;
            }
        }
        return new ConcurrentSkipListSet(this.f4308b.getStringSet(uyVar.f4060a, new HashSet()));
    }

    public final FeedUpdatedEvent a(String str, JSONArray cardsArray) throws JSONException {
        kotlin.jvm.internal.t.i(cardsArray, "cardsArray");
        String str2 = str == null ? "" : str;
        String string = this.f4308b.getString("uid", "");
        if (kotlin.jvm.internal.t.d(string, str2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new vy(str), 6, (Object) null);
            long jNowInSeconds = DateTimeUtils.nowInSeconds();
            SharedPreferences.Editor editorEdit = this.f4308b.edit();
            if (cardsArray.length() == 0) {
                editorEdit.remove("cards");
            } else {
                editorEdit.putString("cards", cardsArray.toString());
            }
            editorEdit.putLong("cards_timestamp", jNowInSeconds);
            editorEdit.apply();
            AbstractSet abstractSet = this.f4309c;
            kotlin.jvm.internal.t.i(cardsArray, "cardsArray");
            HashSet hashSet = new HashSet();
            int length = cardsArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = cardsArray.getJSONObject(i10);
                CardKey cardKey = CardKey.ID;
                if (jSONObject.has(cardKey.getFeedKey())) {
                    String string2 = jSONObject.getString(cardKey.getFeedKey());
                    kotlin.jvm.internal.t.h(string2, "card.getString(CardKey.ID.feedKey)");
                    hashSet.add(string2);
                }
            }
            abstractSet.retainAll(hashSet);
            a(this.f4309c, uy.VIEWED_CARDS);
            AbstractSet abstractSet2 = this.f4310d;
            kotlin.jvm.internal.t.i(cardsArray, "cardsArray");
            HashSet hashSet2 = new HashSet();
            int length2 = cardsArray.length();
            for (int i11 = 0; i11 < length2; i11++) {
                JSONObject jSONObject2 = cardsArray.getJSONObject(i11);
                CardKey cardKey2 = CardKey.ID;
                if (jSONObject2.has(cardKey2.getFeedKey())) {
                    String string3 = jSONObject2.getString(cardKey2.getFeedKey());
                    kotlin.jvm.internal.t.h(string3, "card.getString(CardKey.ID.feedKey)");
                    hashSet2.add(string3);
                }
            }
            abstractSet2.retainAll(hashSet2);
            a(this.f4310d, uy.READ_CARDS);
            return a(cardsArray, str, false, jNowInSeconds);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new wy(str, string), 7, (Object) null);
        return null;
    }
}
