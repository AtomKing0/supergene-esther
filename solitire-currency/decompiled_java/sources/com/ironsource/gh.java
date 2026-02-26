package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum gh {
    NonBidder(1),
    Bidder(2),
    NotSupported(-1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f12287b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12292a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final gh a(int i10) {
            gh ghVar;
            gh[] ghVarArrValues = gh.values();
            int length = ghVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    ghVar = null;
                    break;
                }
                ghVar = ghVarArrValues[i11];
                if (ghVar.f12292a == i10) {
                    break;
                }
                i11++;
            }
            return ghVar == null ? gh.NotSupported : ghVar;
        }
    }

    gh(int i10) {
        this.f12292a = i10;
    }

    public final int b() {
        return this.f12292a;
    }

    public final boolean b(@NotNull gh instanceType) {
        kotlin.jvm.internal.t.i(instanceType, "instanceType");
        return instanceType.b() == this.f12292a;
    }
}
