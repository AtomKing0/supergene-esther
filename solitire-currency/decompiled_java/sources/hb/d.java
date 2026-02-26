package hb;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f26518d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final JSONObject f26519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f26520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f26521c;

    /* JADX INFO: compiled from: Event.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final d a(@NotNull String event) {
            t.j(event, "event");
            JSONObject jSONObject = new JSONObject(event);
            return new d(jSONObject.optJSONObject("user_data"), jSONObject.optString("chatter_transcript"), jSONObject.optString("event_name"));
        }
    }

    public d(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2) {
        this.f26519a = jSONObject;
        this.f26520b = str;
        this.f26521c = str2;
    }

    @Nullable
    public final String a() {
        return this.f26521c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return t.d(this.f26519a, dVar.f26519a) && t.d(this.f26520b, dVar.f26520b) && t.d(this.f26521c, dVar.f26521c);
    }

    public int hashCode() {
        JSONObject jSONObject = this.f26519a;
        int iHashCode = (jSONObject != null ? jSONObject.hashCode() : 0) * 31;
        String str = this.f26520b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26521c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Event(userData=" + this.f26519a + ", chatterTranscript=" + this.f26520b + ", eventName=" + this.f26521c + ")";
    }
}
