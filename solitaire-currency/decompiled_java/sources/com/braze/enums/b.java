package com.braze.enums;

import kotlin.jvm.internal.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f8068a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JSONObject jSONObject) {
        super(0);
        this.f8068a = jSONObject;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Short News card doesn't contain image url, parsing type as Text Announcement. JSON: " + this.f8068a;
    }
}
