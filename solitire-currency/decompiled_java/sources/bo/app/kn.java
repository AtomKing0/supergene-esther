package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.enums.CardKey;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.z0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public final class kn implements ICardStorageProvider {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f3263l = z0.h(CardKey.VIEWED.getContentCardsKey(), CardKey.DISMISSED.getContentCardsKey());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h00 f3265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f3268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f3269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f3270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f3271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SharedPreferences f3272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SharedPreferences f3273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final cm f3274k;

    public /* synthetic */ kn(Context context, String str, String str2, h00 h00Var) {
        this(context, str, str2, h00Var, "32.1.0");
    }

    public final ContentCardsUpdatedEvent a(boolean z10) {
        CardKey.Provider cardKeyProvider = CardKey.Provider.CONTENT_CARDS;
        JSONArray cardJsonStringArray = new JSONArray();
        Iterator it = this.f3271h.values().iterator();
        while (it.hasNext()) {
            cardJsonStringArray.put((String) it.next());
        }
        h00 brazeManager = this.f3265b;
        cm cardAnalyticsProvider = this.f3274k;
        kotlin.jvm.internal.t.i(cardJsonStringArray, "cardJsonStringArray");
        kotlin.jvm.internal.t.i(cardKeyProvider, "cardKeyProvider");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(this, "cardStorageProvider");
        kotlin.jvm.internal.t.i(cardAnalyticsProvider, "cardAnalyticsProvider");
        List listW = o9.o.w(o9.o.t(o9.m.c(o9.o.s(o9.o.k(kotlin.collections.d0.a0(n9.o.u(0, cardJsonStringArray.length())), new tl(cardJsonStringArray)), new ul(cardJsonStringArray)).iterator()), new wl(cardAnalyticsProvider, cardKeyProvider, brazeManager, this, cardJsonStringArray)));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listW) {
            if (((Card) obj).isExpired()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        s sVar = new s(arrayList, arrayList2);
        List<Card> list = (List) sVar.a();
        List list2 = (List) sVar.b();
        for (Card card : list) {
            kotlin.jvm.internal.t.i(card, "card");
            String cardId = card.getId();
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new im(cardId), 7, (Object) null);
            a(cardId, (JSONObject) null);
            kotlin.jvm.internal.t.i(cardId, "cardId");
            this.f3270g.add(cardId);
            qa0 qa0Var = qa0.f3696a;
            kotlinx.coroutines.k.d(qa0Var, null, null, new gm(this, null), 3, null);
            kotlin.jvm.internal.t.i(cardId, "cardId");
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new mm(cardId), 6, (Object) null);
            LinkedHashSet linkedHashSet = this.f3269f;
            linkedHashSet.remove(cardId);
            kotlinx.coroutines.k.d(qa0Var, null, null, new nm(this, linkedHashSet, null), 3, null);
        }
        return new ContentCardsUpdatedEvent(list2, this.f3264a, this.f3273j.getLong("last_storage_update_timestamp", 0L), z10);
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsClicked(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        a(cardId, CardKey.CLICKED);
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsDismissed(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        kotlin.jvm.internal.t.i(cardId, "cardId");
        this.f3268e.add(cardId);
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new fm(this, null), 3, null);
        a(cardId, (JSONObject) null);
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsViewed(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        a(cardId, CardKey.VIEWED);
    }

    @Override // com.braze.storage.ICardStorageProvider
    public final void markCardAsVisuallyRead(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        a(cardId, CardKey.READ);
    }

    public kn(Context context, String userId, String apiKey, h00 brazeManager, String currentSdkVersion) throws NoSuchAlgorithmException {
        Collection collectionF0;
        Collection collectionF02;
        Collection collectionF03;
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(userId, "userId");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(currentSdkVersion, "currentSdkVersion");
        this.f3264a = userId;
        this.f3265b = brazeManager;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f3268e = linkedHashSet;
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        this.f3269f = linkedHashSet2;
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        this.f3270g = linkedHashSet3;
        this.f3271h = new LinkedHashMap();
        String cacheFileSuffix = StringUtils.getCacheFileSuffix(context, userId, apiKey);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.content_cards_storage_provider.cards" + cacheFileSuffix, 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…ix, Context.MODE_PRIVATE)");
        this.f3272i = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.storage.content_cards_storage_provider.metadata" + cacheFileSuffix, 0);
        kotlin.jvm.internal.t.h(sharedPreferences2, "context.getSharedPrefere…ix, Context.MODE_PRIVATE)");
        this.f3273j = sharedPreferences2;
        this.f3274k = new cm();
        Map<String, ?> all = sharedPreferences.getAll();
        kotlin.jvm.internal.t.g(all, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        this.f3271h = kotlin.jvm.internal.t0.d(all);
        Set<String> stringSet = sharedPreferences2.getStringSet("dismissed", new HashSet());
        linkedHashSet.addAll((stringSet == null || (collectionF03 = kotlin.collections.d0.f0(stringSet)) == null) ? z0.e() : collectionF03);
        Set<String> stringSet2 = sharedPreferences2.getStringSet("expired", new HashSet());
        linkedHashSet3.addAll((stringSet2 == null || (collectionF02 = kotlin.collections.d0.f0(stringSet2)) == null) ? z0.e() : collectionF02);
        Set<String> stringSet3 = sharedPreferences2.getStringSet("test", new HashSet());
        linkedHashSet2.addAll((stringSet3 == null || (collectionF0 = kotlin.collections.d0.f0(stringSet3)) == null) ? z0.e() : collectionF0);
        String string = sharedPreferences2.getString("last_accessed_sdk_version", "");
        if (!kotlin.jvm.internal.t.d(currentSdkVersion, string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new em(string, currentSdkVersion), 6, (Object) null);
            sharedPreferences2.edit().putLong("last_full_sync_at", 0L).putString("last_accessed_sdk_version", currentSdkVersion).apply();
        }
        this.f3266c = sharedPreferences2.getLong("last_card_updated_at", 0L);
        this.f3267d = sharedPreferences2.getLong("last_full_sync_at", 0L);
    }

    public final JSONObject a(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        String str = (String) this.f3271h.get(cardId);
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new jm(cardId), 7, (Object) null);
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new km(str), 4, (Object) null);
            return null;
        }
    }

    public final void a(String cardId, CardKey cardKey) {
        Boolean value = Boolean.TRUE;
        kotlin.jvm.internal.t.i(cardId, "cardId");
        kotlin.jvm.internal.t.i(cardKey, "cardKey");
        kotlin.jvm.internal.t.i(value, "value");
        JSONObject jSONObjectA = a(cardId);
        if (jSONObjectA == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new an(cardId), 7, (Object) null);
            return;
        }
        try {
            jSONObjectA.put(cardKey.getContentCardsKey(), value);
            a(cardId, jSONObjectA);
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new bn(cardKey), 4, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.braze.events.ContentCardsUpdatedEvent a(bo.app.dm r22, java.lang.String r23) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 911
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.kn.a(bo.app.dm, java.lang.String):com.braze.events.ContentCardsUpdatedEvent");
    }

    public final void a(String cardId, JSONObject jSONObject) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        if (jSONObject == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new hn(cardId), 7, (Object) null);
            this.f3271h.remove(cardId);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new in(cardId), 7, (Object) null);
            Map map = this.f3271h;
            String string = jSONObject.toString();
            kotlin.jvm.internal.t.h(string, "cardJson.toString()");
            map.put(cardId, string);
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new jn(this, jSONObject, cardId, null), 3, null);
    }
}
