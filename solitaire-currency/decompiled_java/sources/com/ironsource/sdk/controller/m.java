package com.ironsource.sdk.controller;

import com.ironsource.qf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface m {

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f15043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f15044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final String f15045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final String f15046d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String funToCall) {
            this(funToCall, null, null, null, 14, null);
            kotlin.jvm.internal.t.i(funToCall, "funToCall");
        }

        @Override // com.ironsource.sdk.controller.m
        @NotNull
        public String a() {
            StringBuilder sb = new StringBuilder();
            sb.append("SSA_CORE.SDKController.runFunction('" + this.f15043a);
            String str = this.f15044b;
            if (!(str == null || str.length() == 0)) {
                sb.append("?parameters=" + this.f15044b);
            }
            String str2 = this.f15045c;
            if (!(str2 == null || str2.length() == 0)) {
                sb.append("','" + this.f15045c);
            }
            String str3 = this.f15046d;
            if (!(str3 == null || str3.length() == 0)) {
                sb.append("','" + this.f15046d);
            }
            sb.append("');");
            String string = sb.toString();
            kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String funToCall, @Nullable String str) {
            this(funToCall, str, null, null, 12, null);
            kotlin.jvm.internal.t.i(funToCall, "funToCall");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String funToCall, @Nullable String str, @Nullable String str2) {
            this(funToCall, str, str2, null, 8, null);
            kotlin.jvm.internal.t.i(funToCall, "funToCall");
        }

        public a(@NotNull String funToCall, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            kotlin.jvm.internal.t.i(funToCall, "funToCall");
            this.f15043a = funToCall;
            this.f15044b = str;
            this.f15045c = str2;
            this.f15046d = str3;
        }

        public /* synthetic */ a(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.k kVar) {
            this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private String f15048b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@NotNull m jsMethod, int i10) {
            this(jsMethod.a(), i10);
            kotlin.jvm.internal.t.i(jsMethod, "jsMethod");
        }

        @Override // com.ironsource.sdk.controller.m
        @NotNull
        public String a() {
            String str = "try{" + this.f15048b + "}catch(e){" + ((this.f15047a != qf.d.MODE_0.a() && (this.f15047a < qf.d.MODE_1.a() || this.f15047a > qf.d.MODE_3.a())) ? "empty" : "console.log(\"JS exception: \" + JSON.stringify(e));") + "}";
            kotlin.jvm.internal.t.h(str, "StringBuilder()\n        …}\")\n          .toString()");
            return str;
        }

        public b(@NotNull String script, int i10) {
            kotlin.jvm.internal.t.i(script, "script");
            this.f15048b = script;
            this.f15047a = i10;
        }
    }

    @NotNull
    String a();
}
