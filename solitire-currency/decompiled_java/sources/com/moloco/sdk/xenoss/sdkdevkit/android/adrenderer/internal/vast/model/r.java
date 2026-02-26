package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final t f20664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final e f20665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Long f20666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<s> f20667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<w> f20668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final a f20669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final List<n> f20670g;

    public r(@Nullable t tVar, @Nullable e eVar, @Nullable Long l10, @NotNull List<s> mediaFiles, @NotNull List<w> trackingList, @Nullable a aVar, @NotNull List<n> icons) {
        kotlin.jvm.internal.t.i(mediaFiles, "mediaFiles");
        kotlin.jvm.internal.t.i(trackingList, "trackingList");
        kotlin.jvm.internal.t.i(icons, "icons");
        this.f20664a = tVar;
        this.f20665b = eVar;
        this.f20666c = l10;
        this.f20667d = mediaFiles;
        this.f20668e = trackingList;
        this.f20669f = aVar;
        this.f20670g = icons;
    }

    @Nullable
    public final Long a() {
        return this.f20666c;
    }

    @NotNull
    public final List<n> b() {
        return this.f20670g;
    }

    @NotNull
    public final List<s> c() {
        return this.f20667d;
    }

    @Nullable
    public final t d() {
        return this.f20664a;
    }

    @NotNull
    public final List<w> e() {
        return this.f20668e;
    }

    @Nullable
    public final a f() {
        return this.f20669f;
    }
}
