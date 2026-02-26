package com.king.amp.sa;

import com.king.amp.sa.b0;
import java.util.Map;

/* JADX INFO: compiled from: AbmMixedChapterContent.java */
/* JADX INFO: loaded from: classes4.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b0.b f16734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f16735d;

    public c0(String str, String str2, Map<String, String> map, boolean z10) {
        this.f16732a = str;
        this.f16733b = str2;
        this.f16735d = map;
        if (z10) {
            this.f16734c = b0.b.GIF;
        } else {
            this.f16734c = b0.b.IMAGE;
        }
    }

    public Map<String, String> a() {
        return this.f16735d;
    }

    public String b() {
        return this.f16733b;
    }

    public String c() {
        return this.f16732a;
    }

    public b0.b d() {
        return this.f16734c;
    }

    public c0(String str, String str2, Map<String, String> map) {
        this.f16732a = str;
        this.f16733b = str2;
        this.f16735d = map;
        this.f16734c = b0.b.VIDEO;
    }
}
