package com.braze.enums;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import bo.app.rl;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import v8.y;

/* JADX INFO: loaded from: classes2.dex */
public enum CardKey {
    ID("id", "id"),
    VIEWED("viewed", "v"),
    CREATED("created", OTCCPAGeolocationConstants.CA),
    EXPIRES_AT("expires_at", "ea"),
    EXTRAS("extras", "e"),
    OPEN_URI_IN_WEBVIEW("use_webview", "uw"),
    TYPE("type", "tp"),
    CATEGORIES("categories", ""),
    UPDATED("updated", ""),
    DISMISSED("", "d"),
    REMOVED("", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ),
    PINNED("", TtmlNode.TAG_P),
    DISMISSIBLE("", "db"),
    IS_TEST("", "t"),
    READ("", "read"),
    CLICKED("", "cl"),
    IMAGE_ONLY_IMAGE("image", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT),
    IMAGE_ONLY_URL("url", "u"),
    IMAGE_ONLY_DOMAIN(v8.i.D, ""),
    IMAGE_ONLY_ASPECT_RATIO("aspect_ratio", "ar"),
    CAPTIONED_IMAGE_IMAGE("image", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT),
    CAPTIONED_IMAGE_TITLE("title", TtmlNode.TAG_TT),
    CAPTIONED_IMAGE_DESCRIPTION("description", "ds"),
    CAPTIONED_IMAGE_URL("url", "u"),
    CAPTIONED_IMAGE_DOMAIN(v8.i.D, "dm"),
    CAPTIONED_IMAGE_ASPECT_RATIO("aspect_ratio", "ar"),
    TEXT_ANNOUNCEMENT_TITLE("title", TtmlNode.TAG_TT),
    TEXT_ANNOUNCEMENT_DESCRIPTION("description", "ds"),
    TEXT_ANNOUNCEMENT_URL("url", "u"),
    TEXT_ANNOUNCEMENT_DOMAIN(v8.i.D, "dm"),
    SHORT_NEWS_IMAGE("image", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT),
    SHORT_NEWS_TITLE("title", TtmlNode.TAG_TT),
    SHORT_NEWS_DESCRIPTION("description", "ds"),
    SHORT_NEWS_URL("url", "u"),
    SHORT_NEWS_DOMAIN(v8.i.D, "dm");

    private final String contentCardsKey;
    private final String feedKey;
    public static final rl Companion = new Object() { // from class: bo.app.rl
    };
    private static final Map<String, CardType> cardTypeMap = r0.j(y.a("banner_image", CardType.IMAGE), y.a("captioned_image", CardType.CAPTIONED_IMAGE), y.a("text_announcement", CardType.TEXT_ANNOUNCEMENT), y.a("short_news", CardType.SHORT_NEWS), y.a("control", CardType.CONTROL));

    public static final class Provider {
        private final boolean isContentCardProvider;
        public static final a Companion = new a();
        public static final Provider CONTENT_CARDS = new Provider(true);
        public static final Provider NEWS_FEED = new Provider(false);

        public Provider(boolean z10) {
            this.isContentCardProvider = z10;
        }

        public final CardType getCardTypeFromJson(JSONObject jsonObject) {
            String optionalString;
            t.i(jsonObject, "jsonObject");
            String optionalString2 = JsonUtils.getOptionalString(jsonObject, getKey(CardKey.TYPE));
            if (optionalString2 != null && optionalString2.length() != 0 && this.isContentCardProvider && t.d(optionalString2, "short_news") && ((optionalString = JsonUtils.getOptionalString(jsonObject, getKey(CardKey.SHORT_NEWS_IMAGE))) == null || optionalString.length() == 0)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new b(jsonObject), 6, (Object) null);
                optionalString2 = "text_announcement";
            }
            return CardKey.cardTypeMap.containsKey(optionalString2) ? (CardType) CardKey.cardTypeMap.get(optionalString2) : CardType.DEFAULT;
        }

        public final String getKey(CardKey key) {
            t.i(key, "key");
            return this.isContentCardProvider ? key.getContentCardsKey() : key.getFeedKey();
        }

        public final boolean isContentCardProvider() {
            return this.isContentCardProvider;
        }
    }

    CardKey(String str, String str2) {
        this.feedKey = str;
        this.contentCardsKey = str2;
    }

    public final String getContentCardsKey() {
        return this.contentCardsKey;
    }

    public final String getFeedKey() {
        return this.feedKey;
    }
}
