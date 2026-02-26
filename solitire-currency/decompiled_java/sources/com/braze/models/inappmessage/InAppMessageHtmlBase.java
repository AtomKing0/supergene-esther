package com.braze.models.inappmessage;

import bo.app.ba;
import bo.app.e00;
import bo.app.e20;
import bo.app.e9;
import bo.app.h00;
import bo.app.k20;
import bo.app.l20;
import bo.app.m20;
import bo.app.n20;
import bo.app.o20;
import bo.app.tf;
import bo.app.vw;
import bo.app.xe0;
import bo.app.z9;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import h9.a;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageHtmlBase extends InAppMessageBase implements IInAppMessageHtml {
    private String buttonIdClicked;
    private String localAssetsDirectoryUrl;
    private boolean wasButtonClickLogged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageHtmlBase(JSONObject jsonObject, h00 brazeManager) {
        super(jsonObject, brazeManager, false, false, 12, null);
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
        setOpenUriInWebView(jsonObject.optBoolean("use_webview", true));
    }

    @Override // com.braze.models.inappmessage.IInAppMessageHtml
    public String getLocalAssetsDirectoryUrl() {
        return this.localAssetsDirectoryUrl;
    }

    @Override // com.braze.models.inappmessage.IInAppMessageHtml
    public boolean logButtonClick(String buttonId) {
        t.i(buttonId, "buttonId");
        String triggerId = getTriggerId();
        h00 brazeManager = getBrazeManager();
        if (triggerId == null || triggerId.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new k20(buttonId), 7, (Object) null);
            return false;
        }
        if (q.z(buttonId)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) l20.f3295a, 6, (Object) null);
            return false;
        }
        if (this.wasButtonClickLogged && getMessageType() != MessageType.HTML) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) m20.f3384a, 6, (Object) null);
            return false;
        }
        if (brazeManager == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) n20.f3461a, 6, (Object) null);
            return false;
        }
        z9 z9Var = ba.f2429g;
        z9Var.getClass();
        t.i(triggerId, "triggerId");
        t.i(buttonId, "buttonId");
        e00 e00VarA = z9Var.a(new e9(triggerId, buttonId));
        if (e00VarA != null) {
            ((tf) brazeManager).a(e00VarA);
        }
        this.buttonIdClicked = buttonId;
        this.wasButtonClickLogged = true;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new o20(buttonId, triggerId), 7, (Object) null);
        return true;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public void onAfterClosed() {
        String triggerId;
        String str;
        h00 brazeManager;
        super.onAfterClosed();
        if (!this.wasButtonClickLogged || (triggerId = getTriggerId()) == null || q.z(triggerId) || (str = this.buttonIdClicked) == null || q.z(str) || (brazeManager = getBrazeManager()) == null) {
            return;
        }
        String triggerId2 = getTriggerId();
        String str2 = this.buttonIdClicked;
        e20 triggerEvent = new e20(triggerId2);
        triggerEvent.f2699f = str2;
        t.i(triggerEvent, "triggerEvent");
        ((vw) ((tf) brazeManager).f3922d).b(xe0.class, new xe0(triggerEvent));
    }

    @Override // com.braze.models.inappmessage.IInAppMessageHtml
    public void setLocalAssetsDirectoryUrl(String str) {
        this.localAssetsDirectoryUrl = str;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public void setLocalPrefetchedAssetPaths(Map<String, String> remotePathToLocalAssetMap) {
        t.i(remotePathToLocalAssetMap, "remotePathToLocalAssetMap");
        if (!remotePathToLocalAssetMap.isEmpty()) {
            setLocalAssetsDirectoryUrl(((String[]) remotePathToLocalAssetMap.values().toArray(new String[0]))[0]);
        }
    }

    public InAppMessageHtmlBase() {
        setOpenUriInWebView(true);
    }
}
