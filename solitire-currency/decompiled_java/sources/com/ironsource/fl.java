package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class fl {
    public final void a(@Nullable Map<String, String> map, boolean z10) {
        if (z10 && TextUtils.isEmpty(com.ironsource.mediationsdk.p.m().q())) {
            if (map == null || map.isEmpty()) {
                return;
            }
            for (String str : map.keySet()) {
                if (IronSourceUtils.doesClassExist(str)) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    com.ironsource.mediationsdk.p.m().h(str);
                    return;
                }
            }
        }
    }
}
