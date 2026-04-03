package com.braze.support;

import bo.app.a30;
import bo.app.g30;
import bo.app.h00;
import bo.app.w20;
import bo.app.x20;
import bo.app.y20;
import bo.app.z20;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageControl;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.models.inappmessage.InAppMessageHtmlFull;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.support.BrazeLogger;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8123a = BrazeLogger.INSTANCE.getBrazeLogTag("InAppMessageModelUtils");

    public static final InAppMessageBase a(JSONObject inAppMessageJson, h00 brazeManager) {
        InAppMessageBase inAppMessageFull;
        String upperCase;
        t.i(inAppMessageJson, "inAppMessageJson");
        t.i(brazeManager, "brazeManager");
        try {
            t.i(inAppMessageJson, "inAppMessageJson");
            if (inAppMessageJson.optBoolean("is_control", false)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f8123a, BrazeLogger.Priority.D, (Throwable) null, false, (h9.a) x20.f4237a, 12, (Object) null);
                return new InAppMessageControl(inAppMessageJson, brazeManager);
            }
            try {
                String string = inAppMessageJson.getString("type");
                t.h(string, "jsonObject.getString(key)");
                Locale US = Locale.US;
                t.h(US, "US");
                upperCase = string.toUpperCase(US);
                t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            } catch (Exception unused) {
                messageType = null;
            }
            for (MessageType messageType : MessageType.values()) {
                if (t.d(messageType.name(), upperCase)) {
                    if (messageType == null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f8123a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new y20(inAppMessageJson), 12, (Object) null);
                        return null;
                    }
                    int i10 = w20.f4163a[messageType.ordinal()];
                    if (i10 == 1) {
                        inAppMessageFull = new InAppMessageFull(inAppMessageJson, brazeManager);
                    } else if (i10 == 2) {
                        inAppMessageFull = new InAppMessageModal(inAppMessageJson, brazeManager);
                    } else if (i10 == 3) {
                        inAppMessageFull = new InAppMessageSlideup(inAppMessageJson, brazeManager);
                    } else if (i10 == 4) {
                        inAppMessageFull = new InAppMessageHtmlFull(inAppMessageJson, brazeManager);
                    } else {
                        if (i10 != 5) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f8123a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new z20(inAppMessageJson), 12, (Object) null);
                            return null;
                        }
                        inAppMessageFull = new InAppMessageHtml(inAppMessageJson, brazeManager);
                    }
                    return inAppMessageFull;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f8123a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new a30(inAppMessageJson), 8, (Object) null);
            return null;
        }
    }

    public static final JSONArray b(JSONObject inAppMessageJson) {
        JSONObject jSONObjectOptJSONObject;
        t.i(inAppMessageJson, "inAppMessageJson");
        JSONObject jSONObjectOptJSONObject2 = inAppMessageJson.optJSONObject("themes");
        JSONArray jSONArrayOptJSONArray = (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("dark")) == null) ? null : jSONObjectOptJSONObject.optJSONArray("btns");
        return jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
    }

    public static final g30 a(JSONObject inAppMessageJson) {
        t.i(inAppMessageJson, "inAppMessageJson");
        JSONObject jSONObjectOptJSONObject = inAppMessageJson.optJSONObject("themes");
        JSONObject messageThemeJson = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("dark") : null;
        if (messageThemeJson == null) {
            return null;
        }
        t.i(messageThemeJson, "messageThemeJson");
        return new g30(JsonUtils.getColorIntegerOrNull(messageThemeJson, "bg_color"), JsonUtils.getColorIntegerOrNull(messageThemeJson, NotificationSchedulerKeys.KEY_TEXT_COLOR), JsonUtils.getColorIntegerOrNull(messageThemeJson, "close_btn_color"), JsonUtils.getColorIntegerOrNull(messageThemeJson, "icon_color"), JsonUtils.getColorIntegerOrNull(messageThemeJson, "icon_bg_color"), JsonUtils.getColorIntegerOrNull(messageThemeJson, "header_text_color"), JsonUtils.getColorIntegerOrNull(messageThemeJson, "frame_color"));
    }
}
