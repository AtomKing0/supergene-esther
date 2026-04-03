package com.moloco.sdk.internal;

import com.moloco.sdk.publisher.MediationInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    public static final void a(@NotNull e8.l lVar, @Nullable String str, @Nullable String str2, @Nullable MediationInfo mediationInfo) {
        kotlin.jvm.internal.t.i(lVar, "<this>");
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("MolocoSDK/" + str + ';');
        }
        if (mediationInfo != null) {
            sb.append("Mediator/" + mediationInfo.getName() + ';');
        }
        if (str2 != null) {
            sb.append("Android/" + str2 + ';');
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply {\n…$it;\") }\n    }.toString()");
        lVar.f("X-Moloco-User-Agent", string);
    }

    public static /* synthetic */ void b(e8.l lVar, String str, String str2, MediationInfo mediationInfo, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            mediationInfo = null;
        }
        a(lVar, str, str2, mediationInfo);
    }
}
