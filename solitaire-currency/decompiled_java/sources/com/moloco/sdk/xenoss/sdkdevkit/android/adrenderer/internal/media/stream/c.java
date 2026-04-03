package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    @StabilityInferred(parameters = 0)
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final File f19480a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull File file) {
            super(null);
            t.i(file, "file");
            this.f19480a = file;
        }

        @NotNull
        public final File a() {
            return this.f19480a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.d(this.f19480a, ((a) obj).f19480a);
        }

        public int hashCode() {
            return this.f19480a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Complete(file=" + this.f19480a + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final f.a.AbstractC0379a f19481a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull f.a.AbstractC0379a failure) {
            super(null);
            t.i(failure, "failure");
            this.f19481a = failure;
        }

        @NotNull
        public final f.a.AbstractC0379a a() {
            return this.f19481a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && t.d(this.f19481a, ((b) obj).f19481a);
        }

        public int hashCode() {
            return this.f19481a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(failure=" + this.f19481a + ')';
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c$c, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static final class C0384c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final File f19482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final d f19483b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0384c(@NotNull File file, @NotNull d progress) {
            super(null);
            t.i(file, "file");
            t.i(progress, "progress");
            this.f19482a = file;
            this.f19483b = progress;
        }

        @NotNull
        public final File a() {
            return this.f19482a;
        }

        @NotNull
        public final d b() {
            return this.f19483b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0384c)) {
                return false;
            }
            C0384c c0384c = (C0384c) obj;
            return t.d(this.f19482a, c0384c.f19482a) && t.d(this.f19483b, c0384c.f19483b);
        }

        public int hashCode() {
            return (this.f19482a.hashCode() * 31) + this.f19483b.hashCode();
        }

        @NotNull
        public String toString() {
            return "InProgress(file=" + this.f19482a + ", progress=" + this.f19483b + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f19485b;

        public d(long j10, long j11) {
            this.f19484a = j10;
            this.f19485b = j11;
        }

        public final long a() {
            return this.f19484a;
        }

        public final long b() {
            return this.f19485b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f19484a == dVar.f19484a && this.f19485b == dVar.f19485b;
        }

        public int hashCode() {
            return (androidx.compose.animation.a.a(this.f19484a) * 31) + androidx.compose.animation.a.a(this.f19485b);
        }

        @NotNull
        public String toString() {
            return "Progress(bytesDownloaded=" + this.f19484a + ", totalBytes=" + this.f19485b + ')';
        }
    }

    public /* synthetic */ c(k kVar) {
        this();
    }

    public c() {
    }
}
