package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import z1.h;
import z1.m;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class CctBackendFactory implements z1.d {
    @Override // z1.d
    public m create(h hVar) {
        return new d(hVar.b(), hVar.e(), hVar.d());
    }
}
