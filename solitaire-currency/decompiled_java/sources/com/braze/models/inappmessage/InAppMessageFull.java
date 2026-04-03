package com.braze.models.inappmessage;

import bo.app.h00;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.MessageType;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageFull extends InAppMessageImmersiveBase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageFull(JSONObject jsonObject, h00 brazeManager) {
        String upperCase;
        int i10;
        super(jsonObject, brazeManager);
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
        CropType cropType = CropType.CENTER_CROP;
        try {
            String string = jsonObject.getString("crop_type");
            t.h(string, "jsonObject.getString(key)");
            Locale US = Locale.US;
            t.h(US, "US");
            upperCase = string.toUpperCase(US);
            t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        } catch (Exception unused) {
        }
        for (CropType cropType2 : CropType.values()) {
            if (t.d(cropType2.name(), upperCase)) {
                cropType = cropType2;
                setCropType(cropType);
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public MessageType getMessageType() {
        return MessageType.FULL;
    }

    @Override // com.braze.models.inappmessage.InAppMessageImmersiveBase, com.braze.models.inappmessage.InAppMessageBase, com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject jSONObjectForJsonPut = super.forJsonPut();
        try {
            jSONObjectForJsonPut.put("type", getMessageType().name());
        } catch (JSONException unused) {
        }
        return jSONObjectForJsonPut;
    }

    public InAppMessageFull() {
        setCropType(CropType.CENTER_CROP);
    }
}
