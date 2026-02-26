package bo.app;

import com.braze.enums.CardKey;
import com.braze.enums.CardType;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.models.cards.ControlCard;
import com.braze.models.cards.ImageOnlyCard;
import com.braze.models.cards.ShortNewsCard;
import com.braze.models.cards.TextAnnouncementCard;
import com.braze.storage.ICardStorageProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xl f4289a = new xl();

    public static final Card a(JSONObject jsonObject, CardKey.Provider cardKeyProvider, h00 brazeManager, ICardStorageProvider cardStorageProvider, m00 cardAnalyticsProvider) {
        Card imageOnlyCard;
        kotlin.jvm.internal.t.i(jsonObject, "jsonObject");
        kotlin.jvm.internal.t.i(cardKeyProvider, "cardKeyProvider");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(cardStorageProvider, "cardStorageProvider");
        kotlin.jvm.internal.t.i(cardAnalyticsProvider, "cardAnalyticsProvider");
        CardType cardTypeFromJson = cardKeyProvider.getCardTypeFromJson(jsonObject);
        int i10 = cardTypeFromJson == null ? -1 : sl.f3867a[cardTypeFromJson.ordinal()];
        if (i10 == 1) {
            imageOnlyCard = new ImageOnlyCard(jsonObject, cardKeyProvider, brazeManager, cardStorageProvider, cardAnalyticsProvider);
        } else if (i10 == 2) {
            imageOnlyCard = new CaptionedImageCard(jsonObject, cardKeyProvider, brazeManager, cardStorageProvider, cardAnalyticsProvider);
        } else if (i10 == 3) {
            imageOnlyCard = new ShortNewsCard(jsonObject, cardKeyProvider, brazeManager, cardStorageProvider, cardAnalyticsProvider);
        } else if (i10 == 4) {
            imageOnlyCard = new TextAnnouncementCard(jsonObject, cardKeyProvider, brazeManager, cardStorageProvider, cardAnalyticsProvider);
        } else {
            if (i10 != 5) {
                return null;
            }
            imageOnlyCard = new ControlCard(jsonObject, cardKeyProvider, brazeManager, cardStorageProvider, cardAnalyticsProvider);
        }
        return imageOnlyCard;
    }
}
