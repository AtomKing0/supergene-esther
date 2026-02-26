package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import bo.app.q40;
import bo.app.r40;
import bo.app.u40;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import h9.a;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public class MessageButton implements IPutIntoJson<JSONObject>, IInAppMessageThemeable {
    public static final q40 Companion = new q40();
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) MessageButton.class);
    private int backgroundColor;
    private int borderColor;
    private ClickAction clickAction;
    private u40 darkTheme;
    private int id;
    private JSONObject jsonObject;
    private boolean openUriInWebview;
    private String text;
    private int textColor;
    private Uri uri;

    public MessageButton() {
        this.id = -1;
        this.clickAction = ClickAction.NONE;
        int color = Color.parseColor("#1B78CF");
        this.backgroundColor = color;
        this.textColor = -1;
        this.borderColor = color;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageThemeable
    public void enableDarkTheme() {
        u40 u40Var = this.darkTheme;
        if (u40Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (a) r40.f3746a, 14, (Object) null);
            return;
        }
        Integer num = u40Var.f3987a;
        if (num != null) {
            this.backgroundColor = num.intValue();
        }
        Integer num2 = u40Var.f3988b;
        if (num2 != null) {
            this.textColor = num2.intValue();
        }
        Integer num3 = u40Var.f3989c;
        if (num3 != null) {
            this.borderColor = num3.intValue();
        }
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final ClickAction getClickAction() {
        return this.clickAction;
    }

    public final boolean getOpenUriInWebview() {
        return this.openUriInWebview;
    }

    public final String getStringId() {
        return String.valueOf(this.id);
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.id);
            jSONObject.put("click_action", this.clickAction.toString());
            Uri uri = this.uri;
            if (uri != null) {
                jSONObject.put("uri", String.valueOf(uri));
            }
            jSONObject.putOpt("text", this.text);
            jSONObject.put("bg_color", this.backgroundColor);
            jSONObject.put(NotificationSchedulerKeys.KEY_TEXT_COLOR, this.textColor);
            jSONObject.put("use_webview", this.openUriInWebview);
            jSONObject.put("border_color", this.borderColor);
            return jSONObject;
        } catch (JSONException unused) {
            return this.jsonObject;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MessageButton(JSONObject jsonObject, JSONObject jSONObject) {
        ClickAction clickAction;
        String upperCase;
        int i10;
        t.i(jsonObject, "jsonObject");
        int iOptInt = jsonObject.optInt("id", -1);
        ClickAction clickAction2 = ClickAction.NEWS_FEED;
        try {
            String string = jsonObject.getString("click_action");
            t.h(string, "jsonObject.getString(key)");
            Locale US = Locale.US;
            t.h(US, "US");
            upperCase = string.toUpperCase(US);
            t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        } catch (Exception unused) {
            clickAction = clickAction2;
        }
        for (ClickAction clickAction3 : ClickAction.values()) {
            if (t.d(clickAction3.name(), upperCase)) {
                clickAction = clickAction3;
                String strOptString = jsonObject.optString("uri");
                String strOptString2 = jsonObject.optString("text");
                t.h(strOptString2, "jsonObject.optString(TEXT)");
                this(jsonObject, jSONObject, iOptInt, clickAction, strOptString, strOptString2, jsonObject.optInt("bg_color"), jsonObject.optInt(NotificationSchedulerKeys.KEY_TEXT_COLOR), jsonObject.optBoolean("use_webview", false), jsonObject.optInt("border_color"));
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private MessageButton(JSONObject jSONObject, JSONObject jSONObject2, int i10, ClickAction clickAction, String str, String str2, int i11, int i12, boolean z10, int i13) {
        this.id = -1;
        this.clickAction = ClickAction.NONE;
        int color = Color.parseColor("#1B78CF");
        this.backgroundColor = color;
        this.textColor = -1;
        this.borderColor = color;
        this.jsonObject = jSONObject;
        this.id = i10;
        this.clickAction = clickAction;
        if (clickAction == ClickAction.URI && str != null && !q.z(str)) {
            this.uri = Uri.parse(str);
        }
        this.text = str2;
        this.backgroundColor = i11;
        this.textColor = i12;
        this.openUriInWebview = z10;
        this.borderColor = i13;
        this.darkTheme = jSONObject2 != null ? new u40(jSONObject2) : null;
    }
}
