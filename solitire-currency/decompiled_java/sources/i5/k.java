package i5;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* JADX INFO: compiled from: FirebaseOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f26615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f26616g;

    private k(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f26611b = str;
        this.f26610a = str2;
        this.f26612c = str3;
        this.f26613d = str4;
        this.f26614e = str5;
        this.f26615f = str6;
        this.f26616g = str7;
    }

    @Nullable
    public static k a(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new k(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    @NonNull
    public String b() {
        return this.f26610a;
    }

    @NonNull
    public String c() {
        return this.f26611b;
    }

    @Nullable
    public String d() {
        return this.f26614e;
    }

    @Nullable
    public String e() {
        return this.f26616g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Objects.equal(this.f26611b, kVar.f26611b) && Objects.equal(this.f26610a, kVar.f26610a) && Objects.equal(this.f26612c, kVar.f26612c) && Objects.equal(this.f26613d, kVar.f26613d) && Objects.equal(this.f26614e, kVar.f26614e) && Objects.equal(this.f26615f, kVar.f26615f) && Objects.equal(this.f26616g, kVar.f26616g);
    }

    public int hashCode() {
        return Objects.hashCode(this.f26611b, this.f26610a, this.f26612c, this.f26613d, this.f26614e, this.f26615f, this.f26616g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f26611b).add("apiKey", this.f26610a).add("databaseUrl", this.f26612c).add("gcmSenderId", this.f26614e).add("storageBucket", this.f26615f).add("projectId", this.f26616g).toString();
    }
}
