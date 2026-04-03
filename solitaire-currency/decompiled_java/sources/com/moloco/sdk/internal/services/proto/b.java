package com.moloco.sdk.internal.services.proto;

import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class b implements a {
    @Override // com.moloco.sdk.internal.services.proto.a
    @NotNull
    public String a(@NotNull t input, int i10) {
        kotlin.jvm.internal.t.i(input, "input");
        String strEncodeToString = Base64.encodeToString(input.toByteArray(), i10);
        kotlin.jvm.internal.t.h(strEncodeToString, "encodeToString(input.toByteArray(), flags)");
        return strEncodeToString;
    }
}
