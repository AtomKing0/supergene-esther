package bo.app;

import android.content.Context;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q30 extends dh0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InAppMessageBase f3681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f3682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h00 f3683i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q30(JSONObject json, h00 brazeManager) throws JSONException {
        super(json);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new h30(json), 6, (Object) null);
        JSONObject inAppMessageObject = json.getJSONObject("data");
        this.f3683i = brazeManager;
        this.f3682h = inAppMessageObject;
        kotlin.jvm.internal.t.h(inAppMessageObject, "inAppMessageObject");
        InAppMessageBase inAppMessageBaseA = com.braze.support.j.a(inAppMessageObject, brazeManager);
        this.f3681g = inAppMessageBaseA;
        if (inAppMessageBaseA != null) {
            return;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) i30.f3017a, 6, (Object) null);
        throw new IllegalArgumentException("Failed to parse in-app message triggered action with JSON: " + JsonUtils.getPrettyPrintedString(json));
    }

    @Override // bo.app.k10
    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        InAppMessageBase inAppMessageBase = this.f3681g;
        List<String> remoteAssetPathsForPrefetch = inAppMessageBase != null ? inAppMessageBase.getRemoteAssetPathsForPrefetch() : null;
        if (remoteAssetPathsForPrefetch == null || remoteAssetPathsForPrefetch.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) o30.f3539a, 7, (Object) null);
            return arrayList;
        }
        InAppMessageBase inAppMessageBase2 = this.f3681g;
        MessageType messageType = inAppMessageBase2 != null ? inAppMessageBase2.getMessageType() : null;
        int i10 = messageType == null ? -1 : j30.f3114a[messageType.ordinal()];
        if (i10 == 1) {
            arrayList.add(new s70(t70.ZIP, remoteAssetPathsForPrefetch.get(0)));
        } else if (i10 == 2 || i10 == 3 || i10 == 4) {
            arrayList.add(new s70(t70.IMAGE, remoteAssetPathsForPrefetch.get(0)));
        } else if (i10 != 5) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new p30(this), 6, (Object) null);
        } else {
            Iterator<String> it = remoteAssetPathsForPrefetch.iterator();
            while (it.hasNext()) {
                arrayList.add(new s70(t70.FILE, it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        try {
            JSONObject jSONObjectB = super.b();
            if (jSONObjectB == null) {
                return null;
            }
            InAppMessageBase inAppMessageBase = this.f3681g;
            jSONObjectB.put("data", inAppMessageBase != null ? inAppMessageBase.forJsonPut() : null);
            jSONObjectB.put("type", "inapp");
            return jSONObjectB;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // bo.app.k10
    public final void a(Context context, v00 internalEventPublisher, g10 triggerEvent, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new k30(this), 7, (Object) null);
            JSONObject jSONObject = this.f3682h;
            if (jSONObject == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new l30(triggerEvent), 6, (Object) null);
                return;
            }
            InAppMessageBase inAppMessageBaseA = com.braze.support.j.a(jSONObject, this.f3683i);
            String strA = triggerEvent.a();
            int i10 = od0.f3558g;
            if (kotlin.jvm.internal.t.d(strA, "test")) {
                if (inAppMessageBaseA != null) {
                    inAppMessageBaseA.setTestSend(true);
                }
                this.f3682h.put("is_test_send", true);
            }
            if (inAppMessageBaseA == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new m30(triggerEvent), 6, (Object) null);
                return;
            }
            inAppMessageBaseA.setLocalPrefetchedAssetPaths(kotlin.collections.r0.u(this.f2657f));
            inAppMessageBaseA.setExpirationTimestamp(j10);
            ((vw) internalEventPublisher).b(d30.class, new d30(triggerEvent, this, inAppMessageBaseA, ((tf) this.f3683i).f3920b));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) n30.f3463a, 4, (Object) null);
        }
    }
}
