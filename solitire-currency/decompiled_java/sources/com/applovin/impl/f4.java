package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.j2;
import com.applovin.impl.l0;

/* JADX INFO: loaded from: classes2.dex */
public class f4 extends j2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final l0.a f5184n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f5185o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f5186p;

    public f4(l0.a aVar, boolean z10, Context context) {
        super(j2.c.RIGHT_DETAIL);
        this.f5184n = aVar;
        this.f5185o = context;
        this.f5439c = new SpannedString(aVar.a());
        this.f5186p = z10;
    }

    @Override // com.applovin.impl.j2
    public SpannedString f() {
        return new SpannedString(this.f5184n.a(this.f5185o));
    }

    @Override // com.applovin.impl.j2
    public boolean o() {
        return false;
    }

    @Override // com.applovin.impl.j2
    public boolean p() {
        Boolean boolB = this.f5184n.b(this.f5185o);
        if (boolB != null) {
            return boolB.equals(Boolean.valueOf(this.f5186p));
        }
        return false;
    }
}
