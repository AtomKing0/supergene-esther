package com.applovin.impl;

import androidx.arch.core.util.Function;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7617b = new Object();

    public v4(JSONObject jSONObject) {
        this.f7616a = jSONObject;
    }

    public JSONObject a() {
        JSONObject jSONObjectDeepCopy;
        synchronized (this.f7617b) {
            jSONObjectDeepCopy = JsonUtils.deepCopy(this.f7616a);
        }
        return jSONObjectDeepCopy;
    }

    public List b(String str, List list) {
        List<String> stringList;
        synchronized (this.f7617b) {
            stringList = JsonUtils.getStringList(this.f7616a, str, list);
        }
        return stringList;
    }

    public void c(String str) {
        synchronized (this.f7617b) {
            this.f7616a.remove(str);
        }
    }

    public String toString() {
        String string;
        synchronized (this.f7617b) {
            string = this.f7616a.toString();
        }
        return string;
    }

    public boolean a(String str) {
        boolean zHas;
        synchronized (this.f7617b) {
            zHas = this.f7616a.has(str);
        }
        return zHas;
    }

    public Object b(String str) {
        Object objOpt;
        synchronized (this.f7617b) {
            objOpt = this.f7616a.opt(str);
        }
        return objOpt;
    }

    public void a(Consumer consumer) {
        synchronized (this.f7617b) {
            consumer.accept(this);
        }
    }

    public void b(String str, int i10) {
        synchronized (this.f7617b) {
            JsonUtils.putInt(this.f7616a, str, i10);
        }
    }

    public Object a(Function function) {
        Object objApply;
        synchronized (this.f7617b) {
            objApply = function.apply(this);
        }
        return objApply;
    }

    public void b(String str, long j10) {
        synchronized (this.f7617b) {
            JsonUtils.putLong(this.f7616a, str, j10);
        }
    }

    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f7617b) {
            bool2 = JsonUtils.getBoolean(this.f7616a, str, bool);
        }
        return bool2;
    }

    public void b(String str, String str2) {
        synchronized (this.f7617b) {
            JsonUtils.putString(this.f7616a, str, str2);
        }
    }

    public float a(String str, float f10) {
        float f11;
        synchronized (this.f7617b) {
            f11 = JsonUtils.getFloat(this.f7616a, str, f10);
        }
        return f11;
    }

    public int a(String str, int i10) {
        int i11;
        synchronized (this.f7617b) {
            i11 = JsonUtils.getInt(this.f7616a, str, i10);
        }
        return i11;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f7617b) {
            jSONArray2 = JsonUtils.getJSONArray(this.f7616a, str, jSONArray);
        }
        return jSONArray2;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.f7617b) {
            jSONObject2 = JsonUtils.getJSONObject(this.f7616a, str, jSONObject);
        }
        return jSONObject2;
    }

    public long a(String str, long j10) {
        long j11;
        synchronized (this.f7617b) {
            j11 = JsonUtils.getLong(this.f7616a, str, j10);
        }
        return j11;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.f7617b) {
            string = JsonUtils.getString(this.f7616a, str, str2);
        }
        return string;
    }

    public List a(String str, List list) {
        List<Integer> integerList;
        synchronized (this.f7617b) {
            integerList = JsonUtils.getIntegerList(this.f7616a, str, list);
        }
        return integerList;
    }

    public void a(String str, boolean z10) {
        synchronized (this.f7617b) {
            JsonUtils.putBoolean(this.f7616a, str, z10);
        }
    }

    public void a(String str, Object obj) {
        synchronized (this.f7617b) {
            JsonUtils.putObject(this.f7616a, str, obj);
        }
    }
}
