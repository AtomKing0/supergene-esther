package com.ironsource;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ot extends f<a> {

    public interface a {
        void a();
    }

    public ot(long j10) {
        super(j10);
    }

    public final void a(@Nullable a aVar) {
        a(aVar);
    }

    @Override // com.ironsource.f
    protected void b() {
        a aVar = (a) this.f12009d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void e() {
        c();
    }
}
