package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class zn extends m7 {

    @NotNull
    public static final zn P;

    public static final class a {
        public final void a() {
            zn.P.a(new kb(IronSourceConstants.INIT_DEFERRED_DATA, new xg().a()));
        }
    }

    static {
        zn znVar = new zn();
        P = znVar;
        znVar.H = "outcome";
        znVar.G = 0;
        znVar.I = IronSourceConstants.PIXEL_EVENT_TYPE;
        znVar.e();
    }

    private zn() {
    }

    @Override // com.ironsource.m7
    protected int c(@Nullable kb kbVar) {
        return 1;
    }

    @Override // com.ironsource.m7
    protected void d() {
    }

    @Override // com.ironsource.m7
    @NotNull
    protected String e(int i10) {
        return "";
    }

    @Override // com.ironsource.m7
    protected boolean g(@Nullable kb kbVar) {
        return false;
    }

    @Override // com.ironsource.m7
    protected boolean h(@Nullable kb kbVar) {
        return false;
    }

    @Override // com.ironsource.m7
    protected boolean j(@Nullable kb kbVar) {
        return false;
    }

    @Override // com.ironsource.m7
    protected boolean d(@Nullable kb kbVar) {
        return true;
    }

    @Override // com.ironsource.m7
    protected void a(@Nullable ArrayList<kb> arrayList) {
    }

    @Override // com.ironsource.m7
    protected void f(@Nullable kb kbVar) {
    }
}
