package com.onetrust.otpublishers.headless.UI.UIProperty;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f22772a;

    public g(@NonNull Context context) {
        this.f22772a = new JSONObject();
        String string = new com.onetrust.otpublishers.headless.Internal.Preferences.c(context).c().getString("OTT_UX_PARAMS_JSON", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        this.f22772a = new JSONObject(string);
    }

    @NonNull
    public static f a(@NonNull JSONObject jSONObject) {
        f fVar = new f();
        fVar.f22758a = c(jSONObject);
        if (jSONObject.has("backgroundColor")) {
            fVar.f22759b = jSONObject.getString("backgroundColor");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            fVar.f22760c = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_COLOR)) {
            fVar.f22761d = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_WIDTH)) {
            fVar.f22762e = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_WIDTH);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_RADIUS)) {
            fVar.f22763f = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_RADIUS);
        }
        return fVar;
    }

    @NonNull
    public static l c(@NonNull JSONObject jSONObject) {
        l lVar = new l();
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_NAME)) {
            lVar.f22782a = jSONObject.getString(OTUXParamsKeys.OT_UX_FONT_NAME);
        }
        if (jSONObject.has("fontSize")) {
            lVar.f22783b = jSONObject.getString("fontSize");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_TEXT_STYLE)) {
            lVar.f22784c = jSONObject.getInt(OTUXParamsKeys.OT_UX_FONT_TEXT_STYLE);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_TYPE_FACE_KEY)) {
            lVar.f22785d = jSONObject.getString(OTUXParamsKeys.OT_UX_FONT_TYPE_FACE_KEY);
        }
        return lVar;
    }

    @NonNull
    public static o e(@NonNull JSONObject jSONObject) {
        o oVar = new o();
        oVar.f22787a = g(jSONObject);
        return oVar;
    }

    @NonNull
    public static a f(@NonNull JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject.has("backgroundColor")) {
            aVar.f22695a = jSONObject.getString("backgroundColor");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            aVar.f22696b = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_PLACEHOLDER_TEXT_COLOR)) {
            aVar.f22697c = jSONObject.getString(OTUXParamsKeys.OT_UX_PLACEHOLDER_TEXT_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_ICON_COLOR)) {
            aVar.f22698d = jSONObject.getString(OTUXParamsKeys.OT_UX_ICON_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_CLEAR_BUTTON_COLOR)) {
            aVar.f22700f = jSONObject.getString(OTUXParamsKeys.OT_UX_CLEAR_BUTTON_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_COLOR)) {
            aVar.f22699e = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_COLOR);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_WIDTH)) {
            aVar.f22701g = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_WIDTH);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_RADIUS)) {
            aVar.f22702h = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_RADIUS);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_FONT_TYPE_FACE_KEY)) {
            aVar.f22704j.f22720a.f22785d = jSONObject.getString(OTUXParamsKeys.OT_UX_FONT_TYPE_FACE_KEY);
        }
        return aVar;
    }

    @NonNull
    public static c g(@NonNull JSONObject jSONObject) {
        c cVar = new c();
        cVar.f22720a = c(jSONObject);
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_ALIGNMENT)) {
            cVar.f22721b = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_ALIGNMENT);
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            cVar.f22722c = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        return cVar;
    }

    @Nullable
    public final JSONObject b() {
        if (this.f22772a.has(OTUXParamsKeys.OT_UI_CONFIG)) {
            return this.f22772a.getJSONObject(OTUXParamsKeys.OT_UI_CONFIG);
        }
        return null;
    }

    @Nullable
    public final v d() {
        JSONObject jSONObjectB = b();
        v vVar = null;
        JSONObject jSONObject = (jSONObjectB == null || !jSONObjectB.has(OTUXParamsKeys.OT_GLOBAL_THEME)) ? null : jSONObjectB.getJSONObject(OTUXParamsKeys.OT_GLOBAL_THEME);
        if (jSONObject != null) {
            vVar = new v();
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINK_UNDERLINE)) {
                vVar.f22831a = jSONObject.getBoolean(OTUXParamsKeys.OT_UX_LINK_UNDERLINE);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINK_COLOR)) {
                vVar.f22832b = jSONObject.getString(OTUXParamsKeys.OT_UX_LINK_COLOR);
            }
        }
        return vVar;
    }
}
