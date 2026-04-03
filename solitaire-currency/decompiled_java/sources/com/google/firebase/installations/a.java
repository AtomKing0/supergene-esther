package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.installations.g;

/* JADX INFO: compiled from: AutoValue_InstallationTokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10293c;

    /* JADX INFO: compiled from: AutoValue_InstallationTokenResult.java */
    static final class b extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f10295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f10296c;

        b() {
        }

        @Override // com.google.firebase.installations.g.a
        public g a() {
            String str = "";
            if (this.f10294a == null) {
                str = " token";
            }
            if (this.f10295b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f10296c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f10294a, this.f10295b.longValue(), this.f10296c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.g.a
        public g.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f10294a = str;
            return this;
        }

        @Override // com.google.firebase.installations.g.a
        public g.a c(long j10) {
            this.f10296c = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.firebase.installations.g.a
        public g.a d(long j10) {
            this.f10295b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.firebase.installations.g
    @NonNull
    public String b() {
        return this.f10291a;
    }

    @Override // com.google.firebase.installations.g
    @NonNull
    public long c() {
        return this.f10293c;
    }

    @Override // com.google.firebase.installations.g
    @NonNull
    public long d() {
        return this.f10292b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f10291a.equals(gVar.b()) && this.f10292b == gVar.d() && this.f10293c == gVar.c();
    }

    public int hashCode() {
        int iHashCode = (this.f10291a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f10292b;
        long j11 = this.f10293c;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f10291a + ", tokenExpirationTimestamp=" + this.f10292b + ", tokenCreationTimestamp=" + this.f10293c + "}";
    }

    private a(String str, long j10, long j11) {
        this.f10291a = str;
        this.f10292b = j10;
        this.f10293c = j11;
    }
}
