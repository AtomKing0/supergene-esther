package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final vi f12119a;

    public fd(@NotNull vi globalDataWriter) {
        kotlin.jvm.internal.t.i(globalDataWriter, "globalDataWriter");
        this.f12119a = globalDataWriter;
    }

    public final void a(@NotNull JSONObject metaDataJson) {
        kotlin.jvm.internal.t.i(metaDataJson, "metaDataJson");
        if (metaDataJson.has(com.ironsource.mediationsdk.metadata.a.f13690i)) {
            try {
                Object objRemove = metaDataJson.remove(com.ironsource.mediationsdk.metadata.a.f13690i);
                kotlin.jvm.internal.t.g(objRemove, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                ArrayList arrayList = (ArrayList) objRemove;
                if (!arrayList.isEmpty()) {
                    Object obj = arrayList.get(0);
                    kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f12119a.d((String) obj);
                }
            } catch (ClassCastException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error("got the following error " + e10.getMessage());
            }
        }
    }
}
