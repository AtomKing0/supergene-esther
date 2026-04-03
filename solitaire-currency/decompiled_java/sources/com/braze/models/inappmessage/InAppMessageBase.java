package com.braze.models.inappmessage;

import android.graphics.Color;
import android.net.Uri;
import bo.app.a20;
import bo.app.b20;
import bo.app.g30;
import bo.app.h00;
import bo.app.m10;
import bo.app.o10;
import bo.app.p10;
import bo.app.q10;
import bo.app.qa0;
import bo.app.r10;
import bo.app.s10;
import bo.app.t10;
import bo.app.u10;
import bo.app.w10;
import bo.app.x10;
import bo.app.y10;
import bo.app.z10;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.j;
import com.ironsource.v8;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import h9.a;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.r0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageBase implements IInAppMessage, IInAppMessageThemeable {
    public static final m10 Companion = new m10();
    private boolean animateIn;
    private boolean animateOut;
    private int backgroundColor;
    private h00 brazeManager;
    private final AtomicBoolean clickLogged;
    private CropType cropType;
    private DismissType dismissType;
    private int durationInMilliseconds;
    private long expirationTimestamp;
    private Map<String, String> extras;
    private String icon;
    private int iconBackgroundColor;
    private int iconColor;
    private final AtomicBoolean impressionLogged;
    private g30 inAppMessageDarkThemeWrapper;
    private ClickAction internalClickAction;
    private Uri internalUri;
    private boolean isTestSend;
    private JSONObject jsonObject;
    private String message;
    private String messageExtras;
    private TextAlign messageTextAlign;
    private int messageTextColor;
    private boolean openUriInWebView;
    private Orientation orientation;

    public InAppMessageBase(JSONObject json, h00 brazeManager, boolean z10, boolean z11) throws JSONException {
        String upperCase;
        String upperCase2;
        int i10;
        String upperCase3;
        int i11;
        t.i(json, "json");
        t.i(brazeManager, "brazeManager");
        this.internalClickAction = ClickAction.NONE;
        this.extras = r0.g();
        this.animateIn = true;
        this.animateOut = true;
        this.dismissType = DismissType.AUTO_DISMISS;
        this.durationInMilliseconds = 5000;
        Orientation orientation = Orientation.ANY;
        this.orientation = orientation;
        this.cropType = CropType.FIT_CENTER;
        this.messageTextAlign = TextAlign.CENTER;
        this.expirationTimestamp = -1L;
        this.iconBackgroundColor = Color.parseColor("#ff0073d5");
        this.messageTextColor = Color.parseColor("#555555");
        this.backgroundColor = -1;
        this.iconColor = -1;
        this.impressionLogged = new AtomicBoolean(false);
        this.clickLogged = new AtomicBoolean(false);
        this.jsonObject = json;
        this.brazeManager = brazeManager;
        setMessage(json.optString("message"));
        setAnimateIn(json.optBoolean("animate_in", true));
        setAnimateOut(json.optBoolean("animate_out", true));
        setDurationInMilliseconds(json.optInt("duration"));
        setIcon(json.optString(v8.h.H0));
        try {
            String string = json.getString("orientation");
            t.h(string, "jsonObject.getString(key)");
            Locale US = Locale.US;
            t.h(US, "US");
            upperCase3 = string.toUpperCase(US);
            t.h(upperCase3, "this as java.lang.String).toUpperCase(locale)");
        } catch (Exception unused) {
        }
        for (Orientation orientation2 : Orientation.values()) {
            if (t.d(orientation2.name(), upperCase3)) {
                orientation = orientation2;
                setOrientation(orientation);
                setOpenUriInWebView(json.optBoolean("use_webview", false));
                setIconBackgroundColor(json.optInt("icon_bg_color"));
                setMessageTextColor(json.optInt(NotificationSchedulerKeys.KEY_TEXT_COLOR));
                setBackgroundColor(json.optInt("bg_color"));
                setIconColor(json.optInt("icon_color"));
                this.impressionLogged.set(z10);
                this.clickLogged.set(z11);
                setExtras(JsonUtils.convertJSONObjectToMap(json.optJSONObject("extras")));
                if (json.has("message_extras")) {
                    setMessageExtras(json.optString("message_extras"));
                }
                String strOptString = json.optString("uri");
                ClickAction clickAction = ClickAction.NONE;
                try {
                    String string2 = json.getString("click_action");
                    t.h(string2, "jsonObject.getString(key)");
                    Locale US2 = Locale.US;
                    t.h(US2, "US");
                    upperCase2 = string2.toUpperCase(US2);
                    t.h(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                } catch (Exception unused2) {
                }
                for (ClickAction clickAction2 : ClickAction.values()) {
                    if (t.d(clickAction2.name(), upperCase2)) {
                        clickAction = clickAction2;
                        if (clickAction == ClickAction.URI && strOptString != null && !q.z(strOptString)) {
                            this.internalUri = Uri.parse(strOptString);
                        }
                        this.internalClickAction = clickAction;
                        DismissType dismissType = DismissType.AUTO_DISMISS;
                        try {
                            String string3 = json.getString("message_close");
                            t.h(string3, "jsonObject.getString(key)");
                            Locale US3 = Locale.US;
                            t.h(US3, "US");
                            upperCase = string3.toUpperCase(US3);
                            t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
                        } catch (Exception unused3) {
                        }
                        for (DismissType dismissType2 : DismissType.values()) {
                            if (t.d(dismissType2.name(), upperCase)) {
                                dismissType = dismissType2;
                                setDismissType(dismissType == DismissType.SWIPE ? DismissType.MANUAL : dismissType);
                                this.inAppMessageDarkThemeWrapper = j.a(json);
                                json.put("is_test_send", isTestSend());
                                return;
                            }
                        }
                        throw new NoSuchElementException("Array contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // com.braze.models.inappmessage.IInAppMessageThemeable
    public void enableDarkTheme() {
        g30 g30Var = this.inAppMessageDarkThemeWrapper;
        if (g30Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) q10.f3675a, 7, (Object) null);
            return;
        }
        Integer num = g30Var.f2858a;
        if (num != null) {
            setBackgroundColor(num.intValue());
        }
        Integer num2 = g30Var.f2861d;
        if (num2 != null) {
            setIconColor(num2.intValue());
        }
        Integer num3 = g30Var.f2862e;
        if (num3 != null) {
            setIconBackgroundColor(num3.intValue());
        }
        Integer num4 = g30Var.f2859b;
        if (num4 != null) {
            setMessageTextColor(num4.intValue());
        }
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public boolean getAnimateIn() {
        return this.animateIn;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public boolean getAnimateOut() {
        return this.animateOut;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final h00 getBrazeManager() {
        return this.brazeManager;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public ClickAction getClickAction() {
        return this.internalClickAction;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public CropType getCropType() {
        return this.cropType;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public DismissType getDismissType() {
        return this.dismissType;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public int getDurationInMilliseconds() {
        return this.durationInMilliseconds;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public Map<String, String> getExtras() {
        return this.extras;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public String getIcon() {
        return this.icon;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public int getIconBackgroundColor() {
        return this.iconBackgroundColor;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public int getIconColor() {
        return this.iconColor;
    }

    public final g30 getInAppMessageDarkThemeWrapper() {
        return this.inAppMessageDarkThemeWrapper;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public String getMessage() {
        return this.message;
    }

    public String getMessageExtras() {
        return this.messageExtras;
    }

    public TextAlign getMessageTextAlign() {
        return this.messageTextAlign;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public int getMessageTextColor() {
        return this.messageTextColor;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public boolean getOpenUriInWebView() {
        return this.openUriInWebView;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public List<String> getRemoteAssetPathsForPrefetch() {
        return v.l();
    }

    public final String getTriggerId() {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject != null) {
            return jSONObject.optString("trigger_id");
        }
        return null;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public Uri getUri() {
        return this.internalUri;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public boolean isControl() {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject != null && jSONObject.optBoolean("is_control");
    }

    public boolean isTestSend() {
        return this.isTestSend;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public boolean logClick() {
        String triggerId = getTriggerId();
        if (triggerId == null || q.z(triggerId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) s10.f3815a, 7, (Object) null);
            return false;
        }
        h00 h00Var = this.brazeManager;
        if (h00Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) t10.f3886a, 6, (Object) null);
            return false;
        }
        if (getMessageType() != MessageType.HTML && this.clickLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) u10.f3980a, 6, (Object) null);
            return false;
        }
        this.clickLogged.set(true);
        k.d(qa0.f3696a, null, null, new w10(triggerId, h00Var, null), 3, null);
        return true;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public boolean logImpression() {
        String triggerId = getTriggerId();
        if (triggerId == null || q.z(triggerId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (a) x10.f4236a, 6, (Object) null);
            return false;
        }
        h00 h00Var = this.brazeManager;
        if (h00Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) y10.f4315a, 6, (Object) null);
            return false;
        }
        if (this.impressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) z10.f4389a, 6, (Object) null);
            return false;
        }
        this.impressionLogged.set(true);
        k.d(qa0.f3696a, null, null, new a20(triggerId, this, h00Var, null), 3, null);
        return true;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void onAfterClosed() {
        String triggerId = getTriggerId();
        if (triggerId == null || triggerId.length() == 0) {
            return;
        }
        k.d(qa0.f3696a, null, null, new b20(this, null), 3, null);
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void setAnimateIn(boolean z10) {
        this.animateIn = z10;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void setAnimateOut(boolean z10) {
        this.animateOut = z10;
    }

    public void setBackgroundColor(int i10) {
        this.backgroundColor = i10;
    }

    public void setCropType(CropType cropType) {
        t.i(cropType, "<set-?>");
        this.cropType = cropType;
    }

    public void setDismissType(DismissType dismissType) {
        t.i(dismissType, "<set-?>");
        this.dismissType = dismissType;
    }

    public void setDurationInMilliseconds(int i10) {
        if (i10 < 999) {
            this.durationInMilliseconds = 5000;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new o10(i10), 7, (Object) null);
        } else {
            this.durationInMilliseconds = i10;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new p10(i10), 7, (Object) null);
        }
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void setExpirationTimestamp(long j10) {
        this.expirationTimestamp = j10;
    }

    public void setExtras(Map<String, String> map) {
        t.i(map, "<set-?>");
        this.extras = map;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconBackgroundColor(int i10) {
        this.iconBackgroundColor = i10;
    }

    public void setIconColor(int i10) {
        this.iconColor = i10;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void setLocalPrefetchedAssetPaths(Map<String, String> remotePathToLocalAssetMap) {
        t.i(remotePathToLocalAssetMap, "remotePathToLocalAssetMap");
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageExtras(String str) {
        this.messageExtras = str;
    }

    public void setMessageTextAlign(TextAlign textAlign) {
        t.i(textAlign, "<set-?>");
        this.messageTextAlign = textAlign;
    }

    public void setMessageTextColor(int i10) {
        this.messageTextColor = i10;
    }

    public void setOpenUriInWebView(boolean z10) {
        this.openUriInWebView = z10;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void setOrientation(Orientation orientation) {
        t.i(orientation, "<set-?>");
        this.orientation = orientation;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public void setTestSend(boolean z10) {
        this.isTestSend = z10;
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("message", getMessage());
            jSONObject2.put("duration", getDurationInMilliseconds());
            jSONObject2.putOpt("trigger_id", getTriggerId());
            jSONObject2.putOpt("click_action", getClickAction().toString());
            jSONObject2.putOpt("message_close", getDismissType().toString());
            if (getUri() != null) {
                jSONObject2.put("uri", String.valueOf(getUri()));
            }
            jSONObject2.put("use_webview", getOpenUriInWebView());
            jSONObject2.put("animate_in", getAnimateIn());
            jSONObject2.put("animate_out", getAnimateOut());
            jSONObject2.put("bg_color", getBackgroundColor());
            jSONObject2.put(NotificationSchedulerKeys.KEY_TEXT_COLOR, getMessageTextColor());
            jSONObject2.put("icon_color", getIconColor());
            jSONObject2.put("icon_bg_color", getIconBackgroundColor());
            jSONObject2.putOpt(v8.h.H0, getIcon());
            jSONObject2.putOpt("crop_type", getCropType().toString());
            jSONObject2.putOpt("orientation", getOrientation().toString());
            jSONObject2.putOpt("text_align_message", getMessageTextAlign().toString());
            jSONObject2.putOpt("is_control", Boolean.valueOf(isControl()));
            jSONObject2.put("is_test_send", isTestSend());
            if (!getExtras().isEmpty()) {
                jSONObject2.put("extras", getExtras());
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) r10.f3741a, 4, (Object) null);
        }
        return jSONObject2;
    }

    public /* synthetic */ InAppMessageBase(JSONObject jSONObject, h00 h00Var, boolean z10, boolean z11, int i10, kotlin.jvm.internal.k kVar) {
        this(jSONObject, h00Var, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11);
    }

    public InAppMessageBase() {
        this.internalClickAction = ClickAction.NONE;
        this.extras = r0.g();
        this.animateIn = true;
        this.animateOut = true;
        this.dismissType = DismissType.AUTO_DISMISS;
        this.durationInMilliseconds = 5000;
        this.orientation = Orientation.ANY;
        this.cropType = CropType.FIT_CENTER;
        this.messageTextAlign = TextAlign.CENTER;
        this.expirationTimestamp = -1L;
        this.iconBackgroundColor = Color.parseColor("#ff0073d5");
        this.messageTextColor = Color.parseColor("#555555");
        this.backgroundColor = -1;
        this.iconColor = -1;
        this.impressionLogged = new AtomicBoolean(false);
        this.clickLogged = new AtomicBoolean(false);
    }
}
