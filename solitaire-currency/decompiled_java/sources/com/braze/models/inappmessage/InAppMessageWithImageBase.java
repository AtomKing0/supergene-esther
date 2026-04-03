package com.braze.models.inappmessage;

import android.graphics.Bitmap;
import bo.app.h00;
import bo.app.r30;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageWithImageBase extends InAppMessageBase implements IInAppMessageWithImage {
    public static final r30 Companion = new r30();
    private Bitmap bitmap;
    private boolean imageDownloadSuccessful;
    private String localImageUrl;
    private String remoteImageUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageWithImageBase(JSONObject jsonObject, h00 brazeManager) {
        super(jsonObject, brazeManager, false, false, 12, null);
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
        setRemoteImageUrl(jsonObject.optString("image_url"));
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return jsonObject;
        }
        JSONObject jSONObjectForJsonPut = super.forJsonPut();
        try {
            jSONObjectForJsonPut.putOpt("image_url", getRemoteImageUrl());
        } catch (JSONException unused) {
        }
        return jSONObjectForJsonPut;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageWithImage
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public boolean getImageDownloadSuccessful() {
        return this.imageDownloadSuccessful;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageWithImage
    public String getLocalImageUrl() {
        return this.localImageUrl;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public List<String> getRemoteAssetPathsForPrefetch() {
        ArrayList arrayList = new ArrayList();
        String remoteImageUrl = getRemoteImageUrl();
        if (remoteImageUrl != null && (!q.z(remoteImageUrl))) {
            arrayList.add(remoteImageUrl);
        }
        return arrayList;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageWithImage
    public String getRemoteImageUrl() {
        return this.remoteImageUrl;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageWithImage
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageWithImage
    public void setImageDownloadSuccessful(boolean z10) {
        this.imageDownloadSuccessful = z10;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageWithImage
    public void setLocalImageUrl(String str) {
        this.localImageUrl = str;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public void setLocalPrefetchedAssetPaths(Map<String, String> remotePathToLocalAssetMap) {
        t.i(remotePathToLocalAssetMap, "remotePathToLocalAssetMap");
        if (!remotePathToLocalAssetMap.isEmpty()) {
            setLocalImageUrl(((String[]) remotePathToLocalAssetMap.values().toArray(new String[0]))[0]);
        }
    }

    public void setRemoteImageUrl(String str) {
        this.remoteImageUrl = str;
    }

    public InAppMessageWithImageBase() {
    }
}
