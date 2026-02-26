package com.moloco.sdk.acm.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@TypeConverters({a.class})
@Entity(tableName = "events")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @PrimaryKey(autoGenerate = true)
    public final long f17327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f17328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final c f17330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Long f17331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<String> f17332f;

    public b(long j10, @NotNull String name, long j11, @NotNull c eventType, @Nullable Long l10, @NotNull List<String> tags) {
        t.i(name, "name");
        t.i(eventType, "eventType");
        t.i(tags, "tags");
        this.f17327a = j10;
        this.f17328b = name;
        this.f17329c = j11;
        this.f17330d = eventType;
        this.f17331e = l10;
        this.f17332f = tags;
    }

    @Nullable
    public final Long a() {
        return this.f17331e;
    }

    @NotNull
    public final c b() {
        return this.f17330d;
    }

    public final long c() {
        return this.f17327a;
    }

    @NotNull
    public final String d() {
        return this.f17328b;
    }

    @NotNull
    public final List<String> e() {
        return this.f17332f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f17327a == bVar.f17327a && t.d(this.f17328b, bVar.f17328b) && this.f17329c == bVar.f17329c && this.f17330d == bVar.f17330d && t.d(this.f17331e, bVar.f17331e) && t.d(this.f17332f, bVar.f17332f);
    }

    public final long f() {
        return this.f17329c;
    }

    public int hashCode() {
        int iA = ((((((androidx.compose.animation.a.a(this.f17327a) * 31) + this.f17328b.hashCode()) * 31) + androidx.compose.animation.a.a(this.f17329c)) * 31) + this.f17330d.hashCode()) * 31;
        Long l10 = this.f17331e;
        return ((iA + (l10 == null ? 0 : l10.hashCode())) * 31) + this.f17332f.hashCode();
    }

    @NotNull
    public String toString() {
        return "EventEntity(id=" + this.f17327a + ", name=" + this.f17328b + ", timestamp=" + this.f17329c + ", eventType=" + this.f17330d + ", data=" + this.f17331e + ", tags=" + this.f17332f + ')';
    }

    public /* synthetic */ b(long j10, String str, long j11, c cVar, Long l10, List list, int i10, k kVar) {
        this((i10 & 1) != 0 ? 0L : j10, str, j11, cVar, (i10 & 16) != 0 ? null : l10, (i10 & 32) != 0 ? v.l() : list);
    }
}
