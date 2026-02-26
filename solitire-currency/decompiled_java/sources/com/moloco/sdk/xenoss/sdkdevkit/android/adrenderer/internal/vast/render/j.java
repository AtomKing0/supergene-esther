package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class j {

    @StabilityInferred(parameters = 0)
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21319a;

        public a(int i10) {
            super(null);
            this.f21319a = i10;
        }

        public final int a() {
            return this.f21319a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f21319a == ((a) obj).f21319a;
        }

        public int hashCode() {
            return this.f21319a;
        }

        @NotNull
        public String toString() {
            return "Html(webViewId=" + this.f21319a + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f21320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21322c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String imageUrl, int i10, int i11) {
            super(null);
            t.i(imageUrl, "imageUrl");
            this.f21320a = imageUrl;
            this.f21321b = i10;
            this.f21322c = i11;
        }

        public final int a() {
            return this.f21322c;
        }

        @NotNull
        public final String b() {
            return this.f21320a;
        }

        public final int c() {
            return this.f21321b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.d(this.f21320a, bVar.f21320a) && this.f21321b == bVar.f21321b && this.f21322c == bVar.f21322c;
        }

        public int hashCode() {
            return (((this.f21320a.hashCode() * 31) + this.f21321b) * 31) + this.f21322c;
        }

        @NotNull
        public String toString() {
            return "Image(imageUrl=" + this.f21320a + ", w=" + this.f21321b + ", h=" + this.f21322c + ')';
        }
    }

    public /* synthetic */ j(kotlin.jvm.internal.k kVar) {
        this();
    }

    public j() {
    }
}
