package com.unity3d.scar.adapter.common;

/* JADX INFO: compiled from: GMAAdsError.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends m {
    public b(c cVar, Object... objArr) {
        super(cVar, null, objArr);
    }

    public static b a(a7.c cVar) {
        String str = String.format("Cannot show ad that is not loaded for placement %s", cVar.c());
        return new b(c.AD_NOT_LOADED_ERROR, str, cVar.c(), cVar.d(), str);
    }

    public static b b(String str) {
        return new b(c.SCAR_UNSUPPORTED, str, new Object[0]);
    }

    public static b c(a7.c cVar, String str) {
        return new b(c.INTERNAL_LOAD_ERROR, str, cVar.c(), cVar.d(), str);
    }

    public static b d(a7.c cVar, String str) {
        return new b(c.INTERNAL_SHOW_ERROR, str, cVar.c(), cVar.d(), str);
    }

    public static b e(String str) {
        return new b(c.INTERNAL_SIGNALS_ERROR, str, str);
    }

    public static b f(String str, String str2, String str3) {
        return new b(c.NO_AD_ERROR, str3, str, str2, str3);
    }

    public static b g(a7.c cVar) {
        String str = String.format("Missing queryInfoMetadata for ad %s", cVar.c());
        return new b(c.QUERY_NOT_FOUND_ERROR, str, cVar.c(), cVar.d(), str);
    }

    @Override // com.unity3d.scar.adapter.common.m
    public String getDomain() {
        return "GMA";
    }

    public b(c cVar, String str, Object... objArr) {
        super(cVar, str, objArr);
    }
}
