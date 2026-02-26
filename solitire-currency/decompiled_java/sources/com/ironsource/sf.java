package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f15311a = new HashMap<>();

    public sf a(String str, Object obj) {
        if (obj != null) {
            this.f15311a.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }

    public HashMap<String, Object> a() {
        return this.f15311a;
    }
}
