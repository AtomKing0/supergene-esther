package com.moloco.sdk.xenoss.sdkdevkit.android.core.services;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static abstract class AbstractC0481a {

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$a, reason: collision with other inner class name */
        @StabilityInferred(parameters = 0)
        public static final class C0482a extends AbstractC0481a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C0482a f21673a = new C0482a();

            public C0482a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$b */
        @StabilityInferred(parameters = 0)
        public static final class b extends AbstractC0481a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f21674a;

            public b(long j10) {
                super(null);
                this.f21674a = j10;
            }

            public final long a() {
                return this.f21674a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.f21674a == ((b) obj).f21674a;
            }

            public int hashCode() {
                return androidx.compose.animation.a.a(this.f21674a);
            }

            @NotNull
            public String toString() {
                return "AppForeground(lastBgTimestamp=" + this.f21674a + ')';
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c */
        @StabilityInferred(parameters = 0)
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public final EnumC0483a f21675a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            public final f f21676b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @NotNull
            public final g f21677c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c$a, reason: collision with other inner class name */
            public enum EnumC0483a {
                NONE,
                CLOSE,
                SKIP,
                SKIP_DEC,
                MUTE,
                UNMUTE,
                CTA,
                REPLAY,
                AD_BADGE
            }

            public c(@NotNull EnumC0483a buttonType, @NotNull f position, @NotNull g size) {
                t.i(buttonType, "buttonType");
                t.i(position, "position");
                t.i(size, "size");
                this.f21675a = buttonType;
                this.f21676b = position;
                this.f21677c = size;
            }

            public static /* synthetic */ c b(c cVar, EnumC0483a enumC0483a, f fVar, g gVar, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    enumC0483a = cVar.f21675a;
                }
                if ((i10 & 2) != 0) {
                    fVar = cVar.f21676b;
                }
                if ((i10 & 4) != 0) {
                    gVar = cVar.f21677c;
                }
                return cVar.a(enumC0483a, fVar, gVar);
            }

            @NotNull
            public final c a(@NotNull EnumC0483a buttonType, @NotNull f position, @NotNull g size) {
                t.i(buttonType, "buttonType");
                t.i(position, "position");
                t.i(size, "size");
                return new c(buttonType, position, size);
            }

            @NotNull
            public final EnumC0483a c() {
                return this.f21675a;
            }

            @NotNull
            public final f d() {
                return this.f21676b;
            }

            @NotNull
            public final g e() {
                return this.f21677c;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.f21675a == cVar.f21675a && t.d(this.f21676b, cVar.f21676b) && t.d(this.f21677c, cVar.f21677c);
            }

            public int hashCode() {
                return (((this.f21675a.hashCode() * 31) + this.f21676b.hashCode()) * 31) + this.f21677c.hashCode();
            }

            @NotNull
            public String toString() {
                return "Button(buttonType=" + this.f21675a + ", position=" + this.f21676b + ", size=" + this.f21677c + ')';
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$e */
        @StabilityInferred(parameters = 0)
        public static final class e extends AbstractC0481a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final e f21692a = new e();

            public e() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$f */
        @StabilityInferred(parameters = 0)
        public static final class f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f21693a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final float f21694b;

            public f(float f10, float f11) {
                this.f21693a = f10;
                this.f21694b = f11;
            }

            public final float a() {
                return this.f21693a;
            }

            public final float b() {
                return this.f21694b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                return Float.compare(this.f21693a, fVar.f21693a) == 0 && Float.compare(this.f21694b, fVar.f21694b) == 0;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.f21693a) * 31) + Float.floatToIntBits(this.f21694b);
            }

            @NotNull
            public String toString() {
                return "Position(topLeftXDp=" + this.f21693a + ", topLeftYDp=" + this.f21694b + ')';
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$g */
        @StabilityInferred(parameters = 0)
        public static final class g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f21695a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final float f21696b;

            public g(float f10, float f11) {
                this.f21695a = f10;
                this.f21696b = f11;
            }

            public final float a() {
                return this.f21696b;
            }

            public final float b() {
                return this.f21695a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof g)) {
                    return false;
                }
                g gVar = (g) obj;
                return Float.compare(this.f21695a, gVar.f21695a) == 0 && Float.compare(this.f21696b, gVar.f21696b) == 0;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.f21695a) * 31) + Float.floatToIntBits(this.f21696b);
            }

            @NotNull
            public String toString() {
                return "Size(widthDp=" + this.f21695a + ", heightDp=" + this.f21696b + ')';
            }
        }

        public /* synthetic */ AbstractC0481a(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$d */
        @StabilityInferred(parameters = 0)
        public static final class d extends AbstractC0481a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public final f f21688a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            public final f f21689b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public final g f21690c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @NotNull
            public final List<c> f21691d;

            public /* synthetic */ d(f fVar, f fVar2, g gVar, List list, int i10, k kVar) {
                this(fVar, (i10 & 2) != 0 ? null : fVar2, (i10 & 4) != 0 ? null : gVar, (i10 & 8) != 0 ? v.l() : list);
            }

            @NotNull
            public final List<c> a() {
                return this.f21691d;
            }

            @NotNull
            public final f b() {
                return this.f21688a;
            }

            @Nullable
            public final f c() {
                return this.f21689b;
            }

            @Nullable
            public final g d() {
                return this.f21690c;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull f clickPosition, @Nullable f fVar, @Nullable g gVar, @NotNull List<c> buttonLayout) {
                super(null);
                t.i(clickPosition, "clickPosition");
                t.i(buttonLayout, "buttonLayout");
                this.f21688a = clickPosition;
                this.f21689b = fVar;
                this.f21690c = gVar;
                this.f21691d = buttonLayout;
            }
        }

        public AbstractC0481a() {
        }
    }

    @Nullable
    Object a(long j10, @NotNull AbstractC0481a abstractC0481a, @NotNull String str, @NotNull d<? super String> dVar);
}
