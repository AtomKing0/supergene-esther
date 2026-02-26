package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f16373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final String f16374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f16377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final List<Integer> f16378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final List<Integer> f16379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<Integer> f16380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final List<Integer> f16381m;

    public z3(@NotNull JSONObject applicationEvents) {
        kotlin.jvm.internal.t.i(applicationEvents, "applicationEvents");
        this.f16369a = applicationEvents.optBoolean(b4.f11344a, false);
        this.f16370b = applicationEvents.optBoolean(b4.f11345b, false);
        this.f16371c = applicationEvents.optBoolean(b4.f11346c, false);
        this.f16372d = applicationEvents.optInt(b4.f11347d, -1);
        String strOptString = applicationEvents.optString(b4.f11348e);
        kotlin.jvm.internal.t.h(strOptString, "applicationEvents.optStr…(SERVER_EVENTS_URL_FIELD)");
        this.f16373e = strOptString;
        String strOptString2 = applicationEvents.optString(b4.f11349f);
        kotlin.jvm.internal.t.h(strOptString2, "applicationEvents.optString(SERVER_EVENTS_TYPE)");
        this.f16374f = strOptString2;
        this.f16375g = applicationEvents.optInt(b4.f11350g, -1);
        this.f16376h = applicationEvents.optInt(b4.f11351h, -1);
        this.f16377i = applicationEvents.optInt(b4.f11352i, 5000);
        this.f16378j = a(applicationEvents, b4.f11353j);
        this.f16379k = a(applicationEvents, b4.f11354k);
        this.f16380l = a(applicationEvents, b4.f11355l);
        this.f16381m = a(applicationEvents, b4.f11356m);
    }

    public final int a() {
        return this.f16375g;
    }

    public final boolean b() {
        return this.f16371c;
    }

    public final int c() {
        return this.f16372d;
    }

    @NotNull
    public final String d() {
        return this.f16374f;
    }

    public final int e() {
        return this.f16377i;
    }

    public final int f() {
        return this.f16376h;
    }

    @NotNull
    public final List<Integer> g() {
        return this.f16381m;
    }

    @NotNull
    public final List<Integer> h() {
        return this.f16379k;
    }

    @NotNull
    public final List<Integer> i() {
        return this.f16378j;
    }

    public final boolean j() {
        return this.f16370b;
    }

    public final boolean k() {
        return this.f16369a;
    }

    @NotNull
    public final String l() {
        return this.f16373e;
    }

    @NotNull
    public final List<Integer> m() {
        return this.f16380l;
    }

    private final List<Integer> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return kotlin.collections.v.l();
        }
        n9.i iVarU = n9.o.u(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(iVarU, 10));
        Iterator<Integer> it = iVarU.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(((kotlin.collections.l0) it).nextInt())));
        }
        return arrayList;
    }
}
