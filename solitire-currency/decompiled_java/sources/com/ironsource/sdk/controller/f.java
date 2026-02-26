package com.ironsource.sdk.controller;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface f {

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final C0268a f14999c = new C0268a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f15000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final JSONObject f15001b;

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.f$a$a, reason: collision with other inner class name */
        public static final class C0268a {
            private C0268a() {
            }

            public /* synthetic */ C0268a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final a a(@NotNull String jsonStr) throws JSONException {
                kotlin.jvm.internal.t.i(jsonStr, "jsonStr");
                JSONObject jSONObject = new JSONObject(jsonStr);
                String id = jSONObject.getString(b.f15003b);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
                kotlin.jvm.internal.t.h(id, "id");
                return new a(id, jSONObjectOptJSONObject);
            }
        }

        public a(@NotNull String msgId, @Nullable JSONObject jSONObject) {
            kotlin.jvm.internal.t.i(msgId, "msgId");
            this.f15000a = msgId;
            this.f15001b = jSONObject;
        }

        public static /* synthetic */ a a(a aVar, String str, JSONObject jSONObject, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = aVar.f15000a;
            }
            if ((i10 & 2) != 0) {
                jSONObject = aVar.f15001b;
            }
            return aVar.a(str, jSONObject);
        }

        @Nullable
        public final JSONObject b() {
            return this.f15001b;
        }

        @NotNull
        public final String c() {
            return this.f15000a;
        }

        @Nullable
        public final JSONObject d() {
            return this.f15001b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.d(this.f15000a, aVar.f15000a) && kotlin.jvm.internal.t.d(this.f15001b, aVar.f15001b);
        }

        public int hashCode() {
            int iHashCode = this.f15000a.hashCode() * 31;
            JSONObject jSONObject = this.f15001b;
            return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        @NotNull
        public String toString() {
            return "CallbackToNative(msgId=" + this.f15000a + ", params=" + this.f15001b + ')';
        }

        @NotNull
        public static final a a(@NotNull String str) throws JSONException {
            return f14999c.a(str);
        }

        @NotNull
        public final a a(@NotNull String msgId, @Nullable JSONObject jSONObject) {
            kotlin.jvm.internal.t.i(msgId, "msgId");
            return new a(msgId, jSONObject);
        }

        @NotNull
        public final String a() {
            return this.f15000a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f15002a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f15003b = "msgId";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f15004c = "adId";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final String f15005d = "params";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final String f15006e = "success";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public static final String f15007f = "reason";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        public static final String f15008g = "command";

        private b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f15009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f15010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final JSONObject f15011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private String f15012d;

        public c(@NotNull String adId, @NotNull String command, @NotNull JSONObject params) {
            kotlin.jvm.internal.t.i(adId, "adId");
            kotlin.jvm.internal.t.i(command, "command");
            kotlin.jvm.internal.t.i(params, "params");
            this.f15009a = adId;
            this.f15010b = command;
            this.f15011c = params;
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.t.h(string, "randomUUID().toString()");
            this.f15012d = string;
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, JSONObject jSONObject, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = cVar.f15009a;
            }
            if ((i10 & 2) != 0) {
                str2 = cVar.f15010b;
            }
            if ((i10 & 4) != 0) {
                jSONObject = cVar.f15011c;
            }
            return cVar.a(str, str2, jSONObject);
        }

        @NotNull
        public final String b() {
            return this.f15010b;
        }

        @NotNull
        public final JSONObject c() {
            return this.f15011c;
        }

        @NotNull
        public final String d() {
            return this.f15009a;
        }

        @NotNull
        public final String e() {
            return this.f15010b;
        }

        public boolean equals(@Nullable Object obj) {
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar == null) {
                return false;
            }
            if (this == cVar) {
                return true;
            }
            return kotlin.jvm.internal.t.d(this.f15012d, cVar.f15012d) && kotlin.jvm.internal.t.d(this.f15009a, cVar.f15009a) && kotlin.jvm.internal.t.d(this.f15010b, cVar.f15010b) && kotlin.jvm.internal.t.d(this.f15011c.toString(), cVar.f15011c.toString());
        }

        @NotNull
        public final String f() {
            return this.f15012d;
        }

        @NotNull
        public final JSONObject g() {
            return this.f15011c;
        }

        @NotNull
        public final String h() {
            String string = new JSONObject().put(b.f15003b, this.f15012d).put(b.f15004c, this.f15009a).put("params", this.f15011c).toString();
            kotlin.jvm.internal.t.h(string, "JSONObject()\n          .…ms)\n          .toString()");
            return string;
        }

        public int hashCode() {
            return super.hashCode();
        }

        @NotNull
        public String toString() {
            return "MessageToController(adId=" + this.f15009a + ", command=" + this.f15010b + ", params=" + this.f15011c + ')';
        }

        @NotNull
        public final c a(@NotNull String adId, @NotNull String command, @NotNull JSONObject params) {
            kotlin.jvm.internal.t.i(adId, "adId");
            kotlin.jvm.internal.t.i(command, "command");
            kotlin.jvm.internal.t.i(params, "params");
            return new c(adId, command, params);
        }

        @NotNull
        public final String a() {
            return this.f15009a;
        }

        public final void a(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<set-?>");
            this.f15012d = str;
        }
    }
}
