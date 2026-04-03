package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum ld {
    SendEvent(0),
    NativeController(1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f13016b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13020a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final ld a(int i10) {
            ld ldVar;
            ld[] ldVarArrValues = ld.values();
            int length = ldVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    ldVar = null;
                    break;
                }
                ldVar = ldVarArrValues[i11];
                if (ldVar.b() == i10) {
                    break;
                }
                i11++;
            }
            return ldVar == null ? ld.SendEvent : ldVar;
        }
    }

    ld(int i10) {
        this.f13020a = i10;
    }

    public final int b() {
        return this.f13020a;
    }
}
