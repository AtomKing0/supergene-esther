package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b8 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b8 f4910f = new b8();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b8 f4911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f4913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f4914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final List f4915e;

    public b8(String str, Map map, b8 b8Var) {
        this.f4911a = b8Var;
        this.f4912b = str;
        this.f4913c = Collections.unmodifiableMap(map);
        this.f4915e = new ArrayList();
    }

    public Map a() {
        return this.f4913c;
    }

    public List b() {
        return Collections.unmodifiableList(this.f4915e);
    }

    public String c() {
        return this.f4912b;
    }

    public String d() {
        return this.f4914d;
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f4912b + "', text='" + this.f4914d + "', attributes=" + this.f4913c + '}';
    }

    public List a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.f4915e.size());
        for (b8 b8Var : this.f4915e) {
            if (str.equalsIgnoreCase(b8Var.c())) {
                arrayList.add(b8Var);
            }
        }
        return arrayList;
    }

    public b8 b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.f4915e.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        while (!arrayList.isEmpty()) {
            b8 b8Var = (b8) arrayList.get(0);
            arrayList.remove(0);
            if (str.equalsIgnoreCase(b8Var.c())) {
                return b8Var;
            }
            arrayList.addAll(b8Var.b());
        }
        return null;
    }

    public b8 c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (b8 b8Var : this.f4915e) {
            if (str.equalsIgnoreCase(b8Var.c())) {
                return b8Var;
            }
        }
        return null;
    }

    private b8() {
        this.f4911a = null;
        this.f4912b = "";
        this.f4913c = Collections.emptyMap();
        this.f4914d = "";
        this.f4915e = Collections.emptyList();
    }
}
