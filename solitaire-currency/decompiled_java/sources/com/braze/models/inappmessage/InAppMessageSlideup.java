package com.braze.models.inappmessage;

import android.graphics.Color;
import bo.app.e30;
import bo.app.f30;
import bo.app.g30;
import bo.app.h00;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import h9.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class InAppMessageSlideup extends InAppMessageWithImageBase {
    public static final Companion Companion = new Companion(null);
    private int chevronColor;
    private SlideFrom slideFrom;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessageSlideup(JSONObject jsonObject, h00 brazeManager) {
        this(jsonObject, brazeManager, (SlideFrom) JsonUtils.optEnum(jsonObject, "slide_from", SlideFrom.class, SlideFrom.BOTTOM), jsonObject.optInt("close_btn_color"));
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessageThemeable
    public void enableDarkTheme() {
        Integer num;
        super.enableDarkTheme();
        g30 inAppMessageDarkThemeWrapper = getInAppMessageDarkThemeWrapper();
        if (inAppMessageDarkThemeWrapper == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (a) e30.f2701a, 6, (Object) null);
            return;
        }
        Integer num2 = inAppMessageDarkThemeWrapper.f2860c;
        if ((num2 != null && num2.intValue() == -1) || (num = inAppMessageDarkThemeWrapper.f2860c) == null) {
            return;
        }
        this.chevronColor = num.intValue();
    }

    public final int getChevronColor() {
        return this.chevronColor;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public MessageType getMessageType() {
        return MessageType.SLIDEUP;
    }

    public final SlideFrom getSlideFrom() {
        return this.slideFrom;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject jSONObjectForJsonPut = super.forJsonPut();
        try {
            jSONObjectForJsonPut.put("slide_from", this.slideFrom.toString());
            jSONObjectForJsonPut.put("close_btn_color", this.chevronColor);
            jSONObjectForJsonPut.put("type", getMessageType().name());
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) f30.f2765a, 4, (Object) null);
        }
        return jSONObjectForJsonPut;
    }

    private InAppMessageSlideup(JSONObject jSONObject, h00 h00Var, SlideFrom slideFrom, int i10) {
        super(jSONObject, h00Var);
        this.slideFrom = SlideFrom.BOTTOM;
        this.chevronColor = Color.parseColor("#9B9B9B");
        if (slideFrom != null) {
            this.slideFrom = slideFrom;
        }
        this.chevronColor = i10;
        setCropType((CropType) JsonUtils.optEnum(jSONObject, "crop_type", CropType.class, CropType.FIT_CENTER));
        setMessageTextAlign((TextAlign) JsonUtils.optEnum(jSONObject, "text_align_message", TextAlign.class, TextAlign.START));
    }

    public InAppMessageSlideup() {
        this.slideFrom = SlideFrom.BOTTOM;
        this.chevronColor = Color.parseColor("#9B9B9B");
        setMessageTextAlign(TextAlign.START);
    }
}
