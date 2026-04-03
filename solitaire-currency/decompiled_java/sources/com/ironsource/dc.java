package com.ironsource;

import androidx.lifecycle.ProcessLifecycleOwner;

/* JADX INFO: loaded from: classes4.dex */
public final class dc implements je {
    @Override // com.ironsource.je
    public boolean a() {
        try {
            ProcessLifecycleOwner.Companion.get();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
