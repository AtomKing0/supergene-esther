package bo.app;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.braze.models.IPutIntoJson;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public enum lx implements IPutIntoJson {
    LOCATION_RECORDED("lr"),
    CUSTOM_EVENT("ce"),
    PURCHASE(TtmlNode.TAG_P),
    PUSH_STORY_PAGE_CLICK("cic"),
    PUSH_CLICKED("pc"),
    PUSH_ACTION_BUTTON_CLICKED(OTCCPAGeolocationConstants.CA),
    INTERNAL(CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT),
    INTERNAL_ERROR("ie"),
    NEWS_FEED_CARD_IMPRESSION("ci"),
    NEWS_FEED_CARD_CLICK("cc"),
    GEOFENCE("g"),
    CONTENT_CARDS_CLICK("ccc"),
    CONTENT_CARDS_IMPRESSION("cci"),
    CONTENT_CARDS_CONTROL_IMPRESSION("ccic"),
    CONTENT_CARDS_DISMISS("ccd"),
    INCREMENT("inc"),
    ADD_TO_CUSTOM_ATTRIBUTE_ARRAY("add"),
    REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY("rem"),
    SET_CUSTOM_ATTRIBUTE_ARRAY("set"),
    INAPP_MESSAGE_IMPRESSION("si"),
    INAPP_MESSAGE_CONTROL_IMPRESSION("iec"),
    INAPP_MESSAGE_CLICK("sc"),
    INAPP_MESSAGE_BUTTON_CLICK("sbc"),
    /* JADX INFO: Fake field, exist only in values array */
    TEST_TYPE("message_extras"),
    USER_ALIAS("uae"),
    SESSION_START("ss"),
    SESSION_END("se"),
    /* JADX INFO: Fake field, exist only in values array */
    TEST_TYPE(TtmlNode.TAG_TT),
    LOCATION_CUSTOM_ATTRIBUTE_ADD("lcaa"),
    LOCATION_CUSTOM_ATTRIBUTE_REMOVE("lcar"),
    NESTED_CUSTOM_ATTRIBUTE_MERGE("ncam"),
    SUBSCRIPTION_GROUP_UPDATE("sgu"),
    FEATURE_FLAG_IMPRESSION_EVENT("ffi"),
    PUSH_DELIVERY_EVENT("pde"),
    UNKNOWN("");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f3353b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3378a;

    static {
        lx[] lxVarArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(lxVarArrValues.length), 16));
        for (lx lxVar : lxVarArrValues) {
            linkedHashMap.put(lxVar.f3378a, lxVar);
        }
        f3353b = linkedHashMap;
    }

    lx(String str) {
        this.f3378a = str;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        return this.f3378a;
    }
}
