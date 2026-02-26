package com.braze.models.inappmessage;

import bo.app.ba;
import bo.app.e00;
import bo.app.f20;
import bo.app.g20;
import bo.app.h00;
import bo.app.h20;
import bo.app.h9;
import bo.app.i20;
import bo.app.tf;
import bo.app.z9;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import h9.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageControl extends InAppMessageBase {
    private final AtomicBoolean controlImpressionLogged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageControl(JSONObject jsonObject, h00 brazeManager) {
        super(jsonObject, brazeManager, false, false, 12, null);
        t.i(jsonObject, "jsonObject");
        t.i(brazeManager, "brazeManager");
        this.controlImpressionLogged = new AtomicBoolean(false);
    }

    @Override // com.braze.models.inappmessage.IInAppMessage
    public MessageType getMessageType() {
        return MessageType.CONTROL;
    }

    @Override // com.braze.models.inappmessage.InAppMessageBase, com.braze.models.inappmessage.IInAppMessage
    public boolean logImpression() {
        e00 e00VarA;
        if (this.controlImpressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) f20.f2763a, 6, (Object) null);
            return false;
        }
        String triggerId = getTriggerId();
        if (triggerId == null || triggerId.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) g20.f2855a, 6, (Object) null);
            return false;
        }
        if (getBrazeManager() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) h20.f2945a, 6, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) i20.f3015a, 6, (Object) null);
        String triggerId2 = getTriggerId();
        if (triggerId2 != null) {
            z9 z9Var = ba.f2429g;
            String messageExtras = getMessageExtras();
            z9Var.getClass();
            t.i(triggerId2, "triggerId");
            e00VarA = z9Var.a(new h9(triggerId2, messageExtras));
        } else {
            e00VarA = null;
        }
        if (e00VarA != null) {
            h00 brazeManager = getBrazeManager();
            if (brazeManager != null) {
                ((tf) brazeManager).a(e00VarA);
            }
            this.controlImpressionLogged.set(true);
        }
        return true;
    }
}
