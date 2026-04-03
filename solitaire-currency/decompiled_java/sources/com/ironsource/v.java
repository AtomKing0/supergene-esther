package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements wr<JSONObject>, ur<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, a2> f15630a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15631b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15632a;

        static {
            int[] iArr = new int[tr.values().length];
            try {
                iArr[tr.LoadRequest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[tr.LoadSuccess.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[tr.ShowSuccess.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[tr.ShowFailed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[tr.Destroyed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f15632a = iArr;
        }
    }

    public final int a() {
        return this.f15631b;
    }

    @Override // com.ironsource.od
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(@NotNull vr mode) throws JSONException {
        kotlin.jvm.internal.t.i(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, a2> entry : this.f15630a.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObjectA = entry.getValue().a(mode);
            if (jSONObjectA.length() > 0) {
                jSONObject.put(key, jSONObjectA);
            }
        }
        return jSONObject;
    }

    private final void b(t tVar) {
        int i10;
        int i11;
        int i12 = a.f15632a[tVar.f().ordinal()];
        if (i12 == 2) {
            i10 = this.f15631b + 1;
        } else if ((i12 != 3 && i12 != 4 && i12 != 5) || (i11 = this.f15631b) <= 0) {
            return;
        } else {
            i10 = i11 - 1;
        }
        this.f15631b = i10;
    }

    @Override // com.ironsource.ur
    public void a(@NotNull t record) {
        kotlin.jvm.internal.t.i(record, "record");
        String strC = record.c();
        Map<String, a2> map = this.f15630a;
        a2 a2Var = map.get(strC);
        if (a2Var == null) {
            a2Var = new a2();
            map.put(strC, a2Var);
        }
        a2Var.a(record.a(new u()));
        b(record);
    }

    public final boolean b() {
        return !this.f15630a.isEmpty();
    }
}
