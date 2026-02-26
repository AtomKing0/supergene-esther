package com.king.amp.sa;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AdProviderNameValuePairs {

    @NonNull
    private final Map<String, Object> mParameters = new HashMap();

    public void add(String str, Object obj) {
        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String[])) {
            this.mParameters.put(str, obj);
            return;
        }
        throw new RuntimeException("Unsupported type for marshaling: " + obj.getClass().getName());
    }

    public void clear() {
        this.mParameters.clear();
    }

    public String getKeyAtIndex(int i10) {
        for (Map.Entry<String, Object> entry : this.mParameters.entrySet()) {
            if (i10 == 0) {
                return entry.getKey();
            }
            i10--;
        }
        return null;
    }

    public int getNumEntries() {
        return this.mParameters.size();
    }

    public Object getValue(String str) {
        return this.mParameters.get(str);
    }

    public Boolean isEmpty() {
        return Boolean.valueOf(this.mParameters.isEmpty());
    }

    public Object getValue(String str, Object obj) {
        Object obj2 = this.mParameters.get(str);
        return obj2 != null ? obj2 : obj;
    }
}
