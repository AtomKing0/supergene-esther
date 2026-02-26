package com.braze.models.inappmessage;

import bo.app.h00;
import bo.app.j20;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.JsonUtils;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageHtml extends InAppMessageHtmlBase {
    public static final j20 Companion = new j20();
    private List<String> assetUrls;
    private JSONObject messageFields;
    private Map<String, String> remotePathToLocalAssetMap;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessageHtml(JSONObject jsonObject, h00 brazeManager) {
        this(jsonObject, brazeManager, jsonObject.optJSONObject("message_fields"), JsonUtils.convertStringJsonArrayToList(jsonObject.optJSONArray("asset_urls")));
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
    }

    public Map<String, String> getLocalPrefetchedAssetPaths() {
        return this.remotePathToLocalAssetMap;
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public MessageType getMessageType() {
        return MessageType.HTML;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public List<String> getRemoteAssetPathsForPrefetch() {
        return this.assetUrls;
    }

    public final boolean isPushPrimer() {
        JSONObject jSONObject = this.messageFields;
        return jSONObject != null && jSONObject.optBoolean("is_push_primer", false);
    }

    @Override // com.braze.models.inappmessage.InAppMessageHtmlBase, com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public void setLocalPrefetchedAssetPaths(Map<String, String> remotePathToLocalAssetMap) {
        t.i(remotePathToLocalAssetMap, "remotePathToLocalAssetMap");
        this.remotePathToLocalAssetMap = remotePathToLocalAssetMap;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.IPutIntoJson
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

    private InAppMessageHtml(JSONObject jSONObject, h00 h00Var, JSONObject jSONObject2, List<String> list) {
        super(jSONObject, h00Var);
        this.remotePathToLocalAssetMap = r0.g();
        v.l();
        this.messageFields = jSONObject2;
        this.assetUrls = list;
    }

    public InAppMessageHtml() {
        this.remotePathToLocalAssetMap = r0.g();
        this.assetUrls = v.l();
        this.messageFields = new JSONObject();
        this.assetUrls = v.l();
    }
}
