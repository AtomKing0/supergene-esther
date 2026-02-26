package com.braze.models.inappmessage;

import android.graphics.Color;
import bo.app.ba;
import bo.app.e00;
import bo.app.e20;
import bo.app.f9;
import bo.app.g30;
import bo.app.h00;
import bo.app.p20;
import bo.app.q20;
import bo.app.r20;
import bo.app.s20;
import bo.app.t20;
import bo.app.tf;
import bo.app.u20;
import bo.app.v20;
import bo.app.vw;
import bo.app.xe0;
import bo.app.z9;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.j;
import h9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.collections.d0;
import kotlin.collections.i0;
import kotlin.collections.v;
import kotlin.collections.y;
import kotlin.jvm.internal.t;
import o9.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageImmersiveBase extends InAppMessageWithImageBase implements IInAppMessageImmersive {
    public static final p20 Companion = new p20();
    private String buttonIdClicked;
    private int closeButtonColor;
    private Integer frameColor;
    private String header;
    private TextAlign headerTextAlign;
    private int headerTextColor;
    private ImageStyle imageStyle;
    private List<? extends MessageButton> messageButtons;
    private boolean wasButtonClickLogged;

    /* JADX WARN: Illegal instructions before constructor call */
    public InAppMessageImmersiveBase(JSONObject jsonObject, h00 brazeManager) {
        String upperCase;
        int i10;
        String upperCase2;
        int i11;
        String upperCase3;
        int i12;
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
        String strOptString = jsonObject.optString("header");
        t.h(strOptString, "jsonObject.optString(HEADER)");
        int iOptInt = jsonObject.optInt("header_text_color");
        int iOptInt2 = jsonObject.optInt("close_btn_color");
        ImageStyle imageStyle = ImageStyle.TOP;
        try {
            String string = jsonObject.getString("image_style");
            t.h(string, "jsonObject.getString(key)");
            Locale US = Locale.US;
            t.h(US, "US");
            upperCase3 = string.toUpperCase(US);
            t.h(upperCase3, "this as java.lang.String).toUpperCase(locale)");
        } catch (Exception unused) {
            imageStyle = imageStyle;
        }
        for (ImageStyle imageStyle2 : ImageStyle.values()) {
            if (t.d(imageStyle2.name(), upperCase3)) {
                TextAlign textAlign = TextAlign.CENTER;
                try {
                    String string2 = jsonObject.getString("text_align_header");
                    t.h(string2, "jsonObject.getString(key)");
                    Locale US2 = Locale.US;
                    t.h(US2, "US");
                    upperCase2 = string2.toUpperCase(US2);
                    t.h(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                } catch (Exception unused2) {
                    textAlign = textAlign;
                }
                for (TextAlign textAlign2 : TextAlign.values()) {
                    if (t.d(textAlign2.name(), upperCase2)) {
                        TextAlign textAlign3 = TextAlign.CENTER;
                        try {
                            String string3 = jsonObject.getString("text_align_message");
                            t.h(string3, "jsonObject.getString(key)");
                            Locale US3 = Locale.US;
                            t.h(US3, "US");
                            upperCase = string3.toUpperCase(US3);
                            t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
                        } catch (Exception unused3) {
                        }
                        for (TextAlign textAlign4 : TextAlign.values()) {
                            if (t.d(textAlign4.name(), upperCase)) {
                                textAlign3 = textAlign4;
                                this(jsonObject, brazeManager, strOptString, iOptInt, iOptInt2, imageStyle2, textAlign2, textAlign3);
                                JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("btns");
                                JSONArray jSONArrayB = j.b(jsonObject);
                                ArrayList arrayList = new ArrayList();
                                Iterator itY = y.y(jSONArrayOptJSONArray == null ? v.l().iterator() : o.s(o.k(d0.a0(n9.o.u(0, jSONArrayOptJSONArray.length())), new u20(jSONArrayOptJSONArray)), new v20(jSONArrayOptJSONArray)).iterator());
                                while (itY.hasNext()) {
                                    i0 i0Var = (i0) itY.next();
                                    arrayList.add(new MessageButton((JSONObject) i0Var.b(), jSONArrayB.optJSONObject(i0Var.a())));
                                }
                                setMessageButtons(arrayList);
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

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessageThemeable
    public void enableDarkTheme() {
        super.enableDarkTheme();
        g30 inAppMessageDarkThemeWrapper = getInAppMessageDarkThemeWrapper();
        if (inAppMessageDarkThemeWrapper == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) q20.f3679a, 7, (Object) null);
            return;
        }
        Integer num = inAppMessageDarkThemeWrapper.f2864g;
        if (num != null) {
            setFrameColor(num);
        }
        Integer num2 = inAppMessageDarkThemeWrapper.f2860c;
        if (num2 != null) {
            setCloseButtonColor(num2.intValue());
        }
        Integer num3 = inAppMessageDarkThemeWrapper.f2863f;
        if (num3 != null) {
            setHeaderTextColor(num3.intValue());
        }
        Iterator<MessageButton> it = getMessageButtons().iterator();
        while (it.hasNext()) {
            it.next().enableDarkTheme();
        }
    }

    public int getCloseButtonColor() {
        return this.closeButtonColor;
    }

    public Integer getFrameColor() {
        return this.frameColor;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageImmersive
    public String getHeader() {
        return this.header;
    }

    public TextAlign getHeaderTextAlign() {
        return this.headerTextAlign;
    }

    public int getHeaderTextColor() {
        return this.headerTextColor;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageImmersive
    public ImageStyle getImageStyle() {
        return this.imageStyle;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageImmersive
    public List<MessageButton> getMessageButtons() {
        return this.messageButtons;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageImmersive
    public boolean logButtonClick(MessageButton messageButton) {
        t.i(messageButton, "messageButton");
        h00 brazeManager = getBrazeManager();
        String triggerId = getTriggerId();
        if (triggerId == null || q.z(triggerId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) r20.f3743a, 7, (Object) null);
            return false;
        }
        if (this.wasButtonClickLogged) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) s20.f3817a, 6, (Object) null);
            return false;
        }
        if (brazeManager == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) t20.f3888a, 6, (Object) null);
            return false;
        }
        this.buttonIdClicked = messageButton.getStringId();
        z9 z9Var = ba.f2429g;
        z9Var.getClass();
        t.i(triggerId, "triggerId");
        t.i(messageButton, "messageButton");
        e00 e00VarA = z9Var.a(new f9(triggerId, messageButton));
        if (e00VarA != null) {
            ((tf) brazeManager).a(e00VarA);
        }
        this.wasButtonClickLogged = true;
        return true;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public void onAfterClosed() {
        String triggerId;
        String str;
        super.onAfterClosed();
        h00 brazeManager = getBrazeManager();
        if (!this.wasButtonClickLogged || (triggerId = getTriggerId()) == null || q.z(triggerId) || (str = this.buttonIdClicked) == null || q.z(str) || brazeManager == null) {
            return;
        }
        String triggerId2 = getTriggerId();
        String str2 = this.buttonIdClicked;
        e20 triggerEvent = new e20(triggerId2);
        triggerEvent.f2699f = str2;
        t.i(triggerEvent, "triggerEvent");
        ((vw) ((tf) brazeManager).f3922d).b(xe0.class, new xe0(triggerEvent));
    }

    public void setCloseButtonColor(int i10) {
        this.closeButtonColor = i10;
    }

    public void setFrameColor(Integer num) {
        this.frameColor = num;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setHeaderTextAlign(TextAlign textAlign) {
        t.i(textAlign, "<set-?>");
        this.headerTextAlign = textAlign;
    }

    public void setHeaderTextColor(int i10) {
        this.headerTextColor = i10;
    }

    public void setImageStyle(ImageStyle imageStyle) {
        t.i(imageStyle, "<set-?>");
        this.imageStyle = imageStyle;
    }

    public void setMessageButtons(List<? extends MessageButton> list) {
        t.i(list, "<set-?>");
        this.messageButtons = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject jSONObjectForJsonPut = super.forJsonPut();
        try {
            jSONObjectForJsonPut.putOpt("header", getHeader());
            jSONObjectForJsonPut.put("header_text_color", getHeaderTextColor());
            jSONObjectForJsonPut.put("close_btn_color", getCloseButtonColor());
            jSONObjectForJsonPut.putOpt("image_style", getImageStyle().toString());
            jSONObjectForJsonPut.putOpt("text_align_header", getHeaderTextAlign().toString());
            Integer frameColor = getFrameColor();
            if (frameColor != null) {
                jSONObjectForJsonPut.put("frame_color", frameColor.intValue());
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<MessageButton> it = getMessageButtons().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().forJsonPut());
            }
            jSONObjectForJsonPut.put("btns", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObjectForJsonPut;
    }

    private InAppMessageImmersiveBase(JSONObject jSONObject, h00 h00Var, String str, int i10, int i11, ImageStyle imageStyle, TextAlign textAlign, TextAlign textAlign2) {
        super(jSONObject, h00Var);
        this.headerTextColor = Color.parseColor("#333333");
        this.closeButtonColor = Color.parseColor("#9B9B9B");
        this.messageButtons = v.l();
        this.imageStyle = ImageStyle.TOP;
        this.headerTextAlign = TextAlign.CENTER;
        setHeader(str);
        setHeaderTextColor(i10);
        setCloseButtonColor(i11);
        if (jSONObject.has("frame_color")) {
            setFrameColor(Integer.valueOf(jSONObject.optInt("frame_color")));
        }
        setImageStyle(imageStyle);
        setHeaderTextAlign(textAlign);
        setMessageTextAlign(textAlign2);
    }

    public InAppMessageImmersiveBase() {
        this.headerTextColor = Color.parseColor("#333333");
        this.closeButtonColor = Color.parseColor("#9B9B9B");
        this.messageButtons = v.l();
        this.imageStyle = ImageStyle.TOP;
        this.headerTextAlign = TextAlign.CENTER;
    }
}
