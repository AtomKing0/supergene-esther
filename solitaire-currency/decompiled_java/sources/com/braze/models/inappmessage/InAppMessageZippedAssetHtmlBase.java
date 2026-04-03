package com.braze.models.inappmessage;

import bo.app.h00;
import bo.app.s30;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageZippedAssetHtmlBase extends InAppMessageHtmlBase implements IInAppMessageZippedAssetHtml {
    public static final s30 Companion = new s30();
    private String assetsZipRemoteUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageZippedAssetHtmlBase(JSONObject jsonObject, h00 brazeManager) {
        super(jsonObject, brazeManager);
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
        String it = jsonObject.optString("zipped_assets_url");
        t.h(it, "it");
        if (!q.z(it)) {
            setAssetsZipRemoteUrl(it);
        }
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject jSONObjectForJsonPut = super.forJsonPut();
        try {
            jSONObjectForJsonPut.putOpt("zipped_assets_url", getAssetsZipRemoteUrl());
        } catch (JSONException unused) {
        }
        return jSONObjectForJsonPut;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageZippedAssetHtml
    public String getAssetsZipRemoteUrl() {
        return this.assetsZipRemoteUrl;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public List<String> getRemoteAssetPathsForPrefetch() {
        ArrayList arrayList = new ArrayList();
        String assetsZipRemoteUrl = getAssetsZipRemoteUrl();
        if (assetsZipRemoteUrl != null && (!q.z(assetsZipRemoteUrl))) {
            arrayList.add(assetsZipRemoteUrl);
        }
        return arrayList;
    }

    public void setAssetsZipRemoteUrl(String str) {
        this.assetsZipRemoteUrl = str;
    }

    public InAppMessageZippedAssetHtmlBase() {
    }
}
